package fr.eni.lesencheres.bo;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;


public class Article {
	
	private int noArticle;
	private String nomArticle;
	private String description;
	private LocalDate dateDebutEncheres;
	private LocalDate dateFinEncheres;
	private int prixInitial;
	private int prixVente;
	private Utilisateur noUtilisateur;
	private Utilisateur pseudo;
	private Categorie noCategorie;
	private Categorie libelle;
	private List<Enchere> listeEncheres;
	
	//Constructeur par défaut 
	public Article() {
	    this.noUtilisateur = new Utilisateur(); // Initialisation avec un nouvel utilisateur par défaut
	    this.pseudo = new Utilisateur();
	    this.noCategorie = new Categorie(); // Initialisation avec une nouvelle catégorie par défaut
	    this.libelle = new Categorie();
	    this.listeEncheres = new ArrayList<>();	
	}
	
	//Constructeur complet
	public Article(int noArticle, String nomArticle, String description, LocalDate dateDebutEncheres, LocalDate dateFinEncheres, int prixInitial, int prixVente) {
		this.noArticle = noArticle; 
		this.nomArticle = nomArticle; 
		this.description = description; 
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = dateFinEncheres; 
		this.prixInitial = prixInitial;
		this.prixVente = prixVente;
		this.noUtilisateur = new Utilisateur();
		this.pseudo = new Utilisateur();
		this.noCategorie = new Categorie();
		this.libelle = new Categorie();
		this.listeEncheres = new ArrayList();
			
	}
	
	//GETTERS

	public int getNoArticle() {
		return noArticle;
	}

	public String getNomArticle() {
		return nomArticle;
	}

	public String getDescription() {
		return description;
	}

	public LocalDate getDateDebutEncheres() {
		return dateDebutEncheres;
	}

	public LocalDate getDateFinEncheres() {
		return dateFinEncheres;
	}

	public int getPrixInitial() {
		return prixInitial;
	}

	public int getPrixVente() {
		return prixVente;
	}

	public Utilisateur getNoUtilisateur() {
		return noUtilisateur;
	}

	public Utilisateur getPseudo() {
		return pseudo;
	}

	public Categorie getNoCategorie() {
		return noCategorie;
	}

	public Categorie getLibelle() {
		return libelle;
	}
	
	//SETTERS

	public List<Enchere> getListeEncheres() {
		return listeEncheres;
	}

	public void setNoArticle(int noArticle) {
		this.noArticle = noArticle;
	}

	public void setNomArticle(String nomArticle) {
		this.nomArticle = nomArticle;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setDateDebutEncheres(LocalDate dateDebutEncheres) {
		this.dateDebutEncheres = dateDebutEncheres;
	}

	public void setDateFinEncheres(LocalDate dateFinEncheres) {
		this.dateFinEncheres = dateFinEncheres;
	}

	public void setPrixInitial(int prixInitial) {
		this.prixInitial = prixInitial;
	}

	public void setPrixVente(int prixVente) {
		this.prixVente = prixVente;
	}

	public void setNoUtilisateur(Utilisateur noUtilisateur) {
		this.noUtilisateur = noUtilisateur;
	}

	public void setPseudo(Utilisateur pseudo) {
		this.pseudo = pseudo;
	}

	public void setNoCategorie(Categorie noCategorie) {
		this.noCategorie = noCategorie;
	}

	public void setLibelle(Categorie libelle) {
		this.libelle = libelle;
	}

	public void setListeEncheres(List<Enchere> listeEncheres) {
		this.listeEncheres = listeEncheres;
	}
		

}
