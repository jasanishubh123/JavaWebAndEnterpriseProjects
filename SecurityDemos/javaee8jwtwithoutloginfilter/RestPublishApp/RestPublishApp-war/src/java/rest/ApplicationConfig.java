/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import java.util.Set;
import javax.ws.rs.core.Application;
//import org.glassfish.jersey.server.ResourceConfig;
//import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;
 

/**
 *
 * @author root
 */

@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    public ApplicationConfig() {
           
       
    }

    @Override
    public Set<Class<?>> getClasses() {
        
         Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }
    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(client.RestFilter.class);
        resources.add(rest.PublishRest.class);
    }
    
}
