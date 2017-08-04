/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5192.ass.gui;

import fit5192.ass.repository.entities.Book;
import java.util.List;
import java.util.Set;
import javax.swing.JButton;
import javax.swing.JTable;

/**
 *
 * @author zx
 */
public interface LibraryCatalogueSystemGUI {
    /**
     * Clear all the inputs in the GUI
     */
    void clearInput();

    /**
     * Clear all the text fields in the GUI
     */
    void clearTextFields();
    
    /**
     * Clear all the combo boxes in the GUI
     */
    void clearComboBoxes();
    
    /**
     * Clear all records in the table
     */
    void clearBookTable();

    /**
     * Display a message in a dialog box
     *
     * @param message - the message to display
     */
    void displayMessageInDialog(String message);

    /**
     * Display the details of the properties
     *
     * @param property - the details of the property to display
     */
    void displayBookDetails(Book book);
    
    /**
     * Display the details of the selected properties
     *
     * @param property - the details of the selected property to display
     */
    void displaySelectedBookDetails(List<Book> book);
    
    /**
     * Display the details of the properties
     *
     * @param properties - the details of the properties to display
     */
    void displayBookDetails(List<Book> books);
    
    /**
     * Display the details of the properties
     *
     * @param properties - the details of the properties to display
     */
    void displayBookDetails(Set<Book> books);
    
    /**
     * Return the ID of the property selected in table
     *
     * @return the ID of the selected property
     */
   // int getSelectedBookBid() throws Exception;
    String getSelectedBookCallNumber() throws Exception;
    /**
     * Return the Add Property button
     *
     * @return the attribute addButton
     */
   // JButton getAddButton();

    /**
     * Return the Close Window button
     *
     * @return the attribute closeButton
     */
    JButton getCloseButton();
    
    /**
     * Return the Search Property by ID button
     *
     * @return the attribute searchButton
     */
    JButton getSearchButton();

    /**
     * Return the Display All Properties button
     *
     * @return the attribute viewButton
     */
    //JButton getViewButton(); 
    
    /**
     * Return the Update Property Details button
     *
     * @return the attribute updateButton
     */
    //public JButton getUpdateButton();

    /**
     * Return the Delete Property Details button
     *
     * @return the attribute deleteButton
     */
   // public JButton getDeleteButton();

    /**
     * Return the Book Details table
     *
     * @return the attribute propertyTable
     */
    public JTable getBookTable();

    /**
     * Return the details of the Book to add to the repository
     *
     * @return a Property object that contains all the details
     */
    Book getBookDetails();

    /**
     * Return the id of the book to search the repository for
     *
     * @return the id of the property to search the repository for
     */
  //  int getBookBid();
    
    String getBookTitle();
    String getBookAuthors();
    String getBookCallnumber();
    String getBookType();
    /**
     * Return the contact person to search the repository for
     *
     * @return the contact person of a property
     */
   // ContactPerson getSelectedContactPerson();
    
    /**
     * Indicate whether any property is selected
     *
     * @return true if a property is selected, or false otherwise
     */
    boolean isBookSelected();
}
