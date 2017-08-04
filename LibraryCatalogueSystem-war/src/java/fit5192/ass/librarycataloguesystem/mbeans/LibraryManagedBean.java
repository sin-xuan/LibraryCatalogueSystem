/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5192.ass.librarycataloguesystem.mbeans;

import fit5192.ass.librarycataloguesystem.BookRepository;
import fit5192.ass.librarycataloguesystem.navigation.Navigation;
import fit5192.ass.repository.entities.Book;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author zx
 */
@ManagedBean
@SessionScoped
public class LibraryManagedBean implements Serializable{

    public static final String APP_TITLE="Library Catalogue System";
    @EJB
    private BookRepository searchbook;
    private Book bookr;
    private List<Book> books;
    private String title;
    private String authors;
    private String callnumber;
    private String type;
    private int bid;
    private String message;

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public String getCallnumber() {
        return callnumber;
    }

    public void setCallnumber(String callnumber) {
        this.callnumber = callnumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    



    public void setSearchbook(BookRepository searchbook) {
        this.searchbook = searchbook;
    }

    public Book getBookr() {
        return bookr;
    }

    public void setBookr(Book bookr) {
        this.bookr = bookr;
    }

    


    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

   
    
    public String searchBook() throws Exception{
        //success one!
        //books = this.searchbook.searchBookByTitle(title);
        
        if(title!=null && !title.trim().equals("") ){
          books = this.searchbook.searchBookByTitle(title);
        }else if(authors!=null && !authors.trim().equals("")){
          books = this.searchbook.searchBookByAuthors(authors);
        }else if(callnumber!=null && !callnumber.trim().equals("")){
          books = this.searchbook.searchBookByCallnumber(callnumber);
        }else if(type!=null && !type.trim().equals("")){
          books = this.searchbook.searchBookByType(type);
        }
        if(books.size()<=0){
            message = "not found";
            return "index";
        }

       
       return Navigation.book.toString();
    }

    public String detailsBook() throws Exception{
        String book_id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("book_id");
        bookr = this.searchbook.searchBookByBid(Integer.parseInt(book_id));
//        bookr = this.searchbook.searchBookByBid(id);
        return Navigation.book.toString();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    
}
