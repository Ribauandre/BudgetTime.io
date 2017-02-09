package BudgetTimeLogic.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import BudgetTimeLogic.model.AccountModel;
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
            dialogStage.close();
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
        } else {
            // Show the error message.
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
		return okClicked;
    }
}