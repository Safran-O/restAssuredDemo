package tests;

import io.restassured.http.ContentType;
import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class SoapXMLRequest {
    @Test
    public void validateSoapXML() throws IOException {

        File file = new File("./target/classes/Add.xml");

        if (file.exists())
            System.out.println(" >> File exists");

        FileInputStream fileInputStream = new FileInputStream(file);
        String requestBody;
        requestBody = IOUtils.toString(fileInputStream,"UTF-8");

        baseURI = "https://ecs.syr.edu";
        given().
                contentType("test/xml").
                accept(ContentType.XML).
                body(requestBody).
                when().
                post("/faculty/fawcett/Handouts/cse775/code/calcWebService/Calc.asmx").
                then().
                statusCode(200).log().all().
                and().
                body("//:AddResult",equalTo("5"));
    }
}
