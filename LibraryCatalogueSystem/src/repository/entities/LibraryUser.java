/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository.entities;

/**
 *
 * @author zx
 */
public class LibraryUser {
    private int id;
    private String lastname;
    private String firstname;
    private String email;
    private String password;
    private String address;
    private String phonenumber;
    
    /**
     * Default constructor
     */
    public LibraryUser() {
        this.id = 0;
        this.lastname= "Unknown";
        this.address = "Unknown";
        this.firstname= "Unknown";
        this.email = "Unknown";
        this.password = "Unknown";
        this.phonenumber = "Unknown"; 
    }
    
    /**
     * Copy constructor
     */
    public LibraryUser(LibraryUser libraryuser) {
        this.id = libraryuser.id;
        this.lastname = libraryuser.lastname;
        this.firstname = libraryuser.firstname;
        this.address = libraryuser.address;
        this.email = libraryuser.email;
        this.password = libraryuser.password;
        this.phonenumber = libraryuser.phonenumber;
    }
    
    /**
     * Parameterized constructor
     */
    public LibraryUser(int id,String lastname, String firstname, String address, String email, String password, String phonenumber) {
        this.id = id;
        this.lastname = lastname;
        this.firstname = firstname;
        this.address = address;
        this.email = email;
        this.password = password;
        this.phonenumber = phonenumber;
    }

    public int getId(){
       return id;
    }
    public void setId(int id){
      this.id = id;
    }
    
    public String getLastname(){
      return lastname;
    }
    public void setLastname(String lastname){
      this.lastname = lastname;
    }
    
    public String getFirstname(){
      return firstname;
    }
    public void setFirstname(String firstname){
      this.firstname = firstname;
    }
    
    public String getAddress(){
       return address;
    }
    public void setAddress(String address){
       this.address = address;
    }
    
    public String getEmail(){
       return email;
    }
    public void setEmail(String email){
      this.email= email;
    }
    
    public String getPassword(){
       return password;
    }
    public void setPassword(String password){
      this.password =password;
    }
    
    public String getPhonenumber(){
      return phonenumber;
    }
    public void setPhonenumber(){
      this.phonenumber= phonenumber;
    }
    
    /**
     * @return a string representation of the property object
     */
    @Override
    public String toString() {
        return id + " " + lastname + " " + firstname + " " + address + " " + email + " " + password + " " + phonenumber;
    }
}
