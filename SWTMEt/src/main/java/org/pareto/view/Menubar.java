/*
 * Menubar.java
 *
 * Copyright (c) 2020
 * All Rights Reserved.
 *
 * @version 1.00 - 15 June 2020 - HS - initial version
 */

package org.pareto.view;

import java.io.File;
import org.pareto.controller.SelectedBookHelper;
import org.pareto.controller.PLHelper;
import org.pareto.controller.XMLExporter;
import org.pareto.controller.XMLImporter;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.Window;

/**
 * Class to generate the menu bar at the top of the GUI.
 * <br><code><b>[OMI-GP2-Hausarbeit]</b></code>
 *
 * @version 1.00 - 01 July 2020 - HS - initial version
 * @author   Hendrik Schlange (mail@hendrikschlange.de)
 */
public class Menubar {

    /**
     * Method to generate the HBox object for the menubar in the GUI.
     * @return the HBox object for the menubar
     */
    public static HBox menubar() {
        HBox box = new HBox(5);
        box.setPadding(new Insets(10, 10, 10, 10));

        Button createBookButton = new Button("Create book");
        createBookButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                PLHelper.getBP().setCenter(BookDetails.createBookPane());
                // Setting selectedBook == null to deactivate the "Edit" Button
                SelectedBookHelper.setSelectedBook(null);
            }
        });

        // Button to show a book in the edit view
        Button editBookButton = new Button("Edit book");
        editBookButton.setOnAction(e -> PLHelper.getBP().setCenter(BookDetails.bookDetailsEditPane()));
        
        // The button should only be clickable if a book has been selected
        if (SelectedBookHelper.getSelectedBook() == null) {
            editBookButton.setDisable(true);
        }

        // Button for exporting the whole library to XML
        Button exportButton = new Button("Export library");
        exportButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                FileChooser exportFileChooser = new FileChooser();

                // Set filter for export to XML
                FileChooser.ExtensionFilter xmlExtensionFilter = new FileChooser.
                        ExtensionFilter("XML file (*.xml)", "*.xml");
                exportFileChooser.getExtensionFilters().add(xmlExtensionFilter);

                Window exportStage = null;
                
                //Show save file dialog
                File exportFile = exportFileChooser.showSaveDialog(exportStage);
                if (exportFile != null) {
                    // When the export file is set, trigger the XML export
                    XMLExporter.exportToXML(exportFile);
                }
            }

        });
        
        // Exporting the library should only be possible if the PersonalLibrary has entries
        if (PLHelper.getPL().getSize() == 0) {
            exportButton.setDisable(true);
        }

        // Button to import a library from XML
        Button importButton = new Button("Import library");
        importButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                FileChooser importFileChooser = new FileChooser();
                
                // Set filter for export to XML
                FileChooser.ExtensionFilter xmlExtensionFilter = new FileChooser.
                        ExtensionFilter("XML file (*.xml)", "*.xml");
                importFileChooser.getExtensionFilters().add(xmlExtensionFilter);
                
                Window importStage = null;
                
                // After the import file was set, trigger the XML import
                File importFile = importFileChooser.showOpenDialog(importStage);
                if (importFile != null) {
                    XMLImporter.importFromXML(importFile);
                }
                
            }
        
        });

        // Adding all entries to the box
        box.getChildren().addAll(createBookButton, editBookButton, exportButton, importButton);
        return box;
    }
}
