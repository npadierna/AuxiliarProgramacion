package co.edu.udea.juridicapp.persistence.dao;

import co.edu.udea.juridicapp.persistence.entity.Member;
import co.edu.udea.juridicapp.persistence.entity.MemberPK;
import java.util.List;

/**
 *
 * @author Miguel Ossa Ruiz
 * @author Neiber Padierna P&eacute;rez
 */
public interface IMemberDAO {

    public Member deleteMember(Member member);

    public List<Member> findAllMembers();

    public List<Member> findAllMembersByAttributes(Object... attributes);

    public Member findMember(MemberPK memberPK);

    public MemberPK saveMember(Member member);

    public Member updateMember(Member member);

    public long countMembers();
}
