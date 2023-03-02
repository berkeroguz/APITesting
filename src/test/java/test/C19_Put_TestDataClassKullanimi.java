package test;

import baseURL.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import org.testng.asserts.SoftAssert;
import testData.TestDataJsonPlaceHolder;

import static io.restassured.RestAssured.given;

public class C19_Put_TestDataClassKullanimi extends JsonPlaceHolderBaseUrl {
    /*
        https://jsonplaceholder.typicode.com/posts/70 url'ine asagidaki body'e sahip bir PUT
        request yolladigimizda donen response'in
        status kodunun 200, content type'inin "application/json; charset=utf-8",
        Connection header degerinin "keep-alive"
        ve response body'sinin asagida verilen ile ayni oldugunu test ediniz

        Request Body
        {
        "title":"Ali",
        "body":"Merhaba",
        "userId":10,
        "id":70
        }

        Expected Data
        {
        "title":"Ali",
        "body":"Merhaba",
        "userId":10,
        "id":70
        }

     */
    @Test
    public void put01(){
        // 1- Prepare url and body
        specJsonPlace.pathParams("pp1","posts","pp2",70);
        TestDataJsonPlaceHolder testDataJsonPlaceHolder = new TestDataJsonPlaceHolder();
        JSONObject reqBody = testDataJsonPlaceHolder.createRequestBody();

        // 2- Prepare expected Data
        JSONObject expBody = testDataJsonPlaceHolder.createRequestBody();

        // 3- Save the response
        Response response = given().spec(specJsonPlace).contentType(ContentType.JSON).
                body(reqBody.toString())
                .when().put("/{pp1}/{pp2}");

        response.prettyPrint();

        // 4- Asertion
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(response.getStatusCode(),testDataJsonPlaceHolder.basariliStatusCode);
        softAssert.assertEquals(response.contentType(),testDataJsonPlaceHolder.contentType);
        softAssert.assertEquals(response.getHeader("Connection"),testDataJsonPlaceHolder.connectionHeaderDegeri);

        JsonPath resJP = response.jsonPath();

        softAssert.assertEquals(resJP.get("title"),expBody.get("title"));
        softAssert.assertEquals(resJP.get("body"),expBody.get("body"));
        softAssert.assertEquals(resJP.get("userId"),expBody.get("userId"));
        softAssert.assertEquals(resJP.get("id"),expBody.get("id"));
        softAssert.assertAll();

    }
}
