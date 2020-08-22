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
		// Vérifie si utilisateur est connecté
		SessionService.checkUtilisateurSession(request);
				
		request.getRequestDispatcher("/WEB-INF/templates/Inscription.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		
		int creditInitial = 100;
		
		String pseudo = request.getParameter("pseudo").trim().toLowerCase();
		String nom = request.getParameter("nom").trim().toLowerCase();
		String prenom = request.getParameter("prenom").trim().toLowerCase();
		String email = request.getParameter("email").trim().toLowerCase();
		String telephone = request.getParameter("telephone").trim().toLowerCase();
		String rue = request.getParameter("rue").trim().toLowerCase();
		String codePostal = request.getParameter("code_postal").trim().toLowerCase();
		String ville = request.getParameter("ville").trim().toLowerCase();
		String motDePasse = request.getParameter("mot_de_passe").trim().toLowerCase();
		String confirmationMotDePasse = request.getParameter("confirmation_mot_de_passe").trim().toLowerCase();
		
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
		if(pseudo != null) {
			if(pseudo.length() >= 30) {
				erreur++;
			}
			if(!pseudo.matches("^[a-z|A-Z|0-9]{4,29}$")){
				erreur++;
			}
			// Récupérer et vérifier valeur avec selectByPseudo()
			if(utilisateurManager.selectByPseudo(pseudo) != null) {
				erreur++;
			}
		}
		
		if(nom == null || nom == "") {
			erreur++;
		}
		if(nom != null) {
			if(nom.length() >= 30){
				erreur++;
			}
			if(!nom.matches("^[a-z|A-Z]{2,29}$")){
				erreur++;
			}
		}
		
		if(prenom == null || prenom == "") {
			erreur++;
		}
		if(prenom != null && prenom.length() >= 30) {
			if(prenom.length() >= 30){
				erreur++;
			}
			if(!prenom.matches("^[a-z|A-Z]{2,29}$")){
				erreur++;
			}
		}
		
		if(email == null || email == "") {
			erreur++;
		}
		if(email != null && email.length() >= 50) {
			if(email.length() >= 50) {
				erreur++;
			}
			if(!email.matches("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$")) {
				erreur++;
			}
			// Récupérer et vérifier valeur avec selectByEmail()
			if(utilisateurManager.selectByEmail(email) != null) {
				erreur++;
			}
		}
		
		if(telephone == null || telephone == "") {
			erreur++;
		}
		if(telephone != null) {
			if(telephone.length() >= 15) {
				erreur++;
			}
			if(!telephone.matches("^(\\+(\\d){2})?[0-9]{10}$")) {
				erreur++;
			}
		}
		
		if(rue == null || rue == "") {
			erreur++;
		}
		if(rue != null) {
			if(rue.length() >= 30){
				erreur++;
			}
			if(!rue.matches("^[a-zA-Z0-9\\s-]{2,29}$")){
				erreur++;
			}
		}
		
		if(codePostal == null || codePostal == "") {			
			erreur++;
		}
		if(codePostal != null) {
			if(codePostal.length() >= 10){
				erreur++;
			}
			if(!codePostal.matches("^[0-9]{5,9}$")){
				erreur++;
			}
		}
		
		if(ville == null || ville == "") {
			erreur++;
		}
		if(ville != null) {
			if(ville.length() >= 50){
				erreur++;
			}
			if(!ville.matches("^[A-Za-z0-9\\s-]{4,49}$")){
				erreur++;
			}
		}
		
		if(motDePasse == null || motDePasse == "") {
			erreur++;
		}
		if(motDePasse != null) {
			if(motDePasse.length() >= 30){
				erreur++;
			}
			// Taille minimal
			if(!motDePasse.matches(".{4,29}")){
				erreur++;
			}
//			// Minuscule
//			if(!motDePasse.matches(".*[a-z]+.*")){
//				erreur++;
//			}
//			// Majuscule
//			if(!motDePasse.matches(".*[A-Z]+.*")){
//				erreur++;
//			}
//			// Nombre
//			if(!motDePasse.matches(".*[0-9]+.*")){
//				erreur++;
//			}
//			// Caractère spéciaux
//			if(!motDePasse.matches(".*[!-/:-\\?\\[-`\\{-~]+.*\\s")){
//				erreur++;
//			}
		}
		System.out.println("Erreurs : " + erreur);
		if(confirmationMotDePasse == null || confirmationMotDePasse == "") {
			erreur++;
		}
		if(confirmationMotDePasse != null) {
			if(confirmationMotDePasse.length() >= 30){
				erreur++;
			}
			if(!confirmationMotDePasse.equals(motDePasse)){
				erreur++;
			}
		}
		
		if((erreur == 0) && (SessionService.getUtilisateurSessionId(request) == null)) {
			Utilisateur utilisateur = new Utilisateur(pseudo, nom, prenom, email, telephone, rue, codePostal, ville, motDePasse, creditInitial, false);
			utilisateurManager.insert(utilisateur);
			
			SessionService.setUtilisateurSessionId(request, utilisateur.getNoUtilisateur());
			
//			request.getRequestDispatcher("/WEB-INF/templates/ListeEncheres.jsp").forward(request, response);
			response.sendRedirect(request.getContextPath() + "/encheres");
		} else {
			response.getWriter().print("Echec inscription.");
			request.getRequestDispatcher("/WEB-INF/templates/Inscription.jsp").forward(request, response);
		}
	}

}
