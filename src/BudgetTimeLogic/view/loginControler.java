package BudgetTimeLogic.view;


import java.io.IOException;

import BudgetTimeLogic.MainApp;
import BudgetTimeLogic.model.LoginModel;
import BudgetTimeLogic.model.Person;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;
public class loginControler {
	@FXML
    private TextField user;
    @FXML
    private TextField pass;
    @FXML
    private DialogPane pleaseLog;
    @FXML
    private Button loginButton;
    @FXML
    private Button cancelButton;
    @FXML
    private Button registerButton;
    
	
	@FXML
	private void handleCancle() {
		System.exit(0);
	}
	@FXML
	private void handleLogin() {
		String user1 = user.getText();
		String pass1 = pass.getText();
		if (LoginModel.validate(user1, pass1)){
			pleaseLog.setContentText("Login succesful!");
		}
		else{
			pleaseLog.setContentText("Invalid login");
		}
		
	}
	@FXML
	private void handleRegister() {
	        boolean okClicked = MainApp.showPersonEditDialog();
	        if (okClicked) {
	        	MainApp.showPersonEditDialog();
	        

	    } 
	}
}

