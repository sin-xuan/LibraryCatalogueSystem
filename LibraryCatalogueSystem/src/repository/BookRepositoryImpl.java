/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import repository.entities.Book;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author zx
 */
public class BookRepositoryImpl implements BookRepository{

    private final List<Book> books;
    private final List<Book> booksearch;

    protected BookRepositoryImpl()
    {
        books = new ArrayList<>();
        booksearch= new ArrayList<>();
    }
    
    
    @Override
    public void addBook(Book book) throws Exception {
        if ((!books.contains(book)) && (searchBookByBid(book.getBid()) == null))
            books.add(book);
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
        List<Book> books = new ArrayList<>(this.books.size());
        for (Book book : this.books) {
            books.add(new Book(book));
        }
        return books;
    }
    
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
