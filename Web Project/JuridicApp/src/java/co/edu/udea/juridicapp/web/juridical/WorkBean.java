package co.edu.udea.juridicapp.web.juridical;

import co.edu.udea.juridicapp.persistence.dao.IJuridicalDAO;
import co.edu.udea.juridicapp.persistence.dao.impl.JuridicalDAO;
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
    private IJuridicalDAO juridicalDAO;
    private List<Work> allJuridical;

    public WorkBean() {
        super();
        this.juridicalDAO = new JuridicalDAO();
    }

    public List<Work> getAllJuridical() {
        this.allJuridical = this.findAllJuridical();

        return (this.allJuridical);
    }

    private List<Work> findAllJuridical() {

        return (this.juridicalDAO.findAllJuridical());
    }
}