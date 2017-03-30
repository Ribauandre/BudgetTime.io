package BudgetTimeLogic.view;

import java.util.ArrayList;
import java.util.Locale.Category;
import java.util.Scanner;

import BudgetTimeLogic.model.CategoryModel;

public class CategoryController {
	
	Scanner userInput = new Scanner(System.in); 
	Scanner descriptionAddition = new Scanner(System.in); 

	
	static ArrayList <CategoryModel> categories = new ArrayList(); 
	 
	public CategoryController(){
		
		
	}
	
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
	
	public void editCategory(){
		String search = userInput.nextLine(); 
		String editName = userInput.nextLine();
		String editDescription = userInput.nextLine();
		double editPercentage = userInput.nextDouble();
		for(int i=0;i<categories.size(); i++){
			if(categories.get(i).getName().contains(search)){
				categories.get(i).setName(editName);
				categories.get(i).setDescription(editDescription);
				categories.get(i).setPercentage(editPercentage);
			}
			
		}
		
	}

	}