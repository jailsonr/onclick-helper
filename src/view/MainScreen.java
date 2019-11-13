package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.text.AttributedCharacterIterator;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainScreen extends JFrame {
	
	private JTextField calc;
	private JButton actDesactBiometricButton,b2,b3,b4,b5,b6,b7,b8,b9;
	private JMenuBar mb;
	private JMenu menuAjustes;
	private JMenuItem menuItemActDesactValidBio;
	private JMenuItem menuItemChangeValCredVersion;
	
	private JPanel headerPanel, leftPanel, rightPanel, bottomPanel, mainPanel;
	
	public MainScreen(){
		
		
		init();
		
		layoutComponents();
		
		setup();
	}
	
	public JMenuItem getMenuItemChangeValCredVersion() {
		return menuItemChangeValCredVersion;
	}
	
	public void setMenuItemChangeValCredVersion(JMenuItem menuItemChangeValCredVersion) {
		this.menuItemChangeValCredVersion = menuItemChangeValCredVersion;
	}
	
	public JButton getActDesactBiometricButton() {
		return actDesactBiometricButton;
	}
	
	public void setActDesactBiometricButton(JButton actDesactBiometricButton) {
		this.actDesactBiometricButton = actDesactBiometricButton;
	}
	
	public JMenuItem getMenuItemActDesactValidBio() {
		return menuItemActDesactValidBio;
	}
	
	public void setMenuItemActDesactValidBio(JMenuItem menuItemActDesactValidBio) {
		this.menuItemActDesactValidBio = menuItemActDesactValidBio;
	}
	
	private void setup() {
		 Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setResizable(true);
		setTitle("Oneclick Helper");
		setBounds(0,0,screenSize.width - 600, screenSize.height - 400);
		setLocation(50,50);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
	}	
	
	private void layoutComponents() {
			
			
			headerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
			mb.add(menuAjustes);
			menuAjustes.add(menuItemActDesactValidBio);
			menuAjustes.add(menuItemChangeValCredVersion);
//			headerPanel.add(actDesactBiometricButton);
			headerPanel.add(mb);
			
			
			bottomPanel = new JPanel(new FlowLayout());
			bottomPanel.add(new JLabel("Copyright"));

			
			leftPanel = new JPanel();
			leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));

			
			rightPanel = new JPanel();
			rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
			
			try {
				Image img = ImageIO.read(getClass().getResource("/resources/oneclick_img.png"));
				JLabel picLabel = new JLabel(new ImageIcon(img));
				picLabel.setLayout(new BorderLayout());
				mainPanel.add(picLabel, BorderLayout.SOUTH);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			setupPanel();
		/*
		 * mainPanel.add(headerPanel); mainPanel.add(leftPanel);
		 * mainPanel.add(rightPanel); mainPanel.add(bottomPanel);
		 */
			
//			add(mainPanel);
			
		}

	
	
	private void setupPanel() {
		
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(mainPanel,BorderLayout.CENTER);
		getContentPane().add(mb,BorderLayout.NORTH);
		getContentPane().add(bottomPanel,BorderLayout.SOUTH);
//		getContentPane().add(leftPanel,BorderLayout.WEST);
//		getContentPane().add(rightPanel,BorderLayout.EAST);
		
		
}
	private void init() {
		
		calc = new JTextField(25);
		
		actDesactBiometricButton = new JButton("Activar validaci�n biom�trica");
//		actDesactBiometricButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				try {
//					Class.forName("oracle.jdbc.driver.OracleDriver");  
//					Connection con=DriverManager.getConnection(  
//							"jdbc:oracle:thin:@10.49.7.142:1591/EEOCMPP1.tdenopcl.internal","EOC","EOC");  
//					Statement stmt=con.createStatement();  
//					JOptionPane.showMessageDialog(getContentPane(), "Conectado");
//				} catch (Exception e) {
//					System.out.println(e);
//				}
//			}
//		});
		
		headerPanel = new JPanel();
		leftPanel = new JPanel();
		rightPanel = new JPanel();
		bottomPanel = new JPanel();
		mainPanel = new JPanel();
		
		mb = new JMenuBar();
		menuAjustes = new JMenu("Ajustes");
		menuItemActDesactValidBio = new JMenuItem("Activar/Desactivar validacion biometrica");
		menuItemChangeValCredVersion = new JMenuItem("Cambiar versión validación creditícia");
		
		
	}
}
