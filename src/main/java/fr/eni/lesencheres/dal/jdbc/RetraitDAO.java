package fr.eni.lesencheres.dal.jdbc;

import java.beans.Statement;
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

public class RetraitDAO implements GenericDAO<Retrait> {

	private Retrait getRetrait(ResultSet rs) throws SQLException {
        Retrait retrait;
        int num = rs.getInt("no_article");
        ArticleDAO articleDAO = new ArticleDAO();
        Article article = articleDAO.getById(num);
        String rue = rs.getString("rue");
        String codePostal = rs.getString("code_postal");
        String ville = rs.getString("ville");
        retrait = new Retrait(rue,codePostal,ville,article);
        return retrait;
    }
	
	@Override
	public Retrait getById(int id) {
		String sql = "select * from retraits where no_article = ?;";
		Retrait retrait = null;
		try(Connection conn = JDBCTools.Connexion();
            PreparedStatement stmt = conn.prepareStatement(sql);){
            stmt.setInt(1, id);
            try(ResultSet rs = stmt.executeQuery();){
            while (rs.next()) {
                retrait = getRetrait(rs);
                System.out.println(retrait);
                }
            }catch(Exception e) {
            	e.printStackTrace();
            }
        	}
		catch(Exception e) {
            	e.printStackTrace();
            }
		return retrait;
	}

	@Override
	public List<Retrait> getAll() {
		List<Retrait> liste = new ArrayList<>();
		String sql = "select * from retraits;";
		try (Connection conn = JDBCTools.Connexion();
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();)
		{
			while (rs.next()) {
			    Retrait retrait = getRetrait(rs);
			    liste.add(retrait);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return liste; 
	}

	@Override
	public void create(Retrait retrait) throws SQLException {
		String sql = "INSERT INTO retraits (no_article, rue, code_postal, ville)\r\n"
				+ "VALUES (?, ?, ?, ?);";
		try(Connection conn = JDBCTools.Connexion();
				PreparedStatement stmt = conn.prepareStatement(sql);
				){
			stmt.setInt(1, retrait.getArticle().getNumArticle());
			stmt.setString(2, retrait.getRue());
			stmt.setObject(3, retrait.getCodePostal());
			stmt.setObject(4, retrait.getVille());
			int rs = stmt.executeUpdate();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		
		
	}

	@Override
	public void update(Retrait retrait) {
		String sql = "UPDATE retraits SET rue = ?, code_postal = ?, ville = ? WHERE no_article = ?;";
		try (Connection conn = JDBCTools.Connexion();
			PreparedStatement stmt = conn.prepareStatement(sql);){
			stmt.setString(1, retrait.getRue());
			stmt.setString(2, retrait.getCodePostal());
			stmt.setString(3, retrait.getVille());
			stmt.setInt(4, retrait.getArticle().getNumArticle());
			int rs = stmt.executeUpdate();
			} catch (SQLException e) {
			    e.printStackTrace();
			}
		
	}

	@Override
	public void delete(int id) {
		String sql = "delete from retraits where no_article = ?;";
		try (Connection conn = JDBCTools.Connexion();
			PreparedStatement stmt = conn.prepareStatement(sql);){
			stmt.setInt(1, id);
			int rs = stmt.executeUpdate();
			} catch (SQLException e) {
			    e.printStackTrace();
			}
		
	}

	
}
