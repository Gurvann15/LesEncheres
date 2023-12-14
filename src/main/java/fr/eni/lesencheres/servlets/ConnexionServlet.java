package fr.eni.lesencheres.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import fr.eni.lesencheres.bll.UtilisateurManager;
import fr.eni.lesencheres.bo.Utilisateur;
import fr.eni.lesencheres.dal.DAOFactory;
import fr.eni.lesencheres.messages.ErrorManager;
import fr.eni.lesencheres.messages.ErrorMessage;

/**
 * Servlet implementation class ConnexionServlet
 */
public class ConnexionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UtilisateurManager utilisateurManager = new UtilisateurManager(DAOFactory.getUtilisateurDAO());

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/connexion.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String identifiant = request.getParameter("identifiant");
		String password = request.getParameter("password");
		try {
			Utilisateur utilisateur = utilisateurManager.getUtilisateurByPseudo(identifiant);

			if (utilisateur != null && utilisateur.getPassword().equals(password)) {
				// Création d'un cookie sur le pseudo, qu'on va garder un mois
				Cookie pseudoCookie = new Cookie("pseudo", utilisateur.getPseudo());
                pseudoCookie.setMaxAge(30 * 24 * 60 * 60);
                response.addCookie(pseudoCookie);
                // Gestion de la session
                HttpSession session = request.getSession();
                session.setAttribute("pseudo", identifiant);
                session.setAttribute("utilisateurConnecte", true);
                // Requête réussie
				RequestDispatcher dispatcher = request.getRequestDispatcher("/accueil");
				dispatcher.forward(request, response);
			} else {
				request.setAttribute("erreur", ErrorMessage.getMessage("connexionError"));
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/connexion.jsp");
				dispatcher.forward(request, response);
			}
		} catch (ErrorManager e) {
			request.setAttribute("erreur", e.getMessage());
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/connexion.jsp");
			dispatcher.forward(request, response);
		}
	}
}

