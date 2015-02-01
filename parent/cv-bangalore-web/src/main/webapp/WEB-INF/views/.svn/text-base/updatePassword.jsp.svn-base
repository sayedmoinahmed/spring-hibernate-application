<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>
      Update Security Information Summary
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
  <jsp:include page="../views/logoutHeader.jsp" />
    <div id="form_container">

      <form:form 
          cssClass="appnitro"
          method="post"
          action="updatePassword.html"
          commandName="passwordUpdateForm">
		
			<div class="form_description">
          <h2>
            Update Password Information
          </h2>
          <p>
            Please enter new Password Information.
          </p>
        </div>
        
        <li id="li_1" >
          <label class="description" for="password">
            Enter New Password&nbsp;<font color=red size=1>*</font>
          </label>
          <div>
             <form:password path = "password" cssClass="element text medium"/>
          </div>
          <div>
            <form:errors path="password" cssStyle="color: red"/>
          </div>
          
          <p class="guidelines" id="guide_1">
            <small>
      			New password must contain a number, a special symbol, a lowercase & uppercase character and must be between 8 to 20 character long.
    		</small>
          </p>
        </li>
        
        <li id="li_13">
        <label class="description" for="element_13">
          Confirm new password&nbsp;<font color=red size=1>*</font>
        </label>
         <div>
    		<form:password path = "newPassword" cssClass="element text medium" />
  		</div> 
  		<div>
    		<form:errors path="newPassword" cssStyle="color: red"/>
  		</div>
  		<p class="guidelines" id="guide_4">
    		<small>
      			Please enter new Password to confirm.
    		</small>
  		</p>
		</li>
		
		<li id="li_5" >
		<label class="description" for="element_5">
  			Security Questions
		</label>
		<div>
		
		
		<form:select path="securityQuestionId">
		<c:forEach var="securityQuestionVO" items="${securityQuestionList}">
                <form:option value="${securityQuestionVO.questionId}">
                  ${securityQuestionVO.description}
                </form:option>
              </c:forEach>
  		</form:select>
		</div>
		<%-- <div>
  			<form:errors path="securityQuestion" cssStyle="color: red"/>
		</div> --%>
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
  			<form:password path = "answer" cssClass="element text medium" />
		</div>
		<div>
  			<form:errors path="answer" cssStyle="color: red"/>
		</div>
		<p class="guidelines" id="guide_5">
  			<small>
    			Please enter the Answer
  			</small>
		</p>
		</li>
        <li class="buttons">
			<input type="image" src="/CVBangaloreSkin/images/submit_btn.png" value="Submit" alt="Submit"/>
		</li>
        
			<!-- <table>
			<tr><td>Enter New Password</td><td><input type="text"></td></tr>
			<tr><td>Confirm New Password</td><td><input type="text"></td></tr>
			<tr><td>Select Security Question</td><td><input type="text"></td></tr>
			<tr><td>Answer is ::"</td><td><input type="text"></td></tr>
			
			
			</table> -->
        
        
      </form:form>
      <!-- <div id="footer">
        Copyright 2011, Sapient Corporation. All rights reserved
      </div> -->
    </div>
  </body>
</html>