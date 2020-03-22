/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customcomponents;


import java.io.IOException;

import javax.faces.component.FacesComponent;
import javax.faces.component.UIComponentBase;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

/**
 *
 * 
 * @author shubham
 */
@FacesComponent(createTag = true , tagName = "mytag" )

public class CustomComponent extends UIComponentBase{

    @Override
    public String getFamily() {
        return "";
    }

    @Override
    public void encodeEnd(FacesContext context) throws IOException {
       String type=(String) getAttributes().get("type");
       String val=(String) getAttributes().get("value");
       
       if(val!=null){
           ResponseWriter w = context.getResponseWriter();
           if(type.equals("uname")){
               w.write(val.toUpperCase());
           }
           else{
               w.write(val.toLowerCase());

           }
           
       }
       
    }
    
    
}
