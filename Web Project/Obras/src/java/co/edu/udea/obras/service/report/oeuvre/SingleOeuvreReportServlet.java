package co.edu.udea.obras.service.report.oeuvre;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;

/**
 *
 * @author Miguel Ossa Ruiz
 * @author Neiber Padierna P&eacute;rez
 */
public class SingleOeuvreReportServlet extends HttpServlet {

    public static final String ACQUISITION_TYPE = "acquisition";
    public static final String AUTHOR_OEUVRE_DOCUMENT_TYPE = "author_oeuvre_document_type";
    public static final String AUTHOR_OEUVRE_ID_NUMBER = "author_oeuvre_id_number";
    public static final String AUTHOR_OEUVRE_TYPE_NAME = "author_oeuvre_type_name";
    public static final String CONTRACT_ID = "contract";
    public static final String OEUVRE_ID = "oeuvre_id";

    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException,
            JRException {
        response.setContentType("application/pdf");

        ServletOutputStream servletOutputStream = response.getOutputStream();
        Enumeration<String> parameters = request.getParameterNames();
        String authorOeuvreSelected = request.getParameter("mainForm:mainTable_selection");

        // TODO: Modificar esto.
        if ((authorOeuvreSelected == null) || (authorOeuvreSelected.equals(""))) {
            authorOeuvreSelected = request.getParameter("oeuvreid");
        }

        Map jasperParamsMap = new HashMap();
        jasperParamsMap.put(SingleOeuvreReportServlet.ACQUISITION_TYPE,
                null);
        jasperParamsMap.put(SingleOeuvreReportServlet.AUTHOR_OEUVRE_DOCUMENT_TYPE,
                null);
        jasperParamsMap.put(SingleOeuvreReportServlet.AUTHOR_OEUVRE_ID_NUMBER,
                null);
        jasperParamsMap.put(SingleOeuvreReportServlet.AUTHOR_OEUVRE_TYPE_NAME,
                null);
        jasperParamsMap.put(SingleOeuvreReportServlet.CONTRACT_ID,
                null);
        jasperParamsMap.put(SingleOeuvreReportServlet.OEUVRE_ID,
                null);

        Connection connection = this.stablishConnection();
        JasperReport jasperRerport = (JasperReport) JRLoader.loadObject(
                super.getServletContext()
                .getRealPath("/co/edu/udea/obras/report/oeuvre/singleoeuvreObr@sReport.jasper"));
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

    private Connection stablishConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            return (DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/Obras", "root",
                    "230491"));
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(FullOeuvreReportServlet.class.getName())
                    .log(Level.SEVERE, null, ex);
        }

        return (null);
    }
}