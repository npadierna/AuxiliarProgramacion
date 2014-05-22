package co.edu.udea.obras.service.report.oeuvre;

import co.edu.udea.obras.web.bean.authoroeuvre.AuthorOeuvreSelectorBean;
import java.io.IOException;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

/**
 *
 * @author Miguel Ossa Ruiz
 * @author Neiber Padierna P&eacute;rez
 */
public class SingleOeuvreReportServlet extends HttpServlet
        implements Serializable {

    private static final long serialVersionUID = 7423979878025392128L;
    public static final String ACQUISITION_TYPE = "acquisition";
    public static final String AUTHOR_OEUVRE_DOCUMENT_TYPE = "author_oeuvre_document_type";
    public static final String AUTHOR_OEUVRE_ID_NUMBER = "author_oeuvre_id_number";
    public static final String AUTHOR_OEUVRE_TYPE_NAME = "author_oeuvre_type_name";
    public static final String CONTRACT_ID = "contract";
    public static final String OEUVRE_ID = "oeuvre_id";
    @Autowired()
    private AuthorOeuvreSelectorBean authorOeuvreSelectorBean;
    @Resource(name = "jndi/obras")
    private DataSource obrasDataSource;

    public SingleOeuvreReportServlet() {
        super();
    }

    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException,
            JRException {
        response.setContentType("application/pdf");

        ServletOutputStream servletOutputStream = response.getOutputStream();

        Map<String, Object> jasperParamsMap = new HashMap<String, Object>();
        jasperParamsMap.put(SingleOeuvreReportServlet.ACQUISITION_TYPE,
                this.authorOeuvreSelectorBean.getSelectedAuthorOeuvre()
                .getAcquisition().getType());
        jasperParamsMap.put(SingleOeuvreReportServlet.AUTHOR_OEUVRE_DOCUMENT_TYPE,
                this.authorOeuvreSelectorBean.getSelectedAuthorOeuvre()
                .getAuthor().getPeoplePK().getDocumentType());
        jasperParamsMap.put(SingleOeuvreReportServlet.AUTHOR_OEUVRE_ID_NUMBER,
                this.authorOeuvreSelectorBean.getSelectedAuthorOeuvre()
                .getAuthor().getPeoplePK().getIdNumber());
        jasperParamsMap.put(SingleOeuvreReportServlet.AUTHOR_OEUVRE_TYPE_NAME,
                this.authorOeuvreSelectorBean.getSelectedAuthorOeuvre()
                .getOeuvreType().getType().getName());
        jasperParamsMap.put(SingleOeuvreReportServlet.CONTRACT_ID,
                this.authorOeuvreSelectorBean.getSelectedAuthorOeuvre()
                .getContract().getId());
        jasperParamsMap.put(SingleOeuvreReportServlet.OEUVRE_ID,
                this.authorOeuvreSelectorBean.getSelectedAuthorOeuvre()
                .getOeuvreType().getOeuvre().getId());

        try {
            Connection connection = this.obrasDataSource.getConnection();
            if (connection != null) {
                JasperReport jasperRerport = (JasperReport) JRLoader.loadObjectFromFile(
                        super.getServletContext()
                        .getRealPath("/co/edu/udea/obras/report/oeuvre/singleoeuvre/Obr@sReport.jasper"));
                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperRerport,
                        jasperParamsMap, connection);

                JRExporter jRExporter = new JRPdfExporter();
                jRExporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
                jRExporter.setParameter(JRExporterParameter.OUTPUT_STREAM,
                        servletOutputStream);
                jRExporter.exportReport();

                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(FullOeuvreReportServlet.class.getName())
                            .log(Level.SEVERE, null, ex);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(FullOeuvreReportServlet.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
    }

    @Override()
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        try {
            this.processRequest(request, response);
        } catch (JRException ex) {
            Logger.getLogger(SingleOeuvreReportServlet.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
    }

    @Override()
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        try {
            this.processRequest(request, response);
        } catch (JRException ex) {
            Logger.getLogger(SingleOeuvreReportServlet.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
    }

    @Override()
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this,
                config.getServletContext());
    }
}