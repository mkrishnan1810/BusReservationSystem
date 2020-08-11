package com.altemetrick.booking.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.altemetrick.booking.Entity.BookingDetail;

@Repository
public interface BusBookingRepository extends JpaRepository<BookingDetail, UUID> {

}
