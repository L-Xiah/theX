<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<c:set var="ctxtitle" value="Title...TheSet"/>
<html>
<head>
    <title>${ctxtitle}</title>
</head>
<body>
<h2>Hello World!--templates!!!!!!!!!!!!!!---webapp--</h2>
<p><span>---${ctx}</span></p>
</body>
</html>
