package model.booking;

import base.BaseModel;
import io.qameta.allure.internal.shadowed.jackson.annotation.JsonProperty;

public class BookingCreateResponse extends BaseModel {

    public static String schemaFile="booking/bookingResponse.json";
    @JsonProperty("bookingid")
    private int bookingid;
    @JsonProperty("booking")
    private BookerResponse bookerResponse;

    public int getBookingid() {
        return bookingid;
    }

    public BookerResponse getBookerResponse() {
        return bookerResponse;
    }

}
