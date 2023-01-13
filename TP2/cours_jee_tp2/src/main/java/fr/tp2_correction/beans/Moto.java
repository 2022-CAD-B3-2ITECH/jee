package fr.tp2_correction.beans;

public class Moto extends Vehicule {
	
	private boolean porteCasque;

	public Moto(String nom, boolean porteCasque) {
		super(nom);
		this.porteCasque = porteCasque;
	}

	public boolean isPorteCasque() {
		return porteCasque;
	}

	public void setPorteCasque(boolean porteCasque) {
		this.porteCasque = porteCasque;
	}
	
	

}
