package co.edu.udea.juridicapp.service.config.impl;

import co.edu.udea.juridicapp.persistence.dao.IAcquisitionDAO;
import co.edu.udea.juridicapp.persistence.dao.ISupportDAO;
import co.edu.udea.juridicapp.persistence.dao.ITypeDAO;
import co.edu.udea.juridicapp.persistence.entity.Acquisition;
import co.edu.udea.juridicapp.persistence.entity.Support;
import co.edu.udea.juridicapp.persistence.entity.Type;
import co.edu.udea.juridicapp.service.config.IFirstRunConfiguration;
import org.springframework.beans.factory.annotation.Autowired;

public class FirstRunConfigurationImpl implements IFirstRunConfiguration {

    @Autowired()
    private IAcquisitionDAO acquisitionDAO;
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
    }

    @Override()
    public void createDefaultProfiles() {
    }

    @Override()
    public void createDefaultRoles() {
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
}