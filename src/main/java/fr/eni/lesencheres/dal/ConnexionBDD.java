package fr.eni.lesencheres.dal;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.Duration;
import java.io.InputStream;
import java.io.IOException;
import java.util.Properties;

public class ConnexionBDD {

	private String url;
	private String username;
	private String password;

	private Properties properties = new Properties();
	private BasicDataSource dataSource;

	public ConnexionBDD() {
		loadProperties();
		initializeDataSource();
	}

	private void loadProperties() {
		try (InputStream input = ConnexionBDD.class.getResourceAsStream("database.properties")) {
			if (input == null) {
				System.out.println("Dossier database.properties introuvable");
				return;
			}
			properties.load(input); // Charge les properties depuis le fichier
			url = properties.getProperty("db.url");
			username = properties.getProperty("db.username");
			password = properties.getProperty("db.password");
		} catch (IOException exception) {
			exception.printStackTrace();
		}
	}

	private void initializeDataSource() {
		dataSource = new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		dataSource.setMaxTotal(100); // Nbre max de connexions actives et inactives.
		dataSource.setMaxIdle(30); // Nbre max de connexions inactives que le pool peut maintenir sans les fermer
		dataSource.setMaxWait(Duration.ofMillis(10000)); // Temps d'attente pour la connexion

	}

	public Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}

	public void closeDataSource() throws SQLException {
		dataSource.close();
	}

	public static void main(String[] args) {
		// Création de l'objet ConnexionBDD
		ConnexionBDD connexionBDD = new ConnexionBDD();

		try (Connection connection = connexionBDD.getConnection()) {
			// Vérifier si la connexion est établie
			if (connection != null) {
				System.out.println("Connexion à la base de données établie avec succès!");
				// Effectuer des opérations sur la base de données ici si nécessaire
			} else {
				System.out.println("La connexion à la base de données a échoué.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// Fermeture du pool de connexions
				connexionBDD.closeDataSource();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
