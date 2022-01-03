package views.screen.home;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Logger;

import controller.RentalBikesController;
import entity.bike.Bike;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.Stage;
import utils.Configs;
import utils.Utils;
import views.screen.BaseScreenHandler;
import views.screen.detailbike.DetailBikeScreenHandler;
import views.screen.returnbike.ChooseBikeParkScreenHandler;

public class HomeScreenByHoan extends BaseScreenHandler implements Initializable{

    public HomeScreenByHoan(Stage stage, String screenPath) throws IOException {
		super(stage, screenPath);
		// TODO Auto-generated constructor stub
	}

	public static Logger LOGGER = Utils.getLogger(HomeScreenHandler.class.getName());
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
    
	@FXML
	public void onActionThueXe(ActionEvent event) throws IOException {
		
			BaseScreenHandler thueXe = new HomeScreenHandler(this.stage, Configs.HOME_PATH);
			thueXe.setBController(new RentalBikesController());
			thueXe.setScreenTitle("Thuê xe");
			thueXe.show();
	}
	@FXML
	public void onActionTraXe(ActionEvent event) throws IOException {
			BaseScreenHandler traXe = new ChooseBikeParkScreenHandler(this.stage, Configs.CHOOSE_PARK_BIKE_RETURN_PATH);
			traXe.setBController(new RentalBikesController());
			traXe.setScreenTitle("Trả xe");
			traXe.show();
	}
}
