//FlipCardServerEventHandler
import java.util.*;
import kr.ac.konkuk.ccslab.cm.event.CMDummyEvent;
import kr.ac.konkuk.ccslab.cm.event.CMEvent;
import kr.ac.konkuk.ccslab.cm.event.CMSessionEvent;
import kr.ac.konkuk.ccslab.cm.event.handler.CMAppEventHandler;
import kr.ac.konkuk.ccslab.cm.info.CMInfo;
import kr.ac.konkuk.ccslab.cm.stub.CMServerStub;

public class FlipCardServerEventHandler implements CMAppEventHandler {
   private CMServerStub m_serverStub;
   private CardTimer timer;
   int restart = 0;

   String[] color = { "BROWN", "BLUE", "PINK", "GREEN" }; // 사용자 카드 색
   HashMap<String, String> h = new HashMap<String, String>(); // key = 색깔, value = UserID -- hashmap 구현
   String card[] = new String[16]; // 카드 번호 별 카드 색
   {
      for (int i = 0; i < 16; i++) {
         card[i] = new String("");// 버튼 초기화
      }

   }

   public FlipCardServerEventHandler(CMServerStub serverStub) {
      m_serverStub = serverStub;
      timer = new CardTimer(m_serverStub, this);
   }

   @Override
   public void processEvent(CMEvent cme) {
      switch (cme.getType()) {
      case CMInfo.CM_SESSION_EVENT: // 로그인, 세션, 그룹 조인 이벤트
         processSessionEvent(cme);
         break;
      case CMInfo.CM_DUMMY_EVENT: // 메세지 프로토콜 이벤트
         processDummyEvent(cme);
         break;
      default:
         return;
      }
   }

   private void processSessionEvent(CMEvent cme) {

      CMSessionEvent se = (CMSessionEvent) cme;
      CMDummyEvent due = new CMDummyEvent();
      String msg;

      switch (se.getID()) {
      case CMSessionEvent.LOGIN: // 클라이언트가 로그인 요청 이벤트를 보낸 경우

          if (m_serverStub.getLoginUsers().getMemberNum() > 4)// 4명 초과이면 로그인 실패
          {
             // 사용자 정원 초과 메세지
             System.out.println("정원 초과로 인한 로그인 거부 : " + se.getUserName());
             m_serverStub.replyEvent(se, 0);
             break;
          } else {
             System.out.println("로그인 허가"); // 로그인 허가
             m_serverStub.replyEvent(se, 1);

             String loginUser = se.getUserName();
             boolean is_action = true;
             for (int i = 0; i < 4; i++) {
                Set<String> keys = h.keySet();
                if (keys.contains(color[i])) { // i번째 color 값이 이미 해시맵에 있다면

                   msg = "LOGIN;" + h.get(color[i]) + ";" + color[i]; // 이 색을 가진 사용자에 대한 정보를 cast
                   due.setDummyInfo(msg);
                   m_serverStub.cast(due, null, null);
                } else { // i번째 color 값이 해시맵에 없다면-신규사용자 정보
                   if (is_action) {
                      h.put(color[i], loginUser); // 해시맵에 새로운 사용자 정보 추가
                      msg = "LOGIN;" + h.get(color[i]) + ";" + color[i];// 새로운 사용자 정보 cast
                      due.setDummyInfo(msg);
                      m_serverStub.cast(due, null, null);
                      is_action = false;
                   }
                }
             }
         
            if (m_serverStub.getLoginUsers().getMemberNum() == 4) {// 지금 로그인 요청을 한 사용자를 포함하여 4명의 사용자가 모두 로그인했다면 타이머
               if(timer.isAlive()) {
                  timer.interrupt();
               }
                timer = new CardTimer(m_serverStub, this);
                timer.start();
            }
         }

         break;
      case CMSessionEvent.LOGOUT: // 클라이언트가 로그아웃 요청 이벤트를 보낸 경우
         // HashMap에서 로그아웃 요청 사용자 정보 및 카드색 제거
         String logoutUser = se.getUserName();
         Set<String> keys = h.keySet();
         Iterator<String> it = keys.iterator();
         while (it.hasNext()) {
            String key = it.next();
            String value = h.get(key);
            if (value.equals(logoutUser)) {
               h.remove(key);
               msg = "LOGIN;" + "" + ";" + key;
               // 새로운 사용자 정보 cast
               System.out.println(msg);
               due.setDummyInfo(msg);
               m_serverStub.cast(due, null, null);
               break;
            }
         }
      }
   }

