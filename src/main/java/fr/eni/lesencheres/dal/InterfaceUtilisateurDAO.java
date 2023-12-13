package fr.eni.lesencheres.dal;

import java.sql.SQLException;
import java.util.List;

import fr.eni.lesencheres.bo.Utilisateur;

public interface InterfaceUtilisateurDAO {
		Utilisateur getByPseudo(String pseudo);
		Utilisateur getByEmail(String email);
		Utilisateur getById(int id);
	    List<Utilisateur> getAll();
	    void create(Utilisateur entity) throws SQLException;
	    void update(Utilisateur entity);
	    void delete(int id);
}
