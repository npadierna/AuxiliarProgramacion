package co.edu.udea.juridicapp.service.report.oeuvre;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Miguel Ossa Ruiz
 * @author Neiber Padierna P&eacute;rez
 */
public class FullOeuvreReportServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/pdf");

        ServletOutputStream servletOutputStream = response.getOutputStream();
//        JasperReport jasperRerport = (JasperReport) JRLoader.loadObject(
//                super.getServletContext()
//                .getRealPath("resources/jasperreport/Obr@sReport.jasper"));
//
//        Map jasperParamsMap = new HashMap();
//        jasperParamsMap.put("oeuvre_id", 4);
//
//        Connection connection = this.stablishConnection();
//        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperRerport,
//                jasperParamsMap, connection);
//        JRExporter jRExporter = new JRPdfExporter();
//        jRExporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
//        jRExporter.setParameter(JRExporterParameter.OUTPUT_STREAM,
//                servletOutputStream);
//        jRExporter.exportReport();
//
//        try {
//            connection.close();
//        } catch (SQLException ex) {
//            Logger.getLogger(ServletReportViewer.class.getName())
//                    .log(Level.SEVERE, null, ex);
//        }
    }

    @Override()
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
//        try {
        this.processRequest(request, response);
//        } catch (JRException ex) {
//            Logger.getLogger(ServletReportViewer.class.getName())
//                    .log(Level.SEVERE, null, ex);
//        }
    }

    @Override()
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
//        try {
        this.processRequest(request, response);
//        } catch (JRException ex) {
//            Logger.getLogger(ServletReportViewer.class.getName())
//                    .log(Level.SEVERE, null, ex);
//        }
    }
}