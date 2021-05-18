import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.PrintWriter;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Component;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JSplitPane;
import javax.swing.JToolBar;
import java.awt.SystemColor;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.Canvas;
import javax.swing.JProgressBar;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.event.ChangeListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.StyledDocument;

import javax.swing.event.ChangeEvent;
import java.awt.Toolkit;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Checkbox;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.JTree;
import java.awt.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JInternalFrame;

public class Maingame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	public JLabel Timershow;
	public boolean startflag = false;

	public JButton[] CardArray = new JButton[16];
	{
		for (int i = 0; i < 16; i++) {
			CardArray[i] = new JButton("");// 버튼 초기화
			CardArray[i].setIcon(new ImageIcon("../FlipCard/Img/Cardfirst.png"));
			CardArray[i].setForeground(new Color(255, 255, 255));
			CardArray[i].setBackground(new Color(211, 211, 211));
		}

	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Maingame frame = new Maingame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	User MyUser = new User();

	/**
	 * Create the frame.
	 */
	public Maingame() {

		MyUser.ChangeCurrentUser("테스트브라운", "BROWN");
		MyUser.ChangeCurrentUser("테스트블루", "BLUE");
		MyUser.GetMyuserColor("테스트블루");

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

		JLabel BrownUsr = new JLabel(MyUser.Userinfo[0]);
		BrownUsr.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		BrownUsr.setBounds(522, 60, 80, 20);
		contentPane.add(BrownUsr);

		JLabel BlueUsr = new JLabel(MyUser.Userinfo[1]);
		BlueUsr.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		BlueUsr.setBounds(522, 84, 80, 20);
		contentPane.add(BlueUsr);

		JLabel PinkUsr = new JLabel(MyUser.Userinfo[2]);
		PinkUsr.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		PinkUsr.setBounds(522, 107, 80, 20);
		contentPane.add(PinkUsr);

		JLabel GreenUsr = new JLabel(MyUser.Userinfo[3]);
		GreenUsr.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		GreenUsr.setBounds(522, 131, 80, 20);
		contentPane.add(GreenUsr);

		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBackground(new Color(255, 192, 203));
		layeredPane.setBounds(12, 10, 448, 472);
		contentPane.add(layeredPane);

		CardArray[0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch (MyUser.GetMyColor()) {
				case 1:
					CardArray[0].setIcon(new ImageIcon("../FlipCard/Img/Cardusr1.png"));
					break;
				case 2:
					CardArray[0].setIcon(new ImageIcon("../FlipCard/Img/Cardusr2.png"));
					break;
				case 3:
					CardArray[0].setIcon(new ImageIcon("../FlipCard/Img/Cardusr3.png"));
					break;
				case 4:
					CardArray[0].setIcon(new ImageIcon("../FlipCard/Img/Cardusr4.png"));
					break;
				}
				sendColor(0,MyUser.GetMyColor());
			}
		});
		CardArray[0].setBounds(12, 10, 97, 104);
		layeredPane.add(CardArray[0]);

		CardArray[1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch (MyUser.GetMyColor()) {
				case 1:
					CardArray[1].setIcon(new ImageIcon("../FlipCard/Img/Cardusr1.png"));
					break;
				case 2:
					CardArray[1].setIcon(new ImageIcon("../FlipCard/Img/Cardusr2.png"));
					break;
				case 3:
					CardArray[1].setIcon(new ImageIcon("../FlipCard/Img/Cardusr3.png"));
					break;
				case 4:
					CardArray[1].setIcon(new ImageIcon("../FlipCard/Img/Cardusr4.png"));
					break;
				}
				sendColor(0,MyUser.GetMyColor());
			}
		});
		CardArray[1].setBounds(121, 10, 97, 104);
		layeredPane.add(CardArray[1]);

		CardArray[2].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch (MyUser.GetMyColor()) {
				case 1:
					CardArray[2].setIcon(new ImageIcon("../FlipCard/Img/Cardusr1.png"));
					break;
				case 2:
					CardArray[2].setIcon(new ImageIcon("../FlipCard/Img/Cardusr2.png"));
					break;
				case 3:
					CardArray[2].setIcon(new ImageIcon("../FlipCard/Img/Cardusr3.png"));
					break;
				case 4:
					CardArray[2].setIcon(new ImageIcon("../FlipCard/Img/Cardusr4.png"));
					break;
				}
				sendColor(0,MyUser.GetMyColor());
			}
		});
		CardArray[2].setBounds(230, 10, 97, 104);
		layeredPane.add(CardArray[2]);

		CardArray[3].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch (MyUser.GetMyColor()) {
				case 1:
					CardArray[3].setIcon(new ImageIcon("../FlipCard/Img/Cardusr1.png"));
					break;
				case 2:
					CardArray[3].setIcon(new ImageIcon("../FlipCard/Img/Cardusr2.png"));
					break;
				case 3:
					CardArray[3].setIcon(new ImageIcon("../FlipCard/Img/Cardusr3.png"));
					break;
				case 4:
					CardArray[3].setIcon(new ImageIcon("../FlipCard/Img/Cardusr4.png"));
					break;
				}
				sendColor(0,MyUser.GetMyColor());
			}
		});
		CardArray[3].setBounds(339, 10, 97, 104);
		layeredPane.add(CardArray[3]);

		CardArray[4].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch (MyUser.GetMyColor()) {
				case 1:
					CardArray[4].setIcon(new ImageIcon("../FlipCard/Img/Cardusr1.png"));
					break;
				case 2:
					CardArray[4].setIcon(new ImageIcon("../FlipCard/Img/Cardusr2.png"));
					break;
				case 3:
					CardArray[4].setIcon(new ImageIcon("../FlipCard/Img/Cardusr3.png"));
					break;
				case 4:
					CardArray[4].setIcon(new ImageIcon("../FlipCard/Img/Cardusr4.png"));
					break;
				}
				sendColor(0,MyUser.GetMyColor());
			}
		});
		CardArray[4].setBounds(12, 124, 97, 104);
		layeredPane.add(CardArray[4]);

		CardArray[5].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch (MyUser.GetMyColor()) {
				case 1:
					CardArray[5].setIcon(new ImageIcon("../FlipCard/Img/Cardusr1.png"));
					break;
				case 2:
					CardArray[5].setIcon(new ImageIcon("../FlipCard/Img/Cardusr2.png"));
					break;
				case 3:
					CardArray[5].setIcon(new ImageIcon("../FlipCard/Img/Cardusr3.png"));
					break;
				case 4:
					CardArray[5].setIcon(new ImageIcon("../FlipCard/Img/Cardusr4.png"));
					break;
				}
				sendColor(0,MyUser.GetMyColor());
			}
		});
		CardArray[5].setBounds(121, 124, 97, 104);
		layeredPane.add(CardArray[5]);

		CardArray[6].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch (MyUser.GetMyColor()) {
				case 1:
					CardArray[6].setIcon(new ImageIcon("../FlipCard/Img/Cardusr1.png"));
					break;
				case 2:
					CardArray[6].setIcon(new ImageIcon("../FlipCard/Img/Cardusr2.png"));
					break;
				case 3:
					CardArray[6].setIcon(new ImageIcon("../FlipCard/Img/Cardusr3.png"));
					break;
				case 4:
					CardArray[6].setIcon(new ImageIcon("../FlipCard/Img/Cardusr4.png"));
					break;
				}
				sendColor(0,MyUser.GetMyColor());
			}
		});
		CardArray[6].setBounds(230, 124, 97, 104);
		layeredPane.add(CardArray[6]);

		CardArray[7].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch (MyUser.GetMyColor()) {
				case 1:
					CardArray[7].setIcon(new ImageIcon("../FlipCard/Img/Cardusr1.png"));
					break;
				case 2:
					CardArray[7].setIcon(new ImageIcon("../FlipCard/Img/Cardusr2.png"));
					break;
				case 3:
					CardArray[7].setIcon(new ImageIcon("../FlipCard/Img/Cardusr3.png"));
					break;
				case 4:
					CardArray[7].setIcon(new ImageIcon("../FlipCard/Img/Cardusr4.png"));
					break;
				}
				sendColor(0,MyUser.GetMyColor());
			}
		});
		CardArray[7].setBounds(339, 124, 97, 104);
		layeredPane.add(CardArray[7]);

		CardArray[8].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch (MyUser.GetMyColor()) {
				case 1:
					CardArray[8].setIcon(new ImageIcon("../FlipCard/Img/Cardusr1.png"));
					break;
				case 2:
					CardArray[8].setIcon(new ImageIcon("../FlipCard/Img/Cardusr2.png"));
					break;
				case 3:
					CardArray[8].setIcon(new ImageIcon("../FlipCard/Img/Cardusr3.png"));
					break;
				case 4:
					CardArray[8].setIcon(new ImageIcon("../FlipCard/Img/Cardusr4.png"));
					break;
				}
				sendColor(0,MyUser.GetMyColor());
			}
		});
		CardArray[8].setBounds(12, 238, 97, 104);
		layeredPane.add(CardArray[8]);

		CardArray[9].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch (MyUser.GetMyColor()) {
				case 1:
					CardArray[9].setIcon(new ImageIcon("../FlipCard/Img/Cardusr1.png"));
					break;
				case 2:
					CardArray[9].setIcon(new ImageIcon("../FlipCard/Img/Cardusr2.png"));
					break;
				case 3:
					CardArray[9].setIcon(new ImageIcon("../FlipCard/Img/Cardusr3.png"));
					break;
				case 4:
					CardArray[9].setIcon(new ImageIcon("../FlipCard/Img/Cardusr4.png"));
					break;
				}
				sendColor(0,MyUser.GetMyColor());
			}
		});
		CardArray[9].setBounds(121, 238, 97, 104);
		layeredPane.add(CardArray[9]);

		CardArray[10].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch (MyUser.GetMyColor()) {
				case 1:
					CardArray[10].setIcon(new ImageIcon("../FlipCard/Img/Cardusr1.png"));
					break;
				case 2:
					CardArray[10].setIcon(new ImageIcon("../FlipCard/Img/Cardusr2.png"));
					break;
				case 3:
					CardArray[10].setIcon(new ImageIcon("../FlipCard/Img/Cardusr3.png"));
					break;
				case 4:
					CardArray[10].setIcon(new ImageIcon("../FlipCard/Img/Cardusr4.png"));
					break;
				}
				sendColor(0,MyUser.GetMyColor());
			}
		});
		CardArray[10].setBounds(230, 238, 97, 104);
		layeredPane.add(CardArray[10]);

		// JButton CardArray[11] = new JButton("");
		CardArray[11].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch (MyUser.GetMyColor()) {
				case 1:
					CardArray[11].setIcon(new ImageIcon("../FlipCard/Img/Cardusr1.png"));
					break;
				case 2:
					CardArray[11].setIcon(new ImageIcon("../FlipCard/Img/Cardusr2.png"));
					break;
				case 3:
					CardArray[11].setIcon(new ImageIcon("../FlipCard/Img/Cardusr3.png"));
					break;
				case 4:
					CardArray[11].setIcon(new ImageIcon("../FlipCard/Img/Cardusr4.png"));
					break;
				}
				sendColor(0,MyUser.GetMyColor());
			}
		});
		CardArray[11].setBounds(339, 238, 97, 104);
		layeredPane.add(CardArray[11]);

		// JButton CardArray[12] = new JButton("");
		CardArray[12].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch (MyUser.GetMyColor()) {
				case 1:
					CardArray[12].setIcon(new ImageIcon("../FlipCard/Img/Cardusr1.png"));
					break;
				case 2:
					CardArray[12].setIcon(new ImageIcon("../FlipCard/Img/Cardusr2.png"));
					break;
				case 3:
					CardArray[12].setIcon(new ImageIcon("../FlipCard/Img/Cardusr3.png"));
					break;
				case 4:
					CardArray[12].setIcon(new ImageIcon("../FlipCard/Img/Cardusr4.png"));
					break;
				}
				sendColor(0,MyUser.GetMyColor());
			}
		});
		CardArray[12].setBounds(12, 352, 97, 104);
		layeredPane.add(CardArray[12]);

		// JButton CardArray[13] = new JButton("");
		CardArray[13].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch (MyUser.GetMyColor()) {
				case 1:
					CardArray[13].setIcon(new ImageIcon("../FlipCard/Img/Cardusr1.png"));
					break;
				case 2:
					CardArray[13].setIcon(new ImageIcon("../FlipCard/Img/Cardusr2.png"));
					break;
				case 3:
					CardArray[13].setIcon(new ImageIcon("../FlipCard/Img/Cardusr3.png"));
					break;
				case 4:
					CardArray[13].setIcon(new ImageIcon("../FlipCard/Img/Cardusr4.png"));
					break;
				}
				sendColor(0,MyUser.GetMyColor());
			}
		});
		CardArray[13].setBounds(121, 352, 97, 104);
		layeredPane.add(CardArray[13]);

		CardArray[14].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch (MyUser.GetMyColor()) {
				case 1:
					CardArray[14].setIcon(new ImageIcon("../FlipCard/Img/Cardusr1.png"));
					break;
				case 2:
					CardArray[14].setIcon(new ImageIcon("../FlipCard/Img/Cardusr2.png"));
					break;
				case 3:
					CardArray[14].setIcon(new ImageIcon("../FlipCard/Img/Cardusr3.png"));
					break;
				case 4:
					CardArray[14].setIcon(new ImageIcon("../FlipCard/Img/Cardusr4.png"));
					break;
				}
				sendColor(0,MyUser.GetMyColor());
			}
		});
		CardArray[14].setBounds(230, 352, 97, 104);
		layeredPane.add(CardArray[14]);

		// JButton CardArray[15] = new JButton("");
		CardArray[15].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch (MyUser.GetMyColor()) {
				case 1:
					CardArray[15].setIcon(new ImageIcon("../FlipCard/Img/Cardusr1.png"));
					break;
				case 2:
					CardArray[15].setIcon(new ImageIcon("../FlipCard/Img/Cardusr2.png"));
					break;
				case 3:
					CardArray[15].setIcon(new ImageIcon("../FlipCard/Img/Cardusr3.png"));
					break;
				case 4:
					CardArray[15].setIcon(new ImageIcon("../FlipCard/Img/Cardusr4.png"));
					break;
				}
				sendColor(0,MyUser.GetMyColor());
			}
		});
		CardArray[15].setBounds(339, 352, 97, 104);
		layeredPane.add(CardArray[15]);

		JLabel TimerText = new JLabel("Timer :");
		TimerText.setEnabled(false);
		TimerText.setForeground(new Color(0, 0, 0));
		TimerText.setHorizontalAlignment(SwingConstants.LEFT);
		TimerText.setBackground(Color.WHITE);
		TimerText.setFont(new Font("Showcard Gothic", Font.PLAIN, 18));
		TimerText.setBounds(472, 186, 71, 23);
		contentPane.add(TimerText);

		textField = new JTextField();
		textField.setBounds(472, 440, 286, 27);
		contentPane.add(textField);

		JLabel Usrbackground = new JLabel("");
		Usrbackground.setIcon(new ImageIcon("../FlipCard/Img/usrbackground.png"));
		Usrbackground.setBounds(472, 23, 286, 153);
		contentPane.add(Usrbackground);

		JTextPane m_outTextPane = new JTextPane();
		m_outTextPane.setEditable(false);
		m_outTextPane.setBackground(new Color(245, 245, 245));
		m_outTextPane.setBounds(472, 218, 286, 217);
		contentPane.add(m_outTextPane);

		JLabel Timershow = new JLabel("ready");
		Timershow.setFont(new Font("Showcard Gothic", Font.BOLD, 18));
		Timershow.setHorizontalAlignment(SwingConstants.LEFT);
		Timershow.setForeground(new Color(0, 0, 0));
		Timershow.setEnabled(false);
		Timershow.setBounds(540, 187, 80, 20);
		contentPane.add(Timershow);

		Timer jobScheduler = new Timer();
		TimerTask Timerjob = new TimerTask() {
			int Timertime = 10;

			@Override
			public void run() {
				String showTimertime = Integer.toString(Timertime);
				if (Timertime > -1) {
					Timershow.setText(showTimertime);
					Timertime--;
				} else {
					init();
				}
			}
		};
		jobScheduler.scheduleAtFixedRate(Timerjob, 1000, 1000);

	}

	public void init() {
		for (int i = 0; i < 16; i++) {
			CardArray[i].setIcon(new ImageIcon("../FlipCard/Img/Cardfirst.png"));
		}
	}

	public void ChangeColor(int Color, int Cardnum) {
		if (startflag) {
			switch (Color) {
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
	}
	
	public void sendColor(int Cardnum, int indexofColor) {
		if(startflag) {
			String Color="";
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
			String result = "FLIP" + ";" + Integer.toString(Cardnum) + ";" + Color;
			//이벤트 핸들러 불러아서 전송
		}
	}

}
