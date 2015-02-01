<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
	<title>Welcome To RMS Home</title>
	<link rel="stylesheet" type="text/css"
		href="/CVBangaloreSkin/styles/view.css" media="all">
		<link rel="stylesheet" type="text/css"
			href="/CVBangaloreSkin/styles/menu.css" media="all" />
		<script type="text/javascript" src="/CVBangaloreSkin/scripts/view.js"></script>
		<script type="text/javascript"
			src="/CVBangaloreSkin/scripts/calendar.js"></script>
		<script type="text/javascript"
			src="/CVBangaloreSkin/scripts/jquery.js"></script>
		<script type="text/javascript" src="/CVBangaloreSkin/scripts/combo.js"></script>
		<script type="text/javascript" src="/CVBangaloreSkin/scripts/menu.js"></script>
		<style type="text/css">
body,td,th {
	color: #C33;
	font-size: 12px;
}
</style>

		<style>
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

#footer a {
	color: #FFFFFF;
	text-decoration: none;
	border-bottom: 1px dotted #999999;
}

.home_font {
	font-family: Calibri;
	font: Calibri;
	font-size: 16px;
	font-stretch: condensed;
	color: #666
}
</style>
		<style type="text/css">

/*Credits: Dynamic Drive CSS Library */
/*URL: http://www.dynamicdrive.com/style/ */
#ddblueblockmenu {
	border: 1px solid black;
	border-bottom-width: 1px solid black;
	width: 185px;
}

#ddblueblockmenu ul {
	margin: 0;
	padding: 0;
	list-style-type: none;
	font: normal 90% 'Trebuchet MS', 'Lucida Grande', Arial, sans-serif;
}

#ddblueblockmenu li a {
	display: block;
	padding: 3px 0;
	padding-left: 1px;
	width: 185px; /*185px minus all left/right paddings and margins*/
	text-decoration: none;
	color: black;
	background-color: white;
	border-bottom: 1px solid #F04E22;
	border-left: 5px solid #F04E22;
}

#ddblueblockmenu li img {
	width: 23px; /*185px minus all left/right paddings and margins*/
}

* html #ddblueblockmenu li a { /*IE only */
	width: 185px; /*IE 5*/
	w\idth: 185px; /*185px minus all left/right paddings and margins*/
}

#ddblueblockmenu li a:hover {
	background-color: #2586d7;
	border-left-color: #1c64d1;
}

