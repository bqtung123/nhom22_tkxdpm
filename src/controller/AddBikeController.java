package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import entity.db.AIMSDB;

public class AddBikeController extends BaseController {
	public String bikeName;
	public String bikeType;
	public String bikeLicense;
	public String bikeProducer;
	public String bikeCost;
	public int bikeParkId;
	
	public int getBikeParkId() {
		return bikeParkId;
	}
	public void setBikeParkId(int bikeParkId) {
		this.bikeParkId = bikeParkId;
	}
	public void setBikeName(String bikeName){
		this.bikeName = bikeName;
	}
	public String getBikeName() {
		return this.bikeName;
	}
	
	public void setBikeType(String bikeType){
		this.bikeType = bikeType;
	}
	public String getBikeType() {
		return this.bikeType;
	}
	
	public void setBikeLicense(String bikeLicense){
		this.bikeLicense = bikeLicense;
	}
	public String getBikeLicense() {
		return this.bikeLicense;
	}
	
	public void setBikeProducer(String bikeProducer){
		this.bikeProducer = bikeProducer;
	}
	public String getBikeProducer() {
		return this.bikeProducer;
	}
	
	public void setBikeCost(String bikeCost){
		this.bikeCost = bikeCost;
	}
	public String getBikeCost() {
		return this.bikeCost;
	}
	
	//methods
	public boolean AddBikeToDB() throws SQLException {
		if(bikeCost == "" || bikeName == "" || bikeLicense == "" || bikeProducer == "" || bikeType == "") {
			return false;
		} else {

	        String query = " insert into Bike (name, type, license, producer, cost, parkId)"
	          + " values (?, ?, ?, ?, ?, ?)";

	        // create the mysql insert preparedstatement
	        PreparedStatement preparedStmt = AIMSDB.getConnection().prepareStatement(query);
	        preparedStmt.setString(1, this.getBikeName());
	        preparedStmt.setString(2, this.getBikeType());
	        preparedStmt.setString(3, this.getBikeLicense());
	        preparedStmt.setString(4, this.getBikeProducer());
	        preparedStmt.setInt(5, Integer.parseInt(this.getBikeCost()));
	        preparedStmt.setInt(6, this.getBikeParkId());

	        // execute the preparedstatement
	        preparedStmt.execute();
	        
	        return true;
		}
		
	}
	
//	"id"	INTEGER,
//	"type"	TEXT,
//	"weight"	INTEGER,
//	"license"	TEXT,
//	"createdAt"	TEXT,
//	"producer"	TEXT,
//	"cost"	INTEGER,
//	"parkId"	INTEGER,
//	"name"	TEXT,
}
