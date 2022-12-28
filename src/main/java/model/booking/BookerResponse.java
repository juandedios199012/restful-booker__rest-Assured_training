package model.booking;

import base.BaseModel;
import com.github.javafaker.Faker;
import io.qameta.allure.internal.shadowed.jackson.annotation.JsonProperty;
import org.testng.asserts.SoftAssert;

public class BookerResponse extends BaseModel {

    @JsonProperty("firstname")
    private final String firstname;
    @JsonProperty("lastname")
    private final String lastname;
    @JsonProperty("totalprice")
    private final int totalprice;
    @JsonProperty("depositpaid")
    private final boolean depositpaid;
    @JsonProperty("additionalneeds")
    private final String additionalneeds;
    @JsonProperty("bookingdates")
    private final BookingDates bookingdates;

    public BookerResponse() {
        var faker=new Faker();
        firstname= faker.name().firstName();
        lastname=faker.name().lastName();
        totalprice=faker.number().numberBetween(5,100);
        depositpaid=faker.bool().bool();
        additionalneeds=faker.animal().name();
        bookingdates=new BookingDates();
    }

    public void isEqualsTo(BookerResponse bookerResponse){
        var sofAssert=new SoftAssert();
        sofAssert.assertEquals(firstname, bookerResponse.getFirstname());
        sofAssert.assertEquals(lastname, bookerResponse.getLastname());
        sofAssert.assertEquals(totalprice, bookerResponse.getTotalprice());
        sofAssert.assertEquals(depositpaid, bookerResponse.isDepositpaid());
        sofAssert.assertEquals(additionalneeds, bookerResponse.getAdditionalneeds());
        sofAssert.assertEquals(bookingdates.getCheckin(), bookerResponse.getbookingdates().getCheckin());
        sofAssert.assertEquals(bookingdates.getCheckout(), bookerResponse.getbookingdates().getCheckin());

        sofAssert.assertAll();
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public int getTotalprice() {
        return totalprice;
    }

    public boolean isDepositpaid() {
        return depositpaid;
    }

    public String getAdditionalneeds() {
        return additionalneeds;
    }

    public BookingDates getbookingdates() {
        return bookingdates;
    }
}
