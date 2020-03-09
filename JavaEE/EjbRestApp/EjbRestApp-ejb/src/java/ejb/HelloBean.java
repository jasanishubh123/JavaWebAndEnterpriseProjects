/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import javax.ejb.Stateless;

/**
 *
 * @author shubham
 */
@Stateless
public class HelloBean implements HelloBeanLocal {

    @Override
    public String SayHello() {
       return "Shubham Jasani";
    }

    
}
