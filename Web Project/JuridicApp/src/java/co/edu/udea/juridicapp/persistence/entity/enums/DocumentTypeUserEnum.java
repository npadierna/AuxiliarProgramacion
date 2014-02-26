package co.edu.udea.juridicapp.persistence.entity.enums;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Miguel Ossa Ruiz
 * @author Neiber Padierna P&eacute;rez
 */
public enum DocumentTypeUserEnum {

    CEDULA_DE_CIUDADANIA("Cédula De Ciudadanía"),
    CEDULA_DE_EXTRANJERIA("Cédula De Extrajería"),
    NUMERO_IDENTIFICACION_PERSONAL("Número Único De Identificación Personal"),
    REGISTRO_CIVIL("Registro Civil"),
    TARJETA_DE_IDENTIDAD("Tarjeta De Identidad");
    private String documentType;

    private DocumentTypeUserEnum(String documentType) {
        this.setDocumentType(documentType);
    }

    public String getDocumentType() {

        return (this.documentType);
    }

    private void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public static List<String> obtainDocumentsTypeList() {
        List<String> documentsTypeList = new ArrayList<>();

        for (DocumentTypeUserEnum e : DocumentTypeUserEnum.values()) {
            documentsTypeList.add(e.getDocumentType());
        }

        return (documentsTypeList);
    }

    @Override()
    public String toString() {

        return (this.getDocumentType());
    }
}