package fr.eni.projet.ihm;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;
import fr.eni.projet.bll.UtilisateurManager;
import fr.eni.projet.bo.Utilisateur;

/**
 * Servlet implementation class Connexion
 */
@WebServlet("/connexion")
public class ConnexionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger connexionLogger = (Logger) LoggerFactory.getLogger("fr.eni.projet.ihm.ConnexionServlet");
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Utilisateur connecté
		HttpSession session = request.getSession();
		SessionService.checkUtilisateurSession(request);
		
	
		this.getServletContext().getRequestDispatcher("/WEB-INF/templates/Connexion.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		String seSouvenirDeMoi = request.getParameter("seSouvenirDeMoi");
		String identifiant =request.getParameter("identifiant");
		String motDePasse =request.getParameter("motDePasse");
		String messageAuthentification = "Le mot de passe ou l'idenfiant est incorrect";
		
		int erreur = 0;
		
		if(identifiant == null || identifiant == "") {
			erreur++;
		}
		if(identifiant != null && identifiant.length() >= 30) {
			erreur++;
		}
		if(motDePasse == null || motDePasse == "") {
			erreur++;
		}
		if(motDePasse != null && motDePasse.length() >= 30) {
			erreur++;
		}
		
		System.out.println("Erreurs : " + erreur);
		// Si il n'y a pas d'erreur et que l'utilisateur n'est pas encore connecté
		if((erreur == 0) && (session.getAttribute("utilisateurSession") == null)) {		
			UtilisateurManager utilisateurManager = UtilisateurManager.getInstance();
			Utilisateur u = utilisateurManager.authentification(identifiant, motDePasse);
			
			if(u != null) {
//				session.setAttribute("utilisateurSession", u);
				SessionService.setUtilisateurSessionId(request, u.getNoUtilisateur());
				connexionLogger.info("Connexion utilisateur n°"+session.getAttribute("utilisateurSessionId"));
				response.sendRedirect(request.getContextPath() + "/encheres"); 
				System.out.println("Utilisateur connecté");
			} else  {
				System.out.println("La connexion a échoué");
				response.sendRedirect(request.getContextPath() + "/connexion"); 
//				RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/WEB-INF/Accueil.jsp"); 
				erreur++;
			}
		}	
//		else {
//			
//			if(seSouvenirDeMoi.contentEquals("seSouvenirDeMoi")) {
//				session.setAttribute("suiviSession", seSouvenirDeMoi);
//				
//			}
//			RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/WEB-INF/Connexion.jsp"); 
//		}
		
		
		
	}

}
