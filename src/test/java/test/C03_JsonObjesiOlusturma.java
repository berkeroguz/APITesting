package test;

import org.json.JSONObject;
import org.junit.Test;

public class C03_JsonObjesiOlusturma {
    @Test
    public void test01(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("title","Ahmet");
        jsonObject.put("body","Merhaba");
        jsonObject.put("userId",1);

        System.out.println(jsonObject);
    }

    // iç içe Json obje olusturma

    @Test
    public void test02(){
        JSONObject innerJson = new JSONObject();
        innerJson.put("checkin","2023-01-01");
        innerJson.put("checkout","2023-01-02");

        JSONObject jsonObjectBody = new JSONObject();
        jsonObjectBody.put("firstname","Berker");
        jsonObjectBody.put("lastname","Ogz");
        jsonObjectBody.put("totalprice",1000);
        jsonObjectBody.put("depositpaid",true);
        jsonObjectBody.put("bookingdates",innerJson);

        System.out.println(jsonObjectBody);

    }
}
