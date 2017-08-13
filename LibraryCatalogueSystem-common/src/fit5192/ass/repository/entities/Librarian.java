/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5192.ass.repository.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *
 * @author zx
 */
@Entity
@DiscriminatorValue(value = "L")
public class Librarian extends User{

    public Librarian() {
    }

    public Librarian(User user) {
        super(user);
    }

    public Librarian(int id, String lastname, String firstname, String email, String password, String type, String address, String phonenumber) {
        super(id, lastname, firstname, email, password, type, address, phonenumber);
    }
    
}
