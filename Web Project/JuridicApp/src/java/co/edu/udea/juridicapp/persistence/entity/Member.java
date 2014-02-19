package co.edu.udea.juridicapp.persistence.entity;

import java.io.Serializable;

/**
 *
 * @author Miguel Ossa Ruiz
 * @author Neiber Padierna P&eacute;rez
 */
public class Member implements Serializable, IEntityContext {

    private String fullName;
    private String fullLastName;
    private MemberPK memberPK;
    private String userName;
    private String password;

    public Member() {
        super();
    }

    public Member(String documentType, long idNumber) {
        this.memberPK = new MemberPK(documentType, idNumber);
    }

    public Member(MemberPK memberPK) {
        this.memberPK = memberPK;
    }

    public Member(MemberPK memberPK, String fullName, String fullLastName,
            String userName, String password) {
        this.memberPK = memberPK;
        this.fullName = fullName;
        this.fullLastName = fullLastName;
        this.userName = userName;
        this.password = password;
    }

    public MemberPK getMemberPK() {
        return memberPK;
    }

    public void setMemberPK(MemberPK memberPK) {
        this.memberPK = memberPK;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getFullLastName() {
        return fullLastName;
    }

    public void setFullLastName(String fullLastName) {
        this.fullLastName = fullLastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
      @Override()
    public int hashCode() {
        int hash = 0;
        hash += (this.memberPK != null ? this.memberPK.hashCode() : 0);

        return (hash);
    }

    @Override()
    public boolean equals(Object object) {
        if (!(object instanceof Member)) {

            return (false);
        }

        Member other = (Member) object;
        if ((this.memberPK == null && other.memberPK != null)
                || (this.memberPK != null
                && !this.memberPK.equals(other.memberPK))) {

            return (false);
        }

        return (true);
    }

    @Override()
    public String toString() {

        return ("co.edu.udea.juridicapp.persistence.entity.Member[ member1PK="
                + this.memberPK + " ]");
    }

    @Override()
    public Object getKey() {

        return (this.memberPK);
    }

    @Override()
    public void setKey(Object key) {
        this.setMemberPK((MemberPK) key);
    }
}
