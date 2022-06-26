/*
 * Menubar.java
 *
 * Copyright (c) 2020
 * All Rights Reserved.
 *
 * @version 1.00 - 24 June 2020 - HS - initial version
 */

package org.pareto.view;

import java.io.File;

import org.pareto.controller.SelectedBookHelper;
import org.pareto.controller.PLHelper;
import org.pareto.controller.XMLExporter;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Window;
import org.pareto.model.Book;

import static org.pareto.controller.LogHelper.log;

/**
 * Class to generate the Book details view at the center of the GUI.
 * <br><code><b>[OMI-GP2-Hausarbeit]</b></code>
 *
 * @version 1.00 - 03 July 2020 - HS - initial version
 * @author   Hendrik Schlange (mail@hendrikschlange.de)
 */
public class BookDetails {

    /**
     * Creates a GriPand view of a Book object.
     * @return the GridPane to view the Book object
     */
    public static GridPane bookDetailsViewPane() {
        GridPane bookDetailsViewPane = new GridPane();
        bookDetailsViewPane.setHgap(5);
        bookDetailsViewPane.setVgap(5);
        bookDetailsViewPane.setPadding(new Insets(10, 10, 10, 10));

        // Show grid when debugging mode is active
        bookDetailsViewPane.setGridLinesVisible(PLHelper.getDebug());

        // Only show the Grid if a Book has been selected
        if (SelectedBookHelper.getSelectedBook() != null) {

            Label authorLabel = new Label("Author:");
            Text authorField = new Text(SelectedBookHelper.getSelectedBook().getAuthor());
            Label titleLabel = new Label("Title:");
            Text titleField = new Text(SelectedBookHelper.getSelectedBook().getTitle());
            Label publisherLabel = new Label("Publisher:");
            Text publisherField = new Text(SelectedBookHelper.getSelectedBook().getPublisher());
            Label yearLabel = new Label("Year:");

            // If year is -1 --> show "-"
            String yearValue = String.valueOf(SelectedBookHelper.getSelectedBook().getYear());
            if (yearValue.equals("-1")) {
                yearValue = "-";
            }
            Text yearField = new Text(yearValue);
            Label isbnLabel = new Label("ISBN:");
            Text isbnField = new Text(SelectedBookHelper.getSelectedBook().getIsbn());
            Label priceLabel = new Label("Price:");

            // If price is -1.0 --> show "-"
            String priceValue = String.valueOf(SelectedBookHelper.getSelectedBook().getPrice());
            if (priceValue.equals("-1.0")) {
                priceValue = "-";
            }
            Text priceField = new Text(priceValue);

            Label ebookLabel = new Label("E-Book");
            CheckBox ebookBox = new CheckBox();
            ebookBox.setSelected(SelectedBookHelper.getSelectedBook().getEbook());
            ebookBox.setDisable(true);

            Button exportButton = new Button("Export book");
            exportButton.setOnAction(actionEvent -> {
                FileChooser exportFileChooser = new FileChooser();

                // Set filter for export to XML
                FileChooser.ExtensionFilter xmlExtensionFilter = new FileChooser.
                        ExtensionFilter("XML file (*.xml)", "*.xml");
                exportFileChooser.getExtensionFilters().add(xmlExtensionFilter);

                Window primaryStage = null;
                //Show save file dialog
                File file = exportFileChooser.showSaveDialog(primaryStage);
                if (file != null) {
                    XMLExporter.exportToXML(file);
                }
            });

            bookDetailsViewPane.addRow(1, authorLabel, authorField);
            bookDetailsViewPane.addRow(2, titleLabel, titleField);
            bookDetailsViewPane.addRow(3, publisherLabel, publisherField);
            bookDetailsViewPane.addRow(4, yearLabel, yearField);
            bookDetailsViewPane.addRow(5, isbnLabel, isbnField);
            bookDetailsViewPane.addRow(6, priceLabel, priceField);
            bookDetailsViewPane.addRow(7, ebookLabel, ebookBox);
        }
        return bookDetailsViewPane;
    }


