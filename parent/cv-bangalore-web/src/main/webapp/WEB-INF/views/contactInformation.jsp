<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE 
    html
    PUBLIC
    "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">


<html xmlns="http://www.w3.org/1999/xhtml">
  <head>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <title>
      Contact Information
    </title>
    <link rel="stylesheet" type="text/css" href="/CVBangaloreSkin/styles/view.css" media="all">
    <link rel="stylesheet" type="text/css" href="/CVBangaloreSkin/styles/menu.css" media="all"/>
    <script type="text/javascript" src="/CVBangaloreSkin/scripts/view.js">
    </script>
    <script type="text/javascript" src="/CVBangaloreSkin/scripts/jquery.js">
    </script>
    <script type="text/javascript" src="/CVBangaloreSkin/scripts/menu.js">
    </script>
    <style type="text/css">
      body,td,th { color: #C33; font-size: 12px; }
    </style>

  </head>

  <body id="main_body">
 <jsp:include page="../views/header.jsp" />
<div id="form_container">

  <form:form method="post" action="contactInformation.html" commandName="contactInformationForm"  class="appnitro" >
    <div class="form_description">
      <h2>
        Contact Information
      </h2>
      <p>
        Please enter your Contact Information here
      </p>
    </div>
    <ul>

      <li id="li_1">
      <label class="description" for="element_1">
        Permanent Address
      </label>

      <div>
        <form:input path="permanentAddress.streetAddress" cssClass="element text large"  />
        <label for="element_1_1">
          Street Address
        </label>
      </div>


      <div>
        <form:input path="permanentAddress.addressLine2" cssClass="element text large" />
        <label for="element_1_2">
          Address Line 2
        </label>
      </div>


      <div class="left">
        <form:input path="permanentAddress.city" cssClass="element text medium" />
        <label for="element_1_3">
          City
        </label>
      </div>


      <div class="right">
        <form:input path="permanentAddress.state" cssClass="element text medium" />
        <label for="element_1_4">
          State / Province / Region
        </label>
      </div>


      <div class="left">
        <form:input path="permanentAddress.zipCode" cssClass="element text medium" maxlength="15" />
        <label for="element_1_5">
          Postal / Zip Code
        </label>
        <form:errors path="permanentAddress.*" cssStyle="color : red"/>
      </div>


      <div class="right">
        <form:input path="permanentAddress.country" cssClass="element text medium" maxlength="15" />
        <label for="element_1_6">
          Country
        </label>
      </div>


      <p class="guidelines" id="guide_1">
        <small>
          Please enter your Permanent Address here
        </small>
      </p>
    </li>
    <li id="li_2">
    <label class="description" for="element_2">
      Current Address
    </label>

    <div>
      <form:input path="currentAddress.streetAddress" cssClass="element text large" />
      <label for="element_2_1">
        Street Address
      </label>
    </div>

    <div>
      <form:input path="currentAddress.addressLine2" cssClass="element text large" />
      <label for="element_2_2">
        Address Line 2
      </label>
    </div>

    <div class="left">
      <form:input path="currentAddress.city" cssClass="element text medium" />
      <label for="element_2_3">
        City
      </label>
    </div>

    <div class="right">
      <form:input path="currentAddress.state" cssClass="element text medium" />
      <label for="element_2_4">
        State / Province / Region
      </label>
    </div>

    <div class="left">
      <form:input path="currentAddress.zipCode" cssClass="element text medium" maxlength="15" />
      <label for="element_2_5">
        Postal / Zip Code
      </label>
      <form:errors path="currentAddress.*" cssStyle="color : red"/>
    </div>

    <div class="right">
      <form:input path="currentAddress.country" cssClass="element text large" />
      <label for="element_2_6">
        Country
      </label>
    </div>

    <p class="guidelines" id="guide_2">
      <small>
        Please enter your Current Address here
      </small>
    </p>
  </li>
  <li id="li_3">
  <label class="description" for="element_3">
    Primary Email
  </label>
  <div>
    <form:input path="primaryEmail" cssClass="element text medium"  maxlength="255" />
  </div>
  <div>
    <form:errors path="primaryEmail" cssStyle="color : red"/>
  </div>
  <p class="guidelines" id="guide_3">
    <small>
      Please enter your Primary Email here
    </small>
  </p>
</li>
<li id="li_4">
<label class="description" for="element_4">
  Secondary Email
</label>
<div>
  <form:input path="secondaryEmail" cssClass="element text medium" maxlength="255" />
</div>
<div>
  <form:errors path="secondaryEmail" cssStyle="color : red"/>
</div>
<p class="guidelines" id="guide_4">
  <small>
    Please enter your Secondary Email here
  </small>
</p>
</li>
<li id="li_5">
<label class="description" for="element_5">
  Mobile Number
</label>
<span>
  <form:input path="mobileNumber.countryCode" cssClass="element text" size="3" maxlength="3" />
  -
  <label for="element_5_1">
    (###)
  </label>
</span>
<span>
  <form:input path="mobileNumber.areaCode" cssClass="element text" size="3" maxlength="3" />
  -
  <label for="element_5_2">
    ###
  </label>
</span>
<span>
  <form:input path="mobileNumber.phoneNumber" cssClass="element text" size="3" maxlength="3" />
  <label for="element_5_3">
    ####
  </label>
</span>

<p class="guidelines" id="guide_5">
  <small>
    Please enter your Mobile Number here
  </small>
</p>
<!--
  </li> <li id="li_8"><label class="description" for="element_8"> </label> --> <sp
-->
<span>
  <input id="element_8_1" name="element_8_1" class="element checkbox" type="checkbox" value="1" />
  <label class="choice" for="element_8_1">
    Is Emergency number?
  </label>
</span>
<!--
  <p class="guidelines" id="guide_8"> <small>Is It your Emergency Number?</small> </p> --></
-->
</li>
<div>
  <form:errors path="mobileNumber.*" cssStyle="color : red"/>
</div>
<li id="li_6">
<label class="description" for="element_6">
  Office Number
</label>
<span>
  <form:input path="officeNumber.countryCode" cssClass="element text" size="3" maxlength="3" />
  -
  <label for="element_6_1">
    (###)
  </label>
  <form:errors path="officeNumber.*" cssStyle="color : red"/>
</span>
<span>
  <form:input path="officeNumber.areaCode" cssClass="element text" size="3" maxlength="3" />
  -
  <label for="element_6_2">
    ###
  </label>
</span>
<span>
  <form:input path="officeNumber.phoneNumber" cssClass="element text" size="3" maxlength="3" />
  <label for="element_6_3">
    ####
  </label>
</span>
<p class="guidelines" id="guide_6">
  <small>
    Please enter your Office Number here
  </small>
</p>
</li>
<li id="li_7">
<label class="description" for="element_7">
  Office Extension Number
</label>
<div>
  <form:input path="extension" cssClass="element text small" maxlength="255" />
</div>
<span>
  <form:errors path="extension" cssStyle="color : red"/>
</span>
<p class="guidelines" id="guide_7">
  <small>
    Please enter your Office Extension Number here
  </small>
</p>
</li>

<li class="buttons">
<!--<a href ="C:\Documents and Settings\komar\Desktop\forms\form\form\education.html"></a>-->
<input type="hidden" name="form_id" value="150434" />
<input type="image" src="/CVBangaloreSkin/images/submit_btn.png" alt="submit"/>
<!--<input id="saveForm" class="button_text" type="submit" name="submit" value="Submit" />-->
</li>
</ul>
</form:form>
<!--
  <div id="footer">Copyright 2011, Sapient Corporation. All rights reserved</div>
-->
</div>
<img id="bottom" src="/CVBangaloreSkin/images/bottom.png" alt="">
</body>
</html>
