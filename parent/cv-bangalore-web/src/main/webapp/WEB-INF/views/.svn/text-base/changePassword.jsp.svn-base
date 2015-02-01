<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>
      Change Password Information
    </title>
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
   <jsp:include page="../views/header.jsp" /> 
    <div id="form_container">

      <form:form 
          cssClass="appnitro"
          method="post"
          action="submitChangePassword.html"
          commandName="changePasswordForm">
		
			<div class="form_description">
          <h2>
            Change Password Information
          </h2>
          <p>
            Please change your password.
          </p>
        </div>
        
        <li id="li_1" >
          <label class="description" for="password">
            Enter Current Password&nbsp;<font color=red size=1>*</font>
          </label>
          <div>
             <form:password path = "currentPassword" cssClass="element text medium"/>
          </div>
          <div>
            <form:errors path="currentPassword" cssStyle="color: red"/>
          </div>
          
          <p class="guidelines" id="guide_4">
    		<small>
      			Please enter Current Password.
    		</small>
  		</p>
        </li>
        
        <li id="li_13">
        <label class="description" for="element_13">
          Enter New Password&nbsp;<font color=red size=1>*</font>
        </label>
         <div>
         	<form:hidden path="userId"/>
         	<form:hidden path="loginId"/>
         	<form:hidden path="originalAnswer"/>
         	<form:hidden path="securityQuestion"/>
    		<form:password path = "newPassword" cssClass="element text medium" />
  		</div> 
  		<div>
    		<form:errors path="newPassword" cssStyle="color: red"/>
  		</div>
  		<p class="guidelines" id="guide_4">
    		<small>
      			New password must contain a number, a special symbol, a lowercase & uppercase character and must be between 8 to 20 character long.
    		</small>
  		</p>
		</li>
		
		<li id="li_14">
        <label class="description" for="element_13">
          Confirm new password&nbsp;<font color=red size=1>*</font>
        </label>
         <div>
    		<form:password path = "confirmPassword" cssClass="element text medium" />
  		</div> 
  		<div>
    		<form:errors path="confirmPassword" cssStyle="color: red"/>
  		</div>
  		<p class="guidelines" id="guide_4">
    		<small>
      			Please enter new password to confirm.
    		</small>
  		</p>
		</li>
		
		<li id="li_5" >
		<label class="description" for="element_5">
  			Security Question
		</label>
		<div>
		
		
		${changePasswordForm.securityQuestion}
		</div>
		
		<p class="guidelines" id="guide_5">
  			<small>
    			Please enter the Security Question;
  			</small>
		</p>
		</li>
        
        <li id="li_5" >
		<label class="description" for="element_5">
  			Security Answer&nbsp;<font color=red size=1>*</font>
		</label>
		<div>
  			<form:password path = "securityAnswer" cssClass="element text medium" />
		</div>
		<div>
  			<form:errors path="securityAnswer" cssStyle="color: red"/>
		</div>
		<p class="guidelines" id="guide_5">
  			<small>
    			Please enter the Security Answer
  			</small>
		</p>
		</li>
		
        <li class="buttons">
			<input type="image" src="/CVBangaloreSkin/images/submit_btn.png" value="Submit" alt="Submit"/>
		</li>
      </form:form>
     <jsp:include page="../views/footer.jsp" />
    </div>
  </body>
</html>