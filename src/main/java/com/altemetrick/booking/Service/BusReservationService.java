package com.altemetrick.booking.Service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.altemetrick.booking.Entity.BusDetails;
import com.altemetrick.booking.Exception.RecordNotFoundException;

@Service
public interface BusReservationService {

	public List<BusDetails> getAllBusDetails() throws RecordNotFoundException;

	public List<BusDetails> searchByOperatorName(String name) throws RecordNotFoundException;

	public List<BusDetails> searchBusBySourceAndDestination(String sourceCity, String destinationCity, Date travelDate,
			String sortBy) throws RecordNotFoundException;

	public String createOrUpdateBusDeatail(BusDetails busDetails) throws RecordNotFoundException;

	public String bookBus(BusDetails busEntiry, String travelername, String seatNumber) throws RecordNotFoundException;
}
