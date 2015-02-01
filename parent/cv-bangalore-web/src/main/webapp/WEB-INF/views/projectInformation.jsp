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
<title>Project Information</title>
<title>Profile Summary Information</title>
<link rel="stylesheet" type="text/css"
href="/CVBangaloreSkin/styles/view.css" media="all">
<link rel="stylesheet" type="text/css"
href="/CVBangaloreSkin/styles/menu.css" media="all" />
<script type="text/javascript" src="/CVBangaloreSkin/scripts/view.js"></script>
<script type="text/javascript"
src="/CVBangaloreSkin/scripts/jquery.js"></script>
<script type="text/javascript"
src="/CVBangaloreSkin/scripts/calendar.js"></script>
<script type="text/javascript" src="/CVBangaloreSkin/scripts/menu.js"></script>
<!-- there are six things you need to make AtD work for you, they are: -->

<!-- 1. include jQuery ... naturally none of this works without jQuery -->
<script src="http://code.jquery.com/jquery-1.4.2.js"></script>

<!-- 2. load the atd.textarea.js .. this script makes it easy to attach AtD to a textarea -->
<script src="/CVBangaloreSkin/scripts/jquery.atd.textarea.js"></script>

<!-- 3. this script is a hack that allows cross-domain AJAX -->
<script src="/CVBangaloreSkin/scripts/csshttprequest.js"></script>

<!-- 4. this CSS file contains the style information for highlighted errors -->
<link rel="stylesheet" type="text/css" media="screen" href="/CVBangaloreSkin/styles/atd.css" />

