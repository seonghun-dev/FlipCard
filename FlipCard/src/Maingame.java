
//Maingame
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.BadLocationException;
import javax.swing.text.StyledDocument;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JLayeredPane;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import kr.ac.konkuk.ccslab.cm.event.CMDummyEvent;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JScrollPane;

public class Maingame extends JFrame {
   private JPanel contentPane;
   private JTextField textField;
   public JLabel Timershow = new JLabel("ready");
   private static boolean startflag = false; // 게임 진행
   JTextPane m_outTextPane = new JTextPane();
   JLabel Regame;

   FlipCardClient m_client;

   // private CMClientStub m_clientStub = new CMClientStub();
   private JLabel BrownUsr = new JLabel(User.Userinfo[0]);
   private JLabel BlueUsr = new JLabel(User.Userinfo[1]);
   private JLabel PinkUsr = new JLabel(User.Userinfo[2]);
   private JLabel GreenUsr = new JLabel(User.Userinfo[3]);
   public JButton[] CardArray = new JButton[16];
   {
      for (int i = 0; i < 16; i++) {
         CardArray[i] = new JButton("");// 버튼 초기화
         CardArray[i].setIcon(new ImageIcon("../FlipCard/Img/Cardfirst.png"));
         CardArray[i].setForeground(new Color(255, 255, 255));
         CardArray[i].setBackground(new Color(211, 211, 211));
      }

   }
   User MyUser = new User();

