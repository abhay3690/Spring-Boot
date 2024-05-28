package com.work.hotl.service;

import com.work.hotl.exception.ResourceNotFoundException;
import com.work.hotl.modal.Room;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface IRoomService {
    Room addNewRoom(MultipartFile photo, String roomType, BigDecimal roomPrice) throws IOException, SQLException;

    List<String> getAllRoomType();

    List<Room> getAllRoom();

    byte[] getRoomPhotoByRoomId(Long roomId) throws ResourceNotFoundException, SQLException;

    void deleteRoom(Long roomId);

    Room updateRoom(Long roomId, String roomType, BigDecimal roomPrice, byte[] photoBytes) throws ResourceNotFoundException;

    Optional<Room> getRoomById(Long roomId);
}
