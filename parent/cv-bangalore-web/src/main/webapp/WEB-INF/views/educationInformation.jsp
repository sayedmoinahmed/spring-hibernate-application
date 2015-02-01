<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE 
    html
    PUBLIC
    "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">


<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Education Infomation</title>
<link rel="stylesheet" type="text/css"
	href="/CVBangaloreSkin/styles/view.css" media="all">
<link rel="stylesheet" type="text/css"
	href="/CVBangaloreSkin/styles/menu.css" media="all" />
<script type="text/javascript" src="/CVBangaloreSkin/scripts/view.js"></script>
<script type="text/javascript" src="/CVBangaloreSkin/scripts/jquery.js"></script>
<script type="text/javascript"
	src="/CVBangaloreSkin/scripts/calendar.js"></script>
<script type="text/javascript" src="/CVBangaloreSkin/scripts/menu.js"></script>
<style type="text/css">
body,td,th {
	color: #C33;
	font-size: 12px;
}
</style>

</head>
<body id="main_body">
	<jsp:include page="../views/header.jsp" />
	<div id="form_container">

		<form:form method="post" action="submitEducationInformation.html"
			commandName="educationInformationForm" cssClass="appnitro">
			<div class="form_description">
				<h2>Education Infomation</h2>
				<p>Please enter your Education Infomation.</p>
			</div>
			<ul>

				<li id="li_1"><label class="description" for="Course Type">Course
						Type </label>
					<div>
						<form:hidden path="educationInfoId" />
						<form:select path="selectedCourseType"
							class="element select medium">
							<form:options items="${courseTypeList}" />
						</form:select>
					</div>
					<p class="guidelines" id="guide_1">
						<small>Please select the Course Type .</small>
					</p>
				</li>
				
				<li id="li_1"><label class="description" for="Course Type">Course
						Name </label>
					<div>
						
						<form:select path="selectedCourseName"
							class="element select medium">
							<form:options items="${courseNameList}" />
						</form:select>
					</div>
					<p class="guidelines" id="guide_1">
						<small>Please select the Course Name .</small>
					</p>
				</li>

				
				<li id="li_2"><label class="description" for="element_2">Specialization
				</label>
					<div>
						<form:input path="specialization" cssClass="element text medium"
							maxlength="100" />
					</div>
					<div>
						<form:errors path="specialization" cssStyle="color : red" />
					</div>
					<p class="guidelines" id="guide_1">
						<small>Please enter the Course Specialization .</small>
					</p>
				</li>
				<li id="li_3"><label class="description" for="element_3">Institution
				</label>
					<div>
						<form:input path="institution" cssClass="element text medium"
							maxlength="100" />
					</div>
					<div>
						<form:errors path="institution" cssStyle="color : red" />
					</div>
					<p class="guidelines" id="guide_1">
						<small>Please enter the Institution from which the Course is completed.</small>
					</p>
				</li>
				<li id="li_3"><label class="description" for="element_3">Board/University
				</label>
					<div>
						<form:input path="university" cssClass="element text medium"
							maxlength="100" />
					</div>
					<div>
						<form:errors path="university" cssStyle="color : red" />
					</div>
					<p class="guidelines" id="guide_1">
						<small>Please enter the Board/University from which the Course is completed.</small>
					</p>
				</li>
				<li id="li_2"><label class="description" for="element_2">Date
						of Joining&nbsp;<font color=red size=1>*</font> </label> <span> <form:input
							path="yearOfJoining.month" id="element_2_1" name="element_2_1"
							class="element text" size="2" maxlength="2" value="" type="text" />
						/ <label for="element_2_1">MM</label> </span> <span> <form:input
							path="yearOfJoining.day" id="element_2_2" name="element_2_2"
							class="element text" size="2" maxlength="2" value="" type="text" />
						/ <label for="element_2_2">DD</label> </span> <span> <form:input
							path="yearOfJoining.year" id="element_2_3" name="element_2_3"
							class="element text" size="4" maxlength="4" value="" type="text" />
						<label for="element_2_3">YYYY</label> </span> <span id="calendar_2">
						<img id="cal_img_2" class="datepicker"
						src="../../CVBangaloreSkin/images/calendar.gif" alt="Pick a date.">
				</span> <script type="text/javascript">
					Calendar.setup({
						inputField : "element_2_3",
						baseField : "element_2",
						displayArea : "calendar_2",
						button : "cal_img_2",
						ifFormat : "%B %e, %Y",
						onSelect : selectDate
					});
				</script>
					<p class="guidelines" id="guide_2">
						<small>Enter the Date of Joining to the course.</small>
					</p>
				</li>
				<li><form:errors path="yearOfJoining" cssStyle="color : red" />
				</li>
				<li id="li_3"><label class="description" for="element_2">Date
						of Passing&nbsp;<font color=red size=1>*</font> </label> <span> <form:input
							path="yearOfPassing.month" id="element_3_1" name="element_3_1"
							class="element text" size="2" maxlength="2" value="" type="text" />
						/ <label for="element_3_1">MM</label> </span> <span> <form:input
							path="yearOfPassing.day" id="element_3_2" name="element_3_2"
							class="element text" size="2" maxlength="2" value="" type="text" />
						/ <label for="element_3_2">DD</label> </span> <span> <form:input
							path="yearOfPassing.year" id="element_3_3" name="element_3_3"
							class="element text" size="4" maxlength="4" value="" type="text" />
						<label for="element_3_3">YYYY</label> </span> <span id="calendar_3">
						<img id="cal_img_3" class="datepicker"
						src="../../CVBangaloreSkin/images/calendar.gif" alt="Pick a date.">
				</span> <script type="text/javascript">
					Calendar.setup({
						inputField : "element_3_3",
						baseField : "element_3",
						displayArea : "calendar_3",
						button : "cal_img_3",
						ifFormat : "%B %e, %Y",
						onSelect : selectDate
					});
				</script>
					<p class="guidelines" id="guide_2">
						<small>Enter the Date of Passing of the course.</small>
					</p>
				</li>
				<li><form:errors path="yearOfPassing" cssStyle="color : red" />
				</li>
				<li id="li_6"><label class="description" for="element_6">Aggregate/Percentage&nbsp;<font
						color=red size=1>*</font> </label>
					<div>
						<form:input path="aggregate" cssClass="element text medium"
							maxlength="5" />
					</div>
					<div>
						<form:errors path="aggregate" cssStyle="color : red" />
					</div>
					<p class="guidelines" id="guide_2">
						<small>Please enter Aggregate/Percentage scored in the
							course.</small>
					</p>
				</li>
				<li id="li_6"><label class="description" for="element_6">City&nbsp;<font
						color=red size=1>*</font> </label>
					<div>
						<form:hidden path="educationAddress.addressInfoId" />
						<form:input path="educationAddress.city"
							cssClass="element text medium" maxlength="60" />
					</div>
					<div>
						<form:errors path="educationAddress.city" cssStyle="color : red" />
					</div>
					<p class="guidelines" id="guide_2">
						<small>Please enter City where you completed this 
							course.</small>
					</p>
				</li>
				<span class="buttons"> <input type="image"
					src="/CVBangaloreSkin/images/button-submit.png" value="Submit"
					alt="Submit" /> </span>

			</ul>
		</form:form>
		<jsp:include page="../views/footer.jsp" />
	</div>

</body>
</html>