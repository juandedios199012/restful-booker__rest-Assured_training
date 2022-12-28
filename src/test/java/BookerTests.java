import api.BookerApi;
import base.BaseTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import model.booking.BookerResponse;
import model.booking.BookingCreateResponse;
import org.testng.annotations.Test;
import utilities.RequestFilter;

import java.awt.print.Book;

import static io.restassured.http.Method.*;
import static org.hamcrest.Matchers.lessThan;

public class BookerTests extends BaseTest {

    private Response response;

    @Test
    public void crudBookingTest(){
        final var bookerApi=new BookerApi(true);

        final var bookerRequestBody=new BookerResponse();
        response=bookerApi.createBooking(bookerRequestBody);

        var  responseBody =response.then().assertThat()
                .statusCode(200)
                .time(lessThan(7000L))
                .body(JsonSchemaValidator.matchesJsonSchema(getSchema(BookingCreateResponse.schemaFile)))
                .extract().body().as(BookingCreateResponse.class);

        bookerRequestBody.isEqualsTo(responseBody.getBookerResponse());

        final var bookingID=responseBody.getBookingid();

        //GET

        response=bookerApi.getBooking(bookingID);
    }

    @Test
    public void deleteUnhappyPathNoAuth(){

        var bookerApi=new BookerApi(true);

        final var bookerRequestBody=new BookerResponse();
        response=bookerApi.createBooking(bookerRequestBody);

        var  responseBody =response.then().assertThat()
                .statusCode(200)
                .time(lessThan(7000L))
                .body(JsonSchemaValidator.matchesJsonSchema(getSchema(BookingCreateResponse.schemaFile)))
                .extract().body().as(BookingCreateResponse.class);

        bookerRequestBody.isEqualsTo(responseBody.getBookerResponse());

        final var bookingID=responseBody.getBookingid();

        bookerApi=new BookerApi(false);

        //delete
        response=bookerApi.deleteBooking(bookingID);

        response.then().assertThat()
                .statusCode(403)
                .time(lessThan(3000L));
    }
}
