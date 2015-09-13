/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byron.motorsportwarehouse.api;

import byron.motorsportwarehouse.App;
import byron.motorsportwarehouse.domain.CarPart;
import byron.motorsportwarehouse.domain.Supplier;
import java.net.URI;
import java.util.LinkedHashMap;
import java.util.List;
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
/**
 *
 * @author Byron
 */
public class SupplierPageTest {
       final String BASE_URL = "http://localhost:8080/";
    private RestTemplate template;

    @Before
    public void setUp() throws Exception {
        template = new TestRestTemplate();
    }

    @Test
    public void testRead() throws Exception {
        ResponseEntity<String> response =template.getForEntity(BASE_URL+"api/Supplier/readall", String.class);

        System.out.println("The response is "+response.getBody());


    }

    public static final String REST_SERVICE_URI = "http://localhost:8080/api";

    /* GET */
    @SuppressWarnings("unchecked")
    private static void listAllSuppliers(){
        System.out.println("Testing listAllSuppliers API-----------");

        RestTemplate restTemplate = new RestTemplate();
        List<LinkedHashMap<String, Object>> SupplierMap = restTemplate.getForObject(REST_SERVICE_URI+"/suppliers/", List.class);

        if(SupplierMap!=null){
            for(LinkedHashMap<String, Object> map : SupplierMap){
                System.out.println("Supplier_ID : id="+map.get("id")+", name="+map.get("suppname")+", price="+map.get("SuppID"));;
            }
        }else{
            System.out.println("No Supplier exist----------");
        }
    }

    /* GET */
    private static void getSupplier(){
        System.out.println("Testing getSupplier API----------");
        RestTemplate restTemplate = new RestTemplate();
        Supplier supplier = restTemplate.getForObject(REST_SERVICE_URI+"/supplier/1", Supplier.class);
        System.out.println(supplier);
    }

    /* POST */
    private static void createSupplier() {
        System.out.println("Testing create Supplier API----------");
        RestTemplate restTemplate = new RestTemplate();
        Supplier supplier = new Supplier.Builder(32).SuppName("BMW").build();
        URI uri = restTemplate.postForLocation(REST_SERVICE_URI+"/carpart/create/", supplier, Supplier.class);
        System.out.println("Location : "+uri.toASCIIString());
    }

    /* PUT */
    private static void updateSupplier() {
        System.out.println("Testing update Supplier API----------");
        RestTemplate restTemplate = new RestTemplate();
         Supplier supplier = new Supplier.Builder(32).SuppName("BMW").build();
         restTemplate.put(REST_SERVICE_URI+"/supplier/update/1", supplier);
        System.out.println(supplier);
    }

    /* DELETE */
    private static void deleteSupplier() {
        System.out.println("Testing delete Supplier API----------");
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(REST_SERVICE_URI+"/supplier/delete/3");
    }


    /* DELETE */
    private static void deleteAllSupplier() {
        System.out.println("Testing all delete Supplier API----------");
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(REST_SERVICE_URI + "/supplier/");
    }
}
