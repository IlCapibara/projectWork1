<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Academy</title>
<link href="../../webjars/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" />
<script src="../../webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="../../webjars/jquery/3.0.0/js/jquery.min.js"></script>
<script src="http://code.jquery.com/jquery-1.8.3.js"></script>
  <script src="http://code.jquery.com/ui/1.9.2/jquery-ui.js"></script>
<script>
        $(function(){
            $(".date").datepicker();
        });
</script>
<style type="text/css">
	.date{background-color:#ffff;}
</style>
</head>
<body>
    <div class="container">
        <spring:url value="/academies" var="addURL" />
        <h2>Add Academy</h2>
        <!--ModelAttribute=n collegamento tra model e view     -->
        <form:form modelAttribute="academy" method="post" action="${addURL}"
            cssClass="form">
            <form:hidden path="code" />
            <div class="form-group">
                <label>Code</label>
                <form:input path="code" cssClass="form-control" id="code" />
            </div>
            <div class="form-group">
                <label>Title</label>
                <form:input path="title" cssClass="form-control" id="title" />
            </div>
            <div class="form-group">
                <label>Location</label>
                <form:input path="location" cssClass="form-control" id="location" />
            </div>
            <div class="form-group">
                <label>Start Date</label>
                <form:input path="startDate" cssClass="form-control date" id="startDate" />
            </div>
            <div class="form-group">
                <label>End Date</label>
                <form:input path="endDate" cssClass="form-control date" id="endDate" />
            </div>
            <button type="submit" class="btn btn-success">Add or Update Academy</button>
        </form:form>

    </div>
</body>
</html>