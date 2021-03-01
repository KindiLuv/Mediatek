package com.paydiluv.JakartaProject.persistant;

import java.util.List;

import mediatek2021.*;

// classe mono-instance : l'unique instance est connue de la bibliotheque
// via une injection de d�pendance dans son bloc static

public class MediatekData implements PersistentMediatek {
// Jean-Fran�ois Brette 01/01/2018
	static {
		// injection dynamique de la d�pendance dans le package stable mediatek2021
		Mediatek.getInstance().setData(new MediatekData());
	}

	private MediatekData() {
	}

	// renvoie la liste de tous les documents de la biblioth�que
	@Override
	public List<Document> catalogue(int type) {
		return null;
	}

	// va r�cup�rer le User dans la BD et le renvoie
	// si pas trouv�, renvoie null
	@Override
	public Utilisateur getUser(String login, String password) {
		return null;
	}

	// va r�cup�rer le document de num�ro numDocument dans la BD
	// et le renvoie
	// si pas trouv�, renvoie null
	@Override
	public Document getDocument(int numDocument) {
		return null;
	}

	// ajoute un nouveau document - exception � d�finir
	@Override
	public void newDocument(int type, Object... args) throws NewDocException {
		// args[0] -> le titre
		//		// args [1] --> l'auteur
		//		// etc en fonction du type et des infos optionnelles
	}

	// supprime un document - exception � d�finir
	@Override
	public void suppressDoc(int numDoc) throws SuppressException {
		
	}

}
