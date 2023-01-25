package project;

//import java.io.BufferedReader;
//import java.io.FileReader;
import java.util.ArrayList;

public class ForListApp {
	
	static ArrayList<String> groceryList = new ArrayList<String>();
	static ArrayList<String> defaultList = new ArrayList<String>();
	
	public void addItemCategory(String cate) {
		
		groceryList.add(cate);
		
	}
	public void addItemName(String name) {
		
		groceryList.add(name);
		
	}
	public void addItemBrand(String brand) {
		
		groceryList.add(brand);
		
	}
	public void addItemPrice(String price) {
	
	groceryList.add("$" + price);
	
	}
	public void addItemExpire(String expire) {
	
	groceryList.add(expire);
	
	}
	public void addItemStatus(String status) {
	
	groceryList.add(status);
	
	}
	
	public static void printList(String name) {
		
		for(int i = groceryList.indexOf(name) - 1; i < groceryList.indexOf(name) + 5; i++) {
			
			System.out.print(groceryList.get(i) + " ");

		}
		
	}
	
	public static void printCate(String cate) {
		
		for(int i = groceryList.indexOf(cate); i < groceryList.indexOf(cate) + 6; i ++) {
			
			System.out.print(groceryList.get(i) + " ");

		}
	}
	
	public static void findCate(String cate) {
		
		for(int i = groceryList.indexOf(cate) + 1; i < groceryList.indexOf(cate) + groceryList.size(); i += 6) {
			
			System.out.print(groceryList.get(i) + " ");

		}
		
	}
	
	
	public String searchList(String name) {
		
		int index = groceryList.indexOf(name);
		
		if(index >= 0) {
			
			return groceryList.get(index);
		}
		
		else {
			
			return null;
			
		}
		
	}
	

}
