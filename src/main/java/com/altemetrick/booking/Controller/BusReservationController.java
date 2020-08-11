package com.altemetrick.booking.Controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.altemetrick.booking.Entity.BusDetails;
import com.altemetrick.booking.Exception.RecordNotFoundException;
import com.altemetrick.booking.Service.BusReservationService;

@RestController
@RequestMapping(value = "/BusService")
public class BusReservationController {

	@Autowired
	private BusReservationService service;

	/**
	 * getAllBusDetails used to get full information about bus
	 * 
	 * @return List of Bus details
	 * @throws RecordNotFoundException
	 */
	@RequestMapping("/getAllBusDetails")
	public List<BusDetails> getAllBusDetails() throws RecordNotFoundException {
		return service.getAllBusDetails();
	}

	/**
	 * searchByOperatorName used to search bus by given operator name
	 * 
	 * @param name
	 * @return List of Bus operator
	 * @throws RecordNotFoundException
	 */
	@ResponseBody
	@RequestMapping("/searchByOperatorName")
	public List<BusDetails> searchByOperatorName(
			@RequestParam(required = true, name = "OperatorName") String OperatorName) throws RecordNotFoundException {
		return service.searchByOperatorName(OperatorName);
	}

	/**
	 * searchBusBySourceAndDestination method used to get the detail of the bus
	 * based on passed parameters
	 * 
	 * @param SourceCity
	 * @param DestinationCity
	 * @param TravelDate
	 * @return List of Bus detail
	 * @throws RecordNotFoundException
	 */
	@ResponseBody
	@RequestMapping("/searchBusBySourceAndDestination")
	public List<BusDetails> searchBusBySourceAndDestination(
			@RequestParam(required = true, name = "SourceCity") String SourceCity,
			@RequestParam(required = true, name = "DestinationCity") String DestinationCity,
			@RequestParam(required = true, name = "TravelDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date TravelDate,
			@RequestParam(required = false, name = "sortBy") String sortBy) throws RecordNotFoundException {
		return service.searchBusBySourceAndDestination(SourceCity, DestinationCity, TravelDate, sortBy);
	}

	/**
	 * createOrUpdateBusDeatail used to create or update a existing bus details
	 * 
	 * @param busDetails
	 * @return String
	 * @throws RecordNotFoundException
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/addBusDetail")
	public String createOrUpdateBusDeatail(@RequestBody BusDetails busDetails) throws RecordNotFoundException {
		return service.createOrUpdateBusDeatail(busDetails);
	}

	/**
	 * bookBus used to book the bus based on the searched bus details.
	 * 
	 * @param busEntity
	 * @param travelername
	 * @param seatNumber
	 * @return String
	 * @throws RecordNotFoundException
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/bookBus/{travelername}/{seatNumber}")
	public String bookBus(@RequestBody BusDetails busEntity, @PathVariable String travelername,
			@PathVariable String seatNumber) throws RecordNotFoundException {
		return service.bookBus(busEntity, travelername, seatNumber);
	}
}
