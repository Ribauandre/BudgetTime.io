package BudgetTimeLogic.view;

import java.net.URL;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.Locale.Category;

import com.mysql.jdbc.Connection;

import java.util.Scanner;

import BudgetTimeLogic.MainApp;
import BudgetTimeLogic.model.CategoryModel;
import BudgetTimeLogic.model.DB;
import BudgetTimeLogic.model.LoginModel;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextInputDialog;
import javafx.scene.text.Text;

public class CategoryController implements Initializable{
	@FXML
	public Text FoodDrink;
	@FXML
	public Text Utilities;
	@FXML
	public Text Subscription;
	@FXML
	public Text Rent;
	@FXML
	public Text Travel;
	@FXML
	public Text GasFuel;
	@FXML
	public Text Savings;
	public static String user;
	double value;

	
	static ArrayList <CategoryModel> categories = new ArrayList(); 
	
	public void initialize(URL location, ResourceBundle resources) {
		double cat1 = percentCal(NavigationController.loginP.FoodDrink);
		double cat2 = percentCal(NavigationController.loginP.Utilities);
		double cat3 = percentCal(NavigationController.loginP.Subscription);
		double cat4 = percentCal(NavigationController.loginP.Rent);
		double cat5 = percentCal(NavigationController.loginP.Travel);
		double cat6 = percentCal(NavigationController.loginP.GasFuel);
		double cat7 = percentCal(NavigationController.loginP.Savings);
		
    	user = NavigationController.loginP.userName;
    	FoodDrink.setText(""+cat1);
    	Utilities.setText(""+cat2);
    	Subscription.setText(""+cat3);
    	Rent.setText(""+cat4);
    	Travel.setText(""+cat5);
    	GasFuel.setText(""+cat6);
    	Savings.setText(""+cat7);
   
    	
    	
    	
		
	}

