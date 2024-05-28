package com.work.hotl.modal;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
@AllArgsConstructor

public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String roomType;
    private BigDecimal roomPrice;
    private boolean isBooked =false;
    @Lob
    private Blob Photo;
    @OneToMany(mappedBy="room", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<BookedRoom> bookings;

    public Room(){
        this.bookings = new ArrayList<>();
    }
    public void addBooking(BookedRoom booking){
        if(bookings == null){
            bookings =new ArrayList<>();
        }
        bookings.add(booking);
        booking.setRoom(this);
        isBooked = true;
        String RandomStringUtils;

        String bookingCode = generateRandomString(10);
        booking.setBookingConfirmationCode(bookingCode);
        booking.setBookingConfirmationCode(bookingCode);
    }
    public static String generateRandomString(int length) {
        return new Random().ints(48, 58)
                .limit(length)
                .mapToObj(i -> (char) i)
                .map(Object::toString)
                .collect(Collectors.joining());
    }
}
