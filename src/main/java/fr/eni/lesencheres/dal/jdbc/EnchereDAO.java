package fr.eni.lesencheres.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import fr.eni.lesencheres.bo.Article;
import fr.eni.lesencheres.bo.Enchere;
import fr.eni.lesencheres.bo.Utilisateur;
import fr.eni.lesencheres.dal.GenericDAO;

public class EnchereDAO implements GenericDAO<Enchere> {
	
	private Enchere getEnchere(ResultSet rs) throws SQLException {
        Enchere enchere;
        int numUtilisateur = rs.getInt("no_utilisateur");
        UtilisateurDAO utilisateurDAO = new UtilisateurDAO();
        Utilisateur utilisateur = utilisateurDAO.getById(numUtilisateur);
        int numArticle = rs.getInt("no_article");
        ArticleDAO articleDAO = new ArticleDAO();
        Article article = articleDAO.getById(numArticle);
        LocalDate dateEnchere = rs.getDate("date_enchere").toLocalDate();
        int montantEnchere = rs.getInt("montant_enchere");
        enchere = new Enchere(dateEnchere,montantEnchere,utilisateur,article);
        return enchere;
    }

	@Override
	public Enchere getById(int id) {
		String sql = "select * from encheres where no_article = ?;";
		Enchere enchere = null;
		try(Connection conn = JDBCTools.Connexion();
            PreparedStatement stmt = conn.prepareStatement(sql);){
            stmt.setInt(1, id);
            try(ResultSet rs = stmt.executeQuery();){
            while (rs.next()) {
                enchere = getEnchere(rs);
                }
            }catch(Exception e) {
            	e.printStackTrace();
            }
        	}
		catch(Exception e) {
            	e.printStackTrace();
            }
		return enchere;
	}

	@Override
	public List<Enchere> getAll() {
		List<Enchere> liste = new ArrayList<>();
		String sql = "select * from encheres;";
		try (Connection conn = JDBCTools.Connexion();
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();)
		{
			while (rs.next()) {
			    Enchere enchere = getEnchere(rs);
			    liste.add(enchere);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return liste; 
	}

	@Override
	public void create(Enchere enchere) throws SQLException {
		String sql = "insert into encheres values (?,?,?,?);";
		try(Connection conn = JDBCTools.Connexion();
				PreparedStatement stmt = conn.prepareStatement(sql);
				){
			stmt.setInt(1, enchere.getUtilisateur().getNumUtilisateur());
			stmt.setInt(2, enchere.getArticle().getNumArticle());
			stmt.setObject(3, enchere.getDateEnchere());
			stmt.setInt(4, enchere.getMontantEnchere());
			int rs = stmt.executeUpdate();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		
	}

	@Override
	public void update(Enchere enchere) {
		// avec numéro d'article
		String sql = "update encheres set no_utilisateur = ?, date_enchere = ?, montant_enchere = ? where no_article = ?;";
		try(Connection conn = JDBCTools.Connexion();
				PreparedStatement stmt = conn.prepareStatement(sql);
				){
			stmt.setInt(1, enchere.getUtilisateur().getNumUtilisateur());
			stmt.setObject(2, enchere.getDateEnchere());
			stmt.setInt(3, enchere.getMontantEnchere());
			stmt.setInt(4, enchere.getArticle().getNumArticle());
			int rs = stmt.executeUpdate();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		
	}

	public void updateAvecNumUtilisateur(Enchere enchere) {
		// avec numéro d'utilisateur
		String sql = "update encheres set no_article = ?, date_enchere = ?, montant_enchere = ? where no_utilisateur= ?;";
		try(Connection conn = JDBCTools.Connexion();
				PreparedStatement stmt = conn.prepareStatement(sql);
				){
			stmt.setInt(1, enchere.getArticle().getNumArticle());
			stmt.setObject(2, enchere.getDateEnchere());
			stmt.setInt(3, enchere.getMontantEnchere());
			stmt.setInt(4, enchere.getUtilisateur().getNumUtilisateur());
			int rs = stmt.executeUpdate();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		
	}
	@Override
	public void delete(int id) {
		String sql = "delete from encheres where no_article = ?;";
		try (Connection conn = JDBCTools.Connexion();
			PreparedStatement stmt = conn.prepareStatement(sql);)
		{
			stmt.setInt(1, id);
			int rs = stmt.executeUpdate();
			
		} catch (SQLException e) {
			    e.printStackTrace();
			}
		
	}
	public void deleteEncheresUtilisateur(int id) {
		String sql = "delete from encheres where no_utilisateur = ?;";
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
