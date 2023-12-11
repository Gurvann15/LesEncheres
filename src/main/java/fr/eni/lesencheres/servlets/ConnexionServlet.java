package fr.eni.lesencheres.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import fr.eni.lesencheres.bll.UtilisateurManager;
import fr.eni.lesencheres.bo.Utilisateur;
import fr.eni.lesencheres.dal.DAOFactory;
import fr.eni.lesencheres.messages.ErrorManager;

/**
 * Servlet implementation class ConnexionServlet
 */
public class ConnexionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UtilisateurManager utilisateurManager = new UtilisateurManager(DAOFactory.getUtilisateurDAO());

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
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
			System.out.println(utilisateur);
			System.out.println("Mot de pass fourni = " + password);
			System.out.println("Mot de pass en bdd = " + utilisateur.getPassword());

			// Valider le mot de passe
			if (utilisateur != null && utilisateur.getPassword().equals(password)) {
				// Authentification réussie, rediriger vers une page de succès
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/accueil.jsp");
				dispatcher.forward(request, response);
			} else {
				// Authentification échouée, rediriger vers la page de connexion avec un message d'erreur
				request.setAttribute("erreur", "Identifiant ou mot de passe incorrect");
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

