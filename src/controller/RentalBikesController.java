package controller;

import java.util.Random;

import entity.bike.Bike;
import entity.rent.Rental;
import entity.rent.RentalBike;

public class RentalBikesController extends BaseController {
	
	public RentalBike createRentalBike(Bike bike) {
		RentalBike rentalBike = new RentalBike(bike);
		//add time
		int rentalTime = generateTimeRandom(1, 100);
		rentalBike.setTime(rentalTime);
		
		// add rental bike to rental list
		Rental rental=Rental.getRentalInstance();
		rental.addRentalBikes(rentalBike);
		// calculate deposit for rental bike
		calculateDeposit(rentalBike);
		return rentalBike;
	}
	
	public void calculateDeposit(RentalBike rentalBike) {
		Bike bike=rentalBike.getBike();
		if(bike.getType().equals("bike") ) {
			rentalBike.setDeposit(4000);
		}
		
		if(bike.getType().equals("ebike") ) {
			rentalBike.setDeposit(7000);
		}
		
		if(bike.getType().equals("twinbike") ) {
			rentalBike.setDeposit(5500);
		}	
	}

	public static int generateTimeRandom(int min,int max) {
		Random random=new Random();
		int result=random.nextInt((max-min)+1)+min;
		return result;
	}

}
