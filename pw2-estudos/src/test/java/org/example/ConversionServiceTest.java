package org.example;

import static org.hamcrest.Matchers.is;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;

public class ConversionServiceTest {

    @Test
    void testConversionKmMiles() {
        given()
            .contentType(ContentType.TEXT)
            // 50 quilômetros por hora
            .body("50")
        .when()
            .post("/Conversion/km-to-miles")
        .then()
            .contentType(ContentType.TEXT)
            .statusCode(200)
            .body(is("31.06855"));
    }

    /**
     * Test case to verify the conversion from knots to kilometers per hour.
     * The expected value for 1 knot in km/h is 1.852.
    */
    @Test
    void testConversionKnotsKm() {
        given()
            .contentType(ContentType.TEXT)
        .when()
            .contentType(ContentType.JSON)
            .get("/Conversion/knots-to-km/1")
        .then()
            .statusCode(200)
            .body("value", is(1.852f));
    }
}
