package fr.eni.lesencheres.bo;

import java.util.ArrayList;
import java.util.List;

public class Retrait {
	
	private String rue; 
	private String codePostal; 
	private String ville;
	private List<Article> listeArticles;
	
	//Constructeur par défaut
    public Retrait(){
    	this.listeArticles = new ArrayList();
    }
    
  //Constructeur complet
    public Retrait(String rue, String codePostal, String ville ) {
    	this.rue = rue; 
    	this.codePostal = codePostal; 
    	this.ville = ville; 
    	this.listeArticles = new ArrayList();
    }

}
