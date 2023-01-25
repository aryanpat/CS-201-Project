package project;

import java.io.IOException;
import java.util.Scanner;

public class ListApp {
	
	static Scanner input = new Scanner(System.in);
	static public ForListApp groceryList = new ForListApp();
	

	public static void main(String[] args) throws IOException {
		
		//Default List inside of the App before User Input occurs
		
		groceryList.addItemCategory("Categories");
		groceryList.addItemCategory("Food");
		groceryList.addItemName("Pizza");
		groceryList.addItemBrand("Jack's");
		groceryList.addItemPrice("7.12");
		groceryList.addItemExpire("6/12");
		groceryList.addItemStatus("In-Store");
		groceryList.addItemCategory("Footwear");
		groceryList.addItemName("Shoes");
		groceryList.addItemBrand("Nike");
		groceryList.addItemPrice("103.17");
		groceryList.addItemExpire("N/A");
		groceryList.addItemStatus("In-Store");
		groceryList.addItemCategory("Drink");
		groceryList.addItemName("Soda");
		groceryList.addItemBrand("Pepsi");
		groceryList.addItemPrice("1.24");
		groceryList.addItemExpire("2/12");
		groceryList.addItemStatus("In-Store");
		groceryList.addItemCategory("Fruit");
		groceryList.addItemName("Apple");
		groceryList.addItemBrand("Gala-Apple");
		groceryList.addItemPrice("2.12");
		groceryList.addItemExpire("8/12");
		groceryList.addItemStatus("In-Store");
		
		
		
		int end = 0; //Will be used later to terminate the App
		int choice = 0; //Used for the Switch choices
		userManual();
		
		//Switch loop, this is what runs the App
		
		while(end != -1) {
			
			System.out.println("Welcome To The Main Menu. Press 0 to See the User Manual."); 
			choice = input.nextInt();
			input.nextLine();
			
			switch(choice) {
			
			case 0: //Can make it so by pressing User Manual this triggers
				
				System.out.println(" ");
				
				userManual(); //Prints the User Manual
				
				
				break;
			
			case 1: //By pressing add an item a new item can be added
				
				System.out.println(" ");
				
				addItem(); //Will prompt User Input, letting User add items
				
				System.out.println("\nPress 5 to add another item! Or press 0 to return to User Manual."); //Add more items
				choice = input.nextInt();
				
				if(choice == 0) { //If they decide to return to User Manual this will occur
					userManual(); 
				}
				
				while(choice != 5 && choice != 0) { //If neither 5 or 0 are pressed, then this statement will occur. It will repeat until user presses either 5 or 0.
					System.out.println("\nSorry invalid input. Please press 5 to add another item! Or press 0 to return to Main Menu.");
					choice = input.nextInt();
				}
				
				
				
			case 5: //Lets user add another item
				
				
				while(choice == 5) { //Loop that will repeat, letting User add items until User wishes to return to User Manual
					
					if(choice == 5) {
					
						addItem();
				
						System.out.println("\nPress 5 to add another item! Or press 0 to return to User Manual.");
						choice = input.nextInt();
					
					}
				
					if(choice != 5) {
						
						while(choice != 5 && choice != 0) { //In case of invalid input
						
							System.out.println("\nSorry invalid input. Please press 5 to add another item! Or press 0 to return to User Manual.");
							choice = input.nextInt();
						
						}
						
					}
				
					if(choice == 0) {
						
						userManual();
						
					}
				
				}
				
				break;
				
				
			case 2: //By pressing search you can then search for the item you want to look for.
				
				System.out.println(" ");
				
				search(); //Lets the user search through the Array List using the name of their entered product. Will print all details about said product.
				
				System.out.println("\nPress 6 to search for another item! Or press 0 to return to User Manual."); //Same as before this lets User keep searching or return to Manual.
				choice = input.nextInt();
				
				if(choice == 0) {
					
					userManual();
				
				}
				
				while(choice != 6 && choice != 0) { //Same as before will occur if neither 6 or 0 are pressed, until either is pressed
					
					System.out.println("\nSorry invalid input. Please press 6 to search for another item! Or press 0 to return to User Manual.");
					choice = input.nextInt();
					
				}
				
				
				
			case 6: //Lets user search for another item
				
				while(choice == 6) { //Will repeat until User decides to return to Manual
					
					if(choice == 6) {
					
						search();
				
						System.out.println("\nPress 6 to search for another item! Or press 0 to return to User Manual.");
						choice = input.nextInt();
					
					}
				
					if(choice != 6) {
						
						while(choice != 6 && choice != 0) { //In case of invalid input
						
							System.out.println("\nSorry invalid input. Please press 6 to search for another item! Or press 0 to return to User Manual.");
							choice = input.nextInt();
						
						}
						
					}
				
					if(choice == 0) { //Returns user to Manual
						
						ListApp.userManual();
						
					}
				
				}
				
				break;
				
				
				
			case 3: //Will let user search by categories by clicking on the categories
				
				searchCate();
				System.out.println(" ");
				System.out.println("\nWould you like to see the info of the items in these categories? If so press 7! Or press 0 to return to User Manual.");
				choice = input.nextInt();
				
				if(choice == 0) {
					
					userManual();
					
				}
				
				while(choice != 7 && choice != 0) { //Same as before will occur if neither 6 or 0 are pressed, until either is pressed
					
					System.out.println("\nSorry invalid input. Please press 7 to get more info! Or press 0 to return to User Manual.");
					choice = input.nextInt();
					
				}

				
				
			case 7:
				
				System.out.println("Choose the category that you want more info on!");
				String moreInfo = input.next();
				
					
				
				while(moreInfo != null){
					
					if(groceryList.searchList(moreInfo) != null) {
					
						System.out.print("Your category has the following info: ");
						ForListApp.printCate(moreInfo); //This will print the item that the User searches for
						
					
						moreInfo = null;
			
					}
				
					else{
					
						System.out.println("There is no item under " + moreInfo + " in your list. Please type the Uppercase character Y to try again! Or type the Uppercase charcter N to end this search.");//Prints if item not found, User can then try again or quit
						char retry = input.next().charAt(0);
						
						boolean fail = true;
						
						while(fail == true) {
							
							if(retry == 'Y') {
							
								ListApp.searchCate();
								fail = false;
								break;
							
							}
						
							if(retry == 'N') {
							
								fail = false;
								moreInfo = null;
								break;
							
							}
						
							if(retry != 'Y' && retry != 'N') {
							
								System.out.println("Invalid input type Y to retry, or type N to end this search.");
								retry = input.next().charAt(0);
								fail = true;
							
							}
						
						}
					
					}
					
					break;
					
				}
				
				System.out.println(" ");
				System.out.println("\nWould you like to get more info on another category? If so press 8. Or press 0 to return to the User Manual.");
				choice = input.nextInt();
				
				if(choice == 0) {
					
					userManual();
					
				}
				
				while(choice != 8 && choice != 0) { //Same as before will occur if neither 6 or 0 are pressed, until either is pressed
					
					System.out.println("\nSorry invalid input. Please press 8 to get more info! Or press 0 to return to User Manual.");
					choice = input.nextInt();
					
				}
				
				//break;
				
			case 8:
				
				while(choice == 8) { //Will repeat until User decides to return to Manual
					
					if(choice == 8) {
						
						System.out.println(" ");
						System.out.println("Enter the next category you want more info on!");
						moreInfo = input.next();
						
						if(groceryList.searchList(moreInfo) != null) {
							
							System.out.println(" ");
							System.out.print("Your category has the following info: ");
							ForListApp.printCate(moreInfo); //This will print the item that the User searches for
							
							System.out.println(" ");
							System.out.println("Press 8 to search for another item! Or press 0 to return to User Manual.");
							choice = input.nextInt();
							
				
						}
					
					}
					
				
					if(choice != 8) {
						
						while(choice != 8 && choice != 0) { //In case of invalid input
						
							System.out.println("\nSorry invalid input. Please press 8 to search for another item! Or press 0 to return to User Manual.");
							choice = input.nextInt();
						
						}
						
					}
					
				
					if(choice == 0) { //Returns user to Manual
						
						ListApp.userManual();
						
					}
					
					break;
				
				}
				
				break;
			
			case 4: //Can be a button that lets user end the task
				
				System.out.println(" ");
				System.out.println("Thank you for using Go Go Groceries! Have a nice day!"); //Prints after User decides to exit the app
				
				end = -1;
				
				break;
			
			}
			
		}
		
	}
	
