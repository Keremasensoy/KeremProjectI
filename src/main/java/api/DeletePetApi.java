package api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class DeletePetApi {
    static String url = "https://petstore.swagger.io";
    static String deletepath = "/v2/pet";

    @Test(priority = 1,description = "Positive Case")
    public void deletePetApi(){
        RestAssured.baseURI = url;
        Response res =
                given()
                        .header("Accept-Encoding", "gzip,deflate,br")
                        .header("Content-Type", "application/json")
                        .when()
                        .delete(url + deletepath+"/1")
                        .then()
                        .extract().response();
        assertEquals(res.statusCode(), 200);
        String res1 = res.asString();
        System.out.println("status code and response : " + res.statusCode() + res1);

    }

    }




