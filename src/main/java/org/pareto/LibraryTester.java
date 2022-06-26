package org.pareto;/*
 * org.pareto.LibraryTester.java
 *
 * Copyright (c) 2020
 * All Rights Reserved.
 *
 * @version 1.00 - 24 July 2020 - HS - initial version
 */

import org.pareto.controller.PLHelper;
import org.pareto.controller.SelectedBookHelper;
import org.pareto.model.Book;
import org.pareto.model.PersonalLibrary;

/**
 * Class generate Book entries from an XML export file.
 * <br><code><b>[OMI-GP2-Hausarbeit]</b></code>
 *
 * @version 1.00 - 18 July 2020 - HS - initial version
 * @author   Hendrik Schlange (mail@hendrikschlange.de)
 */
public class LibraryTester {

    /**
     * Method to print a separator for console outputs.
     */
    private static void testSeparator() {
        System.out.println("----------------" + System.lineSeparator() + System.lineSeparator());
    }

    /**
     * Method to print a separator and an input String for console outputs.
     * @param printString the String to print
     */
    private static void testSeparator(String printString) {
        System.out.println("----------------" + System.lineSeparator() 
            + printString + System.lineSeparator());
    }    

    /**
     * Tester method for the class Book.
     */
    private static void bookTests() {
        testSeparator("Starting Book tests");

        System.out.println("Creating the first book - only author and title");
        Book testBook1 = new Book("Harald Lesch", "Eine interessante Welt");
        System.out.println("Printing the book - only author and title");
        System.out.println(testBook1);
        
        testSeparator();
        
        System.out.println("Creating the first book - all attributes");
        Book testBook2 = new Book("author2", "title2", "publisher2", 2002, "ISBN2", 50.02, true);
        System.out.println("Printing the book - all attributes");
        System.out.println(testBook2);

        testSeparator();

        System.out.println("Adding publisher, printing complete Book.");
        testBook1.setPublisher("Fischer");
        System.out.println(testBook1.getAll());
        
        
        System.out.println("Printing Book selectively.");
        testSeparator();
        System.out.println(testBook1.getAllSet());

        testSeparator();

        System.out.println("Adding year, printing complete Book.");
        testBook1.setYear(1996);
        System.out.println(testBook1.getAll());
        
        System.out.println("Printing Book selectively.");
        testSeparator();
        System.out.println(testBook1.getAllSet());

        testSeparator();

        System.out.println("Adding ISBN, printing complete Book.");
        testBook1.setIsbn("DE86 123456789");
        System.out.println(testBook1.getAll());
        
        System.out.println("Printing Book selectively.");
        testSeparator();
        System.out.println(testBook1.getAllSet());

        testSeparator();

        System.out.println("Adding price, printing complete Book.");
        testBook1.setPrice(19.95);
        System.out.println(testBook1.getAll());

        System.out.println("Printing Book selectively.");
        testSeparator();
        System.out.println(testBook1.getAllSet());

        testSeparator();

        System.out.println("Marking as an ebook, printing complete Book.");
        testBook1.setEbook(true);
        System.out.println(testBook1.getAll());

        System.out.println("Printing Book selectively.");
        testSeparator();
        System.out.println(testBook1.getAllSet());
        
        System.out.println("Unmarking as an ebook, printing complete Book.");
        testBook1.setEbook(false);
        System.out.println(testBook1.getAll());

        System.out.println("Printing Book selectively.");
        testSeparator();
        System.out.println(testBook1.getAllSet());

        testSeparator("Starting getter tests");

        System.out.println("Testing getter for author");
        System.out.println("Result should be 'Harald Lesch': " 
                + testBook1.getAuthor());

        testSeparator();

        System.out.println("Testing getter for title");
        System.out.println("Result should be 'Eine interessante Welt': " 
                + testBook1.getTitle());

        testSeparator();

        System.out.println("Testing getter for publisher");
        System.out.println("Result should be 'Fischer': " 
                + testBook1.getPublisher());

        testSeparator();

        System.out.println("Testing getter for year");
        System.out.println("Result should be '1996': " 
                + testBook1.getYear());

        testSeparator();

        System.out.println("Testing getter for price");
        System.out.println("Result should be '19.95': " 
                + testBook1.getPrice());

        testSeparator();
        System.out.println("Testing getter for ebook");
        System.out.println("Result should be 'false': " 
                + testBook1.getEbook());
        
        testSeparator();
        System.out.println("Setting ebook to 'true' and testing again.");
        testBook1.setEbook(true);
        System.out.println("Result should be 'true': " 
                + testBook1.getEbook());


        testSeparator("Finished Book tests");
    }

