<%@page import="org.sapient.web.form.EmploymentInformationForm"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Employment Information</title>
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
<script>
	function disableReleaveDate(obj) {
		var dt_mn = document.getElementById("element_3_1");
		var dt_dt = document.getElementById("element_3_2");
		var dt_yr = document.getElementById("element_3_3");
		var cal = document.getElementById("cal_img_3");
		if (obj.checked == true) {
			dt_mn.value = null;
			dt_dt.value = null;
			dt_yr.value = null;
			dt_mn.disabled = true;
			dt_dt.disabled = true;
			dt_yr.disabled = true;
			cal.style.visibility = "hidden";
		} else {
			dt_mn.disabled = false;
			dt_dt.disabled = false;
			dt_yr.disabled = false;
			cal.style.visibility = "visible";

		}
	}
</script>
</head>

<body id="main_body">

	<jsp:include page="../views/header.jsp" />
	<div id="form_container">
		<form:form cssClass="appnitro" method="post"
			action="submitEmploymentInformation.html"
			commandName="employmentInformationForm">
			<div class="form_description">
				<h2>Employment Information</h2>
				<p>Please enter Employment Information.</p>
			</div>
			<ul>

				<li id="li_1"><label class="description" for="employerName">
						Employer Name&nbsp;<font color=red size=1>*</font> </label>
					<div>
						<form:hidden path="employmentInfoId" />
						<form:hidden path="userId" />
						<form:input path="employerName" cssClass="element text medium" />
					</div>
					<div>
						<form:errors path="employerName" cssStyle="color: red" />
					</div>
					<p class="guidelines" id="guide_1">
						<small> Please enter the employer name. </small>
					</p>
				</li>
				<li id="li_13"><label class="description" for="element_13">
						Employment Type&nbsp;<font color=red size=1>*</font> </label> <span> <form:radiobutton
							path="employmentType" cssClass="element radio" value="PERMANENT" />
						<label class="choice" for="element_13_1"> Permanent </label> <form:radiobutton
							path="employmentType" cssClass="element radio" value="CONTRACT" />
						<label class="choice" for="element_13_2"> Contractor </label> <form:radiobutton
							path="employmentType" cssClass="element radio" value="TRAINEE" />
						<label class="choice" for="element_13_3"> Trainee </label> </span>
					<p class="guidelines" id="guide_13">
						<small> Please select the Employment Type. </small>
					</p>
				</li>
				<li>
					<div>
						<form:errors path="employmentType" cssStyle="color: red" />
					</div>
				</li>
				<li id="li_2"><label class="description" for="element_2">
						Date of Joining&nbsp;<font color=red size=1>*</font> </label> <span> <form:input
							path="dateOfJoining.month" id="element_2_1"
							cssClass="element text" size="2" maxlength="2" /> / <label
						for="element_2_1"> MM </label> </span> <span> <form:input
							path="dateOfJoining.day" id="element_2_2" cssClass="element text"
							size="2" maxlength="2" /> / <label for="element_2_2"> DD
					</label> </span> <span> <form:input path="dateOfJoining.year"
							id="element_2_3" cssClass="element text" size="4" maxlength="4" />
						<label for="element_2_3"> YYYY </label> </span> <span id="calendar_2">
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
						<small> Please enter Date of joining to the Employer. </small>
					</p>
				</li>
				<li><form:errors path="dateOfJoining" cssStyle="color: red" />
				</li>
				<li id="li_3"><label class="description" for="element_3">
						Date of Relieving&nbsp;<font color=red size=1>*</font> </label> <span> <form:input
							path="dateOfRelieving.month" id="element_3_1"
							cssClass="element text" size="2" maxlength="2" /> / <label
						for="element_3_1"> MM </label> </span> <span> <form:input
							path="dateOfRelieving.day" id="element_3_2"
							cssClass="element text" size="2" maxlength="2" /> / <label
						for="element_3_2"> DD </label> </span> <span> <form:input
							path="dateOfRelieving.year" id="element_3_3"
							cssClass="element text" size="4" maxlength="4" /> <label
						for="element_3_3"> YYYY </label> </span> <span id="calendar_3"> <img
						id="cal_img_3" class="datepicker"
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
				</script> <form:checkbox path="currentEmployer"
						onclick="disableReleaveDate(this)" id="current_emo_chk" />
					Current Employer
					<p class="guidelines" id="guide_3">
						<small> Please enter Date of Relieving from the Employer. </small>
					</p>
				</li>
				<li><form:errors path="dateOfRelieving" cssStyle="color: red" />
				</li>
				<li id="li_4"><label class="description" for="element_4">
						Designation&nbsp;<font color=red size=1>*</font> </label>
					<div>
						<form:input path="designation" cssClass="element text medium" />
					</div>
					<div>
						<form:errors path="designation" cssStyle="color: red" />
					</div>
					<p class="guidelines" id="guide_4">
						<small> Please enter the last Designation hold at the above Employer. </small>
					</p>
				</li>
				<li id="li_5"><label class="description" for="element_5">
						Supervisor Name&nbsp;<font color=red size=1>*</font> </label>
					<div>
						<form:input path="supervisorName" cssClass="element text medium" />
					</div>
					<div>
						<form:errors path="supervisorName" cssStyle="color: red" />
					</div>
					<p class="guidelines" id="guide_5">
						<small> Please enter the name of the last Supervisor of the above Employer. </small>
					</p>
				</li>
				<li id="li_6"><label class="description" for="element_6">
						Employment Address </label>

					<div>
						<form:hidden path="employmentAddress.addressInfoId" />
						<label for="element_6_1"> Street Address </label>
						<form:input path="employmentAddress.streetAddress"
							cssClass="element text large" />
					</div>

					<div>
						<label for="element_6_2"> Address Line 2 </label>
						<form:input path="employmentAddress.addressLine2"
							cssClass="element text large" />
					</div>

					<div class="left">
						<label for="element_6_3"> City&nbsp;<font color=red size=1>*</font> </label>
						<form:input path="employmentAddress.city"
							cssClass="element text medium" />
					</div>

					<div class="right">
						<label for="element_6_4"> State / Province / Region&nbsp;<font color=red size=1>*</font> </label>
						<form:input path="employmentAddress.state"
							cssClass="element text medium" />
					</div>

					<div class="left">
						<label for="element_6_5"> Postal / Zip Code </label>
						<form:input path="employmentAddress.zipCode"
							cssClass="element text medium" />
					</div>

					<div class="right">
						<label for="element_6_6"> Country&nbsp;<font color=red size=1>*</font> </label>
						<form:input path="employmentAddress.country"
							class="element select medium" />
					</div>
					<p class="guidelines" id="guide_6">
						<small> Please enter the employment address . </small>
					</p>
					<div>
						<form:errors path="employmentAddress.city" cssStyle="color : red" />
					</div>
					<div>
						<form:errors path="employmentAddress.state" cssStyle="color : red" />
					</div>
					<div>
						<form:errors path="employmentAddress.zipCode"
							cssStyle="color : red" />
					</div>
					<div>
						<form:errors path="employmentAddress.country"
							cssStyle="color : red" />
					</div>
				</li>
				<li class="buttons"><input type="image"
					src="/CVBangaloreSkin/images/submit_btn.png" value="Submit"
					alt="Submit" />
				</li>
			</ul>
			<script>
				var dt_mn = document.getElementById("element_3_1");
				var dt_dt = document.getElementById("element_3_2");
				var dt_yr = document.getElementById("element_3_3");
				var cal = document.getElementById("cal_img_3");
				var current_emp_chk = document
						.getElementById("current_emo_chk");
				if (dt_mn.value == "" && current_emp_chk.checked == true) {
					dt_mn.disabled = true;
					dt_dt.disabled = true;
					dt_yr.disabled = true;
					cal.style.visibility = "hidden";
				} else {
					dt_mn.disabled = false;
					dt_dt.disabled = false;
					dt_yr.disabled = false;
					cal.style.visibility = "visible";
				}
			</script>
		</form:form>
		<jsp:include page="../views/footer.jsp" />
	</div>
	<!-- <img id="bottom" src="../../CVBangaloreSkin/images/bottom.png" alt="">
 -->
</body>
</html>
