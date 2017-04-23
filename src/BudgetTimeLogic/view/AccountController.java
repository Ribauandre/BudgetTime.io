package BudgetTimeLogic.view;

import java.sql.PreparedStatement;
import java.util.Optional;

import com.mysql.jdbc.Connection;

import BudgetTimeLogic.MainApp;
import BudgetTimeLogic.model.DB;
import BudgetTimeLogic.model.LoginModel;
import BudgetTimeLogic.model.Person;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.text.Text;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class AccountController {
	 	@FXML
	    private Text firstNameField;
	    @FXML
	    private Text lastNameField;
	    @FXML
	    private Text userNameField;
	    @FXML
	    private Text passField;
	    public static String name;
		public static String last;
		public static String user;
		public static String pass;


	    private Stage dialogStage;
	    private Person person;
	    private boolean okClicked = false;

	  
	    @FXML
	    private void initialize() {
	    	LoginModel.logPerson(LoginModel.user, LoginModel.pass);
	    	name = NavigationController.loginP.firstName;
	    	firstNameField.setText(name);
	    	last = NavigationController.loginP.lastName;
	    	lastNameField.setText(last);
	    	user = NavigationController.loginP.userName;
	    	userNameField.setText(user);
	    	pass = NavigationController.loginP.getPass();
	    	passField.setText(pass);
	    	
	    	
	    	
	    }
	    public void editFName(){
	    	TextInputDialog dialog = new TextInputDialog("First Name");
	    	dialog.setTitle("First Name");
	    	dialog.setHeaderText("Edit First Name");
	    	dialog.setContentText("Please enter your first name:");

	    	Optional<String> result = dialog.showAndWait();
	    	
	    if (result.isPresent()){
	    	NavigationController.loginP.firstName= result.get();
	    }
	    try
		{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con = (Connection) DB.getDataSource().getConnection(); 
			String query = "UPDATE Accounts SET FirstNAme= ? WHERE UserName=? ";
			   

		      
			PreparedStatement ps=(PreparedStatement) con.prepareStatement(query);  
			ps.setString(1,NavigationController.loginP.firstName);  
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
	    public void editLName(){
	    	TextInputDialog dialog = new TextInputDialog("Last Name");
	    	dialog.setTitle("Last Name");
	    	dialog.setHeaderText("Edit Last Name");
	    	dialog.setContentText("Please enter your Last name:");

	    	// Traditional way to get the response value.
	    	Optional<String> result = dialog.showAndWait();
	    	
	    if (result.isPresent()){
	    	NavigationController.loginP.lastName= result.get();
	    }
	    try
		{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con = (Connection) DB.getDataSource().getConnection(); 
			String query = "UPDATE Accounts SET LastName= ? WHERE UserName=? ";
			   

		      
			PreparedStatement ps=(PreparedStatement) con.prepareStatement(query);  
			ps.setString(1,NavigationController.loginP.lastName);  
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
	    public void editPass(){
	    	TextInputDialog dialog = new TextInputDialog("Set new password");
	    	dialog.setTitle("Password");
	    	dialog.setHeaderText("New Password");
	    	dialog.setContentText("Please enter your new Password:");

	    	// Traditional way to get the response value.
	    	Optional<String> result = dialog.showAndWait();
	    	
	    if (result.isPresent()){
	    	NavigationController.loginP.pass= result.get();
	    }
	    try
		{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con = (Connection) DB.getDataSource().getConnection(); 
			String query = "UPDATE Accounts SET Password= ? WHERE UserName=? ";
			   

		      
			PreparedStatement ps=(PreparedStatement) con.prepareStatement(query);  
			ps.setString(1,NavigationController.loginP.pass);  
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

	   
	    public void setDialogStage(Stage dialogStage) {
	        this.dialogStage = dialogStage;
	    }

	   
	    


	    public boolean isOkClicked() {
	        return okClicked;
	    }

	   

	    @FXML
	    private void handleCancel() {
	    	MainApp.showNav();
	    }
	   

}
