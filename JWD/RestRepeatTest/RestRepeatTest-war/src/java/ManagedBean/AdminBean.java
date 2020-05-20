/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBean;

import client.DiffClient;
import client.TestClient;
import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author shubham
 */
@Named(value = "adminBean")
@SessionScoped
public class AdminBean implements Serializable {

    HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
    HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
    HttpSession session = request.getSession();
    private String test;
//    TestClient t;
    DiffClient d;
    public String getTest() {
      String username =(String) session.getAttribute("username");
      String password = (String) session.getAttribute("password");
//        t = new  TestClient(username,password);
//       test= t.getHtml();
        d= new DiffClient(username, password);
        test = d.hello();
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }
    /**
     * Creates a new instance of AdminBean
     */
    public AdminBean() {
    }
    
    
}
