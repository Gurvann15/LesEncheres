package fr.eni.lesencheres.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.lesencheres.bo.Categorie;
import fr.eni.lesencheres.bo.Utilisateur;
import fr.eni.lesencheres.dal.GenericDAO;

public class UtilisateurDAO implements GenericDAO<Utilisateur>{

	private Utilisateur getUtilisateur(ResultSet rs) throws SQLException {
        Utilisateur utilisateur;
        int num = rs.getInt("no_utilisateur");
        String pseudo = rs.getString("pseudo");
        String nom = rs.getString("nom");
        String prenom = rs.getString("prenom");
        String email = rs.getString("email");
        String telephone = rs.getString("telephone");
        String rue = rs.getString("rue");
        String codePostal = rs.getString("code_postal");
        String ville = rs.getString("ville");
        String password = rs.getString("mot_de_passe");
        boolean admin = rs.getBoolean("administrateur");
        utilisateur = new Utilisateur(num,pseudo,nom,prenom,email,telephone,rue,codePostal,ville,password,admin);;
        return utilisateur;
    }
	@Override
	public Utilisateur getById(int id) {
		Utilisateur utilisateur = null;
		String sql = "select * from utilisateurs where no_utilisateur = ?;";
		try(Connection conn = JDBCTools.Connexion();
            PreparedStatement stmt = conn.prepareStatement(sql);){
            stmt.setInt(1, id);
            try(ResultSet rs = stmt.executeQuery();){
            while (rs.next()) {
                utilisateur = getUtilisateur(rs);
                System.out.println(utilisateur);
                }
            }catch(Exception e) {
            	e.printStackTrace();
            }
        	}
		catch(Exception e) {
            	e.printStackTrace();
            }
		return utilisateur;
	}

	@Override
	public List<Utilisateur> getAll() {
		List<Utilisateur> liste = new ArrayList<>();
		String sql = "select * from utilisateurs;";
		try(Connection conn = JDBCTools.Connexion();
            PreparedStatement stmt = conn.prepareStatement(sql)){
            try(ResultSet rs = stmt.executeQuery();){
            while (rs.next()) {
                Utilisateur utilisateur = getUtilisateur(rs);
                liste.add(utilisateur);
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
	public void create(Utilisateur utilisateur) {
		String sql = "insert into utilisateurs (pseudo,nom,prenom,email,telephone,"
				+ "rue,code_postal,ville,mot_de_passe,credit,administrateur) values "
				+ "(?,?,?,?,?,?,?,?,?,?,?);";
		try(Connection conn = JDBCTools.Connexion();
			PreparedStatement stmt = conn.prepareStatement(sql);
			){
		stmt.setString(1, utilisateur.getPseudo());
		stmt.setString(2, utilisateur.getNom());
		stmt.setString(3, utilisateur.getPrenom());
		stmt.setString(4, utilisateur.getEmail());
		stmt.setString(5, utilisateur.getTelephone());
		stmt.setString(6, utilisateur.getRue());
		stmt.setString(7, utilisateur.getCodePostal());
		stmt.setString(8, utilisateur.getVille());
		stmt.setString(9, utilisateur.getPassword());
		stmt.setInt(10, utilisateur.getCredit());
		stmt.setBoolean(11, utilisateur.isAdministrateur());
		int rs = stmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Utilisateur utilisateur) {
		String sql = "update utilisateurs set pseudo = ?, nom = ?, prenom=?, email =?, "
				+ "telephone = ?, rue = ?,code_postal = ?, ville = ?, mot_de_passe = ?, "
				+ "credit = ?, administrateur = ? where no_utilisateur =?;";

		try (Connection conn = JDBCTools.Connexion();
			PreparedStatement stmt = conn.prepareStatement(sql);){
			stmt.setString(1, utilisateur.getPseudo());
			stmt.setString(2, utilisateur.getNom());
			stmt.setString(3, utilisateur.getPrenom());
			stmt.setString(4, utilisateur.getEmail());
			stmt.setString(5, utilisateur.getTelephone());
			stmt.setString(6, utilisateur.getRue());
			stmt.setString(7, utilisateur.getCodePostal());
			stmt.setString(8, utilisateur.getVille());
			stmt.setString(9, utilisateur.getPassword());
			stmt.setInt(10, utilisateur.getCredit());
			stmt.setBoolean(11, utilisateur.isAdministrateur());
			stmt.setInt(12, utilisateur.getNumUtilisateur());
			int rs = stmt.executeUpdate();
			} catch (SQLException e) {
			    e.printStackTrace();
			}
		
	}

	@Override
	public void delete(int id) {
		String sql = "delete from utilisateurs where no_utilisateur = ?;";
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
