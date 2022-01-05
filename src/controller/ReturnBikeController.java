package controller;

import entity.bike.Bike;
import entity.rent.RentalBike;

public class ReturnBikeController extends BaseController {
    
	private RentalBike rentalBike;
	
	public RentalBike getRentalBike() {
		return rentalBike;
	}


	public void setRentalBike(RentalBike rentalBike) {
		this.rentalBike = rentalBike;
	}


	public Integer calculateRentalBikeFee(RentalBike rentalBike) {
		Integer fee = rentalBike.getDeposit();
		if(rentalBike.getTime() < 12){
		 fee = rentalBike.getDeposit() - rentalBike.getTime() * 2000;
		} else {
		 fee = rentalBike.getDeposit() - (rentalBike.getTime() - 12) * 4000 - 24000;
		}
		return fee;
	}
}
