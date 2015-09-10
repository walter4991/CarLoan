package business.entity;

/**
 * Classe che rappresenta l'utente che si registra ed esegue il login al sistema. Esso potrà essere 
 * un cliente o un amministratore
 * @author Sergio
 *
 */
public  class Utente extends BusinessObject {
	

	private String username;
	private String password;
	private String nome;
	private String cognome;
	
	public Utente() {
	
	}

	/**
	 * Costruisce un nuovo utente parzialmente
	 * @param username stringa sceta dall'utente, deve essere univoca
	 * @param password stringa scelta dall'utente per accedere al sistema
	 * @param nome rappresenta il nome dell'utente
	 * @param cognome rappresenta il cognome dell'utente
	 */
	public Utente(String username, String password, String nome, String cognome) {
		this.username = username;
		this.password = password;
		this.nome = nome;
		this.cognome = cognome;
	}
	
	/**
	 * restituisce nome utente scelto al momento della registrazione
	 * @return
	 * 		il nome utente scelto
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * setta il nome utente al momento della registrazione
	 * @param username
	 * 		il nome utente scelto
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * restituisce la password scelta dall'utente
	 * @return
	 * 		la password dell'utente
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * setta la password dell'utente al momento della registrazione
	 * @param password
	 * 		la password dell'utente
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * restituisce il nome dell'utente
	 * @return
	 * 		il nome dell'utente
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * setta il nome dell'utente
	 * @param nome
	 * 		il nome dell'utente
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * restituisce il cognome dell'utente
	 * @return
	 * 		il cognome dell'utente
	 */
	public String getCognome() {
		return cognome;
	}

	/**
	 * setta il cognome dell'utente
	 * @param cognome
	 * 		il cognome dell'utente
	 */
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}	
}
