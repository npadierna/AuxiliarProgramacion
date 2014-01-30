package co.edu.udea.juridicapp.persistence.entity;

import java.io.Serializable;

/**
 *
 * @author Miguel Ossa Ruiz
 * @author Neiber Padierna P&eacute;rez
 */
public class Author implements Serializable {

    //private static final long serialVersionUID = 1L;
    private String kind;
    private String firstNames;
    private String lastNames;

    public Author(String kind, String firstNames, String lastNames) {
        this.kind = kind;
        this.firstNames = firstNames;
        this.lastNames = lastNames;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getFirstNames() {
        return firstNames;
    }

    public void setFirstNames(String firstNames) {
        this.firstNames = firstNames;
    }

    public String getLastNames() {
        return lastNames;
    }

    public void setLastNames(String lastNames) {
        this.lastNames = lastNames;
    }
}