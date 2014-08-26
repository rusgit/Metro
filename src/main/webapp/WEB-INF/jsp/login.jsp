<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
	request.getSession().removeAttribute("user");
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Login</title>
<link href ="<c:url value="/resources/css/frameGen.css"/>" type=text/css rel="stylesheet">
<link href ="<c:url value="/resources/css/styleGeneral.css"/>" type=text/css rel="stylesheet">
<link href ="<c:url value="/resources/css/styleLinks.css"/>" type=text/css rel="stylesheet">
<link href ="<c:url value="/resources/css/styleButton.css"/>" type=text/css rel="stylesheet">
<link href ="<c:url value="/resources/css/positionLogin.css"/>" type=text/css rel="stylesheet">

</head>
<body>
	<div id="wrapper">
			<div id="header"></div>
			<div id="sidebarL">

				<form id="form" action="j_spring_security_check" method="POST">
						<p><label for="username">Login:</label></p>
						<p><input class="input" id="username" type="text" name="j_username" maxlength="10"></p>
									   
						<p><label for="password">Password:</label></p>
						<p><input class="input" id="password" type="password" name="j_password" maxlength="10"></p>
                            <c:if test="${not empty error}">
                                <p class="exception">Error login or password</p>
                            </c:if>
                            <c:if test="${not empty success}">
                                <p class="succesful">Logout successful</p>
                            </c:if>
						<p><input class="button" type="submit" name="submit" value="LOGIN"></p>
						<p><a id="ref" class="button" href="<c:url value="/reg"/>" >SIGN UP</a></p>

				</form>
				
			</div>
			<div id="content"></div>
			<div class="clear"></div>
			<div id="footer">
				<p id="footerPlace">Borisov Ruslan, 2014</p>
			</div>
	</div>

</body>
</html>