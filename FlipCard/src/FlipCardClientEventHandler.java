
//FlipCardClientEventHandler 재생성
import javax.swing.ImageIcon;
import javax.swing.JDialog;

import kr.ac.konkuk.ccslab.cm.event.CMDummyEvent;
import kr.ac.konkuk.ccslab.cm.event.CMEvent;
import kr.ac.konkuk.ccslab.cm.event.CMSessionEvent;
import kr.ac.konkuk.ccslab.cm.event.handler.CMAppEventHandler;
import kr.ac.konkuk.ccslab.cm.info.CMInfo;

public class FlipCardClientEventHandler implements CMAppEventHandler {

	private FlipCardClient m_client;
	Maingame game;
	Nextgame isregame = new Nextgame();

	public FlipCardClientEventHandler(FlipCardClient client) {
		m_client = client;
		game = new Maingame(m_client);
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
		switch (se.getID()) {
		case CMSessionEvent.LOGIN_ACK:
			System.out.println("로그인 인증 받았음");
			m_client.openflag = true;
			game.setLocationRelativeTo(null);
			game.setVisible(true); // 메인게임 화면 시작
			// Login 클래스에서 다음 "로그인 완료되었습니다." 메세지 출력된다.
			// 비동기식으로 구현했음
			break;
		case CMSessionEvent.SESSION_TALK:
			// 클라이언트 간 채팅 구현

			// 채팅 이벤트 받으면 메인 게임 내 채팅 보여지는 부분에 표시하도록
			// "사용자ID : 메세지"

			break;
		default:
			return;
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

			MyUser.ChangeCurrentUser(UserID, Color);
			game.resettext();

			// 메인게임 불러오기-연결만
			if (UserID.equals(User.myname)) {
				MyUser.GetMyuserColor(UserID);
			}
			break;
		case "START":
			game.printMessage("[공지] 게임이 곧 시작합니다. \n");
			game.init(); // 카드 초기화
			game.setstartflag(true);
			break;
		case "FLIP":
			game.printMessage("메세지 받음");
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
			ChangeColor(Color1, Integer.parseInt(splitMsg[1]));
			// 카드 변경
		case "STOP":
			game.setstartflag(false);
			game.init();
			// 시간 0초로 보여짐
			// 카드 초기화
			// 클라측 이벤트 핸들러 중단
		case "TIMER":
			if (game.getstartflag()) {
				game.Timershow.setText(splitMsg[1]);
			}
			if (Integer.parseInt(splitMsg[1]) == 0) {

				isregame.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				isregame.ShowWinner(2);
				isregame.setLocationRelativeTo(null);
				isregame.setVisible(true);
				while (!isregame.regame) {
				}
				isregame.setVisible(false);
				game.resettext();
			}

		case "WIN":
			// 채팅창에 표시

		}

	}
	
	// 서버에서 받아온 값 변화
	public void ChangeColor(int Cardnum, int Color) {
		switch (Color) {
		case 1:
			game.CardArray[Cardnum].setIcon(new ImageIcon("../FlipCard/Img/Cardusr1.png"));
			break;
		case 2:
			game.CardArray[Cardnum].setIcon(new ImageIcon("../FlipCard/Img/Cardusr2.png"));
			break;
		case 3:
			game.CardArray[Cardnum].setIcon(new ImageIcon("../FlipCard/Img/Cardusr3.png"));
			break;
		case 4:
			game.CardArray[Cardnum].setIcon(new ImageIcon("../FlipCard/Img/Cardusr4.png"));
			break;
		default:
			game.CardArray[Cardnum].setIcon(new ImageIcon("../FlipCard/Img/Cardfirst.png"));
			break;
		}
		game.printMessage("변경");
		game.printMessage(Integer.toString(Color));
		game.printMessage(Integer.toString(Cardnum)+"\n");
	}

}