/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myconfig;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.security.enterprise.authentication.mechanism.http.CustomFormAuthenticationMechanismDefinition;
import javax.security.enterprise.authentication.mechanism.http.LoginToContinue;
import javax.security.enterprise.identitystore.DatabaseIdentityStoreDefinition;
import javax.security.enterprise.identitystore.Pbkdf2PasswordHash;

/**
 *
 * @author root
 */

@CustomFormAuthenticationMechanismDefinition(
        loginToContinue = @LoginToContinue(
                loginPage = "/index.jsp"
                
       
        )
)



//@BasicAuthenticationMechanismDefinition(
//  realmName = "jdbc")
//@FormAuthenticationMechanismDefinition(
//       loginToContinue = @LoginToContinue(
//                loginPage = "/index_1.jsp",
//                errorPage="/loginError.jsp"))
//        
@DatabaseIdentityStoreDefinition(
        dataSourceLookup = "jdbc/mysql",
        callerQuery = "select password from users where username = ?",
        groupsQuery = "select GROUPNAME from groups where username = ?",
        hashAlgorithm = Pbkdf2PasswordHash.class,
        priority = 30)
@ApplicationScoped
@Named
public class ProjectConfig {
    
}
