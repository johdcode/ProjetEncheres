package fr.eni.projet.ihm;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.projet.bll.UtilisateurManager;
import fr.eni.projet.bo.Utilisateur;

/**
 * Servlet implementation class InscriptionServlet
 */
@WebServlet("/inscription")
public class InscriptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UtilisateurManager utilisateurManager = UtilisateurManager.getInstance();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Utilisateur connecté
		HttpSession session = request.getSession();
		System.out.println(session.getAttribute("utilisateurSession"));
		if(session.getAttribute("utilisateurSession") != null) {
			request.setAttribute("connecte", true);
		}
				
		request.getRequestDispatcher("/WEB-INF/templates/Inscription.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		int creditInitial = 100;
		
		String pseudo = request.getParameter("pseudo");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String email = request.getParameter("email");
		String telephone = request.getParameter("telephone");
		String rue = request.getParameter("rue");
		String codePostal = request.getParameter("code_postal");
		String ville = request.getParameter("ville");
		String motDePasse = request.getParameter("mot_de_passe");
		String confirmationMotDePasse = request.getParameter("confirmation_mot_de_passe");
		
		System.out.println("pseudo : " + pseudo);
		System.out.println("nom : " + nom);
		System.out.println("prenom : " + prenom);
		System.out.println("email : " + email);
		System.out.println("telephone : " + telephone);
		System.out.println("rue : " + rue);
		System.out.println("code_postal : " + codePostal);
		System.out.println("ville : " + ville);
		System.out.println("motDePasse : " + motDePasse);
		System.out.println("confirmationMotDePasse : " + confirmationMotDePasse);
		
		int erreur = 0;
		
		if(pseudo == null || pseudo == "") {
			erreur++;
		}
		if(pseudo != null && pseudo.length() >= 30) {
			erreur++;
		}
		
		if(nom == null || nom == "") {
			erreur++;
		}
		if(nom != null && nom.length() >= 30) {
			erreur++;
		}
		
		if(prenom == null || prenom == "") {
			erreur++;
		}
		if(prenom != null && prenom.length() >= 30) {
			erreur++;
		}
		
		if(email == null || email == "") {
			erreur++;
		}
		if(email != null && email.length() >= 30) {
			erreur++;
		}
		
		if(telephone == null || telephone == "") {
			erreur++;
		}
		if(telephone != null && telephone.length() >= 30) {
			erreur++;
		}
		
		if(rue == null || rue == "") {
			erreur++;
		}
		if(rue != null && rue.length() >= 30) {
			erreur++;
		}
		
		if(codePostal == null || codePostal == "") {
			erreur++;
		}
		if(codePostal != null && codePostal.length() >= 30) {
			erreur++;
		}
		
		if(ville == null || ville == "") {
			erreur++;
		}
		if(ville != null && ville.length() >= 30) {
			erreur++;
		}
		
		if(motDePasse == null || motDePasse == "") {
			erreur++;
		}
		if(motDePasse != null && motDePasse.length() >= 30) {
			erreur++;
		}
		
		if(confirmationMotDePasse == null || confirmationMotDePasse == "") {
			erreur++;
		}
		if(confirmationMotDePasse != null && confirmationMotDePasse.length() >= 30) {
			erreur++;
		}
		
		if((erreur == 0) && (session.getAttribute("utilisateurSession") == null)) {
			Utilisateur utilisateur = new Utilisateur(pseudo, nom, prenom, email, telephone, rue, codePostal, ville, motDePasse, creditInitial, false);
			utilisateurManager.insert(utilisateur);
			
			session.setAttribute("utilisateurSession", utilisateur);
			
			request.getRequestDispatcher("/WEB-INF/templates/ListeEncheres.jsp").forward(request, response);
		} else {
			response.getWriter().print("Echec inscription.");
			request.getRequestDispatcher("/WEB-INF/templates/Inscription.jsp").forward(request, response);
		}
	}

}