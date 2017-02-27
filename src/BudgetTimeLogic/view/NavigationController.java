package BudgetTimeLogic.view;

import java.net.URL;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;

import com.mysql.jdbc.Connection;

import BudgetTimeLogic.MainApp;
import BudgetTimeLogic.model.BudgetModel;
import BudgetTimeLogic.model.DB;
import BudgetTimeLogic.model.LoginModel;
import BudgetTimeLogic.model.Person;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.DialogPane;

public class NavigationController{

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
	public static Person loginP = new Person(LoginModel.name, LoginModel.last, LoginModel.user, LoginModel.pass, LoginModel.budget);
	@FXML
	BudgetModel budget = new BudgetModel();
	@FXML
	static
	public Text accountName;
	
	public void initialize() {
		
		
		
        
		
    }
	public void setName(){
		String name = loginP.firstName+" "+loginP.lastName;
		System.out.println(accountName.getText());
	}


	public void inputBudget() {
		String url = "jdbc:mysql://sql9.freemysqlhosting.net:3306/sql9160018";
		String usname = "sql9160018";
		String password = "TqN3ywM94V";
		budget.setIncome(incomeField.getLength());
		budget.setFreeMoney(freeMoneyField.getLength());
		budget.setSaveMoney(savingsField.getLength());
		budget.setExpectedExpenses(expectedExpenseField.getLength());

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = (Connection) DB.getDataSource().getConnection();
			String query = " insert into Accounts (FirstNAme, LastName, UserName, Password, Income, FreeMoney, SaveMoney, ExpectedExpenses)"
					+ " values (?, ?, ?, ?, ?, ?, ?, ?)";

			PreparedStatement ps = (PreparedStatement) con.prepareStatement(query);
			ps.setDouble(5, 0.0);
			ps.setDouble(6, 0.0);
			ps.setDouble(7, 0.0);
			ps.setDouble(8, 0.0);

			if (isInputValid()) {
				ps.execute();

				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("BudgetTime.IO");
				alert.setHeaderText("Succsess!");
				alert.setContentText("Regestration Succsesfull.");

				alert.showAndWait();
			}
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public boolean isInputValid() {

		return false;

	}

}
