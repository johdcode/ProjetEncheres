package fr.eni.projet.test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.projet.bll.RetraitManager;
import fr.eni.projet.bo.Retrait;
import fr.eni.projet.dal.DALException;


/**
 * Servlet implementation class Tests
 */
@WebServlet("/Tests")
public class Tests extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//	UtilisateurManager um = UtilisateurManager.getInstance();
//		System.out.println(um.authentification("kim", "motDePasse"));

	//System.out.println(um.selectAll());

		
//		Utilisateur u = new Utilisateur(6,"kim", "Kim", "Maroé", "kim@mail.com", "0707070707", "Rue des lilas", "44200", "Nantes", "motDePasse", 10.0f, false);
//		u.setNom("Coco");
//
//		//um.insert(u);
//		try {
//			um.update(u);
//		} catch (DALException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	
//		ArticleVenduDAOJdbcImpl a = (ArticleVenduDAOJdbcImpl) DAOFactory.getArticleVenduDAO();
//		ArticleVendu b = new ArticleVendu("guitare", "6 cordes", new Timestamp(1901-01-01), new Timestamp(1901-01-01), 2, 3, 1, 2);
//		try {
//			a.insert(b, 1, 2);
//		} catch (DALException e) {
//			
//			e.printStackTrace();
//		}


//	System.out.println(um.selectAll());
//		System.out.println(um.selectById("jo"));
//		Utilisateur u = new Utilisateur("kim", "Kim", "Maroé", "kim@mail.com", "0707070707", "Rue des lilas", "44200", "Nantes", "motDePasse", 10.0f, false);
//		um.insert(u);
		
		
		//Test ArticleVenduDAO
				//Insert
//		RetraitManager avm = RetraitManager.getInstance();
//		Retrait b = new Retrait(2, "25 place de la bourse", "44000", "Nantes"); 
//		try {
//			avm.insert(b);
//		} catch (DALException e) {
//
//			e.printStackTrace();
//		}
		
//		ArticleVenduDAOJdbcImpl a = (ArticleVenduDAOJdbcImpl) DAOFactory.getArticleVenduDAO();
//		ArticleVendu b = new ArticleVendu("Basse", "5 cordes", new Timestamp(1901-01-01), new Timestamp(1901-01-01), 2, 3, 1, 2);
//		try {
//			a.insert(b, 1, 2);
//		} catch (DALException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
				//SelectByID
		
//		ArticleVenduDAOJdbcImpl a = (ArticleVenduDAOJdbcImpl) DAOFactory.getArticleVenduDAO();
//		try {
//			System.out.println(a.selectById(3));
//		} catch (DALException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		RetraitManager avm = RetraitManager.getInstance();
//		try {
//			System.out.println(avm.selectById(11));
//		} catch (DALException e) {
//
//			e.printStackTrace();
//		}
		
				//SelectAll
//		RetraitManager avm = RetraitManager.getInstance();
//		try {
//			System.out.println(avm.selectAll());
//		} catch (DALException e) {
//			
//			e.printStackTrace();
//		}
		
//				//Update
//		RetraitManager avm = RetraitManager.getInstance();
//		Retrait b = new Retrait(2, "2 place de la bourse", "44000", "Naoned"); 
//		try {
//			avm.update(b);
//		} catch (DALException e) {
//			
//			e.printStackTrace();
//		}
//		
				//Delete
//		RetraitManager avm = RetraitManager.getInstance();
//		try {
//			avm.delete(2);
//		} catch (DALException e) {
//
//			e.printStackTrace();
//		}
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
