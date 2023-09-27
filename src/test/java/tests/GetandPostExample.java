package tests;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

public class GetandPostExample {
    @Test
    public void testGet() {
        baseURI = "https://reqres.in/api";
        given().
                get("/users?page=2").
                then().
                statusCode(200).
                body("data[0].first_name", equalTo("Michael")).
                body("data.first_name", hasItems("George", "Rachel"));
    }

    @Test
    public void testPost() {
        Map<String, Object> map = new HashMap<String, Object>();
        //map.put("name", "Onur");
        //map.put("job", "QA");

        //System.out.println(map);

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
                post("/users").
                then().
                statusCode(201).
                log().all();
    }

}
