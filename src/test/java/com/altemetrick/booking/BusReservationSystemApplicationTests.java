package com.altemetrick.booking;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.altemetrick.booking.Entity.BusDetails;
import com.altemetrick.booking.Repository.BusSearchRepository;
import com.altemetrick.booking.Service.BusReservationService;

@SpringBootTest
class BusReservationSystemApplicationTests {

	@Autowired
	private BusReservationService service;

	@MockBean
	private BusSearchRepository repository;

	@Test
	public void getAllBusDetails() throws Exception {
		SimpleDateFormat formatter = new SimpleDateFormat("yyy-MM-dd");
		Date date = formatter.parse("2020-08-07");
		Long i = 1L;
		when(repository.findAll()).thenReturn(Stream.of(
				new BusDetails(i, date, "Jk_tavals", 24, Time.valueOf("18:33:00"), Time.valueOf("18:33:00"), "Chennai",
						"Karaikal", Time.valueOf("18:33:00"), 456),
				new BusDetails(i, date, "Jk_tavals", 24, Time.valueOf("18:33:00"), Time.valueOf("18:33:00"), "Chennai",
						"Karaikal", Time.valueOf("18:33:00"), 467),
				new BusDetails(i, date, "Jk_tavals", 24, Time.valueOf("18:43:00"), Time.valueOf("18:33:00"), "Chennai",
						"Karaikal", Time.valueOf("18:33:00"), 452))
				.collect(Collectors.toList()));
		assertEquals(3, service.getAllBusDetails().size());
		List<BusDetails> result = service.getAllBusDetails();
		assertNotNull(result);
		assertFalse(result.isEmpty());
	}

	@Test
	public void createOrUpdateBusDeatail() throws Exception {
		SimpleDateFormat formatter = new SimpleDateFormat("yyy-MM-dd");
		Date date = formatter.parse("2020-08-07");
		Long i = 1L;
		BusDetails entity = new BusDetails(i, date, "Jk_tavals", 24, Time.valueOf("18:33:00"), Time.valueOf("18:33:00"),
				"Chennai", "Karaikal", Time.valueOf("18:33:00"), 456);
		when(repository.save(entity)).thenReturn(entity);
		assertEquals("Data Created successfully", service.createOrUpdateBusDeatail(entity));
	}
}
