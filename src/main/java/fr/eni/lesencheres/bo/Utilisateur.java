package fr.eni.lesencheres.bo;

// table couplée en BDD : Utilisateur
public class Utilisateur {
	
	// ATTRIBUTS
	private int numUtilisateur; // clé primaire / noUtlisateur
	private String pseudo; // pseudo / TO DO: vérifier pas + 30 caractères en DLL
	private String nom; // nom / TO DO: vérifier pas + 30 caractères en DLL
	private String prenom; // prenom / TO DO: vérifier pas + 30 caractères en DLL
	private String email; // email / TO DO: vérifier pas + 20 caractères en DLL  + regex
	private String telephone; // telephone / TO DO: vérifier pas + 15 caractères en DLL + regex
	private String rue; // rue / TO DO: vérifier pas + 30 caractères en DLL 
	private String codePostal; // codePostal / TO DO: vérifier pas + 10 caractères en DLL + regex
	private String ville; // ville / TO DO: vérifier pas + 30 caractères en DLL 
	private String password; // motDePasse / TO DO: vérifier pas + 30 caractères en DLL 
	private int credit; // credit 
	private boolean administrateur; //administrateur 
	

}
