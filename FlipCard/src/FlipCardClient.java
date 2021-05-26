
//FlipCardClient
import kr.ac.konkuk.ccslab.cm.entity.CMUser;
import kr.ac.konkuk.ccslab.cm.info.CMInteractionInfo;
import kr.ac.konkuk.ccslab.cm.stub.CMClientStub;

public class FlipCardClient {
	CMUser myself;
	public CMClientStub m_clientStub;
	public FlipCardClientEventHandler m_eventHandler;
	String uname = "";
	boolean openflag = false;

	public FlipCardClient() {
		m_clientStub = new CMClientStub();
		m_eventHandler = new FlipCardClientEventHandler(this);
	}

	public CMClientStub getClientStub() {
		return m_clientStub;
	}

	public FlipCardClientEventHandler getClientEventHandler() {
		return m_eventHandler;
	}

	public static void main(String[] args) {
		FlipCardClient client = new FlipCardClient();
		CMClientStub cmStub = client.getClientStub();
		cmStub.setAppEventHandler(client.getClientEventHandler());
		cmStub.startCM();
		Login window = new Login(client);
		window.frmFlipCard.setVisible(true);
	}

	public void FlipCardClientGame(CMClientStub clientStub) {
		m_clientStub = clientStub;
		CMInteractionInfo interInfo = m_clientStub.getCMInfo().getInteractionInfo();
		myself = interInfo.getMyself();
		uname = myself.getName();
	}

}