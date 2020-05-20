/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 package beans;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author root
 */

 //@ApplicationScoped
//@Named
public class AppListener implements PhaseListener {
    //@Inject FacesContext fext;
    //@Inject private ExternalContext ext;

    @Override
    public void afterPhase(PhaseEvent event) {
   //     throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   
    }

    @Override
    public void beforePhase(PhaseEvent event) {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      System.out.println("In First Phase Listener");
      ExternalContext ext = event.getFacesContext().getCurrentInstance().getExternalContext();
      try{
        if(event.getPhaseId().equals(PhaseId.RESTORE_VIEW))
            System.out.println("In Phase Listener");
        {
            HttpServletRequest request = (HttpServletRequest)ext.getRequest();
             HttpServletResponse response = (HttpServletResponse)ext.getResponse();
            if(request.getSession().getAttribute("logged-group")==null || request.getSession().getAttribute("logged-group").equals(""))
            {
                System.out.println("In Phase Listener - blank group");
                request.getServletContext().getRequestDispatcher("/Login.jsf").forward(request, response);
                 //ext.redirect("/EnterpriseSecureJSF-war/Login.jsf");
            }
            else{
          if((request.getRequestURI().contains("/admins/") && !request.getSession().getAttribute("logged-group").equals("Admin")))
          {
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "You are Not Authorised to view this Page . Go Back To Login");
        
          }   
          
          else if((request.getRequestURI().contains("/users/") && !request.getSession().getAttribute("logged-group").equals("Supervisor")))
          {
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "You are Not Authorised to view this Page . Go Back To Login");
            
          } 
            }
        }
    }
    catch (Exception e)
    {
        
    }
    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.RESTORE_VIEW;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
