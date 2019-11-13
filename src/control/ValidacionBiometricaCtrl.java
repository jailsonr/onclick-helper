package control;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.ButtonModel;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import model.FunctionsModel;
import model.ValidacionBiometrica;
import view.MainScreen;

public class ValidacionBiometricaCtrl extends MainController{
	
	private ConnectionCtrl conn = ConnectionCtrl.getConnection();
	private ValidacionBiometrica vModel;
	private MainScreen ms;
	private String sqlSelect = "select * from EOC.BIXU_TYPIFICATIONACTIONS where contextaction in ('idBiometrics', 'idNonBiometrics', 'idThirdParty')";		// TODO Auto-generated method stub
	private String sqlUpdate;
	PreparedStatement ps;
	
	public ValidacionBiometricaCtrl(FunctionsModel vModel, MainScreen ms) {
		super(ms);
		this.vModel = (ValidacionBiometrica) vModel;
		this.ms = ms;
		isActivated();
		setSQLs();
		setPreviewText();
	}


	private void setSQLs() {
		sqlUpdate = "update EOC.BIXU_TYPIFICATIONACTIONS set isenabled="+  boolToInt(!vModel.isStatus()) +" where contextaction in ('idBiometrics', 'idNonBiometrics', 'idThirdParty')";

	}
	
	private void setPreviewText(){
		Image img;
		try {
			if (!vModel.isStatus()) {
//				img = ImageIO.read(getClass().getResource("/resources/Green-Up-Arrow.bmp"));
				ms.getActDesactBiometricButton().setText("Activar validacion biometrica");
			} else {
//				img = ImageIO.read(getClass().getResource("/resources/Descenso.bmp"));
				ms.getActDesactBiometricButton().setText("Desactivar validacion biometrica");
			}
//			ms.getActDesactBiometricButton().setIcon(new ImageIcon(img));
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
//	public void initController(JMenuItem bm) {
//		
//		bm.addActionListener(e -> changeBiometricValidation(!vModel.isStatus()));
//	}
	
	public boolean isActivated() {
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
		
		String showMessage = !vModel.isStatus() ? "Validacion biometrica esta desactivada. \n�Deseas activarla?" : "Validacion biometrica esta activada. \n�Deseas desactivarla?";
		
		int response = JOptionPane.showConfirmDialog(ms, showMessage, "Atencion", JOptionPane.YES_NO_OPTION);
		System.out.println(response);

		try {
			if (response == 0) {
				ps = conn.con.prepareStatement(sqlUpdate);
				System.out.println(sqlUpdate);
				ResultSet rs = ps.executeQuery();
				JOptionPane.showMessageDialog(null, "Validacion biometrica " + msg, "Info", JOptionPane.INFORMATION_MESSAGE);
				isActivated();
				setSQLs();
				setPreviewText();
//				initController();
				
			}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error en la activacion/desactivacion \n " + e,  "Info", JOptionPane.ERROR_MESSAGE);
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);
		}
		
		
	}
	
	int boolToInt(Boolean b) {
	    return b.compareTo(false);
	}


	@Override
	protected void executeAction() {
		changeBiometricValidation(!vModel.isStatus());
	}

}
