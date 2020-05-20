/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBean;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import static javax.faces.application.FacesMessage.SEVERITY_ERROR;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.security.auth.message.AuthStatus;
import javax.security.enterprise.AuthenticationStatus;
import static javax.security.enterprise.AuthenticationStatus.SEND_FAILURE;
import static javax.security.enterprise.AuthenticationStatus.SUCCESS;
import javax.security.enterprise.SecurityContext;
import static javax.security.enterprise.authentication.mechanism.http.AuthenticationParameters.withParams;
import javax.security.enterprise.credential.Credential;
import javax.security.enterprise.credential.Password;
import javax.security.enterprise.credential.UsernamePasswordCredential;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author shubham
 */
@Named(value = "login")
@SessionScoped
public class Login implements Serializable {
    @Inject
    SecurityContext sc;

     private String uname;
     private String pass,message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    
    public Login() {
    }
    
    
    public String CheckLogin(){
        System.out.println("In Checking");
        try{
            
            FacesContext context = FacesContext.getCurrentInstance();
             HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
                HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
                Credential credential = new UsernamePasswordCredential(getUname(), new Password(getPass()));
                
                AuthenticationStatus status = sc.authenticate(request,response, withParams()
                        .credential(credential).newAuthentication(false).rememberMe(true));
                   System.err.println(status);
                if(status.equals(AuthStatus.SEND_CONTINUE)){
                    context.responseComplete();
                }
                else if(status.equals(SEND_FAILURE)){
                     addError(context, "Authentication failed");

                }
                if(sc.isCallerInRole("Admin")){
                        response.sendRedirect(request.getContextPath()+"/"+"index.jsf");
                        //return "index.jsf";
                }
                else if(sc.isCallerInRole("Employee")){
                    response.sendRedirect(request.getContextPath()+"/"+"employee.jsf");

                    //return "employee.jsf";
                }
                else{
                   message = "Either user or password is wrong !!!";
                   return "/login.jsf";
                }
        }
        catch(Exception e){
            message = "Out- Either user or login is wrong !!!";
            e.printStackTrace();
        }
        
        return null;
        
        
    }
     private static void addError(FacesContext context, String message) {
        context = FacesContext.getCurrentInstance();
        context
                .addMessage(
                        null,
                        new FacesMessage(SEVERITY_ERROR, message, null));
    }
     
   public String logout() throws ServletException
   {
       System.out.println("In Log out");
          HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
          request.logout();
          
          return "/login.jsf";
             
    }
    
}
