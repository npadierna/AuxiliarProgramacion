package co.edu.udea.juridicapp.persistence.dao.impl;

import co.edu.udea.juridicapp.persistence.dao.IFileDAO;
import co.edu.udea.juridicapp.persistence.entity.File;
import java.util.ArrayList;
import java.util.List;

public class FileDAO extends AbstractEntityDAO implements IFileDAO{
     
    public FileDAO() {
        super();
    }

    @Override()
    public File deleteFile(File file) {

        return ((File) super.delete(file));
    }

    @Override()
    public List<File> findAllFiles() {

        return ((List<File>) super.findAll(File.class));
    }

    @Override()
    public List<File> findFilesByAttributes(Object... attributes) {

        return ((List<File>) super.findByAttributes(File.class,
                attributes));
    }

    @Override()
    public File findFile(String key) {

        return ((File) super.find(File.class, key));
    }

    @Override()
    public String saveFile(File file) {

        return ((String) super.save(file));
    }

    @Override()
    public File updateFile(File file) {
        return ((File) super.update(file));
    }

    @Override()
    public long countFiles() {
        return (super.count(File.class));
    }

    @Override()
    public List<File> executeNamedQueryForFiles(String namedQuery, 
            String parameterName, Object parameterValue) {
        
        List<File> filesFound = new ArrayList<>();

        for (Object o : super.executeNamedQuery(namedQuery, parameterName,
                parameterValue)) {
            filesFound.add((File) o);
        }

        return (filesFound);
    }
}
