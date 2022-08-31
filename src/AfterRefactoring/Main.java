package AfterRefactoring;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.Vector;

import BeforeRefactoring.ClothData;

public class Main {
	Scanner scan = new Scanner (System.in);
	Vector<Cloth> clothList = new Vector<>();
	
	private Date startPromo() {
		Date promoStart = null;
		SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy");
		while(promoStart==null){
		    try{
		        System.out.print("Input Promo Start Date [dd/MM/yyyy]: ");
		        String input = scan.nextLine();      
		        promoStart = DateFormat.parse(input);
		    }catch(ParseException e){
		    	System.out.println("Format must be [dd/MM/yyyy]");
		    }
		}
		return promoStart;
	}
	
	private Date endPromo() {
		Date promoEnd = null;
		SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy");
		while(promoEnd==null){
		    try{
		        System.out.print("Input Promo End Date [dd/MM/yyyy]: ");
		        String input = scan.nextLine();
		        promoEnd = DateFormat.parse(input);
		    }catch(ParseException e){
		    	System.out.println("Format must be [dd/MM/yyyy]");
		    }
		}
		return promoEnd;
	}
	
	//Refactoring Smell 27: The Dispensable - Long Method
	private void menu() {
		System.out.println("Welcome to ABC Cloth Shop Management System Application!");
		System.out.println("========================================================");
		System.out.println("1. Add New Cloth");
		System.out.println("2. View Cloth List");
		System.out.println("3. Remove Cloth");
		System.out.println("4. Exit");
		System.out.print("Choose: ");
	}
	
	private void chooseMenu() {//Refactoring Smell 4: The Object Orientation Abuser - Alternative Classes with Different Interfaces
		int choose;
		do {
			menu();
			choose = scan.nextInt();
			switch(choose) {
				case 1:
					addNewCloth();//Refactoring Smell 1: The Object Orientation Abuser - Alternative Classes with Different Interfaces
					break;
				case 2:
					viewClothList();//Refactoring Smell 2: The Object Orientation Abuser - Alternative Classes with Different Interfaces
					break;
				case 3:
					removeCloth();//Refactoring Smell 3: The Object Orientation Abuser - Alternative Classes with Different Interfaces
					break;
				case 4:
					System.out.println("Thank you for using this application!");
					System.exit(0);
					break;
				default:
					break;
			}
		}while(choose<1||choose>4);
	}

	//Refactoring Smell 28: The Dispensable - Long Method
	//Refactoring Smell 29: The Dispensable - Long Method
	private void view() {
		System.out.println();
		System.out.println("Cloth List");
		int count = 1;
		System.out.println("=========================");
		for(Cloth c : clothList) {
			SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy");
			String startdate = DateFormat.format(c.getPromoDateRange().getPromoStart());
			String enddate = DateFormat.format(c.getPromoDateRange().getPromoEnd());
			System.out.printf("No: %d\n", count);
			System.out.printf("Cloth ID: %s\n", c.getId());
			System.out.printf("Cloth Type: %s\n", c.getType());
			if(c instanceof Shirt) {
				System.out.printf("Cloth Model: %s\n", ((Shirt)c).getShirtModel());
			}
			else if(c instanceof Pants) {
				System.out.printf("Cloth Model: %s\n", ((Pants)c).getPantsModel());
			}
			System.out.printf("Cloth Brand: %s\n", c.getBrand());
			if(c instanceof Shirt) {
				System.out.printf("Cloth Price: Rp %s\n", ((Shirt)c).getPrice());
			}
			else if(c instanceof Pants) {
				System.out.printf("Cloth Price: Rp %s\n", ((Pants)c).getPrice());
			}
			System.out.printf("Cloth Promo Start: %s\n", startdate);
			System.out.printf("Cloth Promo End: %s\n", enddate);
			
			count++;
			System.out.println();
		}
	}

