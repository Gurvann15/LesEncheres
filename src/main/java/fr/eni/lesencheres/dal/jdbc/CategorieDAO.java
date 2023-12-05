package fr.eni.lesencheres.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import fr.eni.lesencheres.bo.Categorie;
import fr.eni.lesencheres.dal.GenericDAO;

public class CategorieDAO implements GenericDAO<Categorie> {

	@Override
	public Categorie getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Categorie> getAll() {
		// TODO Auto-generated method stub
		return null;
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
	public void update(Categorie entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

}
