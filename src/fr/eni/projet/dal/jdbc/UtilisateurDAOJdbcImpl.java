package fr.eni.projet.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.projet.bo.Utilisateur;
import fr.eni.projet.dal.ConnectionProvider;
import fr.eni.projet.dal.UtilisateurDAO;

public class UtilisateurDAOJdbcImpl implements UtilisateurDAO {
	
	private final String INSERT = "INSERT INTO utilisateurs (pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
	private final String SELECT_ALL = "SELECT no_utilisateur pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur from utilisateurs;";
	private final String SELECT_BY_ID = "SELECT no_utilisateur pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur from utilisateurs where pseudo=?;";
	@Override
	public void insert(Utilisateur utilisateur) {
		Utilisateur u = null;
		PreparedStatement req = null;
		ResultSet rs = null;
		
		try(Connection connection = ConnectionProvider.getConnection()) {
			req = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
			req.setString(1, utilisateur.getPseudo());
			req.setString(2, utilisateur.getNom());
			req.setString(3, utilisateur.getPrenom());
			req.setString(4, utilisateur.getEmail());
			req.setString(5, utilisateur.getTelephone());
			req.setString(6, utilisateur.getRue());
			req.setString(7, utilisateur.getCodePostal());
			req.setString(8, utilisateur.getVille());
			req.setString(9, utilisateur.getMotDePasse());
			req.setFloat(10, utilisateur.getCredit());
			req.setBoolean(11, utilisateur.isAdministrateur());
			
			int nbLignes = req.executeUpdate();
			if (nbLignes == 1) {
				rs = req.getGeneratedKeys();
				if (rs.next()) {
					utilisateur.setNoUtilisateur(rs.getInt(1));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
//			BusinessException.addCodeErreur(DALJdbcCodeError.DAL_REPAS_INSERT_ERROR);
//			throw new BusinessException();
		} finally{
			try {
				if(req != null) {
					req.close();
				}
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public List<Utilisateur> selectAll(){
		List<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();
		
		try ( Connection connection = ConnectionProvider.getConnection()){
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(SELECT_ALL);
			while(rs.next()) {
				Utilisateur utilisateur = new Utilisateur(rs.getInt("no_utilisateur"), rs.getString("pseudo"), 
						rs.getString("nom"), rs.getString("prenom"), rs.getNString("email"),rs.getString("telephone"),
						rs.getString("rue"),rs.getString("code_postal"),rs.getString("ville"),rs.getString("mot_de_passe"),
						rs.getFloat("credit"),rs.getBoolean("administrateur"));
				utilisateurs.add(utilisateur);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return utilisateurs;
		
	}
	
	public Utilisateur selectById(String identifiant, String motDePasse) {
		Utilisateur utilisateur = null;
		try (Connection connection = ConnectionProvider.getConnection()){
		PreparedStatement pstmt = connection.prepareStatement(SELECT_BY_ID);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
		utilisateur = new Utilisateur(rs.getInt("no_utilisateur"), rs.getString("pseudo"), 
					rs.getString("nom"), rs.getString("prenom"), rs.getNString("email"),rs.getString("telephone"),
					rs.getString("rue"),rs.getString("code_postal"),rs.getString("ville"),rs.getString("mot_de_passe"),
					rs.getFloat("credit"),rs.getBoolean("administrateur"));
		}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return utilisateur;
		
	}
	
	
}
