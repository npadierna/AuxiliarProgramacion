package co.edu.udea.juridicapp.web.bean.work;

import co.edu.udea.juridicapp.persistence.dao.IWorkDAO;
import co.edu.udea.juridicapp.persistence.entity.Work;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Miguel Ossa Ruiz
 * @author Neiber Padierna P&eacute;rez
 */
@Component()
@SessionScoped()
public final class WorkListBean implements Serializable {

    private static final long serialVersionUID = 2915088641135538176L;
    @Autowired()
    private IWorkDAO workDAO;
    private List<Work> works;
    private Work selectedWork;

    public WorkListBean() {
        super();
    }

    public List<Work> getWorks() {

        return (this.works);
    }

    public void setWorks(List<Work> works) {
        this.works = works;
    }

    public Work getSelectedWork() {

        return (this.selectedWork);
    }

    public void setSelectedWork(Work selectedWord) {
        this.selectedWork = selectedWord;
    }

    @PostConstruct()
    private void createFields() {
        this.setWorks(this.workDAO.findAllWorks());
    }
}