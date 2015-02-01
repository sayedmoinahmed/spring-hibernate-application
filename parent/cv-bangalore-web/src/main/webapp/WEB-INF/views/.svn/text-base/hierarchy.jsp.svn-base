<%@page pageEncoding="Cp1252" contentType="text/html; charset=Cp1252"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=Cp1252" />
<title>Resume Management System</title>
<link rel="stylesheet" type="text/css"
	href="/CVBangaloreSkin/styles/view.css" media="all">
<link rel="stylesheet" type="text/css"
	href="/CVBangaloreSkin/styles/combo.css" media="all">
<link rel="stylesheet" type="text/css"
	href="/CVBangaloreSkin/styles/menu.css" media="all" />
<link rel="stylesheet" type="text/css"
	href="/CVBangaloreSkin/styles/table.css" media="all">
<script type="text/javascript" src="/CVBangaloreSkin/scripts/view.js"></script>
<script type="text/javascript" src="/CVBangaloreSkin/scripts/jquery.js"></script>
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
	font-weight: 200;
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
<body>
<body id="main_body">
	<jsp:include page="../views/header.jsp" />
	<div id="form_container" style="height: 600px">
		<!-- <div class="roundedcornr_bottom_316279" style="background-color:#FF3300"> -->
		<div align="left">
			<br /> <br /> <br />
		</div>
		<h2>${accountCenterForm.firstName} ${accountCenterForm.lastName}</h2>
		<div align="left" style="width: 100%; overflow: auto; height: 300px;">
			<table>
				<tr>
					<th>Name of Subordinate</th>
					<th>Oracle Id</th>
					<th>Designation</th>
				</tr>
				<c:forEach var="subordinateList" items="${listOfSubordinates}"
					varStatus="loopStatus">
					<tr class="${loopStatus.index % 2 == 0 ? 'even' : ''}">
						<td><c:url var="link" value="resumeOfSubordinate.html">
								<c:param name="loginId" value="${subordinateList.loginId}">
								</c:param>
							</c:url>
							<left>
								<a href="${link}">${subordinateList.firstName}
									${subordinateList.lastName} 
							</left> </a>
						</td>
						<td><left>${subordinateList.oracleId}</left></td>
						<td><left>${subordinateList.designation}</left></td>
					</tr>
				</c:forEach>
			</table>
			Total ${accountCenterForm.size}&nbspSubordinates found
		</div>
	</div>
	</div>
	<div align="left"></div>
	<jsp:include page="../views/footer.jsp" />
</body>
</html>
