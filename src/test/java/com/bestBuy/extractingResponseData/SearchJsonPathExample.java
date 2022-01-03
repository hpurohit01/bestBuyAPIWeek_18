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
    //10.Get storeservices of the store where service name = Windows Store
     @Test
    public void test010(){

// notgiving any data
// List<HashMap<String, Object>> services = response.extract().path("data.services[7].storeservices");
         List<List<HashMap<String, Object>>> services = response.extract().path("data.services.findAll{it.name=='Windows Store'}");
         System.out.println("Services stores are : "+services);

     }

  /* @Test
   public void test010(){

       List<Object> storeservices=new ArrayList<>();
       storeservices =response.extract().path("data.findAll{it.services.name=='Windows Store'}.storeservices");
       System.out.println("Services stores are : "+storeservices);

   }*/

    //11) Get all the storeId of all the store
    @Test
    public void test011(){

        List<Integer> idList=new ArrayList<>();
        idList=response.extract().path("data.services.storeservices.storeId");
        System.out.println("All Store id : "+idList);

    }

    //12) Get id of all the store
    @Test
    public void test012(){

        List<Integer> idList=new ArrayList<>();
        idList=response.extract().path("data.id");
        System.out.println("All Store id : "+idList);
    }

    //13) Find the store names Where state = ND
    @Test
    public void test013(){

        List<Integer> stores= response.extract().path("data.findAll{it.state=='ND'}.name");
        System.out.println("Store names : "+stores);
    }

    //14.Find the Total number of services for the store where store name = Rochester
    @Test
    public void test014(){
        List<HashMap<String,Object>> services =response.extract().path("data.findAll{it.name=='Rochester'}.services");
        int size=services.size();
        System.out.println(services);
        System.out.println("Total no of Services for Rochester are : "+size);

    }

    //15) Find the createdAt for all services whose name = “Windows Store”
    @Test
    public void test015(){

        List<String> created =response.extract().path("data.findAll{it.services.name=='Windows Store'}.services.created");
        System.out.println("Created for Windows Store : "+created);
    }

    //16.Find the name of all services Where store name = “Fargo”
    @Test
    public void test016(){
        List<String> servicesName =response.extract().path("data.findAll{it.name=='Fargo'}.services.name");
        System.out.println("Services name are : "+servicesName);

    }

    //17.Find the zip of all the store
    @Test
    public void test017(){

        List<String> zipList=response.extract().path("data.zip");
        System.out.println("Zip of all stores are : "+zipList);
    }

    //18.Find the zip of store name = Roseville
    @Test
    public void test018(){

        List<String> zip=response.extract().path("data.findAll{it.name=='Roseville'}.zip");
        System.out.println("Zip of Roseville : "+zip);
    }

  /*  //19.Find the storeservices details of the service name = Magnolia Home Theater
    @Test
    public void test019(){

        HashMap<String,Object> created =response.extract().path("data.findAll{it.services.name=='Magnolia Home Theater'}.storeservices");
        System.out.println("Created for Magnolia Home Theater : "+created);

    }*/

    //20.Find the lat of all the stores
    @Test
    public void test020(){

        List<Double> latList=response.extract().path("data.lat");
        System.out.println("Lat of all the stores : "+latList);
    }

}
















