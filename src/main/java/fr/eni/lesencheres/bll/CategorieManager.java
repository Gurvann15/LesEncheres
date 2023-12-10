package fr.eni.lesencheres.bll;

import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.ResourceBundle;

import fr.eni.lesencheres.bo.Categorie;
import fr.eni.lesencheres.dal.DAOFactory;
import fr.eni.lesencheres.dal.GenericDAO;
import fr.eni.lesencheres.messages.ErrorManager;
import fr.eni.lesencheres.messages.ErrorMessage;

public class CategorieManager {

	GenericDAO<Categorie> categorieDAO = DAOFactory.getCategorieDAO();
	String errorMessage;

	public CategorieManager(GenericDAO<Categorie> categorieDAO) {
		this.categorieDAO = categorieDAO;
	}

	public List<Categorie> getAllCategories() {
		try {
			return categorieDAO.getAll();
		}catch (ErrorManager e){
			gestionErreur("erreurRecuperationCategorie",e);
			throw new ErrorManager(errorMessage);
		}
	}

	public Categorie getCategorieById(int id) {
		try{
			Categorie categorie = categorieDAO.getById(id);
			validerCategorie(categorie);
			return categorie;
		}catch(ErrorManager e) {
			gestionErreur("categorieIntrouvable",e);
			throw new ErrorManager(errorMessage);
		}
	}

	public void createCategorie(Categorie c) {
		if (categorieExisteEnLocal(c.getNumCategorie())){
			errorMessage = ErrorMessage.getMessage("categorieDejaExistante");
			throw new ErrorManager(errorMessage);
		}
		else if (getCategorieById(c.getNumCategorie()) != null){
			errorMessage = ErrorMessage.getMessage("categorieDejaExistante");
			throw new ErrorManager(errorMessage);
		}else {
			try {
				validerCategorie(c);
				categorieDAO.create(c);
			}catch (Exception e){
				gestionErreur("categorieNonAjoutee",e);
				throw new ErrorManager(errorMessage);
			}
		}
	}

	public void updateCategorie(Categorie c) {
		try {
			validerCategorie(c);
			categorieDAO.update(c);
		} catch (Exception e) {
			gestionErreur("categorieNonModifee",e);
			throw new ErrorManager(errorMessage);
		}

	}

	public void deleteCategorie(int id) {
		try {
			Categorie c = getCategorieById(id);
			validerCategorie(c);
			categorieDAO.delete(id);
		} catch (Exception e) {
			gestionErreur("categorieNonSupprimee",e);
			throw new ErrorManager(errorMessage);
		}
	}


	// METHODES PRIVEES

	private void validerCategorie(Categorie c) {
		String errorMessage=null;
		Objects.requireNonNull(c, ErrorMessage.getMessage("articleInexistant"));
		if (c.getLibelle()==null) {
			errorMessage = ErrorMessage.getMessage("libelleObligatoire");
		}
		else if(c.getLibelle().length() >30 ||c.getLibelle().length() == 0) {
			errorMessage = ErrorMessage.getMessage("longueurLibelle");
		}
		else if(c.getNumCategorie()<=0) {
			errorMessage = ErrorMessage.getMessage("numeroCategorieInadaptee");
		}
		if(errorMessage!=null) {
			throw new ErrorManager(errorMessage);
		}
	}

	private void gestionErreur(String errorCode, Exception e) {
		errorMessage = ErrorMessage.getMessage(errorCode);
		e.printStackTrace();
	}

	private boolean categorieExisteEnLocal(int id) {
		List<Categorie> liste = categorieDAO.getAll();
		for (Categorie c : liste) {
			if (c.getNumCategorie() == id) {
				return true;
			}
		}
		return false;
	}

}
