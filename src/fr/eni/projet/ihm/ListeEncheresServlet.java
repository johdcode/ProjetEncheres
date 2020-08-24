package fr.eni.projet.ihm;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import fr.eni.projet.bll.ArticleVenduManager;
import fr.eni.projet.bll.CategorieManager;
import fr.eni.projet.bll.UtilisateurManager;
import fr.eni.projet.bo.ArticleVendu;
import fr.eni.projet.bo.Categorie;
import fr.eni.projet.bo.Utilisateur;
import fr.eni.projet.dal.DALException;

/**
 * Servlet implementation class ListeEncheresServlet
 */
@WebServlet("/encheres")
public class ListeEncheresServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private CategorieManager categorieManager = CategorieManager.getInstance();
	private UtilisateurManager utilisateurManager = UtilisateurManager.getInstance();
	private ArticleVenduManager articleVenduManager = ArticleVenduManager.getInstance();


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		SessionService.checkUtilisateurSession(request);
		List <ArticleVendu> listeArticle = new ArrayList<ArticleVendu>();
		try {
			listeArticle = articleVenduManager.selectAll();
		} catch (DALException e1) {
			e1.printStackTrace();
		}
		
		if((request.getParameter("recherche") != null && !request.getParameter("recherche").isEmpty()) 
				|| (request.getParameter("categorie") != null && !request.getParameter("categorie").isEmpty())) {
			String recherche = request.getParameter("recherche").trim();
			String categorie = request.getParameter("categorie").trim();
			
			Categorie targetCategorie = null;
			
			int erreur = 0;
			
			if(recherche != null && !recherche.isEmpty()) {
				if(recherche.length() >= 30) {
					erreur++;
				}
			}
			if(categorie != null && !categorie.isEmpty()) {
				if(categorie.length() >= 30) {
					erreur++;
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
		
		// liste des catégories
		List <Categorie> listeCategorie = new ArrayList<Categorie>();
		try {
			listeCategorie = categorieManager.selectAll();
		} catch (DALException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("listeCategorie", listeCategorie);
		request.setAttribute("listeArticle", listeArticle);

		request.getRequestDispatcher("/WEB-INF/templates/ListeEncheres.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String recherche = request.getParameter("recherche");
		String categorie = request.getParameter("categorie");
		
//		String achat = request.getParameter("achat");
		String type = request.getParameter("type");
		String encheresOuvertes = request.getParameter("encheres_ouvertes");
		String mesEncheres = request.getParameter("mes_encheres");
		String mesEncheresRemportees = request.getParameter("mes_encheres_remportees");
		
//		String vente = request.getParameter("vente");
		String ventesEnCours = request.getParameter("ventes_en_cours");
		String ventesNonDebutees = request.getParameter("ventes_non_debutees");
		String ventesTerminees = request.getParameter("ventes_terminees");
		
		System.out.println("recherche : " + recherche);
		System.out.println("categorie : " + categorie);
		System.out.println("achat : " + type);
		System.out.println("encheresOuvertes : " + encheresOuvertes);
		System.out.println("mesEncheres : " + mesEncheres);
		System.out.println("mesEncheresRemportees : " + mesEncheresRemportees);
		System.out.println("vente : " + type);
		System.out.println("ventesEnCours : " + ventesEnCours);
		System.out.println("ventesNonDebutees : " + ventesNonDebutees);
		System.out.println("ventesTerminees : " + ventesTerminees);

		int erreur = 0;

		if(recherche == null || recherche == "") {
			erreur++;
		}
		if(recherche != null && recherche.length() >= 30) {
			erreur++;
		}
		
		if(categorie == null || categorie == "") {
			erreur++;
		}
		if(categorie != null && categorie.length() >= 30) {
			erreur++;
		}
		
		if(type == null || type == "") {
			erreur++;
		}
		if(type != null && type.length() >= 30) {
			erreur++;
		}
		
		if(encheresOuvertes == null || encheresOuvertes == "") {
			erreur++;
		}
		if(encheresOuvertes != null && encheresOuvertes.length() >= 30) {
			erreur++;
		}
		
		if(mesEncheres == null || mesEncheres == "") {
			erreur++;
		}
		if(mesEncheres != null && mesEncheres.length() >= 30) {
			erreur++;
		}
		
		if(mesEncheresRemportees == null || mesEncheresRemportees == "") {
			erreur++;
		}
		if(mesEncheresRemportees != null && mesEncheresRemportees.length() >= 30) {
			erreur++;
		}
		
		if(ventesEnCours == null || ventesEnCours == "") {
			erreur++;
		}
		if(ventesEnCours != null && ventesEnCours.length() >= 30) {
			erreur++;
		}
		
		if(ventesNonDebutees == null || ventesNonDebutees == "") {
			erreur++;
		}
		if(ventesNonDebutees != null && ventesNonDebutees.length() >= 30) {
			erreur++;
		}
		
		if(ventesTerminees == null || ventesTerminees == "") {
			erreur++;
		}
		if(ventesTerminees != null && ventesTerminees.length() >= 30) {
			erreur++;
		}
		
		if(erreur == 0) {
			response.sendRedirect(request.getContextPath() + "/encheres");
		} else {
			response.getWriter().print("Il y a eu une erreur dans la recherche.");
		}
	}

}
