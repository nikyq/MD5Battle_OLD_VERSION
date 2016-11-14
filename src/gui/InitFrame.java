package gui;

import javax.swing.*;
import java.awt.*;
import javax.swing.UIManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class InitFrame extends JFrame {
	public InitFrame() {		
		setTitle("CK Artifact : \uB9C9\uC7A5 \uC2E0\uAC1C\uB150 MD5 \uBC30\uD2C0");
		setIconImage(Toolkit.getDefaultToolkit().getImage("resource/logo.png"));
		setResizable(false);
		
		getContentPane().setLayout(null);
		
		// 리소스 이미지들을 얻어옴
		ImageIcon logo = new ImageIcon("resource/logo.png");
		ImageIcon logoText = new ImageIcon("resource/logoText.png");
		ImageIcon cheankLogo = new ImageIcon("resource/cheank.png");
		
		JPanel logoPanel = new JPanel()
				{
					public void paint(Graphics g)
					{
						Dimension d = getSize();
						g.drawImage(logo.getImage(), 0, 0, d.width, d.height, null);
					}
				};
		logoPanel.setBounds(27, 66, 131, 122);
		getContentPane().add(logoPanel);
		
		JPanel logoTextPanel = new JPanel()
				{
					public void paint(Graphics g)
					{
						Dimension d = getSize();
						g.drawImage(logoText.getImage(), 0, 0, d.width, d.height, null);
					}
				};
		logoTextPanel.setBounds(158, 54, 302, 143);
		getContentPane().add(logoTextPanel);
		
		Offline of = new Offline();
		of.setVisible(false);
		
		JButton offlineBtn = new JButton("PLAY OFFLINE");
		offlineBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(of.isVisible() == false)
				{
					of.setVisible(true);
				}
				else
				{
					of.requestFocus();
				}
			}
		});
		
		offlineBtn.setBounds(53, 226, 150, 59);
		getContentPane().add(offlineBtn);
		offlineBtn.setFocusPainted(false);
		
		JButton onlineBtn = new JButton("PLAY ONLINE");
		onlineBtn.setBounds(251, 226, 150, 59);
		getContentPane().add(onlineBtn);
		onlineBtn.setFocusPainted(false);
		
		JPanel cheankPanel = new JPanel()
			{
				public void paint(Graphics g)
				{
					Dimension d = getSize();
					g.drawImage(cheankLogo.getImage(), 0, 0, d.width, d.height, null);
				}
			};
		cheankPanel.setBounds(294, 0, 200, 59);
		getContentPane().add(cheankPanel);
		
		JLabel lblNewLabel = new JLabel("\uC81C\uC791 - CheaNK  \uCE58\uD2F0\uB2C8\uD074");
		lblNewLabel.setBounds(343, 313, 145, 15);
		getContentPane().add(lblNewLabel);
		
		setUndecorated(true);
		//setUndecorated(false);
		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocation(100, 100);
		setSize(500, 370);
		
		//gui 기본세팅
		LookAndFeel laf = UIManager.getLookAndFeel();
		if (laf.getSupportsWindowDecorations( ))
		{
		   setDefaultLookAndFeelDecorated(false);
		   getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
		}
	}
}