<!-- 6. a function to call when the button is clicked, this function calls into the AtD textarea code -->
<style type="text/css">
body,td,th { color: #C33; font-size: 12px; }
.div_css{width:450px;}
</style>
<script>
function check(){
AtD.checkTextAreaCrossAJAX('textInput', 'checkLink', 'Edit Text');
}
function check1(){
AtD.checkTextAreaCrossAJAX('textInput1', 'checkLink1', 'Edit Text');
}
function check2(){
AtD.checkTextAreaCrossAJAX('textInput2', 'checkLink2', 'Edit Text');
}
function check3(){
AtD.checkTextAreaCrossAJAX('textInput3', 'checkLink3', 'Edit Text');
}
</script>
</head>
<body id="main_body">
<jsp:include page="../views/header.jsp" />
<div id="form_container">

<form:form method="post" action="submitProjectInformation.html"
	commandName="projectInformationForm" cssClass="appnitro">
	<div class="form_description">
		<h2>Project Information</h2>
		<p>Please enter your project information</p>
	</div>
	<ul>

		<li id='li_1'>
			<label class="description" for="element_1">Project Title&nbsp;<font color=red size=1>*</font></label>
			<div class="div_csss">
				<form:hidden path="projectInfoId" />
				<form:input path="title" cssClass="element text medium"
					maxlength="255" />
			</div>
			<div>
				<form:errors path="title" cssStyle="color : red" />
			</div>
			<p class="guidelines" id="guide_1">
				<small> Please enter the project title. </small>
			</p>
		</li>
		<li id='li_1'>
			<div class="div_css">
				<label class="description" for="element_2">Project Description&nbsp;<font color=red size=1>*</font> </label>
					<form:textarea path="description" cssClass="element textarea medium" id="textInput" />
					<p><img src="/CVBangaloreSkin/images/atdbuttontr.gif"><a href="javascript:check()" id="checkLink">Check Spelling</a></p>
			</div>
			<div>
				<form:errors path="description" cssStyle="color : red" />
			</div>
			<p class="guidelines" id="guide_2">
				<small> Please enter the project description. </small>
			</p>
			</li>
		<li id="li_3"><label class="description" for="element_3">
				Project Start Date&nbsp;<font color=red size=1>*</font> </label> 
				<span> <form:input path="startDate.month"
					id="element_3_1" cssStyle="element text" size="2" maxlength="2" />
				/ <label for="element_3_1"> MM </label> 
				</span>
				<span> <form:input
					path="startDate.day" id="element_3_2" cssStyle="element text"
					size="2" maxlength="2" /> / <label for="element_3_2">
					DD </label> </span> 
					
				 <span> <form:input
					path="startDate.year" id="element_3_3" cssStyle="element text"
					size="4" maxlength="4" /> <label for="element_3_3">
					YYYY </label> 
					</span> 
					<span id="calendar_3"> <img id="cal_img_3"
				class="datepicker"
				src="../../CVBangaloreSkin/images/calendar.gif"
				alt="Pick a date.">
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
			<p class="guidelines" id="guide_3">
				<small> Please enter the date when you joined the Project. </small>
			</p></li>
		<li><form:errors path="startDate" cssStyle="color : red" /></li>
		<li id="li_4"><label class="description" for="element_4">
				Project End Date&nbsp;<font color=red size=1>*</font> </label> 
				<span> 
				    <form:input
					path="endDate.month" id="element_4_1" cssStyle="element text"
					size="2" maxlength="2" /> / <label for="element_4_1">
					MM </label>
				 </span>
				<span> 
				    <form:input path="endDate.day"
					id="element_4_2" cssStyle="element text" size="2" maxlength="2" />
				   / <label for="element_4_2"> DD </label> 
				</span> 
				
				<span> <form:input path="endDate.year"
					id="element_4_3" cssStyle="element text" size="4" maxlength="4" />
				<label for="element_4_3"> YYYY </label> 
				</span>
				 <span id="calendar_4">
				<img id="cal_img_4" class="datepicker"
				src="../../CVBangaloreSkin/images/calendar.gif"
				alt="Pick a date.">
		</span> <script type="text/javascript">
			Calendar.setup({
				inputField : "element_4_3",
				baseField : "element_4",
				displayArea : "calendar_4",
				button : "cal_img_4",
				ifFormat : "%B %e, %Y",
				onSelect : selectDate
			});
		</script>
			<p class="guidelines" id="guide_4">
				<small> Please enter the date when you left the project. </small>
			</p></li>
			<li id='li_1'>
		<li><form:errors path="endDate" cssStyle="color : red" /></li>
		<li id='li_1'>
		<label class="description" for="element_5">
				Project Client&nbsp;<font color=red size=1>*</font> </label>
			<div class="div_css">
				<form:input path="client" cssClass="element text medium"
					maxlength="255" />
			</div>
			<div class="div_css">
				<form:errors path="client" cssStyle="color : red" />
			</div>
			<p class="guidelines" id="guide_5">
				<small> Please enter the Client name of the Project. </small>
			</p>
			</li>
			<li id='li_1'>
		<label class="description" for="element_6">
				Project Team Size&nbsp;<font color=red size=1>*</font> </label>
			<div class="div_css">
				<form:input path="size" cssClass="element text medium"
					maxlength="255" />
			</div>
			<div class="div_css">
				<form:errors path="size" cssStyle="color : red" />
			</div>
			<p class="guidelines" id="guide_6">
				<small> Please enter the project team size. </small>
			</p>
			</li>
			<li id='li_1'>
		<label class="description" for="element_7">
				Project Role&nbsp;<font color=red size=1>*</font> </label>
			<div class="div_css">
				<form:textarea path="role" cssClass="element textarea medium" id="textInput1" />
					<p><img src="/CVBangaloreSkin/images/atdbuttontr.gif"><a href="javascript:check1()" id="checkLink1">Check Spelling </a></p>
			</div>
			<div class="div_css">
				<form:errors path="role" cssStyle="color : red" />
			</div>
			<p class="guidelines" id="guide_7">
				<small> Please enter the role you hold in the above project. </small>
			</p>
			</li>
			<li id='li_1'>
		<label class="description" for="element_8">
				Business Values&nbsp;/Responsibilities&nbsp;<font color=red size=1>*</font> </label>
			<div class="div_css">
				<form:textarea path="responsibilities" cssClass="element textarea medium" id="textInput2" />
						<p><img src="/CVBangaloreSkin/images/atdbuttontr.gif"><a href="javascript:check2()" id="checkLink2">Check Spelling </a></p>
			</div>
			<div class="div_css">
				<form:errors path="responsibilities" cssStyle="color : red" />
			</div>
			<p class="guidelines" id="guide_8">
				<small> Please enter your Business Values&nbsp;/Responsibilities&nbsp; in the project. </small>
			</p>
			</li>
			<li id='li_1'>
		<label class="description" for="element_9">
				Key Technologies&nbsp;<font color=red size=1>*</font> </label>
			<div class="div_css">
				<form:textarea path="technologies" cssClass="element textarea medium" id="textInput3" />
			</div>
			<div class="div_css">
				<form:errors path="technologies" cssStyle="color : red" />
			</div>

			<p class="guidelines" id="guide_9">
				<small> Please enter the key technologies you used in the above Project. </small>
			</p>
          </li>

		<li class="buttons"><input type="image"
			src="/CVBangaloreSkin/images/submit_btn.png" value="Submit"
			alt="Submit" /></li>
	</ul>
</form:form>
<jsp:include page="../views/footer.jsp" />
</body>
</html>
