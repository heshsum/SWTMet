/*
 * XMLImporter.java
 *
 * Copyright (c) 2020
 * All Rights Reserved.
 *
 * @version 1.00 - 18 July 2020 - HS - initial version
 */

package org.pareto.controller;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.pareto.model.Book;
import static org.pareto.controller.LogHelper.log;

/**
 * Class generate Book entries from an XML export file.
 * <br><code><b>[OMI-GP2-Hausarbeit]</b></code>
 *
 * @version 1.00 - 18 July 2020 - HS - initial version
 * @author   Hendrik Schlange (mail@hendrikschlange.de)
 */
public class XMLImporter {

    /**
     * Private Constructor.
     */
    private XMLImporter() {
        log("Utility class");
    }

    /**
     * Method to import Book object via XML file import.
     * @param importFile the File stream for the file
     */
    public static void importFromXML(File importFile) {

        try {
            // Opening and parsing the file
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document importDocument = dBuilder.parse(importFile);

            // Creating a list of all nodes of type "book"
            // Each node contains one book
            NodeList booksList = importDocument.getElementsByTagName("book");

            // Iterating over the list of "book" nodes in order to import them.
            for (int i = 0; i < booksList.getLength(); i++) {

                // Setting the current node in the list of all "book" nodes
                Node currentNode = booksList.item(i);

                // Checking of the the node is actually a parseable element
                if (currentNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element currentElement = (Element) currentNode;

                    // Creating temporary variables to make things a bit more comprehensible
                    String tempAuthor = currentElement.getElementsByTagName("author").
                            item(0).getTextContent();
                    String tempTitle = currentElement.getElementsByTagName("title").
                            item(0).getTextContent();
                    String tempPublisher = currentElement.getElementsByTagName("publisher").
                            item(0).getTextContent();
                    String tempYear = currentElement.getElementsByTagName("year").
                            item(0).getTextContent();
                    String tempIsbn = currentElement.getElementsByTagName("isbn").
                            item(0).getTextContent();
                    String tempPrice = currentElement.getElementsByTagName("price").
                            item(0).getTextContent();
                    Boolean tempEbook = Boolean.parseBoolean(currentElement.
                            getElementsByTagName("ebook").item(0).getTextContent());

                    // author and title are mandatory
                    // Only create a new book if both fields are filled
                    if (!tempAuthor.isBlank() && !tempTitle.isBlank()) {
                        Book newBook = new Book(tempAuthor, tempTitle);

                        // After the book was created, the other attributes are set
                        newBook.setPublisher(tempPublisher);
                        if (Boolean.TRUE.equals(PLHelper.isValidYear(tempYear))) {
                            newBook.setYear(Integer.parseInt(tempYear));
                        }
                        newBook.setIsbn(tempIsbn);
                        
                        if (!tempPrice.isBlank()) {
                            newBook.setPrice(PLHelper.priceFormatter(tempPrice));
                        }
                        
                        newBook.setEbook(tempEbook);

                        // Adding the book to the PersonalLibrary
                        PLHelper.getPL().add(newBook);
                    }
                }
            }

            // After finishing the import, refresh the list view to show any new books
            PLHelper.populateLibrary();

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}
