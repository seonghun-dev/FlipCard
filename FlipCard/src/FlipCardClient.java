//FlipCardClient
import kr.ac.konkuk.ccslab.cm.entity.CMUser;
import kr.ac.konkuk.ccslab.cm.info.CMInteractionInfo;
import kr.ac.konkuk.ccslab.cm.stub.CMClientStub;

public class FlipCardClient {
   CMUser myself;
   public CMClientStub m_clientStub;
   public FlipCardClientEventHandler m_eventHandler;

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
      cmStub.startCM(); //CM start
      Login window = new Login(client); //show Login user interface
      window.frmFlipCard.setLocationRelativeTo(null);
      window.frmFlipCard.setVisible(true);
   }

   public void FlipCardClientGame(CMClientStub clientStub) {
      m_clientStub = clientStub;
      CMInteractionInfo interInfo = m_clientStub.getCMInfo().getInteractionInfo();
      myself = interInfo.getMyself();
   }

}