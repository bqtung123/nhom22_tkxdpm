package views.screen.addBike;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

import controller.AddBikeController;
import controller.PaymentController;
import controller.RentalBikesController;
import entity.bike.Bike;
import entity.invoice.Invoice;
import entity.rent.Rental;
import entity.rent.RentalBike;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import utils.Configs;
import views.screen.BaseScreenHandler;
import views.screen.home.HomeScreenHandler;
import views.screen.invoice.InvoiceScreenHandler;

public class AddBikeHandle extends BaseScreenHandler implements Initializable{
	@FXML
	private Button addBikeButton;
	
	@FXML
	private TextField addBike_name;
	
	@FXML
	private TextField addBike_type;
	
	@FXML
	private TextField addBike_license;
	
	@FXML
	private TextField addBike_producer;
	
	private Bike bike;
	
	private int parkId;

	public AddBikeHandle(Stage stage, String screenPath,int parkId) throws IOException {
		super(stage, screenPath);
		this.parkId=parkId;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		
	}
	
	@FXML
	public void handleButtonAction(ActionEvent event) throws IOException, SQLException {
		AddBikeController addBikeController = (AddBikeController) getBController();
		addBikeController.setBikeName(addBike_name.getText());
		addBikeController.setBikeType(addBike_type.getText());
		addBikeController.setBikeLicense(addBike_license.getText());
		addBikeController.setBikeProducer(addBike_producer.getText());
		addBikeController.setBikeParkId(parkId);
		addBikeController.AddBikeToDB();

//		Stage window = new Stage();
//		window.initModality(Modality.APPLICATION_MODAL);
//		window.setTitle("Notification");
//		window.setMinWidth(600);
//		window.setMinHeight(400);
//		
//		Button button = new Button();
//		button.setOnAction(e -> {
//			HomeScreenHandler homeHandler;
//			try {
//				homeHandler = new HomeScreenHandler(this.stage, Configs.HOME_PATH);
//				homeHandler.setScreenTitle("Home Screen");
//				homeHandler.show();
//				window.close();
//			} catch (IOException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//		});
		
		NotiAdd.Display(this.stage, null,parkId);
	}
	

}

