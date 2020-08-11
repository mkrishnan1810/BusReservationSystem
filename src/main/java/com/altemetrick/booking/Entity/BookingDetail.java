package com.altemetrick.booking.Entity;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "booking_details")
public class BookingDetail {

	@Id
	@GeneratedValue(generator = "UUID")
	@Column(name = "booking_id")
	private UUID bookingId;

	@Column(name = "bus_number")
	private Long busNumber;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "travel_date")
	private Date travelDate;

	@Column(name = "operator_name")
	private String operatorName;

	@Column(name = "traveler_name")
	private String travelerName;

	@Column(name = "seat_number")
	private String seatNumber;

	public BookingDetail() {

	}

	public BookingDetail(Long busNumber, String operatorName, UUID bookingId, String travelerName, String seatNumber,Date travelDate) {
		super();
		this.busNumber = busNumber;
		this.operatorName = operatorName;
		this.bookingId = bookingId;
		this.travelerName = travelerName;
		this.seatNumber = seatNumber;
		this.travelDate = travelDate;
	}

	public Date getTravelDate() {
		return travelDate;
	}

	public void setTravelDate(Date travelDate) {
		this.travelDate = travelDate;
	}

	public Long getBusNumber() {
		return busNumber;
	}

	public String getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}

	public void setBusNumber(Long busNumber) {
		this.busNumber = busNumber;
	}

	public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

	public UUID getBookingId() {
		return bookingId;
	}

	public void setBookingId(UUID bookingId) {
		this.bookingId = bookingId;
	}

	public String getTravelerName() {
		return travelerName;
	}

	public void setTravelerName(String travelerName) {
		this.travelerName = travelerName;
	}

}
