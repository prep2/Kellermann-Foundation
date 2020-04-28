package model;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.http.HttpSession;

public class AuthorizationListener
  implements PhaseListener
{
	private static final long serialVersionUID = 6406806522469361092L;  //randomly generated for serialized class

public void afterPhase(PhaseEvent event)
  {
    FacesContext facesContext = event.getFacesContext();
    String currentPage = facesContext.getViewRoot().getViewId();

    boolean isLoginPage = currentPage.lastIndexOf("start.xhtml") > -1;
    HttpSession session = (HttpSession)facesContext.getExternalContext().getSession(false);

    if (session == null) {
      NavigationHandler nh = facesContext.getApplication().getNavigationHandler();
      nh.handleNavigation(facesContext, null, "start");
    } else {
      Object currentUser = session.getAttribute("username");

      if ((!isLoginPage) && ((currentUser == null) || (currentUser == ""))) {
        NavigationHandler nh = facesContext.getApplication().getNavigationHandler();
        nh.handleNavigation(facesContext, null, "start");
      }
    }
  }

  public void beforePhase(PhaseEvent event) {
  }

  public PhaseId getPhaseId() {
    return PhaseId.RESTORE_VIEW;
  }
}