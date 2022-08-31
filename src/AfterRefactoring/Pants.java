package AfterRefactoring;

import java.util.Date;

public class Pants extends Cloth implements Price{
	//Refactoring Smell 24: Bad Code Smell Encapsulation - Deficient Encapsulation
	private String pantsModel;
	
	public Pants(String id, String type, String brand, Date promoStart, Date promoEnd, String pantsModel) {
		super(id, type, brand, promoStart, promoEnd);
		this.pantsModel = pantsModel;
	}

	public String getPantsModel() {
		return pantsModel;
	}

	//Refactoring Smell 19: Abstraction Smell - Incomplete Abstraction
	//Refactoring Smell 34: The Object Orientation Abuser - Refused Bequest
	public String getPrice() {
		return setPrice();
	}

	public String setPrice() {
		return "250.000";
	}
	
	//Refactoring Smell 32: The Couplers - Feature Envy
	public static void NewPantsAddedSuccessMessage() {
		System.out.println("Success added new pants!");
	}

}