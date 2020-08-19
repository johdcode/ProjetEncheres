package fr.eni.projet.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import fr.eni.gestionAvis.bo.Avis;
import fr.eni.gestionAvis.bo.Categorie;
import fr.eni.projet.bo.ArticleVendu;
import fr.eni.projet.dal.ArticleVenduDAO;
import fr.eni.projet.dal.ConnectionProvider;
import fr.eni.projet.dal.DALException;

public class ArticleVenduDAOJdbcImpl implements ArticleVenduDAO{

	//Variables commandes SQL
	
		private static final String sqlInsertArticle = "INSERT INTO ARTICLES_VENDUS VALUES (?,?,?,?,?,?,?,?)";
		private static final String sqlSelectById = "SELECT no_article,nom_article,date_debut_encheres,date_fin_encheres,prix_initial,prix_vente,no_utilisateur,no_categorie FROM ARTICLES_VENDUS WHERE no_article = ?";
//		private static final String sqlSelectAll = "SELECT idArticle,marque,reference,designation,prixUnitaire,qteStock,grammage,couleur,type FROM dbo.Articles";
//		private static final String sqlUpdate = "UPDATE  dbo.Articles SET reference = ?, marque = ?,designation = ?, prixUnitaire = ?, qteStock = ?, grammage = ?, couleur = ? WHERE idArticle = ? ";
//		private static final String sqlDelete = "DELETE  FROM  dbo.Articles WHERE idArticle = ?";
//		
	// Constructor Vide
		
		public ArticleVenduDAOJdbcImpl () {
			
		}
	// Methode Insert nouvel Article
		public void insert(ArticleVendu a, int noUtilisteur, int noCategorie) throws DALException {
			
			//1- Obtenir une connexion à la base de données
			
			try(Connection conn = ConnectionProvider.getConnection()) {
				
				//2 - Préparer la requete SQL (insert...)
				PreparedStatement pStmt = conn.prepareStatement(sqlInsertArticle, Statement.RETURN_GENERATED_KEYS);
				pStmt.setString(1, a.getNomArticle());
				pStmt.setString(2, a.getDescription());
				pStmt.setTimestamp(3, a.getDateDebutEnchere());
				pStmt.setTimestamp(3, a.getDateFinEnchere());
				pStmt.setInt(5, a.getMiseAPrix());
				pStmt.setInt(6, a.getPrixVente());
				//TODO récup num utilisateur  & num catégorie
				pStmt.setInt(7, noUtilisteur);
				pStmt.setInt(7, noCategorie);
				
				
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
				throw new DALException("Echec de insertAvis", e);
			}
		}
		
	// Methode Select by ID
		
			
		public ArticleVendu selectById(int noArticle) throws DALException {
			ArticleVendu a = null;
				//1- Obtenir une connexion à la base de données	

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
			throw new DALException("SelectById failed - ", e);
		}
		return a;
	}
			
			
		
		
		
	// Methode Select all
		
	// Methode Update article
		
	// Methode Delete
		
	
	
}
