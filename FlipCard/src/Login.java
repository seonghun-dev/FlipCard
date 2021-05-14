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

public class Login {

	public JFrame frmFlipCard;
	private JTextField username;

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
				JOptionPane.showMessageDialog(frmFlipCard, "로그인이 완료되었습니다.");
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

	public Object Login() {
		// TODO Auto-generated method stub
		return null;
	}
}

