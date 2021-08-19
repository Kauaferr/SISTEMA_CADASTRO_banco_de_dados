package faminha;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class conexaosql {
private String url;
private String usuario;
private String senha;
private Connection con;

conexaosql(){
	url = "jdbc:postgresql://localhost:5432/REGISTRO";
	usuario = "postgres";
	senha="041203kfs.";
	
	
	try {
		Class.forName("org.postgresql.Driver");
		con = DriverManager.getConnection(url, usuario, senha);
		
	} catch (Exception e) {
		e.printStackTrace();

	
	}
}
public int executaSQL( String adicionaCampo) {
	try {
		Statement stm = con.createStatement();
		int res = stm.executeUpdate(adicionaCampo);
		return res;
		
	} catch (Exception e) {
		e.printStackTrace();
		return 0;
	}
}
public ResultSet executaBusca ( String consulta) {
	try {
		Statement stm = con.createStatement();
		ResultSet rs = stm.executeQuery(consulta);
		return rs;
		
		
	} catch (Exception e) {
		e.printStackTrace();
		return null;
	}
	
}
}