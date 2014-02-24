package co.edu.udea.juridicapp.web.bean.juridical;

import co.edu.udea.juridicapp.persistence.dao.IWorkDAO;
import co.edu.udea.juridicapp.persistence.dao.impl.WorkDAO;
import co.edu.udea.juridicapp.persistence.entity.Work;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Miguel Ossa Ruiz
 * @author Neiber Padierna P&eacute;rez
 */
@SessionScoped()
public class WorkBean implements Serializable {

    //private static final long serialVersionUID = 1L;
    private IWorkDAO workDAO;
    private List<Work> allJuridical;
    private Work selectedJuridica;

    public WorkBean() {
        super();
        this.workDAO = new WorkDAO();
    }

    public List<Work> getAllJuridical() {
        this.allJuridical = this.findAllJuridical();

        return (this.allJuridical);
    }

    private List<Work> findAllJuridical() {

        return (this.workDAO.findAllWorks());
    }

    public Work getSelectedJuridica() {
        return selectedJuridica;
    }

    public void setSelectedJuridica(Work selectedJuridica) {
        this.selectedJuridica = selectedJuridica;
    }
}