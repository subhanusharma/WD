<%@page import="org.apache.jasper.tagplugins.jstl.core.Import"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="">
<head>
<title>Rakshita Welfare Society</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<link href="layout/styles/layout.css" rel="stylesheet" type="text/css"
	media="all">
<link rel="stylesheet" href="style/w3.css">
<link rel="icon" type="image/png" href="images/icons/fav-icon.png"/>
<script>
	function del(eventid) {
		document.getElementById("eventid").value = eventid;
		document.getElementById("operation").value = 'remove';
		document.uploadmain.submit();
	}
	function mod(eventid, eventname, eventdescription, eventdate, uploadurl) {
		document.getElementById("eventid").value = eventid;
		document.getElementById("eventname").value = eventname;
		document.getElementById("eventdescription").value = eventdescription;
		document.getElementById("eventdate").value = eventdate;
		document.getElementById("path").value = uploadurl;
		document.getElementById("submit").value = 'Update';
		document.getElementById("operation").value = 'edit';
	}
</script>
</head>
<body id="top">

<jsp:include page="Header.jsp"></jsp:include>

<jsp:include page="MainMenu.jsp"></jsp:include>


<div class="wrapper row3">
  <main class="hoc container clear"> 
    <!-- main body -->
    <div class="sectiontitled">
      <h6 class="heading"> Event File Upload Form</h6>
      	<% String path = (String) request.getAttribute("path");%>
      	
      	<form method="post" action="UploadEventServlet" enctype="multipart/form-data"> 
      			Select file to upload: <input type="file" name="file" size="60" id="fileChooser" onchange="return ValidateFileUpload()"/>
      			<br /> <input type="submit"  value="Upload" /> 	
		</form>
		
      	<form id = "uploadmain" name="uploadmain" method="post" action="EventServlet" >
     		Event Name: <input type="text" name="eventname"  id="eventname"/><br /> 
      		Event Description: <textarea name="eventdescription" id="eventdescription" rows="5" cols="100"></textarea>  <br > 
      		Event Date: <input type="date" name="eventdate" id="eventdate"  /><br />
      		<input type="hidden" name = "path" id="path" value = <%=path%>>
      		<input name="operation" id="operation" value="create" type="hidden">
			<input name="eventid" id="eventid" type="hidden">
      		
      	</form>
		
		
			Preview:  
			<% if (path != null) { %>
			<span style="text-align:center; color:red;">Upload Successful	
			<img class="mySlides" src="<%=path%>" style="width:800px; height:auto; display: block; margin-left: auto; margin-right: auto;"></span>
			<% }
			if( path == null){ %>
				<span><img class="mySlides" src="images/ImageNotAvailable.png" style="width:800px; height:auto; display: block; margin-left: auto; margin-right: auto;"></span>	
			<% } %>
		
		<br /> <input type="submit" value="Submit"  id="submit1" form= "uploadmain"/>		
    </div>
    
    <div class="form">
			<br>
			<table width ="90%" border="1">
				<tr>
					<td align="center">Name</td>
					<td align="center">Description</td>
					<td align="center">Date</td>
					<td align="center">Upload Url</td>
					<td align="center">&nbsp;</td>
					<td align="center">&nbsp;</td>
				</tr>
				<c:forEach items="${requestScope.eventList}" var="event">
					<tr>
						<td> ${event.eventname} </td>
						<td> ${event.eventdescription} </td>
						<td><fmt:formatDate value="${event.eventdate}" pattern="dd-MM-yyyy" /></td>
						<td>${event.uploadurl}</td>
						<td><input class="buttom" name="edit" id="edit" value="Edit!"
							type="button"
							onclick="mod('${event.eventid}','${event.eventname}','${event.eventdescription}','<fmt:formatDate value="${event.eventdate}" pattern="yyyy-MM-dd" />','${event.uploadurl}');"></td>
						<td><input class="buttom" name="delete" id="delete"
							value="Delete!" type="button"
							onclick="del('${event.eventid}');"></td>
					</tr>
				</c:forEach>
			</table>
			<br>
		</div>
    
    </main>
</div>

<jsp:include page="Footer.jsp"></jsp:include>

<jsp:include page="Script.jsp"></jsp:include>

</body>

<SCRIPT type="text/javascript">
    function ValidateFileUpload() {
        var fuData = document.getElementById('fileChooser');
        var FileUploadPath = fuData.value;

//To check if user upload any file
        if (FileUploadPath == '') {
            alert("Please upload an image");

        } else {
            var Extension = FileUploadPath.substring(
                    FileUploadPath.lastIndexOf('.') + 1).toLowerCase();

//The file uploaded is an image

if (Extension == "gif" || Extension == "png" || Extension == "bmp"
                    || Extension == "jpeg" || Extension == "jpg") {

// To Display
                if (fuData.files && fuData.files[0]) {
                    var reader = new FileReader();

                    reader.onload = function(e) {
                        $('#blah').attr('src', e.target.result);
                    }

                    reader.readAsDataURL(fuData.files[0]);
                }

            } 

//The file upload is NOT an image
else {
                alert("Photo only allows file types of GIF, PNG, JPG, JPEG and BMP. ");

            }
        }
    }
</SCRIPT>


</html>

