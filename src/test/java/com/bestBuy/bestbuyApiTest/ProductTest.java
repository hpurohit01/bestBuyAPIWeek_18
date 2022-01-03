package com.bestBuy.bestbuyApiTest;

import com.bestBuy.model.ProductsPojo;
import com.bestBuy.testbase.TestBaseProducts;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class ProductTest extends TestBaseProducts {


    Response response;

    //Get Request
    @Test
    public void getAllProductsData() {

        response = given()
                .when()
                .get();
        response.then().statusCode(200);
        response.prettyPrint();

    }

    @Test
    public void getSingleProductsData() {

        response = given()
                .pathParam("id",346575)
                .when()
                .get("/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Test
    public void getProductsDataWithParameters() {

        HashMap<String, Double> qParam = new HashMap<>();
        qParam.put("price", 7.49);
        qParam.put("limit", 10.0);
        response = given()
                .queryParams(qParam)
                .when()
                .get();
        response.then().statusCode(200);
        response.prettyPrint();
    }

    //Post Request
    @Test
    public void createNewProductsRecord(){

        ProductsPojo productsPojo=new ProductsPojo();
        productsPojo.setName("biscuits");
        productsPojo.setType("Cookies");
        productsPojo.setPrice(5.49);
        productsPojo.setUpc("041333415017");
        productsPojo.setShipping(1);
        productsPojo.setDescription("Chocolaty and Testy ; 4-pack");
        productsPojo.setManufacturer("CadBury");
        productsPojo.setModel("MilkTray");
        productsPojo.setUrl("http://www.bestbuy.com/site/macvities biscuit-4-pack/43900.p?id=1059384074145&skuId=43900&cmp=RMXCC");
        productsPojo.setImage("http://img.bbystatic.com/BestBuy_US/images/products/4390/43900_sa.jpg");

        response =given()
                .header("Content-Type","application/json")
                .body(productsPojo)
                .when()
                .post();
        response.then().statusCode(201);
        response.prettyPrint();
    }

    //Put Request
    @Test
    public void updateProductDataRecordWithPut(){


        ProductsPojo productsPojo=new ProductsPojo();
        productsPojo.setName("Choco Lava biscuits");
        productsPojo.setType("Cookies");
        productsPojo.setPrice(4.99);
        productsPojo.setUpc("041333825014");
        productsPojo.setShipping(1);
        productsPojo.setDescription("Chocolaty and Testy ; 6-pack");
        productsPojo.setManufacturer("CadBury");
        productsPojo.setModel("MN1500B8Z ");
        productsPojo.setUrl("http://www.bestbuy.com/site/macvities biscuit-4-pack/43900.p?id=1059384074145&skuId=43900&cmp=RMXCC");
        productsPojo.setImage("http://img.bbystatic.com/BestBuy_US/images/products/4390/43900_sa.jpg");
        response =given()
                .pathParam("id",127687)
                .header("Content-Type","application/json")
                .body(productsPojo)
                .when()
                .put("/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }

    //Patch Request
    @Test
    public void updateProductsDataWithPatch(){

        ProductsPojo productsPojo=new ProductsPojo();
        productsPojo.setType("Cream");
        productsPojo.setPrice(11.99);

        response =given()
                .pathParam("id",9999681)
                .header("Content-Type","application/json")
                .body(productsPojo)
                .when()
                .patch("/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }

    //Delete Request
    @Test
    public void deleteProductsRecord(){
        response =given()
                .pathParam("id",185267)
                .header("Content-Type","application/json")
                .when()
                .delete("/{id}");
        response.then().statusCode(200);
        response.prettyPrint();

    }
}
