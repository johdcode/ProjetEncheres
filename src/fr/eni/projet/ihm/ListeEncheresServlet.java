package fr.eni.projet.ihm;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import fr.eni.projet.bll.ArticleVenduManager;
import fr.eni.projet.bll.CategorieManager;
import fr.eni.projet.bll.EnchereManager;
import fr.eni.projet.bll.UtilisateurManager;
import fr.eni.projet.bo.ArticleVendu;
import fr.eni.projet.bo.Categorie;
import fr.eni.projet.bo.Utilisateur;
import fr.eni.projet.dal.DALException;
import fr.eni.projet.exception.BusinessException;

/**
 * Servlet implementation class ListeEncheresServlet
 */
@WebServlet("/encheres")
public class ListeEncheresServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private CategorieManager categorieManager = CategorieManager.getInstance();
	private UtilisateurManager utilisateurManager = UtilisateurManager.getInstance();
	private ArticleVenduManager articleVenduManager = ArticleVenduManager.getInstance();
	private EnchereManager enchereManager = EnchereManager.getInstance();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		Utilisateur utilisateur = SessionService.checkUtilisateurSession(request);
		
		String recherche = request.getParameter("recherche");
		String categorie = request.getParameter("categorie");
		
		String type = request.getParameter("type");
		String encheresOuvertes = request.getParameter("encheres_ouvertes");
		String mesEncheres = request.getParameter("mes_encheres");
		String mesEncheresRemportees = request.getParameter("mes_encheres_remportees");
		
