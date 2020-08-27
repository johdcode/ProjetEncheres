package fr.eni.projet.exception;

import java.util.ArrayList;

public class BusinessException extends Exception{

	private static final long serialVersionUID = 1L;
	
	private static ArrayList<String> listeMessageException = new ArrayList<>();
	
	public static void reset() {
		listeMessageException.clear();
	}
	public static void addMessageErreur(String message) {
		if(! listeMessageException.contains(message)) {			
			listeMessageException.add(message);
		}
	}
	
	public static boolean hasMessageErreur() {
		return listeMessageException.size() > 0;
	}
	
	public static ArrayList<String> getListeMessageException(){
		return (ArrayList<String>) listeMessageException.clone();
	}
}
