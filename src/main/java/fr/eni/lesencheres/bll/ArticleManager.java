package fr.eni.lesencheres.bll;

import java.util.List;

import fr.eni.lesencheres.bo.Article;
import fr.eni.lesencheres.bo.Utilisateur;
import fr.eni.lesencheres.dal.DAOFactory;
import fr.eni.lesencheres.dal.GenericDAO;
import fr.eni.lesencheres.messages.ErrorManager;
import fr.eni.lesencheres.messages.ErrorMessage;

public class ArticleManager {
	GenericDAO<Article> articleDAO = DAOFactory.getArticleDAO();
	String errorMessage;

	public ArticleManager(GenericDAO<Article> articleDAO) {
		this.articleDAO = articleDAO;
	}

	public Article getArticleById(int id) {
		try{
			Article article = articleDAO.getById(id);
			validerArticle(article);
			return article;
		}catch(ErrorManager e) {
			gestionErreur("articleInexistant",e);
			throw new ErrorManager(errorMessage);
		}
	}
	
	public List<Article> getAllArticle() {
		try {
			return articleDAO.getAll();
		}catch (ErrorManager e){
			gestionErreur("erreurRecuperationArticle",e);
			throw new ErrorManager(errorMessage);
		}
	}
	
	public void createArticle(Article a) {
		if (ArticleExisteEnLocal(a.getNumArticle())){
			errorMessage = ErrorMessage.getMessage("articleDejaExistant");
			throw new ErrorManager(errorMessage);
		}
		else if (getArticleById(a.getNumArticle()) != null){
			errorMessage = ErrorMessage.getMessage("articleDejaExistant");
			throw new ErrorManager(errorMessage);
		}else {
			try {
				articleDAO.create(a);
				validerArticle(a);
			}catch (Exception e){
				gestionErreur("articleNonAjoute",e);
				throw new ErrorManager(errorMessage);
			}
		}
	}
	
	public void updateArticle(Article a) {
		try {
			validerArticle(a);
			articleDAO.update(a);
		} catch (Exception e) {
			gestionErreur("articleNonModifie",e);
			throw new ErrorManager(errorMessage);
		}

	}

	public void deleteArticle(int id) {
		try {
			Article a = getArticleById(id);
			validerArticle(a);
			articleDAO.delete(id);
		} catch (Exception e) {
			gestionErreur("articleNonSupprime",e);
			throw new ErrorManager(errorMessage);
		}
	}
	// METHODES PRIVEES

	private void validerArticle(Article a) {
		String errorMessage=null;
		if (a == null) {
			errorMessage = ErrorMessage.getMessage("articleInexistant");
		}else {
			if(a.getNomArticle()==null ||
					a.getDescription() == null ||
					a.getDateDebutEnchere() == null ||
					a.getDateFinEnchere() == null ||
					a.getUtilisateurAcheteur() ==null ||
					a.getCategorie() == null){
				errorMessage = ErrorMessage.getMessage("champArticleObligatoire");
			}
			else if(a.getNomArticle().length()>30 ||
					a.getDescription().length() >300) {
				errorMessage = ErrorMessage.getMessage("longueurChamp");
			}
		}
	}

	private void gestionErreur(String errorCode, Exception e) {
		errorMessage = ErrorMessage.getMessage(errorCode);
		e.printStackTrace();
	}

	private boolean ArticleExisteEnLocal(int id) {
		List<Article> liste = articleDAO.getAll();
		for (Article a : liste) {
			if (a.getNumArticle() == id) {
				return true;
			}
		}
		return false;
	}
}
