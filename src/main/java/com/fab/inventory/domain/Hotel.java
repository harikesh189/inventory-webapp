package com.fab.inventory.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.fab.inventory.constant.HotelStarRating;

@Entity
public class Hotel extends AbstractBaseDomain {

	private static final long serialVersionUID = 13456L;

	@Column(name = "hotel_name")
	String hotelName;

	@Column(name = "hotel_id")
	String hotelId;

	@Column(name = "total_rooms")
	private Integer totalRooms;

	@Column(name = "available_rooms")
	private Integer availableRooms;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "hotel")
	private Set<HotelRoom> bookedRooms;

	@Enumerated(EnumType.STRING)
	@Column(name = "hotel_rating")
	private HotelStarRating hotelRating;

	public HotelStarRating getHotelRating() {
		return hotelRating;
	}

	public void setHotelRating(HotelStarRating hotelRating) {
		this.hotelRating = hotelRating;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getHotelId() {
		return hotelId;
	}

	public void setHotelId(String hotelId) {
		this.hotelId = hotelId;
	}

	public Integer getTotalRooms() {
		return totalRooms;
	}

	public void setTotalRooms(Integer totalRooms) {
		this.totalRooms = totalRooms;
	}

	public Integer getAvailableRooms() {
		return availableRooms;
	}

	public void setAvailableRooms(Integer availableRooms) {
		this.availableRooms = availableRooms;
	}

	public Set<HotelRoom> getBookedRooms() {
		return bookedRooms;
	}

	public void setBookedRooms(Set<HotelRoom> bookedRooms) {
		this.bookedRooms = bookedRooms;
	}

}