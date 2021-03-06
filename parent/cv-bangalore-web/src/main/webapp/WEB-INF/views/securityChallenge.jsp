<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update Security Information Summary</title>
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

</head>
<body id="main_body">
	<jsp:include page="../views/logoutHeader.jsp" />
	<div id="form_container">

		<form:form cssClass="appnitro" method="post"
			action="submitSecurityQuestionAndAnswer.html"
			commandName="resetPasswordForm">

			<div class="form_description">
				<h2>Security Challenge</h2>
				<p>Please enter your Information.</p>
			</div>

			<li id="li_1"><label class="description" for="password">
					${resetPasswordForm.securityQuestion} </label>
				<div>

					<%--${securityQuestionVO.description} --%>
				</div>

				<p class="guidelines" id="guide_1">
					<small> Security Question. </small>
				</p>
			</li>

			<li id="li_13"><label class="description" for="element_13">
					Security Answer&nbsp;<font color=red size=1>*</font> </label>
				<div>
					<form:password path="answer" cssClass="element text medium" />
				</div>
				<div>
					<form:errors path="answer" cssStyle="color: red" />
				</div>
				<p class="guidelines" id="guide_4">
					<small> Please enter your answer. </small>
				</p>
			</li>
			<li class="buttons"><input type="image"
				src="/CVBangaloreSkin/images/submit_btn.png" value="Submit"
				alt="Submit" />
			</li>
		</form:form>
		<jsp:include page="../views/footer.jsp" />
	</div>
</body>
</html>