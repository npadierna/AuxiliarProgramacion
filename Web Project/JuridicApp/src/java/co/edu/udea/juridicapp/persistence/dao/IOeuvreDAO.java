package co.edu.udea.juridicapp.persistence.dao;

import co.edu.udea.juridicapp.persistence.entity.Oeuvre;
import java.util.List;

public interface IOeuvreDAO {

    public Oeuvre deleteOeuvre(Oeuvre oeuvre);

    public List<Oeuvre> findAllOeuvres();

    public List<Oeuvre> findOeuvresByAttributes(Object... attributes);

    public Oeuvre findOeuvre(Long key);

    public Long saveOeuvre(Oeuvre oeuvre);

    public Oeuvre updateOeuvre(Oeuvre oeuvre);

    public long countOeuvres();

    public List<Oeuvre> executeNamedQueryForOeuvres(String namedQuery,
            String parameterName, Object parameterValue);
}