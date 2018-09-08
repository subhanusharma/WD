

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
<link rel='stylesheet prefetch' href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0/css/bootstrap.css'>
<link rel="icon" type="image/png" href="images/icons/fav-icon.png"/><link rel="stylesheet" href="style/style.css">

<style>
html {
	box-sizing: border-box;
}

*, *:before, *:after {
	box-sizing: inherit;
}

.column {
	float: left;
	width: 33.3%;
	margin-bottom: 16px;
	padding: 0 8px;
}

@media screen and (max-width: 650px) {
	.column {
		width: 100%;
		display: block;
	}
}

.card {
	box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
}

.container {
	padding: 0 16px;
}

.container::after, .row::after {
	content: "";
	clear: both;
	display: table;
}

.title {
	color: grey;
}

.button {
	border: none;
	outline: 0;
	display: inline-block;
	padding: 8px;
	color: white;
	background-color: #000;
	text-align: center;
	cursor: pointer;
	width: 100%;
}

.button:hover {
	background-color: #555;
}

.overflowtext {
  display: block;
  width: 160px;
  overflow: hidden;
  white-space: nowrap;
  text-overflow: ellipsis;
}
</style>

</head>
<body id="top">

	<jsp:include page="Header.jsp"></jsp:include>

	<jsp:include page="MainMenu.jsp"></jsp:include>

	<div id="pageintro" class="hoc clear"
		style="padding-top: 50px; padding-bottom: 50px;">
		<div class="w3-content w3-section" >
			<c:forEach items="${requestScope.photoList}" var="photo">
				<img class="mySlides" src="${photo.uploadurl}"
					style="max-width: 70%; max-height: 12%; display: block; margin-left: auto; margin-right: auto;">
			</c:forEach>
		</div>
	</div>

	<div class="wrapper row3">
		<main class="hoc container clear"> <!-- main body -->
		<div class="sectiontitle" style="max-width: 80%; ">
			<div style="font-family:  'Hoefler Text', Georgia, 'Times New Roman', serif;
 font-weight: normal;
        font-size: 1.75em;
 letter-spacing: .2em;
 line-height: 1.1em;
 margin:0px;
 text-align: center;
 text-transform: uppercase;"><h4 class="heading">"Our Mission is to HELP</h4>
			<p>Those who NEED it"</p><br><br>
</div>
<h6 class="heading">Activities Performed </h6>
<br>
<div class="container-fluid">
 
  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <div class="carousel-inner row w-100 mx-auto">
      <div class="carousel-item col-md-4 active">
        <div class="card">
        <img class="card-img-top img-fluid" style="max-width: 260px; height: auto; " src="images/logo.jpg" alt="logo">
          <div class="card-body">
            <h4 class="card-title"></h4>
            <p class="card-text"></p>
            <p class="card-text"><small class="text-muted"></small></p>
          </div>
        </div>
      </div>
    <c:forEach items="${requestScope.activityList}" var="photo">
      <div class="carousel-item col-md-4 ">
        <div class="card">
          <img class="card-img-top img-fluid" style="max-width: 260px; height: auto; " src="${photo.uploadurl}" alt="${photo.activityname}">
          <div class="card-body">
            <h4 class="card-title">${photo.activityname}</h4>
            <p class="card-text"><span class="overflowtext" >${photo.activitydescription}</span></p>
            <p class="card-text"><small class="text-muted"><fmt:formatDate value="${photo.activitydate}" pattern="dd-MM-yyyy" /></small></p>
          </div>
        </div>
      </div>
  </c:forEach>
    </div>
    <a class="carousel-control-prev" href="#myCarousel" role="button" data-slide="prev">
      <span class="carousel-control-prev-icon" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="carousel-control-next" href="#myCarousel" role="button" data-slide="next">
      <span class="carousel-control-next-icon" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
</div>
<br>
<br>
<h6 class="heading">Events Held</h6>
<br>

<div class="container-fluid">
 
  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <div class="carousel-inner row w-100 mx-auto">
      <div class="carousel-item col-md-4 active">
        <div class="card">
        <img class="card-img-top img-fluid" style="max-width: 260px; height: auto; " src="images/logo.jpg" alt="logo">
          <div class="card-body">
            <h4 class="card-title"></h4>
            <p class="card-text"></p>
            <p class="card-text"><small class="text-muted"></small></p>
          </div>
        </div>
      </div>
    <c:forEach items="${requestScope.eventList}" var="photo">
      <div class="carousel-item col-md-4 ">
        <div class="card">
          <img class="card-img-top img-fluid" style="max-width: 260px; height: auto; " src="${photo.uploadurl}" alt="${photo.eventname}">
          <div class="card-body">
            <h4 class="card-title">${photo.eventname}</h4>
            <p class="card-text"><span class="overflowtext" >${photo.eventdescription}</span></p>
            <p class="card-text"><small class="text-muted"><fmt:formatDate value="${photo.eventdate}" pattern="dd-MM-yyyy" /></small></p>
          </div>
        </div>
      </div>
  </c:forEach>
    </div>
    <a class="carousel-control-prev" href="#myCarousel" role="button" data-slide="prev">
      <span class="carousel-control-prev-icon" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="carousel-control-next" href="#myCarousel" role="button" data-slide="next">
      <span class="carousel-control-next-icon" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
</div>
		</div>
		</main>
	</div>

	<jsp:include page="Footer.jsp"></jsp:include>

	<jsp:include page="Script.jsp"></jsp:include>
<script src='https://code.jquery.com/jquery-1.12.4.min.js'></script>
<script src='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0/js/bootstrap.min.js'></script>
<script  src="js/index.js"></script>
</body>
</html>

