package fr.eni.projet.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import fr.eni.projet.bo.Retrait;
import fr.eni.projet.dal.ConnectionProvider;
import fr.eni.projet.dal.DALException;
import fr.eni.projet.dal.RetraitDAO;

public class RetraitDAOJdbcImpl implements RetraitDAO {
	
	
	private static final String SQL_INSERT = "INSERT INTO RETRAITS (no_article, rue, code_postal, ville) VALUES (?,?,?,?);";
	private static final String SQL_SELECT_BY_ID = "SELECT no_article, rue, code_postal, ville FROM RETRAITS WHERE no_article = ?;";
	private static final String SQL_SELECT_ALL = "SELECT no_article, rue, code_postal, ville FROM RETRAITS;";
	private static final String SQL_UPDATE = "UPDATE RETRAITS SET rue=?,code_postal=?,ville=? WHERE no_article = ?;";
	private static final String SQL_DELETE = "DELETE  FROM  RETRAITS WHERE no_article = ?";

	
	//Insert
	@Override
	public void insert(Retrait r) throws DALException {
		//1- Obtenir une connexion à la base de données
		
		try(Connection conn = ConnectionProvider.getConnection()) {
			
			//2 - Préparer la requete SQL (insert...)
			PreparedStatement pStmt = conn.prepareStatement(SQL_INSERT);
			pStmt.setInt(1, r.getNoArticleRetrait());
			pStmt.setString(2, r.getRue());
			pStmt.setString(3, r.getCodePostal());
			pStmt.setString(4, r.getVille());
		
			//3 - Executer la requete
			pStmt.executeUpdate();
				
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException("Insert Retrait FAIL", e);
		}
	}
	
	//Select By ID
	@Override	
	public Retrait selectById(int noArticleRetrait) throws DALException {
		Retrait a = null;

		try(Connection conn = ConnectionProvider.getConnection()){
				PreparedStatement stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
				stmt.setInt(1, noArticleRetrait);
				ResultSet rs = stmt.executeQuery();
				if(rs.next()) {
					a = new Retrait(
								rs.getInt("no_article"),  
						        rs.getString("rue"),
						        rs.getString("code_postal"),
						        rs.getString("ville")
						        );
				}
		
	} catch (SQLException e) {
		throw new DALException("SelectById Retrait FAIL - ", e);
	}
	return a;
}
	
	//Select All
	@Override
	public List<Retrait> selectAll() throws DALException{
		List<Retrait> retraits = new ArrayList<Retrait>();
		
		try (Connection connection = ConnectionProvider.getConnection()){ 
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(SQL_SELECT_ALL);
			while(rs.next()) {
				Retrait retrait = new Retrait(
						rs.getInt("no_article"),  
				        rs.getString("rue"),
				        rs.getString("code_postal"),
				        rs.getString("ville")
				        );
				retraits.add(retrait);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException("SelectAll Retrait FAIL", e);
		}
		return retraits;
	}
	//Update
	@Override
	public void update(Retrait r) throws DALException {
		try(Connection conn = ConnectionProvider.getConnection()){
			PreparedStatement pStmt = conn.prepareStatement(SQL_UPDATE);
				
			pStmt.setString(1, r.getRue());
			pStmt.setString(2, r.getCodePostal());
			pStmt.setString(3, r.getVille());
			pStmt.setInt(4, r.getNoArticleRetrait());
			
			pStmt.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
			throw new DALException("Update Retrait FAIL", e);
		}
	}	
	
	
	//Delete
	
	@Override
	public void delete(int noArticleRetrait) throws DALException {
		try (Connection connection = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = connection.prepareStatement(SQL_DELETE);
			stmt.setInt(1,noArticleRetrait);
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new DALException("Delete Retrait FAIL - ", e);
		}
	}
}
