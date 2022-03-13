package api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class UpdatePet {

    static String url = "https://petstore.swagger.io";
    static String updatepett = "/v2/pet";

    @Test(priority = 1,description = "Postive Case")
    public void petUpdatePositive() {

        RestAssured.baseURI = url;
        Response res =
                given()
                        .header("Accept-Encoding", "gzip,deflate,br")
                        .header("Content-Type", "application/json")
                        .body("{\n" +
                                "  \"id\": 1,\n" +
                                "  \"category\": {\n" +
                                "    \"id\": 999,\n" +
                                "    \"name\": \"dog2\"\n" +
                                "  },\n" +
                                "  \"name\": \"oldsfsdy\",\n" +
                                "  \"photoUrls\": [\n" +
                                "    \"dfasdfasd.jpg\"\n" +
                                "  ],\n" +
                                "  \"tags\": [\n" +
                                "    {\n" +
                                "      \"id\": 9,\n" +
                                "      \"name\": \"qwe\"\n" +
                                "    }\n" +
                                "  ],\n" +
                                "  \"status\": \"pending\"\n" +
                                "}")
                        .when()
                        .put(url + updatepett)
                        .then()
                        .extract().response();
        assertEquals(res.statusCode(), 200);
        String res1 = res.asString();
        System.out.println("status code and response : " + res.statusCode() + res1);

    }

}

