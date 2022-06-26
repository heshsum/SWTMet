package org.pareto;
/*
 * <br><code><b>[OMI-GP2-Hausarbeit]</b></code>
 *
 * Copyright (c) 2020
 * All Rights Reserved.
 *
 * @version 1.00 - 24 July 2020 - HS - initial version
 * @author   Hendrik Schlange (mail@hendrikschlange.de)
 */

import org.pareto.controller.PLHelper;
import org.pareto.controller.SelectedBookHelper;
import org.pareto.model.Book;
import org.pareto.model.PersonalLibrary;
import static org.pareto.controller.LogHelper.log;

public class LibraryTester {

    /**
     * Method to print a separator for console outputs.
     */
    private static void testSeparator() {
        log("----------------" + System.lineSeparator() + System.lineSeparator());
    }

    /**
     * Method to print a separator and an input String for console outputs.
     * @param printString the String to print
     */
    private static void testSeparator(String printString) {
        log("----------------" + System.lineSeparator() 
            + printString + System.lineSeparator());
    }    

    /**
     * Tester method for the class Book.
     */
    private static void bookTests() {
        testSeparator("Starting Book tests");

        log("Creating the first book - only author and title");
        Book testBook1 = new Book("Harald Lesch", "Eine interessante Welt");
        log("Printing the book - only author and title");
        log(testBook1);
        
        testSeparator();
        
        log("Creating the first book - all attributes");
        Book testBook2 = new Book("author2", "title2", "publisher2", 2002, "ISBN2", 50.02, true);
        log("Printing the book - all attributes");
        log(testBook2);

        testSeparator();

        log("Adding publisher, printing complete Book.");
        testBook1.setPublisher("Fischer");
        log(testBook1.getAll());
        
        
        log("Printing Book selectively.");
        testSeparator();
        log(testBook1.getAllSet());

        testSeparator();

        log("Adding year, printing complete Book.");
        testBook1.setYear(1996);
        log(testBook1.getAll());
        
        log("Printing Book selectively.");
        testSeparator();
        log(testBook1.getAllSet());

        testSeparator();

        log("Adding ISBN, printing complete Book.");
        testBook1.setIsbn("DE86 123456789");
        log(testBook1.getAll());
        
        log("Printing Book selectively.");
        testSeparator();
        log(testBook1.getAllSet());

        testSeparator();

        log("Adding price, printing complete Book.");
        testBook1.setPrice(19.95);
        log(testBook1.getAll());

        log("Printing Book selectively.");
        testSeparator();
        log(testBook1.getAllSet());

        testSeparator();

        log("Marking as an ebook, printing complete Book.");
        testBook1.setEbook(true);
        log(testBook1.getAll());

        log("Printing Book selectively.");
        testSeparator();
        log(testBook1.getAllSet());
        
        log("Unmarking as an ebook, printing complete Book.");
        testBook1.setEbook(false);
        log(testBook1.getAll());

        log("Printing Book selectively.");
        testSeparator();
        log(testBook1.getAllSet());

        testSeparator("Starting getter tests");

        log("Testing getter for author");
        log("Result should be 'Harald Lesch': " 
                + testBook1.getAuthor());

        testSeparator();

        log("Testing getter for title");
        log("Result should be 'Eine interessante Welt': " 
                + testBook1.getTitle());

        testSeparator();

        log("Testing getter for publisher");
        log("Result should be 'Fischer': " 
                + testBook1.getPublisher());

        testSeparator();

        log("Testing getter for year");
        log("Result should be '1996': " 
                + testBook1.getYear());

        testSeparator();

        log("Testing getter for price");
        log("Result should be '19.95': " 
                + testBook1.getPrice());

        testSeparator();
        log("Testing getter for ebook");
        log("Result should be 'false': " 
                + testBook1.getEbook());
        
        testSeparator();
        log("Setting ebook to 'true' and testing again.");
        testBook1.setEbook(true);
        log("Result should be 'true': " 
                + testBook1.getEbook());


        testSeparator("Finished Book tests");
    }

    /**
     * Tester method for the class PersonalLibrary.
     */
    private static void libraryTests() {
        testSeparator("Starting PersonalLibrary tests");

        log("Creating the first book");
        Book testBook1 = new Book("author1", "title1", "publisher1", 2001, "ISBN1", 20.05, false);
        log("Printing the book");
        log(testBook1.getAll());

        testSeparator();

        log("Creating a library");
        PersonalLibrary testPersonalLibrary = new PersonalLibrary();

        testSeparator();

        log("Adding book 1 to the library");
        testPersonalLibrary.add(testBook1);
        log("Size of library: " + testPersonalLibrary.getSize());
        log("Printing the library");
        log(testPersonalLibrary);

        testSeparator();

        log("Creating the second book");
        Book testBook2 = new Book("author2", "title2", "publisher2", 2002, "ISBN2", 50.02, true);
        log("Printing the book");
        log(testBook2.getAll());

        testSeparator();

        log("Size of library: " + testPersonalLibrary.getSize());
        log("Adding book 2 to the library");
        testPersonalLibrary.add(testBook2);
        log("Size of library: " + testPersonalLibrary.getSize());

        log("Printing the library");
        log(testPersonalLibrary);

        testSeparator();
        
        log("Getting book1 of index position 0");
        log(testPersonalLibrary.get(0));
        
        testSeparator();

        log("Removing book 2 from the library");
        testPersonalLibrary.remove(testBook2);
        
        log("Printing the library");
        log(testPersonalLibrary);
        
        log("Removing book 1 from the library");
        testPersonalLibrary.remove(0);
        
        log("Printing the library - should be empty");
        log(testPersonalLibrary);
        
        log("Printing the library");
        log(testPersonalLibrary);

        testSeparator("Finished PersonalLibrary tests");
    }

