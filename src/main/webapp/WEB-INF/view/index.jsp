<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta charset="utf-8">
</head>
<body>

	hello this is index page for fab inventory System
	</br>


	</br>
	</br>
	<%--  ${allHotels} All Hotels --%>
	 
	  
	 <c:forEach var="hotel" items="${allHotels}" varStatus="hotelStatus">
	  
		<h2>Hotel Name : ${hotel.hotelName}</h2>
		Total Rooms : ${hotel.totalRooms}
		Available Rooms : ${hotel.availableRooms}
		Rating : ${hotel.hotelRating}	 
	</c:forEach>
	  
	 	
 
</body>
</html>