   private void processDummyEvent(CMEvent cme) {
      // 클라이언트로부터 받은 더미 이벤트 처리
      CMDummyEvent du = (CMDummyEvent) cme; // 받는
      CMDummyEvent due = new CMDummyEvent(); // 주는

      // 게임 도중 클라이언트가 카드를 클릭했을 경우
      String recv = du.getDummyInfo();
      String s[] = recv.split(";");
      int i;
      
      switch (s[0]) {
      case "FLIP":
         i = Integer.parseInt(s[1]);
          card[i] = s[2];;
          // 카드 클릭 정보를 전체 클라이언트에 전달
          due.setDummyInfo(recv);
          m_serverStub.cast(due, null, null);
          break;
      case "RESTART":
         restart++;
         System.out.println("current restart : "+restart);
         
         if(restart == 4)
         {
            if(timer.isAlive()) {
                timer.interrupt();
             }
              timer = new CardTimer(m_serverStub, this);
              timer.start();
              restart=0;
         }
         break;
      }
 
   }

   class CardTimer extends Thread {
      private CMServerStub m_serverStub;
      private FlipCardServerEventHandler m_eventhandler;
      CMDummyEvent due = new CMDummyEvent();
      int i;

      public CardTimer(CMServerStub serverStub, FlipCardServerEventHandler e) {
         m_serverStub = serverStub;
         m_eventhandler = e;

      }

      @Override
      public void run() {

         due.setDummyInfo("READY");// 대기
         m_serverStub.cast(due, null, null); // 대기하겠다는 더미 이벤트를 클라이언트 전체에 전송

         //카드 초기화
         for (int i = 0; i < 16; i++) {
             card[i] = "";
         }
         // 대기 상태
         try {
            Thread.sleep(5000);
         } catch (InterruptedException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
         }

         due.setDummyInfo("START");// 실행
         m_serverStub.cast(due, null, null); // 시작하겠다는 더미 이벤트를 클라이언트 전체에 전송

         try {
            Thread.sleep(500);
         } catch (InterruptedException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
         }

         // 테스트 용도
         int t = 10;
         String msg = Integer.toString(t);

         while (t > 0) // 10초 타이머 시작
         {
            t--;
            //System.out.println("작업스레드 이름 : " + Thread.currentThread().getName() + System.currentTimeMillis());
            // 시간을 알리는 더미이벤트
            msg = Integer.toString(t);
            due.setDummyInfo("TIMER;" + msg);
            m_serverStub.cast(due, null, null);

            System.out.println(msg);

            try {
               Thread.sleep(1000);
            } catch (InterruptedException e) {
               return;
            }
         }
      
         due.setDummyInfo("STOP");
         m_serverStub.cast(due, null, null); // 클라이언트 게임 종료 메세지 전달
         
         // 결과 계산 코드 추가 예정
         /* 수정 */
         int countcolor[] = { 0, 0, 0, 0 }; // 색깔별 카드 개수 저장할 배열
         int max = 0;
         int winner = 0; // 가장 많은 색
         int i = 0;
         /* 색별 개수 계산 */
         for (i = 0; i < m_eventhandler.card.length; i++) {
            switch (m_eventhandler.card[i]) {

            case "BROWN":
               countcolor[0]++;
               break;
            case "BLUE":
               countcolor[1]++;
               break;
            case "PINK":
               countcolor[2]++;
               break;
            case "GREEN":
               countcolor[3]++;
               break;
            default:
               break;
            }
            
         }
         
         /* 가장 많은 색 계산 */
         for (i = 0; i < countcolor.length; i++) {
            if (countcolor[i] > max) {
               max = countcolor[i];
               winner = i + 1;
            } else if (countcolor[i] == max)
               winner = winner * 10 + i + 1;
         }
         
         /* 우승자 더미 이벤트 보내기 */
         while (winner > 0) {
            if (winner > 1000) {
               i = winner % 10;
               winner = winner / 10;
            } else if (winner > 100) {
               i = winner % 10;
               winner = winner / 10;
            } else if (winner > 10) {
               i = winner % 10;
               winner = winner / 10;
            } else if (winner < 10) {
               i = winner;
               winner = -1;
            }
            
            switch (i) {
            case 1:
               due.setDummyInfo("WIN;" + h.get("BROWN") + ";BROWN");
               break;
            case 2:
               due.setDummyInfo("WIN;" + h.get("BLUE") + ";BLUE");
               break;
            case 3:
               due.setDummyInfo("WIN;" + h.get("PINK") + ";PINK");
               break;
            case 4:
               due.setDummyInfo("WIN;" + h.get("GREEN") + ";GREEN");
               break;
            }
            m_serverStub.cast(due, null, null);
             // 우승자 메세지 전달
         }
         
         return;
      }

   }

}