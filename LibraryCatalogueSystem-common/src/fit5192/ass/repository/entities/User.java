/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5192.ass.repository.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Inheritance;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Pattern;

/**
 *
 * @author zx
 */
@Entity
@Table(name = "LibraryUser")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "user_type", discriminatorType = DiscriminatorType.STRING)
@NamedQueries({@NamedQuery(name=User.FIND_BY_UID,query="SELECT u FROM User u WHERE u.uid=:uid")})
public class User implements Serializable{
    public static final String FIND_BY_UID="User.findByUid";
    
    private int uid;
    private String lastname;
    private String firstname;
    private String email;
    private String password;
    private String type;
    private String address;
    private String phonenumber;

    
    @Id
    //@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="User_Seq")
    //@SequenceGenerator(name="User_Seq",sequenceName="User_Seq",allocationSize=1)
    @Column(name="uid")
    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }
    
    @Column(name = "lastname")
    @Pattern(regexp = "^[A-Za-z]+$" , message = "User's last name must be pure letters")
    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    
    @Column(name = "firstname")
    @Pattern(regexp = "^[A-Za-z]+$" , message = "User's first name must be pure letters")
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @Column(name = "email")
    @Pattern(regexp = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$" , message = "Please input the email within a legal form")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    

    @Column(name = "password")
   
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "user_type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Column(name ="address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Column(name = "phonenumber")
    @Pattern(regexp = "^[9][0-9]{7}$|^[0][0-9]{9}$", message = "Phone number should begin with 9 and the length is 8, or begin with 0 and the length is 10")
    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }
    
    /**
     * Default constructor
     */
    public User() {
        this.uid= 0;
        this.lastname="Unknown";
        this.firstname="Unknown";
        this.email="Unknown";
        this.password="Unknown";
        this.type="Unknown";
        this.address="Unknown";
        this.phonenumber="Unknown";
        
    }
    
    /**
     * Copy constructor
     */
    public User(User user) {
        this.uid= user.uid;
        this.lastname=user.lastname;
        this.firstname=user.firstname;
        this.email=user.email;
        this.password=user.password;
        this.type=user.type;
        this.address=user.address;
        this.phonenumber=user.phonenumber;
    }
    
    public User(int uid, String lastname, String firstname, String email,
            String password, String type, String address , String  phonenumber ){
        
        this.uid=uid;
        this.lastname=lastname;
        this.firstname=firstname;
        this.email=email;
        this.password = password;
        this.type=type;
        this.address= address;
        this.phonenumber =phonenumber;
    }
    
    
}
