import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import kr.ac.konkuk.ccslab.cm.stub.CMClientStub;
import kr.ac.konkuk.ccslab.cm.entity.CMGroup;
import kr.ac.konkuk.ccslab.cm.entity.CMGroupInfo;
import kr.ac.konkuk.ccslab.cm.entity.CMList;
import kr.ac.konkuk.ccslab.cm.entity.CMMember;
import kr.ac.konkuk.ccslab.cm.entity.CMMessage;
import kr.ac.konkuk.ccslab.cm.entity.CMPosition;
import kr.ac.konkuk.ccslab.cm.entity.CMRecvFileInfo;
import kr.ac.konkuk.ccslab.cm.entity.CMSendFileInfo;
import kr.ac.konkuk.ccslab.cm.entity.CMServer;
import kr.ac.konkuk.ccslab.cm.entity.CMSession;
import kr.ac.konkuk.ccslab.cm.entity.CMSessionInfo;
import kr.ac.konkuk.ccslab.cm.entity.CMUser;
import kr.ac.konkuk.ccslab.cm.event.CMBlockingEventQueue;
import kr.ac.konkuk.ccslab.cm.event.CMDummyEvent;
import kr.ac.konkuk.ccslab.cm.event.CMEvent;
import kr.ac.konkuk.ccslab.cm.event.CMFileEvent;
import kr.ac.konkuk.ccslab.cm.event.CMInterestEvent;
import kr.ac.konkuk.ccslab.cm.event.CMSessionEvent;
import kr.ac.konkuk.ccslab.cm.event.CMUserEvent;
import kr.ac.konkuk.ccslab.cm.info.CMCommInfo;
import kr.ac.konkuk.ccslab.cm.info.CMConfigurationInfo;
import kr.ac.konkuk.ccslab.cm.info.CMFileTransferInfo;
import kr.ac.konkuk.ccslab.cm.info.CMInfo;
import kr.ac.konkuk.ccslab.cm.info.CMInteractionInfo;
import kr.ac.konkuk.ccslab.cm.manager.CMConfigurator;
import kr.ac.konkuk.ccslab.cm.manager.CMEventManager;
import kr.ac.konkuk.ccslab.cm.manager.CMFileTransferManager;
import kr.ac.konkuk.ccslab.cm.manager.CMMqttManager;


public class Login {

   private CMClientStub m_clientStub;
   private FlipCardClientEventHandler m_eventHandler;
   
   public JFrame frmFlipCard;
   private JTextField username;
   
   boolean loginSendcheck = false;
   
   
   public CMClientStub getClientStub()
   {
      return m_clientStub;
   }
   
   public FlipCardClientEventHandler getClientEventHandler()
   {
      return m_eventHandler;
   }

   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               Login window = new Login();
               window.frmFlipCard.setVisible(true);
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      });
   }

   /**
    * Create the application.
    */
   public Login() {
      m_clientStub = new CMClientStub();
      m_eventHandler = new FlipCardClientEventHandler(m_clientStub);
      initialize();
   }

   /**
    * Initialize the contents of the frame.
    */
   private void initialize() {
      frmFlipCard = new JFrame();
      frmFlipCard.setTitle("Flip Card");
      frmFlipCard.getContentPane().setBackground(Color.WHITE);
      frmFlipCard.setBounds(100, 100, 791, 528);
      frmFlipCard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frmFlipCard.getContentPane().setLayout(null);
      
      username = new JTextField();
      username.setHorizontalAlignment(SwingConstants.CENTER);
      username.setBackground(SystemColor.inactiveCaptionBorder);
      username.setBounds(309, 305, 156, 35);
      frmFlipCard.getContentPane().add(username);
      username.setColumns(10);
      
      
      
      JButton btnLogin = new JButton("Login");
      btnLogin.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 18));
      btnLogin.setForeground(new Color(255, 255, 255));
      btnLogin.setBackground(new Color(3, 84, 39));
      btnLogin.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            String uname=username.getText();
              //String pass = "anypass";
              loginSendcheck = m_clientStub.loginCM(uname, uname);
              
              //loginSendcheck - 로그인 요청을 잘 보냈을 경우 true, 아니면 false
              //이 변수 이용해서 로그인 요청 보냈는지 확인하는 구문
              
              
              
            JOptionPane.showMessageDialog(frmFlipCard, "로그인이 완료되었습니다.");
            
            //이벤트 핸들러 기다림
            User getUsername =new User();
            getUsername.GetMyuserColor(uname);
            Maingame frame = new Maingame(); //maingame 창 띄움
             frame.setVisible(true);
             frmFlipCard.setVisible(false); //Login창 닫음.
         }
      });
      btnLogin.setBounds(309, 391, 149, 45);
      frmFlipCard.getContentPane().add(btnLogin);
      
      JLabel lblKonkukCardGame = new JLabel("KonKuk Flip Card");
      lblKonkukCardGame.setHorizontalAlignment(SwingConstants.CENTER);
      lblKonkukCardGame.setForeground(new Color(77, 77, 77));
      lblKonkukCardGame.setFont(new Font("Showcard Gothic", Font.BOLD, 52));
      lblKonkukCardGame.setBounds(126, 10, 522, 100);
      frmFlipCard.getContentPane().add(lblKonkukCardGame);
      
      JLabel lblShowimages = new JLabel("");
      lblShowimages.setBounds(222, 78, 331, 317);
      frmFlipCard.getContentPane().add(lblShowimages);
      lblShowimages.setIcon(new ImageIcon("../FlipCard/Img/Login.png"));
   }
   
   public String GetLoginID() {
      return username.getText();
   }

   public Object Login() {
      // TODO Auto-generated method stub
      return null;
   }
}