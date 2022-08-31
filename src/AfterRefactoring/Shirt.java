package AfterRefactoring;

import java.util.Date;

public class Shirt extends Cloth implements Price{
	//Refactoring Smell 23: Bad Code Smell Encapsulation - Deficient Encapsulation
	private String shirtModel;

	public Shirt(String id, String type, String brand,  Date promoStart, Date promoEnd, String shirtModel) {
		super(id, type, brand, promoStart, promoEnd);
		this.shirtModel = shirtModel;
	}

	public String getShirtModel() {
		return shirtModel;
	}

	//Refactoring Smell 20: Abstraction Smell - Incomplete Abstraction
	//Refactoring Smell 34: The Object Orientation Abuser - Refused Bequest
	public String getPrice() {
		return setPrice();
	}

	public String setPrice() {
		return "125.000";
	}
	
	//Refactoring Smell 33: The Couplers - Feature Envy
	public static void NewShirtAddedSuccessMessage() {
		System.out.println("Success added new shirt!");
	}
	
}
