package BudgetTimeLogic.view;

import java.util.ArrayList;
import java.util.Locale.Category;
import java.util.Scanner;

import BudgetTimeLogic.model.CategoryModel;

public class CategoryController {
	
	Scanner userInput = new Scanner(System.in); 
	Scanner descriptionAddition = new Scanner(System.in); 

	
	ArrayList <CategoryModel> categories = new ArrayList(); 
	CategoryModel FoodDrink = new CategoryModel("Food & Drink", "Budgetting for Food & Drink Beverages. Alloting 10%", 0.10);  
	CategoryModel Utilities = new CategoryModel("Utilities", "Budgetting for Utilities like power, electricity, etc. Alloting 20%", 0.20);
	CategoryModel Subscription = new CategoryModel("Subscription", "Budgetting for user subscriptions like Netflix, Apple Music, Hulu, etc.", 0.05); 
	CategoryModel Rent = new CategoryModel("Rent","Budgetting for rent or housing", 0.30); 
	CategoryModel Travel = new CategoryModel("Travel","Budget for any travel expenses", 0.10);
	CategoryModel GasFuel = new CategoryModel("Gas & Fuel", "Budgetting for gas for automobiles", 0.10); 
	CategoryModel  Savings = new CategoryModel("Savings","Setting aside money for savings", 0.15); 
	
	public void searchCategory(){
		String search = userInput.nextLine();
		for (int i=0; i < categories.size(); i++){
			if (categories.get(i).getName().contains(search)){
				System.out.println(categories); 
			}
			else {
				System.out.println("No category found, please try again");
			}
			
		}
	}
	

	}