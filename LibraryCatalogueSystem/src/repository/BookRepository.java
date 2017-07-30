/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import entities.Book;
import java.util.List;

/**
 *
 * @author zx
 */
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
}
