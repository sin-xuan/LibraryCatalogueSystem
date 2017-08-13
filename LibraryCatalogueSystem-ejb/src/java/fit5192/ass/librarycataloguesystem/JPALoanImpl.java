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
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author zx
 */
@Stateless
public class JPALoanImpl implements LoanRepository{
    @PersistenceContext
    private EntityManager entityManager;

    public JPALoanImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    public JPALoanImpl() {
        
    }

    @Override
    public void addLoan(Loan loan) throws Exception {
        entityManager.persist(loan);
    }

    @Override
    public Loan searchLoanByLid(int lid) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Loan> getAllLoans() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Loan searchLoanByMemberidANDRelateduserid() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeLoan(int lid) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void editLoan(Loan loan) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  

    @Override
    public List<Loan> searchLoanByMemberid(int member_Id) throws Exception {
        Query query = entityManager.createQuery("SELECT l from Loan l where l.member_Id.uid = :member_Id", Loan.class);
        query.setParameter("member_Id", member_Id);
        return query.getResultList();
    }

    @Override
    public List<Loan> searchLoansByAttributes(int lid, int uid,  String email , int bid,String title) throws Exception {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Loan> criteriaQuery = builder.createQuery(Loan.class);
        Root<Loan> p = criteriaQuery.from(Loan.class);
        List<Predicate> predicatesList = new ArrayList<>();
        Predicate predicate;

        if(lid!=0){
          predicate= builder.equal(p.get("lid").as(Integer.class), lid);
          predicatesList.add(predicate); 
        }
        if(uid!=0){
          predicate=builder.equal(p.get("member_Id").get(("uid")).as(Integer.class), uid);
          predicatesList.add(predicate);
        }
        if(email!=null && !email.equals("")){
          predicate=builder.equal(p.get("member_Id").get("email").as(Integer.class), email);
          predicatesList.add(predicate);
        }
        if(bid!=0){
          predicate=builder.equal(p.get("related_Book_Id").as(Integer.class), bid);
          predicatesList.add(predicate);
        }
        
        if(title!=null && !title.equals("")){
          predicate=builder.equal(p.get("related_Book_Id").get("title").as(String.class), title);
          predicatesList.add(predicate);
        }
        
        criteriaQuery.where(predicatesList.toArray(new Predicate[predicatesList.size()]));
        TypedQuery typedQuery = entityManager.createQuery(criteriaQuery);
        return typedQuery.getResultList();

    }
    
    
}