    /**
     * Tester method for the class PersonalLibrary.
     */
    private static void libraryTests() {
        testSeparator("Starting PersonalLibrary tests");

        System.out.println("Creating the first book");
        Book testBook1 = new Book("author1", "title1", "publisher1", 2001, "ISBN1", 20.05, false);
        System.out.println("Printing the book");
        System.out.println(testBook1.getAll());

        testSeparator();

        System.out.println("Creating a library");
        PersonalLibrary testPersonalLibrary = new PersonalLibrary();

        testSeparator();

        System.out.println("Adding book 1 to the library");
        testPersonalLibrary.add(testBook1);
        System.out.println("Size of library: " + testPersonalLibrary.getSize());
        System.out.println("Printing the library");
        System.out.println(testPersonalLibrary);

        testSeparator();

        System.out.println("Creating the second book");
        Book testBook2 = new Book("author2", "title2", "publisher2", 2002, "ISBN2", 50.02, true);
        System.out.println("Printing the book");
        System.out.println(testBook2.getAll());

        testSeparator();

        System.out.println("Size of library: " + testPersonalLibrary.getSize());
        System.out.println("Adding book 2 to the library");
        testPersonalLibrary.add(testBook2);
        System.out.println("Size of library: " + testPersonalLibrary.getSize());

        System.out.println("Printing the library");
        System.out.println(testPersonalLibrary);

        testSeparator();
        
        System.out.println("Getting book1 of index position 0");
        System.out.println(testPersonalLibrary.get(0));
        
        testSeparator();

        System.out.println("Removing book 2 from the library");
        testPersonalLibrary.remove(testBook2);
        
        System.out.println("Printing the library");
        System.out.println(testPersonalLibrary);
        
        System.out.println("Removing book 1 from the library");
        testPersonalLibrary.remove(0);
        
        System.out.println("Printing the library - should be empty");
        System.out.println(testPersonalLibrary);
        
        System.out.println("Printing the library");
        System.out.println(testPersonalLibrary);

        testSeparator("Finished PersonalLibrary tests");
    }

    /**
     * Tester method for the method PLHelper.isValidPrice().
     */
    private static void isValidPriceTests() {
        testSeparator("Starting helper tests");
        testSeparator("Starting isValidPrice() tests");

        System.out.println("Testing isValidPrice for '0'");
        System.out.println("Result should be 'true': "
                + PLHelper.isValidPrice("0"));

        testSeparator();

        System.out.println("Testing isValidPrice for '1'");
        System.out.println("Result should be 'true': "
                + PLHelper.isValidPrice("1"));

        testSeparator();

        System.out.println("Testing isValidPrice for '19.95'");
        System.out.println("Result should be 'true': "
                + PLHelper.isValidPrice("19.95"));

        testSeparator();

        System.out.println("Testing isValidPrice for '19,95'");
        System.out.println("Result should be 'false': "
                + PLHelper.isValidPrice("19,95"));

        testSeparator();

        System.out.println("Testing isValidPrice for 'aaa'");
        System.out.println("Result should be 'false': "
                + PLHelper.isValidPrice("aaa"));
        
        testSeparator();

        System.out.println("Testing isValidPrice for '-1'");
        System.out.println("Result should be 'false': "
                + PLHelper.isValidPrice("-1"));

        testSeparator("Finished isValidPrice() tests");

    }

    /**
     * Tester method for the method PLHelper.priceFormatter().
     */
    private static void priceFormatterTests() {

        testSeparator("Starting priceFormatter tests");

        System.out.println("Testing priceFormatter for '0'");
        System.out.println("Result should be '0.0': "
                + PLHelper.priceFormatter("0"));

        testSeparator();

        System.out.println("Testing priceFormatter for '19.95'");
        System.out.println("Result should be '19.95': "
                + PLHelper.priceFormatter("19.95"));

        testSeparator();

        System.out.println("Testing priceFormatter for '19,95'");
        System.out.println("Result should be '19.95': "
                + PLHelper.priceFormatter("19,95"));

        testSeparator();

        System.out.println("Testing priceFormatter for '19.955'");
        System.out.println("Result should be '19.96': "
                + PLHelper.priceFormatter("19.955"));

        testSeparator();
        
        System.out.println("Testing priceFormatter for '19.954'");
        System.out.println("Result should be '19.95': "
                + PLHelper.priceFormatter("19.954"));

        testSeparator();

        System.out.println("Testing priceFormatter for '19,955'");
        System.out.println("Result should be '19.96': "
                + PLHelper.priceFormatter("19,955"));

        testSeparator();
        
        System.out.println("Testing priceFormatter for '19,954'");
        System.out.println("Result should be '19.95': "
                + PLHelper.priceFormatter("19,954"));

        testSeparator();

        System.out.println("Testing priceFormatter for 'aaa'");
        System.out.println("Result should be 'null'"
                + PLHelper.priceFormatter("aaa"));

        testSeparator();

        System.out.println("Testing priceFormatter for '19.95a'");
        System.out.println("Result should be 'null': "
                + PLHelper.priceFormatter("19.95a"));
        testSeparator("Finished priceFormatter tests");

    }


