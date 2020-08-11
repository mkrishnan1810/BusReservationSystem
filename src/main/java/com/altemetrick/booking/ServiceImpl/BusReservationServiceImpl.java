package com.altemetrick.booking.ServiceImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.altemetrick.booking.Entity.BookingDetail;
import com.altemetrick.booking.Entity.BusDetails;
import com.altemetrick.booking.Exception.RecordNotFoundException;
import com.altemetrick.booking.Repository.BusBookingRepository;
import com.altemetrick.booking.Repository.BusSearchRepository;
import com.altemetrick.booking.Service.BusReservationService;

@Service
public class BusReservationServiceImpl implements BusReservationService {

	@Autowired
	private BusSearchRepository busSearchRepository;

	@Autowired
	private BusBookingRepository busBookingRepository;

	public List<BusDetails> getAllBusDetails() throws RecordNotFoundException {
		return busSearchRepository.findAll();
	}

	@Override
	public List<BusDetails> searchByOperatorName(String name) throws RecordNotFoundException {
		return busSearchRepository.findByOperatorName(name);
	}

	@Override
	public List<BusDetails> searchBusBySourceAndDestination(String sourceCity, String destinationCity, Date travelDate,
			String sortBy) throws RecordNotFoundException {
		List<BusDetails> searchList = busSearchRepository.findBySourceCityAndDestinationCityAndTravelDate(sourceCity,
				destinationCity, travelDate);
		List<BusDetails> newSortedList = new ArrayList<BusDetails>();
		searchList.stream().forEach(t -> newSortedList.add(t));
		if (sortBy != null) {
			if (sortBy.contentEquals("depatureTime")) {
				Collections.sort(newSortedList, (o1, o2) -> o1.getDepatureTime().compareTo(o2.getDepatureTime()));
			} else if (sortBy.contentEquals("arrivalTime")) {
				Collections.sort(newSortedList, (o1, o2) -> o1.getArrivalTime().compareTo(o2.getArrivalTime()));
			} else if (sortBy.contentEquals("travel_duration")) {
				Collections.sort(newSortedList, (o1, o2) -> o1.getTravelDuration().compareTo(o2.getTravelDuration()));
			} else {
				Collections.sort(newSortedList, (o1, o2) -> o1.getTicketPrice() - o2.getTicketPrice());
			}
		} else {
			Collections.sort(newSortedList, (o1, o2) -> o1.getTicketPrice() - o2.getTicketPrice());
		}
		return newSortedList;
	}

	@Override
	public String createOrUpdateBusDeatail(BusDetails entity) throws RecordNotFoundException {
		busSearchRepository.save(entity);
		return "Data Created successfully";
	}

	@Override
	public String bookBus(BusDetails busEntiry, String travelername, String seatNumber) throws RecordNotFoundException {
		BookingDetail bookEntity = new BookingDetail();
		bookEntity.setBookingId(UUID.randomUUID());
		bookEntity.setBusNumber(busEntiry.getBusNumber());
		bookEntity.setOperatorName(busEntiry.getOperatorName());
		bookEntity.setSeatNumber(seatNumber);
		bookEntity.setTravelDate(busEntiry.getTravelDate());
		bookEntity.setTravelerName(travelername);
		busBookingRepository.save(bookEntity);
		return "Ticket Booked Sucessfully";
	}
}
