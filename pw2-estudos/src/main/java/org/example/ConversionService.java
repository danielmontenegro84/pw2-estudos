package org.example;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/Conversion")
public class ConversionService {

    @POST
    @Path("/km-to-miles")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    public Response convertKmToMiles(String km){
        try {
            double kmValue = Double.parseDouble(km);
            double miles = kmValue * 0.621371;
            return Response.ok(String.format("%.5f", miles)).build();
        } catch (NumberFormatException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Invalid input").build();
        }
    }
    
    /*
    @POST
    @Path("/km-to-miles")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    public Response convertKnotsToKm(@PathParam("knots") double knots) {
        double kmPerHour = knots * 1.852;
        return  Response.ok(new ConversionResult(kmPerHour)).build();
    }
    */
    
    @GET
    @Path("/fahrenheit-to-celsius/{farenheit}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response convertFahrenheitToCelsius(@PathParam("fahrenheit") double fahrenheit) {
        double celsius = (fahrenheit - 32) * 5/9;
        return Response.ok(new ConversionResult(celsius)).build();
    }

    @GET
    @Path("/inches-to-meters/{inches}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response convertInchesToMeters(@PathParam("inches") double inches) {
        double meters = inches / 39.370;
        return Response.ok(new ConversionResult(meters)).build();
    }
}
