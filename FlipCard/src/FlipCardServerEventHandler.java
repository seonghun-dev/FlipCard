//FlipCardServerEventHanlder
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
   
   String [] color = {"BROWN", "BLUE", "PINK", "GREEN"}; // 사용자 카드 색
   HashMap<String, String> h = new HashMap<String, String>(); //key = 색깔, value = UserID -- hashmap 구현
   String card[] = new String[16]; // 카드 번호 별 카드 색
   
   public FlipCardServerEventHandler(CMServerStub serverStub)
   {
      m_serverStub = serverStub;
   }
   
   @Override
   public void processEvent(CMEvent cme) {
      switch(cme.getType())
      {
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
            
      switch(se.getID())
      {
      case CMSessionEvent.LOGIN: //클라이언트가 로그인 요청 이벤트를 보낸 경우 
         
         //사용자 인증 진행하고, (DBManager 안쓸거임)
         if(m_serverStub.getLoginUsers().getMemberNum()>4)//4명 초과이면 로그인 실패
         {
            //사용자 정원 초과 메세지
            System.out.println("정원 초과로 인한 로그인 거부 : "+se.getUserName());
            m_serverStub.replyEvent(se, 0);
         }
         else
         {
            System.out.println("연동이 됩니다잉");
            //로그인 허가
            m_serverStub.replyEvent(se, 1);   
            
            //카드색 배열과 해시맵 키 비교하여 없는 색과 사용자 매칭
            String loginUser = se.getUserName();
            String loginColor = "";
            int valid = 0;
            
            if(h.isEmpty()) // 첫번째 사용자일 경우 color 배열 중 첫번째 색 배정
               loginColor = color[0];
            else // 첫번째 사용자가 아닌 경우
            {
               Set<String> keys = h.keySet();
               Iterator<String> it = keys.iterator();
               
               for(int i=0; i<4; i++)
               {
                  while(it.hasNext())
                  {
                     String key = it.next();
                     if(color[i] == key)
                     {
                        String msg = "LOGIN;"+h.get(key)+";"+key;
                        due.setDummyInfo(msg);
                        m_serverStub.cast(due,null,null); //이전 사용자 정보 알리는 더미이벤트 발생
                        valid = 1;
                        break;
                     }
                  }
                  if(valid == 0) //valid 값이 바뀌지 않았으면, 0이면
                  {
                     loginColor = color[i];
                     break;
                  }
               }
            }
            h.put(loginColor, loginUser);   
            
            //새로운 사용자가 로그인했다는 것을 다른 사용자들에게 알리는 더미이벤트 발생
            String msg = "LOGIN;"+se.getUserName()+";"+loginColor;
            due.setDummyInfo(msg); 
            m_serverStub.cast(due,null,null); 
            
            //4번째 사용자인 경우를 확인하고, 타이머 한 2~3초 딜레이 후 게임 시작하게 끔
            //타이머 시작하겠다는 채팅을 클라이언트 전체에 전달
            //타이머 호출
            if(m_serverStub.getLoginUsers().getMemberNum()==4) 
            //지금 로그인 요청을 한 사용자를 포함하여 4명의 사용자가 모두 로그인했다면 타이머 실행
            {
               due.setDummyInfo("START");
               m_serverStub.cast(due,null,null); //시작하겠다는 더미 이벤트를 클라이언트 전체에 전송
               timer.run(); //타이머 스레드 실행
            }
            
            
         }
         break;
      case CMSessionEvent.LOGOUT: //클라이언트가 로그아웃 요청 이벤트를 보낸 경우
         
         //HashMap에서 로그아웃 요청 사용자 정보 및 카드색 제거
         String logoutUser = se.getUserName();
         Set<String> keys = h.keySet();
         Iterator<String> it = keys.iterator();
         while(it.hasNext()) 
         {
            String key = it.next();
            String value = h.get(key);
            if(value == logoutUser)
            {
               h.remove(key);
            }
         }
         break;
      default:
         return;
      }
      
   }
   
   private void processDummyEvent(CMEvent cme) {
      //클라이언트로부터 받은 더미 이벤트 처리
      CMDummyEvent du = (CMDummyEvent) cme; //받는
      CMDummyEvent due = new CMDummyEvent(); //주는
      
      // 게임 도중 클라이언트가 카드를 클릭했을 경우
      String recv = du.getDummyInfo();
      String s[] = recv.split(";");
      int i = Integer.parseInt(s[1]);
      card [i] = s[2];
      
      //카드 클릭 정보를 전체 클라이언트에 전달
      due.setDummyInfo(recv);
      m_serverStub.cast(due,null,null); 
   
   }

}  



//FlipCardServer 에 써줘야함
class CardTimer implements Runnable{
   private CMServerStub m_serverStub;
   CMDummyEvent due = new CMDummyEvent();
   int i;
   
   public CardTimer(CMServerStub serverStub)
   {
      m_serverStub = serverStub;
   }

   @Override
   public void run() {
	   //테스트 용도
	   due.setDummyInfo("TIMER;");
	   m_serverStub.cast(due,null,null); 
	   
      int t = 0;
      String msg = Integer.toString(t);
      
      /*
      while(m_serverStub.getLoginUsers().getMemberNum()==4)
      {
         due.setDummyInfo("START");
         m_serverStub.cast(due,null,null); //클라이언트 게임 시작 메세지 전달
      }
      */
      
      while(t<11) // 10초 타이머 시작
      {
         t++;
         
         //시간을 알리는 더미이벤트 
         msg = Integer.toString(t);
         due.setDummyInfo("TIMER;"+msg);
         m_serverStub.cast(due,null,null);  
         
         try{
            Thread.sleep(1000);
         }
         catch(InterruptedException e) {
            return;
         }
      }   
      
      due.setDummyInfo("STOP");
      m_serverStub.cast(due,null,null); //클라이언트 게임 종료 메세지 전달
      
      //10초가 끝난 후 우승자 알려주는 더미이벤트?
      for(i=0; i<16; i++) //카드 결과 계산
      {
         //switch-case문
         
      }
      
      return;
   }
   
}