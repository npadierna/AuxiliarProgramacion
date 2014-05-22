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
public class FullOeuvreReportServlet extends HttpServlet
        implements Serializable {

    private static final long serialVersionUID = 7324905274180794368L;
    public static final String OEUVRE_ID = "oeuvre_id";
    @Autowired()
    private AuthorOeuvreSelectorBean authorOeuvreSelectorBean;
    @Resource(name = "jndi/obras")
    private DataSource obrasDataSource;

    public FullOeuvreReportServlet() {
        super();
    }

    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException,
            JRException {
        response.setContentType("application/pdf");

        ServletOutputStream servletOutputStream = response.getOutputStream();

        Map<String, Object> jasperParamsMap = new HashMap<String, Object>();
        jasperParamsMap.put(FullOeuvreReportServlet.OEUVRE_ID,
                this.authorOeuvreSelectorBean.getSelectedAuthorOeuvre()
                .getOeuvreType().getOeuvre().getId());

        try {
            Connection connection = this.obrasDataSource.getConnection();
            JasperReport jasperRerport = (JasperReport) JRLoader.loadObjectFromFile(
                    super.getServletContext()
                    .getRealPath("/co/edu/udea/obras/report/oeuvre/fulloeuvre/Obr@sReport.jasper"));
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
            Logger.getLogger(FullOeuvreReportServlet.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
    }

    @Override()
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        try {
            this.processRequest(request, response);
        } catch (JRException ex) {
            Logger.getLogger(FullOeuvreReportServlet.class.getName())
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