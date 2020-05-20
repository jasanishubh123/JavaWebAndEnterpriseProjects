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
 * @author shubham
 */

@DatabaseIdentityStoreDefinition(
        dataSourceLookup = "jdbc/emp",
        callerQuery = "select Password from EmpTB where EmployeeName=?",
        groupsQuery = "select r.RoleName from RoleTB r,EmpTB e where e.RoleId=r.RoleId and EmployeeName=?",
        hashAlgorithm = Pbkdf2PasswordHash.class,
        priority = 30
)
@CustomFormAuthenticationMechanismDefinition(
        loginToContinue = @LoginToContinue(
                loginPage = "login.jsf"
                
        )
)
@Named
@ApplicationScoped
public class ProjectConfig {
    
    
}
