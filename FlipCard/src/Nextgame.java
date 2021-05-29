
/**Nextgame
 *This Class Means Nextgame
 *
 */

import java.awt.BorderLayout;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kr.ac.konkuk.ccslab.cm.event.CMDummyEvent;
import kr.ac.konkuk.ccslab.cm.stub.CMClientStub;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;

public class Nextgame extends JDialog {

	private final JPanel contentPanel = new JPanel();
	public JLabel ResultLabel = new JLabel("");
	private final JButton Replaybtn = new JButton("");
	public boolean regame = false;
	
	   FlipCardClient m_client;

	/**
	 * Create the dialog.
	 */
	public Nextgame(FlipCardClient client) {
		setTitle("Result");
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("../FlipCard/Img/icon.png"));
		setBounds(100, 100, 450, 290);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		ResultLabel.setBackground(Color.DARK_GRAY);
		ResultLabel.setBounds(12, 10, 410, 191);
		contentPanel.add(ResultLabel);

		JButton Shutdown = new JButton("");
		Shutdown.setIcon(new ImageIcon("D:\\Documnet\\logout.png"));
		Shutdown.setBackground(Color.LIGHT_GRAY);
		Shutdown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				m_client.m_clientStub.terminateCM();
				System.exit(0);
			}
		});
		Shutdown.setBounds(12, 200, 98, 40);

		contentPanel.add(Shutdown);
		Replaybtn.setIcon(new ImageIcon("D:\\Documnet\\Replay.png"));
		Replaybtn.setBackground(Color.LIGHT_GRAY);
		Replaybtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		Replaybtn.setBounds(108, 200, 314, 40);
		contentPanel.add(Replaybtn);
	}

	public void ShowWinner(String winner) {
		switch (winner) {
		case "BROWN":
			ResultLabel.setIcon(new ImageIcon("../FlipCard/Img/win_brown.png"));
			break;
		case "BLUE":
			ResultLabel.setIcon(new ImageIcon("../FlipCard/Img/win_blue.png"));
			break;
		case "PINK":
			ResultLabel.setIcon(new ImageIcon("../FlipCard/Img/win_pink.png"));
			break;
		case "GREEN":
			ResultLabel.setIcon(new ImageIcon("../FlipCard/Img/win_green.png"));
			break;
		}
	}
}