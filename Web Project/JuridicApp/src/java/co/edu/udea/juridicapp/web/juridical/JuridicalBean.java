package co.edu.udea.juridicapp.web.juridical;

import co.edu.udea.juridicapp.persistence.dao.IJuridicalDAO;
import co.edu.udea.juridicapp.persistence.dao.impl.JuridicalDAO;
import co.edu.udea.juridicapp.persistence.entity.Juridical;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Miguel Ossa Ruiz
 * @author Neiber Padierna P&eacute;rez
 */
@SessionScoped()
public class JuridicalBean implements Serializable {

    //private static final long serialVersionUID = 1L;
    private IJuridicalDAO juridicalDAO;
    private List<Juridical> allJuridical;

    public JuridicalBean() {
        super();
        this.juridicalDAO = new JuridicalDAO();
    }

    public List<Juridical> getAllJuridical() {
        this.allJuridical = this.findAllJuridical();

        return (this.allJuridical);
    }

    private List<Juridical> findAllJuridical() {

        return (this.juridicalDAO.findAllJuridical());
    }
}