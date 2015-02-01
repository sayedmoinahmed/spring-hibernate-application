<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Resume Status</title>
<link rel="stylesheet" type="text/css"
	href="/CVBangaloreSkin/styles/view.css" media="all">
<link rel="stylesheet" type="text/css"
	href="/CVBangaloreSkin/styles/menu.css" media="all" />
<link rel="stylesheet" type="text/css"
	href="/CVBangaloreSkin/styles/table.css" media="all">
<style type="text/css">
body,td,th {
	color: #C33;
	font-size: 12px;
}
</style>
</head>
<body id="main_body">
	<jsp:include page="../views/header.jsp" />
	<div class="form_description" align="center">
	     <br/><br/>
		<h2>Resume Status</h2>
		<br/>

		<table>
			<tr>
				<td><h2>Education Summary</h2></td>
				<td><c:choose>

						<c:when
							test="${completionTipsForm.educationDetails eq 'Incomplete'}">

							<a href="educationSummary.html"><h2>${completionTipsForm.educationDetails}</h2></a>
						</c:when>
						<c:otherwise>
								<h2>${completionTipsForm.educationDetails}</h2>
					</c:otherwise>
					</c:choose>
				</td>

			</tr>

			<tr>
			
				<td><h2>Employment Summary</h2></td>
				<td><c:choose>
						<c:when
							test="${completionTipsForm.employmentDetails eq 'Incomplete'}">

							<a href="employmentSummary.html"><h2>${completionTipsForm.employmentDetails}</h2></a>

						</c:when>
						<c:otherwise>
						<h2>${completionTipsForm.employmentDetails}</h2>
					</c:otherwise>
					</c:choose>
				</td>
			<tr>
			
			<tr>

				<td><h2>Project Summary</h2></td>
				<td><c:choose>
						<c:when
							test="${completionTipsForm.projectDetails eq 'Incomplete'}">
							<a href="projectSummary.html"><h2>${completionTipsForm.projectDetails}</h2></a>
						</c:when>
						<c:otherwise>
						<h2>${completionTipsForm.projectDetails}</h2>
					</c:otherwise>
					</c:choose>
				</td>

			</tr>
			
			<tr>

				<td><h2>Profile Summary</h2></td>
				<td><c:choose>
						<c:when
							test="${completionTipsForm.profileSummaryDetails eq 'Incomplete'}">
							<a href="profileSummaryInformation.html"><h2>${completionTipsForm.profileSummaryDetails}</h2></a>
						</c:when>
						<c:otherwise>
						<h2>${completionTipsForm.profileSummaryDetails}</h2>
					</c:otherwise>
					</c:choose>
				</td>

			</tr>
			
			<tr>
			
				<td><h2>Skill Summary</h2></td>
				<td><c:choose>
						<c:when test="${completionTipsForm.skillDetails eq 'Incomplete'}">
							<a href="skillSummary.html"><h2>${completionTipsForm.skillDetails}</h2></a>
						</c:when>
						<c:otherwise>
						<h2>${completionTipsForm.skillDetails}</h2>
					</c:otherwise>
					</c:choose>
				</td>

			</tr>

			
		</table>
		<div align="left">
		<br>
		
		<br><br><br><br><br>
				
	</div>
		<jsp:include page="../views/footer.jsp" />
	</div>
</body>
</html>
