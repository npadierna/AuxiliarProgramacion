package co.edu.udea.juridicapp.security.authorization;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Miguel Ossa Ruiz
 * @author Neiber Padierna P&eacute;rez
 */
public class AuthorizationListener implements PhaseListener {

    private static final long serialVersionUID = 7755249919051165696L;

    @Override()
    public void afterPhase(PhaseEvent event) {
        FacesContext facesContext = event.getFacesContext();
        String currentPage = facesContext.getViewRoot().getViewId();
        boolean isLoginPage = (currentPage.lastIndexOf("login.xhtml") > -1)
                ? true : false;
        boolean isRecoverPage = (currentPage.lastIndexOf("recoverclientpassword.xhtml") > -1)
                ? true : false;
        HttpSession sesion = (HttpSession) facesContext.getExternalContext()
                .getSession(true);
        Object usuario = sesion.getAttribute("usuario");

        if ((isLoginPage == false && isRecoverPage == false) && (usuario == null)
                && !(currentPage.endsWith(".js"))) {
            NavigationHandler navigationHandler = facesContext.getApplication()
                    .getNavigationHandler();
            navigationHandler.handleNavigation(facesContext, null,
                    "/co/edu/udea/juridicapp/web/index.xhtml");
        }
    }

    @Override()
    public void beforePhase(PhaseEvent event) {
    }

    @Override()
    public PhaseId getPhaseId() {

        return (PhaseId.RESTORE_VIEW);
    }
}