	private void removeCloth() {//Refactoring Smell 3: The Object Orientation Abuser - Alternative Classes with Different Interfaces
		if(clothList.isEmpty()) {
			System.out.println();
			System.out.println("No cloth added to the list yet.");
		}
		else {
			view();
			int clothRemove;
			do {
				System.out.print("Select cloth to remove [1 - " + clothList.size() + "]: ");
				clothRemove = scan.nextInt();
			}while(clothRemove<1||clothRemove>clothList.size());
			
			System.out.println();
			clothList.remove(clothRemove-1);
			//Refactoring Smell 36: The Couplers - Inappropriate Intimacy
			//Refactoring Smell 35: The Change Preventer - Shotgun Surgery
			RemoveClothSuccessMessage();
		}	
		//Refactoring Smell 7: The Dispensable - Duplicate Code
		System.out.println();
		chooseMenu();//Refactoring Smell 4: The Object Orientation Abuser - Alternative Classes with Different Interfaces
	}
	
	private void viewClothList() {//Refactoring Smell 2: The Object Orientation Abuser - Alternative Classes with Different Interfaces
		if(clothList.isEmpty()) {
			System.out.println();
			System.out.println("No cloth added to the list yet.");
			System.out.println();
		}
		else {
			view();
		}	
		//Refactoring Smell 8: The Dispensable - Duplicate Code
		chooseMenu();//Refactoring Smell 4: The Object Orientation Abuser - Alternative Classes with Different Interfaces
	}

	//Refactoring Smell 30: The Dispensable - Long Method
	private String generateID() {
		int ID2 = (int) Math.round(Math.random()*9);
		int ID3 = (int) Math.round(Math.random()*9);
		int ID4 = (int) Math.round(Math.random()*9);
		String IDS2 = Integer.toString(ID2);
		String IDS3 = Integer.toString(ID3);
		String IDS4 = Integer.toString(ID4);
		String IDSFinal = "-"+IDS2+IDS3+IDS4+"-";
		return IDSFinal;
	}
	
