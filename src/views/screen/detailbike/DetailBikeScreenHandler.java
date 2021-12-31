package views.screen.detailbike;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import controller.BaseController;
import controller.PaymentController;
import controller.RentalBikesController;
import entity.bike.Bike;
import entity.invoice.Invoice;
import entity.rent.Rental;
import entity.rent.RentalBike;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import utils.Configs;
import views.screen.BaseScreenHandler;
import views.screen.invoice.InvoiceScreenHandler;

public class DetailBikeScreenHandler extends BaseScreenHandler implements Initializable{
	@FXML
	private Button rentalButton;
	
	@FXML
	private TextField nameText;
	
	@FXML
	private TextField typeText;
	
	@FXML
	private TextField licenseText;
	
	@FXML
	private TextField producerText;
	
	private Bike bike;

	public DetailBikeScreenHandler(Stage stage, String screenPath,Bike bike) throws IOException {
		super(stage, screenPath);
		this.bike = bike;
	nameText.setText(bike.getName());
	typeText.setText(bike.getType());
	licenseText.setText(bike.getLicense());
	producerText.setText(bike.getProducer());
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

		
	}
	
	@FXML
	public void handleButtonAction(ActionEvent event) throws IOException {
		RentalBikesController ctrl=(RentalBikesController) getBController();
		RentalBike rentalBike= ctrl.createRentalBike(bike);
		
		Rental rental=Rental.getRentalInstance();
		List<RentalBike> rentalBikesList= rental.getListBikes();
		for(RentalBike rb: rentalBikesList){
			System.out.println(rb.getBike().getName());
		};
		BaseScreenHandler invoiceScreen = new InvoiceScreenHandler(this.stage, Configs.INVOICE_SCREEN_PATH, new Invoice(rentalBike.getDeposit()));
		invoiceScreen.setBController(new PaymentController());
		invoiceScreen.setScreenTitle("Payment Screen");
		invoiceScreen.show();
	}

}
