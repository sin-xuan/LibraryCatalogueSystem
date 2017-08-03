/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5192.ass.librarycataloguesystem;

import fit5192.ass.repository.entities.Book;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author zx
 */
@Stateless
public class JPALibraryCatalogueSystemImpl implements BookRepository {

    
    @PersistenceContext
    private EntityManager entityManager;
    
    private final List<Book> books;
    private final List<Book> booksearch;
    
    protected JPALibraryCatalogueSystemImpl()
    {
        books = new ArrayList<>();
        booksearch= new ArrayList<>();
    }
    
    @Override
    public void addBook(Book book) throws Exception {
//        if ((!books.contains(book)) && (searchBookByBid(book.getBid()) == null))
//            books.add(book);
            entityManager.persist(book);
    }

    @Override
    public Book searchBookByBid(int bid) throws Exception {
        for (Book book : this.books) {
            if (book.getBid() == bid) {
                return book;
            }
        }
        
        return null;
    }

    @Override
    public List<Book> getAllBooks() throws Exception {
        return entityManager.createNamedQuery(Book.FIND_ALL).getResultList();
    }
    /*
    @Override
    public List<Book> getAllBooks() throws Exception {
        List<Book> books = new ArrayList<>(this.books.size());
        for (Book book : this.books) {
            books.add(new Book(book));
        }
        return books;
    }
    */
    @Override
    public List<Book> searchBookByAttributes(String title, String authors,String callnumber, String type) throws Exception{
    
        List<Book> booksearch=new ArrayList<>(this.booksearch.size());
        for (Book book : this.books) {
            if (book.getTitle().equals(title) &&book.getAuthors().equals(authors) && book.getCallnumber().equals(callnumber) && book.getType().equals(type)) {
                booksearch.add(new Book(book));
                
            }
        }
        
        return booksearch;
    
    
    
    }
    
}
