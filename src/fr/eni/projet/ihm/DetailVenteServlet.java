package fr.eni.projet.ihm;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.servlet.ServletException;
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

	// Appel des managers
	private ArticleVenduManager articleVenduManager = ArticleVenduManager.getInstance();
	private CategorieManager categorieManager = CategorieManager.getInstance();
	private EnchereManager enchereManager = EnchereManager.getInstance();
	private RetraitManager retraitManager = RetraitManager.getInstance();
	private UtilisateurManager utilisateurManager = UtilisateurManager.getInstance();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Utilisateur utilisateurEnSession = SessionService.checkUtilisateurSession(request);
			request.setAttribute("UtilisateurEnSession", utilisateurEnSession);
			// reccuperer l'ID de l'article et le passer en attribut
			int idArticle = 0;
			try {
				idArticle = Integer.parseInt(request.getParameter("idArticle"));
			} catch(NumberFormatException e) {
				e.printStackTrace();
			}
			request.setAttribute("idArticle", idArticle);
	
			// recuperer l'article a afficher
			ArticleVendu av = new ArticleVendu();
	
			try {
				av = articleVenduManager.selectById(idArticle);
			} catch (DALException e) {
				e.printStackTrace();
			}
			try {
				av.getNoUtilisateurArticle();			
			} catch(NullPointerException e) {
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
	
			// Methode selectionne l'enchere la plus haute en fonction de l'article
	
			// variable
			int enchereActuelle = 0;
			Enchere enchereMax = enchereManager.getEnchereMax(idArticle);
	
			// selection du prix à afficher
			try {
				if (enchereMax == null) {
					enchereActuelle = articleVenduManager.selectById(idArticle).getMiseAPrix();
				} else if (enchereMax != null) {
					enchereActuelle = enchereMax.getMontantEnchere();
				}
			} catch (DALException e1) {
				e1.printStackTrace();
			}
			// passe le prix max en attribut
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
	
			Utilisateur vendeur = new Utilisateur();
	
			try {
				int idUti = articleVenduManager.selectById(idArticle).getNoUtilisateurArticle();
				vendeur = utilisateurManager.selectById(idUti);
			} catch (DALException e) {
				e.printStackTrace();
			}
			request.setAttribute("utilisateurArticle", vendeur);
			
			Utilisateur u = utilisateurManager.selectEnchereGagneeByArticle(idArticle);
		
			
			request.setAttribute("gagnantDeLEnchere", utilisateurManager.selectEnchereGagneeByArticle(idArticle));
			request.getRequestDispatcher("/WEB-INF/templates/DetailVente.jsp").forward(request, response);
		}catch(Exception e) {
			response.sendRedirect(request.getContextPath() + "/encheres");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Récupération de l'utilisateur en session
		Utilisateur utilisateurEnSession = SessionService.checkUtilisateurSession(request);

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
		// Methode selectionne l'enchere la plus haute en fonction de l'article

		// variable
		int enchereActuelle = 0;
		Enchere enchereMax = enchereManager.getEnchereMax(idArticle);

		// selection du prix à afficher
		try {
			if (enchereMax == null) {
				enchereActuelle = articleVenduManager.selectById(idArticle).getMiseAPrix();
			} else if (enchereMax != null) {
				enchereActuelle = enchereMax.getMontantEnchere();
			}
		} catch (DALException e1) {
			e1.printStackTrace();
		}
		// passe le prix max en attribut
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

		Utilisateur vendeur = new Utilisateur();

		try {
			int idUti = articleVenduManager.selectById(idArticle).getNoUtilisateurArticle();
			vendeur = utilisateurManager.selectById(idUti);
		} catch (DALException e) {
			e.printStackTrace();
		}
		request.setAttribute("utilisateurArticle", vendeur);

		// enregistrer l'enchère :
		// recupérer la nouvelle enchère

		int montantEnchereSaisie = 0;
		try {
			montantEnchereSaisie = Integer.parseInt(request.getParameter("enchereSaisie").trim());
		} catch (NumberFormatException e) {

			e.printStackTrace();
			String erreurTypeMontant = "Veuillez saisir un nombre entier";
			request.setAttribute("erreurTypeMontant", erreurTypeMontant);

		}

	

		// recuperer l'id utilisateur
		int idUtilisateurSession = Integer.parseInt(SessionService.getUtilisateurSessionId(request));
	

		// recuperer l'id de l'article
	

		// récuperer la date
		LocalDateTime dateNow = LocalDateTime.now();
	

		// vérification des conditions de l'enchère saisie par rapport à l'enchère
		// actuelle, le crédit utilisateur et les dates de début et fin de l'enchère

		// verification du montant de l'enchère saisie par rapport au montant de
		// l'enchère actuelle
		boolean MontantEnchereSaisieEstPlusElevé = false;
		if (montantEnchereSaisie > enchereActuelle) {
			MontantEnchereSaisieEstPlusElevé = true;
		} else {
			String erreurMontant = "Veuillez insérer un montant plus élevé que le montant de la plus haute enchère en cours";
			request.setAttribute("erreurMontant", erreurMontant);
		}

		// vérification de la date de l'enchère saisie par rapport à la date de début et
		// fin d'enchère
		boolean enchereSaisieDateValide = false;

		Enchere enchereAIntegrer = new Enchere(dateNow, montantEnchereSaisie, idArticle, idUtilisateurSession);
		if (enchereAIntegrer.getDateEnchere().isBefore(av.getDateFinEnchere())
				&& enchereAIntegrer.getDateEnchere().isAfter(av.getDateDebutEnchere())) {
			enchereSaisieDateValide = true;
		} else {
			String erreurDate = "Les enchères ne sont pas possibles sur cette vente";
			request.setAttribute("erreurDate", erreurDate);
		}
		// vérification crédit utilisateur
		boolean creditSuperieurAMontantEnchere = false;
		if (utilisateurEnSession.getCredit() > montantEnchereSaisie) {
			creditSuperieurAMontantEnchere = true;
		} else {
			String erreurCredit = "Votre crédit est insuffisant";
			request.setAttribute("erreurCredit", erreurCredit);

		}

		// enregistrer l'enchère si elle répond aux 3 critères précédents : montant, date, crédit utilisateur
		if (MontantEnchereSaisieEstPlusElevé && enchereSaisieDateValide && creditSuperieurAMontantEnchere) {
			enchereManager.insert(enchereAIntegrer);
		
			// passe le prix max en attribut
			request.setAttribute("enchereActuelle", enchereAIntegrer.getMontantEnchere());
			
			// Mise à jour crédit enchérisseur
			int soldeUtilisateur = utilisateurEnSession.getCredit() - enchereAIntegrer.getMontantEnchere();
			utilisateurEnSession.setCredit(soldeUtilisateur);
			try {
				utilisateurManager.update(utilisateurEnSession);
			} catch (DALException e1) {
				e1.printStackTrace();
			}
			
			// Mise à jour crédit ancien enchérisseur

			
			int noUtilisateurAncienEncherisseur = 0;
			try {
				noUtilisateurAncienEncherisseur = enchereMax.getNoUtilisateurEnchere();
			} catch (NullPointerException e) {
				
				e.printStackTrace();
			}
			
			if(noUtilisateurAncienEncherisseur != 0) {
				Utilisateur ancienEncherisseur = utilisateurManager.selectById(noUtilisateurAncienEncherisseur);
				int soldeUtilisateurAncienEncherisseur = ancienEncherisseur.getCredit() + enchereMax.getMontantEnchere();
				ancienEncherisseur.setCredit(soldeUtilisateurAncienEncherisseur);
				try {
					utilisateurManager.update(ancienEncherisseur);
				} catch (DALException e) {
					
					e.printStackTrace();
				}

			}

		}

		request.getRequestDispatcher("/WEB-INF/templates/DetailVente.jsp").forward(request, response);
	}

}
