package org.example.view;

import org.example.model.PhoneBook;

import java.util.List;
import java.util.Scanner;

public class UserInterface {
    Scanner userInput = new Scanner(System.in);
    public void greetUser (){
        System.out.println("WELCOME TO NETRA'S PHONE BOOK");
        System.out.println("_______________________________");
        System.out.println(" ");
    }

//   public String promptUserForLists(){
//       System.out.println("Hi");
//        return userInput.nextLine();
//   }

    public String promptUserForSearchTerm(){
        System.out.print("Enter the First name >>>> ");
        return userInput.nextLine();

    }
//    public String promptUserForInsertTerm(){
//        System.out.println("Enter the FirstName, LastName, PhoneNumber, emailAddress, Address>>> ");
//        return userInput.nextLine();
//    }

    public String promptUserForDeleteTerm(){
        System.out.println("Enter the name to delete>>>");
        return userInput.nextLine();
    }

    public String promptUserForInsertTerm(){
        System.out.println("Enter the First name>>> ");
        String firstName = userInput.nextLine();
        System.out.println("Enter the Last name>>> ");
        String lastName = userInput.nextLine();
        System.out.println("Enter the Phone Number>>> ");
        String phoneNumber = userInput.nextLine();
        System.out.println("Enter the Email Address>>> ");
        String emailAddress = userInput.nextLine();
        System.out.println("Enter the Address>>> ");
        String address = userInput.nextLine();
        return null;
    }

    public String promptUserForUpdate(){
        System.out.println("1) Update First Name ");
        System.out.println("2) Update Last Name ");
        System.out.println("3) Update Phone Number ");
        System.out.println("4) Update Email Address");
        System.out.println("5) Update Address");
        return userInput.nextLine();
    }

    public String promptUserMainMenu(){
        System.out.println("1) List of Contacts List ");
        System.out.println("2) Search By First Name ");
        System.out.println("3) Add Contact ");
        System.out.println("4) Update Contact by Name ");
        System.out.println("5) Delete Contact ");
        System.out.println("0) Exit ");
        return userInput.nextLine();
    }

    public void printPhonebooks(List<PhoneBook> phonebookList){
        int counter = 1;
        for(PhoneBook phonebook : phonebookList){
            System.out.println(counter + ". " + phonebook.getFirstName() + "'s Phone Number is " + phonebook.getPhoneNumber());
            counter ++;
        }
    }



}
