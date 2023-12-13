package fr.eni.lesencheres.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import fr.eni.lesencheres.bll.UtilisateurManager;
import fr.eni.lesencheres.bo.Utilisateur;
import fr.eni.lesencheres.dal.DAOFactory;
import fr.eni.lesencheres.messages.ErrorManager;
import fr.eni.lesencheres.messages.ErrorMessage;

public class InscriptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UtilisateurManager utilisateurManager = new UtilisateurManager(DAOFactory.getUtilisateurDAO());

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/inscription.jsp");
		dispatcher.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("erreur", " ");
		String pseudo = request.getParameter("pseudo");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String email = request.getParameter("email");
		String telephone = request.getParameter("telephone");
		String rue = request.getParameter("rue");
		String ville = request.getParameter("ville");
		String codePostal = request.getParameter("codePostal");
		String password = request.getParameter("password");
		String confirmation = request.getParameter("confirmation");
		try {
			//Vérifie que tous les champs obligatoires sont bien renseignés
			if(pseudo.isEmpty() | nom.isEmpty() | prenom.isEmpty() | email.isEmpty() | rue.isEmpty() | 
					ville.isEmpty() | codePostal.isEmpty() | password.isEmpty() | confirmation.isEmpty()) {
				request.setAttribute("erreur", ErrorMessage.getMessage("infoObligatoire"));
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/inscription.jsp");
				dispatcher.forward(request, response);
			}
			// Vérifie que le mail n'est pas déjà utilisé 
			Utilisateur utilisateur = utilisateurManager.getUtilisateurByEmail(email);
			if (utilisateur != null) {
				request.setAttribute("erreur", ErrorMessage.getMessage("mailExistant"));
				RequestDispatcher dispatcher = request.getRequestDispatcher("/inscription");
				dispatcher.forward(request, response);
			}
			// Vérifie que le pseudo n'est pas déjà utilisé
			Utilisateur utilisateur2 = utilisateurManager.getUtilisateurByPseudo(pseudo);
			if (utilisateur2 != null) {
				request.setAttribute("erreur", ErrorMessage.getMessage("utilisateurDejaExistant"));
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/inscription.jsp");
				dispatcher.forward(request, response);
			}else {
			    Utilisateur nouveauUtilisateur = new Utilisateur();
			    nouveauUtilisateur.setAdministrateur(false);
			    nouveauUtilisateur.setPseudo(pseudo);
			    nouveauUtilisateur.setNom(nom);
			    nouveauUtilisateur.setPrenom(prenom);
			    nouveauUtilisateur.setEmail(email);
			    nouveauUtilisateur.setTelephone(telephone);
			    nouveauUtilisateur.setRue(rue);
			    nouveauUtilisateur.setVille(ville);
			    nouveauUtilisateur.setCodePostal(codePostal);
			    nouveauUtilisateur.setCredit(0);
			    if (!password.equals(confirmation)) {
			        request.setAttribute("erreur", ErrorMessage.getMessage("motPasseNonIdentique"));
			        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/inscription.jsp");
					dispatcher.forward(request, response);
			    } else {
			    	nouveauUtilisateur.setPassword(password);
			        utilisateurManager.createUtilisateur(nouveauUtilisateur);
			        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/accueil.jsp");
					dispatcher.forward(request, response);
			    }
			}

		} catch (ErrorManager e) {
			request.setAttribute("erreur", e.getMessage());
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/inscription.jsp");
			dispatcher.forward(request, response);
		}
	}

}
