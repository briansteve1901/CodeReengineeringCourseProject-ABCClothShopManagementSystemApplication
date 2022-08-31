package BeforeRefactoring;

import java.util.Date;

public class Pants extends ClothData{
	//Smell 24: Bad Code Smell Encapsulation - Deficient Encapsulation
	public String pantsModel;
	public String price;
	
	public Pants(String id, String type, String brand, Date promoStart, Date promoEnd, String pantsModel) {
		super(id, type, brand, promoStart, promoEnd);
		this.pantsModel = pantsModel;
	}

	public String getPantsModel() {
		return pantsModel;
	}

	//Smell 34: The Object Orientation Abuser - Refused Bequest
	//Smell 19: Abstraction Smell - Incomplete Abstraction
	public String getPrice() {
		price = "250.000";
		return price;
	}	

}
