/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5192.ass.librarycataloguesystem.mbeans;

import fit5192.ass.librarycataloguesystem.BookRepository;
import fit5192.ass.librarycataloguesystem.LoanRepository;
import fit5192.ass.librarycataloguesystem.navigation.Navigation;
import fit5192.ass.repository.entities.Book;
import fit5192.ass.repository.entities.Loan;
import fit5192.ass.repository.entities.User;
import java.io.Serializable;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.List;
import javax.ejb.EJB;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;



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
    private int bookId;
    private String message;
    private String deletemessage;
    private  String updatemessage;
    private  String addmessage;
    private int flag;
   
    //special for add book
    private String isbn;
    private String publisher;
    private String thumbnail;
    private String description;
    private String previewurl;
    //for add book end

    //special for loan
    private List<Loan> loans;
    @EJB
    private LoanRepository operationLoan;
    private Loan loan;
    private String loanMessage;
    private int lid;
    private Date start_Date;
    private User member_Id;
    private Date due_Date;
    private Book related_Book_Id;
    private String newDDay;
    private boolean loanflag;
    private String borrowMessage;

    public String getBorrowMessage() {
        return borrowMessage;
    }

    public void setBorrowMessage(String borrowMessage) {
        this.borrowMessage = borrowMessage;
    }

    public boolean isLoanflag() {
        return loanflag;
    }

    public void setLoanflag(boolean loanflag) {
        this.loanflag = loanflag;
    }

   

    public String getNewDDay() {
        return newDDay;
    }

    public void setNewDDay(String newDDay) {
        this.newDDay = newDDay;
    }
    

    public LoanRepository getOperationLoan() {
        return operationLoan;
    }

    public void setOperationLoan(LoanRepository operationLoan) {
        this.operationLoan = operationLoan;
    }

    public Loan getLoan() {
        return loan;
    }

    public void setLoan(Loan loan) {
        this.loan = loan;
    }
    
    public List<Loan> getLoans() {
        return loans;
    }

    public void setLoans(List<Loan> loans) {
        this.loans = loans;
    }

    public String getLoanMessage() {
        return loanMessage;
    }

    public void setLoanMessage(String loanMessage) {
        this.loanMessage = loanMessage;
    }

    public int getLid() {
        return lid;
    }

    public void setLid(int lid) {
        this.lid = lid;
    }

    public Date getStart_Date() {
        return start_Date;
    }

    public void setStart_Date(Date start_Date) {
        this.start_Date = start_Date;
    }

    public User getMember_Id() {
        return member_Id;
    }

    public void setMember_Id(User member_Id) {
        this.member_Id = member_Id;
    }

    public Date getDue_Date() {
        return due_Date;
    }

    public void setDue_Date(Date due_Date) {
        this.due_Date = due_Date;
    }

    public Book getRelated_Book_Id() {
        return related_Book_Id;
    }

    public void setRelated_Book_Id(Book related_Book_Id) {
        this.related_Book_Id = related_Book_Id;
    }
    
    
    
    public String getAddmessage() {
        return addmessage;
    }

    public void setAddmessage(String addmessage) {
        this.addmessage = addmessage;
    }


    //constrcutor
    public LibraryManagedBean() {
        bookr = new Book();
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
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

    public String getDeletemessage() {
        return deletemessage;
    }

    public void setDeletemessage(String deletemessage) {
        this.deletemessage = deletemessage;
    }

    public String getUpdatemessage() {
        return updatemessage;
    }

    public void setUpdatemessage(String updatemessage) {
        this.updatemessage = updatemessage;
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }
    
    //getter & setter for add book
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPreviewurl() {
        return previewurl;
    }

    public void setPreviewurl(String previewurl) {
        this.previewurl = previewurl;
    }
     //add  book end
    
   
    
    //search book
    public String searchBook() throws Exception{
        
        
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

    //search book details
    public String detailsBook() throws Exception{
        String book_id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("book_id");
        bookr = this.searchbook.searchBookByBid(Integer.parseInt(book_id));
        flag=1;
        return Navigation.book.toString();
    }


    //add book
    public String addBookUI(){
        bookr.setIsbn("");
        bookr.setCallnumber("");
        bookr.setAuthors("");
        bookr.setTitle("");
        bookr.setPublisher("");
        bookr.setPreviewurl("");
        bookr.setThumbnail("");
        bookr.setDescription("");
        bookr.setType("");
        return "editBook";
    }
    
    public String addNewBook(){
      // bookr=this.getBookDetails();
        try {
         this.searchbook.addBook(bookr);   
        } catch (Exception ex) {
            addmessage="Fail to add a new book";
        }
        addmessage="Success to add a new book";
         return Navigation.editBook.toString();
    }
    //add end
    
    
    //Delete book begin
    public String deleteExistBook(){
        try {
            String book_id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("book_id");
            this.searchbook.removeBook(Integer.parseInt(book_id));
        } catch (Exception e) {
            deletemessage="Fail to delete this book.";
        }
    deletemessage="Success to delete this book!";
    return Navigation.book.toString();
    }
    
    //update Exist Book
    
      public String updateExistBookUI() throws Exception{
        String book_id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("book_id");
        bookr = this.searchbook.searchBookByBid(Integer.parseInt(book_id));
        bookId = bookr.getBid();
        return "editBook";
    }
      
    public String updateExistBook(){
        try {
            bookr.setBid(bookId);
            this.searchbook.editBook(bookr);
        } catch (Exception e) {
            updatemessage="Fail to update an exist book";
        }
        updatemessage="Success to update!";
        return Navigation.editBook.toString();
    }
    //update end
    
    //member view his loan
    public String searchLoan(){
        try {
            HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
            User user = (User) session.getAttribute("user");
            loans= this.operationLoan.searchLoanByMemberid(user.getUid());
            if(loans.size()<=0){
               loanMessage="You have no loan records ";
               return "index";
            }  
        } catch (Exception e) {
            loanMessage="Fail to find loan records";
        }
        return "searchloan";
    }
    
    //member borrow book
    public String borrowBook(){
        try {
            HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
            User user = (User) session.getAttribute("user");
            loans= this.operationLoan.searchLoanByMemberid(user.getUid());
            java.util.Date dt = new java.util.Date();
            DateFormat df = new SimpleDateFormat("yyy-MM-dd");
            String nowTime = df.format(dt);
            // judge if overdue exist
            loanflag=false;
            for(Loan loan:loans){
             //Date end = loan.getDue_Date();
             // boolean m =java.sql.Date.valueOf(nowTime).after(end);//m=false
                if (java.sql.Date.valueOf(nowTime).after(loan.getDue_Date())) {
                 loanflag =true;
                 borrowMessage="You have overdue records!";
                 break;
                }//
 
               }
            // judge the book's type
            if (!loanflag) { //no overdue
                String book_id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("book_id");
                bookr=this.searchbook.searchBookByBid(Integer.parseInt(book_id));
                  if (bookr.getType().equals("General")) { //book can be borrow
                   loanflag=false; 
                  }else{
                      loanflag=true;
                  borrowMessage="The book has been borrowed!";
                  }
            }
             
             //judge if the book can be borrow
              if (!loanflag) {
                       newDDay= df.format(new Date(dt.getTime()+(long)28*24*60*60*1000));
                       java.util.Date d = df.parse(newDDay);
                       due_Date= new java.sql.Date(d.getTime());   //java.sql.Date
                       start_Date= new java.sql.Date(dt.getTime()); //java.sql.Date
                       //add new loan record
                       loan = new Loan(user, start_Date, due_Date, bookr);
//                       loan = new Loan();
//                       loan.setMember_Id(user);
//                       loan.setStart_Date(start_Date);
//                       loan.setDue_Date(due_Date);
//                       loan.setRelated_Book_Id(bookr);
                       this.operationLoan.addLoan(loan);
                       bookr.setType("Reserved");
                       this.searchbook.editBook(bookr);
                       borrowMessage="Success to borrow this book";
                }

               
        } catch (Exception e) {
            borrowMessage="Fail to borrow !";
        }
             return "book";
    }
}
