package fr.eni.lesencheres.bo;

import java.util.ArrayList;
import java.util.List;

// Liée à la BDD avec la table : categorie
public class Categorie {
	
	// ATTRIBUTS
	private int numCategorie; //no_categorie / clé primaire
	private String libelle; // libelle / TO DO : pas + de 30 caractères en BLL
	private List<Article> listeArticleCategorie;
	
	//CONSTRUCTEURS
	//Constructeur par défault
	public Categorie() {
		this.listeArticleCategorie = new ArrayList<>();
	}

	//Constructeur avec uniquement libelle de renseigné
	public Categorie(String libelle) {
		this.libelle=libelle;
		this.listeArticleCategorie = new ArrayList<>();
	}
	//Constructeur complet
	public Categorie(int numCategorie, String libelle, List<Article> listeArticleCategorie) {
		super();
		this.numCategorie = numCategorie;
		this.libelle = libelle;
		this.listeArticleCategorie = new ArrayList<>();
	}

	
	//GETTERS
	public int getNumCategorie() {
		return numCategorie;
	}

	public String getLibelle() {
		return libelle;
	}

	public List<Article> getListeArticleCategorie() {
		return listeArticleCategorie;
	}

	
	//SETTERS
	public void setNumCategorie(int numCategorie) {
		this.numCategorie = numCategorie;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public void setListeArticleCategorie(List<Article> listeArticleCategorie) {
		this.listeArticleCategorie = listeArticleCategorie;
	}

	
	//METHODES
	@Override
	public String toString() {
		return "Categorie [numCategorie=" + numCategorie + ", libelle=" + libelle + ", listeArticleCategorie="
				+ listeArticleCategorie + "]";
	}

	
	
}
