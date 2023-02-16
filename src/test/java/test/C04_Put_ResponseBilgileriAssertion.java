package test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C04_Put_ResponseBilgileriAssertion {
    /*
    https://jsonplaceholder.typicode.com/posts/70 url'ine asagidaki Json formatindaki body ile bir
    PUT Request gönderdigimizde

    {
        "title":"Ahmet",
        "body":"Merhaba",
        "userId":10,
        "id":70
    }

    donen Response'un status code'unun 200,
    ve content type'nin application/json; charset=utf-8
    Header'in Server = cloudflare oldugunu

    ve status line'in HTTP/1.1 200 OK oldugunu test ediniz
     */
    @Test
    public void putRequest(){
        // 1- Request icin gerekli url ve body

        String url = "https://jsonplaceholder.typicode.com/posts/70";
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("title","Ahmet");
        jsonObject.put("body","Merhaba");
        jsonObject.put("userId",10);
        jsonObject.put("id",70);

        // 2- İstenilen expected varsa data hazirla

        // 3- Response'i kaydet
        Response response = given().contentType(ContentType.JSON).
                when().
                    body(jsonObject.toString()).
                    put(url);

        response.prettyPrint();

        // 4- Assertion

        response.then().assertThat().statusCode(200).
                contentType("application/json; charset=utf-8").
                header("Server","cloudflare").
                statusLine("HTTP/1.1 200 OK");
        System.out.println(response.getHeaders());
    }
}
