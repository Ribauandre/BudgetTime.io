package BudgetTimeLogic.model;

public class AccountModel{
	
	String username; 
	String password; 
	int accountID; 
	
	public String getUsername(){
		return username; 
	}
	
	public void setUsername(String userN){
		this.username = userN; 
	}
	
	public String getPassword(){
		return password; 
	}
	
	public void setPassword(String pwd){
		this.password = pwd; 
	}
	
	public int getAccountIDs(){
		return accountID; 
	}
	
	public void setAccountIDs(int acntID){
		this.accountID = acntID; 
	}
	
}
	