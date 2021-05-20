//import kr.ac.konkuk.ccslab.cm.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import kr.ac.konkuk.ccslab.cm.manager.CMCommManager;
import kr.ac.konkuk.ccslab.cm.stub.CMServerStub;

public class FlipCardServer {
   private CMServerStub m_serverStub;
   private FlipCardServerEventHandler m_eventHandler;
   
   public FlipCardServer()
   {
      m_serverStub = new CMServerStub();
      m_eventHandler = new FlipCardServerEventHandler(m_serverStub);
   }
   
   public CMServerStub getServerStub()  
   {   
      return m_serverStub;  
   }    
   
   public FlipCardServerEventHandler getServerEventHandler()  
   {   
      return m_eventHandler;  
   } 
    
    public static void main(String[] args) 
    {   
       FlipCardServer srv = new FlipCardServer();   
       CMServerStub cmStub = srv.getServerStub();   
       cmStub.setAppEventHandler(srv.getServerEventHandler());   
       cmStub.startCM();
   } 
    
	
}
    