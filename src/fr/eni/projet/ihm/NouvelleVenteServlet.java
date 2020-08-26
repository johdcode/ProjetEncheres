package fr.eni.projet.ihm;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.projet.bll.ArticleVenduManager;
import fr.eni.projet.bll.CategorieManager;
import fr.eni.projet.bo.ArticleVendu;
import fr.eni.projet.bo.Categorie;
import fr.eni.projet.bo.Retrait;
import fr.eni.projet.bo.Utilisateur;
import fr.eni.projet.dal.DALException;

/**
 * Servlet implementation class NouvelleVenteServlet
 */	
@WebServlet("/nouvelle-vente")
public class NouvelleVenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//==================fonctionnalité modifier vente
		//		ArticleVenduManager av = ArticleVenduManager.getInstance();
//		
//		String idArticle = request.getParameter("idArticle");
//		if(!idArticle.equals(null)||!idArticle.isEmpty()) {
//			try {
//				ArticleVendu articleAModifier = av.selectById(Integer.parseInt(idArticle));
//				
//				request.setAttribute("articleAModifier", articleAModifier);
//				request.setAttribute("dateDebut", articleAModifier.getDateDebutEnchere().toLocalDate());
//				request.setAttribute("dateFin", articleAModifier.getDateFinEnchere().toLocalDate());
//			} catch (NumberFormatException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (DALException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//		}
//		=========================================================================================================
		
		//Chargement des catégories en BDD pour affichage en JSP
		CategorieManager cm = CategorieManager.getInstance();
		try {
			List <Categorie> categories = cm.selectAll();
			request.setAttribute("categories", categories);
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Chargement de l'adresse du vendeur
		Utilisateur vendeur = SessionService.checkUtilisateurSession(request);
		request.setAttribute("vendeur", vendeur);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/templates/NouvelleVente.jsp");
		rd.forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
//		//récupération de la saisie utilisateur
		String article = request.getParameter("article");
		String description = request.getParameter("description");
		String categorie = request.getParameter("categorie");
		int noCategorie=0;
			switch (categorie) {
			case "Informatique": noCategorie = 1;
				break;
			case "Ameublement": noCategorie = 3;
				break;
			case "Vetements": noCategorie = 4;
				break;
			case "Sports et loisirs": noCategorie = 5;
				break;
			}
		
		
		String photo = request.getParameter("photo");
		
		int prix = 0;
		try{
			prix = Integer.parseInt(request.getParameter("prix"));
		} catch(NumberFormatException e) {}
		
		//Gestion de la date
		//Récupération des saisies utilisateur et conversion en LocalDate
//		String datePattern = "dd.MM.yyyy hh:mm:ss";
//		DateTimeFormatter fDatePattern = DateTimeFormatter.ofPattern(datePattern);
//		if(request.getParameter("debut-enchere") != null)
		
		String debutEnchere = request.getParameter("debut-enchere");
		String finEnchere = request.getParameter("fin-enchere");
		LocalDate dateDebutEnchere = null;
		LocalDate dateFinEnchere = null;
		LocalDateTime datetimeDebutEnchere = null;
		LocalDateTime datetimeFinEnchere = null;
		//Création du local time à now
		LocalTime heureDebutEnchere = LocalTime.now();
		LocalTime heureFinEnchere = heureDebutEnchere;
		
		try {
			dateDebutEnchere = LocalDate.parse(request.getParameter("debut-enchere"));
			dateFinEnchere = LocalDate.parse(request.getParameter("fin-enchere"));
		} catch(DateTimeParseException e) {}
		
//		LocalDate dateDebutEnchereSaisie = LocalDate.parse(request.getParameter("debut-enchere"));
//		LocalDate dateFinEnchereSaisie = LocalDate.parse(request.getParameter("fin-enchere"));
//		LocalDate dateFinEnchereSaisie = LocalDate.parse(request.getParameter("fin-enchere"));
		
		//Création du LocalDateTime avec la nouvelle LocalDate
		try {			
			datetimeDebutEnchere = LocalDateTime.of(dateDebutEnchere, heureDebutEnchere);
			datetimeFinEnchere = LocalDateTime.of(dateFinEnchere,heureFinEnchere);
			System.out.println(datetimeDebutEnchere);
		} catch(NullPointerException e) {}
		//
		String rue = request.getParameter("rue");
		String cp = request.getParameter("cp");
		String ville = request.getParameter("ville");
		
		
		//affichage saisie pour vérification
		System.out.println("article :"+article);
		System.out.println("article :"+description);
		System.out.println("article :"+categorie);
		System.out.println("article :"+photo);
		System.out.println("article :"+prix);
		System.out.println("article :"+datetimeDebutEnchere);
		System.out.println("article :"+datetimeFinEnchere);
		System.out.println("article :"+rue);
		System.out.println("article :"+cp);
		System.out.println("article :"+ville);
		System.out.println("description :"+description);
		System.out.println("categorie :"+categorie);
		System.out.println("photo :"+photo);
		System.out.println("prix :"+prix);
		System.out.println("dateDebutEnchere :"+dateDebutEnchere);
		System.out.println("dateFinEnchere :"+dateFinEnchere);
		System.out.println("rue"+rue);
		System.out.println("cp :"+cp);
		System.out.println("ville :"+ville);
		
		//vérification des erreurs formulaire
		int erreur = 0;
		if(article == null || article == "") {
			erreur++;
			}
		
		if(article != null && article.length() >= 50) {
			erreur++;
			}
		
		if(description == null || description == "") {
			erreur++;
		}
		if(description != null && description.length() >= 100) {
			erreur++;
			}
		if(categorie == null || categorie == "") {
			erreur++;
		}
		if(categorie != null && categorie.length() >= 50) {
			erreur++;
			}
		//TODO erreur fichier(taille? format?)

		if(prix <= 0) {
			erreur++;
		}
		
		//TODO format date?
		if(datetimeDebutEnchere == null ) {
			erreur++;
		}
		
//		//TODO format date?
		if(datetimeFinEnchere == null) {
			erreur++;
		}
	
		if(rue == null || rue == "") {
			erreur++;
		}
		if(rue != null && rue.length() >= 50) {
			erreur++;
			}
		if(cp == null || cp == "") {
		erreur++;
		}
		if(cp != null && cp.length() > 5) {
			erreur++;
			}
		RequestDispatcher rs = null;
		if(erreur == 0) {
			
			int noUtilisateur = (int) request.getSession().getAttribute("utilisateurSessionId");
			System.out.println(noUtilisateur);
//			
//			//création du retrait
//			
			Retrait retrait = new Retrait(rue, cp, ville);
			ArticleVendu articleVendu = new ArticleVendu(article, description, datetimeDebutEnchere, datetimeFinEnchere, prix, prix, noUtilisateur, noCategorie);
////			
//			//appel instance de manager
			
			ArticleVenduManager am = ArticleVenduManager.getInstance();
			
			
			try {
				am.insert(articleVendu, retrait);
			} catch (DALException e) {
				e.printStackTrace();
			}
			rs = request.getRequestDispatcher("/WEB-INF/templates/ListeEncheres.jsp");
			
			response.sendRedirect(request.getContextPath() + "/nouvelle-vente");
			
			
		} else {
			rs = request.getRequestDispatcher("/WEB-INF/templates/NouvelleVente.jsp");
		}
		rs.forward(request, response);
		
	}

}
