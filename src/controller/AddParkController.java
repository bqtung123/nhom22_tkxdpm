package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import entity.db.AIMSDB;

public class AddParkController extends BaseController {
	public String parkId;
	public String parkName;
	public String parkAddress;
	public String parkMax;
	
	public void setParkId(String parkId){
		this.parkId = parkId;
	}
	public String getParkId() {
		return this.parkId;
	}
	
	public void setParkName(String parkName){
		this.parkName = parkName;
	}
	public String getParkName() {
		return this.parkName;
	}
	
	public void setParkAddress(String parkAddress){
		this.parkAddress = parkAddress;
	}
	public String getParkAddress() {
		return this.parkAddress;
	}
	
	public void setParkMaxBike(String parkMaxBike){
		this.parkMax = parkMaxBike;
	}
	public String getParkMaxBike() {
		return this.parkMax;
	}
	
	private boolean check()
	{
		try
	    {
	        Integer.parseInt(this.getParkMaxBike());
	        return true;
	    } catch (NumberFormatException ex)
	    {
	        return false;
	    }
	}
	
	//methods
	public boolean AddParkToDB() throws SQLException {
//		Statement stm = AIMSDB.getConnection().createStatement();
//        ResultSet res = stm.executeQuery("INSERT INTO Bike (id, COLUMN_2,..) VALUES (VALUE_1,VALUE_2,..)");
        
     // the mysql insert statement
		if(this.getParkName() == "" || this.getParkAddress() == "" || this.getParkMaxBike() == "" || !check())
		{
			return false;
		}
		else {
			String query = " insert into Park (name, address, maxBike)"
			          + " values (?, ?, ?)";

	        // create the mysql insert preparedstatement
	        PreparedStatement preparedStmt = AIMSDB.getConnection().prepareStatement(query);
	        preparedStmt.setString (1, this.getParkName());
	        preparedStmt.setString   (2, this.getParkAddress());
	        preparedStmt.setInt(3, Integer.parseInt(this.getParkMaxBike()));

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
