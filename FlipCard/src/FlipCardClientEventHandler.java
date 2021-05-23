//FlipCardClientEventHandler 재생성
import kr.ac.konkuk.ccslab.cm.event.CMDummyEvent;
import kr.ac.konkuk.ccslab.cm.event.CMEvent;
import kr.ac.konkuk.ccslab.cm.event.CMSessionEvent;
import kr.ac.konkuk.ccslab.cm.event.handler.CMAppEventHandler;
import kr.ac.konkuk.ccslab.cm.info.CMInfo;

public class FlipCardClientEventHandler implements CMAppEventHandler {

   private FlipCardClient m_client;
   Maingame game = new Maingame();
   
   public FlipCardClientEventHandler (FlipCardClient client)
   {
      m_client = client;
   }

   @Override
   public void processEvent(CMEvent cme) {
      // TODO Auto-generated method stub
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
         switch(se.getID())
         {
         case CMSessionEvent.LOGIN_ACK:
            System.out.println("로그인 인증 받았음");
            //Login 클래스에서 다음 "로그인 완료되었습니다." 메세지 출력된다. 
            //비동기식으로 구현했음      
            break;
         }
         
   }
   
   private void processDummyEvent(CMEvent cme) {
      
        CMDummyEvent cde = (CMDummyEvent) cme; // 서버에게서 받는
        
         String message = cde.getDummyInfo();
         String[] splitMsg = message.split(";");
         String choice = splitMsg[0];
         User MyUser = new User();

         
         switch (choice) {
         
         case "LOGIN":
            String UserID = splitMsg[1];
            String Color = splitMsg[2];
           
            User.ChangeCurrentUser(UserID, Color);
            game.resettext();
            // 메인게임 불러오기-연결만
	            if(UserID.equals(User.myname)) {
	            	System.out.println("사용자 정보 가져오기 완료");
	               MyUser.GetMyuserColor(UserID);
	               m_client.openflag = true;
	               game.setVisible(true);
	            }
            break;
            
         case "START":
            game.init();
            game.startflag = true;
            // 카드 초기화
            // 시간 10초로 보여짐
            break;
            
         case "FLIP":
            int Color1 = 0;
            switch (splitMsg[2]) {
            case "BROWN":
               Color1 = 1;
               break;
            case "BLUE":
               Color1 = 2;
               break;
            case "PINK":
               Color1 = 3;
               break;
            case "GREEN":
               Color1 = 4;
               break;
            }
            game.ChangeColor(Color1, Integer.parseInt(splitMsg[1]));
            // 카드 변경
            
         case "STOP":
            game.startflag = false;// 클라측 이벤트 핸들러 중단
            game.init();// 카드 초기화
            

         case "WIN":
            // 채팅창에 표시
         case "TIMER":
 			game.Timershow.setText(splitMsg[1]);

         }


      
      }

}





















/*
	


		switch (choice) {
		case "LOGIN":
			String UserID = splitMsg[1];
			String Color = splitMsg[2];
	         MyUser.ChangeCurrentUser(UserID, Color);

	         // 메인게임 불러오기-연결만
	         if(UserID==CUser.getName()) {
	            MyUser.GetMyuserColor(UserID);
	                game.setVisible(true);
	         }

		case "START":
			game.init();// 카드 초기화
			game.startflag = true;

		case "FLIP":
			int Color1 = 0;
			switch (splitMsg[2]) {
			case "BROWN":
				Color1 = 1;
				break;
			case "BLUE":
				Color1 = 2;
				break;
			case "PINK":
				Color1 = 3;
				break;
			case "GREEN":
				Color1 = 4;
				break;
			}
			game.ChangeColor(Color1, Integer.parseInt(splitMsg[1]));
			// 카드 변경
		case "STOP":
			game.startflag = false; // 클라측 이벤트 핸들러 중단
			game.init();// 카드 초기화

			
		case "WIN":
			// 채팅창에 표시
		case "TIMER":
			game.Timershow.setText(splitMsg[1]);
		}

	}
/*
	private void sendprocessDummyEvent(int CardNum) {
		// Client 측 전송 Flip;CARDNUM;COLOR
		CMDummyEvent due = new CMDummyEvent();// 서버에게 주는
		User MyUser = new User();
		if (game.startflag) {
			due.setDummyInfo(MakeFlip(CardNum, MyUser.GetMyColor()));
			m_clientStub.send(due, "SERVER");
		}
	}


	   private void processSessionEvent(CMEvent cme) {
	         
	         CMSessionEvent se = (CMSessionEvent) cme;
	         switch(se.getID())
	         {
	         case CMSessionEvent.LOGIN_ACK:
	            System.out.println("로그인 인증 받았음");
	            //Login 클래스에서 다음 "로그인 완료되었습니다." 메세지 출력된다. 
	            //비동기식으로 구현했음      
	            break;
	         }
	         
	   }


	private String MakeFlip(int CardNum, int indexofColor) {
		String Color = null;
		switch (indexofColor) {
		case 1:
			Color = "BROWN";
			break;
		case 2:
			Color = "BLUE";
			break;
		case 3:
			Color = "PINK";
			break;
		case 4:
			Color = "GREEN";
			break;
		}
		String result = "FLIP" + ";" + Integer.toString(CardNum) + ";" + Color;
		return result;
	}

}
*/