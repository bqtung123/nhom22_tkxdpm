package entity.rent;

import entity.bike.Bike;

public class RentalBike {
	private Bike bike;
	private int deposit;
	private int time;
	
	
	
	public RentalBike(Bike bike) {
		this.bike = bike;
	}
	
	
	public RentalBike(Bike bike, int deposit) {
		
		this.bike = bike;
		this.deposit = deposit;
	}
	public Bike getBike() {
		return bike;
	}
	public void setBike(Bike bike) {
		this.bike = bike;
	}
	public int getDeposit() {
		return deposit;
	}
	public void setDeposit(int deposit) {
		this.deposit = deposit;
	}


	public int getTime() {
		return time;
	}


	public void setTime(int time) {
		this.time = time;
	}
	

}
