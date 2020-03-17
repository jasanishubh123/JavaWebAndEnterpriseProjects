/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.security.enterprise.authentication.mechanism.http.BasicAuthenticationMechanismDefinition;
import javax.security.enterprise.identitystore.DatabaseIdentityStoreDefinition;
import javax.security.enterprise.identitystore.Pbkdf2PasswordHash;

/**
 *
 * @author shubham
 */
@BasicAuthenticationMechanismDefinition(
        realmName = "jdbc"
)
@DatabaseIdentityStoreDefinition(
        dataSourceLookup = "jdbc/jaas",
        hashAlgorithm = Pbkdf2PasswordHash.class,
        callerQuery = "select Password from UserTB where UserId=?",
        groupsQuery = "select GroupName from GroupTB where UserId=?",
        priority = 30
)
@Named
@ApplicationScoped
public class ProjectConfig {
    
}
