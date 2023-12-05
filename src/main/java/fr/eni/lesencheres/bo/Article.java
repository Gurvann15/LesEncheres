package fr.eni.lesencheres.bo;

import java.time.LocalDate;

// Table liée en BDD : articles_vendus
public class Article {
	private int numArticle; // no_article / Clé primaire
	private String nomArticle; //nom_article / TO DO: vérifier pas + 30 caractères en DLL
	private String description; // drescription / TO DO: vérifier pas + 300 caractères en DLL
	private LocalDate dateDebutEnchere; //date_debut_encheres 
	private LocalDate dateFinEnchere; // date_fin_encheres
	private int prixInitial; // prix_initial / valeur par défault : nulle
	private int prixVente; // prix_vente  / valeur par défault : nulle
	private Utilisateur utilisateurAcheteur;
	private Utilisateur utilisateurVendeur;
	private Categorie categorie;
	private Retrait retrait = null;
	
	//CONSTRUCTEUR
	
	//Constructeur par défault
	public Article() {
		
	}
	
	//Constructeur complet
	public Article(int numArticle, String nomArticle, String description, LocalDate dateDebutEnchere,
			LocalDate dateFinEnchere, int prixInitial, int prixVente, Utilisateur utilisateurAcheteur,
			Utilisateur utilisateurVendeur, Categorie categorie, Retrait retrait) {
		super();
		this.numArticle = numArticle;
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEnchere = dateDebutEnchere;
		this.dateFinEnchere = dateFinEnchere;
		this.prixInitial = prixInitial;
		this.prixVente = prixVente;
		this.utilisateurAcheteur = utilisateurAcheteur;
		this.utilisateurVendeur = utilisateurVendeur;
		this.categorie = categorie;
		this.retrait = retrait;
	}

	
	
	//GETTERS
	public int getNumArticle() {
		return numArticle;
	}
	public String getNomArticle() {
		return nomArticle;
	}
	public String getDescription() {
		return description;
	}
	public LocalDate getDateDebutEnchere() {
		return dateDebutEnchere;
	}
	public LocalDate getDateFinEnchere() {
		return dateFinEnchere;
	}
	public int getPrixInitial() {
		return prixInitial;
	}
	public int getPrixVente() {
		return prixVente;
	}
	public Utilisateur getUtilisateurAcheteur() {
		return utilisateurAcheteur;
	}
	public Utilisateur getUtilisateurVendeur() {
		return utilisateurVendeur;
	}
	public Categorie getCategorie() {
		return categorie;
	}
	public Retrait getRetrait() {
		return retrait;
	}

	
	//SETTERS
	public void setNumArticle(int numArticle) {
		this.numArticle = numArticle;
	}

	public void setNomArticle(String nomArticle) {
		this.nomArticle = nomArticle;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setDateDebutEnchere(LocalDate dateDebutEnchere) {
		this.dateDebutEnchere = dateDebutEnchere;
	}

	public void setDateFinEnchere(LocalDate dateFinEnchere) {
		this.dateFinEnchere = dateFinEnchere;
	}

	public void setPrixInitial(int prixInitial) {
		this.prixInitial = prixInitial;
	}

	public void setPrixVente(int prixVente) {
		this.prixVente = prixVente;
	}

	public void setUtilisateurAcheteur(Utilisateur utilisateurAcheteur) {
		this.utilisateurAcheteur = utilisateurAcheteur;
	}

	public void setUtilisateurVendeur(Utilisateur utilisateurVendeur) {
		this.utilisateurVendeur = utilisateurVendeur;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public void setRetrait(Retrait retrait) {
		this.retrait = retrait;
	}

	
	//METHODES
	@Override
	public String toString() {
		return "Article [numArticle=" + numArticle + ", nomArticle=" + nomArticle + ", description=" + description
				+ ", dateDebutEnchere=" + dateDebutEnchere + ", dateFinEnchere=" + dateFinEnchere + ", prixInitial="
				+ prixInitial + ", prixVente=" + prixVente + ", utilisateurAcheteur=" + utilisateurAcheteur
				+ ", utilisateurVendeur=" + utilisateurVendeur + ", categorie=" + categorie + ", retrait=" + retrait
				+ "]";
	}	

	
	
	
}
