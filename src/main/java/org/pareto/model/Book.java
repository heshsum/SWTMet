/*
 * Book.java
 *
 * Copyright (c) 2020
 * All Rights Reserved.
 *
 * @version 1.00 - 15 June 2020 - HS - initial version
 */

package org.pareto.model;

/**
 * Class to describe the model of a Book.
 * <br><code><b>[OMI-GP2-Hausarbeit]</b></code>
 *
 * @version 1.00 - 15 June 2020 - HS - initial version
 * @author   Hendrik Schlange (mail@hendrikschlange.de)
 */
public class Book {
    /** A String representing the title of a book. */
    private String title;

    /** A String representing the author of a book. */
    private String author;

    /** A String representing the publisher of the book. */
    private String publisher;

    /** An integer representing the year of the book. */
    private int year;

    /** A String representing the isbn of a book. */
    private String isbn;

    /** A double representing the price of a book. */
    private double price;
    
    /** A boolean representing if the book is an e-book. */
    private boolean ebook;

    /**
     * Constructor for a new Book object.
     * @param title the title of the book
     * @param author the author of the book
     * @param publisher the publisher of the book
     * @param year the year the book was released
     * @param isbn the ISBN of the book
     * @param price the price of the book
     * @param ebook the boolean if the book is an ebook
     */
    public Book(String author, String title, String publisher, int year, String isbn, double price, boolean ebook) {
        this.author = author;
        this.title = title;
        this.publisher = publisher;
        this.year = year;
        this.isbn = isbn;
        this.price = price;
        this.ebook = ebook;
    }

    /**
     * Constructor for a new Book object.
     * @param title the title of the book
     * @param author the author of the book
     */
    public Book(String author, String title) {
        this.author = author;
        this.title = title;
        this.year = -1;
        this.price = -1.0;
    }

    /**
     * Method to retrieve the author of a book.
     * @return the author of the book
     */
    public String getAuthor() {
        return this.author;
    }

    /**
     * Method to retrieve the title of a book.
     * @return the title of the book
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Method to retrieve the publisher of a book.
     * @return the publisher of the book
     */
    public String getPublisher() {
        return this.publisher;
    }

    /**
     * Method to retrieve the year of a book.
     * @return the year of the book
     */
    public int getYear() {
        return this.year;
    }

    /**
     * Method to retrieve the ISBN of a book.
     * @return the ISBN of the book
     */
    public String getIsbn() {
        return this.isbn;
    }

    /**
     * Method to retrieve the price of a book.
     * @return the price of the book
     */
    public double getPrice() {
        return this.price;
    }

    /**
     * Method to retrieve the information if the book is an ebook.
     * @return true if the book is an ebook, false if it is not 
     */
    public boolean getEbook() {
        return this.ebook;
    }

    /**
     * Method to set the author of a book.
     * @param author the author of the book
     * @throws IllegalArgumentException if the author is blank
     */
    public void setAuthor(String author) throws IllegalArgumentException {
        if (author.isBlank()) {
            throw new IllegalArgumentException();
        }
        this.author = author;
    }

    /**
     * Method to set the title of a book.
     * @param title the title of the book
     * @throws IllegalArgumentException if the title is blank
     */
    public void setTitle(String title) throws IllegalArgumentException {
        if (!title.isBlank()) {
            this.title = title;
        }
        throw new IllegalArgumentException();
    }

    /**
     * Method to set the publisher of a book.
     * @param publisher the publisher of the book
     */
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    /**
     * Method to set the year of a book.
     * @param year the year of the book
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * Method to set the ISBN of a book.
     * @param isbn the ISBN of the book
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     * Method to set the price of a book.
     * @param price the price of the book
     */
    public void setPrice(double price) {
        this.price = price;
    }
    
    /**
     * Sets the information whether or not a book is an ebook.
     * @param ebook the information if the book is an ebook
     * True if it the book is an ebook, otherwise false
     */
    public void setEbook(boolean ebook) {
        this.ebook = ebook;
    }
    
    /**
     * Returns a complete textual representation of all attributes set for a Book.
     * @return the author and the title of the Book
     */
    public String getAllSet() {
        StringBuilder returnString = new StringBuilder();
        returnString.append("Author: ").append(this.author).append(System.lineSeparator())
                .append("Title: ").append(this.title).append(System.lineSeparator());
        
        if (this.publisher != null) {
            returnString.append("Publisher: ").append(this.publisher).append(System.lineSeparator());
        }
        if (this.year != -1) {
            returnString.append("Year: ").append(this.year).append(System.lineSeparator());
        }
        if (this.isbn != null) {
            returnString.append("ISBN: ").append(this.isbn).append(System.lineSeparator());
        }
        if (this.price != -1.0) {
            returnString.append("Price: ").append(this.price).append(System.lineSeparator());
        }
        returnString.append("Ebook: ").append(this.ebook);
        
        return returnString.toString();
    }
    
    /**
     * Returns a complete textual representation of a Book.
     * @return the author and the title of the Book
     */
    public String getAll() {
        return "Author: " + this.author + System.lineSeparator()
            + "Title: " + this.title + System.lineSeparator()
            + "Publisher: " + this.publisher + System.lineSeparator()
            + "Year: " + this.year + System.lineSeparator()
            + "ISBN: " + this.isbn + System.lineSeparator()
            + "Price: " + this.price + System.lineSeparator()
            + "Ebook: " + this.ebook;
    }

    /**
     * Returns a textual representation of author and title of a Book.
     * If more should be returned, use getAll() or getAllSet()
     * @return the author and title of a Book
     */
    @Override
    public String toString() {
        return "Author: " + author + System.lineSeparator()
            + "Title: " + title + System.lineSeparator();
    }

}
