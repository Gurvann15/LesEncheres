package fr.eni.lesencheres.bo;

import java.util.ArrayList;
import java.util.List;

public class Utilisateur {

	private int noUtilisateur;
	private String pseudo;
	private String nom;
	private String prenom;
	private String email;
	private String telephone;
	private String rue;
	private String codePostal;
	private String ville;
	private String motDePasse;
	private int credit;
	private boolean administrateur;
	private List<Article> listeArticleAchete;
	private List<Article> listeArticleVendu;
	private List<Enchere> listeEncheres;
	
	
	//Constructeur par défaut 
	public Utilisateur() {
		this.credit = 0;
		this.listeArticleAchete = new ArrayList();
		this.listeArticleVendu = new ArrayList();
		this.listeEncheres = new ArrayList(); 
		
	}
	
	//Constructeur complet
	public Utilisateur(int noUtilisateur, String pseudo, String nom, String prenom, String email, String telephone, String rue, String codePostal, String ville,  
			String motDePasse, Boolean administrateur, int credit) {
		this.noUtilisateur = noUtilisateur;
		this.pseudo = pseudo;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.motDePasse = motDePasse;
		this.administrateur = administrateur;
		this.credit = credit;
		this.listeArticleAchete = new ArrayList();
		this.listeArticleVendu = new ArrayList();
		this.listeEncheres = new ArrayList();
		
	}
	
	//GETTERS

	public int getNoUtilisateur() {
		return noUtilisateur;
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

	public String getMotDePasse() {
		return motDePasse;
	}

	public int getCredit() {
		return credit;
	}

	public boolean isAdministrateur() {
		return administrateur;
	}

	public List<Article> getListeArticleAchete() {
		return listeArticleAchete;
	}

	public List<Article> getListeArticleVendu() {
		return listeArticleVendu;
	}

	public List<Enchere> getListeEncheres() {
		return listeEncheres;
	}
	
	
	//SETTERS

	public void setNoUtilisateur(int noUtilisateur) {
		this.noUtilisateur = noUtilisateur;
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

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public void setAdministrateur(boolean administrateur) {
		this.administrateur = administrateur;
	}

	public void setListeArticleAchete(List<Article> listeArticleAchete) {
		this.listeArticleAchete = listeArticleAchete;
	}

	public void setListeArticleVendu(List<Article> listeArticleVendu) {
		this.listeArticleVendu = listeArticleVendu;
	}

	public void setListeEncheres(List<Enchere> listeEncheres) {
		this.listeEncheres = listeEncheres;
	}
	

}
