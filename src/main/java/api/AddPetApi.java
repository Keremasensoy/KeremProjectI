package api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class AddPetApi {

    static String url = "https://petstore.swagger.io";
    static String addPath = "/v2/pet";

    @Test(priority = 1,description = "Positive Case")
    public void petAddPositive() {

        RestAssured.baseURI = url;
        Response res =
                given()
                        .header("Accept-Encoding", "gzip,deflate,br")
                        .header("Content-Type", "application/json")
                        .body("{\n" +
                                "  \"id\": 0,\n" +
                                "  \"category\": {\n" +
                                "    \"id\": 2,\n" +
                                "    \"name\": \"dog\"\n" +
                                "  },\n" +
                                "  \"name\": \"oly\",\n" +
                                "  \"photoUrls\": [\n" +
                                "    \"aaaa.jpg\"\n" +
                                "  ],\n" +
                                "  \"tags\": [\n" +
                                "    {\n" +
                                "      \"id\": 8,\n" +
                                "      \"name\": \"qwe\"\n" +
                                "    }\n" +
                                "  ],\n" +
                                "  \"status\": \"available\"\n" +
                                "}")
                        .when()
                        .post(url + addPath)
                        .then()
                        .extract().response();
        assertEquals(res.statusCode(), 200);
        String res1 = res.asString();
        System.out.println("status code and response : " + res.statusCode() + res1);

    }

    @Test(priority = 2,description = "Negative Case ID is String ")
    public void petAddNegative1(){

        RestAssured.baseURI = url;
        Response res =
                given()
                        .header("Accept-Encoding", "gzip,deflate,br")
                        .header("Content-Type", "application/json")
                        .body("{\n" +
                                "  \"id\":+ \""+ "aaa\"+ \"+\"+,\n" +
                                "  \"category\": {\n" +
                                "    \"id\": 2,\n" +
                                "    \"name\": \"dog\"\n" +
                                "  },\n" +
                                "  \"name\": \"oly\",\n" +
                                "  \"photoUrls\": [\n" +
                                "    \"aaaa.jpg\"\n" +
                                "  ],\n" +
                                "  \"tags\": [\n" +
                                "    {\n" +
                                "      \"id\": 8,\n" +
                                "      \"name\": \"qwe\"\n" +
                                "    }\n" +
                                "  ],\n" +
                                "  \"status\": \"available\"\n" +
                                "}")
                        .when()
                        .post(url + addPath)
                        .then()
                        .extract().response();

        assertEquals(res.statusCode(), 400);
        String res1 = res.asString();
        System.out.println("status code and response : " + res.statusCode() + res1);

    }

    @Test(priority = 3,description = "Negative Case Category ID is String")
    public void petAddNegative2(){

        RestAssured.baseURI = url;
        Response res =
                given()
                        .header("Accept-Encoding", "gzip,deflate,br")
                        .header("Content-Type", "application/json")
                        .body("{\n" +
                                "  \"id\": 0,\n" +
                                "  \"category\": {\n" +
                                "    \"id\": + \""+ "aaa\"+ \"+,\n" +
                                "    \"name\": \"dog\"\n" +
                                "  },\n" +
                                "  \"name\": \"oly\",\n" +
                                "  \"photoUrls\": [\n" +
                                "    \"aaaa.jpg\"\n" +
                                "  ],\n" +
                                "  \"tags\": [\n" +
                                "    {\n" +
                                "      \"id\": 8,\n" +
                                "      \"name\": \"qwe\"\n" +
                                "    }\n" +
                                "  ],\n" +
                                "  \"status\": \"available\"\n" +
                                "}")
                        .when()
                        .post(url + addPath)
                        .then()
                        .extract().response();

        assertEquals(res.statusCode(), 500);

        String res1 = res.asString();
        System.out.println("status code and response : " + res.statusCode() + res1);

    }


    @Test(priority = 4,description = "Negative Case Category ID is  Empty")
    public void petAddNegative3(){

        RestAssured.baseURI = url;
        Response res =
                given()
                        .header("Accept-Encoding", "gzip,deflate,br")
                        .header("Content-Type", "application/json")
                        .body("{\n" +
                                "  \"id\": 1,\n" +
                                "  \"category\": {\n" +
                                "    \"id\": ,\n" +
                                "    \"name\": \"dog\"\n" +
                                "  },\n" +
                                "  \"name\": \"oly\",\n" +
                                "  \"photoUrls\": [\n" +
                                "    \"aaaa.jpg\"\n" +
                                "  ],\n" +
                                "  \"tags\": [\n" +
                                "    {\n" +
                                "      \"id\": 8,\n" +
                                "      \"name\": \"qwe\"\n" +
                                "    }\n" +
                                "  ],\n" +
                                "  \"status\": \"available\"\n" +
                                "}")
                        .when()
                        .post(url + addPath)
                        .then()
                        .extract().response();

        assertEquals(res.statusCode(), 500);

        String res1 = res.asString();
        System.out.println("status code and response : " + res.statusCode() + res1);

    }

    @Test(priority = 5,description = "Negative Case Tag ID is String")
    public void petAddNegative4(){

        RestAssured.baseURI = url;
        Response res =
                given()
                        .header("Accept-Encoding", "gzip,deflate,br")
                        .header("Content-Type", "application/json")
                        .body("{\n" +
                                "  \"id\": 1,\n" +
                                "  \"category\": {\n" +
                                "    \"id\": 1,\n" +
                                "    \"name\": \"dog\"\n" +
                                "  },\n" +
                                "  \"name\": \"oly\",\n" +
                                "  \"photoUrls\": [\n" +
                                "    \"aaaa.jpg\"\n" +
                                "  ],\n" +
                                "  \"tags\": [\n" +
                                "    {\n" +
                                "      \"id\": + \""+ "aaa\"+ \"+,\n" +
                                "      \"name\": \"qwe\"\n" +
                                "    }\n" +
                                "  ],\n" +
                                "  \"status\": \"available\"\n" +
                                "}")
                        .when()
                        .post(url + addPath)
                        .then()
                        .extract().response();

        assertEquals(res.statusCode(), 500);

        String res1 = res.asString();
        System.out.println("status code and response : " + res.statusCode() + res1);

    }

    @Test(priority = 6,description = "Negative  Case Tag ID is Empty")
    public void petAddNegative5(){

        RestAssured.baseURI = url;
        Response res =
                given()
                        .header("Accept-Encoding", "gzip,deflate,br")
                        .header("Content-Type", "application/json")
                        .body("{\n" +
                                "  \"id\":1 ,\n" +
                                "  \"category\": {\n" +
                                "    \"id\": 2,\n" +
                                "    \"name\": \"dog\"\n" +
                                "  },\n" +
                                "  \"name\": \"oly\",\n" +
                                "  \"photoUrls\": [\n" +
                                "    \"aaaa.jpg\"\n" +
                                "  ],\n" +
                                "  \"tags\": [\n" +
                                "    {\n" +
                                "      \"id\": ,\n" +
                                "      \"name\": \"qwe\"\n" +
                                "    }\n" +
                                "  ],\n" +
                                "  \"status\": \"available\"\n" +
                                "}")
                        .when()
                        .post(url + addPath)
                        .then()
                        .extract().response();
        assertEquals(res.statusCode(), 500);

        String res1 = res.asString();
        System.out.println("status code and response : " + res.statusCode() + res1);

    }

}
