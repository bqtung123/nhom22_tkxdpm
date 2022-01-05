package views.screen.addPark;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

//import controller.AddBikeController;
import controller.AddParkController;
import controller.PaymentController;
import controller.RentalBikesController;
import entity.bike.Bike;
import entity.invoice.Invoice;
import entity.park.Park;
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

public class AddParkHandle extends BaseScreenHandler implements Initializable{
	@FXML
	private Button addParkButton;
	
	@FXML
	private TextField addPark_id;
	
	@FXML
	private TextField addPark_name;
	
	@FXML
	private TextField addPark_Address;
	
	@FXML
	private TextField addPark_MaxBike;
	
	private Park park;
	
	

	public AddParkHandle(Stage stage, String screenPath) throws IOException {
		super(stage, screenPath);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		
	}
	
	@FXML
	public void handleButtonAction(ActionEvent event) throws IOException, SQLException {
		AddParkController addParkController = (AddParkController) getBController();
		addParkController.setParkId(addPark_id.getText());
		addParkController.setParkName(addPark_name.getText());
		addParkController.setParkAddress(addPark_Address.getText());
		addParkController.setParkMaxBike(addPark_MaxBike.getText());
		
		addParkController.AddParkToDB();

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
		
//		NotiAdd.Display(this.stage, null);
	}
	

}

