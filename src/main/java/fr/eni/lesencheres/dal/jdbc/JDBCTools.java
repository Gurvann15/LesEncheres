package fr.eni.lesencheres.dal.jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import fr.eni.lesencheres.dal.Settings;

public class JDBCTools {
	
	public static Connection Connexion() throws SQLException {
	    try {
	        Class.forName(Settings.getPropertiesDriver());
	    } catch (ClassNotFoundException e) {
	        throw new RuntimeException("Driver JDBC introuvable", e);
	    }

	    String path = Settings.getPropertiesPath();
	    String user = Settings.getPropertiesUser();
	    String pass = Settings.getPropertiesPass();
	    Connection conn = null;

	    try {
	        conn = DriverManager.getConnection(path, user, pass);
	    } catch (SQLException e) {
	        throw new SQLException("Erreur lors de la connexion à la base de données", e);
	    }
	    return conn;
    }
}
