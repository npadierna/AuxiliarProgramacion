package co.edu.udea.juridicapp.persistence.dao;

import co.edu.udea.juridicapp.persistence.entity.Title;
import java.util.List;

public interface ITitleDAO {

    public Title deleteTitle(Title title);

    public List<Title> findAllTitles();

    public List<Title> findTitlesByAttributes(Object... attributes);

    public Title findTitle(String key);

    public String saveTitle(Title title);

    public Title updateTitle(Title title);

    public long countTitles();

    public List<Title> executeNamedQueryForTitles(String namedQuery,
            String parameterName, Object parameterValue);
}