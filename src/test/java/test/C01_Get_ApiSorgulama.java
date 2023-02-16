package test;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C01_Get_ApiSorgulama {
    /*
    https://restful-booker.herokuapp.com/booking/9856 url'ine
    bit GET request gönderdigimizde dönen Response'un status code = 200
    content typ = application/json; charset=utf-8,
    status line = HTTP/1.1 200 OK
    response time = <5 second  oldungun manuel olarak test edinz
     */

    @Test
    public void get01(){


        // 1- Göndereceğimiz Request icin gerek olan URL ve Body hazirla
        String url="https://restful-booker.herokuapp.com/booking/1";

        // 2- Expected Data hazirlanir

        // 3- Dönen response'i ActualData olarak kaydet
        Response response = given().when().get(url);
        response.prettyPrint();
        // Assertion yapılır


    }
}
