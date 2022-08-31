package BeforeRefactoring;

//Smell 25: Modularization Smell - Broken Modularization
public class Cloth {
	private ClothData clothData;

	public ClothData getClothData() {
		return clothData;
	}

	public void setClothData(ClothData clothData) {
		this.clothData = clothData;
	}
}

