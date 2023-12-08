package fr.eni.lesencheres.dal;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

import fr.eni.lesencheres.bo.Article;


	public class ArticlesDAO {
		
		ConnexionBDD bdd = new ConnexionBDD();
		
		public void insert() throws SQLException {
			
			Connection connexion = bdd.getConnection();
			String query = ("SELECT nom_article FROM articles_vendus");
			
			try (Statement stmt = connexion.createStatement();
		             ResultSet resultSet = stmt.executeQuery(query)) {

		            while (resultSet.next()) {
		                String nomArticle = resultSet.getString("nom_article");
		                System.out.println("Nom de l'article:"+nomArticle);
		            }
		          }
		}
		
	    public static void main(String[] args) throws SQLException {
	        ArticlesDAO articles = new ArticlesDAO();
	        articles.insert();
	    }
	}

	
	/*connectionBDD bdd = new connectionBDD();
	
	public void select() {
		
		Connection connexion = bdd.getConnection();
		String query = ("SELECT nom_article FROM articles_vendus");
		
		try (Statement stmt = connexion.createStatement();
	             ResultSet resultSet = stmt.executeQuery(query)) {

	            while (resultSet.next()) {
	                String nomArticle = resultSet.getString("nom_article");
	                System.out.println("Nom de l'article : " + nomArticle);
	            }
	          } catch (SQLException e) {
	              // Gérer l'exception SQLException
	              e.printStackTrace();
	          }
		finally {
            bdd.fermerConnection();
        }
	}
	
    public static void main(String[] args) {
        ArticlesDAO articles = new ArticlesDAO();
        articles.select();
    }
*/

