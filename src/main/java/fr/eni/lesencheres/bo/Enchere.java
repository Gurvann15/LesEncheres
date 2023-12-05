package fr.eni.lesencheres.bo;

import java.time.LocalDate;

// Liée en BDD à la table : encheres
public class Enchere {
	
	// ATTRIBUTS
	private LocalDate dateEnchere; // date_enchere
	private int montantEnchere; // montant_enchere
	private Utilisateur utilisateur;
	private Article article;
	
	//CONSTRUCTEUR
	
	//Constructeur par défault
	public Enchere() {
		
	}
	
	//Constructeur complet
	public Enchere(LocalDate dateEnchere, int montantEnchere, Utilisateur utilisateur, Article article) {
		super();
		this.dateEnchere = dateEnchere;
		this.montantEnchere = montantEnchere;
		this.utilisateur = utilisateur;
		this.article = article;
	}

	
	//GETTERS
	public LocalDate getDateEnchere() {
		return dateEnchere;
	}

	public int getMontantEnchere() {
		return montantEnchere;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public Article getArticle() {
		return article;
	}

	
	//SETTERS
	public void setDateEnchere(LocalDate dateEnchere) {
		this.dateEnchere = dateEnchere;
	}

	public void setMontantEnchere(int montantEnchere) {
		this.montantEnchere = montantEnchere;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	
	//METHODES
	@Override
	public String toString() {
		return "Enchere [dateEnchere=" + dateEnchere + ", montantEnchere=" + montantEnchere + ", utilisateur="
				+ utilisateur + ", article=" + article + "]";
	}
	
	
	
	
	
}