//		String vente = request.getParameter("vente");
		String ventesEnCours = request.getParameter("ventes_en_cours");
		String ventesNonDebutees = request.getParameter("ventes_non_debutees");
		String ventesTerminees = request.getParameter("ventes_terminees");
		
		List <ArticleVendu> listeArticle = new ArrayList<ArticleVendu>();
		try {
			listeArticle = articleVenduManager.selectAll();
		} catch (DALException e1) {
			e1.printStackTrace();
		}
		
		if((recherche != null && !recherche.isEmpty()) 
				|| (categorie != null && !categorie.isEmpty())) {
			Categorie targetCategorie = null;
			
			int erreur = 0;
			
			if(recherche != null && !recherche.isEmpty()) {
				if(recherche.length() >= 30) {
					erreur++;
					BusinessException.addMessageErreur("La recherche ne doit pas faire plus de 30 caractères.");
				}
			}
			if(categorie != null && !categorie.isEmpty()) {
				if(categorie.length() >= 30) {
					erreur++;
					BusinessException.addMessageErreur("La catégorie ne doit pas faire plus de 30 caractères.");
				}
				
				// Vérifie que la catégorie existe
				List<Categorie> categories = new ArrayList<>();
				try {
					categories = categorieManager.selectAll();
				} catch (DALException e) {
					e.printStackTrace();
				}
				for(Categorie cat : categories) {
					if(cat.getLibelle().toLowerCase().equals(categorie.toLowerCase())) {
						targetCategorie = cat;
					}
				}
				if(targetCategorie == null) {
					erreur++;
					BusinessException.addMessageErreur("La catégorie indiqué n'existe pas.");
				}
			}
		
			
			
			if(erreur == 0) {
				try {
					// Recherche
					if(recherche != null && !recherche.isEmpty()) {
						listeArticle = articleVenduManager.selectByRecherche(recherche);
					}
					// Catégorie
					
					
					
					if(categorie != null && !categorie.isEmpty()){
						List<ArticleVendu> outListeArticle =  new ArrayList<ArticleVendu>();
						// Trie les articles
						for(ArticleVendu art : listeArticle) {
							Utilisateur u = utilisateurManager.selectById(art.getNoUtilisateurArticle());
							
							art.setUtilisateur(u);
							if(art.getNoCategorieArticle() == targetCategorie.getNoCategorie()) {
								outListeArticle.add(art);
							}
						}
						listeArticle = outListeArticle;
					}
				} catch (DALException e) {
					e.printStackTrace();
				}
				
				request.setAttribute("recherche", recherche);
				request.setAttribute("categorie", categorie);
			}
		}
		
		//ACHAT
		if(type != null && type.trim().equals("achat")) {
			// Encheres ouvertes
			if(encheresOuvertes != null && encheresOuvertes.equals("on")) {
				List<ArticleVendu> outListeArticles =  new ArrayList<ArticleVendu>();
				List<ArticleVendu> articlesBDD =  new ArrayList<ArticleVendu>();
				try {
					articlesBDD = articleVenduManager.selectByEncheresOuvertes(utilisateur.getNoUtilisateur());
				} catch (DALException e) {
					e.printStackTrace();
				}
				// Place les articles en commun dans la outListeArticles
				for(int i = 0; i < listeArticle.size(); i++) {
					for(ArticleVendu art : articlesBDD) {
						if(listeArticle.get(i).getNoArticle() == art.getNoArticle() ) {
							outListeArticles.add(art);
						}
					}
				}
				listeArticle = outListeArticles;
			}
			
			// Mes encheres
			if(mesEncheres != null && mesEncheres.equals("on")) {
				List<ArticleVendu> outListeArticles =  new ArrayList<ArticleVendu>();
				List<ArticleVendu> articlesBDD =  new ArrayList<ArticleVendu>();
				try {
					articlesBDD = articleVenduManager.selectByMesEncheres(utilisateur.getNoUtilisateur());
				} catch (DALException e) {
					e.printStackTrace();
				}
				// Place les articles en commun dans la outListeArticles
				for(int i = 0; i < listeArticle.size(); i++) {
					for(ArticleVendu art : articlesBDD) {
						if(listeArticle.get(i).getNoArticle() == art.getNoArticle() ) {
							outListeArticles.add(art);
						}
					}
				}
				listeArticle = outListeArticles;
			}
			
			// Mes encheres remportées
			if(mesEncheresRemportees != null && mesEncheresRemportees.equals("on")) {
				List<ArticleVendu> outListeArticles =  new ArrayList<ArticleVendu>();
				List<ArticleVendu> articlesBDD =  new ArrayList<ArticleVendu>();
				try {
					articlesBDD = articleVenduManager.selectByMesEncheresRemportees(utilisateur.getNoUtilisateur());
				} catch (DALException e) {
					e.printStackTrace();
				}
				// Place les articles en commun dans la outListeArticles
				for(int i = 0; i < listeArticle.size(); i++) {
					for(ArticleVendu art : articlesBDD) {
						if(listeArticle.get(i).getNoArticle() == art.getNoArticle() ) {
							outListeArticles.add(art);
						}
					}
				}
				listeArticle = outListeArticles;
			}
		}
		//VENTE
		else if(type != null && type.trim().equals("vente")) {
			
			
			
			// Vente en cours
			if(ventesEnCours != null && ventesEnCours.equals("on")) {
				List<ArticleVendu> outListeArticles =  new ArrayList<ArticleVendu>();
				List<ArticleVendu> articlesBDD =  new ArrayList<ArticleVendu>();
				try {
					articlesBDD = articleVenduManager.selectByMesVentesEnCours(utilisateur.getNoUtilisateur());	
				} catch (DALException e) {
					e.printStackTrace();
				}
				// Place les articles en commun dans la outListeArticles
				for(int i = 0; i < listeArticle.size(); i++) {
					for(ArticleVendu art : articlesBDD) {
						if(listeArticle.get(i).getNoArticle() == art.getNoArticle() ) {
							outListeArticles.add(art);
						}
					}
				}
				listeArticle = outListeArticles;
			}
			// Ventes non debutees
			if(ventesNonDebutees != null && ventesNonDebutees.equals("on")) {
				List<ArticleVendu> outListeArticles =  new ArrayList<ArticleVendu>();
				List<ArticleVendu> articlesBDD =  new ArrayList<ArticleVendu>();
				try {
					articlesBDD = articleVenduManager.selectByMesVentesNonDebutees(utilisateur.getNoUtilisateur());
				} catch (DALException e) {
					e.printStackTrace();
				}
				// Place les articles en commun dans la outListeArticles
				for(int i = 0; i < listeArticle.size(); i++) {
					for(ArticleVendu art : articlesBDD) {
						if(listeArticle.get(i).getNoArticle() == art.getNoArticle() ) {
							outListeArticles.add(art);
						}
					}
				}
				listeArticle = outListeArticles;
			}
			// Ventes terminées
			if(ventesTerminees != null && ventesTerminees.equals("on")) {
				List<ArticleVendu> outListeArticles =  new ArrayList<ArticleVendu>();
				List<ArticleVendu> articlesBDD =  new ArrayList<ArticleVendu>();
				try {
					articlesBDD = articleVenduManager.selectByMesVentesTerminees(utilisateur.getNoUtilisateur());
				} catch (DALException e) {
					e.printStackTrace();
				}
				// Place les articles en commun dans la outListeArticles
				for(int i = 0; i < listeArticle.size(); i++) {
					for(ArticleVendu art : articlesBDD) {
						if(listeArticle.get(i).getNoArticle() == art.getNoArticle() ) {
							outListeArticles.add(art);
						}
					}
				}
				listeArticle = outListeArticles;
			}
			
		}

		
		// liste des catégories
		List <Categorie> listeCategorie = new ArrayList<Categorie>();
		try {
			listeCategorie = categorieManager.selectAll();
		} catch (DALException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("listeCategorie", listeCategorie);
		request.setAttribute("listeArticle", listeArticle);

		request.setAttribute("listeErreur", BusinessException.getListeMessageException());
		
		request.getRequestDispatcher("/WEB-INF/templates/ListeEncheres.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		doGet(request, response);
	}

}
