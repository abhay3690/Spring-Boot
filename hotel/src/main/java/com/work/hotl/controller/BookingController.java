package com.work.hotl.controller;

import com.work.hotl.Response.BookingResponse;
import com.work.hotl.Response.RoomResponse;
import com.work.hotl.exception.InvalidBookingRequestException;
import com.work.hotl.exception.ResourceNotFoundException;
import com.work.hotl.modal.BookedRoom;
import com.work.hotl.modal.Room;
import com.work.hotl.service.IBookingService;
import com.work.hotl.service.IRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RequiredArgsConstructor
@RestController
@RequestMapping("/bookings")
public class BookingController {
    private final IBookingService bookingService;
    private final IRoomService roomService;
    @GetMapping("all-bookings")
    public ResponseEntity<List<BookingResponse>> getAllBookings(){
        List<BookedRoom> bookings =bookingService.getAllBookings();
        List<BookingResponse> bookingResponses = new ArrayList<>();
        for (BookedRoom booking: bookings){
            BookingResponse bookingResponse = getBookingResponse(booking);
            bookingResponses.add(bookingResponse);
        }
        return ResponseEntity.ok(bookingResponses);
    }



    @GetMapping("/confirmation/{confirmationcode}")
    public ResponseEntity<?> getBookingByConfirmationCode(@PathVariable String confirmationCode){
        BookedRoom booking = bookingService.findByBookingConfirmationCode(confirmationCode);
        BookingResponse bookingResponse = getBookingResponse(booking);
        return ResponseEntity.ok(bookingResponse);
    }
    @PostMapping("/room/{roomId}/booking")
    public ResponseEntity<?> saveBooking(@PathVariable Long roomId, @RequestBody BookedRoom bookingRequest){
        try{
            String confirmationCode =  bookingService.saveBooking(roomId , bookingRequest);
            return ResponseEntity.ok("Room bookedSuccesFully ,Your booking confirmationcode is: "+confirmationCode);
        }catch(InvalidBookingRequestException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @DeleteMapping("/booking/{bookingId}/delete")
    public void cancelBooking(Long bookingId){
        bookingService.cancelBooking(bookingId);
    }
    private BookingResponse getBookingResponse(BookedRoom booking) {
        Room theRoom =roomService.getRoomById(booking.getRoom().getId()).get();
        RoomResponse room = new RoomResponse(theRoom.getId(), theRoom.getRoomType(), theRoom.getRoomPrice());
        return new BookingResponse(booking.getId(), booking.getCheckInDate(),booking.getCheckOutDate(),booking.getGuestFullName(),booking.getGuestEmail(), booking.getNumOfAdults(), booking.getNumOfChildren(),booking.getTotalNumberOfGuest(),booking.getBookingConfirmationCode(), room);
    }
}
