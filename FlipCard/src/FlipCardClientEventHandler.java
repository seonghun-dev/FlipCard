/**FlipCardClientEventHandler
 */
import java.awt.Color;

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
			game.setLocationRelativeTo(null); //화면 가운데 고정
			game.setVisible(true); // 메인게임 화면 시작
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
			if (UserID.equals(User.myname)) { // 내 색상 지정.
				MyUser.GetMyuserColor(UserID);
			}
			break;

		case "READY":
			game.printMessage("[공지] 게임이 곧 시작합니다. \n");
			break;

		case "START":
			game.Timershow.setText("START");
			game.init(); // 카드 초기화
			game.setstartflag(true);
			break;
			
		case "FLIP":
			game.printMessage("메세지 받음");
			ChangeColor(Integer.parseInt(splitMsg[1]),splitMsg[2]);// 카드 변경
			break;
			
		case "STOP":
			game.setstartflag(false); //게임 중단.
			game.init(); // 카드 초기화
			//결과창
			isregame.ShowWinner("BLUE");
			isregame.setLocationRelativeTo(null);
			isregame.setVisible(true);
			game.resettext();
			// 채팅창에 표시
			break;
			
		case "TIMER":
				game.Timershow.setText(splitMsg[1]);
			break;

		case "WIN":
			break;

		}

	}
	
	// 서버에서 받아온 값 변화
	public void ChangeColor(int Cardnum, String Color) {
		switch (Color) {
		case  "BROWN":
			game.CardArray[Cardnum].setIcon(new ImageIcon("../FlipCard/Img/Cardusr1.png"));
			break;
		case "BLUE":
			game.CardArray[Cardnum].setIcon(new ImageIcon("../FlipCard/Img/Cardusr2.png"));
			break;
		case "PINK":
			game.CardArray[Cardnum].setIcon(new ImageIcon("../FlipCard/Img/Cardusr3.png"));
			break;
		case "GREEN":
			game.CardArray[Cardnum].setIcon(new ImageIcon("../FlipCard/Img/Cardusr4.png"));
			break;
		default:
			game.CardArray[Cardnum].setIcon(new ImageIcon("../FlipCard/Img/Cardfirst.png"));
			break;
		}
	}

}