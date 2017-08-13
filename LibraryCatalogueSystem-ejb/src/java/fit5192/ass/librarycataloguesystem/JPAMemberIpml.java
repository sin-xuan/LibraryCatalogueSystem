/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5192.ass.librarycataloguesystem;

import fit5192.ass.repository.entities.Member;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author zx
 */
@Stateless
public class JPAMemberIpml implements MemberRepository{

    @PersistenceContext
    private EntityManager entityManager;
    
    
    @Override
    public void addNewMember(Member member) throws Exception {
        entityManager.persist(member);
    }

    @Override
    public void updateMember(Member member) throws Exception {
        entityManager.merge(member);
    }
    
}
