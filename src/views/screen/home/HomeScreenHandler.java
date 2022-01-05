package views.screen.home;


import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import controller.RentalBikesController;
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
import views.screen.BaseScreenHandler;
<<<<<<< HEAD
import views.screen.addBike.AddBikeHandle;
import views.screen.addPark.AddParkHandle;
import views.screen.detailbike.DetailBikeScreenHandler;
import views.screen.*;


=======
import views.screen.detailpark.DetailParkScreenHandler;
import views.screen.returnbike.ChooseBikeParkScreenHandler;
>>>>>>> 370e4309b59d234795b8441c4e608f38b2083f31

public class HomeScreenHandler extends BaseScreenHandler implements Initializable{

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

	
	
	
	
	public HomeScreenHandler(Stage stage, String screenPath) throws IOException {
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
		    	BaseScreenHandler thueXe = new DetailParkScreenHandler(this.stage, Configs.DETAIL_PARK_PATH,park.getId());
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
			String searchString = searchText.getText();
			System.out.println(searchString);
			showParkByName(searchString);
	}
	
	public void showParkByName(String searchText) throws SQLException {
		ObservableList<Park> park = getParksListByName(searchText);
		
		colId.setCellValueFactory(new PropertyValueFactory<Park, Integer>("id"));
		colName.setCellValueFactory(new PropertyValueFactory<Park, String>("name"));
		colAddress.setCellValueFactory(new PropertyValueFactory<Park, String>("address"));
		colMaxBike.setCellValueFactory(new PropertyValueFactory<Park, Integer>("maxBike"));
		tvPark.setItems(park);
	}
	
<<<<<<< HEAD
	@FXML
	public void buttonAddParkScreenAction(ActionEvent event) throws IOException {
		BaseScreenHandler addParkScreen = new AddParkHandle(this.stage, Configs.ADD_PARK_PATH);
		addParkScreen.setBController(new AddBikeController());
		addParkScreen.setScreenTitle("Add Park Screen");
		addParkScreen.show();
		
	}
    
    
=======
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
	
	
>>>>>>> 370e4309b59d234795b8441c4e608f38b2083f31
}
