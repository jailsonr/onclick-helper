package control;

import java.awt.Image;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import model.ValidacionBiometrica;
import view.MainScreen;

public class ValidacionBiometricaCtrl {
	
	private ConnectionCtrl conn = ConnectionCtrl.getConnection();
	private ValidacionBiometrica vModel;
	private MainScreen ms;
	 private String sqlSelect = "select * from EOC.BIXU_TYPIFICATIONACTIONS where contextaction in ('idBiometrics', 'idNonBiometrics', 'idThirdParty')";		// TODO Auto-generated method stub
	private String sqlUpdate;
	
	public ValidacionBiometricaCtrl(ValidacionBiometrica vModel, MainScreen ms) {
		this.ms = ms;
		this.vModel = vModel;
		isActivated();
		setSQLs();
	}
	
	private void setSQLs() {
		sqlUpdate = "update EOC.BIXU_TYPIFICATIONACTIONS set isenabled="+  boolToInt(!vModel.isStatus()) +" where contextaction in ('idBiometrics', 'idNonBiometrics', 'idThirdParty')";

	}
	
	public void initController() {
		Image img;
		try {
			if (!vModel.isStatus()) {
				img = ImageIO.read(getClass().getResource("/resources/Green-Up-Arrow.bmp"));
				ms.getActDesactBiometricButton().setText("Activar validacion biometrica");
			} else {
				img = ImageIO.read(getClass().getResource("/resources/Descenso.bmp"));
				ms.getActDesactBiometricButton().setText("Desactivar validacion biometrica");
			}
			ms.getActDesactBiometricButton().setIcon(new ImageIcon(img));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		ms.getActDesactBiometricButton().addActionListener(e -> changeBiometricValidation(!vModel.isStatus()));
	}
	
	public boolean isActivated() {
		PreparedStatement ps;
		try {
			ps = conn.con.prepareStatement(sqlSelect);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				vModel.setStatus(rs.getBoolean("ISENABLED"));
				System.out.println(rs.getBoolean("ISENABLED"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vModel.isStatus();
	}
	
	public void changeBiometricValidation(boolean status){
		String msg = !vModel.isStatus() ? "activada" : "desactivada";
		
		try {
			PreparedStatement ps = conn.con.prepareStatement(sqlUpdate);
			ResultSet rs = ps.executeQuery();
			JOptionPane.showMessageDialog(null, "Validación biométrica " + msg, "Info", JOptionPane.INFORMATION_MESSAGE);
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error en la activación/desactivación \n " + e,  "Info", JOptionPane.ERROR_MESSAGE);
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);
		}
		
		isActivated();
		initController();
		
	}
	
	int boolToInt(Boolean b) {
	    return b.compareTo(false);
	}

}
