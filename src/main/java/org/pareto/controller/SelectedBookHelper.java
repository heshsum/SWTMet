/*
 * BookHelper.java
 *
 * Copyright (c) 2020
 * All Rights Reserved.
 *
 * @version 1.00 - 18 July 2020 - HS - initial version
 */

package org.pareto.controller;

import javafx.stage.Stage;
import org.pareto.model.Book;
import org.pareto.view.BookDetails;
import org.pareto.view.Menubar;

import static org.pareto.controller.LogHelper.log;


/**
 * Class for helper functions to control Book objects.
 * <br><code><b>[OMI-GP2-Hausarbeit]</b></code>
 *
 * @version 1.00 - 18 July 2020 - HS - initial version
 * @author   Hendrik Schlange (mail@hendrikschlange.de)
 */
public class SelectedBookHelper {

    /** The currently selected Book object. */
    private static Book selectedBook;

    /**
     * Private Constructor to hide the public one.
     */
    private SelectedBookHelper() {
        log("Utility class");
    }

    /**
     * Method to set the currently used Book object.
     * @param book the current Book
     */
    public static void setSelectedBook(Book book) {
        selectedBook = book;

        // If there is no selected Book (e.g. because it was deleted),
        // this will recreate the menu bar and disable the "Edit" button.
        if (selectedBook == null) {
            PLHelper.root.setTop(Menubar.menubar());
        }
    }


    /**
     * Method to retrieve the currently selected Book.
     * @return the currently selected Book object
     */
    public static Book getSelectedBook() {
        return selectedBook;
    }


    /**
     * Saves a Book entry from the GUI.
     * @param author the author of the book
     * @param title the title of the book
     * @param publisher the publisher of the book
     * @param year the year of the book
     * @param isbn the ISBN number of the book
     * @param price the price of the book
     * @param ebook Boolean to set if the book is an ebook
     */
    public static void saveSelectedBook(String author, String title, String publisher,
                                        String year, String isbn, String price, Boolean ebook) {
        getSelectedBook().setAuthor(author);
        getSelectedBook().setTitle(title);
        getSelectedBook().setPublisher(publisher);
        if (year.isBlank()) {
            getSelectedBook().setYear(-1);
        } else if (Boolean.TRUE.equals(PLHelper.isValidYear(year))) {
            getSelectedBook().setYear(Integer.parseInt(year));
        }
        getSelectedBook().setIsbn(isbn);

        if (price.isBlank() ||  price.equals("0.0") || price.equals("-1.0") || price.equals("-")) {
            getSelectedBook().setPrice(-1);
        } else {
            getSelectedBook().setPrice(PLHelper.priceFormatter(price));
        }

        getSelectedBook().setEbook(ebook);
        PLHelper.populateLibrary();
        PLHelper.getBP().setCenter(BookDetails.bookDetailsViewPane());
    }


    /**
     * Method to delete a Book object.
     * @param deleteBookModalStage the stage of the modal to confirm the deletion
     */
    public static void deleteSelectedBook(Stage deleteBookModalStage) {
        PLHelper.getPL().remove(getSelectedBook());
        PLHelper.populateLibrary();
        deleteBookModalStage.close();
        setSelectedBook(null);
        PLHelper.getBP().setCenter(BookDetails.bookDetailsViewPane());
    }

}
