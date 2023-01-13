package fr.tp2_correction.beans;

public class Voiture extends Vehicule {
	
	private int nbPassagers;
	private boolean ceintureAttachee;
	
	public Voiture(String nom, int nbPassagers, boolean ceintureAttachee) {
		super(nom);
		this.nbPassagers = nbPassagers;
		this.ceintureAttachee = ceintureAttachee;
	}
	public int getNbPassagers() {
		return nbPassagers;
	}
	public void setNbPassagers(int nbPassagers) {
		this.nbPassagers = nbPassagers;
	}
	public boolean isCeintureAttachee() {
		return ceintureAttachee;
	}
	public void setCeintureAttachee(boolean ceintureAttachee) {
		this.ceintureAttachee = ceintureAttachee;
	}

}