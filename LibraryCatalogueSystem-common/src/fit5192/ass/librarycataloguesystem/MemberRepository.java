/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5192.ass.librarycataloguesystem;

import fit5192.ass.repository.entities.Member;
import javax.ejb.Remote;

/**
 *
 * @author zx
 */
@Remote
public interface MemberRepository {
    public void addNewMember(Member member) throws Exception;
    public void updateMember(Member member) throws Exception;
}
