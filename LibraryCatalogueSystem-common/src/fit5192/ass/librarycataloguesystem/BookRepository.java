/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5192.ass.librarycataloguesystem;

import fit5192.ass.repository.entities.Book;
import fit5192.ass.repository.entities.User;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author zx
 */
@Remote
public interface BookRepository {
    /**
     * Add the property being passed as parameter into the repository
     *
     * @param property - the property to add
     */
    public void addBook(Book book) throws Exception;

    /**
     * Search for a property by its property ID
     *
     * @param id - the propertyId of the property to search for
     * @return the property found
     */
    public Book searchBookByBid(int bid) throws Exception;

    /**
     * Return all the properties in the repository
     *
     * @return all the properties in the repository
     */
    public List<Book> getAllBooks() throws Exception;
    
    /**
     * Search for a property by its title, callnumber and type
     *
     * @param title - the title of the book to search for
     * @param callnumber - the callnumber of the book to search for
     * @param typr - the type of the book to search for
     * @return the book found
     */
    public  List<Book> searchBookByTitle(String title) throws Exception;
    public  List<Book> searchBookByAuthors(String authors) throws Exception;
    public  List<Book> searchBookByCallnumber(String callnumber) throws Exception;
    public  List<Book> searchBookByType(String type) throws Exception;
    public  User searchUserByEmailANDPassword(String email,String password) throws Exception;
    public void removeBook(int bid) throws Exception;
    public void editBook(Book book) throws Exception;
}
