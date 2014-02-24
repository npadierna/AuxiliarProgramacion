

package co.edu.udea.juridicapp.persistence.dao.impl;

import co.edu.udea.juridicapp.persistence.dao.IDndaDAO;
import co.edu.udea.juridicapp.persistence.entity.Dnda;
import java.util.ArrayList;
import java.util.List;


public class DndaDAO extends AbstractEntityDAO implements IDndaDAO {
     
    public DndaDAO() {
        super();
    }

    @Override()
    public Dnda deleteDnda(Dnda dnda) {

        return ((Dnda) super.delete(dnda));
    }

    @Override()
    public List<Dnda> findAllDndas() {

        return ((List<Dnda>) super.findAll(Dnda.class));
    }

    @Override()
    public List<Dnda> findDndasByAttributes(Object... attributes) {

        return ((List<Dnda>) super.findByAttributes(Dnda.class,
                attributes));
    }

    @Override()
    public Dnda findDnda(String key) {

        return ((Dnda) super.find(Dnda.class, key));
    }

    @Override()
    public String saveDnda(Dnda dnda) {

        return ((String) super.save(dnda));
    }

    @Override()
    public Dnda updateDnda(Dnda dnda) {
        return ((Dnda) super.update(dnda));
    }

    @Override()
    public long countDndas() {
        return (super.count(Dnda.class));
    }

    @Override()
    public List<Dnda> executeNamedQueryForDndas(String namedQuery, 
            String parameterName, Object parameterValue) {
        
        List<Dnda> dndasFound = new ArrayList<>();

        for (Object o : super.executeNamedQuery(namedQuery, parameterName,
                parameterValue)) {
            dndasFound.add((Dnda) o);
        }

        return (dndasFound);
    }
}
