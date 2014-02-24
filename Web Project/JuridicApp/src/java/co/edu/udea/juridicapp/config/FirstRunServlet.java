package co.edu.udea.juridicapp.config;

import co.edu.udea.juridicapp.service.config.IFirstRunConfiguration;
import co.edu.udea.juridicapp.service.config.impl.FirstRunConfigurationImpl;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class FirstRunServlet implements ServletContextListener {

    @Override()
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println(" + Creating the context servlet application...");

        ApplicationContext appContext =
                WebApplicationContextUtils.getWebApplicationContext(sce.getServletContext());
        IFirstRunConfiguration initialConfig =
                (FirstRunConfigurationImpl) appContext.getBean("firstRunConfiguration");
        initialConfig.createDefaultData();
    }

    @Override()
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println(" + Destroying the context servlet application.");
    }
}