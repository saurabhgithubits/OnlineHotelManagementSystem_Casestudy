package com.ohms.managementservice;

import org.junit.jupiter.api.Test;

import com.ohms.managementservice.exception.ErrorDetail;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

public class ErrorDetailTest {

    @Test
    public void testNoArgsConstructor() {
        ErrorDetail errorDetail = new ErrorDetail();
        assertEquals(null, errorDetail.getTimestamp());
        assertEquals(null, errorDetail.getMessage());
        assertEquals(null, errorDetail.getDetails());
    }

    @Test
    public void testAllArgsConstructor() {
        Date timestamp = new Date();
        String message = "Test error message";
        String details = "Test error details";

        ErrorDetail errorDetail = new ErrorDetail(timestamp, message, details);

        assertEquals(timestamp, errorDetail.getTimestamp());
        assertEquals(message, errorDetail.getMessage());
        assertEquals(details, errorDetail.getDetails());
    }

    @Test
    public void testGettersAndSetters() {
        ErrorDetail errorDetail = new ErrorDetail();

        Date timestamp = new Date();
        String message = "Test error message";
        String details = "Test error details";

        errorDetail.setTimestamp(timestamp);
        errorDetail.setMessage(message);
        errorDetail.setDetails(details);

        assertEquals(timestamp, errorDetail.getTimestamp());
        assertEquals(message, errorDetail.getMessage());
        assertEquals(details, errorDetail.getDetails());
    }
}
