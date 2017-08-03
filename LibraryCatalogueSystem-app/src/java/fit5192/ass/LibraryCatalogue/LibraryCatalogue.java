/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5192.ass.LibraryCatalogue;

import fit5192.ass.gui.LibraryCatalogueSystemGUI;
import fit5192.ass.gui.TableGUIImpl;
import fit5192.ass.librarycataloguesystem.BookRepository;
import fit5192.ass.repository.entities.Book;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.ejb.EJB;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author zx
 */
public class LibraryCatalogue implements ActionListener, ListSelectionListener{
    

     @EJB
    private static BookRepository bookRepository;

    
    private LibraryCatalogueSystemGUI gui;
    private String name;
    public LibraryCatalogue(String name) throws Exception{
        this.name = name;
    }
    
    public void initView() {
        this.gui = new TableGUIImpl(this, this);
        this.displayAllBooks();
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == gui.getSearchButton()) {
            this.displaySearchBooks();
        } else if(event.getSource() == gui.getCloseButton()){
            System.exit(0);
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        
    }
    
    private void displayAllBooks() {
        try {
            List<Book> books = bookRepository.getAllBooks();
            
            if (books != null) {
                this.gui.displayBookDetails(books);
            }
            
        } catch (Exception ex) {
            this.gui.displayMessageInDialog("Failed to retrieve properties: " + ex.getMessage());
        }
    }
    
    public void displaySearchBooks() {
        
        try {
            if(gui.getBookTitle()!=null){
            String title = gui.getBookTitle();
            this.gui.displayBookDetails(bookRepository.searchBookByTitle(title));
            }
            else if (gui.getBookAuthors()!=null){
            String authors = gui.getBookAuthors();
            this.gui.displayBookDetails(bookRepository.searchBookByAuthors(authors));
            }
            else if(gui.getBookCallnumber()!=null){
            String callnumber = gui.getBookCallnumber();
            this.gui.displayBookDetails(bookRepository.searchBookByCallnumber(callnumber));
            }
            else if(gui.getBookType()!=null){
            String type = gui.getBookType();
            this.gui.displayBookDetails(bookRepository.searchBookByType(type));
            }
            
        } catch (Exception ex) {
            this.gui.displayMessageInDialog("Failed to search book: " + ex.getMessage());
            this.gui.clearBookTable();
        } finally {
            this.gui.clearInput();
        }
    }
    /*
    public void searchBookByAttribute(String title, String authors, String callnumber, String type) {
        
        try {
            List<Book> booksearch = bookRepository.searchBookByAttributes(title, authors, callnumber, type);
            
            
            if (booksearch != null) {
                this.gui.displayBookDetails(booksearch);
            } else {
                this.gui.displayMessageInDialog("No matched books found");
                this.gui.clearBookTable();
            }  
        } catch (Exception ex) {
            this.gui.displayMessageInDialog("Failed to search property by ID: " + ex.getMessage());
            this.gui.clearBookTable();
        } finally {
            this.gui.clearInput();
        }
    }*/
    /*
    public void searchBookByAttribute(String title, String authors, String callnumber, String type) {
        
        try {
            List<Book> booksearch = bookRepository.searchBookByAttributes(title, authors, callnumber, type);
            
            
            if (booksearch != null) {
                this.gui.displayBookDetails(booksearch);
            } else {
                this.gui.displayMessageInDialog("No matched books found");
                this.gui.clearBookTable();
            }  
        } catch (Exception ex) {
            this.gui.displayMessageInDialog("Failed to search property by ID: " + ex.getMessage());
            this.gui.clearBookTable();
        } finally {
            this.gui.clearInput();
        }
    }
    */
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            final LibraryCatalogue library = new LibraryCatalogue("Library_Catalogue_System");
            library.initView();
        } catch (Exception ex) {
            System.out.println("Failed to run application: " + ex.getMessage());
        }
    }
}
