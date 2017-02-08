package BudgetTimeLogic.model;

public class RegisterModel {
	


	String firstName; 
	String lastName; 
	String username;
	String password; 
	
	public void RegisterAccount(String fName, String lName, String uName, String pword){
		firstName = fName;
		lastName = lName; 
		username = uName;
		password = pword; 
	}
	
	public String getFirstName(){
		return firstName; 
	}
	
	public void setFirstName(String fName){
		this.firstName = fName; 
	}
	
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lName) {
		this.lastName = lName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String uName) {
		this.username = uName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String pword) {
		this.password = pword;
	}
	
	// Need some logic here correct? Need to create a method that takes in user input for specific variables. 
}
