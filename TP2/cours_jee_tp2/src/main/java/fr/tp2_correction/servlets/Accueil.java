package fr.tp2_correction.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import fr.tp2_correction.beans.Moto;
import fr.tp2_correction.beans.Vehicule;
import fr.tp2_correction.beans.Voiture;

/**
 * Servlet implementation class Accueil
 */
public class Accueil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Accueil() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Voiture voiture = new Voiture("La routarde",5,false);
		Voiture voiture2 = new Voiture("La confortable",2,true);
		Voiture voiture3 = new Voiture("La citadine",1,true);
		Moto moto = new Moto("Le bolide",false);
		Moto moto2 = new Moto("La vieille",true);
		
		Vehicule vehicules[] = {voiture, voiture2, voiture3, moto, moto2};
		Voiture voitures[] = {voiture, voiture2, voiture3};
		Moto motos[] = {moto, moto2};
		
		request.setAttribute("vehicules", vehicules);
		request.setAttribute("voitures", voitures);
		request.setAttribute("motos", motos);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/accueil.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
