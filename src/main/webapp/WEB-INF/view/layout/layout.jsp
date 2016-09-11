<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"  
"http://www.w3.org/TR/html4/loose.dtd">  
<html>  
<head>  
<script src="<c:url value="/resources/jquery-2.1.1.min.js" />"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
<title><tiles:insertAttribute name="title" ignore="true" />  
</title>

<style type ="text/css" >
   .footerPart{ 
       position: fixed;     
       text-align: center;    
       bottom: 0px; 
       width: 100%;
   }  
</style>
  
</head>  
<body>  

<tiles:insertAttribute name="header" /> 
<tiles:insertAttribute name="body" />
<div class="footerPart">
	<tiles:insertAttribute name="footer" />
</div>

   
</body>  
</html>  