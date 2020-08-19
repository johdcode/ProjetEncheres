package fr.eni.projet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.projet.bll.UtilisateurManager;

/**
 * Servlet implementation class Connexion
 */
@WebServlet("/ConnexionServlet")
public class ConnexionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd =this.getServletContext().getRequestDispatcher("/WEB-INF/Connexion.jsp");
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String seSouvenirDeMoi = request.getParameter("seSouvenirDeMoi");
		String identifiant =request.getParameter("identifiant");
		String motDePasse =request.getParameter("motDePasse");
		String messageAuthentification = "Le mot de passe ou l'idenfiant est incorrect";
		HttpSession session = request.getSession();
		
		boolean authentification;
		UtilisateurManager um = UtilisateurManager.getInstance();
		authentification = um.authentification(identifiant, motDePasse);
				
		if(authentification=!true) {
			RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/WEB-INF/Connexion.jsp"); 
			System.out.println("connecté");
		}
		else {
			if(seSouvenirDeMoi.contentEquals("seSouvenirDeMoi")) {
				session.setAttribute("utilisateur", um.selectById(identifiant,motDePasse));
			}
			RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/WEB-INF/Accueil.jsp"); 
		}
		
		
		
	}

}
