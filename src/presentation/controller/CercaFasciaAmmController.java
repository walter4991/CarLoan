package presentation.controller;

import java.io.IOException;

import presentation.Login;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

/**
 * Controller per la schermata cerca delle fasce
 * @author Sergio
 *
 */
public class CercaFasciaAmmController {

	private FrontController frontController;

	public CercaFasciaAmmController() {
		frontController = new FrontController();
	}

	@FXML
	public void visualizzaFascia(ActionEvent event) throws IOException {

		if (Login.getStato().equals("visualizza"))
			frontController.dispatchRequest("visualizzaFasciaAmm");
		else if (Login.getStato().equals("modifica"))
			frontController.dispatchRequest("modificaFascia");
		else if (Login.getStato().equals("elimina"))
			frontController.dispatchRequest("eliminaFascia");
	}
}
