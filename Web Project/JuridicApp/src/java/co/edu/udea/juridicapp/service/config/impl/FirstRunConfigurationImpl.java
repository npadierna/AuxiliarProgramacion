package co.edu.udea.juridicapp.service.config.impl;

import co.edu.udea.juridicapp.persistence.dao.IAcquisitionDAO;
import co.edu.udea.juridicapp.persistence.dao.IDependencyDAO;
import co.edu.udea.juridicapp.persistence.dao.IProfileDAO;
import co.edu.udea.juridicapp.persistence.dao.ITitleDAO;
import co.edu.udea.juridicapp.persistence.dao.ISupportDAO;
import co.edu.udea.juridicapp.persistence.dao.ITypeDAO;
import co.edu.udea.juridicapp.persistence.entity.Acquisition;
import co.edu.udea.juridicapp.persistence.entity.Dependency;
import co.edu.udea.juridicapp.persistence.entity.Profile;
import co.edu.udea.juridicapp.persistence.entity.Title;
import co.edu.udea.juridicapp.persistence.entity.Support;
import co.edu.udea.juridicapp.persistence.entity.Type;
import co.edu.udea.juridicapp.service.config.IFirstRunConfiguration;
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
    private IDependencyDAO dependencyDAO;
    @Autowired()
    private IProfileDAO profileDAO;
    @Autowired()
    private ITitleDAO titleDAO;
    @Autowired()
    private ISupportDAO supportDAO;
    @Autowired()
    private ITypeDAO typeDAO;

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
            Acquisition acquisition = new Acquisition("Contrato de Cesión de Derechos");
            this.acquisitionDAO.saveAcquisition(acquisition);

            acquisition = new Acquisition("Contrato de Obra por Encargo");
            this.acquisitionDAO.saveAcquisition(acquisition);

            acquisition = new Acquisition("Presunción Legal Plan de Trabajo");
            this.acquisitionDAO.saveAcquisition(acquisition);

            acquisition = new Acquisition("Autorización");
            this.acquisitionDAO.saveAcquisition(acquisition);

            acquisition = new Acquisition("Licencia de Software");
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
            Dependency dependency = new Dependency("Ingeniería de Sistemas");
            dependency.setDescription("Departamento de Ingeniería de Sistemas de la Universidad de Antioquia.");
            this.dependencyDAO.saveDependency(dependency);
            
            dependency = new Dependency("Ingeniería Industrial");
            dependency.setDescription("Departamento de Ingeniería Industrial de la Universidad de Antioquia.");
            this.dependencyDAO.saveDependency(dependency);
            
            dependency = new Dependency("Ingeniería Ambiental");
            dependency.setDescription("Departamento de Ingeniería Ambiental de la Universidad de Antioquia.");
            this.dependencyDAO.saveDependency(dependency);
            
            dependency = new Dependency("Ingeniería De Telecomunicaciones");
            dependency.setDescription("Departamento de Ingeniería de Telecomunicaciones de la Universidad de Antioquia.");
            this.dependencyDAO.saveDependency(dependency);

            dependency = new Dependency("Facultad de Comunicaciones");
            dependency.setDescription("Facultad de Comunicaciones de la Universidad de Antioquia.");
            this.dependencyDAO.saveDependency(dependency);

            dependency = new Dependency("Facultad de Ingeniería");
            dependency.setDescription("Facultad de Ingeniería de la Universidad de Antioquia.");
            this.dependencyDAO.saveDependency(dependency);

            dependency = new Dependency("Facultad de Educación");
            dependency.setDescription("Facultad de Educación de la Universidad de Antioquia.");
            this.dependencyDAO.saveDependency(dependency);

            dependency = new Dependency("D.R.A.I.");
            dependency.setDescription("Departamento de Recursos de Apoyo e Informática de la Universidad de Antioquia.");
            this.dependencyDAO.saveDependency(dependency);

            dependency = new Dependency("Proyectos Especiales");
            dependency.setDescription("Proyectos Especiales avalados por la Universidad de Antioquia.");
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

            profile = new Profile("Gestor de Contratos");
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

            title = new Title("Profesor de Cátedra");
            title.setDescription("Profesor de Cátedra.");
            this.titleDAO.saveTitle(title);

            title = new Title("Estudiante de Pregrado");
            title.setDescription("Estudiante de Pregrado.");
            this.titleDAO.saveTitle(title);

            title = new Title("Estudiante de Postgrado");
            title.setDescription("Estudiante de Postgrado.");
            this.titleDAO.saveTitle(title);

            title = new Title("Empleado de Carrera");
            title.setDescription("Empleado de Carrera.");
            this.titleDAO.saveTitle(title);

            title = new Title("Empleado de Libre Nombramiento");
            title.setDescription("Empleado de Libre Nombramiento.");
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

            type = new Type("Programa de Ordenador (Software)");
            type.setDescription("Programa de Ordenador (Software).");
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

            type = new Type("Obra de Bellas Artes");
            type.setDescription("Obra de Bellas Artes.");
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

            type = new Type("Aula Semilla");
            type.setDescription("Aula Semilla.");
            this.typeDAO.saveType(type);
        }
    }

    private void tester() {
    }
}