package BudgetTimeLogic;

import java.sql.PreparedStatement;

import com.mysql.jdbc.Connection;

import BudgetTimeLogic.model.BudgetModel;
import BudgetTimeLogic.model.DB;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;


public class NavigationController {

	// Budget 
	// Account View
    @FXML
    private TextField incomeField;
    @FXML
    private TextField savingsField;
    @FXML
    private TextField freeMoneyField;
    @FXML
    private TextField expectedExpenseField;
    
   BudgetModel budget = new BudgetModel(); 
   
   
	
	public void inputBudget(){
		String url = "jdbc:mysql://sql9.freemysqlhosting.net:3306/sql9160018";
	    String usname = "sql9160018";
	    String password = "TqN3ywM94V";
	    budget.setIncome(incomeField.getLength());  
	    budget.setFreeMoney(freeMoneyField.getLength());
	    budget.setSaveMoney(savingsField.getLength());
	    budget.setExpectedExpenses(expectedExpenseField.getLength()); 
	    
	    try
		{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con = (Connection) DB.getDataSource().getConnection(); 
			String query = " insert into Accounts (FirstNAme, LastName, UserName, Password, Income, FreeMoney, SaveMoney, ExpectedExpenses)"
			        + " values (?, ?, ?, ?, ?, ?, ?, ?)";

		      
			PreparedStatement ps=(PreparedStatement) con.prepareStatement(query);  
			ps.setDouble(5, 0.0);
			ps.setDouble(6, 0.0);
			ps.setDouble(7, 0.0);
			ps.setDouble(8,0.0);
			
			
			
			 
		if (isInputValid()){
			ps.execute();
			dialogStage.close();
			Alert alert = new Alert(AlertType.INFORMATION);
	        alert.initOwner(dialogStage);
	        alert.setTitle("BudgetTime.IO");
	        alert.setHeaderText("Succsess!");
	        alert.setContentText("Regestration Succsesfull.");

	        alert.showAndWait();
		}
		con.close();	
			     
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	    
	}
	
	
	public boolean isInputValid(){
		
		if 
		return false;
		
	}

	
}
