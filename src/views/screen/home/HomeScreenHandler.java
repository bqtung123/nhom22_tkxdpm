package views.screen.home;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Logger;

import common.exception.ViewCartException;
import controller.AddBikeController;
import controller.BaseController;
import controller.RentalBikesController;
import entity.bike.Bike;
import entity.db.AIMSDB;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import utils.Configs;
import utils.Utils;
import views.screen.BaseScreenHandler;
import views.screen.addBike.AddBikeHandle;
import views.screen.addPark.AddParkHandle;
import views.screen.detailbike.DetailBikeScreenHandler;
import views.screen.*;



public class HomeScreenHandler extends BaseScreenHandler implements Initializable{

    public static Logger LOGGER = Utils.getLogger(HomeScreenHandler.class.getName());

    @FXML
    private Button detailButton;
    
    @FXML
    private TableView<Bike> tvBike;
    
    @FXML
    private TableColumn<Bike, Integer> colId;
    
    @FXML
    private TableColumn<Bike, String> colName;
    
    @FXML
    private TableColumn<Bike, String> colType;
    
    @FXML
    private TableColumn<Bike, String> colLicense;
    
    @FXML
    private TableColumn<Bike, String> colProducer;
    
    

    public HomeScreenHandler(Stage stage, String screenPath) throws IOException{
        super(stage, screenPath);
    }

 

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
     try {
		showBikes();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    }
  
		@FXML
		public void handleButtonAction(ActionEvent event) throws IOException {
			Bike bike= tvBike.getSelectionModel().getSelectedItem();
			if(bike != null) {
				BaseScreenHandler detailScreen = new DetailBikeScreenHandler(this.stage, Configs.DETAIL_BIKE_PATH, bike);
				detailScreen.setBController(new RentalBikesController());
				detailScreen.setScreenTitle("Detail Screen");
				detailScreen.show();
			}
			
		}
		
	public ObservableList<Bike> getBikesList() throws SQLException{
		ObservableList<Bike> bikeList = FXCollections.observableArrayList();
		  Statement stm = AIMSDB.getConnection().createStatement();
          ResultSet res = stm.executeQuery("select * from Bike");
         
          while (res.next()) {
                Bike bike = new Bike();
                bike.setId(res.getInt("id"));
                bike.setName(res.getString("name"));
                bike.setType(res.getString("type"));
                bike.setLicense(res.getString("license"));
                bike.setProducer(res.getString("producer"));
          
              bikeList.add(bike);
	}
          return bikeList;
	}
	
	public void showBikes() throws SQLException {
		ObservableList<Bike> bikes = getBikesList();
		
		colId.setCellValueFactory(new PropertyValueFactory<Bike, Integer>("id"));
		colName.setCellValueFactory(new PropertyValueFactory<Bike, String>("name"));
		colType.setCellValueFactory(new PropertyValueFactory<Bike, String>("type"));
		colLicense.setCellValueFactory(new PropertyValueFactory<Bike, String>("license"));
		colProducer.setCellValueFactory(new PropertyValueFactory<Bike, String>("producer"));
		tvBike.setItems(bikes);
	}
	
	
	@FXML
	public void buttonAddBikeScreenAction(ActionEvent event) throws IOException {
		BaseScreenHandler addBikeScreen = new AddBikeHandle(this.stage, Configs.ADD_BIKE_PATH);
		addBikeScreen.setBController(new AddBikeController());
		addBikeScreen.setScreenTitle("Add Bike Screen");
		addBikeScreen.show();
		
	}
	
	@FXML
	public void buttonAddParkScreenAction(ActionEvent event) throws IOException {
		BaseScreenHandler addParkScreen = new AddParkHandle(this.stage, Configs.ADD_PARK_PATH);
		addParkScreen.setBController(new AddBikeController());
		addParkScreen.setScreenTitle("Add Park Screen");
		addParkScreen.show();
		
	}
    
    
}
