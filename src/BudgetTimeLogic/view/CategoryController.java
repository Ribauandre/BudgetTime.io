package BudgetTimeLogic.view;

import java.util.ArrayList;
import java.util.Locale.Category;
import java.util.Scanner;

public class CategoryController {
	
	Scanner userInput = new Scanner (System.in);
 
	
	public void categoryModel(){
		ArrayList <String> category = new ArrayList <String>(); 
		category.add("Food & Drink");
		category.add("Gas & Fuel");
		category.add("Utilities");
		category.add("General Expenses"); 
		category.add("Rent");  
		category.add("Travel");
		category.add("Subscription"); 
		
	}
	
	public void addCategory(){
		ArrayList <String> category  = new <String> ArrayList(); 
		for (int i = 0; i <50; i++){
			String e = userInput.nextLine(); 
			category.add(e);
		}
		
	}
	
	
	public void removeCategory(){
		ArrayList <String> category = new <String> ArrayList(); 
		for (int i = 0; i <50; i++){
			int index = userInput.nextInt();
			category.remove(index); 
			
		}
	}
	
	public void getCategory(){
		System.out.println(Category.DISPLAY.name());
	}
}
