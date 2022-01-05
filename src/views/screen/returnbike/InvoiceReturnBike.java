package views.screen.returnbike;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Logger;

import controller.PaymentController;
import controller.ReturnBikeController;
import entity.invoice.Invoice;
import entity.park.Park;
import entity.rent.Rental;
import entity.rent.RentalBike;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import utils.Configs;
import utils.Utils;
import views.screen.BaseScreenHandler;
import views.screen.payment.PaymentScreenHandler;

public class InvoiceReturnBike extends BaseScreenHandler implements Initializable{
	
	public static Logger LOGGER = Utils.getLogger(InvoiceReturnBike.class.getName());
	
	@FXML
	private Label lbHoanTien;
	
	@FXML
	private Label rentalFees;
	
	@FXML
	private Label lbNameBike;
	
	@FXML
	private Label lbLoaiXe;
	
	@FXML
	private Label lbPark;
	
	@FXML
	private Label lbTimeThue;
	
	@FXML
	private Label lbTienCoc;
	

	
	private RentalBike bike;
	
	private Park park;
	
//	private Invoice invoice;
	public InvoiceReturnBike(Stage stage, String screenPath, RentalBike bike, Park park) throws IOException {
		super(stage, screenPath);
		stage.setX(50);
		stage.setY(50);
		this.bike = bike;
		this.park = park;
		lbNameBike.setText(bike.getBike().getName());
		lbLoaiXe.setText(bike.getBike().getType());
		lbPark.setText(park.getName());
		lbTimeThue.setText(Integer.toString(bike.getTime()));
		lbTienCoc.setText(Integer.toString(bike.getDeposit()));
		if(getFee() > 0) {
			rentalFees.setText(Integer.toString(getFee()));
			lbHoanTien.setText("Hoàn tiền:");
		} else {
			rentalFees.setText(Integer.toString(-1 * getFee()));
			lbHoanTien.setText("Phải trả thêm:");
		}
		
		
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
	@FXML
	void confirmInvoice(MouseEvent event) throws IOException {
		BaseScreenHandler paymentScreen;
		if(getFee() > 0) {
			  paymentScreen = new PaymentScreenHandler(this.stage, Configs.PAYMENT_SCREEN_PATH, new Invoice(getFee()));	
		} else {
			  paymentScreen = new PaymentScreenHandler(this.stage, Configs.PAYMENT_SCREEN_PATH, new Invoice(-1 * getFee()));
		}
		Rental rental = Rental.getRentalInstance();
		rental.removeRentalBikes(bike);
		paymentScreen.setBController(new PaymentController());
		paymentScreen.setPreviousScreen(this);
		paymentScreen.setScreenTitle("Payment Screen");
		paymentScreen.show();
		LOGGER.info("Confirmed invoice");
	}
	public Integer getFee() {
		ReturnBikeController rbController = new ReturnBikeController();
		return rbController.calculateRentalBikeFee(bike);
	    
	}
}
