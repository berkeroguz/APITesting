package test;

import baseURL.JsonPlaceHolderBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class C13_Get_SoftAssertIleExpectedDataTesti {
    @Test
    public void test01(){

        // 1- Create url
        String url = "https://jsonplaceholder.typicode.com/posts/22";

        // 2- Expected Data Prepare
        JSONObject expBody = new JSONObject();
        expBody.put("userId",3);
        expBody.put("id",22);
        expBody.put("title","dolor sint quo a velit explicabo quia nam");
        expBody.put("body","eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita ear" +
                "um mollitia molestiae aut atque rem suscipit\nnam impedit esse");

        System.out.println(expBody);

        // 3- Save the response

        Response response = given().when().get(url);

        // In order to find releated field in body, we need convert response to jsonpath

        JsonPath resJsonPath = response.jsonPath();

        // 4- Assertion
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(resJsonPath.get("userId"),expBody.get("userId"));
        softAssert.assertEquals(resJsonPath.get("id"),expBody.get("id"));
        softAssert.assertEquals(resJsonPath.get("title"),expBody.get("title"));
        softAssert.assertEquals(resJsonPath.get("body"),expBody.get("body"));
        softAssert.assertAll();

    }
}
