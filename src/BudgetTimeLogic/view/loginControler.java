package BudgetTimeLogic.view;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TextField;
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
	private void handleCancle() {
		System.exit(0);
	}
	@FXML
	private void handleLogin() {
		String user1 = user.getText();
		String pass1 = pass.getText();
		if (user1.equals("andre") && pass1.equals("super") ){
			pleaseLog.setContentText("Login succesful!");
		}
		else{
			pleaseLog.setContentText("Invalid login");
		}
		
	}

}
