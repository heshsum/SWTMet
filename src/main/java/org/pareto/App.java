package org.pareto;

/*
 * Run.java
 *
 * Copyright (c) 2020
 * All Rights Reserved.
 *
 * @version 1.00 - 18 July 2020 - HS - initial version
 */

import org.pareto.controller.PLHelper;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.pareto.view.BookDetails;
import org.pareto.view.LibraryList;
import org.pareto.view.Menubar;

/**
 A class for the UI of the library.
 <br><code><b>[OMI-GP2-Hausarbeit]</b></code>
 */
public class App extends Application {



    @Override
    public void start(Stage mainStage) {


        // Populate the list with entries
        PLHelper.populateLibrary();

        // Adding the list view and the details view to the border pane
        PLHelper.getBP().getChildren().add(LibraryList.createLibraryListBox());
        PLHelper.getBP().getChildren().add(BookDetails.bookDetailsViewPane());

        // Setting the menu bar to the top and the list to the left
        PLHelper.getBP().setTop(Menubar.menubar());
        PLHelper.getBP().setLeft(LibraryList.createLibraryListBox());

        // Setting title, scene and size of the window
        mainStage.setTitle("My personal library");
        mainStage.setScene(new Scene(PLHelper.getBP()));
        mainStage.setWidth(1024);
        mainStage.setHeight(500);
        mainStage.show();
    }


    /**
     * Method to launch the application.
     * @param args not used
     */
    public static void main(String[] args) {

        // Initializing the border pane the GUI is based on and the library
        PLHelper.setBP();
        PLHelper.setPL();

        // Set the debug mode
        PLHelper.setDebug(false);

        launch(args);
    }
}