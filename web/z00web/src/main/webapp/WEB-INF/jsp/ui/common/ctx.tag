<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<% String base=request.getRequestURL().substring(0, request.getRequestURL().length() - request.getRequestURI().length()) 
				+ request.getContextPath();%>
<c:set var="base" value="<%=base%>" />
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<c:set var="url" value="${pageContext.request.requestURL}" />
<c:set var="uri" value="${pageContext.request.requestURI}" />
