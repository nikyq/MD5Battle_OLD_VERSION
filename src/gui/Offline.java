package gui;

import javax.swing.*;

import Battle.Battle;
import Battle.Player;
import Battle.Stats;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Offline extends JFrame {
	static boolean isOpened = false;
	private JTextField p1sword;
	private JTextField p1shield;
	private JTextField textField_2;
	private final JLabel lblplayer = new JLabel("\uD50C\uB808\uC774\uC5B4(Player)");
	private JTextField p1player;
	private JTextField p1wand;
	private JTextField p2sword;
	private JTextField p2player;
	private JTextField p2shield;
	private JTextField p2wand;
	
	public Offline()
	{	
		ImageIcon red = new ImageIcon("resource/warrior_red.png");
		ImageIcon redW = new ImageIcon("resource/wand_red.png");
		ImageIcon blue = new ImageIcon("resource/warrior_blue.png");
		ImageIcon blueW = new ImageIcon("resource/wand_blue.png");
		ImageIcon vs = new ImageIcon("resource/vs.png");
		
		getContentPane().setLayout(null);
		
		p1sword = new JTextField();
		p1sword.setBounds(30, 201, 69, 34);
		getContentPane().add(p1sword);
		p1sword.setColumns(10);
		
		JLabel lblsword = new JLabel("\uAC80(sword)");
		lblsword.setFont(new Font("±¼¸²", Font.BOLD, 12));
		lblsword.setBounds(30, 176, 81, 15);
		getContentPane().add(lblsword);
		
		JLabel lblshield = new JLabel("\uBC29\uD328(shield)");
		lblshield.setBounds(274, 144, 81, 15);
		getContentPane().add(lblshield);
		lblshield.setForeground(Color.BLACK);
		lblshield.setFont(new Font("±¼¸²", Font.BOLD, 12));
		
		p1shield = new JTextField();
		p1shield.setBounds(273, 167, 69, 34);
		getContentPane().add(p1shield);
		p1shield.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(57, -15, 69, 34);
		textField_2.setColumns(10);
		lblplayer.setFont(new Font("±¼¸²", Font.BOLD, 12));
		lblplayer.setBounds(114, 10, 119, 31);
		getContentPane().add(lblplayer);
		
		p1player = new JTextField();
		p1player.setBounds(125, 36, 81, 31);
		getContentPane().add(p1player);
		p1player.setColumns(10);
		
		JPanel panel_1 = new JPanel()
			{
				public void paint(Graphics g)
				{
					Dimension d = getSize();
					g.drawImage(redW.getImage(), 0, 0, d.width, d.height, null);
				}
			};
		panel_1.setBounds(61, 325, 97, 95);
		getContentPane().add(panel_1);
		
		p1wand = new JTextField();
		p1wand.setBounds(172, 368, 97, 34);
		getContentPane().add(p1wand);
		p1wand.setColumns(10);
		
		JLabel lblwand = new JLabel("\uC644\uB4DC(wand) ");
		lblwand.setBounds(172, 349, 81, 15);
		getContentPane().add(lblwand);
		lblwand.setFont(new Font("±¼¸²", Font.BOLD, 12));
		
		JPanel panel = new JPanel()
				{
					public void paint(Graphics g)
					{
						Dimension d = getSize();
						g.drawImage(red.getImage(), 0, 0, d.width, d.height, null);
					}
				};
		panel.setBounds(78, 43, 198, 348);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		p2sword = new JTextField();
		p2sword.setColumns(10);
		p2sword.setBounds(526, 210, 69, 34);
		getContentPane().add(p2sword);
		
		JLabel label = new JLabel("\uAC80(sword)");
		label.setFont(new Font("±¼¸²", Font.BOLD, 12));
		label.setBounds(526, 185, 81, 15);
		getContentPane().add(label);
		
		JLabel label_1 = new JLabel("\uD50C\uB808\uC774\uC5B4(Player)");
		label_1.setFont(new Font("±¼¸²", Font.BOLD, 12));
		label_1.setBounds(611, 10, 119, 31);
		getContentPane().add(label_1);
		
		p2player = new JTextField();
		p2player.setColumns(10);
		p2player.setBounds(621, 36, 81, 31);
		getContentPane().add(p2player);
		
		JLabel label_2 = new JLabel("\uBC29\uD328(shield)");
		label_2.setForeground(Color.BLACK);
		label_2.setFont(new Font("±¼¸²", Font.BOLD, 12));
		label_2.setBounds(782, 154, 81, 15);
		getContentPane().add(label_2);
		
		p2shield = new JTextField();
		p2shield.setColumns(10);
		p2shield.setBounds(780, 176, 69, 34);
		getContentPane().add(p2shield);
		
		JPanel panel_3 = new JPanel() {
			public void paint(Graphics g) {
				Dimension d = getSize();
				g.drawImage(blueW.getImage(), 0, 0, d.width, d.height, null);
			}
		};
		panel_3.setBounds(557, 334, 97, 95);
		getContentPane().add(panel_3);
		
		JLabel label_3 = new JLabel("\uC644\uB4DC(wand) ");
		label_3.setFont(new Font("±¼¸²", Font.BOLD, 12));
		label_3.setBounds(680, 349, 81, 15);
		getContentPane().add(label_3);
		
		p2wand = new JTextField();
		p2wand.setColumns(10);
		p2wand.setBounds(680, 368, 97, 34);
		getContentPane().add(p2wand);
		
		JPanel panel_2 = new JPanel() {
			public void paint(Graphics g) {
				Dimension d = getSize();
				g.drawImage(blue.getImage(), 0, 0, d.width, d.height, null);
			}
		};
		panel_2.setLayout(null);
		panel_2.setBounds(586, 51, 198, 348);
		getContentPane().add(panel_2);
		
		JPanel vs1 = new JPanel()
				{
					public void paint(Graphics g) {
						Dimension d = getSize();
						g.drawImage(vs.getImage(), 0, 0, d.width, d.height, null);
					}
				};
		vs1.setBounds(373, 201, 119, 78);
		getContentPane().add(vs1);
		
		JButton btnNewButton = new JButton("FIGHT!!!");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Stats s = new Stats();
				ArrayList<Long> pa1 = s.getStat(p1player.getText(), p1sword.getText(), p1shield.getText(), p1wand.getText());
				ArrayList<Long> pa2 = s.getStat(p2player.getText(), p2sword.getText(), p2shield.getText(), p2wand.getText());
				
				Player p1 = new Player(p1player.getText(), pa1);
				Player p2 = new Player(p2player.getText(), pa2);
				
				BattleGUI bg = new BattleGUI(p1, p2);
			}
		});
		btnNewButton.setFont(new Font("±¼¸²", Font.BOLD, 12));
		btnNewButton.setBounds(330, 390, 172, 57);
		btnNewButton.setFocusable(false);
		getContentPane().add(btnNewButton);
		
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setUndecorated(true);
		this.setSize(900, 500);
		this.setLocation(super.getX() + 30, super.getY() + 200);
		this.setTitle("¿ÀÇÁ¶óÀÎ ¸ðµå - CK ¾ÆÆ¼ÆÑÆ®");
		this.setIconImage(Toolkit.getDefaultToolkit().getImage("resource/logo.png"));
		this.setResizable(false);
		
		//gui ±âº»¼¼ÆÃ
		LookAndFeel laf = UIManager.getLookAndFeel();
		if (laf.getSupportsWindowDecorations( ))
		{
		   setDefaultLookAndFeelDecorated(false);
		   getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
		}
		
		this.addWindowListener(new java.awt.event.WindowAdapter() {
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		    		isOpened = false;
		        };
		});
	}
}
