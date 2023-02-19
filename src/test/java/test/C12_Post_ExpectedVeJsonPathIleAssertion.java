package test;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C12_Post_ExpectedVeJsonPathIleAssertion {
    /*
    https://restful-booker.herokuapp.com/booking url’ine
    asagidaki body'ye sahip bir POST request gonderdigimizde
    donen response’un id disinda asagidaki gibi oldugunu test edin.
    	                Request body
    	           {
    	                "firstname" : "Ahmet",
    	                "lastname" : “Bulut",
    	                "totalprice" : 500,
    	                "depositpaid" : false,
    	                "bookingdates" : {
    	                         "checkin" : "2021-06-01",
    	                         "checkout" : "2021-06-10"
    	                                  },
    	                "additionalneeds" : "wi-fi"
    	            }
    	            	Response Body
    	           {
                    "bookingid":24,
                    "booking":{
                        "firstname":"Ahmet",
                        "lastname":"Bulut",
                        "totalprice":500,
                        "depositpaid":false,
                        "bookingdates":{
                            "checkin":"2021-06-01",
                            "checkout":"2021-06-10"
                                        }
                        ,
                        "additionalneeds":"wi-fi"
                             }
                    }
         */
    @Test
    public void test01(){
        String url = "https://restful-booker.herokuapp.com/booking";

        /*
        {
    	                "firstname" : "Ahmet",
    	                "lastname" : “Bulut",
    	                "totalprice" : 500,
    	                "depositpaid" : false,
    	                "bookingdates" : {
    	                         "checkin" : "2021-06-01",
    	                         "checkout" : "2021-06-10"
    	                                  },
    	                "additionalneeds" : "wi-fi"
    	            }
         */
        JSONObject innerDates = new JSONObject();
        innerDates.put("checkin","2021-06-01");
        innerDates.put("checkout","2021-06-10");

        JSONObject reqBody = new JSONObject();
        reqBody.put("firstname","Ahmet");
        reqBody.put("lastname","Bulut");
        reqBody.put("totalprice","500");
        reqBody.put("depositpaid",true);
        reqBody.put("bookingdates",innerDates);
        reqBody.put("additionalneeds","wi-fi");

        // 2- Expected Data Created
        JSONObject expBody = new JSONObject();
        expBody.put("bookingid",24);
        expBody.put("booking",reqBody);

        System.out.println(reqBody);
        // 3- Save the Response

        Response response = given().contentType(ContentType.JSON).when()
                .body(reqBody.toString())
                .post(url);
        response.prettyPrint();
        JsonPath responseJsonPath = response.jsonPath();
        // 4- Assertion

        /*
        	Response Body
    	           {
                    "bookingid":24,
                    "booking":{
                        "firstname":"Ahmet",
                        "lastname":"Bulut",
                        "totalprice":500,
                        "depositpaid":false,
                        "bookingdates":{
                            "checkin":"2021-06-01",
                            "checkout":"2021-06-10"
                                        }
                        ,
                        "additionalneeds":"wi-fi"
                             }
                    }
         */
        Assert.assertEquals(expBody.getJSONObject("booking").get("firstname"),responseJsonPath.getString("booking.firstname"));
        Assert.assertEquals(expBody.getJSONObject("booking").get("lastname"),responseJsonPath.getString("booking.lastname"));
        Assert.assertEquals(expBody.getJSONObject("booking").getInt("totalprice"),responseJsonPath.getInt("booking.totalprice"));
        Assert.assertEquals(expBody.getJSONObject("booking").get("depositpaid"),responseJsonPath.get("booking.depositpaid"));
        Assert.assertEquals(expBody.getJSONObject("booking").
                getJSONObject("bookingdates").get("checkin"),
                responseJsonPath.get("booking.bookingdates.checkin"));
        Assert.assertEquals(expBody.getJSONObject("booking").
                        getJSONObject("bookingdates").get("checkout"),
                responseJsonPath.get("booking.bookingdates.checkout"));
        Assert.assertEquals(expBody.getJSONObject("booking").get("additionalneeds"),responseJsonPath.get("booking.additionalneeds"));





    }
}
