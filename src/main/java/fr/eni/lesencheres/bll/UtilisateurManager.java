package fr.eni.lesencheres.bll;

import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;


import fr.eni.lesencheres.bo.Utilisateur;
import fr.eni.lesencheres.dal.DAOFactory;
import fr.eni.lesencheres.dal.GenericDAO;
import fr.eni.lesencheres.messages.ErrorManager;
import fr.eni.lesencheres.messages.ErrorMessage;

public class UtilisateurManager {
	GenericDAO<Utilisateur> utilisateurDAO = DAOFactory.getUtilisateurDAO();
	String errorMessage;
	private static final String PASS_REGEX = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[!@#$%^&*()_+\\\\-=\\\\[\\\\]{};':\\\"\\\\\\\\|,.<>\\\\/?]).{10,}$";
	private static final String EMAIL_REGEX = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}$";
	
	public UtilisateurManager(GenericDAO<Utilisateur> utilisateurDAO) {
		this.utilisateurDAO = utilisateurDAO;
	}

	public Utilisateur getUtilisateurById(int id) {
		try{
			Utilisateur utilisateur = utilisateurDAO.getById(id);
			validerUtilisateur(utilisateur);
			return utilisateur;
		}catch(ErrorManager e) {
			gestionErreur("utilisateurInexistant",e);
			throw new ErrorManager(errorMessage);
		}
	}

	public List<Utilisateur> getAllCategories() {
		try {
			return utilisateurDAO.getAll();
		}catch (ErrorManager e){
			gestionErreur("erreurRecuperationUtilisateurs",e);
			throw new ErrorManager(errorMessage);
		}
	}

	public void createUtilisateur(Utilisateur u) {
    	if (utilisateurExisteEnLocal(u.getNumUtilisateur())){
        	errorMessage = ErrorMessage.getMessage("utilisateurDejaExistant");
        	throw new ErrorManager(errorMessage);
        }
    	else if (getUtilisateurById(u.getNumUtilisateur()) != null){
        	errorMessage = ErrorMessage.getMessage("utilisateurDejaExistant");
        	throw new ErrorManager(errorMessage);
        }else {
        try {
            validerUtilisateur(u);
            utilisateurDAO.create(u);
        }catch (Exception e){
        	gestionErreur("utilisateurNonAjoute",e);
			throw new ErrorManager(errorMessage);
        }
        }
    }

	public void updateUtilisateur(Utilisateur u) {
		try {
			validerUtilisateur(u);
			utilisateurDAO.update(u);
		} catch (Exception e) {
			gestionErreur("utilisateurNonModifie",e);
			throw new ErrorManager(errorMessage);
		}

	}

	public void deleteUtilisateur(int id) {
		try {
			Utilisateur u = getUtilisateurById(id);
			validerUtilisateur(u);
			utilisateurDAO.delete(id);
		} catch (Exception e) {
			gestionErreur("utilisateurNonSupprime",e);
			throw new ErrorManager(errorMessage);
		}
	}
	
	// METHODES PRIVEES
	
	private void validerUtilisateur(Utilisateur u) {
		String errorMessage=null;
		Objects.requireNonNull(u, ErrorMessage.getMessage("utilisateurInexistant"));
		if(u.getPseudo() == null || 
				u.getNom()== null ||
				u.getPrenom() == null  ||
				u.getEmail() == null ||
				u.getRue()== null  ||
				u.getCodePostal()== null  ||
				u.getVille()== null  ||
				u.getPassword() == null ||
				u.getCredit() < 0 ||
				u.isAdministrateur() != (true|false))  {
			errorMessage = ErrorMessage.getMessage("infoObligatoire");
		}
		else if(u.getPseudo().length()>30 || 
				u.getNom().length() > 30 ||
				u.getPrenom().length() >30 ||
				u.getEmail().length() >20 ||
				u.getTelephone().length() > 15 ||
				u.getRue().length() > 30 ||
				u.getCodePostal().length() > 10 ||
				u.getVille().length() > 30 ||
				u.getPassword().length() > 30) {
			errorMessage = ErrorMessage.getMessage("longueurChamp");
		}
		else if(verifPassword(u.getPassword()) == false) {
			errorMessage = ErrorMessage.getMessage("motPassNonNorme");
		}
		else if(verifEmail(u.getEmail()) == false) {
			errorMessage = ErrorMessage.getMessage("emailNonNorme");
		}
		if(errorMessage!=null) {
			throw new ErrorManager(errorMessage);
		}
	}
	
	private boolean verifPassword(String password) {
		Pattern pattern = Pattern.compile(PASS_REGEX);
        java.util.regex.Matcher matcher = pattern.matcher(password);
		return matcher.matches();
	}
	
	private boolean verifEmail(String email) {
		Pattern pattern = Pattern.compile(EMAIL_REGEX);
        java.util.regex.Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}

	private void gestionErreur(String errorCode, Exception e) {
		errorMessage = ErrorMessage.getMessage(errorCode);
		e.printStackTrace();
	}
	
	private boolean utilisateurExisteEnLocal(int id) {
        List<Utilisateur> liste = utilisateurDAO.getAll();
        for (Utilisateur u : liste) {
            if (u.getNumUtilisateur() == id) {
                return true;
            }
        }
        return false;
    }

}
