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
	
	//methods
	public void AddBikeToDB() throws SQLException {
//		Statement stm = AIMSDB.getConnection().createStatement();
//        ResultSet res = stm.executeQuery("INSERT INTO Bike (id, COLUMN_2,..) VALUES (VALUE_1,VALUE_2,..)");
        
     // the mysql insert statement
        String query = " insert into Bike (name, type, license, producer)"
          + " values (?, ?, ?, ?)";

        // create the mysql insert preparedstatement
        PreparedStatement preparedStmt = AIMSDB.getConnection().prepareStatement(query);
        preparedStmt.setString (1, this.getBikeName());
        preparedStmt.setString (2, this.getBikeType());
        preparedStmt.setString   (3, this.getBikeLicense());
        preparedStmt.setString(4, this.getBikeProducer());

        // execute the preparedstatement
        preparedStmt.execute();
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
