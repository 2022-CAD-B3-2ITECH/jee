package fr.formation.forms;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import jakarta.servlet.http.Part;

public class UploadForm {
	
	public static final int TAILLE_TAMPON = 10240;
	public static final String CHEMIN_FICHIERS = "/DevFormation/Logiciels/Eclipse/eclipse-workspace/cours_jee_restart/src/main/webapp/assets/"; // A
																																		// changer
	// Upload un fichier passé en paramètre et renvoi son nom (ou un message d'échec)
	public String uploadFile(Part part) {

		// On vérifie qu'on a bien reçu un fichier
		String nomFichier = getNomFichier(part);

		// Si on a bien un fichier
		if (nomFichier != null && !nomFichier.isEmpty()) {
			
			// On écrit définitivement le fichier sur le disque
			try {
				ecrireFichier(part, nomFichier, CHEMIN_FICHIERS);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return nomFichier;
			
		}
		
		return "upload échoué";
				
	}
	
	// Place le fichier dans le dossier
		private void ecrireFichier(Part part, String nomFichier, String chemin) throws IOException {
			BufferedInputStream entree = null;
			BufferedOutputStream sortie = null;
			try {
				entree = new BufferedInputStream(part.getInputStream(), TAILLE_TAMPON);
				sortie = new BufferedOutputStream(new FileOutputStream(new File(chemin + nomFichier)), TAILLE_TAMPON);

				byte[] tampon = new byte[TAILLE_TAMPON];
				int longueur;
				while ((longueur = entree.read(tampon)) > 0) {
					sortie.write(tampon, 0, longueur);
				}
			} finally {
				try {
					sortie.close();
				} catch (IOException ignore) {
				}
				try {
					entree.close();
				} catch (IOException ignore) {
				}
			}
		}

		// Nettoie le nom du fichier en cas d'accent, d'espaces, etc
		private static String getNomFichier(Part part) {
			for (String contentDisposition : part.getHeader("content-disposition").split(";")) {
				if (contentDisposition.trim().startsWith("filename")) {
					return contentDisposition.substring(contentDisposition.indexOf('=') + 1).trim().replace("\"", "");
				}
			}
			return null;
		}

}
