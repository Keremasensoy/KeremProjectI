package api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class UploadImageApi {

    static String url = "https://petstore.swagger.io";
    static String uploadImage = "/v2/pet/1/uploadImage";

    @Test(priority = 1,description = "Positive Case")
    public void petAddPositive() {

        RestAssured.baseURI = url;
        Response res =
                given()
                        .header("Accept-Encoding", "gzip,deflate,br")
                        .multiPart("file",new File("src/main/imageapi/a.png"))
                        .when()
                        .post(url + uploadImage)
                        .then()
                        .extract().response();
        assertEquals(res.statusCode(), 200);
        String res1 = res.asString();
        System.out.println("status code and response : " + res.statusCode() + res1);

    }

    @Test(priority = 1,description = "Negative case File is Empty")
    public void petAddPositive1() {

        RestAssured.baseURI = url;
        Response res =
                given()
                        .header("Accept-Encoding", "gzip,deflate,br")
//                        .multiPart("file",new File("src/main/imageapi2"))
                        .when()
                        .post(url + uploadImage)
                        .then()
                        .extract().response();
        assertEquals(res.statusCode(), 200);
        String res1 = res.asString();
        System.out.println("status code and response : " + res.statusCode() + res1);

    }
}
