/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5192.ass.librarycataloguesystem;

import fit5192.ass.repository.entities.Book;
import fit5192.ass.repository.entities.Loan;
import fit5192.ass.repository.entities.User;
import java.sql.Date;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author zx
 */
@Remote
public interface LoanRepository {
     public void addLoan(Loan loan) throws Exception;

     public Loan searchLoanByLid(int lid) throws Exception;
     public List<Loan> searchLoanByMemberid(int member_Id) throws Exception;
     public List<Loan> getAllLoans() throws Exception;

     public Loan searchLoanByMemberidANDRelateduserid() throws Exception;
     public void removeLoan(int lid) throws Exception;
     public void editLoan( Loan loan) throws Exception;
     

     public List<Loan> searchLoansByAttributes(int lid, int uid,  String email ,int bid, String title) throws Exception;

}
