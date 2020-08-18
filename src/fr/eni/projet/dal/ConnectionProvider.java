package fr.eni.projet.dal;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectionProvider {
	//objet permettant de manipuler le pool de connection
	private static DataSource dataSource;

	static
	{
	    //création d'objet context permettant de rechercher dans l'arbre jndi
	    //lookup pour rechercher la ressource du pool
	    Context context;
	    try {
	        context = new InitialContext();
	        ConnectionProvider.dataSource = (DataSource) context.lookup("java:comp/env/jdbc/pool_cnx");
	
	    } catch (NamingException e) {
	        e.printStackTrace();
	        throw new RuntimeException("Impossible d'accéder à la base de données");
	    }
	}
	
	public static Connection getConnection() throws SQLException{
		return ConnectionProvider.dataSource.getConnection();
	}
	
	public static void closeConnection() {
		try {
			((Connection) ConnectionProvider.dataSource).close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
}