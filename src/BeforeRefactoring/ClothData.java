package BeforeRefactoring;

import java.util.Date;

//Smell 25: Modularization Smell - Broken Modularization
public class ClothData {

	//Smell 22: Bad Code Smell Encapsulation - Deficient Encapsulation
	public String id;
	public String type;
	public String brand;
	
	//Smell 31: The Bloater - Data Clumps
	private Date promoStart; // Data Clumps
	private Date promoEnd; // Data Clumps
	
	public ClothData(String id, String type, String brand, Date promoStart, Date promoEnd) {
		super();
		this.id = id;
		this.type = type;
		this.brand = brand;
		this.promoStart = promoStart;
		this.promoEnd = promoEnd;
	}
	
	public String getId() {
		return id;
	}

	public String getType() {
		return type;
	}

	public String getBrand() {
		return brand;
	}

	public Date getPromoStart() {
		return promoStart;
	}

	public Date getPromoEnd() {
		return promoEnd;
	}
	
	//Smell 32: The Couplers - Feature Envy
	public static void NewPantsAddedSuccessMessage() {
		System.out.println("Success added new pants!");
	}
	
	//Smell 33: The Couplers - Feature Envy
	public static void NewShirtAddedSuccessMessage() {
		System.out.println("Success added new shirt!");
	}
	
	//Smell 36: The Couplers - Inappropriate Intimacy
	//Smell 35: The Change Preventer - Shotgun Surgery
	public static void RemoveClothSuccessMessage() {
		System.out.println("Cloth successfully removed!");
	}
	
	
}
