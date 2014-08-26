<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User page</title>

<script src="<c:url value="/resources/js/jquery-1.11.1.min.js"/>" type="text/javascript"></script>
<script	src="<c:url value="/resources/js/jquery-ui.min.js"/>" type="text/javascript"></script>
<script src="<c:url value="/resources/js/init.js"/>" type="text/javascript"></script>
<script	src="<c:url value="/resources/js/submitCheck.js"/>" type="text/javascript"></script>
<script src="<c:url value="/resources/js/displayCheckUserAdmin.js"/>" type="text/javascript"></script>
<script src="<c:url value="/resources/js/ajaxUse.js"/>" type="text/javascript"></script>
<script src="<c:url value="/resources/js/ajaxBuy.js"/>" type="text/javascript"></script>
    <script src="<c:url value="/resources/js/ajaxDelete.js"/>" type="text/javascript"></script>

<link href ="<c:url value="/resources/css/jquery-ui.min.css"/>" type="text/css" rel="stylesheet">
<link href ="<c:url value="/resources/css/frameGen.css"/>" type="text/css" rel="stylesheet">
<link href ="<c:url value="/resources/css/styleGeneral.css"/>" type="text/css" rel="stylesheet">
<link href ="<c:url value="/resources/css/styleTable.css"/>" type="text/css" rel="stylesheet">
<link href ="<c:url value="/resources/css/styleLinks.css"/>" type="text/css" rel="stylesheet">
<link href ="<c:url value="/resources/css/styleButton.css"/>" type="text/css" rel="stylesheet">
<link href ="<c:url value="/resources/css/positionUser.css"/>" type="text/css" rel="stylesheet">

</head>
<body>
        <div id="wrapper">

            <div id="header"></div>

            <div id="user">
                <p id="userPlace">
                    <c:if test="${pageContext.request.userPrincipal.name != null}">
                    ${pageContext.request.userPrincipal.name}
                    | <a href="<c:url value="/j_spring_security_logout" />" > Exit</a>
                </c:if> |
                <a class="logmenu" href="<c:url value="/myCards"/>" >My cards</a> </p>
            </div>

            <div class="clear"></div>

            <div id="sidebarL">

    <!-- MENU -->

                <ul id="menu" menuId="${menu}">
                    <li><a id="use" class="menu" href="<c:url value="/use"/>" >Use card</a></li>
                    <li><a id="buy" class="menu" href="<c:url value="/buy"/>" >Buy card</a></li>
                    <li><a id="update" class="menu" href="<c:url value="/update"/>" >Update card</a></li>
                    <sec:authorize access="hasRole('ROLE_ADMIN')">
                        <li><a id="show" class="menu" href="<c:url value="/show"/>" name="show">Show cards</a></li>
                    </sec:authorize>
                </ul>

            </div>

            <div id="content">

                <c:if test="${not empty menu}">
                    <jsp:include page="includes/${menu}.jsp" />
                </c:if>

            </div>

            <div class="clear"></div>

            <div id="footer">
                <p id="footerPlace">Borisov Ruslan, 2014</p>
            </div>

        </div>
</body>
</html>