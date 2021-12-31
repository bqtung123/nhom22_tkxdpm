package views.screen.invoice;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Logger;

import common.exception.ProcessInvoiceException;
import controller.PaymentController;
import entity.invoice.Invoice;
//import entity.order.Order;
//import entity.order.OrderMedia;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import utils.Configs;
import utils.Utils;
import views.screen.BaseScreenHandler;
import views.screen.payment.PaymentScreenHandler;

public class InvoiceScreenHandler extends BaseScreenHandler {

	private static Logger LOGGER = Utils.getLogger(InvoiceScreenHandler.class.getName());

	@FXML
	private Label pageTitle;

	@FXML
	private Label name;

	@FXML
	private Label phone;

	@FXML
	private Label province;

	@FXML
	private Label address;

	@FXML
	private Label instructions;


	@FXML
	private Label rentalFees;


	private Invoice invoice;

	public InvoiceScreenHandler(Stage stage, String screenPath, Invoice invoice) throws IOException {
		super(stage, screenPath);
		this.invoice = invoice;
		setInvoiceInfo();
	}

	private void setInvoiceInfo(){
		rentalFees.setText(String.valueOf(invoice.getAmount())+" ");

	}

	@FXML
	void confirmInvoice(MouseEvent event) throws IOException {
		BaseScreenHandler paymentScreen = new PaymentScreenHandler(this.stage, Configs.PAYMENT_SCREEN_PATH, invoice);
		paymentScreen.setBController(new PaymentController());
		paymentScreen.setPreviousScreen(this);
		paymentScreen.setScreenTitle("Payment Screen");
		paymentScreen.show();
		LOGGER.info("Confirmed invoice");
	}

}
