<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>
      Profile Summary Information
    </title>
<title>Profile Summary Information</title>
    <link rel="stylesheet" type="text/css" href="/CVBangaloreSkin/styles/view.css" media="all">
<link rel="stylesheet" type="text/css" href="/CVBangaloreSkin/styles/menu.css" media="all"/>
<script type="text/javascript" src="/CVBangaloreSkin/scripts/view.js"></script>
<script type="text/javascript" src="/CVBangaloreSkin/scripts/jquery.js"></script>
<script type="text/javascript" src="/CVBangaloreSkin/scripts/menu.js"></script>
<!-- there are six things you need to make AtD work for you, they are: -->

 <!-- 1. include jQuery ... naturally none of this works without jQuery -->
 <script src="http://code.jquery.com/jquery-1.4.2.js"></script>

 <!-- 2. load the atd.textarea.js -- this script makes it easy to attach AtD to a textarea -->
 <script src="/CVBangaloreSkin/scripts/jquery.atd.textarea.js"></script>

 <!-- 3. this script is a hack that allows cross-domain AJAX -->
 <script src="/CVBangaloreSkin/scripts/csshttprequest.js"></script>

 <!-- 4. this CSS file contains the style information for highlighted errors -->
 <link rel="stylesheet" type="text/css" media="screen" href="/CVBangaloreSkin/styles/atd.css" />

 <!-- 6. a function to call when the button is clicked, this function calls into the AtD textarea code -->
    <style type="text/css">
      body,td,th { color: #C33; font-size: 12px; }
    </style>
<script>
	function check(obj){
		if(obj=="desc"){
    			AtD.checkTextAreaCrossAJAX('descInput', 'checkDesc', 'Edit Text');
    		}else if(obj=="title"){
    			AtD.checkTextAreaCrossAJAX('titleInput', 'checkTitle', 'Edit Text');
    		}
 	}
 </script>
  </head>
  <body id="main_body">
 <jsp:include page="../views/header.jsp" />
    <div id="form_container">

      <form:form 
          method="post"
          action="profileSummaryInformation.html"
          commandName="profileSummaryForm"
          cssClass="appnitro">

        <div class="form_description">
          <h2>
            Profile Summary Information
          </h2>
          <p>
            Please enter your Profile Summary .
          </p>
        </div>
        <form:hidden path="id"/>
          <label class="description" for="title">
            Title&nbsp;<font color=red size=1>*</font>
          </label>
          <div style="position:absoulte;width:450px;">
            <form:textarea path="title" cssClass="element textarea medium"  id="titleInput"  />
          </div>
          <div>
            <form:errors path="title" cssStyle="color : red"/>
			<p><img src="/CVBangaloreSkin/images/atdbuttontr.gif"><a href="javascript:check('title')" id="checkTitle" name="title" >Check Spelling</a></p>             
          </div>
          <p class="guidelines" id="guide_1">
            <small>
              Please enter the Title of your Profile.
            </small>
          </p>
        <label class="description" for="description">
          Description&nbsp;<font color=red size=1>*</font>
        </label>
        <div style="position:absoulte;width:450px;">
         <form:textarea path="description" cssClass="element textarea medium" id="descInput"   /> 
          <p><img src="/CVBangaloreSkin/images/atdbuttontr.gif"><a href="javascript:check('desc')" id="checkDesc" name="desc" >Check Spelling</a></p>
        </div>
        <div>
          <form:errors path="description" cssStyle="color : red"/>
        </div>
        <p class="guidelines" id="guide_2">
          <small>
            Please enter a brief Description about your Profile.
          </small>
        </p>


    <span class="buttons">
      <input type="image" src="/CVBangaloreSkin/images/submit_btn.png" value="Submit" alt="Submit"/>
   </span>

</form:form>
<jsp:include page="../views/footer.jsp" />
</div>
</body>
</html>
