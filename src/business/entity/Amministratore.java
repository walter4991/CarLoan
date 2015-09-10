package business.entity;

/**
 * Classe che rappresenta l'amministratore e gestisce l'intero sistema
 * 
 * @author Sergio
 *
 */
public class Amministratore extends Utente {

	public Amministratore(String username, String password, String nome, String cognome) {
		super(username, password, nome, cognome);
	}
}
