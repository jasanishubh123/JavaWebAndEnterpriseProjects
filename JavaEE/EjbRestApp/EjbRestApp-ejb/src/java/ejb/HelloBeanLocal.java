/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import javax.ejb.Local;
import javax.ejb.Stateless;

/**
 *
 * @author shubham
 */
@Local

public interface HelloBeanLocal {
    public String SayHello();
}
