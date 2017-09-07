package conectabanco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConectaBanco {
    public static void main(String[] args) throws SQLException{
        final String URL = "localhost";
        final String DATABASE = "exemplo";
        final String USER = "root";
        final String PASS = "";
        final String TABLE = "contatos";
        
        // conexao
        Connection con = new Connect().getConnection(URL, DATABASE, USER, PASS);
        System.out.println("Conexao aberta!");
               
        // chamada da funcao
        //Insert(con, TABLE, "carlos", "carlos@mail");
        Print(con, TABLE);
        
        // fecha a conexao
        con.close();        
    }
    
    // funcao para inserir dados da tabela
    public static void Insert(Connection con, String table, String name, String email) throws SQLException{
    	// criando o statement
        String command = "insert into " + table + " (nome, email) values (?, ?)";                
        PreparedStatement pState = con.prepareStatement(command);
        
        // preenche os valores
        pState.setString(1, name);
        pState.setString(2, email);
        
        // executa o comando
        pState.execute();
        pState.close();
        
        System.out.println("Dados gravados!!!");
    }
    
    // funcao para pegar os dados do banco e exibir
    public static void Print(Connection con, String table) throws SQLException{
    	// cria o statement
    	String command = "select * from " + table;    	
    	PreparedStatement pState = con.prepareStatement(command);
    	
    	// executa um select
    	ResultSet rs = pState.executeQuery();
    	
    	// itera no resultSet
    	while(rs.next()){
    		// pega o dado da coluna especificada
    		String name = rs.getString("nome");
    		String email = rs.getString("email");
    		
    		System.out.println(name + " : " + email);
    	}
    	
    	// fechamento
    	rs.close();
    	pState.close();
    }
}











