/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5192.ass.librarycataloguesystem.mbeans;

import fit5192.ass.librarycataloguesystem.LoanRepository;
import fit5192.ass.librarycataloguesystem.MemberRepository;
import fit5192.ass.librarycataloguesystem.UserRepository;
import fit5192.ass.librarycataloguesystem.navigation.Navigation;
import fit5192.ass.repository.entities.Loan;
import fit5192.ass.repository.entities.Member;
import fit5192.ass.repository.entities.User;
import javax.inject.Named;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.jboss.weld.util.collections.ArraySet;

/**
 *
 * @author zx
 */
@ManagedBean
@SessionScoped
public class UserOperationManagedBean implements Serializable {

    @EJB
    private UserRepository operationUser;
    private User euser;
    private int uid;
    private String lastname ;
    private String firstname ;
    private String email;
    private String address;
    private String phonenumber;
    private int uflag;
    List<User> users;
    private String searchMessage;
    private int userId;
    private String deleteMessage;
    private String updateMessage;
    private String addMessage;
    private String type;
    private String password;
    @EJB
    private MemberRepository operationMember;
    private Member member;
    @EJB
    private LoanRepository loansearch;
    private List<Loan> loan;

    public LoanRepository getLoansearch() {
        return loansearch;
    }

    public void setLoansearch(LoanRepository loansearch) {
        this.loansearch = loansearch;
    }

    public List<Loan> getLoan() {
        return loan;
    }

    public void setLoan(List<Loan> loan) {
        this.loan = loan;
    }

    

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public MemberRepository getOperationMember() {
        return operationMember;
    }

    public void setOperationMember(MemberRepository operationMember) {
        this.operationMember = operationMember;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRepository getOperationUser() {
        return operationUser;
    }

    public void setOperationUser(UserRepository operationUser) {
        this.operationUser = operationUser;
    }

    public User getEuser() {
        return euser;
    }

    public void setEuser(User euser) {
        this.euser = euser;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

  

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public String getSearchMessage() {
        return searchMessage;
    }

    public void setSearchMessage(String searchMessage) {
        this.searchMessage = searchMessage;
    }

    public int getUflag() {
        return uflag;
    }

    public void setUflag(int uflag) {
        this.uflag = uflag;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getDeleteMessage() {
        return deleteMessage;
    }

    public void setDeleteMessage(String deleteMessage) {
        this.deleteMessage = deleteMessage;
    }

    public String getUpdateMessage() {
        return updateMessage;
    }

    public void setUpdateMessage(String updateMessage) {
        this.updateMessage = updateMessage;
    }

    public String getAddMessage() {
        return addMessage;
    }

    public void setAddMessage(String addMessage) {
        this.addMessage = addMessage;
    }

    //constructor
    
    /**
     * Creates a new instance of UserOperationManagedBean
     */
    public UserOperationManagedBean() {
        euser = new User();
        member=new Member();
    }
    
  
    
    public String searchMember() {
        try {
            users =this.operationUser.searchUserByAttribute(uid, lastname, firstname, email, address, phonenumber);
            for(User user: users){
               if(user.getType().equals("L"))
                   users.remove(user);
            }
            if(users.size()>0){
            searchMessage="";
            }else{
            searchMessage="Fail to find correspondng member.";
            return "useoperations";
            }
        } catch (Exception e) {
            searchMessage="Fail to search.";
        }       
        return "userSearch";
    }
    
    public String detailsUser()throws Exception{
         String user_uid= FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("user_uid");
         euser = this.operationUser.searchMemberByUid(Integer.parseInt(user_uid));
         uflag=1;
         return "userSearch";
    }
    
    //update user
    public String updateExistUserUI() throws Exception{
        String user_uid= FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("user_uid");
        euser = this.operationUser.searchMemberByUid(Integer.parseInt(user_uid));
        userId = euser.getUid();
    return "editUser";
    }
    
    public String updateExistUser() {
        try {
            euser.setUid(userId);
            this.operationUser.editMember(euser);
        } catch (Exception e) {
            updateMessage="Fail to update an exist user";
        }
        updateMessage="Success to update!";
        
        return "editUser";
    }
    
    //add new user
    public String addNewUser(){
        try {
            Set<Loan> loan1 = new ArraySet<>();
            member = new Member(loan1,uid, lastname, firstname,email,password, type, address,  phonenumber);
//            Member m1 = new Member(loan1,uid,lastname,firstname,email,password,type,address,phonenumber);
            this.operationMember.addNewMember(member);
         //this.operationUser.addMember(euser);   
        } catch (Exception ex) {
            addMessage="Fail to add a new user";
        }
        addMessage="Success to add a new user";
        return "addUser";
    }
    
    //delete user
    public String deleteExistUser(){
    try {
            String user_uid= FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("user_uid");
            loan= this.loansearch.searchLoanByMemberid(Integer.parseInt(user_uid));
            if(loan.size()>0){
              deleteMessage="The member has loan records and cannot be delete!";
            }else{
            this.operationUser.removeMember(Integer.parseInt(user_uid));
            deleteMessage="Success to delete this user!";
            }
        } catch (Exception e) {
            deleteMessage="Fail to delete this user.";
        }
    return "userSearch"; 
    }

}
