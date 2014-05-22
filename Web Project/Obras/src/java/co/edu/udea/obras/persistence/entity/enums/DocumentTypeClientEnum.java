package co.edu.udea.obras.persistence.entity.enums;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Miguel Ossa Ruiz
 * @author Neiber Padierna P&eacute;rez
 */
public enum DocumentTypeClientEnum {

    CEDULA_DE_CIUDADANIA("Cédula de Ciudadanía"),
    CEDULA_DE_EXTRANJERIA("Cédula de Extranjería"),
    NUMERO_IDENTIFICACION_PERSONAL("Número Único de Identificación Personal"),
    REGISTRO_CIVIL("Registro Civil"),
    TARJETA_DE_IDENTIDAD("Tarjeta de Identidad");
    private String documentType;

    private DocumentTypeClientEnum(String documentType) {
        this.setDocumentType(documentType);
    }

    public String getDocumentType() {

        return (this.documentType);
    }

    private void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public static List<String> obtainDocumentsTypeList() {
        List<String> documentsTypeList = new ArrayList<String>();

        for (DocumentTypeClientEnum e : DocumentTypeClientEnum.values()) {
            documentsTypeList.add(e.getDocumentType());
        }

        return (documentsTypeList);
    }

    @Override()
    public String toString() {

        return (this.getDocumentType());
    }
}