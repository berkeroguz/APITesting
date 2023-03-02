package testData;

import org.json.JSONObject;

public class TestDataDummy {
    public int basariliStatusCode=200;
    public String contentType="application/json; charset=utf-8";
    public String connectionHeaderDegeri="keep-alive";

    public JSONObject createdExpectedBody(){
        /*
                Expected Body
                    {
                    "status":"success",
                    "data": {
                                "id": 3,
                                "employee_name":"Ashton Cox",
                                "employee_salary":86000,
                                "employee_age":66,
                                "profile_image":""
                            },
                    "message": "Successfully! Record has been fetched."
                    }
         */
        JSONObject innerBodyData = new JSONObject();
        innerBodyData.put("id",3);
        innerBodyData.put("employee_name","Ashton Cox");
        innerBodyData.put("employee_salary",86000);
        innerBodyData.put("employee_age",66);
        innerBodyData.put("profile_image","");
        JSONObject expBody= new JSONObject();
        expBody.put("status","success");
        expBody.put("data",innerBodyData);
        expBody.put("message","Successfully! Record has been fetched.");

        return expBody;
    }
}
