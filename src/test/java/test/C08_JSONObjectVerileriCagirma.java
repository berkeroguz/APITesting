package test;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

public class C08_JSONObjectVerileriCagirma {
        /*
    {
    "firstName": "John",
    "lastName": "doe",
    "age": 26,
    "address": {
        "streetAddress": "naist street",
        "city": "Nara",
        "postalCode": "630-0192"
    },
    "phoneNumbers": [
        {
            "type": "iPhone",
            "number": "0123-4567-8888"
        },
        {
            "type": "home",
            "number": "0123-4567-8910"
        }
    ]
}
     */

    @Test
    public void test01(){
        JSONObject innerAddress=new JSONObject();
        innerAddress.put("streetAddress","naist street");
        innerAddress.put("city","Nara");
        innerAddress.put("postalcode","630-0192");

        JSONObject phoneNumber = new JSONObject();
        phoneNumber.put("type","iPhone");
        phoneNumber.put("number","0123-4567-8910");

        JSONObject homeNumber = new JSONObject();
        homeNumber.put("type","home");
        homeNumber.put("number","0123-456-8910");

        JSONArray phoneInformation= new JSONArray();
        phoneInformation.put(phoneNumber);
        phoneInformation.put(homeNumber);

        JSONObject mainObject = new JSONObject();
        mainObject.put("firstname","John");
        mainObject.put("lastname","doe");
        mainObject.put("age",26);
        mainObject.put("address",innerAddress);
        mainObject.put("phoneNumbers",phoneInformation);

        System.out.println(mainObject);


    }
}
