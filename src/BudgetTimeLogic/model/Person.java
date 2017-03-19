package BudgetTimeLogic.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class Person {

    public String firstName;
    public String lastName;
    public String userName;
    public String pass;
    public double budget;
    
    


    public Person(String firstName, String lastName, String userName, String pass, double budget) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.pass = pass;
        this.budget = budget;
        
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        firstName = this.firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        lastName = this.lastName;
    }
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        userName = this.userName;
    }
    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        pass = this.pass;
    }
    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
    	budget = this.budget;
    }
    


   
}
