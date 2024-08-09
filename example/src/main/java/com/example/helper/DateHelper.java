package com.example.helper;

import java.util.Date;

import java.time.LocalDateTime;
import java.time.ZoneId;


public class DateHelper {
    public static LocalDateTime convertToLocalDateTime(Date date) {
        return date.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
    }

    public static Date getCurrentDate() {
        return new Date(); // Returns the current date and time
    }
}
