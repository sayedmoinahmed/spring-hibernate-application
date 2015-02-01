<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
      Recognition Information
    </title>
    <link rel="stylesheet" type="text/css" href="/CVBangaloreSkin/styles/view.css" media="all">
    <link rel="stylesheet" type="text/css" href="/CVBangaloreSkin/styles/menu.css" media="all" />
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

      <form:form 
          method="post"
          action="submitRecognitionInformation.html"
          commandName="recognitionInformationForm"
          cssClass="appnitro">

        <div class="form_description">
          <h2>
            Recognition/Awards/Certifications Information
          </h2>
          <p>
            Please enter your Recognition/Awards/Certifications Information.
          </p>
        </div>
        <ul>

          <li id="li_2">
          <label class="description" for="element_2">
            Recognition Type
          </label>
          <div>
            <form:hidden path="recognitionInfoId" />
            <form:select path="recognitionTypeId" id="recognitionTypeId">

              <c:forEach var="recognitionTypeVO" items="${ recognitionTypes }">
                <c:choose>
                  <c:when test="${recognitionTypeVO.recognitionTypeId eq recognitionInformationForm.recognitionTypeId}">
                    <form:option value="${recognitionTypeVO.recognitionTypeId}" selected="selected">
                      ${recognitionTypeVO.description}
                    </form:option>
                  </c:when>
                  <c:otherwise>
                    <form:option value="${recognitionTypeVO.recognitionTypeId}">
                      ${recognitionTypeVO.description}
                    </form:option>
                  </c:otherwise>
                </c:choose>
              </c:forEach>
            </form:select>
          </div>
          <p class="guidelines" id="guide_2">
            <small>
              Please select the Type of Recognition.
            </small>
          </p>
        </li>



        <li id="li_1">
        <label class="description" for="element_1">
          Description&nbsp;<font color=red size=1>*</font>
        </label>
        <div>
          <form:input path="items" cssClass="element text medium"	maxlength="100" />
        </div>
        <div>
          <form:errors path="items" cssStyle="color : red" />
        </div>
        <p class="guidelines" id="guide_1">
          <small>
            Please enter description of your Recognition/Awards/Certifications.
          </small>
        </p>
      </li>
      <li class="buttons">
      <input type="image" src="/CVBangaloreSkin/images/button-submit.png" value="Submit" alt="Submit" />
    </li>
  </ul>
</form:form>
<jsp:include page="../views/footer.jsp" />
</div>

</body>
</html>
