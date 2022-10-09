package models.booking.body.response;

import models.booking.body.Bookingdates;

@lombok.Data
public class Booking {
    private String firstname;
    private String lastname;
    private String totalprice;
    private String depositpaid;
    private Bookingdates bookingdates;
    private String additionalneeds;
}
