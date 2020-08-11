package com.altemetrick.booking.Repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.altemetrick.booking.Entity.BusDetails;

@Repository
public interface BusSearchRepository extends JpaRepository<BusDetails, Long> {

	List<BusDetails> findByOperatorName(String operatorName);

	List<BusDetails> findBySourceCityAndDestinationCityAndTravelDate(String sourceCity, String destinationCity,
			Date travelDate);

	List<BusDetails> findByOperatorNameAndDepatureTimeAndArrivalTimeAndTravelDuration(String operatorName,
			String depatureTime, String arrivalTime, String travelDuration);
}
