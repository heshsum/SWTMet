package org.pareto.controller;
/*
 * PLHelper.java
 *
 * Copyright (c) 2020
 * All Rights Reserved.
 *
 * @version 1.00 - 18 July 2020 - HS - initial version
 */

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.layout.BorderPane;
import org.pareto.model.Book;
import org.pareto.model.PersonalLibrary;

/**
 * Class for general helper functions in the application.
 * <br><code><b>[OMI-GP2-Hausarbeit]</b></code>
 *
 * @version 1.00 - 18 July 2020 - HS - initial version
 * @author   Hendrik Schlange (mail@hendrikschlange.de)
 */
public class PLHelper {


    /** The BorderPane of the GUI. */
    static BorderPane root;

    /** The library to manage. */
    private static PersonalLibrary pl;

    /**
     * An ObservableList of all Book object in the PersonalLibrary.
     */
    private static ObservableList<Book> personalLibraryObservableList = FXCollections.observableArrayList();

    /** A Boolean to (de-) activate the debug mode. */
    private static Boolean debugMode = false;


    /** Method to create a new BorderPane (which is used as the basis for the GUI). */
    public static void setBP() {
        root = new BorderPane();
    }


    /**
     * Method to retrieve the root BorderPane.
     * @return the root BorderPane object
     */
    public static BorderPane getBP() {
        return root;
    }


    /** Method to create the PersonalLibrary to manage. */
    public static void setPL() {
        pl = new PersonalLibrary();
    }


    /**
     * Method to retrieve the PersonalLibrary object to manage.
     * @return the PersonalLibrary object to manage
     */
    public static PersonalLibrary getPL() {
        return pl;
    }

    /**
     * Method to retrieve the ObservableList object of the PersonalLibrary.
     * @return the ObservableList
     */
    public static ObservableList<Book> getPersonalLibraryObservableList() {
        return personalLibraryObservableList;
    }


    /**
     * Method to (de-) activate the debug mode.
     * @param debugValue the setting of the debug mode
     */
    public static void setDebug(Boolean debugValue) {
        debugMode = debugValue;
    }


    /**
     * Method to retrieve the state of the debug mode.
     * @return true if debug mode is active, false if it is not
     */
    public static Boolean getDebug() {
        return debugMode;
    }


    /**
     * Method to check if a String is a valid price.
     * @param price the String representing the price
     * @return the price as a Double, rounded to two decimal places
     */
    public static Double priceFormatter(String price) {
        Double formattedPrice = null;
        // Replacing , with . to be able to parse it
        price = price.replace(",", ".");

        Boolean isValidPrice = isValidPrice(price);
        // If the price String is a valid price, round it to two decimal places
        if (Boolean.TRUE.equals(isValidPrice)) {

            // Converting to BigDecimal to make use of setScale
            BigDecimal tempPrice = BigDecimal.valueOf(Double.parseDouble(price));

            // Round the value to 2 decimal places
            tempPrice = tempPrice.setScale(2, RoundingMode.HALF_UP);

            // Return the result as a Double
            formattedPrice = tempPrice.doubleValue();
        }

        return formattedPrice;
    }


    /**
     * Method to determine if a price value is a valid price.
     * Valid prices are numeric values with up to 2 decimal points
     * A point is used as decimal divider
     * @param price the Double representing the price
     * @return true if the price is valid, false if it is not
     */
    public static Boolean isValidPrice(String price) {
        // ^ = start capturing from beginning
        // [0-9] capture numbers between 0 and 9
        // + capturing group has to have at least one match
        // \\. match "."
        // {0,1} match between 0 and 1 occurrence
        // [0-9] capture numbers between 0 and 9
        // * match 0 or more occurrences of the capture group
        String priceRegex = "^[0-9]+\\.{0,1}[0-9]*$";
        Pattern pricePattern = Pattern.compile(priceRegex);
        Matcher priceMatcher = pricePattern.matcher(price);
        return priceMatcher.matches();
    }


    /**
     * Method to validate of a String value is a valid year.
     * Evaluation is rather simple: check if the String is comprised of 4 digits
     * @param year the String to evaluate
     * @return true if the String is a valid year, false if it is not
     */
    public static Boolean isValidYear(String year) {
        String yearRegex = "^(17|18|19|20)[0-9]{2}";
        Pattern yearPattern = Pattern.compile(yearRegex);
        Matcher yearMatcher = yearPattern.matcher(year);
        return yearMatcher.matches();
    }


    /**
     * Method to add all Book objects of the PersonalLibrary to the ObservableList.
     */
    public static void populateLibrary() {
        getPersonalLibraryObservableList().clear();
        for (int i = 0; i < getPL().getSize(); i++) {
            getPersonalLibraryObservableList().add(getPL().get(i));
        }
    }
}
