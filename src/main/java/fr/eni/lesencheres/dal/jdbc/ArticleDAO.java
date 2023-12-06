package fr.eni.lesencheres.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import fr.eni.lesencheres.bo.Article;
import fr.eni.lesencheres.bo.Categorie;
import fr.eni.lesencheres.bo.Retrait;
import fr.eni.lesencheres.bo.Utilisateur;
import fr.eni.lesencheres.dal.GenericDAO;

public class ArticleDAO implements GenericDAO<Article> {

	private Article getArticle(ResultSet rs) throws SQLException {
        Article article;
        int num = rs.getInt("no_article");
        String nom = rs.getString("nom_article");
        String description = rs.getString("description");
        LocalDate dateDebut = rs.getDate("date_debut_encheres").toLocalDate();
        LocalDate dateFin = rs.getDate("date_fin_encheres").toLocalDate();
        int prixInitial = rs.getInt("prix_initial");
        int prixVente = rs.getInt("prix_vente");
        int numUtilisateur = rs.getInt("no_utilisateur");
        UtilisateurDAO utilisateurDAO = new UtilisateurDAO();
        Utilisateur utilisateur = utilisateurDAO.getById(numUtilisateur);
        int numCategorie = rs.getInt("no_categorie");
        CategorieDAO categorieDAO = new CategorieDAO();
        Categorie categorie = categorieDAO.getById(numCategorie);
        article = new Article(num,nom,description,dateDebut,dateFin,prixInitial,prixVente,utilisateur,categorie);
        return article;
    }
	@Override
	public Article getById(int id) {
		String sql = "select * from articles_vendus where no_article = ?;";
		Article article = null;
		try(Connection conn = JDBCTools.Connexion();
            PreparedStatement stmt = conn.prepareStatement(sql);){
            stmt.setInt(1, id);
            try(ResultSet rs = stmt.executeQuery();){
            while (rs.next()) {
                article = getArticle(rs);
                System.out.println(article);
                }
            }catch(Exception e) {
            	e.printStackTrace();
            }
        	}
		catch(Exception e) {
            	e.printStackTrace();
            }
		return article;
	}

	@Override
	public List<Article> getAll() {
		List<Article> liste = new ArrayList<>();
		String sql = "select * from articles_vendus;";
		try (Connection conn = JDBCTools.Connexion();
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();)
		{
			while (rs.next()) {
			    Article article = getArticle(rs);
			    liste.add(article);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return liste; 
	}

	@Override
	public void create(Article article) {
		String sql = "INSERT INTO articles_vendus (nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, no_utilisateur, no_categorie)\r\n"
				+ "VALUES (?,?,?,?,?,?,?);";
		try(Connection conn = JDBCTools.Connexion();
				PreparedStatement stmt = conn.prepareStatement(sql);
				){
			stmt.setString(1, article.getNomArticle());
			stmt.setString(2, article.getDescription());
			stmt.setObject(3, article.getDateDebutEnchere());
			stmt.setObject(4, article.getDateFinEnchere());
			stmt.setInt(5, article.getPrixInitial());
			stmt.setInt(6, article.getUtilisateurVendeur().getNumUtilisateur());
			stmt.setInt(7, article.getCategorie().getNumCategorie());
			int rs = stmt.executeUpdate();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		
	}

	@Override
	public void update(Article article) {
		String sql = "UPDATE articles_vendus\r\n"
				+ "SET nom_article = ?, description = ?, date_debut_encheres = ?, date_fin_encheres = ?, prix_initial = ?,\r\n"
				+ "    no_utilisateur = ?, no_categorie = ?, prix_vente = ?\r\n"
				+ "WHERE no_article = ?;";
		try(Connection conn = JDBCTools.Connexion();
				PreparedStatement stmt = conn.prepareStatement(sql);
				){
			stmt.setString(1, article.getNomArticle());
			stmt.setString(2, article.getDescription());
			stmt.setObject(3, article.getDateDebutEnchere());
			stmt.setObject(4, article.getDateFinEnchere());
			stmt.setInt(5, article.getPrixInitial());
			stmt.setInt(6, article.getUtilisateurVendeur().getNumUtilisateur());
			stmt.setInt(7, article.getCategorie().getNumCategorie());
			stmt.setInt(8, article.getPrixVente());
			stmt.setInt(9, article.getNumArticle());
			int rs = stmt.executeUpdate();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
	}

	@Override
	public void delete(int id) {
		String sql = "delete from articles_vendus where no_article = ?;";
		try (Connection conn = JDBCTools.Connexion();
			PreparedStatement stmt = conn.prepareStatement(sql);)
		{
			stmt.setInt(1, id);
			int rs = stmt.executeUpdate();
			
		} catch (SQLException e) {
			    e.printStackTrace();
			}
	}

}
