
package co.edu.udea.juridicapp.persistence.dao;

import co.edu.udea.juridicapp.persistence.entity.File;
import java.util.List;

public interface IFileDAO {
    
    public File deleteFile(File file);

    public List<File> findAllFiles();

    public List<File> findFilesByAttributes(Object... attributes);

    public File findFile(String key);

    public String saveFile(File file);

    public File updateFile(File file);

    public long countFiles();

    public List<File> executeNamedQueryForFiles(String namedQuery,
            String parameterName, Object parameterValue);
}
