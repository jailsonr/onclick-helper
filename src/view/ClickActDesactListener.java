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

public class ClickActDesactListener implements ActionListener {
	
	private JMenuItem jm;
	private MainScreen ms;

	public ClickActDesactListener(JMenuItem jm, MainScreen ms) {
		this.jm = jm;
		this.ms = ms;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		MainController mc;
		ControllerFactoryMethod factory = new ControllerFactory();
		FunctionsModel vModel;
		
		String command = e.getActionCommand();
        if ("Activar/Desactivar validacion biometrica".equals(command)) {
        	vModel = new ValidacionBiometrica();
        	mc = factory.createController(vModel, ms);
        	mc.initController();
            
        }

	}

}
