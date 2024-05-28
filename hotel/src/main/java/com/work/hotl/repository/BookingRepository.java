package com.work.hotl.repository;

import com.work.hotl.modal.BookedRoom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Book;
import java.util.List;

public interface BookingRepository extends JpaRepository<BookedRoom,Long> {

    List<BookedRoom> findByRoomId(Long roomId);
    BookedRoom findByBookingConfirmationCode(String confirmationCode);
    List<BookedRoom> findAll();


    List<BookedRoom> findByGuestEmail(String email);


}
