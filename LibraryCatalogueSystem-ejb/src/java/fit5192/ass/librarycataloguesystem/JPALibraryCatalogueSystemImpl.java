/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5192.ass.librarycataloguesystem;

import fit5192.ass.repository.entities.Book;
import fit5192.ass.repository.entities.User;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


/**
 *
 * @author zx
 */
@Stateless
public class JPALibraryCatalogueSystemImpl implements BookRepository {

    
    @PersistenceContext
    private EntityManager entityManager;
    private Book fixbook;
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
        Query query = entityManager.createQuery("select b from Book b WHERE b.bid = :bookId", Book.class);
        query.setParameter("bookId", bid);
        return (Book) query.getSingleResult();
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
    public List<Book> searchBookByTitle(String title) throws Exception{
    
        Query query = entityManager.createNamedQuery(Book.FIND_BY_TITLE);
        query.setParameter("title", title);
        return query.getResultList();

    }
    /*
    @Override
    public List<Book> searchBookByAttributes(String title, String authors,String callnumber, String type) throws Exception{
    
        List<Book> booksearch=new ArrayList<>(this.booksearch.size());
        for (Book book : this.books) {
            if (book.getTitle().equals(title) &&book.getAuthors().equals(authors) && book.getCallnumber().equals(callnumber) && book.getType().equals(type)) {
                booksearch.add(new Book(book));
                
            }
        }
        return booksearch;
    }*/

    @Override
    public List<Book> searchBookByAuthors(String authors) throws Exception {
        Query query = entityManager.createNamedQuery(Book.FIND_BY_AUTHORS);
        query.setParameter("authors", authors);
        return query.getResultList();
    }

    @Override
    public List<Book> searchBookByCallnumber(String callnumber) throws Exception {
        Query query = entityManager.createNamedQuery("Book.findByCallNumber");
        query.setParameter("callnumber", callnumber);
        return query.getResultList();
    }

    
    @Override
    public List<Book> searchBookByType(String type) throws Exception {
        Query query = entityManager.createNamedQuery("Book.findByType");
        query.setParameter("type", type);
        return query.getResultList();
    }

    @Override
    public User searchUserByEmailANDPassword(String email, String password) throws Exception {
        Query query = entityManager.createQuery("SELECT u from User u WHERE u.email = :email AND u.password = :password", User.class);
        query.setParameter("email", email);
        query.setParameter("password", password);
        List<User> users = query.getResultList();
        if(users.size()>0){
            return users.get(0);
        }
        return null;
    }

    @Override
    public void removeBook(int bid) throws Exception {
        Book book= this.searchBookByBid(bid);
        if(book!=null){
          entityManager.remove(book);
        }
    }

    @Override
    public void editBook(Book book) throws Exception {
       entityManager.merge(book);
    }
    
}
