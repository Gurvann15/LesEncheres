package fr.eni.lesencheres.bo;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public class Enchere {
	
	private LocalDate dateEnchere;
	private int montantEnchere;
	private List<Utilisateur> listeUtilisateurs;
	private Article article; 
	
	//Constructeur par défaut
	public Enchere() {
		this.listeUtilisateurs = new ArrayList();
		this.article = new Article();
	}
	
	//Constructeur complet
	public Enchere(LocalDate dateEnchere, int montantEnchere) {
		this.dateEnchere = dateEnchere;
		this.montantEnchere = montantEnchere;
		this.listeUtilisateurs = new ArrayList();
		this.article = new Article();
	}

}
