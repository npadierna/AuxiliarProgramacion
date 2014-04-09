package co.edu.udea.juridicapp.service.report.oeuvre;

import java.io.IOException;
import javax.servlet.ServletContext;
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
public class SingleOeuvreReportServlet extends HttpServlet {

    public static final String SELECTED_OEUVRE_ID = "oeuvre_id";

    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/pdf");

        String oeuvreId = request.getParameter(
                SingleOeuvreReportServlet.SELECTED_OEUVRE_ID);
        Object o = super.getServletContext().getAttribute(
                SingleOeuvreReportServlet.SELECTED_OEUVRE_ID);

        ServletOutputStream servletOutputStream = response.getOutputStream();
        ServletContext servletContext = super.getServletContext();
        servletContext.getRequestDispatcher("/faces/co/edu/udea/juridicapp/web/oeuvre/list/oeuvrelist.xhtml").forward(request, response);


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