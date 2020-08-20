package fr.eni.projet.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.projet.bo.Categorie;
import fr.eni.projet.dal.CategorieDAO;
import fr.eni.projet.dal.ConnectionProvider;
import fr.eni.projet.dal.DALException;

public class CategorieDAOJdbcImpl implements CategorieDAO {

	private static final String SQL_INSERT = "INSERT INTO CATEGORIES (libelle) VALUES (?);";
	private static final String SQL_SELECT_BY_ID = "SELECT no_categorie, libelle FROM CATEGORIES WHERE no_categorie = ?;";
	private static final String SQL_SELECT_ALL = "SELECT no_categorie, libelle FROM CATEGORIES;";
	private static final String SQL_UPDATE = "UPDATE CATEGORIES SET libelle=? WHERE no_categorie = ?;";
	private static final String SQL_DELETE = "DELETE  FROM  CATEGORIES WHERE no_article = ?";

	
	//Constructor vide
	public CategorieDAOJdbcImpl() {	
	}

	//Insert

	@Override
	public void insert(Categorie c) throws DALException {
		
		//1- Obtenir une connexion à la base de données
		
		try(Connection conn = ConnectionProvider.getConnection()) {
			
			//2 - Préparer la requete SQL (insert...)
			PreparedStatement pStmt = conn.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
			pStmt.setString(1, c.getLibelle());
			
			//3 - Executer la requete
			int nbLignes = pStmt.executeUpdate();
			//4 - Récupérer l'id
			if (nbLignes == 1) {
				ResultSet rsKey = pStmt.getGeneratedKeys(); 
				if(rsKey.next()) {
					c.setNoCategorie(rsKey.getInt(1));	
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException("Insert Categorie FAIL", e);
		}
	}
		
	
	//Select By ID
	@Override	
	public Categorie selectById(int noCategorie) throws DALException {
		Categorie a = null;

		try(Connection conn = ConnectionProvider.getConnection()){
				PreparedStatement stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
				stmt.setInt(1, noCategorie);
				ResultSet rs = stmt.executeQuery();
				if(rs.next()) {
					a = new Categorie(
								rs.getInt("no_categorie"),  
						        rs.getString("libelle")
						        );
				}
		
	} catch (SQLException e) {
		throw new DALException("SelectById Categorie FAIL - ", e);
	}
	return a;
}
	
	//Select All
	@Override
	public List<Categorie> selectAll() throws DALException{
		List<Categorie> retraits = new ArrayList<Categorie>();
		
		try (Connection connection = ConnectionProvider.getConnection()){ 
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(SQL_SELECT_ALL);
			while(rs.next()) {
				Categorie categorie = new Categorie(
						rs.getInt("no_categorie"),  
				        rs.getString("libelle")
				        );
				retraits.add(categorie);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException("SelectAll Categorie FAIL", e);
		}
		return retraits;
	}
	//Update
	@Override
	public void update(Categorie c) throws DALException {
		try(Connection conn = ConnectionProvider.getConnection()){
			PreparedStatement pStmt = conn.prepareStatement(SQL_UPDATE);
				
			pStmt.setString(1, c.getLibelle());
			pStmt.setInt(2, c.getNoCategorie());
			
			pStmt.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
			throw new DALException("Update Categorie FAIL", e);
		}
	}	
	
	//Delete
	
	@Override
	public void delete(int noCategorie) throws DALException {
		try (Connection connection = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = connection.prepareStatement(SQL_DELETE);
			stmt.setInt(1,noCategorie);
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new DALException("Delete Categorie FAIL - ", e);
		}
	}
	
}
