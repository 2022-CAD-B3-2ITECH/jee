package fr.formation.dao;

import java.util.List;

import fr.formation.beans.Utilisateur;

public interface UtilisateurDao {
	
	void ajouter(Utilisateur utilisateur);
	List<Utilisateur> lister();

}