	//Linked to the case tree, will help User navigate the "List App" 
	
	public static void userManual() {
		
		System.out.println("Press: ");
		System.out.println("1 - To Add an Item to your Grocery List."); //User presses 1 to add an item
		System.out.println("2 - To Search for an Item in your Grocery List."); //User presses 2 to search for an item by name
		System.out.println("3 - To Search through your list by categories."); //User presses 3 to search for an item by category
		System.out.println("4 - To end the List App."); //User presses 4 to end the app
		System.out.println(" ");
		
	}
	
	//Gets user input and then puts it into the ArrayList
	
	public static void addItem() {
		
		System.out.println("Enter your items Category."); //User input for item category
		groceryList.addItemCategory(input.next());
		
		System.out.println("Enter your items Name."); //User input for item name
		groceryList.addItemName(input.next());
		
		System.out.println("Enter your items Brand."); //User input for item brand
		groceryList.addItemBrand(input.next());
		
		System.out.println("Enter your items Price."); //User input for item price
		groceryList.addItemPrice(input.next());
		
		System.out.println("Enter your items Expiration."); //User input or item expiration
		groceryList.addItemExpire(input.next());
		
		System.out.println("Enter your items Status."); //User input for item status
		groceryList.addItemStatus(input.next());
		
		System.out.println("Your item has been succesfully added!"); //Will print after all Product / Item, fields are filled. Letting User know that the item has been added.
		
	}
	
