package fr.eni.lesencheres.bo;

import java.util.ArrayList;
import java.util.List;

// table couplée en BDD : Utilisateur
public class Utilisateur {

	// ATTRIBUTS
	private int numUtilisateur; // clé primaire / noUtlisateur
	private String pseudo; // pseudo / TO DO: vérifier pas + 30 caractères en DLL
	private String nom; // nom / TO DO: vérifier pas + 30 caractères en DLL
	private String prenom; // prenom / TO DO: vérifier pas + 30 caractères en DLL
	private String email; // email / TO DO: vérifier pas + 20 caractères en DLL + regex
	private String telephone; // telephone / TO DO: vérifier pas + 15 caractères en DLL + regex
	private String rue; // rue / TO DO: vérifier pas + 30 caractères en DLL
	private String codePostal; // codePostal / TO DO: vérifier pas + 10 caractères en DLL + regex
	private String ville; // ville / TO DO: vérifier pas + 30 caractères en DLL
	private String password; // motDePasse / TO DO: vérifier pas + 30 caractères en DLL
	private int credit; // credit
	private boolean administrateur; // administrateur
	private List<Article> listeArticleAchat;
	private List<Article> listeArticleVente;
	private List<Enchere> listeEnchere;

	// CONSTRUCTEURS
	
	// Constructeur par défaut 
	public Utilisateur () {
		this.credit = 0;
		this.listeArticleAchat = new ArrayList();
		this.listeArticleVente = new ArrayList();
		this.listeEnchere = new ArrayList();
	}
	// Constructeur avec tous les paramètres
	public Utilisateur(int numUtilisateur, String pseudo, String nom, String prenom, String email, String telephone,
			String rue, String codePostal, String ville, String password, int credit, boolean administrateur) {
		super();
		this.numUtilisateur = numUtilisateur;
		this.pseudo = pseudo;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.password = password;
		this.credit = credit;
		this.administrateur = administrateur;
		this.listeArticleAchat = new ArrayList<>();
		this.listeArticleVente = new ArrayList<>();
		this.listeEnchere = new ArrayList<>();
	}

	// Constructeur avec tous les paramètres sauf crédit initialisé à 0
	// Dans le constructeur avec crédit initialisé à 0
	public Utilisateur(int numUtilisateur, String pseudo, String nom, String prenom, String email, String telephone,
	        String rue, String codePostal, String ville, String password, boolean administrateur) {
	    this(numUtilisateur, pseudo, nom, prenom, email, telephone, rue, codePostal, ville, password, 0, administrateur);
	}


	// GETTERS
	public int getNumUtilisateur() {
		return numUtilisateur;
	}

	public String getPseudo() {
		return pseudo;
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public String getEmail() {
		return email;
	}

	public String getTelephone() {
		return telephone;
	}

	public String getRue() {
		return rue;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public String getVille() {
		return ville;
	}

	public String getPassword() {
		return password;
	}

	public int getCredit() {
		return credit;
	}

	public boolean isAdministrateur() {
		return administrateur;
	}
	public List<Article> getListeArticleAchat() {
		return listeArticleAchat;
	}
	public List<Article> getListeArticleVente() {
		return listeArticleVente;
	}
	public List<Enchere> getListeEnchere() {
		return listeEnchere;
	}

	// SETTERS
	public void setNumUtilisateur(int numUtilisateur) {
		this.numUtilisateur = numUtilisateur;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public void setAdministrateur(boolean administrateur) {
		this.administrateur = administrateur;
	}
	public void setListeArticleAchat(List<Article> listeArticleAchat) {
		this.listeArticleAchat = listeArticleAchat;
	}
	public void setListeArticleVente(List<Article> listeArticleVente) {
		this.listeArticleVente = listeArticleVente;
	}
	public void setListeEnchere(List<Enchere> listeEnchere) {
		this.listeEnchere = listeEnchere;
	}
	// METHODES
	@Override
	public String toString() {
		return "Utilisateur [numUtilisateur=" + numUtilisateur + ", pseudo=" + pseudo + ", nom=" + nom + ", prenom="
				+ prenom + ", email=" + email + ", telephone=" + telephone + ", rue=" + rue + ", codePostal="
				+ codePostal + ", ville=" + ville + ", password=" + password + ", credit=" + credit
				+ ", administrateur=" + administrateur + ", listeArticleAchat=" + listeArticleAchat
				+ ", listeArticleVente=" + listeArticleVente + ", listeEnchere=" + listeEnchere + "]";
	}
	
	

}