	private void addNewCloth() {//Refactoring Smell 1: The Object Orientation Abuser - Alternative Classes with Different Interfaces
		String type;
		String brand;
		String shirtModel;
		String pantsModel;
		
		do {
			System.out.print("Input Cloth Type [Shirt | Pants] (case sensitive): ");
			type = scan.next();
		}while(type.compareTo("Shirt")!=0&&type.compareTo("Pants")!=0);
	
		do {
			System.out.print("Input Cloth Brand [Zara | Uniqlo] (case sensitive): ");
			brand = scan.next();
		}while(brand.compareTo("Zara")!=0&&brand.compareTo("Uniqlo")!=0);
		scan.nextLine();
		Date promoStart = startPromo();
		Date promoEnd = endPromo();
		
		//Refactoring Smell 11: The Dispensable - Comment
		boolean typeIsEqualToShirt = type.compareTo("Shirt")==0;
		//Refactoring Smell 15: The Dispensable - Comment
		boolean typeIsEqualToPants = type.compareTo("Pants")==0;
		//Refactoring Smell 11: The Dispensable - Comment
		if(typeIsEqualToShirt) {
			do {
				System.out.print("Input Shirt Model [Camp | Dress | Poet ] (case sensitive): ");
				shirtModel = scan.next();
			}while(shirtModel.compareTo("Camp")!=0&&shirtModel.compareTo("Dress")!=0&&shirtModel.compareTo("Poet")!=0);
		
			String ID1 = "SHI";
			String ID2 = "";
			//Refactoring Smell 12: The Dispensable - Comment
			boolean shirtModelIsEqualToCamp = shirtModel.equals("Camp");
			//Refactoring Smell 13: The Dispensable - Comment
			boolean shirtModelIsEqualToDress = shirtModel.equals("Dress");
			//Refactoring Smell 14: The Dispensable - Comment
			boolean shirtModelIsEqualToPoet = shirtModel.equals("Poet");
			//Refactoring Smell 12: The Dispensable - Comment
			if(shirtModelIsEqualToCamp) {
				ID2 ="CAM";
			}
			//Refactoring Smell 13: The Dispensable - Comment
			else if(shirtModelIsEqualToDress) {
				ID2 ="DRE";
			}
			//Refactoring Smell 14: The Dispensable - Comment
			else if(shirtModelIsEqualToPoet) {
				ID2 ="POE";
			}
			
			String finalID = ID1+generateID()+ID2;		
			clothList.add(new Shirt(finalID, type, brand, promoStart, promoEnd, shirtModel));
			System.out.println();
			System.out.printf("Generated Cloth ID: %s\n", finalID);
			//Refactoring Smell 33: The Couplers - Feature Envy
			Shirt.NewShirtAddedSuccessMessage();
		}
		//Refactoring Smell 15: The Dispensable - Comment
		else if(typeIsEqualToPants) {
			do {
				System.out.print("Input Pants Model [Jeans | Shorts | Leggings] (case sensitive): ");
				pantsModel = scan.next();
			}while(pantsModel.compareTo("Jeans")!=0&&pantsModel.compareTo("Shorts")!=0&&pantsModel.compareTo("Leggings")!=0);
			
			String ID1 = "PAN";
			String ID2 = "";
			//Refactoring Smell 16: The Dispensable - Comment
			boolean pantsModelIsEqualToJeans = pantsModel.equals("Jeans");
			//Refactoring Smell 17: The Dispensable - Comment
			boolean pantsModelIsEqualToShorts = pantsModel.equals("Shorts");
			//Refactoring Smell 18: The Dispensable - Comment
			boolean pantsModelIsEqualToLeggings = pantsModel.equals("Leggings");
			//Refactoring Smell 16: The Dispensable - Comment
			if(pantsModelIsEqualToJeans) {
				ID2="JEA";
			}
			//Refactoring Smell 17: The Dispensable - Comment
			else if(pantsModelIsEqualToShorts) {
				ID2="SHO";
			}
			//Refactoring Smell 18: The Dispensable - Comment
			else if(pantsModelIsEqualToLeggings) {
				ID2="LEG";
			}
			
			String finalID = ID1+generateID()+ID2;
			clothList.add(new Pants(finalID, type, brand, promoStart, promoEnd, pantsModel));
			System.out.println();
			System.out.printf("Generated Cloth ID: %s\n", finalID);
			//Refactoring Smell 32: The Couplers - Feature Envy
			Pants.NewPantsAddedSuccessMessage();
		}
		//Refactoring Smell 9: The Dispensable - Duplicate Code
		//Refactoring Smell 6: The Dispensable - Lazy Class
		//Hapus class NewClothAddedSuccessMessage, methodnya, dan isinya
		//Pindahin isi method ke Main.java
		System.out.println("Success added new cloth!");
		System.out.println();
		chooseMenu();//Refactoring Smell 4: The Object Orientation Abuser - Alternative Class with Different Interfaces
	}
	
	//Refactoring Smell 5: The Dispensable - Speculative Generality
	//Hapus Method updateCloth
	
	//Refactoring Smell 10: The Dispensable - Dead Code
	//Hapus Method addNewClothTwo
	
	public Main() {
		chooseMenu();//Refactoring Smell 4: The Object Orientation Abuser - Alternative Classes with Different Interfaces
	}

	public static void main(String[] args) {
		new Main();
	}
	
	//Refactoring Smell 21: Abstraction Smell - Unutilized Abstraction -> Hapus class Underwear.java
	//Refactoring Smell 26: Hierarchy Smell - Speculative Hierarchy -> Hapus class Socks.java

	//Refactoring Smell 36: The Couplers - Inappropriate Intimacy
	//Refactoring Smell 35: The Change Preventer - Shotgun Surgery
	public static void RemoveClothSuccessMessage() {
		System.out.println("Cloth successfully removed!");
	}
}