package co.edu.udea.juridicapp.persistence.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Miguel Ossa Ruiz
 * @author Neiber Padierna P&eacute;rez
 */
public class Juridical implements Serializable {

    //private static final long serialVersionUID = 1L;
    private Date year;
    private String isbn;
    private String issue;
    private String kind;
    private List<Author> authors;

    public Juridical(Date year, String isbn, String issue, String kind) {
        this.year = year;
        this.isbn = isbn;
        this.issue = issue;
        this.kind = kind;
    }

    public Date getYear() {
        return year;
    }

    public void setYear(Date year) {
        this.year = year;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }
}