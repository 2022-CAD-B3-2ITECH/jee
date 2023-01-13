package fr.formation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.formation.beans.BeanException;
import fr.formation.beans.Utilisateur;

public class UtilisateurDaoImpl implements UtilisateurDao {

	private DaoFactory daoFactory;

	UtilisateurDaoImpl(DaoFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void ajouter(Utilisateur utilisateur) {

		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		
		try {
			
			connexion = daoFactory.getConnection();

			preparedStatement = connexion.prepareStatement("INSERT INTO utilisateur(nom,prenom) VALUES(?,?);");

			preparedStatement.setString(1, utilisateur.getNom());
			preparedStatement.setString(2, utilisateur.getPrenom());

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Utilisateur> lister() {

		List<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();

		Statement statement = null;
		ResultSet resultat = null;
		Connection connexion = null;

		try {
			connexion = daoFactory.getConnection();
			statement = connexion.createStatement();

			// Exécution de la requête SQL
			resultat = statement.executeQuery("SELECT * FROM utilisateur;");

			// Récupération des données
			while (resultat.next()) {

				int id = resultat.getInt("id");
				String nom = resultat.getString("nom");
				String prenom = resultat.getString("prenom");

				Utilisateur utilisateur = new Utilisateur(id, nom, prenom);
				utilisateurs.add(utilisateur);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}catch(BeanException e) {
			e.printStackTrace();
		}

		// je retourne mes utilisateurs
		return utilisateurs;

	}

}