package views.screen.addBike;

import java.io.IOException;
import utils.Configs;
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
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
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
	
	@FXML
	private TextField addBike_cost;
	
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
		addBikeController.setBikeCost(addBike_cost.getText());
		addBikeController.setBikeParkId(parkId);
		
		if(addBikeController.AddBikeToDB()) {
			ShowSuccessPopup();
		} else {
			ShowErrorPopup();
		}
	}
	
	@FXML
	public void cancelAddBike(ActionEvent event) throws IOException, SQLException {
		   
    	BaseScreenHandler thueXe = new HomeScreenHandler(this.stage, Configs.HOME_PATH, parkId);
		thueXe.setBController(new RentalBikesController());
		thueXe.setScreenTitle("Thuê xe");
		thueXe.show();
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
				homeHandler = new HomeScreenHandler(this.stage, Configs.HOME_PATH,parkId);
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

