package BudgetTimeLogic.model;


public class CategoryModel {
	 
	String name;
	String description;
	double percentage; 
	
	 
	public CategoryModel(String n, String d, double p){
		name =n;
		description = d;
		percentage = p; 
		
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public double getPercentage() {
		return percentage;
	}


	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}
	
	
	
	
	
}
