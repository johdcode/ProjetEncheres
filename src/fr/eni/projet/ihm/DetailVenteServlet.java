package fr.eni.projet.ihm;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import fr.eni.projet.bll.ArticleVenduManager;
import fr.eni.projet.bll.CategorieManager;
import fr.eni.projet.bll.EnchereManager;
import fr.eni.projet.bll.RetraitManager;
import fr.eni.projet.bll.UtilisateurManager;
import fr.eni.projet.bo.ArticleVendu;
import fr.eni.projet.bo.Categorie;
import fr.eni.projet.bo.Enchere;
import fr.eni.projet.bo.Retrait;
import fr.eni.projet.bo.Utilisateur;
import fr.eni.projet.dal.DALException;

/**
 * Servlet implementation class DetailVente
 */
@WebServlet("/DetailVente")
public class DetailVenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	//Appel des managers
	private ArticleVenduManager articleVenduManager = ArticleVenduManager.getInstance();
	private CategorieManager categorieManager = CategorieManager.getInstance();
	private EnchereManager enchereManager = EnchereManager.getInstance();
	private RetraitManager retraitManager = RetraitManager.getInstance();
	private UtilisateurManager utilisateurManager = UtilisateurManager.getInstance();
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		SessionService.checkUtilisateurSession(request);
		
		// reccuperer l'ID de l'article et le passer en attribut
		int idArticle = Integer.parseInt(request.getParameter("idArticle"));
		request.setAttribute("idArticle", idArticle);
		
		// recuperer l'article a afficher
		ArticleVendu av = new ArticleVendu();
		
		
		try {
			av = articleVenduManager.selectById(idArticle);	
		} catch (DALException e) {
			e.printStackTrace();
		}
		request.setAttribute("articleAAfficher", av);
		
		// récupérer la catégorie
		
		Categorie c = new Categorie();
		
		try {
			int idCat = articleVenduManager.selectById(idArticle).getNoCategorieArticle();
			c = categorieManager.selectById(idCat);
		} catch (DALException e) {
			e.printStackTrace();
		}
		request.setAttribute("categorieArticle", c);
		
		
		//Methode selectionne l'enchere la plus haute en fonction de l'article
				
			// variable 
		int enchereActuelle = 0;
		Enchere enchereMax = enchereManager.getEnchereMax(idArticle);
		
			// selection du prix à afficher
		try {
			if (enchereMax == null) {
			enchereActuelle = articleVenduManager.selectById(idArticle).getMiseAPrix();
			}
			else if (enchereMax != null) {
				enchereActuelle = enchereMax.getMontantEnchere();
			}
		} catch (DALException e1) {
			e1.printStackTrace();
		}
			//passe le prix max en attribut
		request.setAttribute("enchereActuelle", enchereActuelle);
		
		// Recup du retrait
		Retrait r = new Retrait();
		
		try {
			r = retraitManager.selectById(idArticle);
		} catch (DALException e) {
			e.printStackTrace();
		}
		request.setAttribute("retraitArticle", r);
		
		// recup vendeur
		
		Utilisateur u = new Utilisateur();
		
		try {
			int idUti = articleVenduManager.selectById(idArticle).getNoUtilisateurArticle();
			u = utilisateurManager.selectById(idUti);
		} catch (DALException e) {
			e.printStackTrace();
		}
		request.setAttribute("utilisateurArticle", u);
		
		request.getRequestDispatcher("/WEB-INF/templates/DetailVente.jsp").forward(request, response);
	}


	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Affichage des Infos après l'enchère
			SessionService.checkUtilisateurSession(request);
				
		// reccuperer l'ID de l'article et le passer en attribut
			int idArticle = Integer.parseInt(request.getParameter("idArticle"));
			request.setAttribute("idArticle", idArticle);
		
		// recuperer l'article a afficher
		ArticleVendu av = new ArticleVendu();
		
		
		try {
			av = articleVenduManager.selectById(idArticle);	
		} catch (DALException e) {
			e.printStackTrace();
		}
		request.setAttribute("articleAAfficher", av);
		
		// récupérer la catégorie
		
		Categorie c = new Categorie();
		
		try {
			int idCat = articleVenduManager.selectById(idArticle).getNoCategorieArticle();
			c = categorieManager.selectById(idCat);
		} catch (DALException e) {
			e.printStackTrace();
		}
		request.setAttribute("categorieArticle", c);
		//Methode selectionne l'enchere la plus haute en fonction de l'article
		
		// variable 
	int enchereActuelle = 0;
	Enchere enchereMax = enchereManager.getEnchereMax(idArticle);
	
		// selection du prix à afficher
	try {
		if (enchereMax == null) {
		enchereActuelle = articleVenduManager.selectById(idArticle).getMiseAPrix();
		}
		else if (enchereMax != null) {
			enchereActuelle = enchereMax.getMontantEnchere();
		}
	} catch (DALException e1) {
		e1.printStackTrace();
	}
		//passe le prix max en attribut
	request.setAttribute("enchereActuelle", enchereActuelle);
	
	// Recup du retrait
	Retrait r = new Retrait();
	
	try {
		r = retraitManager.selectById(idArticle);
	} catch (DALException e) {
		e.printStackTrace();
	}
	request.setAttribute("retraitArticle", r);
	
	// recup vendeur
	
	Utilisateur u = new Utilisateur();
	
	try {
		int idUti = articleVenduManager.selectById(idArticle).getNoUtilisateurArticle();
		u = utilisateurManager.selectById(idUti);
	} catch (DALException e) {
		e.printStackTrace();
	}
	request.setAttribute("utilisateurArticle", u);
	
	// enregsitrer l'enchère :
				// recupérer la nouvelle enchère
			int montantEnchereSaisie = Integer.parseInt(request.getParameter("enchereSaisie").trim());
			System.out.println(montantEnchereSaisie);
			
				// recuperer l'utilisateur
			int idUtilisateurSession = Integer.parseInt(SessionService.getUtilisateurSessionId(request));
			System.out.println("idUt : " + idUtilisateurSession);
			
				// recuperer l'id de l'article
			System.out.println("idArt : " + idArticle);
			
				// récuperer la date
			LocalDateTime dateNow = LocalDateTime.now();
			System.out.println("date : "+ dateNow);
			
			// enregistrer la proposition si elle est plus grande que le prix actuel
//			if (montantEnchereSaisie > enchereActuelle) {
//				Enchere enchereAIntegrer = new Enchere(dateNow, montantEnchereSaisie, idArticle, idUtilisateurSession);
//				enchereManager.insert(enchereAIntegrer);
//			}
	
	
		
	request.getRequestDispatcher("/WEB-INF/templates/DetailVente.jsp").forward(request, response);
	}

}
