package com.work.hotl.service;

import com.work.hotl.modal.BookedRoom;

import java.util.List;

public interface IBookingService {
//    List<BookedRoom> getBookingsByUserEmail(String email);

    void cancelBooking(Long bookingId);

    String saveBooking(Long roomId, BookedRoom bookingRequest);

    BookedRoom findByBookingConfirmationCode(String confirmationCode);

    List<BookedRoom> getAllBookings();
}
