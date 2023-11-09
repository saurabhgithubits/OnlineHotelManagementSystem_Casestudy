package com.ohms.room_service.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ohms.room_service.entity.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

	List<Room> findAllByCheckInDateLessThanEqualAndCheckOutDateGreaterThanEqual(LocalDate checkOutDate,
					LocalDate checkInDate);
	
	@Query("SELECT r FROM Room r WHERE (:checkInDate BETWEEN r.checkInDate AND r.checkOutDate) AND (:checkOutDate BETWEEN r.checkInDate AND r.checkOutDate)")
    List<Room> findAvailableRoomsBetweenDates(@Param("checkInDate") LocalDate checkInDate, @Param("checkOutDate") LocalDate checkOutDate);
	
	@Query("SELECT r FROM Room r WHERE (:roomType LIKE roomType )")
    List<Room> findRoomsByType(@Param("roomType") String roomType);

}
