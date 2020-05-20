/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import client.AnotherRestClient;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Response;

/**
 *
 * @author snehal
 */
@Named(value = "anotherrest")
@RequestScoped
public class AnotherRestBean {
    
    Response res;
    String username;
    String password;
    AnotherRestClient arc;
    String str="";

    public Response getRes() {
        return res;
    }

    public void setRes(Response res) {
        this.res = res;
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

    public AnotherRestClient getArc() {
        return arc;
    }

    public void setArc(AnotherRestClient arc) {
        this.arc = arc;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public AnotherRestBean() {
        System.out.println("Hello AnotherRestBean Bean ");
          HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
       String token="";
                   Cookie cookies[] = request.getCookies();
        for(Cookie c: cookies)
        {
            System.out.println("name ="+c.getName()+" Val = "+c.getValue());
            if(c.getName().equals("JREMEMBERMEID")){
               token= c.getValue();
               
            }
        } 
       token = request.getSession().getAttribute("token").toString();
       System.out.println("Token="+token);
       arc=new AnotherRestClient(token);
       str=arc.getHello();
    }
    
    
    
}
