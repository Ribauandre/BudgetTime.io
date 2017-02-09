package BudgetTimeLogic.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class Person {

    private final StringProperty firstName;
    private final StringProperty lastName;
    private final StringProperty userName;
    private final StringProperty pass;
    


    /**
     * Default constructor.
     */
    public Person() {
        this(null, null, null, null);
    }


    public Person(String firstName, String lastName, String userName, String pass) {
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
        this.userName = new SimpleStringProperty(userName);
        this.pass = new SimpleStringProperty(pass);
        
    }

    public String getFirstName() {
        return firstName.get();
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public String getLastName() {
        return lastName.get();
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }
    public String getUserName() {
        return userName.get();
    }

    public void setUserName(String userName) {
        this.userName.set(userName);
    }
    public String getPass() {
        return pass.get();
    }

    public void setPass(String pass) {
        this.pass.set(pass);
    }


   
}
