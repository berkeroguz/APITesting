package test;

import baseURL.HerokuappBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C17_BaseUrlHerokuappQueryParam extends HerokuappBaseUrl {

    // Class icinde 3 test metodu olusturun ve asagıdaki testleri yapin
    /*
        1- https://restful-booker.herokuapp.com/booking endpointine bir GET
        request gonderdigimizde donen response'un status code'unun 200 oldugunu
        ve Response'ta 33071 id'ye sahip bir booking oldugunu test edin
    */
    /*
        2- https://restful-booker.herokuapp.com/booking endpointine gerekli
        Query parametrelerini yazarak "firstname" degeri "Eric" olan rezervasyon
        oldugunu test edecek bir GET request gonderdigimizde, donen response'un
        status code'unun 200 oldugunu ve "Eric" ismine sahip en az bir booking oldugunu test edin
    */
    /*
        3- https://restful-booker.herokuapp.com/booking endpointine gerekli Query
        parametrelerini yazarak "firstname" degeri "Jim" ve "lastname" degeri
        "Jackson" olan rezervasyon oldugunu test edecek bir GET request gonderdigimizde,
        donen response'un status code'unun 200 oldugunu ve "Jim Jackson" ismine sahip
        en az bir booking oldugunu test edin.

 */
    @Test
    public void get01(){
       /* 1- https://restful-booker.herokuapp.com/booking endpointine bir GET
        request gonderdigimizde donen response'un status code'unun 200 oldugunu
        ve Response'ta 33071 id'ye sahip bir booking oldugunu test edin

        */

        // 1- Url prepare
        specHerokuApp.pathParam("pp1","booking");

        // 2- Expected Data prepare

        // 3- Save th response

        Response response = given().spec(specHerokuApp)
                            .when()
                .                   get("/{pp1}");
        response.prettyPrint();

        // 4- Assertion
        response.then().assertThat()
                .statusCode(200)
                .body("bookingid", Matchers.hasItem(2789));
        /*
        TAnre rTasmeta Kalemi sdglkjasdfşlk
         */


    }

    @Test
    public void get02(){
          /*
        2- https://restful-booker.herokuapp.com/booking endpointine gerekli
        Query parametrelerini yazarak "firstname" degeri "Sally" olan rezervasyon
        oldugunu test edecek bir GET request gonderdigimizde, donen response'un
        status code'unun 200 oldugunu ve "Sally" ismine sahip en az bir booking oldugunu test edin
    */
        // 1- Prepare url
        specHerokuApp.pathParam("pp1","booking").queryParam("firstname","Sally");

        // 2- Expected Data prepare

        // 3- Save the response
        Response response = given().spec(specHerokuApp).when().get("/{pp1}");

        response.prettyPrint();
        // 4- Assertion
        response.then().assertThat()
                .statusCode(200)
                .body("bookingid",Matchers.hasSize(1));

    }

    @Test
    public void get03(){

        /*
        3- https://restful-booker.herokuapp.com/booking endpointine gerekli Query
        parametrelerini yazarak "firstname" degeri "Sally" ve "lastname" degeri
        "Smith" olan rezervasyon oldugunu test edecek bir GET request gonderdigimizde,
        donen response'un status code'unun 200 oldugunu ve "Jim Jackson" ismine sahip
        en az bir booking oldugunu test edin.
         */
        // 1- prepare url
        specHerokuApp.pathParam("pp1","booking").queryParams("firstname","Sally","lastname","Smith");

        // Expected data

        // 3- Save the response
        Response response = given().spec(specHerokuApp).when().get("/{pp1}");
        response.prettyPrint();

        // Assertion
        response.then().assertThat()
                .statusCode(200)
                .body("bookingid",Matchers.hasSize(1));




    }
}
