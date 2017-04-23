package BudgetTimeLogic;

import java.io.IOException;

import BudgetTimeLogic.model.Person;
import BudgetTimeLogic.view.NavigationController;
import BudgetTimeLogic.view.RegisterController;
import BudgetTimeLogic.view.AccountController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainApp extends Application {

    public static Stage primaryStage;
    private static BorderPane rootLayout;
    
    

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("BudgetTime.IO");
 

        initRootLayout();

        showPersonOverview();
    }


    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /* public static boolean showFName() {
        try {
            
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/editFNameView.fxml"));
            AnchorPane page = (AnchorPane) loader.load();
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Account Edit");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            AccountController controller = loader.getController();
            controller.setDialogStage(dialogStage);


            dialogStage.showAndWait();

            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    } */
    public static void showCat() {
        try {
            
        	 FXMLLoader loader = new FXMLLoader();
             loader.setLocation(MainApp.class.getResource("view/CatigoryView.fxml"));
             AnchorPane personOverview = (AnchorPane) loader.load();
             rootLayout.setCenter(personOverview);
             
             
         } catch (IOException e) {
             e.printStackTrace();
         }
     }
    public static void showAccount() {
        try {
            
        	 FXMLLoader loader = new FXMLLoader();
             loader.setLocation(MainApp.class.getResource("view/AccountView.fxml"));
             AnchorPane personOverview = (AnchorPane) loader.load();
             rootLayout.setCenter(personOverview);
             
             
         } catch (IOException e) {
             e.printStackTrace();
         }
     }
    public static void showIncomeEdit() {
        try {
            
        	 FXMLLoader loader = new FXMLLoader();
             loader.setLocation(MainApp.class.getResource("view/incomeView.fxml"));
             AnchorPane personOverview = (AnchorPane) loader.load();
             rootLayout.setCenter(personOverview);
             
             
         } catch (IOException e) {
             e.printStackTrace();
         }
     }
    

    public static void showNav() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/NavigationView.fxml"));
            AnchorPane personOverview = (AnchorPane) loader.load();
            rootLayout.setCenter(personOverview);

            
            
        } catch (IOException e) {
            e.printStackTrace();
        }
		
    }
    public static void showPersonOverview() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/LoginView.fxml"));
            AnchorPane personOverview = (AnchorPane) loader.load();


            // Set person overview into the center of root layout.
            rootLayout.setCenter(personOverview);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static boolean showPersonEditDialog() {
        try {
            
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/RegisterView.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

         
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Register Person");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            RegisterController controller = loader.getController();
            controller.setDialogStage(dialogStage);


            dialogStage.showAndWait();

            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    public static Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
        
    }
}
