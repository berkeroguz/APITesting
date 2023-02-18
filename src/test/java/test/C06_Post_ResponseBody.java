package test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class C06_Post_ResponseBody {

    @Test
    public void post01(){
        // 1- Create url and body
        String url = "https://jsonplaceholder.typicode.com/posts";

        JSONObject reqBody = new JSONObject();
        reqBody.put("title","API");
        reqBody.put("body","API ogrenmek ne guzel");
        reqBody.put("userId",10);

        System.out.println("Prepeared Body = " + reqBody);

        // 2- Expected Data

        // 3- Save response
         Response response = given().
                                    contentType(ContentType.JSON).
                            when().
                                    body(reqBody.toString()).
                                    post(url);

         response.prettyPrint();

         // 4- Assertion

        response.then().assertThat()
                .statusCode(201)
                .contentType(ContentType.JSON)
                .body("title", equalTo("API"))
                .body("userId", lessThan(100));
    }

    @Test
    public void post02(){
        // 1- Create url and body
        String url = "https://jsonplaceholder.typicode.com/posts";

        JSONObject reqBody = new JSONObject();
        reqBody.put("title","API");
        reqBody.put("body","API ogrenmek ne guzel");
        reqBody.put("userId",10);


        // 2- Expected Data

        // 3- Save response
        Response response = given().
                contentType(ContentType.JSON).
                when().
                body(reqBody.toString()).
                post(url);


        // 4- Assertion

        response.then().assertThat()
                .statusCode(201)
                .contentType(ContentType.JSON).
                body("title",equalTo("API"),
                        "userId",lessThan(100),
                        "body",containsString("API"));
    }
}
