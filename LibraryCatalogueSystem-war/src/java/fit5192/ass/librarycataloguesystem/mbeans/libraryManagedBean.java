/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5192.ass.librarycataloguesystem.mbeans;

import fit5192.ass.librarycataloguesystem.BookRepository;
import fit5192.ass.repository.entities.Book;
import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author zx
 */
@Named(value = "libraryManagedBean")
@ApplicationScoped
public class libraryManagedBean implements Serializable{

    public static final String APP_TITLE="Library Catalogue System";
    private BookRepository borrowbook;
    private Book book;

    public BookRepository getBorrowbook() {
        return borrowbook;
    }

    public Book getBook() {
        return book;
    }

    public void setBorrowbook(BookRepository borrowbook) {
        this.borrowbook = borrowbook;
    }

    public void setBook(Book book) {
        this.book = book;
    }
    
    
    /**
     * Creates a new instance of libraryManagedBean
     */
    public libraryManagedBean() {
        this.book=new Book();
    }
    
}
