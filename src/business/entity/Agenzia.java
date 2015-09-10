package business.entity;
/** 
 * Classe che rappresenta l' oggetto di business "Agenzia" 
 * 
 */
public class Agenzia extends BusinessObject{

	private int codAgenzia;
	private String nome;
	private String indirizzo;
	private String citta;
	private String pIva;
	private String email;
	private String telefono;
	/**
	 * Costruttore di una nuova agenzia
	 * 
	 * @param codAgenzia intero indicante il codice univoco dell'agenzia
	 * @param nome stringa indicante il nome univoco dell'agenzia 
	 * @param indirizzo stringa indicante l'indirizzo della sede
	 * @param citta stringa indicante la citta della sede
	 * @param pIva stringa che indica la Partita Iva (univoca)
	 * @param email stringa che contiene l'e-mail
	 * @param telefono stringa che contiene il numero di telefono
	 */
	public Agenzia(int codAgenzia, String nome, String indirizzo, String citta, String pIva, String email, String telefono) {
		this.codAgenzia = codAgenzia;
		this.nome = nome;
		this.indirizzo = indirizzo;
		this.citta = citta;
		this.pIva = pIva;
		this.email = email;
		this.telefono = telefono;
	}
/**
 * Codice dell' agenzia
 * 
 * @return CodAgenzia
 */
	public String getCodAgenzia() {
		
		return String.valueOf(codAgenzia);
	}
/**
 * Setta il codice dell'agenzia
 * 
 * @param codAgenzia di un' agenzia 
 */
	public void setCodAgenzia(int codAgenzia) {
		this.codAgenzia = codAgenzia;
	}
/**
 * Codice dell'agenzia
 * @return nome dell'agenzia
 */
	public String getNome() {
		return nome;
	}
/**
 * Setta il nome di un' agenzia
 * 
 * @param nome
 */
	public void setNome(String nome) {
		this.nome = nome;
	}
/**
 * Indirizzo di un' agenzia
 * 
 * @return indirizzo  di un' agenzia
 */
	public String getIndirizzo() {
		return indirizzo;
	}
/**
 * 
 * 
 * @param indirizzo di un' agenzia
 */
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	/**
	 * La citta' di un' agenzia
	 * @return citta' di un' agenzia
	 */
	public String getCitta() {
		return citta;
	}
	/**
	 * Setta la citta' di un agenzia
	 * @param citta
	 */

	public void setCitta(String citta) {
		this.citta = citta;
	}
/**
 * La partita di un' agenzia
 * @return la partita iva di un' agenzia
 */
	public String getpIva() {
		return pIva;
	}
/**
 * Setta la partita iva di un'agenzia 
 * 
 * @param pIva- partita iva di un' agenzia
 */
	public void setpIva(String pIva) {
		this.pIva = pIva;
	}
/**
 *  l' e-email di un'agenzia
 * @return l' e-email di un'agenzia
 */
	public String getEmail() {
		return email;
	}
	/**
	 * Setta l'e-mail di un'agenzia
	 * 
	 * @param email- l'email di un' agenzia, una stringa alfanumerica di massimo 30 caratteri.
	 */

	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * Il numero telefono di un'agenzia
	 * @return telefono- il numero telefono di un'agenzia
	 */

	public String getTelefono() {
		return telefono;
	}
/**
 * Setta il numero telefono di un'agenzia
 * @param telefono- il numero telefono di un'agenzia di 10 caratteri */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
}
