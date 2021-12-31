package entity.db;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Logger;

import entity.bike.Bike;

import utils.*;

import java.sql.Connection;

public class AIMSDB {

	private static Logger LOGGER = Utils.getLogger(Connection.class.getName());
	private static Connection connect;

    public static Connection getConnection() {
        if (connect != null) return connect;
        try {
			Class.forName("org.sqlite.JDBC");
            String url = "jdbc:sqlite:assets/db/ecobike.db";
            connect = DriverManager.getConnection(url);
            LOGGER.info("Connect database successfully ecobikedb");
        } catch (Exception e) {
            LOGGER.info(e.getMessage());
        } 
        return connect;
    }
    

    public static void main(String[] args) throws SQLException {
//        AIMSDB.getConnection();
    	  Statement stm = AIMSDB.getConnection().createStatement();
          ResultSet res = stm.executeQuery("select * from Bike");
          ArrayList medium = new ArrayList<>();
          while (res.next()) {
              Bike bike = new Bike();
                bike.setName(res.getString("name"));
                bike.setType(res.getString("type"));
                bike.setLicense(res.getString("license"));
                bike.setProducer(res.getString("producer"));
              System.out.println(bike.getName()+" "+bike.getType()+" "+ bike.getLicense());
              medium.add(bike);
          }
    }
}
