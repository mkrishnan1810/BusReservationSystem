package com.altemetrick.booking.Entity;

import java.sql.Time;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "bus_details")
public class BusDetails {

	@Id
	@Column(name = "bus_number")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long busNumber;

	@Temporal(TemporalType.DATE)
	@Column(name = "travel_date")
	private Date travelDate;

	@Column(name = "operator_name")
	private String operatorName;

	@Column(name = "seats_available")
	private int seatsAvailable;

	@Column(name = "depature_time")
	private Time depatureTime;

	@Column(name = "arrival_time")
	private Time arrivalTime;

	@Column(name = "source_city")
	private String sourceCity;

	@Column(name = "destination_city")
	private String destinationCity;

	@Column(name = "travel_duration")
	private Time travelDuration;

	@Column(name = "ticket_price")
	private int ticketPrice;

	public BusDetails() {

	}

	public BusDetails(Long busNumber, Date travelDate, String operatorName, int seatsAvailable, Time depatureTime,
			Time arrivalTime, String sourceCity, String destinationCity, Time travelDuration, int ticketPrice) {
		super();
		this.busNumber = busNumber;
		this.travelDate = travelDate;
		this.operatorName = operatorName;
		this.seatsAvailable = seatsAvailable;
		this.depatureTime = depatureTime;
		this.arrivalTime = arrivalTime;
		this.sourceCity = sourceCity;
		this.destinationCity = destinationCity;
		this.travelDuration = travelDuration;
		this.ticketPrice = ticketPrice;
	}

	public Long getBusNumber() {
		return busNumber;
	}

	public void setBusNumber(Long busNumber) {
		this.busNumber = busNumber;
	}

	public Date getTravelDate() {
		return travelDate;
	}

	public void setTravelDate(Date travelDate) {
		this.travelDate = travelDate;
	}

	public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

	public int getSeatsAvailable() {
		return seatsAvailable;
	}

	public void setSeatsAvailable(int seatsAvailable) {
		this.seatsAvailable = seatsAvailable;
	}

	public Time getDepatureTime() {
		return depatureTime;
	}

	public void setDepatureTime(Time depatureTime) {
		this.depatureTime = depatureTime;
	}

	public Time getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(Time arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public String getSourceCity() {
		return sourceCity;
	}

	public void setSourceCity(String sourceCity) {
		this.sourceCity = sourceCity;
	}

	public String getDestinationCity() {
		return destinationCity;
	}

	public void setDestinationCity(String destinationCity) {
		this.destinationCity = destinationCity;
	}

	public Time getTravelDuration() {
		return travelDuration;
	}

	public void setTravelDuration(Time travelDuration) {
		this.travelDuration = travelDuration;
	}

	public int getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(int ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

}
