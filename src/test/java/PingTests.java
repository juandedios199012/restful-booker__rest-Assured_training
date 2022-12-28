import api.PingApi;
import base.BaseTest;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.awt.geom.RectangularShape;

import static org.hamcrest.Matchers.lessThan;

public class PingTests extends BaseTest {

    private Response response;
    @Test
    public void healthCheckTest(){
        final var pingApi=new PingApi(true);

        response=pingApi.helthCheck();
        response.then().assertThat()
                        .statusCode(201)
                        .time(lessThan(4000L));
    }
}
