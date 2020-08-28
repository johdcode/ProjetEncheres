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
import fr.eni.projet.exception.BusinessException;

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
		
		String pseudo = request.getParameter("pseudo").trim();
		String nom = request.getParameter("nom").trim();
		String prenom = request.getParameter("prenom").trim();
		String email = request.getParameter("email").trim();
		String telephone = request.getParameter("telephone").trim();
		String rue = request.getParameter("rue").trim();
		String codePostal = request.getParameter("code_postal").trim();
		String ville = request.getParameter("ville").trim();
		String motDePasse = request.getParameter("mot_de_passe").trim();
		String confirmationMotDePasse = request.getParameter("confirmation_mot_de_passe").trim();
		
	
		
		int erreur = 0;
		
		if(pseudo == null || pseudo == "") {
			erreur++;
			BusinessException.addMessageErreur("Le pseudo ne doit pas être vide.");
		}
		if(pseudo != null) {
			if(pseudo.length() >= 30) {
				erreur++;
				BusinessException.addMessageErreur("Le pseudo ne doit pas faire plus de 30 caractères.");
			}
			if(!pseudo.matches("^[a-z|A-Z|0-9]{4,29}$")){
				erreur++;
				BusinessException.addMessageErreur("Le format du pseudo n'est pas correct. Utiliser des lettres et chiffres uniquement.");
			}
			// Récupérer et vérifier valeur avec selectByPseudo()
			if(utilisateurManager.selectByPseudo(pseudo) != null) {
				erreur++;
				BusinessException.addMessageErreur("Ce pseudo est déjà utilisé.");
			}
		}
		
		if(nom == null || nom == "") {
			erreur++;
			BusinessException.addMessageErreur("Le nom ne doit pas être vide.");
		}
		if(nom != null) {
			if(nom.length() >= 30){
				erreur++;
				BusinessException.addMessageErreur("Le nom ne doit pas faire plus de 30 caractères.");
			}
			if(!nom.matches("^[a-z|A-Z]{2,29}$")){
				erreur++;
				BusinessException.addMessageErreur("Le format du nom n'est pas correct. Utiliser des lettres uniquement.");
			}
		}
		
		if(prenom == null || prenom == "") {
			erreur++;
			BusinessException.addMessageErreur("Le prénom ne doit pas être vide.");
		}
		if(prenom != null && prenom.length() >= 30) {
			if(prenom.length() >= 30){
				erreur++;
				BusinessException.addMessageErreur("Le prénom ne doit pas faire plus de 30 caractères.");
			}
			if(!prenom.matches("^[a-z|A-Z]{2,29}$")){
				erreur++;
				BusinessException.addMessageErreur("Le format du prénom n'est pas correct. Utiliser des lettres uniquement.");
			}
		}
		
		if(email == null || email == "") {
			erreur++;
			BusinessException.addMessageErreur("L'email ne doit pas être vide.");
		}
		if(email != null && email.length() >= 50) {
			if(email.length() >= 50) {
				erreur++;
				BusinessException.addMessageErreur("L'emain ne doit pas faire plus de 50 caractères.");
				
			}
			if(!email.matches("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$")) {
				erreur++;
				BusinessException.addMessageErreur("Utiliser un format d'email correct.");
			}
			// Récupérer et vérifier valeur avec selectByEmail()
			if(utilisateurManager.selectByEmail(email) != null) {
				erreur++;
				BusinessException.addMessageErreur("Cette email est déjà utilisé.");
			}
		}
		
		if(telephone == null || telephone == "") {
			erreur++;
			BusinessException.addMessageErreur("Le numéro de téléphone ne doit pas être vide.");
		}
		if(telephone != null) {
			if(telephone.length() >= 15) {
				erreur++;
				BusinessException.addMessageErreur("Le téléphone ne doit pas faire plus de 30 caractères.");
			}
			if(!telephone.matches("^(\\+(\\d){2})?[0-9]{10}$")) {
				erreur++;
				BusinessException.addMessageErreur("Le format du nom n'est pas correct. Utiliser des chiffres uniquement.");
			}
		}
		
		if(rue == null || rue == "") {
			erreur++;
			BusinessException.addMessageErreur("Le nom de rue ne doit pas être vide.");
		}
		if(rue != null) {
			if(rue.length() >= 30){
				erreur++;
				BusinessException.addMessageErreur("Le nom de rue ne doit pas faire plus de 30 caractères.");
			}
			if(!rue.matches("^[a-zA-Z0-9\\s-]{2,29}$")){
				erreur++;
				BusinessException.addMessageErreur("Le format du nom n'est pas correct. Utiliser des lettres, chiffres et des espaces uniquement.");
			}
		}
		
		if(codePostal == null || codePostal == "") {			
			erreur++;
			BusinessException.addMessageErreur("Le code postal ne doit pas être vide.");
		}
		if(codePostal != null) {
			if(codePostal.length() >= 10){
				erreur++;
				BusinessException.addMessageErreur("Le pseudo ne doit pas faire plus de 10 caractères.");
			}
			if(!codePostal.matches("^[0-9]{5,9}$")){
				erreur++;
				BusinessException.addMessageErreur("Le format du nom n'est pas correct. Utiliser chiffres uniquement d'une taille de 5 à 10 caractères.");
			}
		}
		
		if(ville == null || ville == "") {
			erreur++;
			BusinessException.addMessageErreur("La ville ne doit pas être vide.");
		}
		if(ville != null) {
			if(ville.length() >= 50){
				erreur++;
				BusinessException.addMessageErreur("Le nom de ville doit faire moins de 50 caractères.");
			}
			if(!ville.matches("^[A-Za-z0-9\\s-]{4,49}$")){
				erreur++;
				BusinessException.addMessageErreur("Le format du nom n'est pas correct. Utiliser des lettres, des chiffres et des espaces uniquement.");
			}
		}
		
		if(motDePasse == null || motDePasse == "") {
			erreur++;
			BusinessException.addMessageErreur("Le mot de passe ne doit pas être vide.");
		}
		if(motDePasse != null) {
			if(motDePasse.length() >= 30){
				erreur++;
				BusinessException.addMessageErreur("Le mot de passe doit faire moins de 30 caractères.");
			}
			// Taille minimal
			if(!motDePasse.matches(".{4,29}")){
				erreur++;
				BusinessException.addMessageErreur("Le mot de passe doit faire entre 4 et 30 caractères.");
			}
			boolean erreurFormat = false;
			// Minuscule
			if(!motDePasse.matches(".*[a-z]+.*")){
				erreur++;
				erreurFormat = true;
			}
			// Majuscule
			if(!motDePasse.matches(".*[A-Z]+.*")){
				erreur++;
				erreurFormat = true;
			}
			// Nombre
			if(!motDePasse.matches(".*[0-9]+.*")){
				erreur++;
				erreurFormat = true;
			}
			// Caractère spéciaux
			if(!motDePasse.matches(".*[\\n!-/:-\\?\\[-`\\{-~]+.*")){
				erreur++;
				erreurFormat = true;
			}
			if(erreurFormat) {
				BusinessException.addMessageErreur("Votre mot de passe doit contenir au moins 1 minuscules, 1 majuscule, 1 nombre et un caractère spécial.");
			}
		
		}
		
		if(confirmationMotDePasse == null || confirmationMotDePasse == "") {
			erreur++;
			BusinessException.addMessageErreur("Le confimation du mot de passe ne doit pas être vide.");
		}
		if(confirmationMotDePasse != null) {
			if(confirmationMotDePasse.length() >= 30){
				erreur++;
			}
			if(!confirmationMotDePasse.equals(motDePasse)){
				erreur++;
				BusinessException.addMessageErreur("Le mot de passe doit être le même que la confirmation.");
			}
		}
	
		if((erreur == 0) && session.getAttribute("utilisateurSessionId")  == null) {
			Utilisateur utilisateur = new Utilisateur(pseudo, nom, prenom, email, telephone, rue, codePostal, ville, motDePasse, creditInitial, false);
			utilisateurManager.insert(utilisateur);
			
			SessionService.setUtilisateurSessionId(request,utilisateurManager.selectByPseudo(pseudo).getNoUtilisateur());
			
//			request.getRequestDispatcher("/WEB-INF/templates/ListeEncheres.jsp").forward(request, response);
			response.sendRedirect(request.getContextPath() + "/encheres");
		} else {
			request.setAttribute("listeErreur", BusinessException.getListeMessageException());
			request.getRequestDispatcher("/WEB-INF/templates/Inscription.jsp").forward(request, response);
			BusinessException.reset();
		}
	}

}
