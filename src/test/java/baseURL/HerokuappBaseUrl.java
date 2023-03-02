package baseURL;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class HerokuappBaseUrl {

    protected RequestSpecification specHerokuApp;

    @Before
    public void setUp(){
        specHerokuApp = new RequestSpecBuilder().setBaseUri("http://restful-booker.herokuapp.com").build();
    }
}
