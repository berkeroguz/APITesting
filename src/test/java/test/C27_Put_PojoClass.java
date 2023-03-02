package test;

import baseURL.JsonPlaceHolderBaseUrl;
import org.junit.Test;
import pojos.POJOJsonPlaceHolder;

public class C27_Put_PojoClass extends JsonPlaceHolderBaseUrl {
/*

            567 https://jsonplaceholder.typicode.com/posts/70 url'ine asagidaki
            C27_Put_PojoClass
            body'e sahip bir PUT request yolladigimizda donen response'in
            000 response body'sinin asagida verilen ile ayni oldugunu test ediniz
            Request Body
                    {
                    "title":"Ahmet",
                    "body":"Merhaba",
                    "userId":10,
                    "id":70
                    }

            Expected Body
                    {
                    "title":"Ahmet",
                    "body":"Merhaba",
                    "userId":10,
                    "id":70
                    }
 */

    @Test
    public void put01(){

        // 1- Prepare Url and Body
        specJsonPlace.pathParams("pp1","posts","pp2",70);
        POJOJsonPlaceHolder reqBody = new POJOJsonPlaceHolder("Ahmet","Merhaba","userId",70 );



    }

}
