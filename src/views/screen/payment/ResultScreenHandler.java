package views.screen.payment;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import utils.Configs;
import views.screen.BaseScreenHandler;
import views.screen.detailpark.DetailParkScreenHandler;
import views.screen.home.HomeScreenHandler;

public class ResultScreenHandler extends BaseScreenHandler {

	private String result;
	private String message;

	public ResultScreenHandler(Stage stage, String screenPath, String result, String message) throws IOException {
		super(stage, screenPath);
		resultLabel.setText(result);
		messageLabel.setText(message);
	}

	@FXML
	private Label pageTitle;

	@FXML
	private Label resultLabel;

	@FXML
	private Button okButton;
	
	@FXML
	private Label messageLabel;

	@FXML
	void confirmPayment(MouseEvent event) throws IOException {
		HomeScreenHandler homeHandler = new HomeScreenHandler(this.stage, Configs.HOME_PATH);
		homeHandler.setScreenTitle("Home Screen");

		homeHandler.show();
	}

}
