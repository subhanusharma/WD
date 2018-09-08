<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="">
<head>
<title>Rakshita Welfare Society</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<link href="layout/styles/layout.css" rel="stylesheet" type="text/css"
	media="all">
<link rel="stylesheet" href="style/w3.css">
<link rel="icon" type="image/png" href="images/icons/fav-icon.png"/>
</head>
<body id="top">

<jsp:include page="Header.jsp"></jsp:include>

<jsp:include page="MainMenu.jsp"></jsp:include>


<div class="wrapper row3">
  <main class="hoc container clear"> 
    <!-- main body -->
    <div class="sectiontitle">
      <c:forEach items="${requestScope.activityList}" var="activity">
    					
      <h6 class="heading">${activity.activityname}</h6><span style="color:red;">[ <fmt:formatDate value="${activity.activitydate}" pattern="dd-MM-yyyy" /> ]</span><br>
      <p>${activity.activitydescription}</p><br>
      <img class="mySlides" src="${activity.uploadurl}" style="width:500px; height:auto; display: block; margin-left: auto; margin-right: auto;"><br><br>
      </c:forEach>
    </div>
    </main>
</div>

<jsp:include page="Footer.jsp"></jsp:include>

<script src="layout/scripts/jquery.min.js"></script>
<script src="layout/scripts/jquery.backtotop.js"></script>
<script src="layout/scripts/jquery.mobilemenu.js"></script>

</body>

</html>

