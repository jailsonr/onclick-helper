package control;

import javax.swing.ButtonModel;

public abstract class MainController {
	
	private String sqlUpdate;
	
	private void setSQLs(String sqpUpdate) {
		this.sqlUpdate = sqlUpdate;

	}
	
	public  void initController(ButtonModel bm) {
		System.out.println("Chamou");
//		bm.addActionListener(e -> executeAction());
	}

//	protected abstract void executeAction();

}
