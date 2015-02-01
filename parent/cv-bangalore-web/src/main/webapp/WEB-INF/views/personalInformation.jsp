<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE 
html
PUBLIC
"-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">


<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>
			Personal Information
		</title>
		<link rel="stylesheet" type="text/css" href="/CVBangaloreSkin/styles/view.css" media="all">
		<link rel="stylesheet" type="text/css" href="/CVBangaloreSkin/styles/menu.css" media="all"/>
		<script type="text/javascript" src="/CVBangaloreSkin/scripts/view.js"></script>
		<script type="text/javascript" src="/CVBangaloreSkin/scripts/calendar.js"></script>
		<script type="text/javascript" src="/CVBangaloreSkin/scripts/jquery.js"></script>
		<script type="text/javascript" src="/CVBangaloreSkin/scripts/menu.js"></script>
		<style type="text/css">
			body,td,th { color: #C33; font-size: 12px; }
		</style>
	</head>
	<body id="main_body">
		<jsp:include page="../views/header.jsp" />
		<div id="form_container">
			<form:form 
				action="submitPersonalInformation.html"
				commandName="personalInformationForm"
				cssClass="appnitro"
				method="POST">
					<div class="form_description">
						<h2>
							Personal Information
						</h2>
					<p>
						Please enter your Personal Information here
					</p>
					</div>
					<table align="left" border="0">
						<tr>
							<form:hidden path="id" />
							<td class="description">Oracle Id</td>
							<td style="color:black;font-size:10px;font-weight:700" >&nbsp;:&nbsp;&nbsp;</td>
							<td class="personal_info_rslt">${personalInformationForm.oracleId}</td>
						</tr>
						<tr>
							<td class="description">NT Login</td>
							<td style="color:black;font-size:10px;font-weight:700">&nbsp;:&nbsp;&nbsp;</td>
							<td class="personal_info_rslt">${personalInformationForm.loginId}</td>
						</tr>
						<tr>
							<td class="description">First Name</td>
							<td style="color:black;font-size:10px;font-weight:700">&nbsp;:&nbsp;&nbsp;</td>
							<td class="personal_info_rslt">${personalInformationForm.firstName}</td>
						</tr>  
						<tr>
							<td class="description">Middle Name</td>
							<td style="color:black;font-size:10px;font-weight:700">&nbsp;:&nbsp;&nbsp;</td>
							<td class="personal_info_rslt">${personalInformationForm.middleName}</td>
						</tr>
						<tr>
							<td class="description">Last Name</td>
							<td style="color:black;font-size:10px;font-weight:700">&nbsp;:&nbsp;&nbsp;</td>
							<td class="personal_info_rslt">${personalInformationForm.lastName}</td>
						</tr> 
						<tr>
							<td class="description">Father Name</td>
							<td style="color:black;font-size:10px;font-weight:700">&nbsp;:&nbsp;&nbsp;</td>
							<td class="personal_info_rslt">${personalInformationForm.fatherName}</td>
						</tr> 
						<tr>
							<td class="description">Date of Birth</td>
							<td style="color:black;font-size:10px;font-weight:700">&nbsp;:&nbsp;&nbsp;</td>
								<td class="personal_info_rslt">${personalInformationForm.dateOfBirth.month}&nbsp;/&nbsp;${personalInformationForm.dateOfBirth.day}&nbsp;/&nbsp;${personalInformationForm.dateOfBirth.year}<br><span style="color:black;font-size:10px;">MM&nbsp;DD&nbsp;YYYY</span>
								</td>
						</tr> 
						<tr>
							<td class="description"> Date of Joining</td>
							<td style="color:black;font-size:10px;font-weight:700">&nbsp;:&nbsp;&nbsp;</td>
								<td class="personal_info_rslt">${personalInformationForm.dateOfJoining.month}&nbsp;/&nbsp;${personalInformationForm.dateOfJoining.day}&nbsp;/&nbsp;${personalInformationForm.dateOfJoining.year}<br><span style="color:black;font-size:10px;">MM&nbsp;DD&nbsp;YYYY</span>
							</td>
						</tr> 
						<tr>
							<td class="description">Person Type</td>
							<td style="color:black;font-size:10px;font-weight:700">&nbsp;:&nbsp;&nbsp;</td>
							<td class="personal_info_rslt">
								<form:radiobutton path="personType" cssClass="element radio" disabled="true" value="PERMANENT" /><label class="choice" for="element_13_1">Sapient Staff</label>
								<form:radiobutton path="personType" cssClass="element radio" disabled="true" value="CONTRACT" /><label class="choice" for="element_13_2">Contractor</label> 
								<form:radiobutton path="personType" cssClass="element radio" disabled="true" value="TRAINEE" /><label class="choice" for="element_13_3">Trainee</label>         						       						
							</td>
						</tr> 
						<tr>
							<td class="description">Designation</td>
							<td style="color:black;font-size:10px;font-weight:700">&nbsp;:&nbsp;&nbsp;</td>
							<td class="personal_info_rslt">${personalInformationForm.designation}</td>
						</tr>        		        		       		       		        		       		        		       		        		
					</table>
					<ul>
						<li class="buttons">
						<input type="image" src="/CVBangaloreSkin/images/continue_btn.png" value="Submit" alt="Continue" />
						</li>
					</ul>
			</form:form>
			<jsp:include page="../views/footer.jsp" />	
		</div>
	</body>
</html>
