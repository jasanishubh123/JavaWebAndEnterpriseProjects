/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import com.sun.istack.NotNull;
import java.util.Date;
import javax.inject.Named;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author shubham
 */
@Named(value = "customerBean")
@RequestScoped
public class CustomerBean {

    
    private String uname;
    
    private String cpass;
    private int cage;
    private String cname;
    private Date regDate= new Date();
    private String customerEmail;
    private String msg;

    
    public String showprompt(){
       // return msg;
       return msg="Hello I am From AJAX";
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    
    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    
    
    
    
    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getCpass() {
        return cpass;
    }

    public void setCpass(String cpass) {
        this.cpass = cpass;
    }

    public int getCage() {
        return cage;
    }

    public void setCage(int cage) {
        this.cage = cage;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }
    
    
    /**
     * Creates a new instance of CustomerBean
     */
    public CustomerBean() {
    }
    
    public  String ShowData(){
        return "success";
    }
    
    public void validateLength(FacesContext ctx,UIComponent ui,Object obj){
        String str=(String)obj;
        if(str.length()<=3){
            ((UIInput)ui).setValid(false);
            FacesMessage ms= new FacesMessage("Length err");
            ms.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw  new ValidatorException(ms);
        }
        
    }
}
