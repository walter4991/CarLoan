package business.entity;

import java.util.Date;

/**
 * Classe che rappresenta l'oggetto di business "Vettura" 
 * @author Sergio
 *
 */
public class Vettura extends BusinessObject {

	private String targa;
	private String marca;
	private String modello;
	private String cilindrata;
	private String cambio;
	private int ac;
	private int posti;
	private Date dataImm;
	private Date scadAssicur;
	private String alimentazione;
	private String stato;
	private int km;
	
	/**
	 * Costruisce una nuova "Vettura" che sarà possibile noleggiare
	 * @param targa stringa alfanumerica di 7 caratteri che identifica in modo univoco la vettura
	 * @param marca indica la marca della vettura ad esempio fiat, ford, ecc.
	 * @param modello indica il modello della vettura ad esempio punto, fiesta, ecc.
	 * @param cilindrata indica la cilindrata della vettura
	 * @param cambio indica il tipo di cambio della vettura 
	 * @param ac indica se la vettura possiede l'aria condizionata
	 * @param posti numero di posti della vettura
	 * @param dataImm data di immatricolazione della vettura
	 * @param scadAssicur scadenza dell'assicurazione della vettura
	 * @param alimentazione tipo di alimentazione della vettura
	 * @param stato indica lo stato della vettura ovvero: disponibile, noleggiata, in manutenzione
	 * @param km i chilometri che la vettura possiede in quel momento
	 */
	public Vettura(String targa, String marca, String modello, String cilindrata, String cambio, int ac, int posti, Date dataImm, Date scadAssicur, String alimentazione, String stato, int km) {
		this.targa = targa;
		this.marca = marca;
		this.modello = modello;
		this.cilindrata = cilindrata;
		this.cambio = cambio;
		this.ac = ac;
		this.posti = posti;
		this.dataImm = dataImm;
		this.scadAssicur = scadAssicur;
		this.alimentazione = alimentazione;
		this.stato = stato;
		this.km = km;
	}

	/**
	 * restituisce la targa univoca della vettura
	 * @return
	 * 		la targa della vettura	
	 */
	public String getTarga() {
		return targa;
	}

	/**
	 * setta la targa univoca della vettura
	 * @param targa
	 * 			la targa della vettura
	 */
	public void setTarga(String targa) {
		this.targa = targa;
	}

	/**
	 * restituisce la marca della vettura
	 * @return
	 * 		la targa della vettura
	 */
	public String getMarca() {
		return marca;
	}

	/**
	 * setta la targa della vettura
	 * @param marca
	 * 		la marca della vettura
	 */
	public void setMarca(String marca) {
		this.marca = marca;
	}

	/**
	 * restituisce il modello della vettura
	 * @return
	 * 		il modello della vettura
	 */
	public String getModello() {
		return modello;
	}

	/**
	 * setta il modello della vettura 
	 * @param modello
	 * 			il modello della vettura
	 */
	public void setModello(String modello) {
		this.modello = modello;
	}

	/**
	 * restituisce la cilindrata che la vettura possiede
	 * @return
	 * 		la cilindrata della vettura
	 */
	public String getCilindrata() {
		return cilindrata;
	}

	/**
	 * setta  la cilindrata ad una vettura
	 * @param cilindrata
	 * 		la cilindrata della vettura
	 */
	public void setCilindrata(String cilindrata) {
		this.cilindrata = cilindrata;
	}

	/**
	 * restituisce il tipo di cambio della vettura
	 * @return
	 * 		il tipo di cambio della vettura
	 */
	public String getCambio() {
		return cambio;
	}

	/**
	 * setta il tipo di cambio ad una vettura
	 * @param cambio
	 * 		il cambio della vettura
	 */
	public void setCambio(String cambio) {
		this.cambio = cambio;
	}

	/**
	 * restituisce se l'autovettura possiede l'aria condizionata o meno
	 * @return
	 * 		SI se l'aria condizionata è presente
	 * 		NO altrimenti
	 */
	public int getAc() {
		return ac;
	}

	/**
	 * inserisce la presenza o meno dell'aria condizionata nella vettura
	 * @param ac
	 * 		SI se l'aria condizionata è presente
	 * 		NO altrimenti
	 */
	public void setAc(int ac) {
		this.ac = ac;
	}

	/**
	 * restituisce il numero di posti di un autovettura
	 * @return
	 * 		il numero di posti
	 */
	public int getPosti() {
		return posti;
	}

	/**
	 * setta il numero di posti in un autovettura 
	 * @param posti
	 * 		il numero di posti
	 */
	public void setPosti(int posti) {
		this.posti = posti;
	}

	/**
	 * restituisce la data di prima immatricolazione della vettura
	 * @return
	 * 		la data di immatricolazione
	 */
	public Date getDataImm() {
		return dataImm;
	}

	/**
	 * setta la data di prima immatricolazione della vettura
	 * @param dataImm
	 * 		la data di immatricolazione
	 */
	public void setDataImm(Date dataImm) {
		this.dataImm = dataImm;
	}

	/**
	 * restituisce la data di scadenza dell'assicurazione della vettura
	 * @return
	 * 		la data di scadenza assicurazione
	 */
	public Date getScadAssicur() {
		return scadAssicur;
	}

	/**
	 * setta la data di scadenza dell'assicurazione della vettura
	 * @param scadAssicur
	 * 		la data di scadenza assicurazione
	 */
	public void setScadAssicur(Date scadAssicur) {
		this.scadAssicur = scadAssicur;
	}

	/**
	 * restituisce il tipo di alimentazione della vettura secondo lo standard europeo
	 * @return
	 * 		il tipo di alimentazione
	 */
	public String getAlimentazione() {
		return alimentazione;
	}

	/**
	 * setta il tipo di alimentazione della vettura secondo lo standard europeo
	 * @param alimentazione
	 * 		il tipo di alimentazione
	 */
	public void setAlimentazione(String alimentazione) {
		this.alimentazione = alimentazione;
	}

	/**
	 * restituisce lo stato in cui si trova la vettura ovvero: disponibile, noleggiata, in manutenzione
	 * @return
	 * 		lo stato della vettura
	 */	
	public String getStato() {
		return stato;
	}

	/**
	 * setta lo stato della vettura ovvero: disponibile, noleggiata, in manutenzione
	 * @param stato
	 * 		lo stato della vettura
	 */
	public void setStato(String stato) {
		this.stato = stato;
	}

	/**
	 * restituisce i chilometri percorsi dalla vettura
	 * @return
	 * 		i chilometri della vettura
	 */
	public int getKm() {
		return km;
	}

	/**
	 * setta i chilometri della vettura
	 * @param km
	 * 		i chilometri della vettura
	 */
	public void setKm(int km) {
		this.km = km;
	}
}
