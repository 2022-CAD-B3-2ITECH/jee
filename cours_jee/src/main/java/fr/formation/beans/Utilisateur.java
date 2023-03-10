package fr.formation.beans;

public class Utilisateur {
	
	private int id;
	private String nom;
	private String prenom;
	
	public Utilisateur(int id, String nom, String prenom) throws BeanException {
		super();
		this.id = id;
		this.setNom(nom);
		this.prenom = prenom;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) throws BeanException {
		
		if(nom.length() < 3 || nom.length() > 20) {
			throw new BeanException("Le nom doit être compris entre 3 et 20 caractères.");
		}else {
			this.nom = nom;
		}
		
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

}
