package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainScreen extends JFrame {
	
	private JTextField calc;
	private JButton actDesactBiometricButton,b2,b3,b4,b5,b6,b7,b8,b9;
	
	private JPanel headerPanel, leftPanel, rightPanel, bottomPanel, mainPanel;
	
	public MainScreen(){
		
		
		init();
		
		layoutComponents();
		
		setup();
	}
	
	public JButton getActDesactBiometricButton() {
		return actDesactBiometricButton;
	}
	
	public void setActDesactBiometricButton(JButton actDesactBiometricButton) {
		this.actDesactBiometricButton = actDesactBiometricButton;
	}
	
	private void setup() {
		 Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setResizable(true);
		setTitle("Calculadora");
		setBounds(0,0,screenSize.width, screenSize.height);
		setLocation(50,50);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	
	private void changeActDesactBiometricButtonColor() {
		

	}
	
	private void layoutComponents() {
			
			
			headerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
			
			headerPanel.add(actDesactBiometricButton);
			headerPanel.add(new JButton("Sup.2"));
			headerPanel.add(new JButton("Sup.3"));
			headerPanel.add(new JButton("Sup.4"));
			
			bottomPanel = new JPanel(new FlowLayout());
			bottomPanel.add(new JLabel("Pon texto"));
			bottomPanel.add(new JTextField(25));
			bottomPanel.add(new JButton("Listo"));
			
			leftPanel = new JPanel();
			leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
			leftPanel.add(new JButton("1"));
			leftPanel.add(new JButton("2"));
			leftPanel.add(new JButton("3"));
			
			rightPanel = new JPanel();
			rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
			rightPanel.add(new JButton("A"));
			rightPanel.add(new JButton("B"));
			rightPanel.add(new JButton("C"));
			rightPanel.add(new JButton("D"));
			
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
		getContentPane().add(headerPanel,BorderLayout.NORTH);
		getContentPane().add(bottomPanel,BorderLayout.SOUTH);
		getContentPane().add(leftPanel,BorderLayout.WEST);
		getContentPane().add(rightPanel,BorderLayout.EAST);
		
		
}
	private void init() {
		
		calc = new JTextField(25);
		
		actDesactBiometricButton = new JButton("Activar validación biométrica");
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
		
		
	}
	
	
	
	public static void main(String[] args) {
		
		new MainScreen();
	}

}
