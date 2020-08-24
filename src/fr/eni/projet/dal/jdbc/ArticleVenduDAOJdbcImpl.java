package fr.eni.projet.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.projet.bll.CategorieManager;
import fr.eni.projet.bll.RetraitManager;
import fr.eni.projet.bll.UtilisateurManager;
import fr.eni.projet.bo.ArticleVendu;
import fr.eni.projet.bo.Retrait;
import fr.eni.projet.dal.ArticleVenduDAO;
import fr.eni.projet.dal.ConnectionProvider;
import fr.eni.projet.dal.DALException;




public class ArticleVenduDAOJdbcImpl implements ArticleVenduDAO{

	//Variables commandes SQL
	
		private static final String SQL_INSERT_ARTICLE = "INSERT INTO ARTICLES_VENDUS(nom_article,description,date_debut_encheres,date_fin_encheres,prix_initial,prix_vente,no_utilisateur,no_categorie) VALUES (?,?,?,?,?,?,?,?)";
		private static final String SQL_SELECT_BY_ID = "SELECT no_article,nom_article,description,date_debut_encheres,date_fin_encheres,prix_initial,prix_vente,no_utilisateur,no_categorie FROM ARTICLES_VENDUS WHERE no_article = ?;";
		private static final String SQL_SELECT_ALL = "SELECT no_article,nom_article,description,date_debut_encheres,date_fin_encheres,prix_initial,prix_vente,no_utilisateur,no_categorie FROM ARTICLES_VENDUS;";
		private static final String SQL_UPDATE = "UPDATE  ARTICLES_VENDUS SET nom_article=?,description=?,date_debut_encheres=?,date_fin_encheres=?,prix_initial=?,prix_vente=?,no_utilisateur=?,no_categorie=? WHERE no_article = ?;";
		private static final String SQL_DELETE = "DELETE  FROM  ARTICLES_VENDUS WHERE no_article = ?";
//		
	// Constructor Vide
		
		public ArticleVenduDAOJdbcImpl () {
			
		}
		

	
		
	// Methode Insert nouvel Article
		@Override
		public void insert(ArticleVendu a, Retrait r) throws DALException {
			
			//1- Obtenir une connexion à la base de données
			
			try(Connection conn = ConnectionProvider.getConnection()) {
				
				//2 - Préparer la requete SQL (insert...)
				PreparedStatement pStmt = conn.prepareStatement(SQL_INSERT_ARTICLE, Statement.RETURN_GENERATED_KEYS);
				pStmt.setString(1, a.getNomArticle());
				pStmt.setString(2, a.getDescription());
				pStmt.setTimestamp(3, java.sql.Timestamp.valueOf(a.getDateDebutEnchere()));
				pStmt.setTimestamp(4, java.sql.Timestamp.valueOf(a.getDateFinEnchere()));
				pStmt.setInt(5, a.getMiseAPrix());
				pStmt.setInt(6, a.getPrixVente());
				pStmt.setInt(7, a.getNoUtilisateurArticle());
				pStmt.setInt(8, a.getNoCategorieArticle());
				
				
				//3 - Executer la requete
				int nbLignes = pStmt.executeUpdate();
				
				//4 - Récupérer l'id
				if (nbLignes == 1) {
					ResultSet rsKey = pStmt.getGeneratedKeys(); 
					if(rsKey.next()) {
						a.setNoArticle(rsKey.getInt(1));	
					}
//					int noUtilisateur = a.getNoUtilisateurArticle();
					
					r.setNoArticleRetrait(a.getNoArticle());
					RetraitManager rm = RetraitManager.getInstance();
					rm.insert(r);
//					RetraitManager.getInstance().insert(r);
				}
				//5 -
				a.setUtilisateur(UtilisateurManager.getInstance().selectById(a.getNoUtilisateurArticle()));
				a.setCategorie(CategorieManager.getInstance().selectById(a.getNoCategorieArticle()));
				
				
			} catch (SQLException e) {
				e.printStackTrace();
				
				//TODO 
				throw new DALException("Insert ArticleVendu FAIL", e);
			}
		}
		
	// Methode Select by ID
		@Override	
		public ArticleVendu selectById(int noArticle) throws DALException {
			ArticleVendu a = null;

			try(Connection conn = ConnectionProvider.getConnection()){
					PreparedStatement stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
					stmt.setInt(1, noArticle);
					ResultSet rs = stmt.executeQuery();
					if(rs.next()) {
						a = new ArticleVendu(
										rs.getInt("no_article"),  
								        rs.getString("nom_article"),
								        rs.getString("description"),
								        rs.getTimestamp("date_debut_encheres").toLocalDateTime(),
								        rs.getTimestamp("date_fin_encheres").toLocalDateTime(),
								        rs.getInt("prix_initial"),
								        rs.getInt("prix_vente"),
								        rs.getInt("no_utilisateur"),
								        rs.getInt("no_categorie")
								);
					}
			
		} catch (SQLException e) {
			throw new DALException("SelectById ArticleVendu FAIL - ", e);
		}
		return a;
	}
					
		
	// Methode Select all
		@Override
		public List<ArticleVendu> selectAll() throws DALException{
			List<ArticleVendu> articles = new ArrayList<ArticleVendu>();
			
			try (Connection connection = ConnectionProvider.getConnection()){ 
				Statement stmt = connection.createStatement();
				ResultSet rs = stmt.executeQuery(SQL_SELECT_ALL);
				while(rs.next()) {
					ArticleVendu article = new ArticleVendu(
							rs.getInt("no_article"),  
					        rs.getString("nom_article"),
					        rs.getString("description"),
					        rs.getTimestamp("date_debut_encheres").toLocalDateTime(),
					        rs.getTimestamp("date_fin_encheres").toLocalDateTime(),
					        rs.getInt("prix_initial"),
					        rs.getInt("prix_vente"),
					        rs.getInt("no_utilisateur"),
					        rs.getInt("no_categorie"));
					articles.add(article);
				}
			} catch (SQLException e) {
				e.printStackTrace();
				throw new DALException("SelectAll ArticleVendu FAIL", e);
			}
			return articles;
			
		}
		
		
	// Methode Update article
		@Override
		public void update(ArticleVendu a) throws DALException {
			try(Connection conn = ConnectionProvider.getConnection()){
				PreparedStatement stmt = conn.prepareStatement(SQL_UPDATE);
				
				stmt.setString(1, a.getNomArticle());
				stmt.setString(2, a.getDescription());
				stmt.setTimestamp(3, java.sql.Timestamp.valueOf(a.getDateDebutEnchere()));
				stmt.setTimestamp(4, java.sql.Timestamp.valueOf(a.getDateFinEnchere()));
				stmt.setInt(5, a.getMiseAPrix());
				stmt.setInt(6, a.getPrixVente());
				stmt.setInt(7, a.getNoUtilisateurArticle());
				stmt.setInt(8, a.getNoCategorieArticle());
				stmt.setInt(9, a.getNoArticle());
				
				stmt.executeUpdate();
			}catch (SQLException e) {
				e.printStackTrace();
				throw new DALException("Update ArticleVendu FAIL", e);
			}
			}	
		
		
		
	// Methode Delete
		@Override
		public void delete(int id) throws DALException {
			try (Connection connection = ConnectionProvider.getConnection()) {
				PreparedStatement stmt = connection.prepareStatement(SQL_DELETE);
				stmt.setInt(1,id);
				stmt.executeUpdate();
			} catch (SQLException e) {
				throw new DALException("Delete ArticleVendu FAIL - ", e);
			}
		}
		
	
}
