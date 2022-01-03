package views.screen.returnbike;

import java.io.IOException;
import java.net.URL;

import java.util.ResourceBundle;

import controller.ReturnBikeController;
import entity.bike.Bike;
import entity.park.Park;
import entity.rent.RentalBike;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import utils.Configs;
import views.screen.BaseScreenHandler;

public class PopupReturnBikeHandler extends BaseScreenHandler implements Initializable{
    
	private RentalBike bikeChoose; 
	private Park parkChoose;
	
	@FXML
	private Text textPopup;
    
	public PopupReturnBikeHandler(Stage stage, String screenPath,RentalBike bike,Park park) throws IOException {
		super(stage, screenPath);
		stage.setX(300);
		stage.setY(200);
		this.bikeChoose = bike;
		this.parkChoose = park;
		textPopup.setText("Bạn có muốn trả xe "+bike.toString()+" vào bãi để xe "+park.toString()+" không?" );	
	}
    
	@FXML
	public void onAcceptClick(ActionEvent event) throws IOException {
		BaseScreenHandler invoiceReturnBike = new InvoiceReturnBike(this.stage, Configs.INVOICE_RETURN_BIKE_PATH,bikeChoose,parkChoose);
		invoiceReturnBike.setBController(new ReturnBikeController());
		invoiceReturnBike.setScreenTitle("Hóa đơn trả xe");
		invoiceReturnBike.show();
	}
	
	@FXML
	public void onCancelClick(ActionEvent event) throws IOException {
		ChooseBikeParkScreenHandler chooseBikeParkScreen = new ChooseBikeParkScreenHandler(this.stage, Configs.CHOOSE_PARK_BIKE_RETURN_PATH);
			chooseBikeParkScreen.setScreenTitle("Trả xe");
			chooseBikeParkScreen.getChooseBefore(bikeChoose, parkChoose);
			chooseBikeParkScreen.show();
		}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}

}
