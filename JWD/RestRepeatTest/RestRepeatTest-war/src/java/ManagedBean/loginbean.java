/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBean;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.security.enterprise.AuthenticationStatus;
import static javax.security.enterprise.AuthenticationStatus.SEND_FAILURE;
import static javax.security.enterprise.AuthenticationStatus.SUCCESS;
import javax.security.enterprise.SecurityContext;
import static javax.security.enterprise.authentication.mechanism.http.AuthenticationParameters.withParams;
import javax.security.enterprise.credential.Credential;
import javax.security.enterprise.credential.Password;
import javax.security.enterprise.credential.UsernamePasswordCredential;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author shubham
 */
@Named(value = "login")
@RequestScoped
public class loginbean  {

     @Inject
    SecurityContext sc;
    private String username;
    private String password;
    private String messgae;

    public String getMessgae() {
        return messgae;
    }

    public void setMessgae(String messgae) {
        this.messgae = messgae;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public loginbean() {
    }
    
    
    public String CheckLogin(){
        
        System.out.println("In Check Method");
        
         try{
             HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
                HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
                Credential credential = new UsernamePasswordCredential(getUsername(), new Password(getPassword()));
                AuthenticationStatus status = sc.authenticate(request,response, withParams().credential(credential));
                System.out.println("User "+getUsername() +" "+getPassword());   
                System.err.println(status);
                if(status.equals(SUCCESS)){
                    HttpSession session= request.getSession(true);
                    session.setAttribute("username",getUsername());
                    session.setAttribute("password",getPassword());
                    System.out.println(sc.isCallerInRole("Admin"));
                    if(sc.isCallerInRole("Admin")){
                        return "admin.jsf";
                    }
                    else if(sc.isCallerInRole("Employee")){
                        return "employee.jsf";
                    }
                    else{
                        System.out.println("No Role Found");
                    }
                }
                else if(status.equals(SEND_FAILURE)){
                    messgae="Username Or Password is Wrong";
                    return "index.jsf";
                }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        
        return null;
    }
    
}
