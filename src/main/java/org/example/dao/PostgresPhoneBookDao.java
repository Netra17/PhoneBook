package org.example.dao;

import org.apache.commons.dbcp2.BasicDataSource;
import org.example.model.PhoneBook;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.ArrayList;
import java.util.List;

public class PostgresPhoneBookDao implements PhoneBookDao {

    JdbcTemplate jdbcTemplate;
    public PostgresPhoneBookDao(){
        BasicDataSource phonebookInfo = new BasicDataSource();
        phonebookInfo.setUrl("jdbc:postgresql://localhost:5432/Phonebook");
        phonebookInfo.setUsername("postgres");
        phonebookInfo.setPassword("postgres1");

         jdbcTemplate = new JdbcTemplate(phonebookInfo);
    }

    public List<PhoneBook> searchByName(String searchTerm) {
        searchTerm = searchTerm;
        String sql = "select * from phonebook where first_name ilike ?;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql,searchTerm);

        return mapAllRowsToListOfPhoneBooks(results);
    }

    public void insertContact(String contact){
        String sql = "\n" +
            "Insert Into phonebook (first_name, last_name, phone_number, email_address, address)\n" +
            "Values (?, ?, ?, ?, ?);";
    SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
    }


    public void deleteContact(String name){
        String sql = "Delete From phonebook\n" +
                "Where first_name = ?; ";
        jdbcTemplate.update(sql, name );
    }

//    @Override
//    public List<PhoneBook> listOfContacts(String searchTerm) {
//        String sql = "select * from phonebook;";
//        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, searchTerm);
//
//        return mapAllRowsToListOfPhoneBooks(results);
//    }

    //@Override
    public List<PhoneBook> listOfContacts() {
        String sql = "select * from phonebook;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

        return mapAllRowsToListOfPhoneBooks(results);
    }

    @Override
    public void updateContact(String name) {
        String sql = "Update phonebook " +
        "Set phone_number ? where first_name ?";
        jdbcTemplate.update(sql, name );
    }

    public List<PhoneBook> mapAllRowsToListOfPhoneBooks(SqlRowSet rowSet) {
        List<PhoneBook> results = new ArrayList<>();

        while (rowSet.next()) {
            results.add(mapOneRowToOnePhoneBook(rowSet));
        }
        return results;
    }

    public PhoneBook mapOneRowToOnePhoneBook(SqlRowSet rowSet) {
        int personId = rowSet.getInt("personid");
        String firstName = rowSet.getString("first_name");
        String lastName = rowSet.getString("last_name");
        String phoneNumber = rowSet.getString("phone_number");
        String emailAddress = rowSet.getString("email_address");
        String address = rowSet.getString("address");

        PhoneBook phonebook = new PhoneBook();
        phonebook.setPersonId(personId);
        phonebook.setFirstName(firstName);
        phonebook.setLast_name(lastName);
        phonebook.setPhoneNumber(phoneNumber);
        phonebook.setEmailAddress(emailAddress);
        phonebook.setAddress(address);

        return phonebook;
    }
}
