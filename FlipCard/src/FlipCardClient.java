import java.awt.*;// 그래픽 처리를 위한 클래스들의 경로명
import java.awt.event.*; // AWT 이벤트 사용을 위한 경로명 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.*; // 스윙 컴포넌트 클래스들의 경로명 
import javax.swing.event.*; // 스윙 이벤트를 위한 경로
import javax.swing.text.BadLocationException;
import javax.swing.text.StyledDocument;
import java.awt.EventQueue;
import kr.ac.konkuk.ccslab.cm.entity.CMUser;
import kr.ac.konkuk.ccslab.cm.event.CMDummyEvent;
import kr.ac.konkuk.ccslab.cm.info.CMInteractionInfo;
import kr.ac.konkuk.ccslab.cm.stub.CMClientStub;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class FlipCardClient  {
   CMUser myself;
   private CMClientStub m_clientStub;
   private FlipCardClientEventHandler m_eventHandler;
   String uname="";
   public static boolean openflag=false;
   
   
   public FlipCardClient()
	{
	   m_clientStub = new CMClientStub();
	   m_eventHandler = new FlipCardClientEventHandler(m_clientStub);
	}

	public CMClientStub getClientStub()
	{
		return m_clientStub;
	}
	
	public FlipCardClientEventHandler getClientEventHandler()
	{
		return m_eventHandler;
	}
	
	public static void main(String[] args) {
	      FlipCardClient client = new FlipCardClient();
	      CMClientStub cmStub = client.getClientStub();
	      cmStub.setAppEventHandler(client.getClientEventHandler());
	      cmStub.startCM();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
					Login window = new Login();
					Login.main(args);
			}
		});
	}
   
   public void  FlipCardClientGame(CMClientStub clientStub) {
      m_clientStub=clientStub;
      CMInteractionInfo interInfo=m_clientStub.getCMInfo().getInteractionInfo();
      myself=interInfo.getMyself();
      uname=myself.getName();
    	  
   }
   
   public void printmessage(String message, String type) {
      switch(type) {
      case "Chat":
      case "Winner":
      }
      
   }
  

}
