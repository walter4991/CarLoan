package business.entity;

/**
 * Classe che rappresenta l'ogetto di business fascia, ovvero la fascia a cui appartiene un automobile
 * secondo gli standard europei
 * @author Sergio
 *
 */
public class Fascia extends BusinessObject {

	private char codFascia;
	private String porte;
	private String dimensioni;
	private float tariffaBase;
	private int etaMinima;
	
	/**
	 * Costruisce una nuova "Fascia" di automobili
	 * @param codFascia stringa che identifica la fascia in modo univoco
	 * @param porte numero di porte k sono presenti nell'autovettura
	 * @param dimensioni indicano le dimensioni dell'autovettura secondo gli standard europei
	 * @param tariffaBase rappresenta la tariffa minima della fascia
	 * @param etaMinima indica l'et&agrave; minima con la quale è possibile noleggiare quella fascia
	 */
	public Fascia(char codFascia, String porte, String dimensioni, float tariffaBase, int etaMinima) {
		this.codFascia = codFascia;
		this.porte = porte;
		this.dimensioni = dimensioni;
		this.tariffaBase = tariffaBase;
		this.etaMinima = etaMinima;
	}

	/**
	 * restituisce il codice univo della fascia
	 * @return
	 * 		il codice della fascia
	 */		
	public char getCodFascia() {
		return codFascia;
	}

	/**
	 * setta il codice univoco della fascia
	 * @param codFascia
	 * 			il codice della fascia
	 */
	public void setCodFascia(char codFascia) {
		this.codFascia = codFascia;
	}

	/**
	 * restituisce il numero di porte dell'autovettura
	 * @return
	 * 		il numero di porte
	 */
	public String getPorte() {
		return porte;
	}

	/**
	 * setta il numero di porte presenti in un autovettura
	 * @param porte
	 * 			il numero di porte
	 */
	public void setPorte(String porte) {
		this.porte = porte;
	}

	/**
	 * restituisce le dimensioni della vettura
	 * @return
	 * 		le dimensioni della vettura
	 */	
	public String getDimensioni() {
		return dimensioni;
	}

	/**
	 * setta le dimensioni della vettura
	 * @param dimensioni
	 * 			le dimensioni della vettura
	 */
	public void setDimensioni(String dimensioni) {
		this.dimensioni = dimensioni;
	}

	/**
	 * restituisce la tariffa base della fascia
	 * @return
	 * 		la tariffa base della fascia
	 */	
	public float getTariffaBase() {
		return tariffaBase;
	}

	/**
	 * setta la tariffa base della fascia
	 * @param tariffaBase
	 * 			la tariffa base della fascia
	 */
	public void setTariffaBase(float tariffaBase) {
		this.tariffaBase = tariffaBase;
	}

	/**
	 * restituisce l'et&agrave; minima per noleggiare una determinata fascia
	 * @return
	 * 		l'et&agrave; minima 
	 */
	public int getEtaMinima() {
		return etaMinima;
	}

	/**
	 * setta l'et&agrave; minima per noleggiare una determinata fascia
	 * @param etaMinima
	 * 			l'et&agrave; minima 
	 */
	public void setEtaMinima(int etaMinima) {
		this.etaMinima = etaMinima;
	}
}
