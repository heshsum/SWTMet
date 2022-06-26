/*
 * LibraryList.java
 *
 * Copyright (c) 2020
 * All Rights Reserved.
 *
 * @version 1.00 - 18 July 2020 - HS - initial version
 */

package org.pareto.view;

import org.pareto.controller.SelectedBookHelper;
import org.pareto.controller.PLHelper;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import org.pareto.model.Book;
import static org.pareto.controller.LogHelper.log;

/**
 * Class to generate the list of Book objects for a PersonalLibrary.
 * <br><code><b>[OMI-GP2-Hausarbeit]</b></code>
 *
 * @version 1.00 - 18 July 2020 - HS - initial version
 * @author   Hendrik Schlange (mail@hendrikschlange.de)
 */
public class LibraryList {

    /** Private constructor to hide the public one. */
    private LibraryList() {
        log("Utility class");
    }
    
    /**
     * Method to create the VBox for the PersonalLibrary.
     * @return the VBox object for the PersonalLibrary
     */
    public static VBox createLibraryListBox() {
        VBox libraryListBox = new VBox();
        libraryListBox.setSpacing(10);

        // Creation of a LibraryList, adding the observable list and adding it to the VBox
        libraryListBox.getChildren().add(createListView());

        return libraryListBox;
    }


    /**
     * Method to create the ListView of Book objects.
     * @return the ListView of Book objects
     */
    private static ListView<Book> createListView() {
        ListView<Book> bookList = new ListView<>();
        bookList.setItems(PLHelper.getPersonalLibraryObservableList());

        bookList.setOnMouseClicked(mouseEvent -> {
            SelectedBookHelper.setSelectedBook(PLHelper.getPL().get(bookList.getSelectionModel().getSelectedIndex()));
            PLHelper.getBP().setTop(Menubar.menubar());
            PLHelper.getBP().setCenter(BookDetails.bookDetailsViewPane());
        });
        return bookList;
    }
    
}
