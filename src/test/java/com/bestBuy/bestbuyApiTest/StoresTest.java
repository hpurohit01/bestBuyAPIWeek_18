package com.bestBuy.bestbuyApiTest;

import com.bestBuy.model.StoresPojo;
import com.bestBuy.testbase.TestBaseStores;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class StoresTest extends TestBaseStores {

    Response response;
    //Get Request
    @Test
    public void getAllStoresData(){

        response=given()
                .when()
                .get();
        response.then().statusCode(200);
        response.prettyPrint();

    }

    @Test
    public void getSingleStoresData(){

        response=given()
                .pathParam("id",11)
                .when()
                .get("/{id}");
        response.then().statusCode(200);
        response.prettyPrint();

    }

   @Test
    public void getStoresDataWithParameter(){

        response=given()
                .queryParam("city","Saint Cloud")
                .when()
                .get();
        response.then().statusCode(200);
        response.prettyPrint();
    }

    //Post Request
    @Test
    public void createStoresData(){

        StoresPojo storesPojo=new StoresPojo();
        storesPojo.setName("Walmart");
        storesPojo.setType("Grocery");
        storesPojo.setAddress("798 Reeds");
        storesPojo.setAddress2("999");
        storesPojo.setCity("Hopkins");
        storesPojo.setState("NM");
        storesPojo.setZip("55305");
        storesPojo.setLat(44.969658);
        storesPojo.setLng(-93.449539);
        storesPojo.setHours("Mon: 10-9; Tue: 10-9; Wed: 10-9; Thurs: 10-9; Fri: 10-9; Sat: 10-9; Sun: 10-5");

        response=given()
                .header("Content-Type","application/json")
                .body(storesPojo)
                .when()
                .post();
        response.then().statusCode(201);
        response.prettyPrint();
    }

    //Put Request
    @Test

    public void updateStoresRecord(){


        StoresPojo storesPojo=new StoresPojo();
        storesPojo.setName("Asda");
        storesPojo.setType("Grocery");
        storesPojo.setAddress("12341 St Albans");
        storesPojo.setAddress2("778");
        storesPojo.setCity("Manchester");
        storesPojo.setState("AB");
        storesPojo.setZip("785632");
        storesPojo.setLat(44.9674);
        storesPojo.setLng(-94.8712);
        storesPojo.setHours("Mon: 10-9; Tue: 10-9; Wed: 10-9; Thurs: 10-9; Fri: 10-9; Sat: 10-9; Sun: 10-5");

        response=given()
                .pathParam("id",56)
                .header("Content-Type","application/json")
                .body(storesPojo)
                .when()
                .put("/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }

    //Patch Request
    @Test

    public void updateStoreRecordWithPatch(){

        StoresPojo storesPojo=new StoresPojo();
        storesPojo.setName("TESCO");

        response=given()
                .pathParam("id","56")
                .header("Content-Type","application/json")
                .body(storesPojo)
                .when()
                .patch("/{id}");
        response.then().statusCode(200);
        response.prettyPrint();

    }

    //Delete Request
    @Test

    public void deleteStoresData(){

        response=given()
                .pathParam("id",8925)
                .when()
                .delete("/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }
}
