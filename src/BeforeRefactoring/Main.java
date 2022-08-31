package BeforeRefactoring;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.Vector;

public class Main {
	Scanner scan = new Scanner (System.in);
	Vector<ClothData> clothList = new Vector<>();
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
	
	//Smell 27: The Dispensable - Long Method
	private void chsMn() {//Smell 4: The Object Orientation Abuser - Alternative Classes with Different Interfaces
		int choose;
		do {
			System.out.println("Welcome to ABC Cloth Shop Management System Application!");
			System.out.println("========================================================");
			System.out.println("1. Add New Cloth");
			System.out.println("2. View Cloth List");
			System.out.println("3. Remove Cloth");
			System.out.println("4. Exit");
			System.out.print("Choose: ");
			choose = scan.nextInt();
			switch(choose) {
				case 1:
					adNwClo();//Smell 1: The Object Orientation Abuser - Alternative Classes with Different Interfaces
					break;
				case 2:
					viCloLis();//Smell 2: The Object Orientation Abuser - Alternative Classes with Different Interfaces
					break;
				case 3:
					remClo();//Smell 3: The Object Orientation Abuser - Alternative Classes with Different Interfaces
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
	//Smell 28: The Dispensable - Long Method
	private void remClo() {//Smell 3: The Object Orientation Abuser - Alternative Classes with Different Interfaces
		if(clothList.isEmpty()) {
			System.out.println();
			System.out.println("No cloth added to the list yet.");
			//Smell 7: The Dispensable - Duplicate Code
			System.out.println();
			chsMn();//Smell 4: The Object Orientation Abuser - Alternative Classes with Different Interfaces
		}
		else {
			System.out.println();
			System.out.println("Cloth List");
			int count = 1;
			System.out.println("=========================");
			for(ClothData c : clothList) {
				SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy");
				String startdate = DateFormat.format(c.getPromoStart());
				String enddate = DateFormat.format(c.getPromoEnd());
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
			
			int clothRemove;
			do {
				System.out.print("Select cloth to remove [1 - " + clothList.size() + "]: ");
				clothRemove = scan.nextInt();
			}while(clothRemove<1||clothRemove>clothList.size());
			
			System.out.println();
			clothList.remove(clothRemove-1);
			//Smell 36: The Couplers - Inappropriate Intimacy
			//Smell 35: The Change Preventer - Shotgun Surgery
			ClothData.RemoveClothSuccessMessage();
			//Smell 7: The Dispensable - Duplicate Code
			System.out.println();
			chsMn();//Smell 4: The Object Orientation Abuser - Alternative Classes with Different Interfaces
		}	
	}
	//Smell 29: The Dispensable - Long Method
	private void viCloLis() {//Smell 2: The Object Orientation Abuser - Alternative Classes with Different Interfaces
		if(clothList.isEmpty()) {
			System.out.println();
			System.out.println("No cloth added to the list yet.");
			System.out.println();
			//Smell 8: The Dispensable - Duplicate Code
			chsMn();//Smell 4: The Object Orientation Abuser - Alternative Classes with Different Interfaces
		}
		else {
			System.out.println();
			System.out.println("Cloth List");
			int count = 1;
			System.out.println("=========================");
			for(ClothData c : clothList) {
				SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy");
				String startdate = DateFormat.format(c.getPromoStart());
				String enddate = DateFormat.format(c.getPromoEnd());
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
			//Smell 8: The Dispensable - Duplicate Code
			chsMn();//Smell 4: The Object Orientation Abuser - Alternative Classes with Different Interfaces
		}	
	}
	//Smell 30: The Dispensable - Long Method
	private void adNwClo() {//Smell 1: The Object Orientation Abuser - Alternative Classes with Different Interfaces
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
		
		//Smell 11: The Dispensable - Comment
		//jika type sama dengan Shirt
		if(type.compareTo("Shirt")==0) {
			do {
				System.out.print("Input Shirt Model [Camp | Dress | Poet ] (case sensitive): ");
				shirtModel = scan.next();
			}while(shirtModel.compareTo("Camp")!=0&&shirtModel.compareTo("Dress")!=0&&shirtModel.compareTo("Poet")!=0);
		
			String ID1 = "SHI";
			int ID2 = (int) Math.round(Math.random()*9);
			int ID3 = (int) Math.round(Math.random()*9);
			int ID4 = (int) Math.round(Math.random()*9);
			String IDS2 = Integer.toString(ID2);
			String IDS3 = Integer.toString(ID3);
			String IDS4 = Integer.toString(ID4);
			String IDS5 = "";
			//Smell 12: The Dispensable - Comment
			//jika shirtModel sama dengan Camp
			if(shirtModel.equals("Camp")) {
				IDS5="CAM";
			}
			//Smell 13: The Dispensable - Comment
			//jika shirtModel sama dengan Dress
			else if(shirtModel.equals("Dress")) {
				IDS5="DRE";
			}
			//Smell 14: The Dispensable - Comment
			//jika shirtModel sama dengan Poet
			else if(shirtModel.equals("Poet")) {
				IDS5="POE";
			}
			String finalID = ID1+"-"+IDS2+IDS3+IDS4+"-"+IDS5;
			
			clothList.add(new Shirt(finalID, type, brand, promoStart, promoEnd, shirtModel));
			System.out.println();
			System.out.printf("Generated Cloth ID: %s\n", finalID);
			//Smell 33: The Couplers - Feature Envy
			ClothData.NewShirtAddedSuccessMessage();
			//Smell 9: The Dispensable - Duplicate Code
			NewClothAddedSuccessMessage.NewClothAddedSuccessMessage();//Smell 6: The Dispensable - Lazy Class
			System.out.println();
			chsMn();//Smell 4: The Object Orientation Abuser - Alternative Classes with Different Interfaces
		}
		//Smell 15: The Dispensable - Comment
		//jika type sama dengan Pants
		else if(type.compareTo("Pants")==0) {
			do {
				System.out.print("Input Pants Model [Jeans | Shorts | Leggings] (case sensitive): ");
				pantsModel = scan.next();
			}while(pantsModel.compareTo("Jeans")!=0&&pantsModel.compareTo("Shorts")!=0&&pantsModel.compareTo("Leggings")!=0);
			
			String ID1 = "PAN";
			int ID2 = (int) Math.round(Math.random()*9);
			int ID3 = (int) Math.round(Math.random()*9);
			int ID4 = (int) Math.round(Math.random()*9);
			String IDS2 = Integer.toString(ID2);
			String IDS3 = Integer.toString(ID3);
			String IDS4 = Integer.toString(ID4);
			String IDS5 = "";
			//Smell 16: The Dispensable - Comment
			//jika pantsModel sama dengan Jeans
			if(pantsModel.equals("Jeans")) {
				IDS5="JEA";
			}
			//Smell 17: The Dispensable - Comment
			//jika pantsModel sama dengan Shorts
			else if(pantsModel.equals("Shorts")) {
				IDS5="SHO";
			}
			//Smell 18: The Dispensable - Comment
			//jika pantsModel sama dengan Leggings
			else if(pantsModel.equals("Leggings")) {
				IDS5="LEG";
			}
			String finalID = ID1+"-"+IDS2+IDS3+IDS4+"-"+IDS5;
			
			clothList.add(new Pants(finalID, type, brand, promoStart, promoEnd, pantsModel));
			System.out.println();
			System.out.printf("Generated Cloth ID: %s\n", finalID);
			//Smell 32: The Couplers - Feature Envy
			ClothData.NewPantsAddedSuccessMessage();
			//Smell 9: The Dispensable - Duplicate Code
			NewClothAddedSuccessMessage.NewClothAddedSuccessMessage(); //Smell 6: The Dispensable - Lazy Class
			System.out.println();
			chsMn();//Smell 4: The Object Orientation Abuser - Alternative Classes with Different Interfaces
		}
	}

	private void updateCloth() {//Smell 5: The Dispensable - Speculative Generality
		
	}
	
	private void addNewClothTwo() {//Smell 10: The Dispensable - Dead Code
		
	}
	
	public Main() {
		chsMn();//Smell 4: The Object Orientation Abuser - Alternative Classes with Different Interfaces
	}

	public static void main(String[] args) {
		new Main();
	}

}
