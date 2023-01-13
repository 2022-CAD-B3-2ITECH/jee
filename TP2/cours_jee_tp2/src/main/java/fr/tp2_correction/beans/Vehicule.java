package fr.tp2_correction.beans;
import java.util.Random;

public class Vehicule {
	
	protected String nom;
	protected int vitesse = new Random().nextInt((180 - 30) + 30);
	protected boolean recoitAmende = false;
	
	public Vehicule(String nom) {
		super();
		this.nom = nom;
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getVitesse() {
		return vitesse;
	}
	public void setVitesse(int vitesse) {
		this.vitesse = vitesse;
	}

	public boolean isRecoitAmende() {
		return recoitAmende;
	}

	public void setRecoitAmende(boolean recoitAmende) {
		this.recoitAmende = recoitAmende;
	}
	
	

}
