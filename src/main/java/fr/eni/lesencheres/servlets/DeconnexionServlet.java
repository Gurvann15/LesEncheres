package fr.eni.lesencheres.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import fr.eni.lesencheres.bll.ArticleManager;
import fr.eni.lesencheres.bll.CategorieManager;
import fr.eni.lesencheres.bo.Article;
import fr.eni.lesencheres.bo.Categorie;
import fr.eni.lesencheres.dal.DAOFactory;

/**
 * Servlet implementation class DeconnexionServlet
 */
public class DeconnexionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CategorieManager categorieManager = new CategorieManager(DAOFactory.getCategorieDAO());
	private ArticleManager articleManager = new ArticleManager(DAOFactory.getArticleDAO());




	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Categorie> categories = categorieManager.getAllCategories();
		if (categories != null) {
			request.setAttribute("categories", categories);
		}
		List<Article> articles = articleManager.getAllArticle();
		if (articles != null) {
			request.setAttribute("articles", articles);}
			HttpSession session = request.getSession();
			// Retirer le pseudo de la session
			session.removeAttribute("pseudo");
			session.setAttribute("utilisateurConnecte", false);
			// Invalider la session
			session.invalidate();
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/accueil.jsp");
			dispatcher.forward(request, response);
		}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
