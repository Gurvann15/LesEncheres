package fr.eni.lesencheres.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
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
			// Récupérer l'utilisateur par son identifiant (ici, supposons que l'identifiant est le pseudo)
			Utilisateur utilisateur = utilisateurManager.getUtilisateurByPseudo(identifiant);

			// Valider le mot de passe
			if (utilisateur != null && utilisateur.getPassword().equals(password)) {
				Cookie pseudoCookie = new Cookie("pseudo", utilisateur.getPseudo());
                // Cookie gardé pendant 1 semaine
                pseudoCookie.setMaxAge(30 * 24 * 60 * 60);
                // Ajouter le cookie à la réponse
                response.addCookie(pseudoCookie);
				// Authentification réussie, rediriger vers une page de succès
				RequestDispatcher dispatcher = request.getRequestDispatcher("/accueil");
				dispatcher.forward(request, response);
			} else {
				// Authentification échouée, rediriger vers la page de connexion avec un message d'erreur
				request.setAttribute("erreur", ErrorMessage.getMessage("connexionError"));
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/connexion.jsp");
				dispatcher.forward(request, response);
			}
		} catch (ErrorManager e) {
			// Gérer les erreurs, rediriger vers la page de connexion avec un message d'erreur
			request.setAttribute("erreur", e.getMessage());
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/connexion.jsp");
			dispatcher.forward(request, response);
		}
	}
}

