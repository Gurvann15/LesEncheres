package fr.eni.lesencheres.bo;

import java.util.List;

// Liée à la BDD avec la table : categorie
public class Categorie {
	// ATTRIBUTS
	private int numCategorie; //no_categorie / clé primaire
	private String libelle; // libelle / TO DO : pas + de 30 caractères en BLL
	private List<Article> listeArticleCategorie;

}
