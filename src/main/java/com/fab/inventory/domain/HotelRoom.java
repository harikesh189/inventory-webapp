package com.fab.inventory.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fab.inventory.constant.HotelRoomType;

@Entity
public class HotelRoom extends AbstractBaseDomain {

	private static final long serialVersionUID = 198765L;

	@Column(name = "room_id")
	String roomId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id")
	Customer customerDetail;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "hotel_id")
	private Hotel hotel;

	@Enumerated(EnumType.STRING)
	@Column(name = "hotel_room_type")
	private HotelRoomType HotelRoomType;

	public HotelRoomType getHotelRoomType() {
		return HotelRoomType;
	}

	public void setHotelRoomType(HotelRoomType hotelRoomType) {
		HotelRoomType = hotelRoomType;
	}

	public String getRoomId() {
		return roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}

	public Customer getCustomerDetail() {
		return customerDetail;
	}

	public void setCustomerDetail(Customer customerDetail) {
		this.customerDetail = customerDetail;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

}