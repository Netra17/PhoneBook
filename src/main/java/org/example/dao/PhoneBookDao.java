package org.example.dao;

import org.example.model.PhoneBook;

import java.util.List;

public interface PhoneBookDao {

    List<PhoneBook> searchByName (String searchTerm);
 //   List<PhoneBook> searchByPhoneNumber (String searchTerm);
    void deleteContact(String name);
    List<PhoneBook> listOfContacts();

    void updateContact(String name);

}
