package AfterRefactoring;

import java.util.Date;

//Refactoring Smell 25: Modularization Smell - Broken Modularization
//Hapus class ClothData.java
public class Cloth {
	//Refactoring Smell 22: Bad Code Smell Encapsulation - Deficient Encapsulation
	private String id;
	private String type;
	private String brand;
	
	//Refactoring Smell 31: The Bloater - Data Clumps
	private PromoDateRange promoDateRange;
	
	public Cloth(String id, String type, String brand, Date promoStart, Date promoEnd) {
		super();
		this.id = id;
		this.type = type;
		this.brand = brand;
		this.promoDateRange = new PromoDateRange(promoStart, promoEnd);
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

	public PromoDateRange getPromoDateRange() {
		return promoDateRange;
	}
	
}
