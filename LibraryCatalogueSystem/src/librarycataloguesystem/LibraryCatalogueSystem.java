/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarycataloguesystem;

import java.util.List;
import repository.entities.Book;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import repository.BookRepository;
import repository.BookRepositoryFactory;

/**
 *
 * @author zx
 */
public class LibraryCatalogueSystem {

    
    private String name;
    private final BookRepository bookRepository;

    public LibraryCatalogueSystem(String name) throws Exception {
        this.name = name;
        this.bookRepository = BookRepositoryFactory.getInstance();
    }
    
    public void createBooks() {
        try {
            this.bookRepository.addBook(new Book(1,"156205533X", "133-J41", "Java!", "Tim. Ritchey", "New-Riders-Pub", "General","books.google.com.hk/books?id=HsktAAAAYAAJ&source=gbs_ViewAPI&redir_esc=y", "Web server", "books.google.com.hk/books?id=HsktAAAAYAAJ&source=gbs_ViewAPI&redir_esc=y"));
            
            System.out.println("1 book added successfully");
        } catch (Exception ex) {
            System.out.println("Failed to create books: " + ex.getMessage());
        }
    }
    
     public void searchBookByBid() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the ID of the property you want to search: ");
        int id = scanner.nextInt();
        try {
            Book book = this.bookRepository.searchBookByBid(id);
            if (book != null) {
                System.out.println(book.toString());
            } else {
                System.out.println("Property not found");
            }  
        } catch (Exception ex) {
            System.out.println("Failed to search property by ID: " + ex.getMessage());
        }
    }
     
     public void displayAllBooks() {
        try {
            for (Book book : this.bookRepository.getAllBooks()) {
                System.out.println(book.toString());
            }
        } catch (Exception ex) {
            Logger.getLogger(LibraryCatalogueSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public void searchBookByAttributes() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the title, callnumber and type of the book you want to search: ");
        String title = scanner.next();
        String callnumber = scanner.next();
        String type = scanner.next();
        try {
            List<Book> book = this.bookRepository.searchBookByAttributes(title,callnumber,type );
            if (book != null) {
                System.out.println(book.toString());
            } else {
                System.out.println("Book not found");
            }  
        } catch (Exception ex) {
            System.out.println("Failed to search property by ID: " + ex.getMessage());
        }
    }
     public void run() {
        this.createBooks();
        System.out.println("***********************************************************************************");
        this.displayAllBooks();
        System.out.println("***********************************************************************************");
        this.searchBookByAttributes();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            new LibraryCatalogueSystem("Library Catalogue System").run();
        } catch (Exception ex) {
            System.out.println("Failed to run application: " + ex.getMessage());
        }
    }
    
}
