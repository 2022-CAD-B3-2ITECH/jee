package fr.tp1correction.beans;

public class Chat {
	
	private String nom;
	private String img;
	private boolean estSortable;
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public boolean isEstSortable() {
		return estSortable;
	}
	public void setEstSortable(boolean estSortable) {
		this.estSortable = estSortable;
	}

}