	public void editFood(){
    	TextInputDialog dialog = new TextInputDialog("Food and Drink");
    	dialog.setTitle("Food and Drink");
    	dialog.setHeaderText("Edit Food and Drink");
    	dialog.setContentText("Please enter new Food and Drink percentage:");

    	Optional<String> result = dialog.showAndWait();
    	
    if (result.isPresent()){
    	value = Double.parseDouble(result.get());
    	NavigationController.loginP.FoodDrink= percentCaltoDub(value);
    }
    try
	{  
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con = (Connection) DB.getDataSource().getConnection(); 
		String query = "UPDATE Accounts SET FoodDrink = ? WHERE UserName=? ";
		   

	      
		PreparedStatement ps=(PreparedStatement) con.prepareStatement(query);  
		ps.setDouble(1,NavigationController.loginP.FoodDrink);  
		ps.setString(2,user);
		ps.execute();

		con.close();	
		MainApp.showAccount();
	     
	}
	catch(Exception e)
	{
		System.out.println(e);
	}  
  }
	public void editUtilities(){
    	TextInputDialog dialog = new TextInputDialog("Utilities");
    	dialog.setTitle("Utilities");
    	dialog.setHeaderText("Edit Utilities");
    	dialog.setContentText("Please enter new Utilities percentage:");

    	Optional<String> result = dialog.showAndWait();
    	
    if (result.isPresent()){
    	value = Double.parseDouble(result.get());
    	NavigationController.loginP.Utilities= percentCaltoDub(value);
    }
    try
	{  
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con = (Connection) DB.getDataSource().getConnection(); 
		String query = "UPDATE Accounts SET Utilities = ? WHERE UserName=? ";
		   

	      
		PreparedStatement ps=(PreparedStatement) con.prepareStatement(query);  
		ps.setDouble(1,NavigationController.loginP.Utilities);  
		ps.setString(2,user);
		ps.execute();

		con.close();	
		MainApp.showAccount();
	     
	}
	catch(Exception e)
	{
		System.out.println(e);
	}  
  }
	public void editSubscription(){
    	TextInputDialog dialog = new TextInputDialog("Subscription");
    	dialog.setTitle("Subscription");
    	dialog.setHeaderText("Edit Subscription");
    	dialog.setContentText("Please enter new Subscription percentage:");

    	Optional<String> result = dialog.showAndWait();
    	
    if (result.isPresent()){
    	value = Double.parseDouble(result.get());
    	NavigationController.loginP.Subscription= percentCaltoDub(value);
    }
    try
	{  
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con = (Connection) DB.getDataSource().getConnection(); 
		String query = "UPDATE Accounts SET Subscription = ? WHERE UserName=? ";
		   

	      
		PreparedStatement ps=(PreparedStatement) con.prepareStatement(query);  
		ps.setDouble(1,NavigationController.loginP.Subscription);  
		ps.setString(2,user);
		ps.execute();

		con.close();	
		MainApp.showAccount();
	     
	}
	catch(Exception e)
	{
		System.out.println(e);
	}  
  }
	public void editRent(){
    	TextInputDialog dialog = new TextInputDialog("Rent");
    	dialog.setTitle("Rent");
    	dialog.setHeaderText("Rent");
    	dialog.setContentText("Please enter new Rent percentage:");

    	Optional<String> result = dialog.showAndWait();
    	
    if (result.isPresent()){
    	value = Double.parseDouble(result.get());
    	NavigationController.loginP.Rent= percentCaltoDub(value);
    }
    try
	{  
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con = (Connection) DB.getDataSource().getConnection(); 
		String query = "UPDATE Accounts SET Rent = ? WHERE UserName=? ";
		   

	      
		PreparedStatement ps=(PreparedStatement) con.prepareStatement(query);  
		ps.setDouble(1,NavigationController.loginP.Rent);  
		ps.setString(2,user);
		ps.execute();

		con.close();	
		MainApp.showAccount();
	     
	}
	catch(Exception e)
	{
		System.out.println(e);
	}  
  }
	public void editTravel(){
    	TextInputDialog dialog = new TextInputDialog("Travel");
    	dialog.setTitle("Travel");
    	dialog.setHeaderText("Edit Travel");
    	dialog.setContentText("Please enter new Travel percentage:");

    	Optional<String> result = dialog.showAndWait();
    	
    if (result.isPresent()){
    	value = Double.parseDouble(result.get());
    	NavigationController.loginP.Travel= percentCaltoDub(value);
    }
    try
	{  
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con = (Connection) DB.getDataSource().getConnection(); 
		String query = "UPDATE Accounts SET Travel = ? WHERE UserName=? ";
		   

	      
		PreparedStatement ps=(PreparedStatement) con.prepareStatement(query);  
		ps.setDouble(1,NavigationController.loginP.Travel);  
		ps.setString(2,user);
		ps.execute();

		con.close();	
		MainApp.showAccount();
	     
	}
	catch(Exception e)
	{
		System.out.println(e);
	}  
  }
	public void editGasFueld(){
    	TextInputDialog dialog = new TextInputDialog("GasFuel");
    	dialog.setTitle("GasFuel");
    	dialog.setHeaderText("Edit GasFuel");
    	dialog.setContentText("Please enter new GasFuel percentage:");

    	Optional<String> result = dialog.showAndWait();
    	
    if (result.isPresent()){
    	value = Double.parseDouble(result.get());
    	NavigationController.loginP.GasFuel= percentCaltoDub(value);
    }
    try
	{  
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con = (Connection) DB.getDataSource().getConnection(); 
		String query = "UPDATE Accounts SET GasFuel = ? WHERE UserName=? ";
		   

	      
		PreparedStatement ps=(PreparedStatement) con.prepareStatement(query);  
		ps.setDouble(1,NavigationController.loginP.GasFuel);  
		ps.setString(2,user);
		ps.execute();

		con.close();	
		MainApp.showAccount();
	     
	}
	catch(Exception e)
	{
		System.out.println(e);
	}  
  }
	public void editSavings(){
    	TextInputDialog dialog = new TextInputDialog("Savings");
    	dialog.setTitle("Savings");
    	dialog.setHeaderText("Edit Savings");
    	dialog.setContentText("Please enter new Savings percentage:");

    	Optional<String> result = dialog.showAndWait();
    	
    if (result.isPresent()){
    	value = Double.parseDouble(result.get());
    	NavigationController.loginP.Savings= percentCaltoDub(value);
    }
    try
	{  
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con = (Connection) DB.getDataSource().getConnection(); 
		String query = "UPDATE Accounts SET Savings = ? WHERE UserName=? ";
		   

	      
		PreparedStatement ps=(PreparedStatement) con.prepareStatement(query);  
		ps.setDouble(1,NavigationController.loginP.Savings);  
		ps.setString(2,user);
		ps.execute();

		con.close();	
		MainApp.showAccount();
	     
	}
	catch(Exception e)
	{
		System.out.println(e);
	}  
  }
	double percentCal(double result){
		return result*100;
	}
	double percentCaltoDub(double result){
		return result/100;
	}
	@FXML
	 private void handleCancel() {
	    	MainApp.showNav();
	    }
	
	
	
}
