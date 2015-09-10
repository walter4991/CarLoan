package business.entity;

/**
 * Classe che rappresenta l'oggetto di business "Prenotazione"
 * @author Sergio
 *
 */
public class Prenotazione extends BusinessObject{

	private int codPrenotaz;
	private float totale;
	private float acconto;
	private String dataInizioNol;
	private String dataFineNol;
	private String tipologiaNol;
	private String tipologiaKm;
	
	/**
	 * Costruisce una nuova "Prenotazione" se &egrave; stata richiesta da un cliente
	 * @param codPrenotaz numero autoincrementativo che identifica in modo univoco una prenotazione
	 * @param totale indica il totale da pagare secondo la prenotazione effettuata
	 * @param acconto indica l'acconto da versare per effettuare un contratto successivamente 
	 * @param dataInizioNol rappresenta la data di inizio del noleggio
	 * @param dataFineNol rappresenta la data di fine noleggio
	 * @param tipologiaNol indica la tipologia del noleggio se giornaliero o settimanale
	 * @param tipologiaKm indica la tipologia del noleggio in base ai chilometri se limitati o illimitati
	 */
	public Prenotazione(int codPrenotaz, float totale, float acconto, String dataInizioNol, String dataFineNol, String tipologiaNol, String tipologiaKm) {
		this.codPrenotaz = codPrenotaz;
		this.totale = totale;
		this.acconto = acconto;
		this.dataInizioNol = dataInizioNol;
		this.dataFineNol = dataFineNol;
		this.tipologiaNol = tipologiaNol;
		this.tipologiaKm = tipologiaKm;
	}

	/**
	 * restituisce il codice univoco della prenotazione
	 * @return
	 * 		il codice della prenotazione
	 */		
	public int getCodPrenotaz() {
		return codPrenotaz;
	}

	/**
	 * setta il codice univoco della prenotazione
	 * @param codPrenotaz
	 * 			il codice della prenotazione
	 */
	public void setCodPrenotaz(int codPrenotaz) {
		this.codPrenotaz = codPrenotaz;
	}

	/**
	 * restituisce il totale della prenotazione
	 * @return
	 * 		il totale della prenotazione
	 */
	public float getTotale() {
		return totale;
	}

	/**
	 * setta il valore in denaro a cui ammonta il totale della prenotazione
	 * 
	 * @param totale
	 * 		il totale della prenotazione
	 */
	public void setTotale(float totale) {
		this.totale = totale;
	}

	/**
	 * restituisce l'acconto da pagare alla prenotazione del noleggio
	 * @return
	 * 		l'acconto da pagare
	 */	
	public float getAcconto() {
		return acconto;
	}

	/**
	 * setta l'acconto da pagare alla prenotazione del noleggio
	 * @param acconto
	 * 		l'acconto da pagare
	 */
	public void setAcconto(float acconto) {
		this.acconto = acconto;
	}

	/**
	 * restituisce la data in cui il noleggio è iniziato
	 * @return
	 * 		la data di inizio noleggio
	 */
	public String getDataInizioNol() {
		return dataInizioNol;
	}

	/**
	 * setta la data in cui il noleggio è iniziato
	 * @param dataInizioNol
	 * 			la data di inizio noleggio
	 */
	public void setDataInizioNol(String dataInizioNol) {
		this.dataInizioNol = dataInizioNol;
	}

	/**
	 * restituisce la data in cui il noleggio è terminato o dovrebbe terminare
	 * @return
	 * 		la data di fine noleggio
	 */
	public String getDataFineNol() {
		return dataFineNol;
	}

	/**
	 * setta la data in cui il noleggio è terminato o dovrebbe terminare
	 * @param dataFineNol
	 * 			la data di fine noleggio
	 */
	public void setDataFineNol(String dataFineNol) {
		this.dataFineNol = dataFineNol;
	}

	/**
	 * restituisce la tipologia del noleggio ovvero giornaliero o settimanale
	 * @return
	 * 		la tipologia del noleggio
	 */
	public String getTipologiaNol() {
		return tipologiaNol;
	}

	/**
	 * setta la tipologia del noleggio secondo due valori possibili: giornaliero o settimanale
	 * @param tipologiaNol
	 * 			la tipologia del noleggio
	 */
	public void setTipologiaNol(String tipologiaNol) {
		this.tipologiaNol = tipologiaNol;
	}

	/**
	 * restituisce la tipologia del noleggio in base al chilometraggio limitato o illimitato
	 * @return
	 * 		la tipologia del chilometraggio 
	 */
	public String getTipologiaKm() {
		return tipologiaKm;
	}

	/**
	 * setta la tipologia del noleggio in base al chilometraggio secondo due valori possibili:
	 * limitato o illimitato
	 * @param tipologiaKm
	 * 		la tipologia del noleggio in base ai chilometri
	 */
	public void setTipologiaKm(String tipologiaKm) {
		this.tipologiaKm = tipologiaKm;
	}
}