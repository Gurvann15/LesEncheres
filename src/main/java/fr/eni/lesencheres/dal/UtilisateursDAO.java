package fr.eni.lesencheres.dal;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.lesencheres.bo.Utilisateur;
import fr.eni.lesencheres.dal.connectionBDD;

public class UtilisateursDAO {
	
	public void insert(Utilisateur user) {
		
	}
	
	public void update(Utilisateur user) {
		
	}
	
	public Utilisateur select(int noUser) {
		return null;
	}
	
	/*public List<Utilisateur> selectAll(){
	List<Utilisateur> utilisateur = new ArrayList<Utilisateur>();
	Statement stmt;
	
	connectionBDD bdd = new connectionBDD();
	
	try {
		
		Connection connexion = bdd.getConnection();
	}
	}*/
	
	public void delete(Utilisateur user) {
		
	}

}
