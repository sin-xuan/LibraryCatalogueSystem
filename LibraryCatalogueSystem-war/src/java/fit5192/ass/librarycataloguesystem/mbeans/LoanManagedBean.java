/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5192.ass.librarycataloguesystem.mbeans;

import fit5192.ass.librarycataloguesystem.LoanRepository;
import fit5192.ass.repository.entities.Book;
import fit5192.ass.repository.entities.Loan;
import fit5192.ass.repository.entities.User;
import java.io.Serializable;
import java.sql.Date;
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
public class LoanManagedBean implements Serializable {

    @EJB
    private LoanRepository operationloan;
    private Loan loan;
    private User member_Id;
    private Book reated_book_Id;
    private Date start_Date;
    private Date due_Date;
    private List<Loan> loans;
    private int lid;
    private int uid;
    private String email;
    private String title;
    private int bid;
    private String searchloanMessage ;

    public String getSearchloanMessage() {
        return searchloanMessage;
    }

    public void setSearchloanMessage(String searchloanMessage) {
        this.searchloanMessage = searchloanMessage;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    
    public List<Loan> getLoans() {
        return loans;
    }

    public void setLoans(List<Loan> loans) {
        this.loans = loans;
    }

    public int getLid() {
        return lid;
    }

    public void setLid(int lid) {
        this.lid = lid;
    }

    public LoanRepository getOperationloan() {
        return operationloan;
    }

    public void setOperationloan(LoanRepository operationloan) {
        this.operationloan = operationloan;
    }
   
    
    

    public Loan getLoan() {
        return loan;
    }

    public void setLoan(Loan loan) {
        this.loan = loan;
    }

    public User getMember_Id() {
        return member_Id;
    }

    public void setMember_Id(User member_Id) {
        this.member_Id = member_Id;
    }

    public Book getReated_book_Id() {
        return reated_book_Id;
    }

    public void setReated_book_Id(Book reated_book_Id) {
        this.reated_book_Id = reated_book_Id;
    }

    public Date getStart_Date() {
        return start_Date;
    }

    public void setStart_Date(Date start_Date) {
        this.start_Date = start_Date;
    }

    public Date getDue_Date() {
        return due_Date;
    }

    public void setDue_Date(Date due_Date) {
        this.due_Date = due_Date;
    }
    
    /**
     * Creates a new instance of LoanManagedBean
     */
    public LoanManagedBean() {
    }
    
    //search loan records
    public String searchLoans(){
    try {
            loans =this.operationloan.searchLoansByAttributes(lid, uid, email, bid, title);
            if(loans.size()>0){
            searchloanMessage="Success to find corresponding loans!";
            }else{
            searchloanMessage="Fail to find corresponding loans.";
            return "loanoperations";
            }
        } catch (Exception e) {
            searchloanMessage="Fail to search.";
        }  
    return "searchManyLoans";
    }
    
    
}
