package gui;

import javax.swing.*;

import Battle.Battle;
import Battle.Player;
import Calcuration.Unit;

import java.awt.*;

public class BattleGUI extends JFrame {
	public BattleGUI(Player p1, Player p2)
	{
		Unit u = new Unit();
		Battle b = new Battle();
		
		JLabel lblWhatTheFuck = new JLabel("\u3147\u3147");
		lblWhatTheFuck.setHorizontalAlignment(SwingConstants.TRAILING);
		lblWhatTheFuck.setForeground(Color.BLUE);
		lblWhatTheFuck.setFont(new Font("µ¸¿òÃ¼", Font.BOLD, 20));
		lblWhatTheFuck.setBounds(313, 33, 535, 69);
		getContentPane().add(lblWhatTheFuck);
		
		JLabel label = new JLabel("\u3147\u3147");
		label.setFont(new Font("µ¸¿òÃ¼", Font.BOLD, 20));
		label.setForeground(Color.RED);
		label.setBounds(43, 38, 594, 59);
		getContentPane().add(label);
		
		label.setText(p1.getName());
		lblWhatTheFuck.setText(p2.getName());
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(247, 153, 405, 710);
		getContentPane().add(textPane);
		
		JLabel label_1 = new JLabel("\uCCB4\uB825 : ");
		label_1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 16));
		label_1.setBounds(19, 167, 64, 32);
		getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("\uACF5\uACA9\uB825 : ");
		label_2.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 16));
		label_2.setBounds(19, 238, 64, 32);
		getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("\uBC29\uC5B4\uB825 : ");
		label_3.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 16));
		label_3.setBounds(18, 278, 64, 32);
		getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("\uB9C8\uBC95 : ");
		label_4.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 16));
		label_4.setBounds(19, 348, 64, 32);
		getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("\uB9C8\uBC95 \uB808\uBCA8 : ");
		label_5.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 16));
		label_5.setBounds(19, 391, 92, 32);
		getContentPane().add(label_5);
		
		JLabel lblMp = new JLabel("MP : ");
		lblMp.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 16));
		lblMp.setBounds(19, 451, 64, 32);
		getContentPane().add(lblMp);
		
		JLabel lblPp = new JLabel("PP : ");
		lblPp.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 16));
		lblPp.setBounds(19, 559, 64, 32);
		getContentPane().add(lblPp);
		
		JLabel label_6 = new JLabel("\uCE58\uBA85\uD0C0\uC728 : ");
		label_6.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 16));
		label_6.setBounds(19, 638, 92, 32);
		getContentPane().add(label_6);
		
		JLabel p1HP = new JLabel("");
		p1HP.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 16));
		p1HP.setBounds(72, 178, 98, 15);
		getContentPane().add(p1HP);
		
		JLabel p1ATK = new JLabel("");
		p1ATK.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 16));
		p1ATK.setBounds(95, 249, 98, 15);
		getContentPane().add(p1ATK);
		
		JLabel p1DEF = new JLabel("");
		p1DEF.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 16));
		p1DEF.setBounds(94, 289, 98, 15);
		getContentPane().add(p1DEF);
		
		JLabel p1Magic = new JLabel("");
		p1Magic.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 16));
		p1Magic.setBounds(72, 359, 98, 15);
		getContentPane().add(p1Magic);
		
		JLabel p1MagicLevel = new JLabel("");
		p1MagicLevel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 16));
		p1MagicLevel.setBounds(111, 402, 98, 15);
		getContentPane().add(p1MagicLevel);
		
		JLabel p1MP = new JLabel("");
		p1MP.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 16));
		p1MP.setBounds(72, 462, 98, 15);
		getContentPane().add(p1MP);
		
		JLabel p1PP = new JLabel("");
		p1PP.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 16));
		p1PP.setBounds(57, 570, 98, 15);
		getContentPane().add(p1PP);
		
		JLabel p1Critic = new JLabel("");
		p1Critic.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 16));
		p1Critic.setBounds(111, 649, 98, 15);
		getContentPane().add(p1Critic);
		
		JProgressBar p1HPBar = new JProgressBar();
		p1HPBar.setForeground(new Color(178, 34, 34));
		p1HPBar.setBounds(19, 203, 216, 32);
		p1HPBar.setMaximum(100);
		getContentPane().add(p1HPBar);
		
		JProgressBar p1MPBar = new JProgressBar();
		p1MPBar.setBounds(19, 493, 204, 32);
		p1MPBar.setMaximum(300);
		getContentPane().add(p1MPBar);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(19, 595, 204, 32);
		getContentPane().add(progressBar);
		
		try {
			p1.setHP(u.parseUnit("2.00T"), Player.SUBSTRACT);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		p1HP.setText(u.getUnit(p1.getHP()));
		p1HPBar.setValue((int)((double)(p1.getHP() / p1.getInitHP()) * 100));
		p1ATK.setText(u.getUnit(p1.getATK()));
		p1DEF.setText(u.getUnit(p1.getDEF()));
		p1Magic.setText(b.getMagic(p1.getMAGIC()));
		p1MagicLevel.setText(String.valueOf(p1.getMAGIC_LEVEL()));
		p1MP.setText(String.valueOf(p1.getMP()));
		p1MPBar.setValue((int)((double)(p1.getMP() / p1.getMAX_MP()) * 300));
		p1PP.setText(String.valueOf(p1.getPP()));
		p1Critic.setText(String.valueOf(p1.getCRITICAL_HIT()));
		p1
		setUndecorated(true);
		//setUndecorated(false);
		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocation(100, 100);
		setSize(900, 900);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		//gui ±âº»¼¼ÆÃ
		LookAndFeel laf = UIManager.getLookAndFeel();
		if (laf.getSupportsWindowDecorations( ))
		{
		   setDefaultLookAndFeelDecorated(false);
		   getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
		}
	}
}
