package com.bestBuy.extractingResponseData;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class SearchJsonPathExample {

    static ValidatableResponse response;

        @BeforeClass

        public static void inIt() {
            RestAssured.baseURI = "http://localhost";
            RestAssured.port = 3030;
            response = given()
                    .when()
                    .get("/stores")
                    .then().statusCode(200);

        }
        //1.Extract the limit
    @Test

    public void test001(){
        int limit =response.extract().path("limit");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of limit is : " + limit);
        System.out.println("------------------End of Test---------------------------");

    }
    //2.Extract the total

    @Test
    public void test002(){

       // List<Integer> total = response.extract().path("data.total");
        int total =response.extract().path("total");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("List of total are : " + total);
        System.out.println("------------------End of Test---------------------------");



    }
    //3.Extract the name of 5th store
    @Test
    public void test003(){

        String  name=response.extract().path("data[4].name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The Store name is: "+name);
        System.out.println("------------------End of Test---------------------------");

    }
    //4. Extract the names of all the store
    @Test
    public void test004() {

        List<String> nameList = new ArrayList<>();
        nameList = response.extract().path("data.name");
        System.out.println("All Stores name : " + nameList);
    }

    //5)  Extract the storeId of all the store
    @Test
    public void test005(){

        List<Integer> idList=new ArrayList<>();
        idList=response.extract().path("data.id");
        System.out.println("All Store id : "+idList);
    }
    //6) Print the size of the data list
    @Test
    public void test006(){

         //int idList=response.extract().path("data.length()");
       // System.out.println(idList);

        List<Integer> idList=new ArrayList<>();
        idList=response.extract().path("data.list");
        System.out.println(idList);
        int size= idList.size();
        System.out.println("Size of the data list : "+size);

    }
    //7.Get all the value of the store where store name = St Cloud

    @Test
    public void test007(){

        List<HashMap<String, ?>> values= response.extract().path("data.findAll{it.name=='St Cloud'}");
        System.out.println("Value of the store where name is St Cloud : "+values);
    }
    //8.Get the address of the store where store name = Rochester
    @Test
    public void test008(){
        List<Integer> address= response.extract().path("data.findAll{it.name=='Rochester'}.address");
        System.out.println("Address of Rochester : "+address);

    }
    //9.Get all the services of 8th store
    @Test
    public void test009(){

            List<HashMap<String,Object>> services =response.extract().path("data[7].services");
            System.out.println("Services of 8th stores are : ");
            for (HashMap<String,Object> service:services){
                System.out.println(service);
            }
    }
   /* //10.Get storeservices of the store where service name = Windows Store
     @Test
    public void test010(){

         //HashMap<String,Object> services=new HashMap<>();
         List<Map<String,Object>> services;
         services =response.extract().path("data.services.findAll{it.name=='Windows Store'}.storeservices");
         System.out.println("Services stores are : "+services);
     }*/

}
















