package BudgetTimeLogic.view;

import java.sql.PreparedStatement;

import com.mysql.jdbc.Connection;

import BudgetTimeLogic.model.DB;
import BudgetTimeLogic.model.Person;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
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

	   
	    public void setDialogStage(Stage dialogStage) {
	        this.dialogStage = dialogStage;
	    }

	   
	    


	    public boolean isOkClicked() {
	        return okClicked;
	    }

	   
	   
	    
	  

		
	  
			
			
			 
    
		

	    @FXML
	    private void handleCancel() {
	        dialogStage.close();
	    }

}
