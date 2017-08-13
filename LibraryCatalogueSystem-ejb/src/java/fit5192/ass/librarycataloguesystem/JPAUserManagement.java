/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5192.ass.librarycataloguesystem;


import fit5192.ass.repository.entities.User;
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
public class JPAUserManagement implements UserRepository {

    @PersistenceContext
    private EntityManager entityManager;
    private User tuser;

    public JPAUserManagement() {
       
    }
    
     
    
    @Override
    public void addMember(User user) throws Exception {
        entityManager.persist(user);
    }

    @Override
    public User searchMemberByUid(int uid) throws Exception {
        Query query = entityManager.createNamedQuery(User.FIND_BY_UID);
        query.setParameter("uid", uid);
        return (User) query.getSingleResult();
    }

    @Override
    public List<User> getAllMembers() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    public void removeMember(int uid) throws Exception {
        User user= this.searchMemberByUid(uid);
        if(user!=null){
          entityManager.remove(user);
        }
    }

    @Override
    public void editMember(User user) throws Exception {
        entityManager.merge(user);
    }

    @Override
    public List<User> searchUserByAttribute(int uid, String lastname, String firstname, String email, String address, String phonenumber) throws Exception {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = builder.createQuery(User.class);
        Root<User> p = criteriaQuery.from(User.class);
        List<Predicate> predicatesList = new ArrayList<>();
        Predicate predicate;

        if(uid!=0){
          predicate= builder.equal(p.get("uid").as(Integer.class), uid);
          predicatesList.add(predicate); 
        }
        if(lastname!=null && !lastname.equals("")){
          predicate=builder.equal(p.get("lastname").as(String.class), lastname);
          predicatesList.add(predicate);
        }
        if(firstname!=null && !firstname.equals("")){
          predicate=builder.equal(p.get("firstname").as(String.class), firstname);
          predicatesList.add(predicate);
        }
        if(email!=null && !email.equals("")){
          predicate=builder.equal(p.get("email").as(String.class), email);
          predicatesList.add(predicate);
        }
        if(address!=null && !address.equals("")){
          predicate=builder.equal(p.get("address").as(String.class), address);
          predicatesList.add(predicate);
        }
        if(phonenumber!=null && !phonenumber.equals("")){
          predicate=builder.equal(p.get("phonenumber").as(String.class),phonenumber);
          predicatesList.add(predicate);
        }
        criteriaQuery.where(predicatesList.toArray(new Predicate[predicatesList.size()]));
        TypedQuery typedQuery = entityManager.createQuery(criteriaQuery);
        return typedQuery.getResultList();

    }

    @Override
    public User searchUserByEmail(String email) throws Exception {
         Query query = entityManager.createQuery("select u from User u WHERE u.email = :email", User.class);
        query.setParameter("email", email);
        return (User) query.getSingleResult();
    }

    @Override
    public User searchUserByPassword(String password) throws Exception {
        Query query = entityManager.createQuery("select u from User u WHERE u.password= :password", User.class);
        query.setParameter("password", password);
        return (User) query.getSingleResult();
    }
    
}
