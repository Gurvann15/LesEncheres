package fr.eni.lesencheres.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.lesencheres.bo.Categorie;
import fr.eni.lesencheres.dal.GenericDAO;

public class CategorieDAO implements GenericDAO<Categorie> {

	private Categorie getCategorie(ResultSet rs) throws SQLException {
        Categorie categorie;
        String libelle = rs.getString("libelle");
        int numCategorie = rs.getInt("no_categorie");
        categorie = new Categorie(numCategorie,libelle);
        return categorie;
    }

	@Override
	public Categorie getById(int id) {
		String sql = "select * from categories where no_categorie = ?;";
		Categorie categorie = null;
		try(Connection conn = JDBCTools.Connexion();
            PreparedStatement stmt = conn.prepareStatement(sql);){
            stmt.setInt(1, id);
            try(ResultSet rs = stmt.executeQuery();){
            while (rs.next()) {
                categorie = getCategorie(rs);
                System.out.println(categorie);
                }
            }catch(Exception e) {
            	e.printStackTrace();
            }
        	}
		catch(Exception e) {
            	e.printStackTrace();
            }
		return categorie;
	}
	
	@Override
	public List<Categorie> getAll() {
		List<Categorie> liste = new ArrayList();
		String sql = "select * from categories;";
		try(Connection conn = JDBCTools.Connexion();
            PreparedStatement stmt = conn.prepareStatement(sql)){
            try(ResultSet rs = stmt.executeQuery();){
            while (rs.next()) {
                Categorie categorie = getCategorie(rs);
                liste.add(categorie);
                }
        	}
		catch(Exception e) {
            	e.printStackTrace();
            }}catch(Exception e) {
            	e.printStackTrace();
            }
        return liste;
	}

	@Override
	public  void create(Categorie categorie) throws SQLException {
		String sql = "insert into categories(libelle) value (?);";
		try(
				Connection conn = JDBCTools.Connexion();
				PreparedStatement stmt = conn.prepareStatement(sql);
			){
		stmt.setString(1, categorie.getLibelle());
		int rs = stmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void update(Categorie categorie) {
		String sql = "update categories set libelle = ? where no_categorie =?;";
		try (Connection conn = JDBCTools.Connexion();
			PreparedStatement stmt = conn.prepareStatement(sql);){
			stmt.setString(1, categorie.getLibelle());
			stmt.setInt(2, categorie.getNumCategorie());
			int rs = stmt.executeUpdate();
			} catch (SQLException e) {
			    e.printStackTrace();
			}
		
	}

	@Override
	public void delete(int id) {
		String sql = "delete from categories where no_categorie = ?;";
		try (Connection conn = JDBCTools.Connexion();
			PreparedStatement stmt = conn.prepareStatement(sql);){
			stmt.setInt(1, id);
			int rs = stmt.executeUpdate();
			} catch (SQLException e) {
			    e.printStackTrace();
			}
		
		
	}
	
	
}
