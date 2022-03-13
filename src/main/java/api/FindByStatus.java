package api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class FindByStatus {

    static String url = "https://petstore.swagger.io";
    static String findByStatus = "/v2/pet/findByStatus";

    @Test(priority = 1,description = "Positive Case available")
    public void petFindStatusPositive1() {

        RestAssured.baseURI = url;
        Response res =
                given()
                        .header("Accept-Encoding", "gzip,deflate,br")
                        .header("Content-Type", "application/json")
                        .queryParam("status","available")
                        .when()
                        .get(url + findByStatus)
                        .then()
                        .extract().response();
        assertEquals(res.statusCode(), 200);
        String res1 = res.asString();
        System.out.println("status code and response : " + res.statusCode() + res1);

    }

    @Test(priority = 1,description = "Positive Case Sold")
    public void petFindStatusPositive2() {

        RestAssured.baseURI = url;
        Response res =
                given()
                        .header("Accept-Encoding", "gzip,deflate,br")
                        .header("Content-Type", "application/json")
                        .queryParam("status","sold")
                        .get(url + findByStatus)
                        .then()
                        .extract().response();
        assertEquals(res.statusCode(), 200);
        String res1 = res.asString();
        System.out.println("status code and response : " + res.statusCode() + res1);

    }

    @Test(priority = 1,description = "Positive Case Pending")
    public void petFindStatusPositive3() {

        RestAssured.baseURI = url;
        Response res =
                given()
                        .header("Accept-Encoding", "gzip,deflate,br")
                        .header("Content-Type", "application/json")
                        .queryParam("status","pending")
                        .get(url + findByStatus)
                        .then()
                        .extract().response();
        assertEquals(res.statusCode(), 200);
        String res1 = res.asString();
        System.out.println("status code and response : " + res.statusCode() + res1);

    }

}