    /**
     * Tester method for the method isValidYear().
     */
    private static void isValidYearTests() {

        testSeparator("Starting isValidYear tests");

        System.out.println("Testing isValdiYear() for 'aaa'");
        System.out.println("Result should be 'false': "
                + PLHelper.isValidYear("aaa"));

        testSeparator();

        System.out.println("Testing isValdiYear() for '1996a'");
        System.out.println("Result should be 'false': "
                + PLHelper.isValidYear("1996a"));

        testSeparator();

        System.out.println("Testing isValdiYear() for '0'");
        System.out.println("Result should be 'false': "
                + PLHelper.isValidYear("0"));

        testSeparator();

        System.out.println("Testing isValdiYear() for '1'");
        System.out.println("Result should be 'false': "
                + PLHelper.isValidYear("1"));

        testSeparator();

        System.out.println("Testing isValdiYear() for '10'");
        System.out.println("Result should be 'false': "
                + PLHelper.isValidYear("10"));

        testSeparator();

        System.out.println("Testing isValdiYear() for '100'");
        System.out.println("Result should be 'false': "
                + PLHelper.isValidYear("100"));

        testSeparator();

        System.out.println("Testing isValdiYear() for '1000'");
        System.out.println("Result should be 'false': "
                + PLHelper.isValidYear("1000"));

        testSeparator();

        System.out.println("Testing isValdiYear() for '10000'");
        System.out.println("Result should be 'false': "
                + PLHelper.isValidYear("10000"));

        testSeparator();

        System.out.println("Testing isValdiYear() for '-1'");
        System.out.println("Result should be 'false': "
                + PLHelper.isValidYear("-1"));

        testSeparator();

        System.out.println("Testing isValdiYear() for '1699'");
        System.out.println("Result should be 'false': "
                + PLHelper.isValidYear("1699"));

        testSeparator();

        System.out.println("Testing isValdiYear() for '1700'");
        System.out.println("Result should be 'true': "
                + PLHelper.isValidYear("1700"));

        testSeparator();

        System.out.println("Testing isValdiYear() for '2000'");
        System.out.println("Result should be 'true': "
                + PLHelper.isValidYear("2000"));

        testSeparator();

        System.out.println("Testing isValdiYear() for '2099'");
        System.out.println("Result should be 'true': "
                + PLHelper.isValidYear("2099"));

        testSeparator();

        System.out.println("Testing isValdiYear() for '2100'");
        System.out.println("Result should be 'false': "
                + PLHelper.isValidYear("2100"));

        testSeparator("Finished isValidYear() tests");
    }
    
    
    /**
     * Tester method for class selectedBookHelper.
     */
    static void selectedBookHelperTester() {
        testSeparator("Starting setSelectedBook() and getSelectedBook() tests");
        System.out.println("Creating new Book");
        Book testBook = new Book("author1", "title1");
        System.out.println(testBook);
        
        testSeparator();
        
        System.out.println("Setting book as selected Book");
        SelectedBookHelper.setSelectedBook(testBook);
        
        testSeparator();
        
        System.out.println("Printing selected Book. "
                + "Result should be the same as the printout before.");
        System.out.println(SelectedBookHelper.getSelectedBook());
        
        testSeparator("Finished setSelectedBook() and getSelectedBook() tests");
    }

    /**
     * Method to start tests.
     * @param args not used
     */
    public static void main(String[] args) {
        bookTests();
        libraryTests();
        isValidPriceTests();
        priceFormatterTests();
        isValidYearTests();
        selectedBookHelperTester();
    }


    /**
     * Method to initialize data for debugging.
     * @param ce the boolean, if examples should be created
     */
    public static void createExamples(Boolean ce) {

        if (ce) {
            // Adding a book in order to test the thing
            Book book1 = new Book("Daniel Defoe", "Robinson Crusoe");
            PLHelper.getPL().add(book1);

            Book book2 = new Book("Vanessa Blohm", "Über Sprache",
                    "C.H. Beck", 2021, "DE8699553", 19.85, false);
            PLHelper.getPL().add(book2);

            Book book3 = new Book("J.K. Rowling", "The Casual Vacancy", "Sphere", 2007,
                    "DE862233665", 22.65, true);
            PLHelper.getPL().add(book3);
        }

    }
}
