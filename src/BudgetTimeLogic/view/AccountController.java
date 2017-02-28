package BudgetTimeLogic.view;

import java.sql.PreparedStatement;
import java.util.Optional;

import com.mysql.jdbc.Connection;

import BudgetTimeLogic.MainApp;
import BudgetTimeLogic.model.DB;
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

	    	// Traditional way to get the response value.
	    	Optional<String> result = dialog.showAndWait();
	    	
	    if (result.isPresent()){
	    	NavigationController.loginP.firstName= result.get();
	    }
	    try
		{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con = (Connection) DB.getDataSource().getConnection(); 
			String query = "UPDATE Accounts SET FirstNAme= ? WHERE Password=? ";
			   

		      
			PreparedStatement ps=(PreparedStatement) con.prepareStatement(query);  
			ps.setString(1,NavigationController.loginP.firstName);  
			ps.setString(2,pass);
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