    /**
     * Creates a GriPand edit screen of a Book object.
     * @return the GridPane to edit the Book object
     */
    public static GridPane bookDetailsEditPane() {
        GridPane bookDetailsEditPane = new GridPane();
        bookDetailsEditPane.setHgap(5);
        bookDetailsEditPane.setVgap(5);
        bookDetailsEditPane.setPadding(new Insets(10, 10, 10, 10));

        // Show grid when debugging mode is active
        bookDetailsEditPane.setGridLinesVisible(PLHelper.getDebug());

        Label authorLabel = new Label("Author:");
        TextField authorField = new TextField(SelectedBookHelper.getSelectedBook().getAuthor());
        Label titleLabel = new Label("Title:");
        TextField titleField = new TextField(SelectedBookHelper.getSelectedBook().getTitle());
        Label publisherLabel = new Label("Publisher:");
        TextField publisherField = new TextField(SelectedBookHelper.getSelectedBook().getPublisher());
        Label yearLabel = new Label("Year:");
        
        // If yearValue = -1, don't show it
        String yearValue = String.valueOf(SelectedBookHelper.getSelectedBook().getYear());
        if (yearValue.equals("-1")) {
            yearValue = "";
        }
        TextField yearField = new TextField(yearValue);
        
        Label isbnLabel = new Label("ISBN:");
        TextField isbnField = new TextField(SelectedBookHelper.getSelectedBook().getIsbn());
        Label priceLabel = new Label("Price:");

        // If price is -1.0 --> show nothing
        String priceValue = String.valueOf(SelectedBookHelper.getSelectedBook().getPrice());
        if (priceValue.equals("-1.0")) {
            priceValue = "";
        }
        TextField priceField = new TextField(priceValue);

        Label ebookLabel = new Label("E-Book");
        CheckBox ebookBox = new CheckBox();
        ebookBox.setSelected(SelectedBookHelper.getSelectedBook().getEbook());

        Text errorMessage = new Text("");
        errorMessage.setFill(Color.RED);

        Button saveBookButton = new Button("Save");
        saveBookButton.setOnAction(actionEvent -> {
            if (authorField.getText().isBlank() ||  titleField.getText().isBlank()) {
                errorMessage.setText("Author and Title are mandatory to create new books.");
            } else {
                SelectedBookHelper.saveSelectedBook(authorField.getText(), titleField.getText(), publisherField.getText(),
                        yearField.getText(), isbnField.getText(),
                        priceField.getText(), ebookBox.isSelected());
            }
        });
        Button cancelEditBookButton = new Button("Cancel");
        cancelEditBookButton.setOnAction(e -> PLHelper.getBP().setCenter(bookDetailsViewPane()));

        Button deleteBookButton = new Button("Delete");
        deleteBookButton.setOnAction(e -> DeleteBook.deleteModal()); 

        bookDetailsEditPane.addRow(1, authorLabel, authorField);
        bookDetailsEditPane.addRow(2, titleLabel, titleField);
        bookDetailsEditPane.addRow(3, publisherLabel, publisherField);
        bookDetailsEditPane.addRow(4, yearLabel, yearField);
        bookDetailsEditPane.addRow(5, isbnLabel, isbnField);
        bookDetailsEditPane.addRow(6, priceLabel, priceField);
        bookDetailsEditPane.addRow(7, ebookLabel, ebookBox);
        bookDetailsEditPane.add(errorMessage, 0, 8, 3, 1);
        bookDetailsEditPane.addRow(9, saveBookButton, cancelEditBookButton, deleteBookButton);

        return bookDetailsEditPane;
    }


    /**
     * Creates a GriPane to create a new Book object.
     * @return the GridPane to edit the Book object
     */
    public static GridPane createBookPane() {
        GridPane createBookPane = new GridPane();
        createBookPane.setHgap(5);
        createBookPane.setVgap(5);
        createBookPane.setPadding(new Insets(10, 10, 10, 10));

        // Show grid when debugging mode is active
        createBookPane.setGridLinesVisible(PLHelper.getDebug());

        Label authorLabel = new Label("Author:");
        TextField authorField = new TextField();
        Label titleLabel = new Label("Title:");
        TextField titleField = new TextField();
        Label publisherLabel = new Label("Publisher:");
        TextField publisherField = new TextField();
        Label yearLabel = new Label("Year:");
        TextField yearField = new TextField();
        Label isbnLabel = new Label("ISBN:");
        TextField isbnField = new TextField();
        Label priceLabel = new Label("Price:");
        TextField priceField = new TextField();
        Label ebookLabel = new Label("E-Book");
        CheckBox ebookBox = new CheckBox();
        ebookBox.setSelected(false);

        Text errorMessage = new Text("");
        errorMessage.setFill(Color.RED);

        Button saveBookButton = new Button("Save");
        saveBookButton.setOnAction(new EventHandler<ActionEvent>() {
            Book newBook;
            @Override
            public void handle(ActionEvent actionEvent) {
                if (authorField.getText().isBlank() ||  titleField.getText().isBlank()) {
                    errorMessage.setText("Author and Title are mandatory to create new books.");
                } else {
                    newBook = new Book(authorField.getText(), titleField.getText());
                    try {
                        newBook.setPublisher(publisherField.getText());
                        if (Boolean.TRUE.equals(PLHelper.isValidYear(yearField.getText()))) {
                            newBook.setYear(Integer.parseInt(yearField.getText()));
                        }
                        newBook.setIsbn(isbnField.getText());
                        newBook.setPrice(PLHelper.priceFormatter(priceField.getText()));
                        if (ebookBox.isSelected()) {
                            newBook.setEbook(true);
                        }
                    } catch (Exception nullException) {
                        log(nullException);
                    }

                    PLHelper.getPL().add(newBook);
                    PLHelper.populateLibrary();
                    SelectedBookHelper.setSelectedBook(newBook);
                    PLHelper.getBP().setCenter(bookDetailsViewPane());
                }
            }
        });

        Button cancelEditBookButton = new Button("Cancel");
        cancelEditBookButton.setOnAction(e -> PLHelper.getBP().setCenter(bookDetailsViewPane())); 

        createBookPane.addRow(1, authorLabel, authorField);
        createBookPane.addRow(2, titleLabel, titleField);
        createBookPane.addRow(3, publisherLabel, publisherField);
        createBookPane.addRow(4, yearLabel, yearField);
        createBookPane.addRow(5, isbnLabel, isbnField);
        createBookPane.addRow(6, priceLabel, priceField);
        createBookPane.addRow(7, ebookLabel, ebookBox);
        createBookPane.add(errorMessage, 0, 8, 3, 1);
        createBookPane.addRow(9, saveBookButton, cancelEditBookButton);

        return createBookPane;
    }

}
