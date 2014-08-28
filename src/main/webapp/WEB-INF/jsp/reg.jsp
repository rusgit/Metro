<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
<script src="<c:url value="/resources//js/jquery-1.11.1.min.js"/>" type="text/javascript"></script>
<script	src="<c:url value="/resources/js/jquery-ui.min.js"/>" type="text/javascript"></script>
<script src="<c:url value="/resources/js/init.js"/>" type="text/javascript"></script>
<script	src="<c:url value="/resources/js/submitCheck.js"/>" type="text/javascript"></script>
<script src="<c:url value="/resources/js/displayCheckReg.js"/>" type="text/javascript"></script>

<link href ="<c:url value="/resources/css/jquery-ui.min.css"/>" type=text/css rel="stylesheet">
<link href ="<c:url value="/resources/css/frameReg.css"/>" type=text/css rel="stylesheet">
<link href ="<c:url value="/resources/css/styleGeneral.css"/>" type=text/css rel="stylesheet">
<link href ="<c:url value="/resources/css/styleButton.css"/>" type=text/css rel="stylesheet">
<link href ="<c:url value="/resources/css/positionReg.css"/>" type=text/css rel="stylesheet">

</head>
<body>
	<div id="wrapper">
        <div id="header"></div>

        <div id="content">

        <div  class="divBorder">
            <form id="formReg" action="<c:url value="/reg/submit"/>" method="POST">


                <p class="question"><label for="username">Enter Your Login:</label></p>
                <div class="wrap">
                    <input id="username" class="input" type="text" name="username" maxlength="10">
                    <div id="usernameOK" class="goodCheck dispNone"> OK </div>
                    <div id="usernameX" class="badCheck dispNone"> X </div>
                    <div id="usernameInfo" class="checkInfo dispNone" >minimum 5 symbols</div>
                </div>

                <p class="question"><label for="password">Enter Password:</label></p>
                <div class="wrap">
                    <input id="pass" class="input" type="password" name="password" maxlength="10">
                    <div id="passOK" class="goodCheck dispNone"> OK </div>
                    <div id="passX" class="badCheck dispNone"> X </div>
                    <div id="passInfo" class="checkInfo dispNone" >minimum 5 symbols</div>
                </div>

                <p class="question"><label for="passwordRepeat">Repeat Password:</label></p>
                <div class="wrap">
                    <input id="repeatPass" class="input" name="passwordRepeat" maxlength="10">
                    <div id="repeatPassOK" class="goodCheck dispNone"> OK </div>
                    <div id="repeatPassX" class="badCheck dispNone"> X </div>
                    <div id="repeatPassInfo" class="checkInfo dispNone" >wrong repeat password</div>
                </div>

                <c:if test="${not empty exception}">
                    <p class="exception">${exception}</p>
                </c:if>

                    <p class="question"><label for="inp">Enter Your e-mail:</label></p>
                <div class="wrap">
                    <input id="email" class="input" type="text" name="email">
                    <div id="emailOK" class="goodCheck dispNone"> OK </div>
                    <div id="emailX" class="badCheck dispNone"> X </div>
                    <span id="emailInfo" class="checkInfo dispNone" >wrong format</span>
                </div>
                <p><input id="buttonReg" class="button" type="submit" value="SEND"></p>
            </form>
        </div>
			
        </div>
        <div class="clear"></div>
        <div id="footer">
            <p id="footerPlace">Borisov Ruslan, 2014</p>
        </div>
	</div>		

</body>
</html>