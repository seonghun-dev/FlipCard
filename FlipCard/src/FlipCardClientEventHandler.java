//FlipCardEventHandler
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import kr.ac.konkuk.ccslab.cm.entity.CMGroup;
import kr.ac.konkuk.ccslab.cm.entity.CMGroupInfo;
import kr.ac.konkuk.ccslab.cm.entity.CMMember;
import kr.ac.konkuk.ccslab.cm.entity.CMSessionInfo;
import kr.ac.konkuk.ccslab.cm.entity.CMUser;
import kr.ac.konkuk.ccslab.cm.event.CMDataEvent;
import kr.ac.konkuk.ccslab.cm.event.CMDummyEvent;
import kr.ac.konkuk.ccslab.cm.event.CMEvent;
import kr.ac.konkuk.ccslab.cm.event.CMSessionEvent;
import kr.ac.konkuk.ccslab.cm.event.handler.CMAppEventHandler;
import kr.ac.konkuk.ccslab.cm.info.CMInfo;
import kr.ac.konkuk.ccslab.cm.info.CMInteractionInfo;
import kr.ac.konkuk.ccslab.cm.stub.CMClientStub;

public class FlipCardClientEventHandler implements CMAppEventHandler {
	private CMClientStub m_clientStub;
	private FlipCardClient m_client;
	Maingame game = new Maingame();

	public FlipCardClientEventHandler(CMClientStub stub)
	{
		m_clientStub = stub;
	}
	
	public void getClientEventHandler(CMClientStub stub, FlipCardClient client) {
		m_client = client;
		m_clientStub = stub;
	}

	public void processEvent(CMEvent cme) {
		// TODO Auto-generated method stub
		// System.out.println("processEvent: Client app receives CM event!!");
		switch (cme.getType()) {
		case CMInfo.CM_DUMMY_EVENT:
			ReceiveprocessDummyEvent(cme);
			break;
		case CMInfo.CM_SESSION_EVENT:
			processSessionEvent(cme);

		default:
			break;
		}
	}

	private void ReceiveprocessDummyEvent(CMEvent cme) {
		CMDummyEvent cde = (CMDummyEvent) cme; // 서버에게서 받는
		String message = cde.getDummyInfo();
		String[] splitMsg = message.split(";");
		String choice = splitMsg[0];
		User MyUser = new User();

		switch (choice) {
		case "LOGIN":
			String UserID = splitMsg[1];
			String Color = splitMsg[2];
			FlipCardClient newgame = new FlipCardClient();
			MyUser.ChangeCurrentUser(UserID, Color);
			// newgame.FlipCardClientGame();
			MyUser.GetMyuserColor(newgame.uname);
			FlipCardClient changeflag = new FlipCardClient();
			changeflag.openflag = true;

			// 로그인창 닫기-연결만
			// 메인게임 불러오기-연결만

		case "START":
			game.init();
			game.startflag = true;
			// 카드 초기화
			// 시간 10초로 보여짐

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
			game.startflag = false;
			// 시간 0초로 보여짐
			// 카드 초기화
			// 클라측 이벤트 핸들러 중단
		case "WIN":
			// 채팅창에 표시
		case "TIMER":
			game.Timershow.setText(splitMsg[1]);
		}

	}

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

	}

	private void processDataEvent(CMEvent cme) {
		CMDataEvent de = (CMDataEvent) cme;
		switch (de.getID()) {
		case CMDataEvent.NEW_USER:
			printMessage("[" + de.getUserName() + "] 의 사용자가 들어왔습니다..", "Chat");
			// printMessage(count+"", "Info");

			break;
		case CMDataEvent.REMOVE_USER:
			// printMessage("["+de.getUserName()+"] leaves group("+de.getHandlerGroup()+")
			// in session("
			// +de.getHandlerSession()+").");
			printMessage("[" + de.getUserName() + "] 의 사용자가 나갔습니다.", "Chat");
			// printMessage(count+"", "Info");
			break;
		default:
			return;
		}
	}

	private void printMessage(String strText, String type) {
		// m_client.printMessage(strText, type);

		return;
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
