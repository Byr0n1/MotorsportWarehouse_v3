/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byron.motorsportwarehouse.api;

import byron.motorsportwarehouse.App;
import byron.motorsportwarehouse.domain.CarPart;
import java.net.URI;
import java.util.LinkedHashMap;
import java.util.List;
import javax.security.auth.Subject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
@IntegrationTest({"server.port=8080"})

public class CarPartPageTest {
        final String BASE_URL = "http://localhost:8080/";
    private RestTemplate template;

    @Before
    public void setUp() throws Exception {
        template = new TestRestTemplate();
    }

    @Test
    public void testRead() throws Exception {
        ResponseEntity<String> response =template.getForEntity(BASE_URL+"api/Carpart/readall", String.class);

        System.out.println("The response is "+response.getBody());


    }

    public static final String REST_SERVICE_URI = "http://localhost:8080/api";

    /* GET */
    @SuppressWarnings("unchecked")
    private static void listAllCarparts(){
        System.out.println("Testing listAllCarparts API-----------");

        RestTemplate restTemplate = new RestTemplate();
        List<LinkedHashMap<String, Object>> CarpartsMap = restTemplate.getForObject(REST_SERVICE_URI+"/carparts/", List.class);

        if(CarpartsMap!=null){
            for(LinkedHashMap<String, Object> map : CarpartsMap){
                System.out.println("partnum : id="+map.get("id")+", status="+map.get("status")+", price="+map.get("price"));;
            }
        }else{
            System.out.println("No Carpart exist----------");
        }
    }

    /* GET */
    private static void getCarPart(){
        System.out.println("Testing getCarpart API----------");
        RestTemplate restTemplate = new RestTemplate();
        CarPart carpart = restTemplate.getForObject(REST_SERVICE_URI+"/carpart/1", CarPart.class);
        System.out.println(carpart);
    }

    /* POST */
    private static void createCarPart() {
        System.out.println("Testing create Carpart API----------");
        RestTemplate restTemplate = new RestTemplate();
        CarPart carpart = new CarPart.Builder("123").Status("instock").Price(400.00).build();
        URI uri = restTemplate.postForLocation(REST_SERVICE_URI+"/carpart/create/", carpart, CarPart.class);
        System.out.println("Location : "+uri.toASCIIString());
    }

    /* PUT */
    private static void updateCarpart() {
        System.out.println("Testing update Carpart API----------");
        RestTemplate restTemplate = new RestTemplate();
        CarPart carpart = new CarPart.Builder("123").Status("instock").Price(500.00).build();
        restTemplate.put(REST_SERVICE_URI+"/carpart/update/1", carpart);
        System.out.println(carpart);
    }

    /* DELETE */
    private static void deleteCarpart() {
        System.out.println("Testing delete Carpart API----------");
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(REST_SERVICE_URI+"/carpart/delete/3");
    }


    /* DELETE */
    private static void deleteAllCarparts() {
        System.out.println("Testing all delete Carparts API----------");
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(REST_SERVICE_URI + "/carpart/");
    }
}
