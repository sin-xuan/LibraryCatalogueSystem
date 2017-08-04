/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5192.ass.repository.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author zx
 */
  @Entity
  @NamedQueries({
      @NamedQuery(name=Book.FIND_BY_TITLE,query="SELECT b FROM Book b WHERE b.title=:title")
    , @NamedQuery(name = Book.FIND_ALL,query="SELECT b FROM Book b")
    , @NamedQuery(name = Book.FIND_BY_AUTHORS,query= "SELECT b FROM Book b WHERE b.authors=:authors")
    , @NamedQuery(name = Book.FIND_BY_CALLNUMBER,query= "SELECT b FROM Book b WHERE b.callnumber=:callnumber")
    , @NamedQuery(name = Book.FIND_BY_TYPE,query= "SELECT b FROM Book b WHERE b.type=:type")})

public class Book implements Serializable{
    
   public static final String FIND_BY_TITLE="Book.findByTitle";
   public static final String FIND_ALL="Book.getAll";
   public static final String FIND_BY_AUTHORS="Book.findByAuthors";
   public static final String FIND_BY_CALLNUMBER="Book.findByCallNumber";
   public static final String FIND_BY_TYPE="Book.findByType";
    private int bid;
    private String isbn;
    private String callnumber;
    private String title;
    private String authors;
    private String publisher;
    private String type;
    private String thumbnail;
    private String description;
    private String previewurl;
    
     /**
     * Default constructor
     */
    public Book() {
        this.bid= 0;
        this.isbn = "Unknown";
        this.callnumber= "Unknown";
        this.title = "Unknown";
        this.authors= "Unknown";
        this.publisher= "Unknown";
        this.type = "Unknown";
        this.thumbnail= "Unknown";
        this.description= "Unknown";
        this.previewurl = "Unknown";
    }
    
    /**
     * Copy constructor
     */
    public Book(Book book) {
        this.bid= book.bid;
        this.isbn = book.isbn;
        this.callnumber = book.callnumber;
        this.title = book.title;
        this.authors = book.authors;
        this.publisher = book.publisher;
        this.type = book.type;
        this.thumbnail = book.thumbnail;
        this.description = book.description;
        this.previewurl = book.previewurl;
    }
    
    /**
     * Parameterized constructor
     */
    public Book(int bid, String isbn, String callnumber, String title, String authors, String publisher, String type, String thumbnail, String description, String previewurl) {
        this.bid = bid;
        this.isbn = isbn;
        this.callnumber = callnumber;
        this.title = title;
        this.authors= authors;
        this.publisher = publisher;
        this.type=type;
        this.thumbnail =thumbnail;
        this.description =description;
        this.previewurl =previewurl;
    }

    public Book(String title, String authors, String callnumber, String type) {
        this.title = title;
        this.authors= authors;
        this.callnumber = callnumber;
        this.type=type;
    }

   
    
    @Id
    @GeneratedValue
    @Column(name="bid")
    public int getBid(){
        return bid;
    }
    public void setBid(int bid){
       this.bid = bid;
    }
    
    @Column(name="isbn")
    public String getIsbn(){
       return isbn;
    }
    public void setIsbn(String isbn){
      this.isbn= isbn;
    }
    
    @Column(name="callnumber")
    public String getCallnumber(){
       return callnumber;
    }
    public void setCallnumber(String callnumber){
       this.callnumber = callnumber;
    }
    
    @Column(name="title")
    public String getTitle(){
      return title;
    }
    public void setTitle(String title){
       this.title= title;
    }
    
    @Column(name="authors")
    public String getAuthors(){
        return authors;
    }
    public void setAuthors(String authors){
       this.authors= authors;
    }
    
    @Column(name="publisher")
    public String getPublisher(){
        return publisher;
    }
    public void setPublisher(String publisher){
        this.publisher = publisher;
    }
    
    @Column(name="type")
    public String getType(){
        return type;
    }
    public void setType(String type){
        this.type = type;
    }
    
    @Column(name="thumbnail")
    public String getThumbnail(){
       return thumbnail;
    }
    public void setThumbnail(String thumbnail){
       this.thumbnail = thumbnail;
    }
    
    @Column(name="description")
    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description= description;
    }
    
    @Column(name="previewurl")
    public String getPreviewurl(){
        return previewurl;
    }
    public void setPreviewurl(String previewurl){
        this.previewurl = previewurl;
    }
    
     /**
     * @return a string representation of the property object
     */
    @Override
    public String toString() {
       StringBuilder bookstring = new StringBuilder();
       bookstring.append("Book ID:").append(bid);
       bookstring.append("\n");
       bookstring.append("ISBN:").append(isbn);
       bookstring.append("\n");
       bookstring.append("Call Number:").append(callnumber);
       bookstring.append("\n");
       bookstring.append("Title:").append(title);
       bookstring.append("\n");
       bookstring.append("Author(s):").append(authors);
       bookstring.append("\n");
       bookstring.append("Publisher:").append(publisher);
       bookstring.append("\n");
       bookstring.append("Type:           ").append(type);
       bookstring.append("\n");
       bookstring.append("Thumbnail:      ").append(thumbnail);
       bookstring.append("\n");
       bookstring.append("Description:    ").append(description);
       bookstring.append("\n");
       bookstring.append("Preview URL:    ").append(previewurl);
        
       return bookstring.toString();       
        
    }
    
    
    public String partToString(){
       return title + " " + authors + " " +callnumber;
    }
}
