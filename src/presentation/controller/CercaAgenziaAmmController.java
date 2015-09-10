package presentation.controller;

import java.io.IOException;
 


import java.sql.SQLException;

import presentation.Login;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

/**
 * Controller per la schermata cerca di agenzia
 * @author Sergio
 *
 */
public class CercaAgenziaAmmController {

	private FrontController frontController;
	 
	public CercaAgenziaAmmController() {
		frontController = new FrontController();
		 
	}

	@FXML
	public void visualizza(ActionEvent event) throws IOException, SQLException {

		if (Login.getStato().equals("visualizza")) {
			frontController.dispatchRequest("visualizzaAgenziaAmm");
		} else {
			if (Login.getStato().equals("modifica")) {
				frontController.dispatchRequest("modificaAgenzia");
			} else {
				if (Login.getStato().equals("elimina")) {
					frontController.dispatchRequest("eliminaAgenzia");
				}
			}
		}
	}
}
