<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Help</title>
	<link rel="stylesheet" type="text/css"
		href="/CVBangaloreSkin/styles/view.css" media="all">
		<link rel="stylesheet" type="text/css"
			href="/CVBangaloreSkin/styles/table.css" media="all">
			<link rel="stylesheet" type="text/css"
				href="/CVBangaloreSkin/styles/menu.css" media="all" />
			<script type="text/javascript" src="/CVBangaloreSkin/scripts/view.js"></script>
			<script type="text/javascript"
				src="/CVBangaloreSkin/scripts/jquery.js"></script>
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

		<form:form method="post" action="submitSearchCriteria.html"
			commandName="searchEmployeeForm" cssClass="appnitro">
			<div class="form_description">
				<h2>Frequently Asked Questions</h2>
				<p>Here are some Frequently Asked Questions and thier Answers to
					use RMS System.</p>
			</div>
			<ul>
				<li id="li_1">
				<label class="description" for="element_1" >
					<font color=#2E2E2E size=3>Ques 1: Data displayed on Home page are incorrect?</font>
				</label>
				<label class="description" for="element_1">
					<font color=#848484 size=3>Ans: Please raise a	helpdesk ticket to update the respective data in Oracle.</font>
				</label> <br>
				<li id="li_1">
				<label class="description" for="element_1">
					<font color=#2E2E2E size=3>Ques 2: How can I know what all fields are mandatory to complete my resume?</font>
				</label>
				<label class="description" for="element_1">
					<font color=#848484 size=3>Ans: Click the "?" mark displayed near "Resume Status" field on home
					page to see what all information is needed to complete the
					resume.</font>
				</label> <br>
				<li id="li_1">
				<label class="description" for="element_1">
					<font color=#2E2E2E size=3>Ques 3: I have filled the Education details still the resume status shows incomplete?</font>
				</label>
				<label class="description" for="element_1">
					<font color=#848484 size=3>Ans: Graduation is a mandatory course type to change the status to complete.</font>
				</label> <br>
				<li id="li_1">
				<label class="description" for="element_1">
					<font color=#2E2E2E size=3>Ques 4: How can I create my resume?</font>
				</label>
				<label class="description" for="element_1">
					<font color=#848484 size=3>Ans: Click on Manage Resume, It will display all the links to create a resume. Click one by one and fill the data in respective pages to complete the resume.</font>
				</label> <br><br><li id="li_1">
				<label class="description" for="element_1">
					<font color=#2E2E2E size=3>Ques 5: Application is not automatically checking the spelling?</font>
				</label>
				<label class="description" for="element_1">
					<font color=#848484 size=3>Ans: After typing the content please click on "Check Spelling" link to check the spelling.</font>
				</label> <br>
				<li id="li_1">
				<label class="description" for="element_1">
					<font color=#2E2E2E size=3>Ques 6: How can I search a resume?</font>
				</label>
				<label class="description" for="element_1">
					<font color=#848484 size=3>Ans: The search menu will be only available to staffing users. They will be able to see Search link between Settings and Help.</font>
				</label> <br>
				<li id="li_1">
				<label class="description" for="element_1">
					<font color=#2E2E2E size=3>Ques 7: How can I make sure that my Resume is sent to the Staffing on selecting the "Mail Resume to staffing"?</font>
				</label>
				<label class="description" for="element_1">
					<font color=#848484 size=3>Ans: On Selecting the check box and after clicking the generate PDF button if you are able to see the generated PDF resume then the resume is sent for staffing successfully.</font>
				</label> <br>
				<li id="li_1">
				<label class="description" for="element_1">
					<font color=#2E2E2E size=3>Ques 8: By clicking Generate resume button I am able to see my resume but On the Home page the Resume status displays "Incomplete" and I am unable to see the Public Profile link?</font>
				</label>
				<label class="description" for="element_1">
					<font color=#848484 size=3>Ans: The minimum criteria to create a resume are that at least Education, Employment and Profile summary should be there, and to change the status to complete follow the Tips next to Resume Status.</font>
				</label> <br>
				<li id="li_1">
				<label class="description" for="element_1">
					<font color=#2E2E2E size=3>Ques 9: My Skill type does not appear in the dropdown?</font>
				</label>
				<label class="description" for="element_1">
					<font color=#848484 size=3>Ans: Please select others from the dropdown and mention the Skill details in Skill Name.</font>
				</label> <br>
			</ul>
		</form:form>
		<jsp:include page="../views/footer.jsp" />
	</div>
	<img id="bottom" src="bottom.png" alt="">
</body>
</html>