#ddblueblockmenu div.menutitle {
	color: white;
	border-bottom: 1px solid black;
	padding: 1px 0;
	padding-left: 5px;
	width: 210px;
	background-color: #646D7E;
	font: bold 90% 'Trebuchet MS', 'Lucida Grande', Arial, sans-serif;
}
</style>
</head>
<body id="main_body">
	<jsp:include page="../views/header.jsp" />
	<div id="form_container" style="height: 655px">

		<form:form action="home.html" commandName="accountCenterForm"
			cssClass="appnitro" method="GET">

			<div
				style="width: 620px; position: relative; left: 1%; top: 25%; height: 550px;">
				<h2>
					&nbsp;&nbsp;Welcome ${accountCenterForm.firstName}
					<c:if test="${accountCenterForm.isSubordinate eq 'true'}">
						<a href="hierarchy.html"><img
						src="/CVBangaloreSkin/images/sub_ordinates_image.png"
						title="List of ${accountCenterForm.firstName}'s Subordinates"
						height='28px' align='middle'></img></a>
					<img
						src="/CVBangaloreSkin/images/Subordinate_Arrow.png" height='28px'
						align='middle' >
					</c:if>
					<font size=2>${haveSubordinate}</font>
				</h2>
				${noSubordinate} <br /> <br />

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
						<div align="left" style="width: auto">
							<br /> <br />
							<table border="0" align="center" cellspacing="5">
								<tr>
									<td nowrap align="left" class="home_font" for="element_1"><b>Name</b>
									</td>
									<td width="10%">&nbsp;</td>
									<td nowrap align="left" class="home_font">&nbsp;&nbsp;&nbsp;${accountCenterForm.firstName}&nbsp;${accountCenterForm.middleName}&nbsp;${accountCenterForm.lastName}</td>
								</tr>
								<tr>
									<td nowrap align="left" class="home_font" for="element_1"><b>Designation</b>
									</td>
									<td>&nbsp;</td>
									<td nowrap align="left" class="home_font">&nbsp;&nbsp;&nbsp;${accountCenterForm.designation}</td>
								</tr>
								<tr>
									<td nowrap align="left" class="home_font" for="element_1"><b>Person
											Type</b>
									</td>
									<td>&nbsp;</td>
									<td nowrap align="left" class="home_font">&nbsp;&nbsp;&nbsp;${accountCenterForm.personType}</td>
								</tr>
								<tr>
									<td nowrap align="left" class="home_font" for="element_1"><b>Supervisor
											Name</b>
									</td>
									<td>&nbsp;</td>
									<td nowrap align="left" class="home_font">&nbsp;&nbsp;&nbsp;${accountCenterForm.supervisorName}</td>
								</tr>
								<tr>
									<td align="left" class="home_font" for="element_1"><b>Oracle
											Id</b>
									</td>
									<td>&nbsp;</td>
									<td nowrap align="left" class="home_font">&nbsp;&nbsp;&nbsp;${accountCenterForm.oracleId}</td>
								</tr>
								<tr>
									<td align="left" class="home_font" for="element_1"><b>Date
											of Joining</b>
									</td>
									<td>&nbsp;</td>
									<td nowrap align="left" class="home_font">&nbsp;&nbsp;&nbsp;${accountCenterForm.dateOfJoining}</
									
								</tr>
								<tr>
									<td align="left" class="home_font" for="element_1"><b>Resume
											Status</b>
									</td>
									<td>&nbsp;</td>
									<td nowrap align="left" class="home_font">&nbsp;&nbsp;&nbsp;${accountCenterForm.resumeStatus}&nbsp;&nbsp;&nbsp;&nbsp;
										<c:if test="${accountCenterForm.resumeStatus eq 'Complete'}">
											<c:url var="link" value="generateResume">
												<c:param name="ref"
													value="${accountCenterForm.encryptedLoginName}">
												</c:param>
											</c:url>
											<a href="javascript:window.open('${link}');"><img
												src="/CVBangaloreSkin/images/PDF-logoBIG.gif" height='28px'
												align='middle'>
											</a>
										</c:if> <c:if
											test="${accountCenterForm.resumeStatus eq 'Incomplete'}">
											<a href="resumeStatus.html"><img
												src="/CVBangaloreSkin/images/help_icon.jpg" height='28px'
												align='middle'>
											</a>
										</c:if>
									</td>



									<td></td>
								</tr>
								<%-- <tr>
									<td nowrap align="left" width="25%" class="home_font"
										for="element_1"><b>Login TimeStamp</b>
									</td>
									<td>&nbsp;</td>
									<td nowrap align="left" class="home_font">&nbsp;&nbsp;&nbsp;${accountCenterForm.loginTimeStamp}</td>
								</tr> --%>
							</table>
							<br />
						</div>
					</div>
					<div class="roundedcornr_bottom_316279"
						style="background-color: #FF3300">
						<div>
							<div align="left"></div>
						</div>
					</div>
				</div>
				<br />

				<c:if test="${accountCenterForm.resumeStatus eq 'Complete'}">

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
							<div align="left" style="width: auto">
								<br /> <br />
								<h2>
									&nbsp;&nbsp;Your public profile Is One Click Away &nbsp;&nbsp;<img
										src="/CVBangaloreSkin/images/down-icon.png" height='30px'
										align='middle'>
								</h2>
								<br />
								<p class="home_font">http://localhost:8080/CVBangaloreWeb/action/generateResume?ref=${accountCenterForm.encryptedLoginName}</p>
								<br /> <br />
							</div>
						</div>
						<div class="roundedcornr_bottom_316279"
							style="background-color: #FF3300">
							<div>
								<div align="left"></div>
							</div>
						</div>
					</div>
				</c:if>
				<input type="hidden" id="hirarchey_str" value="CLOSE" />
		</form:form>
	</div>
	<br />
	<br />
	<br />
	<jsp:include page="../views/footer.jsp" />
	<!-- <img id="bottom" src="/CVBangaloreSkin/images/bottom.png" alt="">-->
</body>
</html>