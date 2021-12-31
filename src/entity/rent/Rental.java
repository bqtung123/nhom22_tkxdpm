package entity.rent;

import java.util.ArrayList;
import java.util.List;



public class Rental {
	
	private List<RentalBike> lstRentalBikes;
	private static Rental rentalInstance;
	
	public static Rental getRentalInstance() {
	    if(rentalInstance == null) rentalInstance = new Rental();
        return rentalInstance;
	}
	
	public Rental() {
		lstRentalBikes = new ArrayList<RentalBike>();
	}
	
	public void addRentalBikes(RentalBike rb) {
		lstRentalBikes.add(rb);
	}
	
	public List<RentalBike> getListBikes() {
		return lstRentalBikes;
	}
	
	public void removeRentalBikes(RentalBike rb) {
		lstRentalBikes.remove(rb);
		
	}
	
	public void emptyRental() {
		lstRentalBikes.clear();
	}

}
