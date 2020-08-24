package fr.eni.projet.ihm;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;
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
@WebServlet("/NouvelleVenteServlet")
public class NouvelleVenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
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
			case "Vêtements": noCategorie = 4;
				break;
			case "Sports et loisirs": noCategorie = 5;
				break;
			}
		
		
		String photo = request.getParameter("photo");
		int prix = Integer.parseInt(request.getParameter("prix"));
		Timestamp debutEnchere = Timestamp.valueOf(request.getParameter("debut-enchere")) ;
		Timestamp finEnchere = Timestamp.valueOf(request.getParameter("fin-enchere"));
		String rue = request.getParameter("rue");
		String cp = request.getParameter("cp");
		String ville = request.getParameter("ville");
		
		
		//affichage saisie pour vérification
		System.out.println("article :"+article);
		System.out.println("article :"+description);
		System.out.println("article :"+categorie);
		System.out.println("article :"+photo);
		System.out.println("article :"+prix);
		System.out.println("article :"+debutEnchere);
		System.out.println("article :"+finEnchere);
		System.out.println("article :"+rue);
		System.out.println("article :"+cp);
		System.out.println("article :"+ville);
		
		
		//vérification des erreurs formulaire
		int erreur = 0;
		if(article == null || article == "") {
			erreur++;
			}
//		
		if(article != null && article.length() >= 50) {
			erreur++;
			}
//		
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
//		//TODO erreur fichier(taille? format?)
//
		if(prix <= 0) {
			erreur++;
		}
//		
//		//TODO format date?
//		if(debutEnchere == null ) {
//			erreur++;
//		}
//		
//		//TODO format date?
//		if(finEnchere == null) {
//			erreur++;
//		}
//	
		if(rue == null || rue == "") {
			erreur++;
		}
		if(rue != null && rue.length() >= 50) {
			erreur++;
			}
		if(cp == null || cp == "") {
		erreur++;
		}
		if(cp != null && cp.length() >= 5) {
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
			ArticleVendu articleVendu = new ArticleVendu(article, description, debutEnchere, finEnchere, prix, prix, noUtilisateur, noCategorie);
////			
//			//appel instance de manager
			
			ArticleVenduManager am = ArticleVenduManager.getInstance();
			try {
				am.insert(articleVendu, retrait);
			} catch (DALException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			rs = request.getRequestDispatcher("/WEB-INF/templates/ListeEncheres.jsp");
			
			
		} else {
			rs = request.getRequestDispatcher("/WEB-INF/templates/NouvelleVente.jsp");
		}
		rs.forward(request, response);
		
	}

}
