package BudgetTimeLogic.view;

import java.net.URL;
import java.sql.PreparedStatement;
import java.util.Optional;
import java.util.ResourceBundle;

import com.mysql.jdbc.Connection;

import BudgetTimeLogic.MainApp;
import BudgetTimeLogic.model.DB;
import BudgetTimeLogic.model.LoginModel;
import BudgetTimeLogic.model.Person;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextInputDialog;
import javafx.scene.text.Text;

public class editIncomeController implements Initializable {
	public static Person loginP = new Person(LoginModel.name, LoginModel.last, LoginModel.user, LoginModel.pass, LoginModel.budget);
	@FXML
	public Text budgetText;
	double bud;
	public static String name;
	public static String last;
	public static String user;
	public static String pass;
	public static double budget;
	double value;
	
	public void initialize(URL location, ResourceBundle resources) {
		LoginModel.logPerson(LoginModel.user, LoginModel.pass);
		loginP = new Person(LoginModel.name, LoginModel.last, LoginModel.user, LoginModel.pass, LoginModel.budget);
		user = NavigationController.loginP.userName;
		bud = loginP.budget;
		budgetText.setText(""+bud);
	}
	@FXML
	 private void handleCancel() {

		
	    	MainApp.showNav();
	    }
	@FXML
	 private void handleIncome() {
		TextInputDialog dialog = new TextInputDialog("Set new weekly income");
    	dialog.setTitle("Weekly Income");
    	dialog.setHeaderText("New income");
    	dialog.setContentText("Please enter your new weekly income :");

    	// Traditional way to get the response value.
    	Optional<String> result = dialog.showAndWait();
    	
    if (result.isPresent()){
    	value = Double.parseDouble(result.get());
    	NavigationController.loginP.budget = value;
    	
    }
    try
	{  
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con = (Connection) DB.getDataSource().getConnection(); 
		String query = "UPDATE Accounts SET Budget= ? WHERE UserName=? ";
		   

	      
		PreparedStatement ps=(PreparedStatement) con.prepareStatement(query);  
		ps.setDouble(1,value);  
		ps.setString(2,user);
		ps.execute();

		con.close();	
		MainApp.showIncomeEdit();
	     
	}
	catch(Exception e)
	{
		System.out.println(e);
	}  
  }
	    }

