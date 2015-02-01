<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Resume Management System - A Sapient Approach..!!! </title>
<link rel="stylesheet" type="text/css"
	href="/CVBangaloreSkin/styles/view.css" media="all">
<script type="text/javascript" src="/CVBangaloreSkin/scripts/view.js">
    </script>
<style>
body,td,th {
	color: #C33;
	font-size: 12px;
}

.roundedcornr_box_316279 {
	background: #ffffff
		url(/CVBangaloreSkin/images/roundedcornr_316279_grad.gif) repeat-x top
		left;
}

.roundedcornr_top_316279 div {
	background: url(/CVBangaloreSkin/images/roundedcornr_316279_tl.gif)
		no-repeat top left;
}

.roundedcornr_top_316279 {
	background: transparent
		url(/CVBangaloreSkin/images/roundedcornr_316279_tr.gif) no-repeat top
		right;
}

.roundedcornr_bottom_316279 div {
	background: url(/CVBangaloreSkin/images/roundedcornr_316279_bl.gif)
		no-repeat bottom left;
}

.roundedcornr_bottom_316279 {
	background: transparent
		url(/CVBangaloreSkin/images/roundedcornr_316279_br.gif) no-repeat
		bottom right;
}

.roundedcornr_top_316279 div,.roundedcornr_top_316279,.roundedcornr_bottom_316279 div,.roundedcornr_bottom_316279
	{
	width: 100%;
	height: 30px;
	font-size: 1px;
}

.roundedcornr_content_316279 {
	margin: 0 30px;
}

.style1 {
	font-family: "Bella Donna", Berylium, Biondi
}

#footer {
	width: 640px;
	clear: both;
	color: #C33;
	text-align: center;
	width: 640px;
	padding-bottom: 15px;
	font-size: 85%;
	left: 48px;
	top: 442px;
	position: absolute;
}

#footer a {
	color: #FFFFFF;
	text-decoration: none;
	border-bottom: 1px dotted #999999;
}

.footer {
	width: 640px;
	clear: both;
	color: #C33;
	text-align: center;
	padding-bottom: 15px;
	font-size: 85%;
	left: 280px;
	top: 700px;
	position: absolute;
}
</style>
</head>
<body id="main_body"
	onload="document.getElementById('login_id_txt').focus();">


	<p>
		<img src="/CVBangaloreSkin/images/header.jpg" height="114"
			align="left" />
	</p>
	<div id="form_container"
		style="width: 432px; position: absolute; left: 290px; top: 172px; height: 250px;">

		<form:form method="post" action="login.html" commandName="loginForm"
			cssClass="appnitro">
			<div class="roundedcornr_box_316279">
				<div class="roundedcornr_top_316279">
					<div>
						<div align="center"></div>
					</div>
				</div>
				<div class="roundedcornr_content_316279">
					<div align="center">
						<br />
					</div>
					<br /> <br />
					<div align="left">
						<br />
						<div>
							<label
								style="font-family: Calibri; font: Calibri; font-size: 95%; font-weight: 600; color: #222;">
								&nbsp;&nbsp;Login&nbsp;Id&nbsp;<font color=red size=1>*</font>&nbsp;&nbsp;&nbsp;&nbsp;
							</label>
							<form:input path="userName" cssClass="element textarea medium"
								id="login_id_txt" />
						</div>
						<label> <form:errors path="userName"
								cssStyle="color : red" /> </label> <br />
						<div>
							<label
								style="font-family: Calibri; font: Calibri; font-size: 95%; font-weight: 600; color: #222;">
								&nbsp;Password&nbsp;<font color=red size=1>*</font>&nbsp;&nbsp;
							</label>
							<form:password path="password" cssClass="element textarea medium" />
						</div>
						<label> <form:errors path="password"
								cssStyle="color : red" /> </label>
					</div>
					<br /> <input type="image"
						src="/CVBangaloreSkin/images/login_btn.png" width="145"
						height="45" border="0" align="right" value="Submit" alt="Submit" />

					</a>
					</p>
					<p>&nbsp;</p>
					<p align="left">
						<a href="renderDefaultPage.html">Forgot your password?</a>
					<p>
				</div>
				<div class="roundedcornr_bottom_316279"
					style="background-color: #FF3300">
					<div>
						<div align="right"></div>
					</div>
				</div>
			</div>
	</div>

	</form:form>
	<jsp:include page="../views/footer.jsp" />

	<blockquote>
		<p>
			<img
				src="/CVBangaloreSkin/images/paper_clip_attached_two_sticky_notes_md_wm.jpg"
				height="313" />
		</p>
	</blockquote>
</body>
</html>
