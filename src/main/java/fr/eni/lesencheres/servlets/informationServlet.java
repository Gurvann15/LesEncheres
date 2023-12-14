package fr.eni.lesencheres.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import fr.eni.lesencheres.bll.UtilisateurManager;
import fr.eni.lesencheres.bo.Utilisateur;
import fr.eni.lesencheres.dal.DAOFactory;

/**
 * Servlet implementation class informationServlet
 */
public class informationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UtilisateurManager utilisateurManager = new UtilisateurManager(DAOFactory.getUtilisateurDAO());
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    HttpSession session = request.getSession();
	    String pseudo = (String) session.getAttribute("pseudo");
	    Utilisateur utilisateur = utilisateurManager.getUtilisateurByPseudo(pseudo);
	    request.setAttribute("pseudoEnCours", utilisateur);
	    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/information.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
