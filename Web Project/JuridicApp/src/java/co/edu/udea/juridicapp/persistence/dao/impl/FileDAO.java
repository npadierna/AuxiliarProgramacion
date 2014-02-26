package co.edu.udea.juridicapp.persistence.dao.impl;

import co.edu.udea.juridicapp.persistence.dao.IFileDAO;
import co.edu.udea.juridicapp.persistence.entity.File;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository()
@Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = true)
public class FileDAO extends AbstractEntityDAO implements IFileDAO {

    public FileDAO() {
        super();
    }

    @Override()
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public File deleteFile(File file) {

        return ((File) super.delete(file));
    }

    @Override()
    @SuppressWarnings("unchecked")
    public List<File> findAllFiles() {

        return ((List<File>) super.findAll(File.class));
    }

    @Override()
    @SuppressWarnings("unchecked")
    public List<File> findFilesByAttributes(Object... attributes) {

        return ((List<File>) super.findByAttributes(File.class,
                attributes));
    }

    @Override()
    public File findFile(String key) {

        return ((File) super.find(File.class, key));
    }

    @Override()
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public String saveFile(File file) {

        return ((String) super.save(file));
    }

    @Override()
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public File updateFile(File file) {
        return ((File) super.update(file));
    }

    @Override()
    public long countFiles() {
        return (super.count(File.class));
    }

    @Override()
    @SuppressWarnings("unchecked")
    public List<File> executeNamedQueryForFiles(String namedQuery,
            String parameterName, Object parameterValue) {

        return ((List<File>) super.executeNamedQuery(namedQuery, parameterName,
                parameterValue));
    }
}