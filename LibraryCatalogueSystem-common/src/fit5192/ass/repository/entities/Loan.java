/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5192.ass.repository.entities;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author zx
 */
@Entity
@NamedQueries({@NamedQuery(name=Loan.FIND_BY_LID,query="SELECT l FROM Loan l WHERE l.lid=:lid")})
public class Loan implements Serializable{
    public static final String FIND_BY_LID="User.findByLid";
    
    @Id
     @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="Loan_Seq")
    @SequenceGenerator(name="Loan_Seq",sequenceName="Loan_Seq",allocationSize=1)
    @Column(name = "lid")
    private int lid;
    
    //@Column(name = "member_id")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "member_Id" , nullable = false)
    private User member_Id;
    
    @Column(name = "start_Date")
    private Date start_Date;
    
    @Column(name = "due_Date")
    private Date due_Date;
    
    //@Column(name = "relatedbookids")
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "related_Book_Id" , nullable = false)
    private Book related_Book_Id;


    public int getLid() {
        return lid;
    }

    public void setLid(int lid) {
        this.lid = lid;
    }

    public User getMember_Id() {
        return member_Id;
    }

    public void setMember_Id(User member_Id) {
        this.member_Id = member_Id;
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

    public Book getRelated_Book_Id() {
        return related_Book_Id;
    }

    public void setRelated_Book_Id(Book related_Book_Id) {
        this.related_Book_Id = related_Book_Id;
    }

    public Loan(User member_Id, Date start_Date, Date due_Date, Book related_Book_Id) {
        this.member_Id = member_Id;
        this.start_Date = start_Date;
        this.due_Date = due_Date;
        this.related_Book_Id = related_Book_Id;
    }
    
    public Loan(){
    }
    
    
    
}
