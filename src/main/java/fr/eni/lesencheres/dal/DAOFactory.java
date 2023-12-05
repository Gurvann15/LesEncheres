package fr.eni.lesencheres.dal;

import fr.eni.lesencheres.bo.Article;
import fr.eni.lesencheres.bo.Categorie;
import fr.eni.lesencheres.bo.Enchere;
import fr.eni.lesencheres.bo.Retrait;
import fr.eni.lesencheres.bo.Utilisateur;

public class DAOFactory {
	
	public static GenericDAO<Article> getArticleDAO(){return new ArticleDAO();}
	public static GenericDAO<Categorie> getCategorieDAO(){return new CategorieDAO();}
	public static GenericDAO<Enchere> getEnchereDAO(){return new EnchereDAO();}
	public static GenericDAO<Retrait> getRetraitDAO(){return new RetraitDAO();}
	public static GenericDAO<Utilisateur> getUtilisateurDAO(){return new UtilisateurDAO();}

}
