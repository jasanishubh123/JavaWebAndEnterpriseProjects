/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.security.enterprise.authentication.mechanism.http.CustomFormAuthenticationMechanismDefinition;
import javax.security.enterprise.authentication.mechanism.http.LoginToContinue;
import javax.security.enterprise.identitystore.DatabaseIdentityStoreDefinition;
import javax.security.enterprise.identitystore.Pbkdf2PasswordHash;

/**
 *
 * @author snehal
 */
@DatabaseIdentityStoreDefinition(
            dataSourceLookup = "jdbc/GlobalInsuranceDB",
            callerQuery = "select Password from UserTB where UserName=?  ",
            groupsQuery = "select g.GroupName from GroupTB g,UserTB u where g.GroupId=u.GroupId and u.UserName=?",
            hashAlgorithm = Pbkdf2PasswordHash.class,
            priority = 30
    )
//@CustomFormAuthenticationMechanismDefinition(
//        loginToContinue = @LoginToContinue(
//                loginPage = "/LogIn.jsf"
//                
//        )
//)
@Named
@ApplicationScoped
public class ProjectConfig {

    

}