   public Maingame(FlipCardClient client) {

      m_client = client;
      setResizable(false);
      setIconImage(Toolkit.getDefaultToolkit().getImage("../FlipCard/Img/icon.png"));
      setFont(new Font("Brush Script MT", Font.PLAIN, 15));
      setTitle("FlipCard");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(100, 100, 791, 528);
      contentPane = new JPanel();
      contentPane.setBackground(new Color(255, 255, 255));
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(contentPane);
      contentPane.setLayout(null);

      BrownUsr.setFont(new Font("함초롬돋움", Font.PLAIN, 14));
      BrownUsr.setBounds(522, 60, 210, 20);
      contentPane.add(BrownUsr);

      BlueUsr.setFont(new Font("함초롬돋움", Font.PLAIN, 14));
      BlueUsr.setBounds(522, 84, 210, 20);
      contentPane.add(BlueUsr);

      PinkUsr.setFont(new Font("함초롬돋움", Font.PLAIN, 14));
      PinkUsr.setBounds(522, 107, 210, 20);
      contentPane.add(PinkUsr);

      GreenUsr.setFont(new Font("함초롬돋움", Font.PLAIN, 14));
      GreenUsr.setBounds(522, 131, 210, 20);
      contentPane.add(GreenUsr);

      JLayeredPane layeredPane = new JLayeredPane();
      layeredPane.setBackground(new Color(255, 192, 203));
      layeredPane.setBounds(12, 10, 448, 472);
      contentPane.add(layeredPane);

      CardArray[0].addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            // ClickHandler(0);
            sendColor(0, MyUser.GetMyColor());
         }
      });
      CardArray[0].setBounds(12, 10, 97, 104);
      layeredPane.add(CardArray[0]);

      CardArray[1].addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            // ClickHandler(1);
            sendColor(1, MyUser.GetMyColor());
         }
      });
      CardArray[1].setBounds(121, 10, 97, 104);
      layeredPane.add(CardArray[1]);

      CardArray[2].addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            // ClickHandler(2);
            sendColor(2, MyUser.GetMyColor());
         }
      });
      CardArray[2].setBounds(230, 10, 97, 104);
      layeredPane.add(CardArray[2]);

      CardArray[3].addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            // ClickHandler(3);
            sendColor(3, MyUser.GetMyColor());
         }
      });
      CardArray[3].setBounds(339, 10, 97, 104);
      layeredPane.add(CardArray[3]);

      CardArray[4].addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            // ClickHandler(4);
            sendColor(4, MyUser.GetMyColor());
         }
      });
      CardArray[4].setBounds(12, 124, 97, 104);
      layeredPane.add(CardArray[4]);

      CardArray[5].addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            // ClickHandler(5);
            sendColor(5, MyUser.GetMyColor());
         }
      });
      CardArray[5].setBounds(121, 124, 97, 104);
      layeredPane.add(CardArray[5]);

      CardArray[6].addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            // ClickHandler(6);
            sendColor(6, MyUser.GetMyColor());
         }
      });
      CardArray[6].setBounds(230, 124, 97, 104);
      layeredPane.add(CardArray[6]);

      CardArray[7].addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            // ClickHandler(7);
            sendColor(7, MyUser.GetMyColor());
         }
      });
      CardArray[7].setBounds(339, 124, 97, 104);
      layeredPane.add(CardArray[7]);

      CardArray[8].addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            // ClickHandler(8);
            sendColor(8, MyUser.GetMyColor());
         }
      });
      CardArray[8].setBounds(12, 238, 97, 104);
      layeredPane.add(CardArray[8]);

      CardArray[9].addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            // ClickHandler(9);
            sendColor(9, MyUser.GetMyColor());
         }
      });
      CardArray[9].setBounds(121, 238, 97, 104);
      layeredPane.add(CardArray[9]);

      CardArray[10].addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            // ClickHandler(10);
            sendColor(10, MyUser.GetMyColor());
         }
      });
      CardArray[10].setBounds(230, 238, 97, 104);
      layeredPane.add(CardArray[10]);

      CardArray[11].addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            // ClickHandler(11);
            sendColor(11, MyUser.GetMyColor());
         }
      });
      CardArray[11].setBounds(339, 238, 97, 104);
      layeredPane.add(CardArray[11]);

      CardArray[12].addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            // ClickHandler(12);
            sendColor(12, MyUser.GetMyColor());
         }
      });
      CardArray[12].setBounds(12, 352, 97, 104);
      layeredPane.add(CardArray[12]);

      CardArray[13].addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            // ClickHandler(13);
            sendColor(13, MyUser.GetMyColor());
         }
      });
      CardArray[13].setBounds(121, 352, 97, 104);
      layeredPane.add(CardArray[13]);

      CardArray[14].addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            // ClickHandler(14);
            sendColor(14, MyUser.GetMyColor());
         }
      });
      CardArray[14].setBounds(230, 352, 97, 104);
      layeredPane.add(CardArray[14]);

      CardArray[15].addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            // ClickHandler(15);
            sendColor(15, MyUser.GetMyColor());
         }
      });
      CardArray[15].setBounds(339, 352, 97, 104);
      layeredPane.add(CardArray[15]);

      // 사용자 정보
      JLabel Usrbackground = new JLabel("");
      Usrbackground.setIcon(new ImageIcon("../FlipCard/Img/usrbackground.png"));
      Usrbackground.setBounds(472, 23, 286, 153);
      contentPane.add(Usrbackground);

      // 채팅창
      m_outTextPane.setEditable(false);
      m_outTextPane.setBackground(new Color(245, 245, 245));
      m_outTextPane.setBounds(472, 218, 286, 217);
      m_outTextPane.setFont(new Font("함초롬돋움", Font.PLAIN, 14));
      contentPane.add(m_outTextPane);
      JScrollPane scrollPane = new JScrollPane(m_outTextPane);
      scrollPane.setBounds(472, 218, 286, 217);
      contentPane.add(scrollPane);

      // 채팅창 입력
      textField = new JTextField();
      textField.addKeyListener(new KeyAdapter() {
         @Override
         public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            if (key == KeyEvent.VK_ENTER) {
               inputMsg();
            }
         }
      });

      textField.setBounds(472, 440, 286, 27);
      contentPane.add(textField);

      // 타이머 파트 글자표시
      JLabel TimerText = new JLabel("Timer :");
      TimerText.setEnabled(false);
      TimerText.setForeground(new Color(0, 0, 0));
      TimerText.setHorizontalAlignment(SwingConstants.LEFT);
      TimerText.setBackground(Color.WHITE);
      TimerText.setFont(new Font("Showcard Gothic", Font.PLAIN, 18));
      TimerText.setBounds(472, 186, 71, 23);
      contentPane.add(TimerText);

      // 타이머-시간 표시
      Timershow.setFont(new Font("Showcard Gothic", Font.BOLD, 18));
      Timershow.setHorizontalAlignment(SwingConstants.LEFT);
      Timershow.setForeground(new Color(0, 0, 0));
      Timershow.setEnabled(false);
      Timershow.setBounds(540, 187, 80, 20);
      contentPane.add(Timershow);
   }

   // 카드 값 초기화
   public void init() {
      for (int i = 0; i < 16; i++) {
         CardArray[i].setIcon(new ImageIcon("../FlipCard/Img/Cardfirst.png"));
      }
   }

   // 서버로 컬러값 보내주는 부분
   public void sendColor(int Cardnum, int indexofColor) {
      String Color = "";
      if (startflag) {
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
         // 서버에게 보내주는 부분
         String result = "FLIP" + ";" + Integer.toString(Cardnum) + ";" + Color;
         CMDummyEvent due = new CMDummyEvent();
         due.setDummyInfo(result);
         m_client.m_clientStub.send(due, "SERVER");
      }
      return;
   }

   // 클릭했을때 사용자 색깔로 변경
   public void ClickHandler(int Cardnum) {
      switch (MyUser.GetMyColor()) {
      case 1:
         CardArray[Cardnum].setIcon(new ImageIcon("../FlipCard/Img/Cardusr1.png"));
         break;
      case 2:
         CardArray[Cardnum].setIcon(new ImageIcon("../FlipCard/Img/Cardusr2.png"));
         break;
      case 3:
         CardArray[Cardnum].setIcon(new ImageIcon("../FlipCard/Img/Cardusr3.png"));
         break;
      case 4:
         CardArray[Cardnum].setIcon(new ImageIcon("../FlipCard/Img/Cardusr4.png"));
         break;
      }
   }

   // 사용자 정보 갱신
   public void resettext() {
      BrownUsr.setText(User.Userinfo[0]);
      BlueUsr.setText(User.Userinfo[1]);
      PinkUsr.setText(User.Userinfo[2]);
      GreenUsr.setText(User.Userinfo[3]);
   }

   // 채팅창 입력 내용 전송
   public void inputMsg() {
      String strText = textField.getText();
      textField.setText("");
      textField.requestFocus();

      m_client.m_clientStub.chat("/b", strText);
   }
   
   // 채팅창 입력내용 표시
   public void printMessage(String strText) {
      StyledDocument doc = m_outTextPane.getStyledDocument();
      try {
         doc.insertString(doc.getLength(), strText, null);
         m_outTextPane.setCaretPosition(m_outTextPane.getDocument().getLength());
      } catch (BadLocationException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      return;
   }

   public void setstartflag(boolean state) {
      startflag = state;
   }

   public boolean getstartflag() {
      return startflag;
   }



}