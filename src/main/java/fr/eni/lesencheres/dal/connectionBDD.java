package fr.eni.lesencheres.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connectionBDD {


	public static class ConnectionBDD {

        private final String URL = "jdbc:mysql://127.0.0.1:3306/LesEncheres";
        private final String USERNAME = "Jean";
        private final String PASSWORD = "BTSSIO2023!";

        private Connection connexion;

        public Connection getConnection() {
            try {
                connexion = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            } catch (SQLException e) {
                System.out.println("Erreur lors de la connexion à la base de données: " + e.getMessage());
            }
            return connexion;
        }

        public void fermerConnection() {
            try {

                    connexion.close();
              
            } catch (SQLException e) {
                System.out.println("Erreur lors de la fermeture à la base de données : " + e.getMessage());
            }
        }
    }


/*    public static void main(String[] args) {
        ConnectionBDD connectionBDD = new ConnectionBDD();

        // Obtenez la connexion à partir de la classe ConnectionBDD
        Connection connection = connectionBDD.getConnection();

        // Vérifiez si la connexion est établie
        if (connection != null) {
            System.out.println("Connexion à la base de données établie avec succès!");
        } else {
            System.out.println("La connexion à la base de données a échoué.");
        }

        // Fermez la connexion
        connectionBDD.fermerConnection();
    }*/

}