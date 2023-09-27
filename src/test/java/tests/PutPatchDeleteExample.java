package tests;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class PutPatchDeleteExample {
    @Test
    public void testPut() {
        Map<String, Object> map = new HashMap<String, Object>();

        JSONObject request = new JSONObject();

        request.put("name", "Onur");
        request.put("job", "QA");

        //System.out.println(request);
        System.out.println(request.toJSONString());

        baseURI = "https://reqres.in/api";
        given().
                header("Content-Type","application/json").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).
                when().
                put("/users/2").
                then().
                statusCode(200).
                log().all();
    }

    @Test
    public void testPatch() {
        Map<String, Object> map = new HashMap<String, Object>();

        JSONObject request = new JSONObject();

        request.put("name", "Onur");
        request.put("job", "QA");

        //System.out.println(request);
        System.out.println(request.toJSONString());

        baseURI = "https://reqres.in/api";
        given().
                header("Content-Type","application/json").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).
                when().
                patch("/users/2").
                then().
                statusCode(200).
                log().all();
    }

    @Test
    public void testDelete() {
        baseURI = "https://reqres.in/api";
        given().
                when().
                delete("/users/2").
                then().
                statusCode(204).
                log().all();
    }
}
