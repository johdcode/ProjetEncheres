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
import fr.eni.projet.dal.DALException;

/**
 * Servlet implementation class ModifierProfil
 */
@WebServlet("/modifier-profil")
public class ModifierProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UtilisateurManager utilisateurManager = UtilisateurManager.getInstance();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Utilisateur u = SessionService.checkUtilisateurSession(request);
		request.getRequestDispatcher("/WEB-INF/templates/ModifierProfil.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		int creditInitial = 100;
		
		Utilisateur utilisateurDb = SessionService.checkUtilisateurSession(request);
		
		String pseudo = request.getParameter("pseudo").trim();
		String nom = request.getParameter("nom").trim();
		String prenom = request.getParameter("prenom").trim();
		String email = request.getParameter("email").trim();
		String telephone = request.getParameter("telephone").trim();
		String rue = request.getParameter("rue").trim();
		String codePostal = request.getParameter("code_postal").trim();
		String ville = request.getParameter("ville").trim();
		String motDePasse = request.getParameter("mot_de_passe").trim();
		String nouveauMotDePasse = request.getParameter("nouveau_mot_de_passe").trim();
		String confirmationNouveauMotDePasse = request.getParameter("confirmation_nouveau_mot_de_passe").trim();
		
		System.out.println("pseudo : " + pseudo);
		System.out.println("nom : " + nom);
		System.out.println("prenom : " + prenom);
		System.out.println("email : " + email);
		System.out.println("telephone : " + telephone);
		System.out.println("rue : " + rue);
		System.out.println("code_postal : " + codePostal);
		System.out.println("ville : " + ville);
		System.out.println("motDePasse : " + motDePasse);
		System.out.println("nouveauMotDePasse : " + nouveauMotDePasse);
		System.out.println("confirmationNouveauMotDePasse : " + confirmationNouveauMotDePasse);
		
		int erreur = 0;
		
		if(pseudo == null || pseudo == "") {
			erreur++;
		}
		if(pseudo != null && !pseudo.isEmpty()) {
			if(pseudo.length() >= 30) {
				erreur++;
			}
			if(!pseudo.matches("^[a-z|A-Z|0-9]{4,29}$")){
				erreur++;
			}
			// Récupérer et vérifier valeur avec selectByPseudo() 
			if(!utilisateurDb.getPseudo().equals(pseudo) && utilisateurManager.selectByPseudo(pseudo) != null) {
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
			if(!utilisateurDb.getEmail().equals(email) && utilisateurManager.selectByEmail(email) != null) {
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
		
		if(motDePasse != null && !motDePasse.isEmpty()) {
			if(!motDePasse.equals(utilisateurDb.getMotDePasse())){
				erreur++;
			}
		}
		// Si le nouveau mot de passe est entrée OU si un mot de passe à été saisie
		if((nouveauMotDePasse != null && !nouveauMotDePasse.isEmpty()) || (motDePasse != null && !motDePasse.isEmpty())) {
			// Vérifie que le mot de passe à été bien été saisie
			if(motDePasse == null || motDePasse.isEmpty()) {
				erreur++;
			}
			// Le nouveau mot de passe et la confimation du nouveau mot de passe doivent être identique
			if(!confirmationNouveauMotDePasse.equals(nouveauMotDePasse)){
				erreur++;
			}
			if(nouveauMotDePasse.length() >= 30){
				erreur++;
			}
			if(!nouveauMotDePasse.matches(".{4,29}")){
				erreur++;
			}
			// Le mot de passe et le nouveau mot de passe ne doivent pas être identique
			if(nouveauMotDePasse.equals(motDePasse)){
				erreur++;
			}
//			// Minuscule
//			if(!nouveauMotDePasse.matches(".*[a-z]+.*")){
//				erreur++;
//			}
//			// Majuscule
//			if(!nouveauMotDePasse.matches(".*[A-Z]+.*")){
//				erreur++;
//			}
//			// Nombre
//			if(!nouveauMotDePasse.matches(".*[0-9]+.*")){
//				erreur++;
//			}
//			// Caractère spéciaux
//			if(!nouveauMotDePasse.matches(".*[!-/:-\\?\\[-`\\{-~]+.*\\s")){
//				erreur++;
//			}
		}

		System.out.println("Erreurs : " + erreur);
		if((erreur == 0) && (SessionService.getUtilisateurSessionId(request) != null)) {
			Utilisateur utilisateur = null;
			
			if(motDePasse != null && !motDePasse.isEmpty()) {
				utilisateur = new Utilisateur(pseudo, nom, prenom, email, telephone, rue, codePostal, ville, nouveauMotDePasse, utilisateurDb.getCredit(), false);
			} else{				
				utilisateur = new Utilisateur(pseudo, nom, prenom, email, telephone, rue, codePostal, ville, utilisateurDb.getMotDePasse(), utilisateurDb.getCredit(), false);
			}
			// Ajoute un id à l'utilisateur à partir de l'utilisateurDb
			utilisateur.setNoUtilisateur(utilisateurDb.getNoUtilisateur());
			
			try {
				utilisateurManager.update(utilisateur);
			} catch (DALException e) {
				e.printStackTrace();
			}
//			request.getRequestDispatcher("/WEB-INF/templates/ListeEncheres.jsp").forward(request, response);
			response.sendRedirect(request.getContextPath() + "/profil?id=" + utilisateur.getNoUtilisateur());
		} else {
			response.getWriter().print("Echec inscription.");
			response.sendRedirect(request.getContextPath() + "/modifier-profil");
//			request.getRequestDispatcher("/WEB-INF/templates/Inscription.jsp").forward(request, response);
		}
	}

}
