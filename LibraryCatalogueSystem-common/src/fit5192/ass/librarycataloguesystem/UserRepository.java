/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5192.ass.librarycataloguesystem;


import fit5192.ass.repository.entities.User;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author zx
 */
@Remote
public interface UserRepository {
     public void addMember(User user) throws Exception;

    public User searchMemberByUid(int uid) throws Exception;

    public List<User> getAllMembers() throws Exception;
    
    public  User searchUserByEmailANDPassword(String email,String password) throws Exception;
    public void removeMember(int uid) throws Exception;
    public void editMember(User user) throws Exception;
    public List<User> searchUserByAttribute(int uid, String lastname,String firstname , String email, String address ,String  phonenumber ) throws  Exception;
    public User searchUserByEmail(String email) throws Exception;
    public User searchUserByPassword(String password) throws Exception;
}
