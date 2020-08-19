package fr.eni.projet.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import fr.eni.projet.bo.ArticleVendu;
import fr.eni.projet.dal.ArticleVenduDAO;
import fr.eni.projet.dal.ConnectionProvider;
import fr.eni.projet.dal.DALException;

public class ArticleVenduDAOJdbcImpl implements ArticleVenduDAO{

	//Variables commandes SQL
	
		private static final String sqlInsertArticle = "INSERT INTO ARTICLES_VENDUS(nom_article,description,date_debut_encheres,date_fin_encheres,prix_initial,prix_vente,no_utilisateur,no_categorie) VALUES (?,?,?,?,?,?,?,?)";
		private static final String sqlSelectById = "SELECT no_article,nom_article,description,date_debut_encheres,date_fin_encheres,prix_initial,prix_vente,no_utilisateur,no_categorie FROM ARTICLES_VENDUS WHERE no_article = ?";
		private static final String sqlSelectAll = "SELECT no_article,nom_article,description,date_debut_encheres,date_fin_encheres,prix_initial,prix_vente,no_utilisateur,no_categorie FROM ARTICLES_VENDUS";
		private static final String sqlUpdate = "UPDATE  ARTICLES_VENDUS SET nom_article=? ,date_debut_encheres=?,date_fin_encheres=?,prix_initial=?,prix_vente=?,no_utilisateur=?,no_categorie=? WHERE no_article = ? ";
		private static final String sqlDelete = "DELETE  FROM  ARTICLES_VENDUS WHERE no_article = ?";
//		
	// Constructor Vide
		
		public ArticleVenduDAOJdbcImpl () {
			
		}
		

	
		
	// Methode Insert nouvel Article
		@Override
		public void insert(ArticleVendu a, int noUtilisteur, int noCategorie) throws DALException {
			
			//1- Obtenir une connexion à la base de données
			
			try(Connection conn = ConnectionProvider.getConnection()) {
				
				//2 - Préparer la requete SQL (insert...)
				PreparedStatement pStmt = conn.prepareStatement(sqlInsertArticle, Statement.RETURN_GENERATED_KEYS);
				pStmt.setString(1, a.getNomArticle());
				pStmt.setString(2, a.getDescription());
				pStmt.setTimestamp(3, a.getDateDebutEnchere());
				pStmt.setTimestamp(4, a.getDateFinEnchere());
				pStmt.setInt(5, a.getMiseAPrix());
				pStmt.setInt(6, a.getPrixVente());
				pStmt.setInt(7, noUtilisteur);
				pStmt.setInt(8, noCategorie);
				
				
				//3 - Executer la requete
				pStmt.executeUpdate();
				
				//4 - Récupérer l'id
				ResultSet rsKey = pStmt.getGeneratedKeys(); 
				if(rsKey.next()) {
					a.setNoArticle(rsKey.getInt(1));	
				}
				
				
				//5 - Fermer la connexion = Remettre la connexion disponible dans le pool
				
				
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
					PreparedStatement stmt = conn.prepareStatement(sqlSelectById);
					stmt.setInt(1, noArticle);
					ResultSet rs = stmt.executeQuery();

					if(rs.next()) {
						
						a = new ArticleVendu(rs.getInt("no_article"),  
								        rs.getString("nom_article"),
								        rs.getString("description "),
								        rs.getTimestamp("date_debut_encheres"),
								        rs.getTimestamp("date_fin_encheres"),
								        rs.getInt("prix_initial"),
								        rs.getInt("prix_vente"),
								        rs.getInt("no_utilisateur"),
								        rs.getInt("no_categorie"));
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
				ResultSet rs = stmt.executeQuery(sqlSelectAll);
				while(rs.next()) {
					ArticleVendu article = new ArticleVendu(rs.getInt("no_article"),  
					        rs.getString("nom_article"),
					        rs.getString("description "),
					        rs.getTimestamp("date_debut_encheres"),
					        rs.getTimestamp("date_fin_encheres"),
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
				PreparedStatement stmt = conn.prepareStatement(sqlUpdate);
				
				stmt.setString(1, a.getDescription());
				stmt.setTimestamp(2, a.getDateDebutEnchere());
				stmt.setTimestamp(3, a.getDateFinEnchere());
				stmt.setInt(4, a.getMiseAPrix());
				stmt.setInt(5, a.getPrixVente());
				stmt.setInt(6, a.getNoUtilisateurArticle());
				stmt.setInt(7, a.getNoCategorieArticle());
				stmt.setString(8, a.getNomArticle());
				
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
				PreparedStatement stmt = connection.prepareStatement(sqlDelete);
				stmt.setInt(1, id);
				stmt.executeUpdate();
			} catch (SQLException e) {
				throw new DALException("Delete ArticleVendu FAIL - ", e);
			}
		}
		
	
}