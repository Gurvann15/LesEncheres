package fr.eni.lesencheres.dal.jdbc;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.lesencheres.bo.Categorie;
import fr.eni.lesencheres.dal.GenericDAO;

public class CategorieDAO implements GenericDAO<Categorie> {

	@Override
	public Categorie getById(int id) {
		String sql = "select * from categories where no_categorie = ?;";
		Categorie categorie = null;
		try{
            Connection conn = JDBCTools.Connexion();
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, String.valueOf(id));
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                categorie = getCategorie(rs);
                System.out.println(categorie);
                }
        	}
		catch(Exception e) {
            	e.printStackTrace();
            }
		return categorie;
	}
	
	private Categorie getCategorie(ResultSet rs) throws SQLException {
        Categorie categorie;
        String libelle = rs.getString("libelle");
        int numCategorie = rs.getInt("no_categorie");
        categorie = new Categorie(numCategorie,libelle);
        return categorie;
    }

	@Override
	public List<Categorie> getAll() {
		Categorie categorie = new Categorie();
		List<Categorie> liste = new ArrayList();
		String sql = "select * from categories;";
		try{
            Connection conn = JDBCTools.Connexion();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                categorie = getCategorie(rs);
                liste.add(categorie);
                }
        	}
		catch(Exception e) {
            	e.printStackTrace();
            }
        return liste;
	}

	@Override
	public  void create(Categorie categorie) throws SQLException {
		String sql = "insert into categories(libelle) value (?);";
		try(
				Connection conn = JDBCTools.Connexion();
				PreparedStatement preparedStatement = conn.prepareStatement(sql);
			){
		preparedStatement.setString(1, categorie.getLibelle());
		int resultSet = preparedStatement.executeUpdate();
		preparedStatement.close();
		conn.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void update(Categorie categorie) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}
	public static void main(String[] args) {
		
	}

}
