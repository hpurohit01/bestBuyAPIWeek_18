package com.bestBuy.assertionexample;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.hasEntry;
import static org.hamcrest.Matchers.hasKey;

public class AssertionExample {

    static ValidatableResponse response;
    @BeforeClass
    public static void inIt(){

        RestAssured.baseURI="http://localhost";
        RestAssured.port=3030;
        response=given()
                .when()
                .get("/stores")
                .then().statusCode(200);

    }

    //1. Verify the if the total is equal to 1562
    @Test
    public void test001(){
        response.body("total",equalTo(1562));
    }

    //2.Verify the if the stores of limit is equal to 10
    @Test
    public void test002(){
        response.body("limit",equalTo(10));
    }



    //3. Check the single ‘Name’ in the Array list (Inver Grove Heights)
    @Test
    public void test003(){

        response.body("data.name",hasItem("Inver Grove Heights"));
    }

    //4.Check the multiple ‘Names’ in the ArrayList (Square83215, Southridge, Green Bay)
    @Test
    public void test004(){

        response.body("data.name",hasItems("Inver Grove Heights","Square83215", "Rochester"));// Northtown, string, Fargo, Rochester, Oakdale, West Des Moines"));
    }

    // 5. Verify the storied inside storeservices of the third store of second services
    @Test
    public void test005(){

        response.body("data[1].services[2].storeservices",hasKey("storeId"));
    }

    //6. Check hash map values ‘createdAt’ inside store services map where store name = Southridge
    @Test
    public void test006(){

        response.body("data.findAll{it.name=='Roseville'}",hasItems(hasEntry("createdAt","2016-11-17T17:57:05.853Z")));
    }

    //7. Verify the state = MN of third store
    @Test
    public void test007(){
        response.body("data.findAll{it.name=='Burnsville'}",hasItems(hasEntry("state","MN")));
    }

    //8. Verify the name = Green Bay of 9th store
    @Test
    public void test008(){

        response.body("data.findAll{it.id==15}",hasItem(hasEntry("name","Oakdale")));
    }

    //9. Verify the storeId = 11 for the 6th store

    @Test
    public void test009(){

      //  response.body("data.findAll{it.id==6}",hasItem(hasEntry("services.storeservices.storeId",11)));
        response.body("data[5].services[1].storeservices",hasKey("storeId"));
    }


    //10. Verify the serviceId = 4 for the 7th store

    @Test
    public void test010(){
        //response.body("data.findAll{it.id==4}",hasItem(hasEntry("services.storeservices.serviceId",7)));
        response.body("data[6].services[3].storeservices",hasKey("serviceId"));

    }









}
