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
	public int indexofColorID=1;
	public JButton Card0;
	public JButton Card1;
	public JButton Card2;
	public JButton Card3;
	public JButton Card4;
	public JButton Card5;
	public JButton Card6;
	public JButton Card7;
	public JButton Card8;
	public JButton Card9;
	public JButton Card10;
	public JButton Card11;
	public JButton Card12;
	public JButton Card13;
	public JButton Card14;
	public JButton Card15;
	public JLabel Timershow;
	
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
		
			JLabel BrownUsr = new JLabel("새로운 유저");
			BrownUsr.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					indexofColorID=1;
				}
			});
			
			JLayeredPane layeredPane = new JLayeredPane();
			layeredPane.setBackground(new Color(255, 192, 203));
			layeredPane.setBounds(12, 10, 448, 472);
			contentPane.add(layeredPane);
			

			
			JButton Card0_1 = new JButton("");
			Card0_1.setIcon(new ImageIcon("../FlipCard/Img/Cardfirst.png"));
			Card0_1.setForeground(new Color(255, 255, 255));
			Card0_1.setBackground(new Color(211, 211, 211));
			Card0_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					switch(indexofColorID) {
					case 1 : Card0_1.setIcon(new ImageIcon("../FlipCard/Img/Cardusr1.png")); break;
					case 2 : Card0_1.setIcon(new ImageIcon("../FlipCard/Img/Cardusr2.png")); break;
					case 3 : Card0_1.setIcon(new ImageIcon("../FlipCard/Img/Cardusr3.png")); break;
					case 4 : Card0_1.setIcon(new ImageIcon("../FlipCard/Img/Cardusr4.png")); break;
					}
				}
			});
			Card0_1.setBounds(12, 10, 97, 104);
			layeredPane.add(Card0_1);
			
			
			
			JButton Card1_1 = new JButton("");
			Card1_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					switch(indexofColorID) {
					case 1 : Card1_1.setIcon(new ImageIcon("../FlipCard/Img/Cardusr1.png")); break;
					case 2 : Card1_1.setIcon(new ImageIcon("../FlipCard/Img/Cardusr2.png")); break;
					case 3 : Card1_1.setIcon(new ImageIcon("../FlipCard/Img/Cardusr3.png")); break;
					case 4 : Card1_1.setIcon(new ImageIcon("../FlipCard/Img/Cardusr4.png")); break;
					}
				}
			});
			Card1_1.setIcon(new ImageIcon("../FlipCard/Img/Cardfirst.png"));
			Card1_1.setForeground(new Color(255, 255, 255));
			Card1_1.setBackground(new Color(211, 211, 211));
			Card1_1.setBounds(121, 10, 97, 104);
			layeredPane.add(Card1_1);
			
			
			
			JButton Card2_1 = new JButton("");
			Card2_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e)  {
					switch(indexofColorID) {
					case 1 : Card2_1.setIcon(new ImageIcon("../FlipCard/Img/Cardusr1.png")); break;
					case 2 : Card2_1.setIcon(new ImageIcon("../FlipCard/Img/Cardusr2.png")); break;
					case 3 : Card2_1.setIcon(new ImageIcon("../FlipCard/Img/Cardusr3.png")); break;
					case 4 : Card2_1.setIcon(new ImageIcon("../FlipCard/Img/Cardusr4.png")); break;
					}
				}
			});
			Card2_1.setIcon(new ImageIcon("../FlipCard/Img/Cardfirst.png"));
			Card2_1.setForeground(new Color(255, 255, 255));
			Card2_1.setBackground(new Color(211, 211, 211));
			Card2_1.setBounds(230, 10, 97, 104);
			layeredPane.add(Card2_1);
			
			
			
			
			JButton Card3_1 = new JButton("");
			Card3_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e)  {
					switch(indexofColorID) {
					case 1 : Card3_1.setIcon(new ImageIcon("../FlipCard/Img/Cardusr1.png")); break;
					case 2 : Card3_1.setIcon(new ImageIcon("../FlipCard/Img/Cardusr2.png")); break;
					case 3 : Card3_1.setIcon(new ImageIcon("../FlipCard/Img/Cardusr3.png")); break;
					case 4 : Card3_1.setIcon(new ImageIcon("../FlipCard/Img/Cardusr4.png")); break;
					}
				}
			});
			Card3_1.setIcon(new ImageIcon("../FlipCard/Img/Cardfirst.png"));
			Card3_1.setForeground(new Color(255, 255, 255));
			Card3_1.setBackground(new Color(211, 211, 211));
			Card3_1.setBounds(339, 10, 97, 104);
			layeredPane.add(Card3_1);
			

			JButton Card4_1 = new JButton("");
			Card4_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e)  {
					switch(indexofColorID) {
					case 1 : Card4_1.setIcon(new ImageIcon("../FlipCard/Img/Cardusr1.png")); break;
					case 2 : Card4_1.setIcon(new ImageIcon("../FlipCard/Img/Cardusr2.png")); break;
					case 3 : Card4_1.setIcon(new ImageIcon("../FlipCard/Img/Cardusr3.png")); break;
					case 4 : Card4_1.setIcon(new ImageIcon("../FlipCard/Img/Cardusr4.png")); break;
					}
				}
			});
			Card4_1.setIcon(new ImageIcon("../FlipCard/Img/Cardfirst.png"));
			Card4_1.setForeground(new Color(255, 255, 255));
			Card4_1.setBackground(new Color(211, 211, 211));
			Card4_1.setBounds(12, 124, 97, 104);
			layeredPane.add(Card4_1);
			
			JButton Card5_1 = new JButton("");
			Card5_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e)  {
					switch(indexofColorID) {
					case 1 : Card5_1.setIcon(new ImageIcon("../FlipCard/Img/Cardusr1.png")); break;
					case 2 : Card5_1.setIcon(new ImageIcon("../FlipCard/Img/Cardusr2.png")); break;
					case 3 : Card5_1.setIcon(new ImageIcon("../FlipCard/Img/Cardusr3.png")); break;
					case 4 : Card5_1.setIcon(new ImageIcon("../FlipCard/Img/Cardusr4.png")); break;
					}
				}
			});
			Card5_1.setIcon(new ImageIcon("../FlipCard/Img/Cardfirst.png"));
			Card5_1.setForeground(new Color(255, 255, 255));
			Card5_1.setBackground(new Color(211, 211, 211));
			Card5_1.setBounds(121, 124, 97, 104);
			layeredPane.add(Card5_1);
			
			
			
			JButton Card6_1 = new JButton("");
			Card6_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					switch(indexofColorID) {
					case 1 : Card6_1.setIcon(new ImageIcon("../FlipCard/Img/Cardusr1.png")); break;
					case 2 : Card6_1.setIcon(new ImageIcon("../FlipCard/Img/Cardusr2.png")); break;
					case 3 : Card6_1.setIcon(new ImageIcon("../FlipCard/Img/Cardusr3.png")); break;
					case 4 : Card6_1.setIcon(new ImageIcon("../FlipCard/Img/Cardusr4.png")); break;
					}
				}
			});
			Card6_1.setIcon(new ImageIcon("../FlipCard/Img/Cardfirst.png"));
			Card6_1.setForeground(new Color(255, 255, 255));
			Card6_1.setBackground(new Color(211, 211, 211));
			Card6_1.setBounds(230, 124, 97, 104);
			layeredPane.add(Card6_1);
			
			
			JButton Card7_1 = new JButton("");
			Card7_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					switch(indexofColorID) {
					case 1 : Card7_1.setIcon(new ImageIcon("../FlipCard/Img/Cardusr1.png")); break;
					case 2 : Card7_1.setIcon(new ImageIcon("../FlipCard/Img/Cardusr2.png")); break;
					case 3 : Card7_1.setIcon(new ImageIcon("../FlipCard/Img/Cardusr3.png")); break;
					case 4 : Card7_1.setIcon(new ImageIcon("../FlipCard/Img/Cardusr4.png")); break;
					}
				}
			});
			Card7_1.setIcon(new ImageIcon("../FlipCard/Img/Cardfirst.png"));
			Card7_1.setForeground(new Color(255, 255, 255));
			Card7_1.setBackground(new Color(211, 211, 211));
			Card7_1.setBounds(339, 124, 97, 104);
			layeredPane.add(Card7_1);
			
					JButton Card8_1 = new JButton("");
					Card8_1.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							switch(indexofColorID) {
							case 1 : Card8_1.setIcon(new ImageIcon("../FlipCard/Img/Cardusr1.png")); break;
							case 2 : Card8_1.setIcon(new ImageIcon("../FlipCard/Img/Cardusr2.png")); break;
							case 3 : Card8_1.setIcon(new ImageIcon("../FlipCard/Img/Cardusr3.png")); break;
							case 4 : Card8_1.setIcon(new ImageIcon("../FlipCard/Img/Cardusr4.png")); break;
							}
						}
					});
					Card8_1.setIcon(new ImageIcon("../FlipCard/Img/Cardfirst.png"));
					Card8_1.setForeground(new Color(255, 255, 255));
					Card8_1.setBackground(new Color(211, 211, 211));
					Card8_1.setBounds(12, 238, 97, 104);
					layeredPane.add(Card8_1);
					
					
					JButton Card9_1 = new JButton("");
					Card9_1.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							switch(indexofColorID) {
							case 1 : Card9_1.setIcon(new ImageIcon("../FlipCard/Img/Cardusr1.png")); break;
							case 2 : Card9_1.setIcon(new ImageIcon("../FlipCard/Img/Cardusr2.png")); break;
							case 3 : Card9_1.setIcon(new ImageIcon("../FlipCard/Img/Cardusr3.png")); break;
							case 4 : Card9_1.setIcon(new ImageIcon("../FlipCard/Img/Cardusr4.png")); break;
							}
						}
					});
					Card9_1.setIcon(new ImageIcon("../FlipCard/Img/Cardfirst.png"));
					Card9_1.setForeground(new Color(255, 255, 255));
					Card9_1.setBackground(new Color(211, 211, 211));
					Card9_1.setBounds(121, 238, 97, 104);
					layeredPane.add(Card9_1);
					
					
					
					JButton Card10_1 = new JButton("");
					Card10_1.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							switch(indexofColorID) {
							case 1 : Card10_1.setIcon(new ImageIcon("../FlipCard/Img/Cardusr1.png")); break;
							case 2 : Card10_1.setIcon(new ImageIcon("../FlipCard/Img/Cardusr2.png")); break;
							case 3 : Card10_1.setIcon(new ImageIcon("../FlipCard/Img/Cardusr3.png")); break;
							case 4 : Card10_1.setIcon(new ImageIcon("../FlipCard/Img/Cardusr4.png")); break;
							}
						}
					});
					Card10_1.setIcon(new ImageIcon("../FlipCard/Img/Cardfirst.png"));
					Card10_1.setForeground(new Color(255, 255, 255));
					Card10_1.setBackground(new Color(211, 211, 211));
					Card10_1.setBounds(230, 238, 97, 104);
					layeredPane.add(Card10_1);		
					
					
					
					JButton Card11_1 = new JButton("");
					Card11_1.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							switch(indexofColorID) {
							case 1 : Card11_1.setIcon(new ImageIcon("../FlipCard/Img/Cardusr1.png")); break;
							case 2 : Card11_1.setIcon(new ImageIcon("../FlipCard/Img/Cardusr2.png")); break;
							case 3 : Card11_1.setIcon(new ImageIcon("../FlipCard/Img/Cardusr3.png")); break;
							case 4 : Card11_1.setIcon(new ImageIcon("../FlipCard/Img/Cardusr4.png")); break;
							}
						}
					});
					Card11_1.setIcon(new ImageIcon("../FlipCard/Img/Cardfirst.png"));
					Card11_1.setForeground(new Color(255, 255, 255));
					Card11_1.setBackground(new Color(211, 211, 211));
					Card11_1.setBounds(339, 238, 97, 104);
					layeredPane.add(Card11_1);
					
					
					
					JButton Card12_1 = new JButton("");
					Card12_1.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							switch(indexofColorID) {
							case 1 : Card12_1.setIcon(new ImageIcon("../FlipCard/Img/Cardusr1.png")); break;
							case 2 : Card12_1.setIcon(new ImageIcon("../FlipCard/Img/Cardusr2.png")); break;
							case 3 : Card12_1.setIcon(new ImageIcon("../FlipCard/Img/Cardusr3.png")); break;
							case 4 : Card12_1.setIcon(new ImageIcon("../FlipCard/Img/Cardusr4.png")); break;
							}
						}
					});
					Card12_1.setIcon(new ImageIcon("../FlipCard/Img/Cardfirst.png"));
					Card12_1.setForeground(new Color(255, 255, 255));
					Card12_1.setBackground(new Color(211, 211, 211));
					Card12_1.setBounds(12, 352, 97, 104);
					layeredPane.add(Card12_1);
					
					
					
					JButton Card13_1 = new JButton("");
					Card13_1.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							switch(indexofColorID) {
							case 1 : Card13_1.setIcon(new ImageIcon("../FlipCard/Img/Cardusr1.png")); break;
							case 2 : Card13_1.setIcon(new ImageIcon("../FlipCard/Img/Cardusr2.png")); break;
							case 3 : Card13_1.setIcon(new ImageIcon("../FlipCard/Img/Cardusr3.png")); break;
							case 4 : Card13_1.setIcon(new ImageIcon("../FlipCard/Img/Cardusr4.png")); break;
							}
						}
					});
					Card13_1.setIcon(new ImageIcon("../FlipCard/Img/Cardfirst.png"));
					Card13_1.setForeground(new Color(255, 255, 255));
					Card13_1.setBackground(new Color(211, 211, 211));
					Card13_1.setBounds(121, 352, 97, 104);
					layeredPane.add(Card13_1);
					
					
					
					JButton Card14_1 = new JButton("");
					Card14_1.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							switch(indexofColorID) {
							case 1 : Card14_1.setIcon(new ImageIcon("../FlipCard/Img/Cardusr1.png")); break;
							case 2 : Card14_1.setIcon(new ImageIcon("../FlipCard/Img/Cardusr2.png")); break;
							case 3 : Card14_1.setIcon(new ImageIcon("../FlipCard/Img/Cardusr3.png")); break;
							case 4 : Card14_1.setIcon(new ImageIcon("../FlipCard/Img/Cardusr4.png")); break;
							}
						}
					});
					Card14_1.setIcon(new ImageIcon("../FlipCard/Img/Cardfirst.png"));
					Card14_1.setForeground(new Color(255, 255, 255));
					Card14_1.setBackground(new Color(211, 211, 211));
					Card14_1.setBounds(230, 352, 97, 104);
					layeredPane.add(Card14_1);
					
					JButton Card15_1 = new JButton("");
					Card15_1.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							switch(indexofColorID) {
							case 1 : Card15_1.setIcon(new ImageIcon("../FlipCard/Img/Cardusr1.png")); break;
							case 2 : Card15_1.setIcon(new ImageIcon("../FlipCard/Img/Cardusr2.png")); break;
							case 3 : Card15_1.setIcon(new ImageIcon("../FlipCard/Img/Cardusr3.png")); break;
							case 4 : Card15_1.setIcon(new ImageIcon("../FlipCard/Img/Cardusr4.png")); break;
							}
						}
					});
					Card15_1.setIcon(new ImageIcon("../FlipCard/Img/Cardfirst.png"));
					Card15_1.setForeground(new Color(255, 255, 255));
					Card15_1.setBackground(new Color(211, 211, 211));
					Card15_1.setBounds(339, 352, 97, 104);
					layeredPane.add(Card15_1);
			BrownUsr.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
			BrownUsr.setBounds(522, 60, 80, 20);
			contentPane.add(BrownUsr);
		
		JLabel BlueUsr = new JLabel("새로운 유저");
		BlueUsr.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				indexofColorID=2;
			}
		});
		BlueUsr.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		BlueUsr.setBounds(522, 84, 80, 20);
		contentPane.add(BlueUsr);
		
		JLabel PinkUsr = new JLabel("새로운 유저");
		PinkUsr.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				indexofColorID=3;
			}
		});
		PinkUsr.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		PinkUsr.setBounds(522, 107, 80, 20);
		contentPane.add(PinkUsr);
		

		
		JLabel GreenUsr = new JLabel("새로운 유저");
		GreenUsr.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				indexofColorID=4;
			}
		});
		GreenUsr.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		GreenUsr.setBounds(522, 131, 80, 20);
		contentPane.add(GreenUsr);
		

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
					Card0_1.setIcon(new ImageIcon("../FlipCard/Img/Cardfirst.png"));
					Card1_1.setIcon(new ImageIcon("../FlipCard/Img/Cardfirst.png"));
					Card2_1.setIcon(new ImageIcon("../FlipCard/Img/Cardfirst.png"));
					Card3_1.setIcon(new ImageIcon("../FlipCard/Img/Cardfirst.png"));
					Card4_1.setIcon(new ImageIcon("../FlipCard/Img/Cardfirst.png"));
					Card5_1.setIcon(new ImageIcon("../FlipCard/Img/Cardfirst.png"));
					Card6_1.setIcon(new ImageIcon("../FlipCard/Img/Cardfirst.png"));
					Card7_1.setIcon(new ImageIcon("../FlipCard/Img/Cardfirst.png"));
					Card8_1.setIcon(new ImageIcon("../FlipCard/Img/Cardfirst.png"));
					Card9_1.setIcon(new ImageIcon("../FlipCard/Img/Cardfirst.png"));
					Card10_1.setIcon(new ImageIcon("../FlipCard/Img/Cardfirst.png"));
					Card11_1.setIcon(new ImageIcon("../FlipCard/Img/Cardfirst.png"));
					Card12_1.setIcon(new ImageIcon("../FlipCard/Img/Cardfirst.png"));
					Card13_1.setIcon(new ImageIcon("../FlipCard/Img/Cardfirst.png"));
					Card14_1.setIcon(new ImageIcon("../FlipCard/Img/Cardfirst.png"));
					Card15_1.setIcon(new ImageIcon("../FlipCard/Img/Cardfirst.png"));
				}
			}
		};
	      jobScheduler.scheduleAtFixedRate(Timerjob, 1000, 1000);
	      

	    
	}
	
		
}


