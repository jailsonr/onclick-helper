package control;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ButtonModel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import model.FunctionsModel;
import model.ValidacionCrediticia;
import view.MainScreen;

public class ValidacionCrediticiaCtrl extends MainController{
	
	private ConnectionCtrl conn = ConnectionCtrl.getConnection();
	private ValidacionCrediticia vModel;
	private MainScreen ms;
	private String sqlSelect = "select * from eoc.bixu_msg_out_config where operation like '%show%' and ONECLICKENVIRONMENT = 'PPRDCL'";		// TODO Auto-generated method stub
	private String sqlUpdate;
	PreparedStatement ps;
	private String version;

	public ValidacionCrediticiaCtrl(FunctionsModel vModel, MainScreen ms) {
		super(ms);
		// TODO Auto-generated constructor stub
	}
	
	private void changeValidCreditVersin() {
//		int response = JOptionPane.showConfirmDialog(ms, showMessage, "Atencion", JOptionPane.YES_NO_OPTION);
		int response = 0;
		try {
			if (response == 0) {
				ps = conn.con.prepareStatement(sqlUpdate);
				System.out.println(sqlUpdate);
				ResultSet rs = ps.executeQuery();
//				JOptionPane.showMessageDialog(null, "Validacion biometrica " + msg, "Info", JOptionPane.INFORMATION_MESSAGE);
				gerVersion();
//				setSQLs();
				
			}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error en la activacion/desactivacion \n " + e,  "Info", JOptionPane.ERROR_MESSAGE);
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);
		}

	}
	
	public String gerVersion() {
		try {
			ps = conn.con.prepareStatement(sqlSelect);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
//				vModel.setStatus(rs.getBoolean("ENDPOINT"));
				System.out.println(rs.getBoolean("ENDPOINT"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
//		return vModel.isStatus();
	}

	@Override
	protected void executeAction() {
		// TODO Auto-generated method stub
		
	}

}
