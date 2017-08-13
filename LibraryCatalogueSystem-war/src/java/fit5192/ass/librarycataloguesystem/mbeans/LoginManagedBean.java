/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5192.ass.librarycataloguesystem.mbeans;


import fit5192.ass.librarycataloguesystem.UserRepository;
import fit5192.ass.librarycataloguesystem.navigation.Navigation;
import fit5192.ass.repository.entities.User;
import javax.inject.Named;
import java.io.Serializable;
import java.rmi.server.UID;
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
public class LoginManagedBean implements Serializable {

    @EJB
    private UserRepository loginsystem;
    
    private HttpSession session;
    private User loginuser;
    private String email;
    private String password ;
    private boolean temp; 
    private String usertype;
    

    private String loginMessage ;
    public UserRepository getLoginsystem() {
        return loginsystem;
    }

    public void setLoginsystem(UserRepository loginsystem) {
        this.loginsystem = loginsystem;
    }


    public User getLoginuser() {
        return loginuser;
    }

    public void setLoginuser(User loginuser) {
        this.loginuser = loginuser;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    

    public boolean isTemp() {
        return temp;
    }

    public void setTemp(boolean temp) {
        this.temp = temp;
    }

    public HttpSession getSession() {
        return session;
    }

    public void setSession(HttpSession session) {
        this.session = session;
    }

    public String getLoginMessage() {
        return loginMessage;
    }

    public void setLoginMessage(String loginMessage) {
        this.loginMessage = loginMessage;
    }
    
    
    
    /**
     * Creates a new instance of loginManagedBean
     */
    public LoginManagedBean() {
    }
    
    public String loginInSystem() {
        try {
            loginuser= this.loginsystem.searchUserByEmailANDPassword(email,password);
            session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
            session.setAttribute("user", loginuser);
            usertype=loginuser.getType();
       // temp=loginuser.getType().equals("L");
         
                 if(usertype.equals("L")){
                     return Navigation.librarianChoose.toString();
                   }else if(usertype.equals("M")){
                     return Navigation.index.toString();
                    }
            } catch (Exception e) {
                    loginMessage="login fail!";
                }

           loginMessage="Please input correct infomation!";
            return  "login";
        
        
    }
    
    //log out
    public String logOut(){
  
      password="";
      return "login";
    
    }
}
