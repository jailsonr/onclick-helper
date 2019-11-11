import control.ConnectionCtrl;
import control.ValidacionBiometricaCtrl;
import model.ValidacionBiometrica;
import view.LoginScreen;
import view.MainScreen;

public class Main {
	
	
	public static void main(String[] args) {
		ConnectionCtrl con = ConnectionCtrl.getConnection();
		MainScreen main = new MainScreen();
		ValidacionBiometrica vModel = new ValidacionBiometrica();
		
		ValidacionBiometricaCtrl c = new ValidacionBiometricaCtrl(vModel, main);
		c.initController();
		
		
	}

}
