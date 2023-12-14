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

import fr.eni.lesencheres.bll.UtilisateurManager;
import fr.eni.lesencheres.bo.Utilisateur;
import fr.eni.lesencheres.dal.DAOFactory;
import fr.eni.lesencheres.messages.ErrorManager;
import fr.eni.lesencheres.messages.ErrorMessage;

public class ModificationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UtilisateurManager utilisateurManager = new UtilisateurManager(DAOFactory.getUtilisateurDAO());
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/modificationProfil.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pseudo,nom,prenom,email,telephone,rue,ville,codePostal,password,confirmation;
		String identifiant = null;
		HttpSession session = request.getSession();
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("pseudoCookie")) {
					identifiant = cookie.getValue();
					session.setAttribute("pseudoCookie", identifiant);
					break;
				}
			}
		}
		if(identifiant !=null) {
			Utilisateur utilisateur = utilisateurManager.getUtilisateurByPseudo(identifiant);	

			int credit = utilisateur.getCredit();

			if(request.getParameter("pseudo") != null) {
				pseudo = request.getParameter("pseudo");
				Utilisateur utilisateur3 = utilisateurManager.getUtilisateurByPseudo(pseudo);
				if (utilisateur3 != null) {
					request.setAttribute("erreur", ErrorMessage.getMessage("utilisateurDejaExistant"));
					RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/modificationProfil.jsp");
					dispatcher.forward(request, response);
				}

			}else {
				pseudo = utilisateur.getPseudo();
			}

			if(request.getParameter("nom") != null) {
				nom = request.getParameter("nom");
			}else {
				nom = utilisateur.getNom();
			}

			if(request.getParameter("prenom") != null) {
				prenom = request.getParameter("prenom");
			}else {
				prenom = utilisateur.getPrenom();
			}

			if(request.getParameter("email") != null) {
				email = request.getParameter("email");
			}else {
				email = utilisateur.getEmail();
			}

			if(request.getParameter("telephone") != null) {
				telephone = request.getParameter("telephone");
			}else {
				telephone = utilisateur.getTelephone();
			}

			if(request.getParameter("rue") != null) {
				rue = request.getParameter("rue");
			}else {
				rue = utilisateur.getRue();
			}

			if(request.getParameter("ville") != null) {
				ville = request.getParameter("ville");
			}else {
				ville = utilisateur.getVille();
			}

			if(request.getParameter("codePostal") != null) {
				codePostal = request.getParameter("codePostal");
			}else {
				codePostal = utilisateur.getCodePostal();
			}

			if(request.getParameter("password") != null && request.getParameter("confirmation") != null) {
				confirmation = request.getParameter("confirmation");
				if(request.getParameter("password").equals(confirmation)) {
					password = request.getParameter("password");
				}else {
					password = utilisateur.getPassword();
				}}
			else {
				password = utilisateur.getPassword();
			}

			try {
				//Vérifie que tous les champs obligatoires sont bien renseignés
				if(pseudo.isEmpty() 
						|| nom.isEmpty() 
						|| prenom.isEmpty() 
						|| email.isEmpty() 
						|| rue.isEmpty() 
						|| ville.isEmpty() 
						|| codePostal.isEmpty() 
						|| password.isEmpty()) {
					request.setAttribute("erreur", ErrorMessage.getMessage("infoObligatoire"));
					RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/modificationProfil.jsp");
					dispatcher.forward(request, response);
				}
				// Vérifie que le mail n'est pas déjà utilisé 
				Utilisateur utilisateur2 = utilisateurManager.getUtilisateurByEmail(email);
				if (utilisateur2 != null) {
					request.setAttribute("erreur", ErrorMessage.getMessage("mailExistant"));
					RequestDispatcher dispatcher = request.getRequestDispatcher("/inscription");
					dispatcher.forward(request, response);
				}
				else {

					utilisateur.setPseudo(pseudo);
					utilisateur.setNom(nom);
					utilisateur.setPrenom(prenom);
					utilisateur.setEmail(email);
					utilisateur.setTelephone(telephone);
					utilisateur.setRue(rue);
					utilisateur.setVille(ville);
					utilisateur.setCodePostal(codePostal);
					utilisateur.setCredit(credit);
					utilisateur.setAdministrateur(false);
					utilisateurManager.updateUtilisateur(utilisateur);
					RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/info.jsp");
					dispatcher.forward(request, response);
				}


			} catch (ErrorManager e) {
				request.setAttribute("erreur", e.getMessage());
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/modificationProfil.jsp");
				dispatcher.forward(request, response);
			}
		}
		else {
			request.setAttribute("erreur", ErrorMessage.getMessage("utilisateurNonModifie"));
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/modificationProfil.jsp");
			dispatcher.forward(request, response);
		}}

}

