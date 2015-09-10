package utilita.controlli_e_sicurezza;

import java.util.Optional;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

/**
 * Classe che permette di gestire gli alert ovvero crearli e visualizzarli
 * @author Sergio
 *
 */
public class GestioneAlert {

	/**
	 * Permette di creare e visualizzare un alert informativo utilizzando la classe Alert
	 * @see javafx.scene.control.Alert
	 * @param messaggio
	 * 		il messaggio da visualizzare
	 */
	public void alertInformativo(String messaggio) {

		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Informazione");
		alert.setHeaderText(messaggio);

		alert.showAndWait();
	}

	/**
	 * Permette di creare e visualizzare un alert errore utilizzando la classe Alert
	 * @see javafx.scene.control.Alert
	 * @param messaggio
	 * 		il messaggio da visualizzare
	 */
	public void alertErrore(String messaggio) {

		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Errore");
		alert.setHeaderText(messaggio);

		alert.showAndWait();
	}

	/**
	 * Permette di creare e visualizzare un alert conferma utilizzando la classe Alert
	 * @see javafx.scene.control.Alert
	 * @param messaggio
	 * 		il messaggio da visualizzare
	 * @return
	 * 		true se è stato premuto OK
	 * 		false altrimenti
	 */
	public boolean alertConferma(String messaggio) {

		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Conferma");
		alert.setHeaderText(messaggio);

		ButtonType ok = new ButtonType("OK");
		ButtonType annulla = new ButtonType("ANNULLA");

		alert.getButtonTypes().setAll(ok, annulla);

		Optional<ButtonType> result = alert.showAndWait();

		if (result.get() == ok) {
			return true;

		} else
			return false;
	}
}
