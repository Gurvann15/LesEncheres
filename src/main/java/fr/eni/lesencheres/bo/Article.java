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
	
	
	
	
	
	/*

  `prix_initial` int DEFAULT NULL,
  `prix_vente` int DEFAULT NULL,
  `no_utilisateur` int NOT NULL,
  `no_categorie` int NOT NULL,
  
  KEY `FK_articles_vendus_categories` (`no_categorie`),
  KEY `FK_articles_vendus_utilisateurs_2` (`no_utilisateur`),
  CONSTRAINT `FK_articles_vendus_categories` FOREIGN KEY (`no_categorie`) REFERENCES `categories` (`no_categorie`),
  CONSTRAINT `FK_articles_vendus_utilisateurs` FOREIGN KEY (`no_utilisateur`) REFERENCES `utilisateurs` (`no_utilisateur`),
  CONSTRAINT `FK_articles_vendus_utilisateurs_2` FOREIGN KEY (`no_utilisateur`) REFERENCES `utilisateurs` (`no_utilisateur`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;*/
}