    /**
     * Tester method for the method PLHelper.isValidPrice().
     */
    private static void isValidPriceTests() {
        testSeparator("Starting helper tests");
        testSeparator("Starting isValidPrice() tests");

        log("Testing isValidPrice for '0'");
        log("Result should be 'true': "
                + PLHelper.isValidPrice("0"));

        testSeparator();

        log("Testing isValidPrice for '1'");
        log("Result should be 'true': "
                + PLHelper.isValidPrice("1"));

        testSeparator();

        log("Testing isValidPrice for '19.95'");
        log("Result should be 'true': "
                + PLHelper.isValidPrice("19.95"));

        testSeparator();

        log("Testing isValidPrice for '19,95'");
        log("Result should be 'false': "
                + PLHelper.isValidPrice("19,95"));

        testSeparator();

        log("Testing isValidPrice for 'aaa'");
        log("Result should be 'false': "
                + PLHelper.isValidPrice("aaa"));
        
        testSeparator();

        log("Testing isValidPrice for '-1'");
        log("Result should be 'false': "
                + PLHelper.isValidPrice("-1"));

        testSeparator("Finished isValidPrice() tests");

    }

    /**
     * Tester method for the method PLHelper.priceFormatter().
     */
    private static void priceFormatterTests() {

        testSeparator("Starting priceFormatter tests");

        log("Testing priceFormatter for '0'");
        log("Result should be '0.0': "
                + PLHelper.priceFormatter("0"));

        testSeparator();

        log("Testing priceFormatter for '19.95'");
        log("Result should be '19.95': "
                + PLHelper.priceFormatter("19.95"));

        testSeparator();

        log("Testing priceFormatter for '19,95'");
        log("Result should be '19.95': "
                + PLHelper.priceFormatter("19,95"));

        testSeparator();

        log("Testing priceFormatter for '19.955'");
        log("Result should be '19.96': "
                + PLHelper.priceFormatter("19.955"));

        testSeparator();
        
        log("Testing priceFormatter for '19.954'");
        log("Result should be '19.95': "
                + PLHelper.priceFormatter("19.954"));

        testSeparator();

        log("Testing priceFormatter for '19,955'");
        log("Result should be '19.96': "
                + PLHelper.priceFormatter("19,955"));

        testSeparator();
        
        log("Testing priceFormatter for '19,954'");
        log("Result should be '19.95': "
                + PLHelper.priceFormatter("19,954"));

        testSeparator();

        log("Testing priceFormatter for 'aaa'");
        log("Result should be 'null'"
                + PLHelper.priceFormatter("aaa"));

        testSeparator();

        log("Testing priceFormatter for '19.95a'");
        log("Result should be 'null': "
                + PLHelper.priceFormatter("19.95a"));
        testSeparator("Finished priceFormatter tests");

    }


    /**
     * Tester method for the method isValidYear().
     */
    private static void isValidYearTests() {

        testSeparator("Starting isValidYear tests");

        log("Testing isValdiYear() for 'aaa'");
        log("Result should be 'false': "
                + PLHelper.isValidYear("aaa"));

        testSeparator();

        log("Testing isValdiYear() for '1996a'");
        log("Result should be 'false': "
                + PLHelper.isValidYear("1996a"));

        testSeparator();

        log("Testing isValdiYear() for '0'");
        log("Result should be 'false': "
                + PLHelper.isValidYear("0"));

        testSeparator();

        log("Testing isValdiYear() for '1'");
        log("Result should be 'false': "
                + PLHelper.isValidYear("1"));

        testSeparator();

        log("Testing isValdiYear() for '10'");
        log("Result should be 'false': "
                + PLHelper.isValidYear("10"));

        testSeparator();

        log("Testing isValdiYear() for '100'");
        log("Result should be 'false': "
                + PLHelper.isValidYear("100"));

        testSeparator();

        log("Testing isValdiYear() for '1000'");
        log("Result should be 'false': "
                + PLHelper.isValidYear("1000"));

        testSeparator();

        log("Testing isValdiYear() for '10000'");
        log("Result should be 'false': "
                + PLHelper.isValidYear("10000"));

        testSeparator();

        log("Testing isValdiYear() for '-1'");
        log("Result should be 'false': "
                + PLHelper.isValidYear("-1"));

        testSeparator();

        log("Testing isValdiYear() for '1699'");
        log("Result should be 'false': "
                + PLHelper.isValidYear("1699"));

        testSeparator();

        log("Testing isValdiYear() for '1700'");
        log("Result should be 'true': "
                + PLHelper.isValidYear("1700"));

        testSeparator();

        log("Testing isValdiYear() for '2000'");
        log("Result should be 'true': "
                + PLHelper.isValidYear("2000"));

        testSeparator();

        log("Testing isValdiYear() for '2099'");
        log("Result should be 'true': "
                + PLHelper.isValidYear("2099"));

        testSeparator();

        log("Testing isValdiYear() for '2100'");
        log("Result should be 'false': "
                + PLHelper.isValidYear("2100"));

        testSeparator("Finished isValidYear() tests");
    }
    
    
    /**
     * Tester method for class selectedBookHelper.
     */
    static void selectedBookHelperTester() {
        testSeparator("Starting setSelectedBook() and getSelectedBook() tests");
        log("Creating new Book");
        Book testBook = new Book("author1", "title1");
        log(testBook);
        
        testSeparator();
        
        log("Setting book as selected Book");
        SelectedBookHelper.setSelectedBook(testBook);
        
        testSeparator();
        
        log("Printing selected Book. "
                + "Result should be the same as the printout before.");
        log(SelectedBookHelper.getSelectedBook());
        
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
