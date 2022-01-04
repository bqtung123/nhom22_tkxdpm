package views.screen.home;


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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import utils.Configs;
import utils.Utils;
import views.screen.BaseScreenHandler;
import views.screen.detailbike.DetailBikeScreenHandler;
import views.screen.returnbike.ChooseBikeParkScreenHandler;

public class HomeScreenByHoan extends BaseScreenHandler implements Initializable{

	 @FXML
    private TableView<Park> tvPark;
	    
    @FXML
    private TableColumn<Park, Integer> colId;
    
    @FXML
    private TableColumn<Park, String> colName;
    
    @FXML
    private TableColumn<Park, String> colAddress;
    
    @FXML
    private TableColumn<Park, Integer> colMaxBike;
    
    @FXML
    private TextField searchText;

	
	
	
	
	public HomeScreenByHoan(Stage stage, String screenPath) throws IOException {
		super(stage, screenPath);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		  try {
		    	 showPark();
		 	} catch (SQLException e) {
		 		// TODO Auto-generated catch block
		 		e.printStackTrace();
		 	}
	}
	

	
	public void showPark() throws SQLException {
		ObservableList<Park> park = getParksList();
		
		colId.setCellValueFactory(new PropertyValueFactory<Park, Integer>("id"));
		colName.setCellValueFactory(new PropertyValueFactory<Park, String>("name"));
		colAddress.setCellValueFactory(new PropertyValueFactory<Park, String>("address"));
		colMaxBike.setCellValueFactory(new PropertyValueFactory<Park, Integer>("maxBike"));
		tvPark.setItems(park);
	}
	
	public ObservableList<Park> getParksList() throws SQLException{
		ObservableList<Park> parkList = FXCollections.observableArrayList();
		  Statement stm = AIMSDB.getConnection().createStatement();
          ResultSet res = stm.executeQuery("select * from Park");
         
          while (res.next()) {
                Park park = new Park();
                park.setId(res.getInt("id"));
                park.setName(res.getString("name"));
                park.setAddress(res.getString("address"));
                park.setMaxBike(res.getInt("maxBike"));
          
                parkList.add(park);
	}
          return parkList;
	}
    
	@FXML
	public void onActionThueXe(ActionEvent event) throws IOException {
		    Park park= tvPark.getSelectionModel().getSelectedItem();
		   
		    if(park!=null) {
		    	BaseScreenHandler thueXe = new HomeScreenHandler(this.stage, Configs.HOME_PATH,park.getId());
				thueXe.setBController(new RentalBikesController());
				thueXe.setScreenTitle("Thuê xe");
				thueXe.show();
		    }
		
	}
	@FXML
	public void onActionTraXe(ActionEvent event) throws IOException {
			BaseScreenHandler traXe = new ChooseBikeParkScreenHandler(this.stage, Configs.CHOOSE_PARK_BIKE_RETURN_PATH);
			traXe.setBController(new RentalBikesController());
			traXe.setScreenTitle("Trả xe");
			traXe.show();
	}
	
	@FXML
	public void searchPark(ActionEvent event) throws IOException, SQLException {
			String searhString = searchText.getText();
			if(searhString.length() > 0) {
				showParkByName(searhString);
			}
	}
	
	public void showParkByName(String searchText) throws SQLException {
		ObservableList<Park> park = getParksListByName(searchText);
		
		colId.setCellValueFactory(new PropertyValueFactory<Park, Integer>("id"));
		colName.setCellValueFactory(new PropertyValueFactory<Park, String>("name"));
		colAddress.setCellValueFactory(new PropertyValueFactory<Park, String>("address"));
		colMaxBike.setCellValueFactory(new PropertyValueFactory<Park, Integer>("maxBike"));
		tvPark.setItems(park);
	}
	
	public ObservableList<Park> getParksListByName(String searchText) throws SQLException{
		ObservableList<Park> parkList = FXCollections.observableArrayList();
		  Statement stm = AIMSDB.getConnection().createStatement();
		  String queryString ="select * from Park where name like '%"+ searchText+"%'";
          ResultSet res = stm.executeQuery(queryString);
         
          while (res.next()) {
                Park park = new Park();
                park.setId(res.getInt("id"));
                park.setName(res.getString("name"));
                park.setAddress(res.getString("address"));
                park.setMaxBike(res.getInt("maxBike"));
          
                parkList.add(park);
	}
          return parkList;
	}
	
	
}
