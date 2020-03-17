/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validator;

import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author shubham
 */
@FacesValidator("customLengthValidator")

public class CustomLengthValidator implements Validator{

    @Override
    public void validate(FacesContext fc, UIComponent uic, Object t) throws ValidatorException {
       String str=(String)t;
        if(str.length()<=3){
            ((UIInput)uic).setValid(false);
            FacesMessage ms= new FacesMessage("Length err");
            fc.addMessage(uic.getClientId(fc), ms);
        }
    }

   
    
}
