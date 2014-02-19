package co.edu.udea.juridicapp.persistence.entity;

/**
 *
 * @author Miguel Ossa Ruiz
 * @author Neiber Padierna P&eacute;rez
 */
public class MemberPK {
    
    private String documentType;
    private long idNumber;
    
    public MemberPK( ){
        super();
    }
    
    public MemberPK(String documentType, long idNumber){
        this.documentType = documentType;
        this.idNumber = idNumber;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public long getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(long idNumber) {
        this.idNumber = idNumber;
    }
    
    
    @Override()
    public int hashCode() {
        int hash = 0;
        hash += (this.documentType != null ? this.documentType.hashCode() : 0);
        hash += (int) this.idNumber;

        return (hash);
    }

    @Override()
    public boolean equals(Object object) {
        if (!(object instanceof MemberPK)) {

            return (false);
        }

        MemberPK other = (MemberPK) object;
        if ((this.documentType == null && other.documentType != null)
                || (this.documentType != null
                && !this.documentType.equals(other.documentType))) {

            return (false);
        }

        if (this.idNumber != other.idNumber) {

            return (false);
        }

        return (true);
    }

    @Override()
    public String toString() {

        return ("co.edu.udea.juridicapp.persistence.entity.MemberPK[ documentType="
                + this.documentType + ", idNumber=" + this.idNumber + " ]");
    }
}
