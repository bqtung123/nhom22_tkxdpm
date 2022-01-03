package views.screen.returnbike;


import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Logger;

import controller.RentalBikesController;
import entity.bike.Bike;
import entity.db.AIMSDB;
import entity.park.Park;
import entity.rent.Rental;
import entity.rent.RentalBike;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import utils.Configs;
import utils.Utils;
import views.screen.BaseScreenHandler;

public class ChooseBikeParkScreenHandler extends BaseScreenHandler implements Initializable{
    
	public static Logger LOGGER = Utils.getLogger(ChooseBikeParkScreenHandler.class.getName());
	
	@FXML
	private Button buttonChooseReturn;
	
	@FXML
	private ComboBox<RentalBike> CbxBikeList;
	
	@FXML
	private ComboBox<Park> CbxParkList;
	
	
	public ChooseBikeParkScreenHandler(Stage stage, String screenPath) throws IOException {
		super(stage, screenPath);
		stage.setX(200);
		stage.setY(100);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		 try {
				showBikes();
				showParks();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

	@FXML
	public void chooseBikeToReturn(ActionEvent event) throws IOException {
		RentalBike bike= CbxBikeList.getSelectionModel().getSelectedItem();
		Park park= CbxParkList.getSelectionModel().getSelectedItem();
		if(bike != null && park != null) {
			BaseScreenHandler popupReturnBikeScreen = new PopupReturnBikeHandler(this.stage, Configs.POPUP_RETURN_BIKE_PATH, bike,park);
			popupReturnBikeScreen.setScreenTitle("Thông báo");
			popupReturnBikeScreen.show();
		}
		
	}
	
public ObservableList<RentalBike> getBikesList() throws SQLException{
	ObservableList<RentalBike> bikeList = FXCollections.observableArrayList();
	 Rental rental = Rental.getRentalInstance();
	 for (RentalBike rb : rental.getListBikes()) {
		 bikeList.add(rb);
	 }
      return bikeList;
}
public ObservableList<Park> getParksList() throws SQLException{
	ObservableList<Park> parkList = FXCollections.observableArrayList();
	  Statement stm = AIMSDB.getConnection().createStatement();
      ResultSet res = stm.executeQuery("select * from Park");
     
      while (res.next()) {
            Park park = new Park();
            park.setId(res.getInt("id"));
            park.setName(res.getString("name"));
            park.setAddress(res.getString("address"));;
            park.setMaxBike(res.getInt("maxBike"));;
      
          parkList.add(park);
}
      return parkList;
}
public void showBikes() throws SQLException {
	ObservableList<RentalBike> bikes = getBikesList();
	
	CbxBikeList.setItems(bikes);
}
public void showParks() throws SQLException {
	ObservableList<Park> parks = getParksList();
	
	CbxParkList.setItems(parks);;
}
public void getChooseBefore(RentalBike bike, Park park) {
	CbxBikeList.getSelectionModel().select(bike);
	CbxParkList.getSelectionModel().select(park);
}
}
