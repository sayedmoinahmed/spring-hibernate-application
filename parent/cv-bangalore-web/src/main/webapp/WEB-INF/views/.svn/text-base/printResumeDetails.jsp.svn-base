<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>
      Generate PDF
    </title>
    <link rel="stylesheet" type="text/css" href="/CVBangaloreSkin/styles/view.css" media="all">
    <link rel="stylesheet" type="text/css" href="/CVBangaloreSkin/styles/menu.css" media="all"/>
    <script type="text/javascript" src="/CVBangaloreSkin/scripts/view.js">
    </script>
    <script type="text/javascript" src="/CVBangaloreSkin/scripts/jquery.js">
    </script>
    <script type="text/javascript" src="/CVBangaloreSkin/scripts/menu.js">
    </script>
    <script type="text/javascript">
    
    function generatePDF()
    {
    	
    	window.open("","PDFWin","menubar=0,status=0,toolbar=0,resizable=1,location=0");
    	document.forms(0).target="PDFWin";
    }
    
   
    
    
    </script>
    
    
    <style type="text/css">
      body,td,th { color: #C33; font-size: 12px; }
    </style>

  </head>
  <body id="main_body">
    <jsp:include page="../views/header.jsp" />
<div id="form_container">
  <div class="form_description">
    <h2>
      Print Resume Details
    </h2>
    
  </div>
  <form:form action="printResume"  commandName="printResumeForm" method="POST">
  <ul>
  <form:checkbox path="mailResume" label="Mail Resume to Staffing"/>
  
  </ul>
  
  <ul>

  <span class="buttons">
    <input type="image" src="/CVBangaloreSkin/images/generate_pdf_btn.png" value="Submit" alt="Generate" onclick="generatePDF()"/>
  </span>
  </ul>
</form:form>

<jsp:include page="../views/footer.jsp" />
</div>
</body>
</html>
