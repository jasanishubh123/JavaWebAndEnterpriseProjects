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
 * Jersey REST client generated for REST resource:RestAgent [generic]<br>
 * USAGE:
 * <pre>
 *        AgentClient client = new AgentClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author shubham
 */
public class AgentClient {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "https://localhost:8181/Rest_Global_Insurance-war/webresources";

    public AgentClient(String token) {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        client.register(new RestFilter(token));
        webTarget = client.target(BASE_URI).path("generic").queryParam("token", token);
    }

    public String Hello() throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getHello");
        return resource.request(javax.ws.rs.core.MediaType.TEXT_PLAIN).get(String.class);
    }

    public <T> T getAllAgent(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllAgent");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getAddressByAgentId(Class<T> responseType, String aid) throws ClientErrorException {
        WebTarget resource = webTarget;
        if (aid != null) {
            resource = resource.queryParam("aid", aid);
        }
        resource = resource.path("getAddressOfAgent");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void updateAgent(Object requestEntity) throws ClientErrorException {
        webTarget.path("updateAgent").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public String removeEmp(String aid) throws ClientErrorException {
        WebTarget resource = webTarget;
        if (aid != null) {
            resource = resource.queryParam("aid", aid);
        }
        resource = resource.path("deleteAgent");
        return resource.request(javax.ws.rs.core.MediaType.TEXT_PLAIN).get(String.class);
    }

    public <T> T getAgent(Class<T> responseType, String aid) throws ClientErrorException {
        WebTarget resource = webTarget;
        if (aid != null) {
            resource = resource.queryParam("aid", aid);
        }
        resource = resource.path("getSingleAgent");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T addAgent(Object requestEntity, Class<T> responseType) throws ClientErrorException {
        return webTarget.path("addAgent").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), responseType);
    }

    public void close() {
        client.close();
    }
    
}
