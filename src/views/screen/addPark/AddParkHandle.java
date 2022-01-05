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
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import utils.Configs;
import views.screen.BaseScreenHandler;
import views.screen.detailpark.DetailParkScreenHandler;
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
	private TextField addPark_maxBike;
	
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
		addParkController.setParkName(addPark_name.getText());
		addParkController.setParkAddress(addPark_Address.getText());
		addParkController.setParkMaxBike(addPark_maxBike.getText());
		
		if(addParkController.AddParkToDB())
		{
			ShowSuccessPopup();
		} else {
			ShowErrorPopup();
		}
		
	}
	
	private void ShowSuccessPopup() {
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Thêm thành công");
		window.setWidth(400);
		window.setHeight(200);
		
		Button button = new Button("OK");
		button.setOnAction(e -> {
			HomeScreenHandler homeHandler;
			try {
				homeHandler = new HomeScreenHandler(this.stage, Configs.HOME_PATH);
				homeHandler.setScreenTitle("Home Screen");
				homeHandler.show();
				window.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
		button.setAlignment(Pos.BOTTOM_CENTER);
		VBox layout = new VBox(20);
		
		layout.getChildren().add(new javafx.scene.control.Label("Thêm thành công"));
		layout.getChildren().addAll(button);
		layout.setAlignment(Pos.CENTER);
		Scene scene = new Scene(layout);
		scene.disposePeer();
		window.setScene(scene);
		window.showAndWait();
	}
	
	
	@FXML
	public void cancelAddPark(ActionEvent event) throws IOException, SQLException {
		   
    	BaseScreenHandler thueXe = new HomeScreenHandler(this.stage, Configs.HOME_PATH);
		thueXe.setScreenTitle("Home");
		thueXe.show();
    }
	
	private void ShowErrorPopup() {
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Không thành công.");
		window.setWidth(400);
		window.setHeight(200);
		
		Button button = new Button("OK");
		button.setOnAction(e -> {
			window.close();
		});
		
		button.setAlignment(Pos.BOTTOM_CENTER);
		
		
		VBox layout = new VBox(20);
		
		layout.getChildren().add(new javafx.scene.control.Label("Không thành công. Kiểm tra lại thông tin nhập vào"));
		layout.getChildren().addAll(button);
		
		  
        // add label to vbox

	    
		layout.setAlignment(Pos.CENTER);
		Scene scene = new Scene(layout);
		scene.disposePeer();
		window.setScene(scene);
		window.showAndWait();
	}
	

}

