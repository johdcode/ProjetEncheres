package fr.eni.projet.ihm;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.projet.bll.ArticleVenduManager;
import fr.eni.projet.bll.CategorieManager;
import fr.eni.projet.bo.ArticleVendu;
import fr.eni.projet.bo.Categorie;
import fr.eni.projet.dal.DALException;

/**
 * Servlet implementation class DetailVente
 */
@WebServlet("/DetailVente")
public class DetailVenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		SessionService.checkUtilisateurSession(request);
		// reccupérer l'ID de l'utilisateur
		
		
		// reccuperer l'ID de l'article et le passer en attribut
		int idArticle = Integer.parseInt(request.getParameter("idArticle"));
		System.out.println(idArticle);
		
		// recuperer l'article a afficher
		ArticleVendu av = new ArticleVendu();
		ArticleVenduManager avm = ArticleVenduManager.getInstance();
		
		try {
			av = avm.selectById(idArticle);	
		} catch (DALException e) {
			e.printStackTrace();
		}
		request.setAttribute("articleAAfficher", av);
		
		// récupérer la catégorie
		
		Categorie categorieArticle = new Categorie();
		CategorieManager cm = CategorieManager.getInstance();
		
		try {
			categorieArticle = cm.selectById(idArticle);
		} catch (DALException e) {
			e.printStackTrace();
		}
		request.setAttribute("categorieArticle", categorieArticle);
		
		
		//Methode selectionne l'enchere la plus haute en fonction de l'article
		
		
		request.getRequestDispatcher("/WEB-INF/templates/DetailVente.jsp").forward(request, response);
	}

	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getRequestDispatcher("/WEB-INF/templates/DetailVente.jsp").forward(req, resp);
	}

}
