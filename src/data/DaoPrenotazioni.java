package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Classe che permette di manipolare i dati relativi alle prenotazioni
 * @author Sergio
 *
 */
public class DaoPrenotazioni extends DaoService {
	
	private final String QUERY_PRENOTAZIONE_ESISTENTE = "SELECT codPrenotaz FROM Prenotazioni WHERE codPrenotaz = ?;";

	/**
	 * Ricerca se una prenotazione è presente nel database
	 * @param codPrenotazione
	 * 		il codice da ricercare
	 * @return
	 * 		il risultato della ricerca
	 */
	public boolean controlloPrenotazioneEsistente(String codPrenotazione) {
		PreparedStatement query = null;
		boolean esistente = false;
		try {
			query = connessione.prepareStatement(QUERY_PRENOTAZIONE_ESISTENTE);

			query.setString(1, codPrenotazione);

			ResultSet results = query.executeQuery();

			if (results.next()) {
				esistente = true;

			} else {
				esistente = false;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return esistente;
	}
}
