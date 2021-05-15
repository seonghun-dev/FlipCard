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
	public JButton Card0;	public JButton Card1;
	public JButton Card2;	public JButton Card3;
	public JButton Card4;	public JButton Card5;
	public JButton Card6;	public JButton Card7;
	public JButton Card8;	public JButton Card9;
	public JButton Card10; public JButton Card11;
	public JButton Card12;	public JButton Card13;
	public JButton Card14; public JButton Card15;
	
	
	
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

	

	
	
	/**
	 * Create the frame.
	 */
	public Maingame() {
		
		User MyUser = new User();
		MyUser.ChangeCurrentUser("테스트브라운","BROWN");
		MyUser.ChangeCurrentUser("테스트블루","BLUE");
		MyUser. GetMyuserColor("테스트블루");
		
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
			

			
			JButton Card0 = new JButton("");
			Card0.setIcon(new ImageIcon("../FlipCard/Img/Cardfirst.png"));
			Card0.setForeground(new Color(255, 255, 255));
			Card0.setBackground(new Color(211, 211, 211));
			Card0.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					switch(MyUser.GetMyColor()) {
					case 1 : Card0.setIcon(new ImageIcon("../FlipCard/Img/Cardusr1.png")); break;
					case 2 : Card0.setIcon(new ImageIcon("../FlipCard/Img/Cardusr2.png")); break;
					case 3 : Card0.setIcon(new ImageIcon("../FlipCard/Img/Cardusr3.png")); break;
					case 4 : Card0.setIcon(new ImageIcon("../FlipCard/Img/Cardusr4.png")); break;
					}
				}
			});
			Card0.setBounds(12, 10, 97, 104);
			layeredPane.add(Card0);
			
			
			
			JButton Card1 = new JButton("");
			Card1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					switch(MyUser.GetMyColor()) {
					case 1 : Card1.setIcon(new ImageIcon("../FlipCard/Img/Cardusr1.png")); break;
					case 2 : Card1.setIcon(new ImageIcon("../FlipCard/Img/Cardusr2.png")); break;
					case 3 : Card1.setIcon(new ImageIcon("../FlipCard/Img/Cardusr3.png")); break;
					case 4 : Card1.setIcon(new ImageIcon("../FlipCard/Img/Cardusr4.png")); break;
					}
				}
			});
			Card1.setIcon(new ImageIcon("../FlipCard/Img/Cardfirst.png"));
			Card1.setForeground(new Color(255, 255, 255));
			Card1.setBackground(new Color(211, 211, 211));
			Card1.setBounds(121, 10, 97, 104);
			layeredPane.add(Card1);
			
			
			
			JButton Card2 = new JButton("");
			Card2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e)  {
					switch(MyUser.GetMyColor()) {
					case 1 : Card2.setIcon(new ImageIcon("../FlipCard/Img/Cardusr1.png")); break;
					case 2 : Card2.setIcon(new ImageIcon("../FlipCard/Img/Cardusr2.png")); break;
					case 3 : Card2.setIcon(new ImageIcon("../FlipCard/Img/Cardusr3.png")); break;
					case 4 : Card2.setIcon(new ImageIcon("../FlipCard/Img/Cardusr4.png")); break;
					}
				}
			});
			Card2.setIcon(new ImageIcon("../FlipCard/Img/Cardfirst.png"));
			Card2.setForeground(new Color(255, 255, 255));
			Card2.setBackground(new Color(211, 211, 211));
			Card2.setBounds(230, 10, 97, 104);
			layeredPane.add(Card2);
			
			
			
			
			JButton Card3 = new JButton("");
			Card3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e)  {
					switch(MyUser.GetMyColor()) {
					case 1 : Card3.setIcon(new ImageIcon("../FlipCard/Img/Cardusr1.png")); break;
					case 2 : Card3.setIcon(new ImageIcon("../FlipCard/Img/Cardusr2.png")); break;
					case 3 : Card3.setIcon(new ImageIcon("../FlipCard/Img/Cardusr3.png")); break;
					case 4 : Card3.setIcon(new ImageIcon("../FlipCard/Img/Cardusr4.png")); break;
					}
				}
			});
			Card3.setIcon(new ImageIcon("../FlipCard/Img/Cardfirst.png"));
			Card3.setForeground(new Color(255, 255, 255));
			Card3.setBackground(new Color(211, 211, 211));
			Card3.setBounds(339, 10, 97, 104);
			layeredPane.add(Card3);
			

			JButton Card4 = new JButton("");
			Card4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e)  {
					switch(MyUser.GetMyColor()) {
					case 1 : Card4.setIcon(new ImageIcon("../FlipCard/Img/Cardusr1.png")); break;
					case 2 : Card4.setIcon(new ImageIcon("../FlipCard/Img/Cardusr2.png")); break;
					case 3 : Card4.setIcon(new ImageIcon("../FlipCard/Img/Cardusr3.png")); break;
					case 4 : Card4.setIcon(new ImageIcon("../FlipCard/Img/Cardusr4.png")); break;
					}
				}
			});
			Card4.setIcon(new ImageIcon("../FlipCard/Img/Cardfirst.png"));
			Card4.setForeground(new Color(255, 255, 255));
			Card4.setBackground(new Color(211, 211, 211));
			Card4.setBounds(12, 124, 97, 104);
			layeredPane.add(Card4);
			
			JButton Card5 = new JButton("");
			Card5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e)  {
					switch(MyUser.GetMyColor()) {
					case 1 : Card5.setIcon(new ImageIcon("../FlipCard/Img/Cardusr1.png")); break;
					case 2 : Card5.setIcon(new ImageIcon("../FlipCard/Img/Cardusr2.png")); break;
					case 3 : Card5.setIcon(new ImageIcon("../FlipCard/Img/Cardusr3.png")); break;
					case 4 : Card5.setIcon(new ImageIcon("../FlipCard/Img/Cardusr4.png")); break;
					}
				}
			});
			Card5.setIcon(new ImageIcon("../FlipCard/Img/Cardfirst.png"));
			Card5.setForeground(new Color(255, 255, 255));
			Card5.setBackground(new Color(211, 211, 211));
			Card5.setBounds(121, 124, 97, 104);
			layeredPane.add(Card5);
			
			
			
			JButton Card6 = new JButton("");
			Card6.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					switch(MyUser.GetMyColor()) {
					case 1 : Card6.setIcon(new ImageIcon("../FlipCard/Img/Cardusr1.png")); break;
					case 2 : Card6.setIcon(new ImageIcon("../FlipCard/Img/Cardusr2.png")); break;
					case 3 : Card6.setIcon(new ImageIcon("../FlipCard/Img/Cardusr3.png")); break;
					case 4 : Card6.setIcon(new ImageIcon("../FlipCard/Img/Cardusr4.png")); break;
					}
				}
			});
			Card6.setIcon(new ImageIcon("../FlipCard/Img/Cardfirst.png"));
			Card6.setForeground(new Color(255, 255, 255));
			Card6.setBackground(new Color(211, 211, 211));
			Card6.setBounds(230, 124, 97, 104);
			layeredPane.add(Card6);
			
			
			JButton Card7 = new JButton("");
			Card7.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					switch(MyUser.GetMyColor()) {
					case 1 : Card7.setIcon(new ImageIcon("../FlipCard/Img/Cardusr1.png")); break;
					case 2 : Card7.setIcon(new ImageIcon("../FlipCard/Img/Cardusr2.png")); break;
					case 3 : Card7.setIcon(new ImageIcon("../FlipCard/Img/Cardusr3.png")); break;
					case 4 : Card7.setIcon(new ImageIcon("../FlipCard/Img/Cardusr4.png")); break;
					}
				}
			});
			Card7.setIcon(new ImageIcon("../FlipCard/Img/Cardfirst.png"));
			Card7.setForeground(new Color(255, 255, 255));
			Card7.setBackground(new Color(211, 211, 211));
			Card7.setBounds(339, 124, 97, 104);
			layeredPane.add(Card7);
			
					JButton Card8 = new JButton("");
					Card8.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							switch(MyUser.GetMyColor()) {
							case 1 : Card8.setIcon(new ImageIcon("../FlipCard/Img/Cardusr1.png")); break;
							case 2 : Card8.setIcon(new ImageIcon("../FlipCard/Img/Cardusr2.png")); break;
							case 3 : Card8.setIcon(new ImageIcon("../FlipCard/Img/Cardusr3.png")); break;
							case 4 : Card8.setIcon(new ImageIcon("../FlipCard/Img/Cardusr4.png")); break;
							}
						}
					});
					Card8.setIcon(new ImageIcon("../FlipCard/Img/Cardfirst.png"));
					Card8.setForeground(new Color(255, 255, 255));
					Card8.setBackground(new Color(211, 211, 211));
					Card8.setBounds(12, 238, 97, 104);
					layeredPane.add(Card8);
					
					
					JButton Card9 = new JButton("");
					Card9.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							switch(MyUser.GetMyColor()) {
							case 1 : Card9.setIcon(new ImageIcon("../FlipCard/Img/Cardusr1.png")); break;
							case 2 : Card9.setIcon(new ImageIcon("../FlipCard/Img/Cardusr2.png")); break;
							case 3 : Card9.setIcon(new ImageIcon("../FlipCard/Img/Cardusr3.png")); break;
							case 4 : Card9.setIcon(new ImageIcon("../FlipCard/Img/Cardusr4.png")); break;
							}
						}
					});
					Card9.setIcon(new ImageIcon("../FlipCard/Img/Cardfirst.png"));
					Card9.setForeground(new Color(255, 255, 255));
					Card9.setBackground(new Color(211, 211, 211));
					Card9.setBounds(121, 238, 97, 104);
					layeredPane.add(Card9);
					
					
					
					JButton Card10 = new JButton("");
					Card10.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							switch(MyUser.GetMyColor()) {
							case 1 : Card10.setIcon(new ImageIcon("../FlipCard/Img/Cardusr1.png")); break;
							case 2 : Card10.setIcon(new ImageIcon("../FlipCard/Img/Cardusr2.png")); break;
							case 3 : Card10.setIcon(new ImageIcon("../FlipCard/Img/Cardusr3.png")); break;
							case 4 : Card10.setIcon(new ImageIcon("../FlipCard/Img/Cardusr4.png")); break;
							}
						}
					});
					Card10.setIcon(new ImageIcon("../FlipCard/Img/Cardfirst.png"));
					Card10.setForeground(new Color(255, 255, 255));
					Card10.setBackground(new Color(211, 211, 211));
					Card10.setBounds(230, 238, 97, 104);
					layeredPane.add(Card10);		
					
					
					
					JButton Card11 = new JButton("");
					Card11.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							switch(MyUser.GetMyColor()) {
							case 1 : Card11.setIcon(new ImageIcon("../FlipCard/Img/Cardusr1.png")); break;
							case 2 : Card11.setIcon(new ImageIcon("../FlipCard/Img/Cardusr2.png")); break;
							case 3 : Card11.setIcon(new ImageIcon("../FlipCard/Img/Cardusr3.png")); break;
							case 4 : Card11.setIcon(new ImageIcon("../FlipCard/Img/Cardusr4.png")); break;
							}
						}
					});
					Card11.setIcon(new ImageIcon("../FlipCard/Img/Cardfirst.png"));
					Card11.setForeground(new Color(255, 255, 255));
					Card11.setBackground(new Color(211, 211, 211));
					Card11.setBounds(339, 238, 97, 104);
					layeredPane.add(Card11);
					
					
					
					JButton Card12 = new JButton("");
					Card12.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							switch(MyUser.GetMyColor()) {
							case 1 : Card12.setIcon(new ImageIcon("../FlipCard/Img/Cardusr1.png")); break;
							case 2 : Card12.setIcon(new ImageIcon("../FlipCard/Img/Cardusr2.png")); break;
							case 3 : Card12.setIcon(new ImageIcon("../FlipCard/Img/Cardusr3.png")); break;
							case 4 : Card12.setIcon(new ImageIcon("../FlipCard/Img/Cardusr4.png")); break;
							}
						}
					});
					Card12.setIcon(new ImageIcon("../FlipCard/Img/Cardfirst.png"));
					Card12.setForeground(new Color(255, 255, 255));
					Card12.setBackground(new Color(211, 211, 211));
					Card12.setBounds(12, 352, 97, 104);
					layeredPane.add(Card12);
					
					
					
					JButton Card13 = new JButton("");
					Card13.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							switch(MyUser.GetMyColor()) {
							case 1 : Card13.setIcon(new ImageIcon("../FlipCard/Img/Cardusr1.png")); break;
							case 2 : Card13.setIcon(new ImageIcon("../FlipCard/Img/Cardusr2.png")); break;
							case 3 : Card13.setIcon(new ImageIcon("../FlipCard/Img/Cardusr3.png")); break;
							case 4 : Card13.setIcon(new ImageIcon("../FlipCard/Img/Cardusr4.png")); break;
							}
						}
					});
					Card13.setIcon(new ImageIcon("../FlipCard/Img/Cardfirst.png"));
					Card13.setForeground(new Color(255, 255, 255));
					Card13.setBackground(new Color(211, 211, 211));
					Card13.setBounds(121, 352, 97, 104);
					layeredPane.add(Card13);
					
					
					
					JButton Card14 = new JButton("");
					Card14.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							switch(MyUser.GetMyColor()) {
							case 1 : Card14.setIcon(new ImageIcon("../FlipCard/Img/Cardusr1.png")); break;
							case 2 : Card14.setIcon(new ImageIcon("../FlipCard/Img/Cardusr2.png")); break;
							case 3 : Card14.setIcon(new ImageIcon("../FlipCard/Img/Cardusr3.png")); break;
							case 4 : Card14.setIcon(new ImageIcon("../FlipCard/Img/Cardusr4.png")); break;
							}
						}
					});
					Card14.setIcon(new ImageIcon("../FlipCard/Img/Cardfirst.png"));
					Card14.setForeground(new Color(255, 255, 255));
					Card14.setBackground(new Color(211, 211, 211));
					Card14.setBounds(230, 352, 97, 104);
					layeredPane.add(Card14);
					
					JButton Card15 = new JButton("");
					Card15.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							switch(MyUser.GetMyColor()) {
							case 1 : Card15.setIcon(new ImageIcon("../FlipCard/Img/Cardusr1.png")); break;
							case 2 : Card15.setIcon(new ImageIcon("../FlipCard/Img/Cardusr2.png")); break;
							case 3 : Card15.setIcon(new ImageIcon("../FlipCard/Img/Cardusr3.png")); break;
							case 4 : Card15.setIcon(new ImageIcon("../FlipCard/Img/Cardusr4.png")); break;
							}
						}
					});
					Card15.setIcon(new ImageIcon("../FlipCard/Img/Cardfirst.png"));
					Card15.setForeground(new Color(255, 255, 255));
					Card15.setBackground(new Color(211, 211, 211));
					Card15.setBounds(339, 352, 97, 104);
					layeredPane.add(Card15);
		
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
				if(Timertime > -1) {
					Timershow.setText(showTimertime);
					Timertime--;
				}
				else{
					Card0.setIcon(new ImageIcon("../FlipCard/Img/Cardfirst.png"));
					Card1.setIcon(new ImageIcon("../FlipCard/Img/Cardfirst.png"));
					Card2.setIcon(new ImageIcon("../FlipCard/Img/Cardfirst.png"));
					Card3.setIcon(new ImageIcon("../FlipCard/Img/Cardfirst.png"));
					Card4.setIcon(new ImageIcon("../FlipCard/Img/Cardfirst.png"));
					Card5.setIcon(new ImageIcon("../FlipCard/Img/Cardfirst.png"));
					Card6.setIcon(new ImageIcon("../FlipCard/Img/Cardfirst.png"));
					Card7.setIcon(new ImageIcon("../FlipCard/Img/Cardfirst.png"));
					Card8.setIcon(new ImageIcon("../FlipCard/Img/Cardfirst.png"));
					Card9.setIcon(new ImageIcon("../FlipCard/Img/Cardfirst.png"));
					Card10.setIcon(new ImageIcon("../FlipCard/Img/Cardfirst.png"));
					Card11.setIcon(new ImageIcon("../FlipCard/Img/Cardfirst.png"));
					Card12.setIcon(new ImageIcon("../FlipCard/Img/Cardfirst.png"));
					Card13.setIcon(new ImageIcon("../FlipCard/Img/Cardfirst.png"));
					Card14.setIcon(new ImageIcon("../FlipCard/Img/Cardfirst.png"));
					Card15.setIcon(new ImageIcon("../FlipCard/Img/Cardfirst.png"));
				}
			}
		};
	      jobScheduler.scheduleAtFixedRate(Timerjob, 1000, 1000);
	      

	    
	}
	
		
}


