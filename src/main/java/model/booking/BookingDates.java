package model.booking;

import base.BaseModel;
import io.qameta.allure.internal.shadowed.jackson.annotation.JsonProperty;

public class BookingDates extends BaseModel {
    @JsonProperty("checkin")
    private final String checkin;
    @JsonProperty("checkout")
    private final String checkout;

    public BookingDates() {
        checkin="2018-01-01";
        checkout="2018-01-01";
    }

    public String getCheckin() {
        return checkin;
    }

    public String getCheckout() {
        return checkout;
    }
}
