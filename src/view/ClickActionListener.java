package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonModel;
import javax.swing.JMenuItem;

import control.ControllerFactory;
import control.ControllerFactoryMethod;
import control.MainController;
import control.ValidacionBiometricaCtrl;
import model.FunctionsModel;
import model.ValidacionBiometrica;
import model.ValidacionCrediticia;

public class ClickActionListener implements ActionListener {
	
	private MainScreen ms;

	public ClickActionListener(MainScreen ms) {
		this.ms = ms;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		MainController mc = null;
		ControllerFactoryMethod factory = new ControllerFactory();
		FunctionsModel vModel;
		
		String command = e.getActionCommand();
        if ("Activar/Desactivar validacion biometrica".equals(command)) {
        	vModel = new ValidacionBiometrica();
        	mc = factory.createController(vModel, ms);
        } else if ("V1".equals(command) || "V2".equals(command) || "V3".equals(command)) {
        	vModel = new ValidacionCrediticia();
        	mc = factory.createController(vModel, ms);
        }
        
        mc.initController();

	}

}
