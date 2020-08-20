package fr.eni.projet.test;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.projet.bll.ArticleVenduManager;
import fr.eni.projet.bll.UtilisateurManager;
import fr.eni.projet.bo.ArticleVendu;
import fr.eni.projet.bo.Utilisateur;
import fr.eni.projet.dal.ArticleVenduDAO;
import fr.eni.projet.dal.DALException;
import fr.eni.projet.dal.DAOFactory;
import fr.eni.projet.dal.jdbc.ArticleVenduDAOJdbcImpl;

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
//		UtilisateurManager um = UtilisateurManager.getInstance();
//		System.out.println(um.authentification("kim", "motDePasse"));
//	System.out.println(um.selectAll());
//		System.out.println(um.selectById("jo"));
//		Utilisateur u = new Utilisateur("kim", "Kim", "Maroé", "kim@mail.com", "0707070707", "Rue des lilas", "44200", "Nantes", "motDePasse", 10.0f, false);
//		um.insert(u);
		
		
		//Test ArticleVenduDAO
//				//Insert
//		ArticleVenduManager avm = ArticleVenduManager.getInstance();
//		ArticleVendu b = new ArticleVendu("basse", "5 cordes", new Timestamp(1901-01-01), new Timestamp(1901-01-01), 2, 3, 4, 2); 
//		try {
//			avm.insert(b, 1, 2);
//		} catch (DALException e) {
//			// TODO Auto-generated catch block
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
		
//		ArticleVenduManager avm = ArticleVenduManager.getInstance();
//		try {
//			System.out.println(avm.selectById(3));
//		} catch (DALException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
				//SelectAll
//		ArticleVenduManager avm = ArticleVenduManager.getInstance();
//		try {
//			System.out.println(avm.selectAll());
//		} catch (DALException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//				//Update
//		ArticleVenduManager avm = ArticleVenduManager.getInstance();
//		ArticleVendu b = new ArticleVendu(2,"grosse guitare", "12 cordes", new Timestamp(1901-01-01), new Timestamp(1901-01-01), 2, 3, 1, 2); 
//		try {
//			avm.update(b);
//		} catch (DALException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
				//Delete
//		ArticleVenduManager avm = ArticleVenduManager.getInstance();
//		try {
//			avm.delete(5);
//		} catch (DALException e) {
//			// TODO Auto-generated catch block
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
