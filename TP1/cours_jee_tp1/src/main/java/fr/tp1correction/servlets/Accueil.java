package fr.tp1correction.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import fr.tp1correction.beans.Chat;

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
		
		Chat felix = new Chat();
		Chat willow = new Chat();
		Chat alba = new Chat();
		
		felix.setNom("Félix");
		felix.setImg("https://cdn.pixabay.com/photo/2017/07/25/01/22/cat-2536662_960_720.jpg");
		felix.setEstSortable(false);
		
		willow.setNom("Willow");
		willow.setImg("https://cdn.pixabay.com/photo/2015/03/27/13/16/maine-coon-694730_960_720.jpg");
		willow.setEstSortable(true);
		
		alba.setNom("Alba");
		alba.setImg("https://cdn.pixabay.com/photo/2017/02/20/18/03/cat-2083492_960_720.jpg");
		alba.setEstSortable(false);
		
		request.setAttribute("felix", felix);
		request.setAttribute("willow", willow);
		request.setAttribute("alba", alba);
		
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
