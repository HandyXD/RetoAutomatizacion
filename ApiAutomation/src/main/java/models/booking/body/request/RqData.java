package models.booking.body.request;

import models.booking.body.Bookingdates;

@lombok.Data
public class RqData {
    private String firstname;
    private String lastname;
    private String totalprice;
    private String depositpaid;
    private Bookingdates bookingdates;
    private String additionalneeds;
    private String username;
    private String password;
}
