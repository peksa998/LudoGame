package client;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JTextField;

public class LudoGame extends JFrame {

	private JPanel contentPane;
	private JLabel lblBackgroundGame;
	private JLabel lblBoard;
	private JLabel lblPlayerYou;
	private JLabel lblPlayer2;
	private JLabel lblPlayer3;
	private JLabel lblPlayer4;
	private JLabel lblDiceBackPlayer2;
	private JLabel lblDiceBackPlayer3;
	private JLabel lblDiceBackPlayer4;
	private JLabel lblPawnRed1;
	private JLabel lblPawnRed2;
	private JLabel lblPawnRed3;
	private JLabel lblPawnRed4;
	private JLabel lblPawnYellow1;
	private JLabel lblPawnYellow2;
	private JLabel lblPawnYellow3;
	private JLabel lblPawnYellow4;
	private JLabel lblPawnBlue1;
	private JLabel lblPawnBlue2;
	private JLabel lblPawnBlue3;
	private JLabel lblPawnBlue4;
	private JLabel lblPawnGreen1;
	private JLabel lblPawnGreen2;
	private JLabel lblPawnGreen3;
	private JLabel lblPawnGreen4;
	private JLabel lblNamePlayerYou;
	private JLabel lblNamePlayer2;
	private JLabel lblNamePlayer3;
	private JLabel lblNamePlayer4;
	private JLabel lblDicePlayer2;
	private JLabel lblDicePlayer3;
	private JLabel lblDicePlayer4;
	private JLabel lblExit;
	private JLabel lblSettings;
	private JLabel lblDiceBackRed;
	private JLabel lblDiceRed;
	private JLabel lblChatBack;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LudoGame frame = new LudoGame();
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
	public LudoGame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(LudoGame.class.getResource("/Resource/ludo1.png")));
		setTitle("Ludo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1640, 880);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblPawnRed1());
		contentPane.add(getLblPawnRed2());
		contentPane.add(getLblPawnRed3());
		contentPane.add(getLblPawnRed4());
		contentPane.add(getLblPawnYellow1());
		contentPane.add(getLblPawnYellow2());
		contentPane.add(getLblPawnYellow3());
		contentPane.add(getLblPawnYellow4());
		contentPane.add(getLblPawnBlue1());
		contentPane.add(getLblPawnBlue2());
		contentPane.add(getLblPawnBlue3());
		contentPane.add(getLblPawnBlue4());
		contentPane.add(getLblPawnGreen1());
		contentPane.add(getLblPawnGreen2());
		contentPane.add(getLblPawnGreen3());
		contentPane.add(getLblPawnGreen4());
		contentPane.add(getLblNamePlayerYou());
		contentPane.add(getLblNamePlayer2());
		contentPane.add(getLblNamePlayer3());
		contentPane.add(getLblNamePlayer4());
		contentPane.add(getLblBoard());
		contentPane.add(getLblPlayerYou());
		contentPane.add(getLblPlayer2());
		contentPane.add(getLblPlayer3());
		contentPane.add(getLblPlayer4());
		contentPane.add(getLblDicePlayer2());
		contentPane.add(getLblDicePlayer3());
		contentPane.add(getLblDicePlayer4());
		contentPane.add(getLblDiceBackPlayer2());
		contentPane.add(getLblDiceBackPlayer3());
		contentPane.add(getLblDiceBackPlayer4());
		contentPane.add(getLblDiceRed());
		contentPane.add(getLblDiceBackRed());
		contentPane.add(getLblExit());
		contentPane.add(getLblSettings());
		contentPane.add(getLblChatBack());
		contentPane.add(getLblBackgroundGame());
	}
	private JLabel getLblBackgroundGame() {
		if (lblBackgroundGame == null) {
			lblBackgroundGame = new JLabel("");
			lblBackgroundGame.setIcon(new ImageIcon(LudoGame.class.getResource("/Resource/backgroundGame.png")));
			lblBackgroundGame.setBounds(0, 0, 2400, 2214);
		}
		return lblBackgroundGame;
	}
	private JLabel getLblBoard() {
		if (lblBoard == null) {
			lblBoard = new JLabel("");
			lblBoard.setIcon(new ImageIcon(LudoGame.class.getResource("/Resource/board (3) (2).png")));
			lblBoard.setBounds(270, 40, 770, 769);
		}
		return lblBoard;
	}
	public JLabel getLblPlayerYou() {
		if (lblPlayerYou == null) {
			lblPlayerYou = new JLabel("");
			lblPlayerYou.setIcon(new ImageIcon(LudoGame.class.getResource("/Resource/Rededge (6).png")));
			lblPlayerYou.setBounds(1064, 87, 220, 60);
		}
		return lblPlayerYou;
	}
	public JLabel getLblPlayer2() {
		if (lblPlayer2 == null) {
			lblPlayer2 = new JLabel("");
			lblPlayer2.setIcon(new ImageIcon(LudoGame.class.getResource("/Resource/Blueedge (5).png")));
			lblPlayer2.setBounds(22, 502, 220, 60);
		}
		return lblPlayer2;
	}
	public JLabel getLblPlayer3() {
		if (lblPlayer3 == null) {
			lblPlayer3 = new JLabel("");
			lblPlayer3.setIcon(new ImageIcon(LudoGame.class.getResource("/Resource/Greenedge (8).png")));
			lblPlayer3.setBounds(1064, 502, 220, 60);
		}
		return lblPlayer3;
	}
	public JLabel getLblPlayer4() {
		if (lblPlayer4 == null) {
			lblPlayer4 = new JLabel("");
			lblPlayer4.setIcon(new ImageIcon(LudoGame.class.getResource("/Resource/Yellowedge (7).png")));
			lblPlayer4.setBounds(22, 92, 220, 60);
		}
		return lblPlayer4;
	}
	private JLabel getLblDiceBackPlayer2() {
		if (lblDiceBackPlayer2 == null) {
			lblDiceBackPlayer2 = new JLabel("");
			lblDiceBackPlayer2.setIcon(new ImageIcon(LudoGame.class.getResource("/Resource/edgeDice (5).png")));
			lblDiceBackPlayer2.setBounds(55, 575, 150, 150);
		}
		return lblDiceBackPlayer2;
	}
	private JLabel getLblDiceBackPlayer3() {
		if (lblDiceBackPlayer3 == null) {
			lblDiceBackPlayer3 = new JLabel("");
			lblDiceBackPlayer3.setIcon(new ImageIcon(LudoGame.class.getResource("/Resource/edgeDice (5).png")));
			lblDiceBackPlayer3.setBounds(1100, 575, 150, 150);
		}
		return lblDiceBackPlayer3;
	}
	private JLabel getLblDiceBackPlayer4() {
		if (lblDiceBackPlayer4 == null) {
			lblDiceBackPlayer4 = new JLabel("");
			lblDiceBackPlayer4.setIcon(new ImageIcon(LudoGame.class.getResource("/Resource/edgeDice (5).png")));
			lblDiceBackPlayer4.setBounds(55, 160, 150, 150);
		}
		return lblDiceBackPlayer4;
	}
	private JLabel getLblPawnRed1() {
		if (lblPawnRed1 == null) {
			lblPawnRed1 = new JLabel("");
			lblPawnRed1.setIcon(new ImageIcon(LudoGame.class.getResource("/Resource/pawnRedTable.png")));
			lblPawnRed1.setBounds(805, 85, 65, 92);
		}
		return lblPawnRed1;
	}
	private JLabel getLblPawnRed2() {
		if (lblPawnRed2 == null) {
			lblPawnRed2 = new JLabel("");
			lblPawnRed2.setIcon(new ImageIcon(LudoGame.class.getResource("/Resource/pawnRedTable.png")));
			lblPawnRed2.setBounds(903, 85, 65, 92);
		}
		return lblPawnRed2;
	}
	private JLabel getLblPawnRed3() {
		if (lblPawnRed3 == null) {
			lblPawnRed3 = new JLabel("");
			lblPawnRed3.setIcon(new ImageIcon(LudoGame.class.getResource("/Resource/pawnRedTable.png")));
			lblPawnRed3.setBounds(805, 173, 65, 92);
		}
		return lblPawnRed3;
	}
	private JLabel getLblPawnRed4() {
		if (lblPawnRed4 == null) {
			lblPawnRed4 = new JLabel("");
			lblPawnRed4.setIcon(new ImageIcon(LudoGame.class.getResource("/Resource/pawnRedTable.png")));
			lblPawnRed4.setBounds(903, 173, 65, 92);
		}
		return lblPawnRed4;
	}
	private JLabel getLblPawnYellow1() {
		if (lblPawnYellow1 == null) {
			lblPawnYellow1 = new JLabel("");
			lblPawnYellow1.setIcon(new ImageIcon(LudoGame.class.getResource("/Resource/pawnYellowTable.png")));
			lblPawnYellow1.setBounds(342, 85, 65, 92);
		}
		return lblPawnYellow1;
	}
	private JLabel getLblPawnYellow2() {
		if (lblPawnYellow2 == null) {
			lblPawnYellow2 = new JLabel("");
			lblPawnYellow2.setIcon(new ImageIcon(LudoGame.class.getResource("/Resource/pawnYellowTable.png")));
			lblPawnYellow2.setBounds(440, 85, 65, 92);
		}
		return lblPawnYellow2;
	}
	private JLabel getLblPawnYellow3() {
		if (lblPawnYellow3 == null) {
			lblPawnYellow3 = new JLabel("");
			lblPawnYellow3.setIcon(new ImageIcon(LudoGame.class.getResource("/Resource/pawnYellowTable.png")));
			lblPawnYellow3.setBounds(342, 173, 65, 92);
		}
		return lblPawnYellow3;
	}
	private JLabel getLblPawnYellow4() {
		if (lblPawnYellow4 == null) {
			lblPawnYellow4 = new JLabel("");
			lblPawnYellow4.setIcon(new ImageIcon(LudoGame.class.getResource("/Resource/pawnYellowTable.png")));
			lblPawnYellow4.setBounds(440, 173, 65, 92);
		}
		return lblPawnYellow4;
	}
	private JLabel getLblPawnBlue1() {
		if (lblPawnBlue1 == null) {
			lblPawnBlue1 = new JLabel("");
			lblPawnBlue1.setIcon(new ImageIcon(LudoGame.class.getResource("/Resource/pawnBlueTable.png")));
			lblPawnBlue1.setBounds(342, 550, 65, 92);
		}
		return lblPawnBlue1;
	}
	private JLabel getLblPawnBlue2() {
		if (lblPawnBlue2 == null) {
			lblPawnBlue2 = new JLabel("");
			lblPawnBlue2.setIcon(new ImageIcon(LudoGame.class.getResource("/Resource/pawnBlueTable.png")));
			lblPawnBlue2.setBounds(440, 550, 65, 92);
		}
		return lblPawnBlue2;
	}
	private JLabel getLblPawnBlue3() {
		if (lblPawnBlue3 == null) {
			lblPawnBlue3 = new JLabel("");
			lblPawnBlue3.setIcon(new ImageIcon(LudoGame.class.getResource("/Resource/pawnBlueTable.png")));
			lblPawnBlue3.setBounds(342, 635, 65, 92);
		}
		return lblPawnBlue3;
	}
	private JLabel getLblPawnBlue4() {
		if (lblPawnBlue4 == null) {
			lblPawnBlue4 = new JLabel("");
			lblPawnBlue4.setIcon(new ImageIcon(LudoGame.class.getResource("/Resource/pawnBlueTable.png")));
			lblPawnBlue4.setBounds(440, 635, 65, 92);
		}
		return lblPawnBlue4;
	}
	private JLabel getLblPawnGreen1() {
		if (lblPawnGreen1 == null) {
			lblPawnGreen1 = new JLabel("");
			lblPawnGreen1.setIcon(new ImageIcon(LudoGame.class.getResource("/Resource/pawnGreenTable.png")));
			lblPawnGreen1.setBounds(805, 550, 65, 92);
		}
		return lblPawnGreen1;
	}
	private JLabel getLblPawnGreen2() {
		if (lblPawnGreen2 == null) {
			lblPawnGreen2 = new JLabel("");
			lblPawnGreen2.setIcon(new ImageIcon(LudoGame.class.getResource("/Resource/pawnGreenTable.png")));
			lblPawnGreen2.setBounds(903, 550, 65, 92);
		}
		return lblPawnGreen2;
	}
	private JLabel getLblPawnGreen3() {
		if (lblPawnGreen3 == null) {
			lblPawnGreen3 = new JLabel("");
			lblPawnGreen3.setIcon(new ImageIcon(LudoGame.class.getResource("/Resource/pawnGreenTable.png")));
			lblPawnGreen3.setBounds(805, 635, 65, 92);
		}
		return lblPawnGreen3;
	}
	private JLabel getLblPawnGreen4() {
		if (lblPawnGreen4 == null) {
			lblPawnGreen4 = new JLabel("");
			lblPawnGreen4.setIcon(new ImageIcon(LudoGame.class.getResource("/Resource/pawnGreenTable.png")));
			lblPawnGreen4.setBounds(903, 635, 65, 92);
		}
		return lblPawnGreen4;
	}
	public JLabel getLblNamePlayerYou() {
		if (lblNamePlayerYou == null) {
			lblNamePlayerYou = new JLabel("player1");
			lblNamePlayerYou.setForeground(new Color(255, 255, 0));
			lblNamePlayerYou.setHorizontalAlignment(SwingConstants.CENTER);
			lblNamePlayerYou.setFont(new Font("Showcard Gothic", Font.PLAIN, 22));
			lblNamePlayerYou.setBounds(1090, 104, 161, 29);
		}
		return lblNamePlayerYou;
	}
	public JLabel getLblNamePlayer2() {
		if (lblNamePlayer2 == null) {
			lblNamePlayer2 = new JLabel("player2");
			lblNamePlayer2.setHorizontalAlignment(SwingConstants.CENTER);
			lblNamePlayer2.setForeground(Color.YELLOW);
			lblNamePlayer2.setFont(new Font("Showcard Gothic", Font.PLAIN, 22));
			lblNamePlayer2.setBounds(55, 516, 161, 29);
		}
		return lblNamePlayer2;
	}
	public JLabel getLblNamePlayer3() {
		if (lblNamePlayer3 == null) {
			lblNamePlayer3 = new JLabel("player3");
			lblNamePlayer3.setHorizontalAlignment(SwingConstants.CENTER);
			lblNamePlayer3.setForeground(Color.YELLOW);
			lblNamePlayer3.setFont(new Font("Showcard Gothic", Font.PLAIN, 22));
			lblNamePlayer3.setBounds(1097, 518, 161, 29);
		}
		return lblNamePlayer3;
	}
	public JLabel getLblNamePlayer4() {
		if (lblNamePlayer4 == null) {
			lblNamePlayer4 = new JLabel("player4");
			lblNamePlayer4.setHorizontalAlignment(SwingConstants.CENTER);
			lblNamePlayer4.setForeground(Color.YELLOW);
			lblNamePlayer4.setFont(new Font("Showcard Gothic", Font.PLAIN, 22));
			lblNamePlayer4.setBounds(55, 106, 161, 29);
		}
		return lblNamePlayer4;
	}
	private JLabel getLblDicePlayer2() {
		if (lblDicePlayer2 == null) {
			lblDicePlayer2 = new JLabel("");
			lblDicePlayer2.setIcon(new ImageIcon(LudoGame.class.getResource("/Resource/diceAllYouFinal.png")));
			lblDicePlayer2.setBounds(85, 605, 90, 90);
		}
		return lblDicePlayer2;
	}
	private JLabel getLblDicePlayer3() {
		if (lblDicePlayer3 == null) {
			lblDicePlayer3 = new JLabel("");
			lblDicePlayer3.setIcon(new ImageIcon(LudoGame.class.getResource("/Resource/diceAllYouFinal.png")));
			lblDicePlayer3.setBounds(1131, 605, 90, 90);
		}
		return lblDicePlayer3;
	}
	private JLabel getLblDicePlayer4() {
		if (lblDicePlayer4 == null) {
			lblDicePlayer4 = new JLabel("");
			lblDicePlayer4.setIcon(new ImageIcon(LudoGame.class.getResource("/Resource/diceAllYouFinal.png")));
			lblDicePlayer4.setBounds(85, 190, 90, 90);
		}
		return lblDicePlayer4;
	}
	private JLabel getLblExit() {
		if (lblExit == null) {
			lblExit = new JLabel("");
			lblExit.setIcon(new ImageIcon(LudoGame.class.getResource("/Resource/exit (3).png")));
			lblExit.setBounds(1510, 27, 50, 50);
		}
		return lblExit;
	}
	private JLabel getLblSettings() {
		if (lblSettings == null) {
			lblSettings = new JLabel("");
			lblSettings.setIcon(new ImageIcon(LudoGame.class.getResource("/Resource/settings (1).png")));
			lblSettings.setBounds(1441, 27, 50, 50);
		}
		return lblSettings;
	}
	private JLabel getLblDiceBackRed() {
		if (lblDiceBackRed == null) {
			lblDiceBackRed = new JLabel("");
			lblDiceBackRed.setIcon(new ImageIcon(LudoGame.class.getResource("/Resource/edgeDice (5).png")));
			lblDiceBackRed.setBounds(1100, 160, 150, 150);
		}
		return lblDiceBackRed;
	}
	private JLabel getLblDiceRed() {
		if (lblDiceRed == null) {
			lblDiceRed = new JLabel("");
			lblDiceRed.setIcon(new ImageIcon(LudoGame.class.getResource("/Resource/diceAllYouFinal.png")));
			lblDiceRed.setBounds(1131, 190, 90, 90);
		}
		return lblDiceRed;
	}
	private JLabel getLblChatBack() {
		if (lblChatBack == null) {
			lblChatBack = new JLabel("");
			lblChatBack.setIcon(new ImageIcon(LudoGame.class.getResource("/Resource/chat.png")));
			lblChatBack.setBounds(1409, 480, 37, -52);
		}
		return lblChatBack;
	}
}
