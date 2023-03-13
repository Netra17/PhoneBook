package org.example;

import org.example.dao.PhoneBookDao;
import org.example.dao.PostgresPhoneBookDao;
import org.example.model.PhoneBook;
import org.example.view.UserInterface;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        UserInterface userInterface = new UserInterface();
        PhoneBookDao phoneBookDao = new PostgresPhoneBookDao();
        userInterface.greetUser();

        String mainMenu = userInterface.promptUserMainMenu();
     //   while (!mainMenu.equals("0")) {
            if (mainMenu.equals("1")) {
     //           String searchTerm = userInterface.promptUserForLists();
                List<PhoneBook> phoneBookList = phoneBookDao.listOfContacts();
      //          System.out.println("You enter to see list of All contracts ");

            } else if (mainMenu.equals("2")) {
                String searchTerm = userInterface.promptUserForSearchTerm();
                List<PhoneBook> matchingNames = phoneBookDao.searchByName(searchTerm);
                userInterface.printPhonebooks(matchingNames);

            } else if (mainMenu.equals("3")) {
                System.out.println("You enter to Add contact to phone book ");

            } else if (mainMenu.equals("4")) {
                System.out.println("You enter to Update Contact by name ");

            } else if (mainMenu.equals("5")) {
                String name = userInterface.promptUserForDeleteTerm();
                phoneBookDao.deleteContact(name);

            } else if (mainMenu.equals("0")) {
                System.out.println("HAVE A GOOD DAY!!!");
                System.exit(1);

            } else System.out.println("Invalid Entry");
















//        String searchTerm = userInterface.promptUserForSearchTerm();



//        List<PhoneBook> matchingNames = phoneBookDao.searchByName(searchTerm);
//        userInterface.printPhonebooks(matchingNames);

//        List<PhoneBook> matchingNumber = phoneBookDao.searchByPhoneNumber(searchTerm);
//        userInterface.printPhonebooks(matchingNumber);


//        String name = userInterface.promptUserForDeleteTerm();
//        phoneBookDao.deleteContact(name);



    }
}