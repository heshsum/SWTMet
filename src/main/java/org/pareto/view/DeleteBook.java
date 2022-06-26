/*
 * Menubar.java
 *
 * Copyright (c) 2020
 * All Rights Reserved.
 *
 * @version 1.00 - 20 July 2020 - HS - initial version
 */

package org.pareto.view;

import org.pareto.controller.SelectedBookHelper;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * Class to generate GUI when deleting a Book.
 * <br><code><b>[OMI-GP2-Hausarbeit]</b></code>
 *
 * @version 1.00 - 18 July 2020 - HS - initial version
 * @author   Hendrik Schlange (mail@hendrikschlange.de)
 */
public class DeleteBook {

    /**
     * Method to create a modal to confirm deletion of a Book.
     */
    static void deleteModal() {
        // Second window for new contact
        Stage deleteBookModalStage = new Stage();
        deleteBookModalStage.setTitle("");
        GridPane deleteModalPane = new GridPane();
    
        // Space between rows and column
        deleteModalPane.setHgap(10);
        deleteModalPane.setVgap(10);
    
        //space around the element root
        deleteModalPane.setPadding(new Insets(10, 10, 10, 10));
    
        Label areYouSure = new Label("Are you sure you want to delete this book?"
                + System.lineSeparator() + "This cannot be undone!" + System.lineSeparator() 
                + System.lineSeparator()
                + "Author: " + SelectedBookHelper.getSelectedBook().getAuthor() + System.lineSeparator() 
                + "Title: " + SelectedBookHelper.getSelectedBook().getTitle());
    
        Button yesButton = new Button("Of course I am!");
        yesButton.setOnAction(e -> SelectedBookHelper.deleteSelectedBook(deleteBookModalStage));
    
        Button noButton = new Button("Actually, not quite.");
        noButton.setOnAction(e -> deleteBookModalStage.close());
    
        // In order to group the button into one field of the pane,
        // a new HBox is created
        HBox buttonBox = new HBox(5);
        buttonBox.getChildren().addAll(yesButton, noButton);
    
        deleteModalPane.addRow(1, areYouSure);
        deleteModalPane.addRow(3, buttonBox);
    
        deleteBookModalStage.setScene(new Scene(deleteModalPane));
        deleteBookModalStage.setWidth(300);
        deleteBookModalStage.setHeight(200);
        deleteBookModalStage.show();
    }

}
