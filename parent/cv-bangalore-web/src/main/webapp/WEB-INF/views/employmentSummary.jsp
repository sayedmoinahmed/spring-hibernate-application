<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Employment Summary</title>
<link rel="stylesheet" type="text/css"
	href="/CVBangaloreSkin/styles/view.css" media="all">
<link rel="stylesheet" type="text/css"
	href="/CVBangaloreSkin/styles/menu.css" media="all" />
<link rel="stylesheet" type="text/css"
	href="/CVBangaloreSkin/styles/table.css" media="all">
<script type="text/javascript" src="/CVBangaloreSkin/scripts/view.js"></script>
<script type="text/javascript" src="/CVBangaloreSkin/scripts/jquery.js"></script>
<script type="text/javascript" src="/CVBangaloreSkin/scripts/menu.js"></script>
<style type="text/css">
body,td,th {
	color: #C33;
	font-size: 12px;
}
</style>
<script language="javascript">
function confirmDelete(){    return confirm("Are you sure to delete this entry?");}
</script>
</head>
<body id="main_body">
 <jsp:include page="../views/header.jsp" />
	<div id="form_container">
		<form:form method="post" action="addNewEmployment.html"
			cssClass="appnitro">
			<div class="form_description">
				<h2>Employment Summary</h2>
			</div>
			<c:if test="${employmentSummaryList != null }">
				<table>
					<tr>
						<th>Employer Name</th>
						<th>Designation</th>
						<th>Employment Type</th>
						<th>Date of Joining</th>
						<th>Date of Relieving</th>
						<th>Details</th>
						<th>Delete</th>
						
					</tr>
					<c:forEach var="employmentSummary" items="${employmentSummaryList}"
						varStatus="loopStatus">
						<tr class="${loopStatus.index % 2 == 0 ? 'even' : ''}">
							<td>${employmentSummary.employerName}</td>
							<td>${employmentSummary.designation}</td>
							<td>${employmentSummary.employmentType}</td>
							<td>${employmentSummary.dateOfJoining}</td>
							<td>${employmentSummary.dateOfRelieving}</td>
							<td><c:url var="retrieveEmploymentInformationById"
									value="retrieveEmploymentInformationById.html">
									<c:param name="employmentInfoId"
										value="${employmentSummary.employmentInfoId}">
									</c:param>
								</c:url> <a href="${retrieveEmploymentInformationById}"> Details </a>
							</td>
							<td>
							<c:url var="removeEmploymentDetail" value="removeEmploymentDetail.html" >
							<c:param name="employmentInfoId" value="${employmentSummary.employmentInfoId}"></c:param>
							</c:url>
							<a href="${removeEmploymentDetail}" onclick="return confirmDelete()";>
							<img src="/CVBangaloreSkin/images/delete-icon.png" height='25px' align='middle'>
							</a>
							</td>
						</tr>
					</c:forEach>
				</table>
			</c:if>
			<span class="buttons"> 
				<input type="image" src="/CVBangaloreSkin/images/button-add.png" value="Submit" alt="Submit"/>
				<a href="/CVBangaloreWeb/action/projectSummary.html"><image src="/CVBangaloreSkin/images/continue_btn.png" alt="Continue"/></a>
			</span>
		</form:form>
		<jsp:include page="../views/footer.jsp" />	
	</div>
</body>
</html>
