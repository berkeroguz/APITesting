package test;

import baseURL.DummyUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import org.testng.asserts.SoftAssert;
import testData.TestDataDummy;

import static io.restassured.RestAssured.given;

public class C20_Get_TestDataKullanimi extends DummyUrl {
    /*
            http://dummy.restapiexample.com/api/v1/employee/3 url'ine bir GET request
            gonderdigimizde donen response'un status code'unun 200,
            content Type'inin application/json ve body'sinin asagidaki gibi oldugunu test edin.
            Expected Body
            {
            "status":"success",
            "data": {
                        "id": 3,
                        "employee_name":"Ashton Cox",
                        "employee_salary":86000,
                        "employee_age":66,
                        "profile_image":"
                     },
            "message": "Successfully! Record has been fetched."
            }
     */

    @Test
    public void get01(){
        // 1- Prepare url
        specDummy.pathParams("pp1","api","pp2","v1","pp3","employee","pp4","3");

        // 2- Prepare expected Data
        TestDataDummy testDataDummy = new TestDataDummy();
        JSONObject expData = new JSONObject();
        expData= testDataDummy.createdExpectedBody();

        // 3- Save the response
        Response response = given().spec(specDummy).when().get("/{pp1}/{pp2}/{pp3}/{pp4}");
        JsonPath jsonRes = response.jsonPath();
        // 4- Assertion

        /*
        Expected Body
            {
            "status":"success",
            "data": {
                        "id": 3,
                        "employee_name":"Ashton Cox",
                        "employee_salary":86000,
                        "employee_age":66,
                        "profile_image":"
                     },
            "message": "Successfully! Record has been fetched."
            }
         */
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(jsonRes.get("status"),expData.get("status"));
        softAssert.assertEquals(jsonRes.get("data.id"),expData.getJSONObject("data").get("id"));
        softAssert.assertEquals(jsonRes.get("data.employee_name"),expData.getJSONObject("data").get("employee_name"));
        softAssert.assertEquals(jsonRes.get("data.employee_salary"),expData.getJSONObject("data").get("employee_salary"));
        softAssert.assertEquals(jsonRes.get("data.employee_age"),expData.getJSONObject("data").get("employee_age"));
        softAssert.assertEquals(jsonRes.get("data.profile_image"),expData.getJSONObject("data").get("profile_image"));
        softAssert.assertEquals(jsonRes.get("message"),expData.get("message"));

        softAssert.assertAll();





    }
}
