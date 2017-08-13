/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5192.ass.repository.entities;

import java.util.Set;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

/**
 *
 * @author zx
 */
@Entity
@DiscriminatorValue(value = "M")
public class Member extends User{
    
@OneToMany(mappedBy = "User", fetch = FetchType.EAGER)
Set<Loan> loan;

    public Member() {
    }

    public Member(User user) {
        super(user);
    }

    public Member(int id, String lastname, String firstname, String email, String password, String type, String address, String phonenumber) {
        super(id, lastname, firstname, email, password, type, address, phonenumber);
    }

    public Set<Loan> getLoan() {
        return loan;
    }

    public void setLoan(Set<Loan> loan) {
        this.loan = loan;
    }

    public Member(Set<Loan> loan) {
        this.loan = loan;
    }

    public Member(Set<Loan> loan, User user) {
        super(user);
        this.loan = loan;
    }

    public Member(Set<Loan> loan, int uid, String lastname, String firstname, String email, String password, String type, String address, String phonenumber) {
        super(uid, lastname, firstname, email, password, type, address, phonenumber);
        this.loan = loan;
    }


}
