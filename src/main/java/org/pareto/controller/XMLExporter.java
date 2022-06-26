/*
 * XMLExporter.java
 *
 * Copyright (c) 2020
 * All Rights Reserved.
 *
 * @version 1.00 - 18 July 2020 - HS - initial version
 */

package org.pareto.controller;

import java.io.File;
import java.time.LocalDateTime;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import static org.pareto.controller.LogHelper.log;

/**
 * Class to generate XML exports for PersonalLibrary objects.
 * <br><code><b>[OMI-GP2-Hausarbeit]</b></code>
 *
 * @version 1.00 - 18 July 2020 - HS - initial version
 * @author   Hendrik Schlange (mail@hendrikschlange.de)
 */
public class XMLExporter {

    private XMLExporter() {
        log("Utility class");
    }

    /** XML element for a book entry. */
    static Element bookElement;

    /**
     * Creates an XML document for the whole PersonalLibrary.
     * @param file the file stream to save the XML to
     */
    public static void exportToXML(File file) {
        try {

            // Initializing Factory and Builders for the document
            DocumentBuilderFactory xmlDocFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder xmlDocBuilder = xmlDocFactory.newDocumentBuilder();
            Document xmlDoc = xmlDocBuilder.newDocument();

            // Adding the root element of the document (this element is static)
            Element root = xmlDoc.createElement("PersonalLibrary");

            // For reference purposes, adding an attribute to the root element 
            // with the current date and time
            root.setAttribute("date", String.valueOf(LocalDateTime.now()));

            // for-loop to iterate through the PersonalLibrary and
            // extract all information per book
            for (int i = 0; i < PLHelper.getPL().getSize(); i++) {
                bookElement = xmlDoc.createElement("book");
                bookElement.setAttribute("id", String.valueOf(i));

                // Calling the method that created the XML nodes with the details per book
                createBookEntry(xmlDoc, bookElement, i);
                // Adding the book element to the XML file
                root.appendChild(bookElement);
            }

            // Adding the root element to the XML file
            xmlDoc.appendChild(root);

            // Saving the XML file
            xmlDocToFile(xmlDoc, file);

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }

        return;
    }


    /**
     * Method to generate the XML nodes for a single Book entry.
     * @param xmlDoc the document to append
     * @param bookElement the element to nest the nodes underneath
     * @param i the index of the Book object
     */
    private static void createBookEntry(Document xmlDoc, Element bookElement, int i) {
        Element author = xmlDoc.createElement("author");
        author.setTextContent(PLHelper.getPL().get(i).getAuthor());
        bookElement.appendChild(author);

        Element title = xmlDoc.createElement("title");
        title.setTextContent(PLHelper.getPL().get(i).getTitle());
        bookElement.appendChild(title);

        Element publisher = xmlDoc.createElement("publisher");
        publisher.setTextContent(PLHelper.getPL().get(i).getPublisher());
        bookElement.appendChild(publisher);

        Element year = xmlDoc.createElement("year");
        String yearString = String.valueOf(PLHelper.getPL().get(i).getYear());
        if (yearString.equals("-1")) {
            yearString = "";
        }
        year.setTextContent(yearString);
        bookElement.appendChild(year);

        Element isbn = xmlDoc.createElement("isbn");
        isbn.setTextContent(PLHelper.getPL().get(i).getIsbn());
        bookElement.appendChild(isbn);

        Element price = xmlDoc.createElement("price");
        String priceString = String.valueOf(PLHelper.getPL().get(i).getPrice());
        if (priceString.equals("-1.0")) {
            priceString = "";
        }
        price.setTextContent(priceString);
        bookElement.appendChild(price);

        Element ebook = xmlDoc.createElement("ebook");
        ebook.setTextContent(String.valueOf(PLHelper.getPL().get(i).getEbook()));
        bookElement.appendChild(ebook);
    }


    /**
     * Creates a file export from an XML document.
     * @param xmlDoc the XML document to save
     * @param file the file stream to save the document to
     */
    private static void xmlDocToFile(Document xmlDoc, File file) {
        try {
            TransformerFactory transFactory = TransformerFactory.newInstance();
            Transformer transformer = transFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
            Source xmlDocSource = new DOMSource(xmlDoc);
            Result fileResult = new StreamResult(file);
            transformer.transform(xmlDocSource, fileResult);

        } catch (TransformerConfigurationException e1) {
            e1.printStackTrace();

        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
}
