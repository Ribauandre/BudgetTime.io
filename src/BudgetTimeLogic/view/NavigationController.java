package BudgetTimeLogic.view;

import java.net.URL;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.mysql.jdbc.Connection;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import BudgetTimeLogic.MainApp;
import BudgetTimeLogic.model.BudgetModel;
import BudgetTimeLogic.model.CategoryModel;
import BudgetTimeLogic.model.DB;
import BudgetTimeLogic.model.LoginModel;
import BudgetTimeLogic.model.Person;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.Alert.AlertType;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Callback;


public class NavigationController implements Initializable{

	// Budget
	// Account View
	@FXML
	public static Button logButton;
	@FXML
	public static Button editButton;
	@FXML
	public static Button catButton;
	@FXML
	private TextField incomeField;
	@FXML
	private TextField savingsField;
	@FXML
	private TextField freeMoneyField;
	@FXML
	private TextField expectedExpenseField;
	public static Person loginP = new Person(LoginModel.name, LoginModel.last, LoginModel.user, LoginModel.pass, LoginModel.budget, LoginModel.FoodDrink, LoginModel.Utilities, LoginModel.Subscription, LoginModel.Rent, LoginModel.Travel, LoginModel.GasFuel, LoginModel.Savings);
	@FXML
	public Text budgetText;
	@FXML
	public Text accountName;
	@FXML
	public ListView<String> catigories;
	@FXML
    private DialogPane discrip;
	CategoryAxis xAxis    = new CategoryAxis();
	

	NumberAxis yAxis = new NumberAxis();
	
	@FXML
    private BarChart info = new BarChart(xAxis, yAxis);
	
	
	String name;
	double bud;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		CategoryModel FoodDrink = new CategoryModel("Food & Drink", "Budgetting for Food & Drink Beverages. Alloting 10%",LoginModel.FoodDrink);  
		CategoryModel Utilities = new CategoryModel("Utilities", "Budgetting for Utilities like power, electricity, etc. Alloting 20%", LoginModel.Utilities);
		CategoryModel Subscription = new CategoryModel("Subscription", "Budgetting for user subscriptions like Netflix, Apple Music, Hulu, etc.", LoginModel.Subscription); 
		CategoryModel Rent = new CategoryModel("Rent","Budgetting for rent or housing", LoginModel.Rent); 
		CategoryModel Travel = new CategoryModel("Travel","Budget for any travel expenses", LoginModel.Travel);
		CategoryModel GasFuel = new CategoryModel("Gas & Fuel", "Budgetting for gas for automobiles", LoginModel.GasFuel); 
		CategoryModel Savings = new CategoryModel("Savings","Setting aside money for savings", LoginModel.Savings);
		CategoryController.categories.clear();
		LoginModel.logPerson(LoginModel.user, LoginModel.pass);
		loginP = new Person(LoginModel.name, LoginModel.last, LoginModel.user, LoginModel.pass, LoginModel.budget, LoginModel.FoodDrink, LoginModel.Utilities, LoginModel.Subscription, LoginModel.Rent, LoginModel.Travel, LoginModel.GasFuel, LoginModel.Savings);
		name = loginP.firstName+" "+loginP.lastName;
		accountName.setText(name);
		double percent = loginP.budget * 0.87;
		bud = loginP.budget - percent;
		budgetText.setText(""+bud);
		CategoryController.categories.add(FoodDrink);
		CategoryController.categories.add(Utilities);
		CategoryController.categories.add(Subscription);
		CategoryController.categories.add(Rent);
		CategoryController.categories.add(Travel);
		CategoryController.categories.add(GasFuel);
		CategoryController.categories.add(Savings);

		xAxis.setLabel("Catigories");
		yAxis.setLabel("Aloted Ammount");
		

		ObservableList<String> items =(ObservableList) FXCollections.observableArrayList (
		    "Food & Drink", "Gas & Fuel", "Utilities", "Savings","Rent", "Travel", "Subscription");
		catigories.setItems(items);
		catigories.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
		    @Override
		    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
		        for(int i =0; i< CategoryController.categories.size(); i++){
		        	
	
		        	if(newValue.equals(CategoryController.categories.get(i).getName())){
		        		info.getData().clear();
		        		XYChart.Series dataSeries1 = new XYChart.Series();
		        		dataSeries1.setName("Current");
		        		dataSeries1.getData().add(new XYChart.Data("Total Income", LoginModel.budget));
		        		String dis = CategoryController.categories.get(i).getDescription();
		        		discrip.setContentText(dis);
		        		double per = loginP.budget * CategoryController.categories.get(i).getPercentage();
		        		dataSeries1.getData().add(new XYChart.Data(CategoryController.categories.get(i).getName(),per));
		        		info.getData().add(dataSeries1);
		        
		        	}
		        	
		        	
		        }
		    }
		});
		
	}
	
	
	
	@FXML
	public void handelLogout(){
		loginP=null;
		MainApp.showPersonOverview();
		
	}
	public void accountClick(){
		MainApp.showAccount();
	}
	public void catClick(){
		MainApp.showCat();
	}
	public void editClick(){
		MainApp.showIncomeEdit();
	}


	public void inputBudget() {
	
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
