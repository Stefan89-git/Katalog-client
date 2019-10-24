package rs.itcentar.katalog_proizvoda;

import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author IQooLogic
 */
public class KatalogClient {

    private static final String BASE_URL = "http://localhost:8080/katalog-api/api/katalog";
    private Client client = ClientBuilder.newClient();

    public List<Proizvodi> getProizvodi() {
        WebTarget webTarget = client.target(BASE_URL);

        Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
        Response response = invocationBuilder.get();
        if (response.getStatus() == 200) {
            List<Proizvodi> proizvodi = response.readEntity(new GenericType<List<Proizvodi>>() {
            });
            response.close();
            return proizvodi;
        }

        return null;
    }

    public void addProduct(Proizvodi proizvod) {
        WebTarget webTarget = client.target(BASE_URL);

        Response response = webTarget.request().put(Entity.entity(proizvod, MediaType.APPLICATION_JSON_TYPE));
        if (response.getStatus() == 201) {

        }
        response.close();
    }

    public void deleteProduct(int id) {
        WebTarget webTarget = client.target(BASE_URL).path(String.valueOf(id));

        Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
        Response response = invocationBuilder.delete();
        System.out.println(response.getStatus());// 200
        if (response.getStatus() == 200) {

        }
        response.close();
    }

    public void updateProduct(int id, Proizvodi proizvod) {
        WebTarget webTarget = client.target(BASE_URL).path(String.valueOf(id));

        Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
        Response response = invocationBuilder.post(Entity.entity(proizvod, MediaType.APPLICATION_JSON_TYPE));
        System.out.println(response.getStatus());// 200
        if (response.getStatus() == 200) {

        }
        response.close();
    }
}
