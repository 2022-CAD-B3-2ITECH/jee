package fr.formation.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.util.List;

import fr.formation.beans.BeanException;
import fr.formation.beans.Utilisateur;
import fr.formation.dao.DaoFactory;
import fr.formation.dao.UtilisateurDao;
import fr.formation.forms.ConnectionForm;
import fr.formation.forms.UploadForm;

/**
 * Servlet implementation class Accueil
 */
public class Accueil extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UtilisateurDao utilisateurDao;
	
	public void init() throws ServletException{
		DaoFactory daoFactory = DaoFactory.getInstance();
		this.utilisateurDao = daoFactory.getUtilisateurDao();
	}
       
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
		
		// Récupérer la liste des utilisateurs
		List<Utilisateur> utilisateurs = utilisateurDao.lister();
		
		// Passer la liste à la JSP
		request.setAttribute("utilisateurs", utilisateurs);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/accueil.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Utilisateur utilisateur;
		try {
			
			utilisateur = new Utilisateur(0,request.getParameter("nom"),request.getParameter("prenom"));
			utilisateurDao.ajouter(utilisateur);
			response.sendRedirect("/cours_jee_restart");
			
		} catch (BeanException e) {
			
			request.setAttribute("erreur", e.getMessage());
			this.getServletContext().getRequestDispatcher("/WEB-INF/accueil.jsp").forward(request, response);
			
		}
	
	}

}
