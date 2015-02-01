<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Search</title>
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
<script>
	function advanceSearchVisible(){
		
		var adv_tab=document.getElementById("advance_search_tab");
		var expand_coll=document.getElementById("expand_id");
		if(expand_coll.innerHTML=="+"){
			adv_tab.style.display="inline-table";
			expand_coll.innerHTML="-";
		}else{
			adv_tab.style.display="none";
			expand_coll.innerHTML="+";
		}
		
	}
</script>

</head>
<body id="main_body">
	<jsp:include page="../views/header.jsp" />
	<div id="form_container">

		<form:form method="post" action="submitSearchCriteria.html"
			commandName="searchEmployeeForm" cssClass="appnitro">
			<div class="form_description">
				<h2>Search Employees By</h2>
				<p>Please enter search criteria.Only completed profile will be
					searched.</p>
			</div>
			<table class="adv_search_table">
				<tr class="adv_search_tr">
					<td class="adv_search_td">
						<label class="description" for="element_1">OracleId</label>
						<form:input path="oracleId" cssClass="element text medium" maxlength="100" />
					</td>
					<td class="adv_search_td">&nbsp;</td>
				</tr>
				<tr class="adv_search_tr">
					<td class="adv_search_td">
						<label class="description" for="element_1">First Name </label>
						<form:input path="fName" cssClass="element text medium"	maxlength="100" />
					</td>
					<td class="adv_search_td">
						<label class="description" for="element_1">Last Name </label>
						<form:input path="lName" cssClass="element text medium"	maxlength="100" />
					</td>
				</tr>
				
				<tr class="adv_search_tr">
					<td class="adv_search_td">
						<label class="description" for="element_1">Designation </label>
						<form:input path="searchCriteria" cssClass="element text medium" maxlength="100" />
					</td>
					<td class="adv_search_td">
						<label class="description" for="element_1">Skill </label>
						<form:input path="skill" cssClass="element text medium"	maxlength="100" />
					</td>
				</tr>
			</table>
			<br>
			<a href="javascript:advanceSearchVisible()"><font color='#DF0000'size="3px" face="Calibri">Advance Search</font></a>&nbsp;&nbsp;&nbsp;<span id="expand_id" style="color:#3399CC;font-size:25px;">+</span>
			<br>
			<br>
			<table id="advance_search_tab" class="adv_search_table" style='display:none;'>
				<tr class="adv_search_tr">
					<td class="adv_search_td">
						<label class="description" for="element_1">Revenue Group </label>
						<form:input path="revenueGroup" cssClass="element text medium" maxlength="100" />
					</td>
					<td class="adv_search_td">
						<label class="description" for="element_1">Team Name </label>
						<form:input path="teamName" cssClass="element text medium" maxlength="100" />
					</td>
				</tr>
				<tr class="adv_search_tr">
					<td class="adv_search_td">
						<label class="description" for="element_1">Business Focus </label>
						<form:input path="businessFocus" cssClass="element text medium" maxlength="100" />
					</td>
					<td class="adv_search_td">
						<label class="description" for="element_1">BU </label>
						<form:input path="bu" cssClass="element text medium" maxlength="100" />
					</td>
				</tr>
				<tr class="adv_search_tr">
					<td class="adv_search_td">
						<label class="description" for="element_1">Division </label>
						<form:input path="division" cssClass="element text medium" maxlength="100" />
					</td>
					<td class="adv_search_td">
						<label class="description" for="element_1">Home Office </label>
						<form:input path="homeOff" cssClass="element text medium" maxlength="100" />
					</td>
				</tr>
				<tr class="adv_search_tr">
					<td class="adv_search_td">
						<label class="description" for="element_1">Current Office </label>
						<form:input path="currOff" cssClass="element text medium" maxlength="100" />
					</td>
					<td class="adv_search_td">
						<label class="description" for="element_1">Company </label>
						<form:input path="company" cssClass="element text medium" maxlength="100" />
					</td>
				</tr>	
				<tr class="adv_search_tr">
					<td class="adv_search_td">
						<label class="description" for="element_1">Current Region</label>
						<form:input path="currentRegion" cssClass="element text medium"	maxlength="100" />				
						
					</td>
					<td class="adv_search_td">
						<label class="description" for="element_1">Home Region </label>
						<form:input path="homeRegion" cssClass="element text medium" maxlength="100" />
					</td>
				</tr>
				<tr class="adv_search_tr">
					<td class="adv_search_td">
						<label class="description" for="element_1">Person Type </label>
						<form:input path="personType" cssClass="element text medium" maxlength="100" />
					</td>
					<td class="adv_search_td">
						<label class="description" for="element_1">Primary Capability </label>
						<form:input path="primaryCapability" cssClass="element text medium" maxlength="100" />
					</td>
				</tr>	
				<tr class="adv_search_tr">
					<td class="adv_search_td">
						<label class="description" for="element_1">Domain </label>
						<form:input path="domain" cssClass="element text medium" maxlength="100" />
					</td>
					<td class="adv_search_td">
						&nbsp;
					</td>
				</tr>														
			</table>			




				<li class="buttons"><input type="image"
					src="/CVBangaloreSkin/images/button-submit.png" value="Submit"
					alt="Submit" /></li>






				<c:if test="${searchedEmployeeList != null }">
					<div class="form_description" cssClass="appnitro">
						<h2>Search Result</h2>
					</div>
					<table>
						<tr>
							<th>Oracle ID</th>
							<th>First Name</th>
							<th>Designation</th>
							<th>loginId</th>
							<th>Details</th>


						</tr>
						<c:forEach var="searchedEmployee" items="${searchedEmployeeList}"
							varStatus="loopStatus">
							<tr class="${loopStatus.index % 2 == 0 ? 'even' : ''}">
								<td>${searchedEmployee.oracleId}</td>
								<td>${searchedEmployee.firstName}</td>
								<td>${searchedEmployee.designation}</td>
								<td>${searchedEmployee.loginId}</td>




								<td><c:url var="abc" value="resumeDetail.html">
										<c:param name="loginId" value="${searchedEmployee.loginId}">
										</c:param>
									</c:url> <a href="javascript:window.open('${abc}');"> Details </a>
								</td>





							</tr>
						</c:forEach>
					</table>
				</c:if>



		</form:form>
		<jsp:include page="../views/footer.jsp" />
	</div>
</body>
</html>