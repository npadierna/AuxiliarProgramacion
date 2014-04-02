package co.edu.udea.juridicapp.service.config.impl;

import co.edu.udea.juridicapp.persistence.dao.IAcquisitionDAO;
import co.edu.udea.juridicapp.persistence.dao.IAuthorDAO;
import co.edu.udea.juridicapp.persistence.dao.IAuthorOeuvreDAO;
import co.edu.udea.juridicapp.persistence.dao.IDependencyDAO;
import co.edu.udea.juridicapp.persistence.dao.IProfileDAO;
import co.edu.udea.juridicapp.persistence.dao.ITitleDAO;
import co.edu.udea.juridicapp.persistence.dao.ISupportDAO;
import co.edu.udea.juridicapp.persistence.dao.ITypeDAO;
import co.edu.udea.juridicapp.persistence.dao.IClientDAO;
import co.edu.udea.juridicapp.persistence.entity.Acquisition;
import co.edu.udea.juridicapp.persistence.entity.Author;
import co.edu.udea.juridicapp.persistence.entity.AuthorOeuvre;
import co.edu.udea.juridicapp.persistence.entity.Dependency;
import co.edu.udea.juridicapp.persistence.entity.Profile;
import co.edu.udea.juridicapp.persistence.entity.Title;
import co.edu.udea.juridicapp.persistence.entity.Support;
import co.edu.udea.juridicapp.persistence.entity.Type;
import co.edu.udea.juridicapp.persistence.entity.Client;
import co.edu.udea.juridicapp.service.config.IFirstRunConfiguration;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Miguel Ossa Ruiz
 * @author Neiber Padierna P&eacute;rez
 */
public class FirstRunConfigurationImpl implements IFirstRunConfiguration {

    @Autowired()
    private IAcquisitionDAO acquisitionDAO;
    @Autowired()
    private IAuthorOeuvreDAO authorOeuvreDAO;
    @Autowired()
    private IDependencyDAO dependencyDAO;
    @Autowired()
    private IProfileDAO profileDAO;
    @Autowired()
    private ITitleDAO titleDAO;
    @Autowired()
    private ISupportDAO supportDAO;
    @Autowired()
    private ITypeDAO typeDAO;
    @Autowired()
    private IClientDAO clientDAO;

    @Override()
    public void createDefaultData() {
        System.out.println(" * Creating the Data Base default data.");

        this.createDefaultAcquisitions();
        this.createDefaultSupports();
        this.createDefaultTypes();
        this.createDefaultDependencies();
        this.createDefaultProfiles();
        this.createDefaultTitles();

        this.tester();
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
            dependency.setDescription("Departamentos de Recursos y Apoyo Didáctico (D.R.A.I.) para la Facultad de Ingeniería.");
            this.dependencyDAO.saveDependency(dependency);
        }
    }

    @Override()
    public void createDefaultProfiles() {
        System.out.println(" + Creating the default \"PROFILE\" data.");

        if (this.profileDAO.countProfiles() == 0) {
            Profile profile = new Profile("Administrador");
            profile.setDescription("Administrador del Sistema.");
            this.profileDAO.saveProfile(profile);

            profile = new Profile("Gestor De Contratos");
            profile.setDescription("Gestor de Contratos u Obras en el Sistema.");
            this.profileDAO.saveProfile(profile);

            profile = new Profile("Consultor");
            profile.setDescription("Consultor de Obras en el Sistema.");
            this.profileDAO.saveProfile(profile);
        }
    }

    @Override()
    public void createDefaultTitles() {
        System.out.println(" + Creating the default \"TITLE\" data.");

        if (this.titleDAO.countTitles() == 0) {
            Title title = new Title("Profesor Vinculado");
            title.setDescription("Profesor Vinculado.");
            this.titleDAO.saveTitle(title);

            title = new Title("Profesor Ocasional");
            title.setDescription("Profesor Ocasional.");
            this.titleDAO.saveTitle(title);

            title = new Title("Profesor Visitante");
            title.setDescription("Profesor Visitante.");
            this.titleDAO.saveTitle(title);

            title = new Title("Profesor Ad Honórem");
            title.setDescription("Profesor Ad Honórem.");
            this.titleDAO.saveTitle(title);

            title = new Title("Profesor De Cátedra");
            title.setDescription("Profesor De Cátedra.");
            this.titleDAO.saveTitle(title);

            title = new Title("Estudiante De Pregrado");
            title.setDescription("Estudiante De Pregrado.");
            this.titleDAO.saveTitle(title);

            title = new Title("Estudiante De Postgrado");
            title.setDescription("Estudiante De Postgrado.");
            this.titleDAO.saveTitle(title);

            title = new Title("Empleado De Carrera");
            title.setDescription("Empleado De Carrera.");
            this.titleDAO.saveTitle(title);

            title = new Title("Empleado De Libre Nombramiento");
            title.setDescription("Empleado De Libre Nombramiento.");
            this.titleDAO.saveTitle(title);

            title = new Title("Empleado Provisional");
            title.setDescription("Empleado Provisional.");
            this.titleDAO.saveTitle(title);

            title = new Title("Empleado Ocasional");
            title.setDescription("Empleado Ocasional.");
            this.titleDAO.saveTitle(title);

            title = new Title("Contratista");
            title.setDescription("Contratista.");
            this.titleDAO.saveTitle(title);

            title = new Title("Externo");
            title.setDescription("Externo.");
            this.titleDAO.saveTitle(title);

            title = new Title("No Aplica");
            title.setDescription("No Aplica.");
            this.titleDAO.saveTitle(title);
        }
    }

    @Override()
    public void createDefaultSupports() {
        System.out.println(" + Creating the default \"SUPPORT\" data.");

        if (this.supportDAO.countSupports() == 0) {
            Support support = new Support("Físico");
            support.setDescription("Soporte para Obras físicas.");
            this.supportDAO.saveSupport(support);

            support = new Support("Digital");
            support.setDescription("Soporte para Obras digitales.");
            this.supportDAO.saveSupport(support);
        }
    }

    @Override()
    public void createDefaultTypes() {
        System.out.println(" + Creating the default \"TYPE\" data.");

        if (this.typeDAO.countTypes() == 0) {
            Type type = new Type("Escrito");
            type.setDescription("Escrito.");
            this.typeDAO.saveType(type);

            type = new Type("Programa De Ordenador (Software)");
            type.setDescription("Programa De Ordenador (Software).");
            this.typeDAO.saveType(type);

            type = new Type("Audiovisual, Multimedia");
            type.setDescription("Audiovisual, Multimedia.");
            this.typeDAO.saveType(type);

            type = new Type("Exposición (Conferencia)");
            type.setDescription("Exposición (Conferencia).");
            this.typeDAO.saveType(type);

            type = new Type("Composición Musical");
            type.setDescription("Composición Musical.");
            this.typeDAO.saveType(type);

            type = new Type("Obra De Bellas Artes");
            type.setDescription("Obra De Bellas Artes.");
            this.typeDAO.saveType(type);

            type = new Type("Obra Fotográfica");
            type.setDescription("Obra Fotográfica.");
            this.typeDAO.saveType(type);

            type = new Type("Ilustración (Mapa)");
            type.setDescription("Ilustración (Mapa).");
            this.typeDAO.saveType(type);

            type = new Type("Obra Derivada");
            type.setDescription("Obra Derivada.");
            this.typeDAO.saveType(type);

            type = new Type("Otro");
            type.setDescription("Otro.");
            this.typeDAO.saveType(type);
        }
    }

    private void tester() {
    }
}