package fr.eni.lesencheres.bo;

import java.util.ArrayList;
import java.util.List;

public class Categorie {
	
	private int noCategorie;
	private String libelle;
	private List<Article> listeArticles;
	
	//Constructeur par défaut
	public Categorie () {
		this.listeArticles = new ArrayList();
	}
	
	//constructeur complet
	public Categorie (int noCategorie, String libelle) {
		this.noCategorie = noCategorie; 
		this.libelle = libelle;
		this.listeArticles = new ArrayList();
	}
	

}
