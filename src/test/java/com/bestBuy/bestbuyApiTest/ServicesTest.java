package com.bestBuy.bestbuyApiTest;

import com.bestBuy.model.ServicesPojo;
import com.bestBuy.testbase.TestBaseServices;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class ServicesTest extends TestBaseServices {
    Response response;

    //Get Request
    @Test
    public void getAllServicesData(){
        response=given()
                .when()
                .get();
        response.then().statusCode(200);
        response.prettyPrint();
    }
    @Test
    public void getSingleProductsData(){
        response=given()
                .pathParam("id",9)
                .when()
                .get("/{id}");
        response.then().statusCode(200);
        response.prettyPrint();

    }
    @Test
    public void getProductsDataWithParameters() {

        HashMap<String,Integer> qParam = new HashMap<>();
        qParam.put("$limit",2);
        qParam.put("$skip",3);
        response = given()
                .queryParams(qParam)
                .when()
                .get();
        response.then().statusCode(200);
        response.prettyPrint();

    }
    @Test
    public void getServicesDataWithParameter(){

        HashMap<String,Integer> qParam=new HashMap<>();
        qParam.put("$limit",3);
        qParam.put("$skip",2);
        response=given()
                .queryParams(qParam)
                .when()
                .get();
        response.then().statusCode(200);
        response.prettyPrint();

    }

    //Post Request
    @Test
    public void createServiceData(){

        ServicesPojo servicesPojo=new ServicesPojo();
        servicesPojo.setName("Best Mobile");

        response=given()
                .header("Content-Type","application/json")
                .body(servicesPojo)
                .when()
                .post();
        response.then().statusCode(201);
        response.prettyPrint();

    }

    //Put request
    @Test
    public void updateServicesDataWithPut(){

        ServicesPojo servicesPojo=new ServicesPojo();
        servicesPojo.setName("Web service");

        response=given()
                .header("Content-Type","application/json")
                .pathParam("id",15)
                .body(servicesPojo)
                .when()
                .put("/{id}");
        response.then().statusCode(200);
        response.prettyPrint();

    }

    //Patch Request
    @Test
    public void updateServicesWithPatch(){

        ServicesPojo servicesPojo=new ServicesPojo();
        servicesPojo.setName("Api service");

        response=given()
                .header("Content-Type","application/json")
                .pathParam("id",15)
                .body(servicesPojo)
                .when()
                .patch("/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }

    //Delete Request
    @Test
    public void deleteServicesData(){

        response=given()
                .pathParam("id",20)
                .when()
                .delete("/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }

}
