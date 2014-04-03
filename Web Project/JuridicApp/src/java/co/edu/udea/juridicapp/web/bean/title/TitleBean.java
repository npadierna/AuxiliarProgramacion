package co.edu.udea.juridicapp.web.bean.title;

import co.edu.udea.juridicapp.persistence.dao.ITitleDAO;
import co.edu.udea.juridicapp.persistence.entity.Title;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author Miguel Ossa Ruiz
 * @author Neiber Padierna P&eacute;rez
 */
@Component()
@Scope(value = "singleton")
@ApplicationScoped()
public final class TitleBean implements Serializable {

    private static final long serialVersionUID = 4651738957089294336L;
    @Autowired()
    private ITitleDAO titleDAO;
    private List<String> titlesNames;

    public TitleBean() {
        super();
    }

    public List<String> getTitlesNames() {
        if (this.titleDAO.countTitles() != this.titlesNames.size()) {
            this.createFields();
        }

        return (this.titlesNames);
    }

    public void setTitlesNames(List<String> titlesNames) {
        this.titlesNames = titlesNames;
    }

    @PostConstruct()
    private void createFields() {
        this.setTitlesNames(new ArrayList<String>());

        List<Title> titlesFound = this.titleDAO.findAllTitles();
        for (Title r : titlesFound) {
            this.titlesNames.add(r.getProfile());
        }
    }
}