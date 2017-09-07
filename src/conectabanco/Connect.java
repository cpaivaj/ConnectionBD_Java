package conectabanco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect{
    public Connection getConnection(String url, String database, String user, String password){
    	// driver usado
    	final String DRIVE = "jdbc:mysql://";
    	
    	// tenta criar a conexao com o banco
    	try{
    		return DriverManager.getConnection(DRIVE + url + "/" + database, user, password);    		
    	}
    	catch(SQLException ex){
    		throw new RuntimeException(ex);
    	}
    }
}
