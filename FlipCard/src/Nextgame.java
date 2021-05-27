import java.awt.BorderLayout;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;

public class Nextgame extends JDialog {

	private final JPanel contentPanel = new JPanel();
	public JLabel ResultLabel = new JLabel("");
	private final JButton Replaybtn = new JButton("");
	public boolean regame = false;

	/**
	 * Create the dialog.
	 */
	public Nextgame() {
		setTitle("Result");
		setIconImage(Toolkit.getDefaultToolkit().getImage("../FlipCard/Img/icon.png"));
		setBounds(100, 100, 450, 290);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		ResultLabel.setIcon(new ImageIcon("C:\\Users\\seong\\Desktop\\win_blue.png"));

		ResultLabel.setBackground(Color.DARK_GRAY);
		ResultLabel.setBounds(12, 10, 410, 191);
		contentPanel.add(ResultLabel);

		JButton Shutdown = new JButton("");
		Shutdown.setIcon(new ImageIcon("D:\\Documnet\\logout.png"));
		Shutdown.setBackground(Color.LIGHT_GRAY);
		Shutdown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		Shutdown.setBounds(12, 200, 98, 40);

		contentPanel.add(Shutdown);
		Replaybtn.setIcon(new ImageIcon("D:\\Documnet\\Replay.png"));
		Replaybtn.setBackground(Color.LIGHT_GRAY);
		Replaybtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				regame = true;
			}
		});
		Replaybtn.setBounds(108, 200, 314, 40);

		contentPanel.add(Replaybtn);
		{
			{
				setVisible(false);
			}
		}
	}

	public void ShowWinner(int winnernum) {
		switch (winnernum) {
		case 1:
			ResultLabel.setIcon(new ImageIcon("../FlipCard/Img/win_brown.png"));
			break;
		case 2:
			ResultLabel.setIcon(new ImageIcon("../FlipCard/Img/win_blue.png"));
			break;
		case 3:
			ResultLabel.setIcon(new ImageIcon("../FlipCard/Img/win_pink.png"));
			break;
		case 4:
			ResultLabel.setIcon(new ImageIcon("../FlipCard/Img/win_green.png"));
			break;
		}
	}
}