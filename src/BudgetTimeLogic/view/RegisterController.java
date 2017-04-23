package BudgetTimeLogic.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.PreparedStatement;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;

import BudgetTimeLogic.model.AccountModel;
import BudgetTimeLogic.model.DB;
import BudgetTimeLogic.model.Person;


public class RegisterController {

    @FXML
    private TextField firstNameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private TextField userNameField;
    @FXML
    private TextField passField;
    @FXML
    private TextField veryPass;


    private Stage dialogStage;
    private Person person;
    private boolean okClicked = false;

  
    @FXML
    private void initialize() {
    }

   
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

   
    public void setPerson(Person person) {
        this.person = person;

        firstNameField.setText(person.getFirstName());
        lastNameField.setText(person.getLastName());
        userNameField.setText(person.getFirstName());
        passField.setText(person.getLastName());
       
    }


    public boolean isOkClicked() {
        return okClicked;
    }

    @FXML
    private void handleOk() {
        if (isInputValid()) {
            person.setFirstName(firstNameField.getText());
            person.setLastName(lastNameField.getText());
            person.setUserName(userNameField.getText());
            person.setPass(passField.getText());

            okClicked = true;
            
            //add to the database
            }
      
            dialogStage.close();
        }
    
  
  public void addNewUser(){ 

    String name = firstNameField.getText();
    String last = lastNameField.getText();
    String user = userNameField.getText();
    String pass = passField.getText();
	
    try
	{  
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con = (Connection) DB.getDataSource().getConnection(); 
		String query = " insert into Accounts (FirstNAme, LastName, UserName, Password, Budget, FoodDrink, Utilities, Subscription, Rent, Travel, GasFuel, Savings )"
		        + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	      
		PreparedStatement ps=(PreparedStatement) con.prepareStatement(query);  
		ps.setString(1,name);  
		ps.setString(2,last);
		ps.setString(3,user);  
		ps.setString(4,pass);
		ps.setDouble(5, 0.0);
		ps.setDouble(6, 0.10);
		ps.setDouble(7, 0.20);
		ps.setDouble(8, 0.05);
		ps.setDouble(9, 0.30);
		ps.setDouble(10, 0.02);
		ps.setDouble(11, 0.10);
		ps.setDouble(12, 0.10);
		
		
		 
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

    @FXML
    private void handleCancel() {
        dialogStage.close();
    }


    private boolean isInputValid() {
        String errorMessage = "";

        if (firstNameField.getText() == null || firstNameField.getText().length() == 0) {
            errorMessage += "No valid first name!\n"; 
        }
        if (lastNameField.getText() == null || lastNameField.getText().length() == 0) {
            errorMessage += "No valid last name!\n"; 
        }
        if (userNameField.getText() == null || userNameField.getText().length() == 0) {
            errorMessage += "No valid UserName"; 
        }

        if (passField.getText() == null || passField.getText().length() == 0) {
            errorMessage += "No valid Pass"; 
        } 
        
        if (!passField.getText().equals(veryPass.getText()) )
        {
            // Show the error message.
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);

            alert.showAndWait();

        }
        else {
        	return true; 
        }
        
		return okClicked;
    }
}