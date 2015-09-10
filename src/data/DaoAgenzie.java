package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import presentation.controller.ApplicationController;
import business.entity.Agenzia;
import business.entity.Cliente;

/**
 * Classe che permette di manipolare i dati delle Agenzie
 * @author Sergio
 *
 */
public class DaoAgenzie extends DaoService {
	private final String QUERY_RICERCA_COD = "SELECT codAgenzia, nome, indirizzo,citta, pIva, email, telefono FROM Agenzie   WHERE codAgenzia=? ;";

	private final String AGENZIE = "SELECT DISTINCT nome FROM CarLoan.Agenzie; ";

	public DaoAgenzie() {
		super();
	}

	/**
	 * Permette di leggere i dati relativi alle Agenzia
	 * @return
	 * 		la lista delle Agenzie
	 * @throws SQLException
	 * 			se la connesione non è presente
	 */
	public ArrayList<String> tutteAgenzie() throws SQLException {
		PreparedStatement agenzie = null;
		ArrayList<String> agenzieList = new ArrayList<String>();
		agenzie = connessione.prepareStatement(AGENZIE);

		ResultSet risultati = agenzie.executeQuery();

		while (risultati.next()) {
			agenzieList.add(risultati.getString("nome"));
		}
		return agenzieList;
	}
	
	
	

	/**
	 * Permette di leggere i dati di un'agenzia mediante il codice e crea un oggetto di tipo Agenzia
	 * @return
	 * 		il risultato della ricerca
	 */
	public boolean cercaCod() {

		int codice = 1;
		String nome = "";
		String indirizzo = "";
		String citta = "";
		String pIva = "";
		String email = "";
		String telefono = "";
		
		
	 
		boolean trovato = false;

		PreparedStatement ricercaCod = null;

		try {
			ricercaCod = connessione.prepareStatement(QUERY_RICERCA_COD);
			ricercaCod.setString(1,
					(String) ApplicationController.params.get("codFis"));
			ResultSet resultsRicercaCod = ricercaCod.executeQuery();

			if (resultsRicercaCod.next()) {
			 	codice = resultsRicercaCod.getInt("CodAgenzia");
				
				nome = resultsRicercaCod.getString("nome");
				
				indirizzo = resultsRicercaCod.getString("indirizzo");
				citta = resultsRicercaCod.getString("citta");
				pIva = resultsRicercaCod.getString("pIva");
				email = resultsRicercaCod.getString("email");
				telefono = resultsRicercaCod.getString("telefono");
				trovato = true;
			}

			Agenzia agenzia = new Agenzia(codice, nome, indirizzo,citta, pIva, email, telefono);
			ApplicationController.params.put("agenzia", agenzia);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return trovato;
	}
}
