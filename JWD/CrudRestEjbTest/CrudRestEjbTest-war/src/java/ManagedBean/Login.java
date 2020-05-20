/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBean;

import javax.annotation.security.DeclareRoles;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.security.enterprise.AuthenticationStatus;
import static javax.security.enterprise.AuthenticationStatus.SEND_FAILURE;
import static javax.security.enterprise.AuthenticationStatus.SUCCESS;
import javax.security.enterprise.SecurityContext;
import javax.security.enterprise.authentication.mechanism.http.AuthenticationParameters;
import static javax.security.enterprise.authentication.mechanism.http.AuthenticationParameters.withParams;
import javax.security.enterprise.credential.Credential;
import javax.security.enterprise.credential.Password;
import javax.security.enterprise.credential.UsernamePasswordCredential;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author shubham
 */
@Named(value = "login")
@RequestScoped
//@DeclareRoles({"Admin","Employee"})
//@ServletSecurity(@HttpConstraint(rolesAllowed = "Admin"))

public class Login {
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
             HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
                HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
                Credential credential = new UsernamePasswordCredential(getUname(), new Password(getPass()));
                AuthenticationStatus status = sc.authenticate(request,response, withParams().credential(credential));
                   System.err.println(status);
                if(status.equals(SUCCESS)){
                    HttpSession session= request.getSession(true);
                    session.setAttribute("username",getUname());
                    session.setAttribute("password",getPass());
                    System.out.println(sc.isCallerInRole("Admin"));
                    if(sc.isCallerInRole("Admin")){
                        return "index.jsf";
                    }
                    else if(sc.isCallerInRole("Employee")){
                        return "/employees/Employee.jsf";
                    }
                    else{
                        System.out.println("No Role Found");
                    }
                }
                else if(status.equals(SEND_FAILURE)){
                    message="Username Or Password is Wrong";
                    return "login.jsf";
                }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        return null;
        
        
    }
    
}
