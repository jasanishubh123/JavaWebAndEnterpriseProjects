/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

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
//@CustomFormAuthenticationMechanismDefinition(
//        loginToContinue = @LoginToContinue(
//                loginPage = "/index.jsp"
//              
//        )
//)
@DatabaseIdentityStoreDefinition(
  dataSourceLookup = "jdbc/practiceSecurity",
  callerQuery = "select Password from UserTB where UserId=? ",
  groupsQuery = "select GroupName from GroupTB where UserId=?",
  hashAlgorithm = Pbkdf2PasswordHash.class,
  priority=30)
@Named
@ApplicationScoped
public class ProjectConfig {
    
}
