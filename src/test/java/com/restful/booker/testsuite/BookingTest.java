package com.restful.booker.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.Matchers.hasKey;

public class BookingTest
{
    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "https://restful-booker.herokuapp.com/";
        response = given()
                .when()
                .get("/booking/1")
                .then().statusCode(200);
    }

    // verify firstName from list
    @Test
    public void verifyFname(){
        response.body("firstname", hasItem("Eric"));
    }

    // verify lastName from list
    @Test
    public void verifyLname(){
        response.body("lastname", hasItem("Brown"));
    }

    // verify total price from list
    @Test
    public void verifyTotalPrice()
    {
        response.body("totalprice", hasItem("totalprice"));
    }

    // verify booking date
    @Test
    public void verifyBookingDate()
    {
        response.body("bookingdates", hasKey("checkout"));
    }

    // verify additional need is breakfast
    @Test
    public void verifyAdditionalNeed()
    {
        response.body("additionalneeds", hasKey("Breakfast"));
    }

}
