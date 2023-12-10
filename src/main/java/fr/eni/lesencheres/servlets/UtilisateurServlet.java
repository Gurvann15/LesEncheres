package fr.eni.lesencheres.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import fr.eni.lesencheres.bll.UtilisateurManager;
import fr.eni.lesencheres.bo.Utilisateur;
import fr.eni.lesencheres.dal.DAOFactory;

/**
 * Servlet implementation class UtilisateurServlet
 */
public class UtilisateurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        UtilisateurManager utilisateurManager = new UtilisateurManager(DAOFactory.getUtilisateurDAO());
        List<Utilisateur> utilisateurs = utilisateurManager.getAllCategories();

        request.setAttribute("utilisateurs", utilisateurs);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/utilisateur.jsp");
        dispatcher.forward(request, response);
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
