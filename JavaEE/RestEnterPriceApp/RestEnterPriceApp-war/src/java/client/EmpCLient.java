/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

/**
 * Jersey REST client generated for REST resource:EmployeeResource [Emp]<br>
 * USAGE:
 * <pre>
 *        EmpCLient client = new EmpCLient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author shubham
 */
public class EmpCLient {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/RestEnterPriceApp-war/webresources";

    public EmpCLient() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("Emp");
    }

//    public <T> T remooveEmp(Class<T> responseType, String id) throws ClientErrorException {
//        WebTarget resource = webTarget;
//        resource = resource.path(java.text.MessageFormat.format("remooveEmp/{0}", new Object[]{id}));
//        return resource.get(responseType);
//    }

    public void addEmp(String Ename, String sal) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addEmp/{0}/{1}", new Object[]{Ename, sal})).request().post(null);
    }

    public <T> T getalleemp(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void updateEmp(String id, String Ename, String sal) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateEmp/{0}/{1}/{2}", new Object[]{id, Ename, sal})).request().post(null);
    }

    public void close() {
        client.close();
    }
    
}
