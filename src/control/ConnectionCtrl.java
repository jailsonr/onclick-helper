package control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionCtrl {
	
	private static ConnectionCtrl connection;
	public static Connection con;
	
	public ConnectionCtrl() {
		// TODO Auto-generated constructor stub
	}
	
	public static ConnectionCtrl getConnection() {
        if (connection == null){
            connection = new ConnectionCtrl();
            try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				con=DriverManager.getConnection(  
						"jdbc:oracle:thin:@10.49.7.142:1591/EEOCMPP1.tdenopcl.internal","EOC","EOC");  
				Statement stmt=con.createStatement();  
				System.out.println("Conectado...");
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e);
				e.printStackTrace();
			}  
        }
        else{
            
        }
        
        return connection;
    }

}
