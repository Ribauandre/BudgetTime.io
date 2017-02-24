package BudgetTimeLogic.model;

public class BudgetModel {
	
	double income; 
	double expectedExpense; 
	double savings;
	double freeMoney; 
	
	public void budget(double cashflow, double save, double ballOut, double monthlyExpenses){
		
		income = cashflow;
		
		//Expected expenses like power and utility
		monthlyExpenses =  income * 0.5; 
		expectedExpense = monthlyExpenses;
		
		// amount they should save per month 
		save = 0.3 * income;
		savings = save;
		
		//amount to spend drinking :)
		ballOut = 0.2 * income; 
		freeMoney = ballOut; 
		
		
	
		
	}
	
	public double getIncome(){
		return income;
	}
	
	public void setIncome(double cashflow){
	this.income = cashflow;
	}
	
	public double getExpectedExpenses(){
		return expectedExpense;
	}
	
	public void setExpectedExpenses(double monthlyExpenses){
		this.expectedExpense = monthlyExpenses;
	}
	
	public double getFreeMoney(){
		return freeMoney; 
	}
	
	public void setFreeMoney(double ballOut){
		this.freeMoney = ballOut; 
	}
	public double getSavings(){
		return savings;
	}
	
	public void setSaveMoney(double save){
		this.savings = save; 
	}
}