	//Class made to search the ArrayList for an item
	
	public static void search() {
		
		
		System.out.println("What item would you like to search for?"); //User input for what item they want to search
		String search = input.next();
		
		while(search != null){
			
			if(groceryList.searchList(search) != null) {
			
				System.out.println(search + " was found in your list!"); //Will print to tell User that their item was found
				System.out.print(search + " had the following details: ");
				ForListApp.printList(search); //This will print the item that the User searches for
			
				search = null;
	
			}
		
			else{
			
				System.out.println("There is no item under " + search + " in your list. Please type the Uppercase character Y to try again! Or type the Uppercase charcter N to end this search.");//Prints if item not found, User can then try again or quit
				char retry = input.next().charAt(0);
				
				boolean fail = true;
				
				while(fail == true) {
					
					if(retry == 'Y') {
					
						ListApp.search();
						fail = false;
						break;
					
					}
				
					if(retry == 'N') {
					
						fail = false;
						search = null;
						break;
					
					}
				
					if(retry != 'Y' && retry != 'N') {
					
						System.out.println("Invalid input type Y to retry, or type N to end this search.");
						retry = input.next().charAt(0);
						fail = true;
					
					}
				
				}
			
			}
			
			break;
			
		}
		
	}
	
	public static void searchCate() {
		
		System.out.println("Please enter 'Categories' in order to see all product Categories!");
		String searchCate = input.next();
		
		while(searchCate != null){
			
			if(groceryList.searchList(searchCate) != null) {
			
				System.out.print("Your list has the following categories: ");
				ForListApp.findCate(searchCate); //This will print the item that the User searches for
				
			
				searchCate = null;
	
			}
		
			else{
			
				System.out.println("There is no item under " + searchCate + " in your list. Please type the Uppercase character Y to try again! Or type the Uppercase charcter N to end this search.");//Prints if item not found, User can then try again or quit
				char retry = input.next().charAt(0);
				
				boolean fail = true;
				
				while(fail == true) {
					
					if(retry == 'Y') {
					
						ListApp.searchCate();
						fail = false;
						break;
					
					}
				
					if(retry == 'N') {
					
						fail = false;
						searchCate = null;
						break;
					
					}
				
					if(retry != 'Y' && retry != 'N') {
					
						System.out.println("Invalid input type Y to retry, or type N to end this search.");
						retry = input.next().charAt(0);
						fail = true;
					
					}
				
				}
			
			}
			
			break;
			
		}
		
		
	}
	
}

