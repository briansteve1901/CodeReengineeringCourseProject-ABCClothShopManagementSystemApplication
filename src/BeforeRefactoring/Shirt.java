package BeforeRefactoring;

import java.util.Date;

public class Shirt extends ClothData{
	//Smell 23: Bad Code Smell Encapsulation - Deficient Encapsulation
	public String shirtModel;
	public String price;

	public Shirt(String id, String type, String brand, Date promoStart, Date promoEnd, String shirtModel) {
		super(id, type, brand, promoStart, promoEnd);
		this.shirtModel = shirtModel;
	}

	public String getShirtModel() {
		return shirtModel;
	}

	//Smell 34: The Object Orientation Abuser - Refused Bequest
	//Smell 20: Abstraction Smell - Incomplete Abstraction
	public String getPrice() {
		price = "125.000";
		return price;
	}

}
