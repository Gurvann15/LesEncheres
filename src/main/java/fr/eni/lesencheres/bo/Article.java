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
	//comentaire
}
