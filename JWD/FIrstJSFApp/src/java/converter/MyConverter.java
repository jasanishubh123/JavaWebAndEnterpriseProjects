/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author shubham
 */
@FacesConverter("myconverter")
 public class MyConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
       
        if(value.startsWith("IN")){
            FacesMessage fm = new FacesMessage("You can not start with IN");
            fm.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ConverterException(fm);   
        }
             String cval = "::"+value+"::";
             return cval;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
      
        String str = (String)t;
        return (str.substring(2,str.length()-2));
    }
    
    
}
