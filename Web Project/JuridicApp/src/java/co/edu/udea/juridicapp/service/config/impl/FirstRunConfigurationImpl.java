package co.edu.udea.juridicapp.service.config.impl;

import co.edu.udea.juridicapp.persistence.dao.IAcquisitionDAO;
import co.edu.udea.juridicapp.persistence.dao.IAuthorDAO;
import co.edu.udea.juridicapp.persistence.dao.IAuthorWorkDAO;
import co.edu.udea.juridicapp.persistence.dao.IDependencyDAO;
import co.edu.udea.juridicapp.persistence.dao.IProfileDAO;
import co.edu.udea.juridicapp.persistence.dao.IRoleDAO;
import co.edu.udea.juridicapp.persistence.dao.ISupportDAO;
import co.edu.udea.juridicapp.persistence.dao.ITypeDAO;
import co.edu.udea.juridicapp.persistence.dao.IUserDAO;
import co.edu.udea.juridicapp.persistence.entity.Acquisition;
import co.edu.udea.juridicapp.persistence.entity.Author;
import co.edu.udea.juridicapp.persistence.entity.AuthorWork;
import co.edu.udea.juridicapp.persistence.entity.Dependency;
import co.edu.udea.juridicapp.persistence.entity.PersonPK;
import co.edu.udea.juridicapp.persistence.entity.Profile;
import co.edu.udea.juridicapp.persistence.entity.Role;
import co.edu.udea.juridicapp.persistence.entity.Support;
import co.edu.udea.juridicapp.persistence.entity.Type;
import co.edu.udea.juridicapp.persistence.entity.User;
import co.edu.udea.juridicapp.service.config.IFirstRunConfiguration;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

public class FirstRunConfigurationImpl implements IFirstRunConfiguration {

    @Autowired()
    private IAcquisitionDAO acquisitionDAO;
    @Autowired()
    private IAuthorDAO authorDAO;
    @Autowired()
    private IAuthorWorkDAO authorWorkDAO;
    @Autowired()
    private IDependencyDAO dependencyDAO;
    @Autowired()
    private IProfileDAO profileDAO;
    @Autowired()
    private IRoleDAO roleDAO;
    @Autowired()
    private ISupportDAO supportDAO;
    @Autowired()
    private ITypeDAO typeDAO;
    @Autowired()
    private IUserDAO userDAO;

    @Override()
    public void createDefaultData() {
        System.out.println(" * Creating the Data Base default data.");

        this.createDefaultAcquisitions();
        this.createDefaultSupports();
        this.createDefaultTypes();
        this.createDefaultDependencies();
        this.createDefaultProfiles();
        this.createDefaultRoles();

        //this.tester();
    }

    @Override()
    public void createDefaultAcquisitions() {
        System.out.println(" + Creating the default \"ACQUISITION\" data.");

        if (this.acquisitionDAO.countAcquisitions() == 0) {
            Acquisition acquisition = new Acquisition("Contrato De Cesión De Derechos");
            this.acquisitionDAO.saveAcquisition(acquisition);

            acquisition = new Acquisition("Contrato De Obra Por Encargo");
            this.acquisitionDAO.saveAcquisition(acquisition);

            acquisition = new Acquisition("Presunción Legal Plan De Trabajo");
            this.acquisitionDAO.saveAcquisition(acquisition);

            acquisition = new Acquisition("Autorización");
            this.acquisitionDAO.saveAcquisition(acquisition);

            acquisition = new Acquisition("Licencia De Software");
            this.acquisitionDAO.saveAcquisition(acquisition);

            acquisition = new Acquisition("Licencia Creative Commons");
            this.acquisitionDAO.saveAcquisition(acquisition);
        }
    }

    @Override()
    public void createDefaultDnda() {
    }

    @Override()
    public void createDefaultDependencies() {
        System.out.println(" + Creating the default \"DEPENDENCY\" data.");

        if (this.dependencyDAO.countDependencies() == 0) {
            Dependency dependency = new Dependency("DRAI Facultad De Ingeniería");
            this.dependencyDAO.saveDependency(dependency);
        }
    }

    @Override()
    public void createDefaultProfiles() {
        System.out.println(" + Creating the default \"PROFILE\" data.");

        if (this.profileDAO.countProfiles() == 0) {
            Profile profile = new Profile("Secretaria");
            this.profileDAO.saveProfile(profile);
        }
    }

    @Override()
    public void createDefaultRoles() {
        System.out.println(" + Creating the default \"ROLE\" data.");

        if (this.roleDAO.countRoles() == 0) {
            Role role = new Role("Profesor Vinculado");
            this.roleDAO.saveRole(role);

            role = new Role("Profesor Ocasional");
            this.roleDAO.saveRole(role);

            role = new Role("Profesor Visitante");
            this.roleDAO.saveRole(role);

            role = new Role("Profesor Ad Honórem");
            this.roleDAO.saveRole(role);

            role = new Role("Profesor De Cátedra");
            this.roleDAO.saveRole(role);

            role = new Role("Estudiante De Pregrado");
            this.roleDAO.saveRole(role);

            role = new Role("Estudiante De Postgrado");
            this.roleDAO.saveRole(role);

            role = new Role("Empleado De Carrera");
            this.roleDAO.saveRole(role);

            role = new Role("Empleado De Libre Nombramiento");
            this.roleDAO.saveRole(role);

            role = new Role("Empleado Provisional");
            this.roleDAO.saveRole(role);

            role = new Role("Empleado Ocasional");
            this.roleDAO.saveRole(role);

            role = new Role("Contratista");
            this.roleDAO.saveRole(role);

            role = new Role("Externo");
            this.roleDAO.saveRole(role);

            role = new Role("No Aplica");
            this.roleDAO.saveRole(role);
        }
    }

    @Override()
    public void createDefaultSupports() {
        System.out.println(" + Creating the default \"SUPPORT\" data.");

        if (this.supportDAO.countSupports() == 0) {
            Support support = new Support("Físico");
            this.supportDAO.saveSupport(support);

            support = new Support("Digital");
            this.supportDAO.saveSupport(support);
        }
    }

    @Override()
    public void createDefaultTypes() {
        System.out.println(" + Creating the default \"TYPE\" data.");

        if (this.typeDAO.countTypes() == 0) {
            Type type = new Type("Escrito");
            this.typeDAO.saveType(type);

            type = new Type("Programa De Ordenador (Software)");
            this.typeDAO.saveType(type);

            type = new Type("Audiovisual, Multimedia");
            this.typeDAO.saveType(type);

            type = new Type("Exposición (Conferencia)");
            this.typeDAO.saveType(type);

            type = new Type("Composición Musical");
            this.typeDAO.saveType(type);

            type = new Type("Obra De Bellas Artes");
            this.typeDAO.saveType(type);

            type = new Type("Obra Fotográfica");
            this.typeDAO.saveType(type);

            type = new Type("Ilustración (Mapa)");
            this.typeDAO.saveType(type);

            type = new Type("Obra Derivada");
            this.typeDAO.saveType(type);

            type = new Type("Otro");
            this.typeDAO.saveType(type);
        }
    }

    private void tester() {
        User user = this.userDAO.findUserByLogin("neiber.padierna", "neiber123");

        Author author = new Author(user.getPersonPK().getDocumentType(),
                user.getPersonPK().getIdNumber());
        this.authorDAO.saveAuthor(author);

        List<AuthorWork> authorWorks = this.authorWorkDAO.findAuthorWorkByAuthor(author);
    }
}