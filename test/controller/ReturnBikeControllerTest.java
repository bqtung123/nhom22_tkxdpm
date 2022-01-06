package controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import entity.bike.Bike;
import entity.rent.RentalBike;


public class ReturnBikeControllerTest {

private ReturnBikeController returnBikeController;
	
	@BeforeEach
	void setUp() throws Exception {
		returnBikeController = new ReturnBikeController();
	}

	@ParameterizedTest
	@CsvSource({
		"40000,12,16000",
		"200000,8,184000",
		"10000,12,-14000",
		"150000,24,78000",
		"40000,48,-128000"
	})
	void test(Integer deposit,Integer time, Integer expectedDeposit) {
		RentalBike rentalBike = new RentalBike(new Bike());
		rentalBike.setDeposit(deposit);
		rentalBike.setTime(time);
		Integer checkDeposit = returnBikeController.calculateRentalBikeFee(rentalBike);
		
		// then
		assertEquals(expectedDeposit, checkDeposit);
	}
}
