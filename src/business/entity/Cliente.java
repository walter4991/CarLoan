package business.entity;

/**
 * Classe che rappresenta il cliente ovvero colui che può effettuare le operazioni all'interno del sistema
 * 
 * @author Sergio
 *
 */
public class Cliente extends Utente{
	
	private String sesso;
	private String luogoNascita;
	private String dataNascita;
	private String codFisc;
	private String telefono;
	private String email;

	public Cliente() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * Costruisce un nuovo "Cliente";
	 * 
	 * @param username stringa indicante il nome scelto a piacere dal cliente, deve essere univoco
	 * @param password stringa scelta dal cliente per accedere al sistema
	 * @param nome indica il nome del del cliente
	 * @param cognome indica il cognome del cliente
	 * @param sesso indica il sesso del cliente
	 * @param luogoNascita rappresenta il luogo dove il cliente è nato
	 * @param dataNascita indica la data di nascita del cliente
	 * @param codFisc stringa alfanumerica di 16 caratteri che rappresenta il cliente in modo unico
	 * @param telefono numero di telefono del cliente
	 * @param email indirizzo di posta elettronica del cliente
	 */
	public Cliente(String username, String password, String nome, String cognome, String sesso, String luogoNascita, String dataNascita, String codFisc, String telefono, String email) {
		super(username, password, nome, cognome);
		this.sesso = sesso;
		this.luogoNascita = luogoNascita;
		this.dataNascita = dataNascita;
		this.codFisc = codFisc;
		this.telefono = telefono;
		this.email = email;
	}
	
	/**
	 * restituisce il sesso del cliente
	 * @return
	 * 		il sesso del cliente
	 */		
	public String getSesso() {
		return sesso;
	}

	/**
	 * Setta il sesso del cliente
	 * @param sesso
	 * 			il sesso del cliente
	 */
	public void setSesso(String sesso) {
		this.sesso = sesso;
	}

	/**
	 * Restituisce il luogo in cui un cliente è nato
	 * @return
	 * 		il luogo di nascita di un cliente
	 */
	public String getLuogoNascita() {
		return luogoNascita;
	}

	/**
	 * Setta il luogo in cui un cliente è nato
	 * @param luogoNascita
	 * 			il luogo di nascita del cliente
	 */
	public void setLuogoNascita(String luogoNascita) {
		this.luogoNascita = luogoNascita;
	}

	/**
	 * Restituisce la data di nascita del cliente
	 * @return
	 * 		la data di nascita del cliente
	 */
	public String getDataNascita() {
		return dataNascita;
	}

	/**
	 * Setta la data di nascita di un cliente
	 * @param dataNascita
	 * 			la data di nascita del cliente
	 */
	public void setDataNascita(String dataNascita) {
		this.dataNascita = dataNascita;
	}

	/**
	 * restituisce il codice fiscale del cliente
	 * @return
	 * 		il codice fiscale del cliente
	 */
	public String getCodFisc() {
		return codFisc;
	}

	/**
	 * setta il codice fiscale del cliente
	 * @param codFisc
	 * 			il codice fiscale del cliente
	 */
	public void setCodFisc(String codFisc) {
		this.codFisc = codFisc;
	}

	/**
	 * restituisce il numero di telefono del cliente
	 * @return
	 * 		il numero di telefono del cliente
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * setta il numero di telefono del cliente
	 * @param telefono
	 * 			il numero di telefono del cliente
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	/**
	 * restituisce l'indirizzo di posta elettronica del cliente
	 * @return
	 * 		l'indirizzo email del cliente
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * setta l'inidrizzo di posta elettronica del cliente
	 * @param email
	 * 			l'indirizzo email del cliente
	 */
	public void setEmail(String email) {
		this.email = email;
	}
}
