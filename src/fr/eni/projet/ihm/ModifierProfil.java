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
import fr.eni.projet.exception.BusinessException;

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
		SessionService.checkUtilisateurSession(request);
		
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
				BusinessException.addMessageErreur("Le pseudo ne doit pas faire plus de 30 caractères.");
			}
			if(!pseudo.matches("^[a-z|A-Z|0-9]{4,29}$")){
				erreur++;
				BusinessException.addMessageErreur("Le format du pseudo n'est pas correct. Utiliser des lettres et chiffres uniquement.");
			}
			// Récupérer et vérifier valeur avec selectByPseudo() 
			if(!utilisateurDb.getPseudo().equals(pseudo) && utilisateurManager.selectByPseudo(pseudo) != null) {
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
				BusinessException.addMessageErreur("L'email ne doit pas faire plus de 50 caractères.");
			}
			if(!email.matches("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$")) {
				erreur++;
				BusinessException.addMessageErreur("Utiliser un format d'email correct.");
			}
			// Récupérer et vérifier valeur avec selectByEmail()
			if(!utilisateurDb.getEmail().equals(email) && utilisateurManager.selectByEmail(email) != null) {
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
				BusinessException.addMessageErreur("Le format du nom de rue n'est pas correct. Utiliser des lettres, des chiffres et des espaces uniquement.");
			}
		}
		
		if(codePostal == null || codePostal == "") {			
			erreur++;
			BusinessException.addMessageErreur("Le code postal ne doit pas être vide.");
		}
		if(codePostal != null) {
			if(codePostal.length() >= 10){
				erreur++;
				BusinessException.addMessageErreur("Le code postal ne doit pas faire plus de 10 caractères.");
			}
			if(!codePostal.matches("^[0-9]{5,9}$")){
				erreur++;
				BusinessException.addMessageErreur("Le format du code postal n'est pas correct. Utiliser chiffres uniquement d'une taille de 5 à 10 caractères.");
			}
		}
		
		if(ville == null || ville == "") {
			erreur++;
			BusinessException.addMessageErreur("La nom de la ville ne doit pas être vide.");
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
		
		if(motDePasse != null && !motDePasse.isEmpty()) {
			if(motDePasse.length() >= 30){
				erreur++;
				BusinessException.addMessageErreur("Le mot de passe doit faire moins de 30 caractères.");
			}
			if(!motDePasse.equals(utilisateurDb.getMotDePasse())){
				erreur++;
				BusinessException.addMessageErreur("Le mot de passe n'est pas correct.");
			}
		}
		// Si le nouveau mot de passe est entrée OU si un mot de passe à été saisie
		if((nouveauMotDePasse != null && !nouveauMotDePasse.isEmpty()) || (motDePasse != null && !motDePasse.isEmpty())) {
			// Vérifie que le mot de passe à été bien été saisie
			if(motDePasse == null || motDePasse.isEmpty()) {
				erreur++;
				BusinessException.addMessageErreur("Le mot de passe ne doit pas être vide.");
			}
			// Le nouveau mot de passe et la confimation du nouveau mot de passe doivent être identique
			if(!confirmationNouveauMotDePasse.equals(nouveauMotDePasse)){
				erreur++;
				BusinessException.addMessageErreur("Le nouveau mot de passe doit être le même que la confirmation.");
			}
			if(nouveauMotDePasse.length() >= 30){
				erreur++;
				BusinessException.addMessageErreur("Le nouveau mot de passe doit faire moins de 30 caractères.");
			}
			if(!nouveauMotDePasse.matches(".{4,29}")){
				erreur++;
				BusinessException.addMessageErreur("Le mot de passe doit faire entre 4 et 30 caractère");
			}
			// Le mot de passe et le nouveau mot de passe ne doivent pas être identique
			if(nouveauMotDePasse.equals(motDePasse)){
				erreur++;
				BusinessException.addMessageErreur("Le nouveau mot de passe doit être différent du précédent.");
			}
			boolean erreurFormat = false;
			// Minuscule
			if(!nouveauMotDePasse.matches(".*[a-z]+.*")){
				erreur++;
				erreurFormat = true;
			}
			// Majuscule
			if(!nouveauMotDePasse.matches(".*[A-Z]+.*")){
				erreur++;
				erreurFormat = true;
			}
			// Nombre
			if(!nouveauMotDePasse.matches(".*[0-9]+.*")){
				erreur++;
				erreurFormat = true;
			}
			// Caractère spéciaux
			if(!nouveauMotDePasse.matches(".*[\\n!-/:-\\?\\[-`\\{-~]+.*")){
				erreur++;
				erreurFormat = true;
			}
			if(erreurFormat) {
				BusinessException.addMessageErreur("Votre nouveau mot de passe doit contenir au moins 1 minuscules, 1 majuscule, 1 nombre et un caractère spécial.");
			}
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
			response.sendRedirect(request.getContextPath() + "/profil?id=" + utilisateur.getNoUtilisateur());
		} else {
			request.setAttribute("listeErreur", BusinessException.getListeMessageException());
			request.getRequestDispatcher("/WEB-INF/templates/ModifierProfil.jsp").forward(request, response);
			BusinessException.reset();
		}
	}

}
