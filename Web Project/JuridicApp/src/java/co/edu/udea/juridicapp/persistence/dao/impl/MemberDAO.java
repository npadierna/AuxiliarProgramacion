package co.edu.udea.juridicapp.persistence.dao.impl;

import co.edu.udea.juridicapp.persistence.dao.IMemberDAO;
import co.edu.udea.juridicapp.persistence.entity.Member;
import co.edu.udea.juridicapp.persistence.entity.MemberPK;
import co.edu.udea.juridicapp.persistence.entity.Work;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Miguel Ossa Ruiz
 * @author Neiber Padierna P&eacute;rez
 */
public class MemberDAO implements IMemberDAO {

    private static final List<Member> MEMBERS_FOO;
    
    static {
        MEMBERS_FOO = new ArrayList<>();
        for (int counter = 0; counter < 10; counter++) {
            String s = Integer.toString(counter);
            Member m = new Member( new MemberPK( "Cédula De Ciudadanía", 
                    counter), "FirstName".concat(s), "LastName".concat(s),
                    "User".concat(s), "password".concat(s));
            
            MEMBERS_FOO.add(m);
        }
    }

    public MemberDAO() {
        super();
    }

    @Override
    public Member deleteMember(Member member) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Member> findAllMembers() {
        return(MEMBERS_FOO);
    }

    @Override
    public List<Member> findAllMembersByAttributes(Object... attributes) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Member findMember(MemberPK memberPK) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public MemberPK saveMember(Member member) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Member updateMember(Member member) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public long countMembers() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
