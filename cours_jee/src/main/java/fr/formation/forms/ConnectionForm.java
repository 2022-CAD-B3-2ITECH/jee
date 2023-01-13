package fr.formation.forms;

import jakarta.servlet.http.HttpServletRequest;

public class ConnectionForm {
	
	private String resultat;
	
	public void verifierIdentifiants(HttpServletRequest request) {
		
		String login = request.getParameter("login");
		String pass = request.getParameter("password");
		
		if(pass.equals(login + "123")) {
			
			this.resultat = "Vous êtes bien connecté";
			
		}else {
			
			this.resultat = "Identifiants incorrects";
			
		}
		
	}

	public String getResultat() {
		return resultat;
	}

	public void setResultat(String resultat) {
		this.resultat = resultat;
	}

}