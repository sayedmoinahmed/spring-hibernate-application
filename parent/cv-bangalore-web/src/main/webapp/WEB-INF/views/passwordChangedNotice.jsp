<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Password Changed</title>
	<link rel="stylesheet" type="text/css" href="/CVBangaloreSkin/styles/view.css" media="all">
	<link rel="stylesheet" type="text/css" href="/CVBangaloreSkin/styles/menu.css" media="all"/>
		 <link rel="stylesheet" type="text/css" href="/CVBangaloreSkin/styles/table.css" media="all">
	<script type="text/javascript" src="/CVBangaloreSkin/scripts/view.js"></script>
	<script type="text/javascript" src="/CVBangaloreSkin/scripts/jquery.js"></script>
	<script type="text/javascript" src="/CVBangaloreSkin/scripts/menu.js"></script>
    <style type="text/css">
      body,td,th { color: #C33; font-size: 12px; }
    </style>

</head>
<body id="main_body">
<jsp:include page="../views/logoutHeader.jsp" />
	<div id="form_container">
	<br><br><br>

		<h2>Your password has been updated.Please try with your new password.</h2>
		<br><br>
		<div align="left">
			<a href="login.html">Login Again</a>  
		</div>
		<br><br>
		<jsp:include page="../views/footer.jsp" />
	</div>
</body>
</html>