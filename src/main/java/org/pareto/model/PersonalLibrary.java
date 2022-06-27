/*
 * PersonalLibrary.java
 *
 * Copyright (c) 2020
 * All Rights Reserved.
 *
 * @version 1.00 - 18 July 2020 - HS - initial version
 */

package org.pareto.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Class to represent a library (in the classical sense) for Book objects.
 * <br><code><b>[OMI-GP2-Hausarbeit]</b></code>
 *
 * @version 1.00 - 18 July 2020 - HS - initial version
 * @author   Hendrik Schlange (mail@hendrikschlange.de)
 */
public class PersonalLibrary {
    
    /** ArrayList of Book object representing the PersonalLibrary. */
    ArrayList<Book> pl = new ArrayList<>();

    /**
     * Method to retrieve a single book from the library.
     * @param index the index position of a book in the library
     * @return the Book object of that index position
     * @throws ArrayIndexOutOfBoundsException if index is out of bounds
     */
    public Book get(int index) throws ArrayIndexOutOfBoundsException {
        if (index >= pl.size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return pl.get(index);
    }
    

    /**
     * Method to retrieve an ArrayList object containing all Book object of the PersonalLibrary.
     * @return an ArrayList with all Book object of the PersonalLibrary
     */
    public List<Book> getAll() {
        return new ArrayList<>(pl);
    }

    /**
     * Method to add a Book object to the PersonalLibrary.
     * @param book the Book object to add
     */
    public void add(Book book) {
        pl.add(book);
    }

    /**
     * Method to create and add a new Book object to the PersonalLibrary.
     * @param title the title of the book
     * @param author the author of the book
     */
    public void add(String author, String title) {
        pl.add(new Book(author, title));
    }

    /**
     * Method to remove a book from the library.
     * @param index the index position of the book to remove
     */
    public void remove(int index) {
        pl.remove(index);
    }
    
    /**
     * Method to remove a book from the library.
     * @param book the Book object to remove
     */
    public void remove(Book book) {
        pl.remove(book);
    }

    /**
     * Method to get the size of the library.
     * @return the number of elements of the ArrayList representing the library
     */
    public int getSize() {
        return pl.size();
    }

    @Override
    public String toString() {
        StringBuilder returnString = new StringBuilder();
        for (Book book : pl) {
            returnString.append(book.toString()).append(System.lineSeparator());
        } return returnString.toString();
    }
}


