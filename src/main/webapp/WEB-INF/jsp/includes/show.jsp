<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

    <form id="formShow" action="<c:url value="/show/cards"/>" method="POST">
        <div  class="divBorder">

        <div class="wrap">
            <input class="input" id="idFrom" type="text" placeholder="Enter ID from.." name="idFrom" maxlength="15">
        </div>
        <div class="wrap">
            <p><input class="input" id="idTo" type="text" placeholder="Enter ID to.." name="idTo" maxlength="15">
        </div>

            <p><input id="submitShow" class="button" type="submit" value="SEND"></p>

    </div>
    </form>

<!-- INFORMATION -->	

    <c:if test="${not empty cards && empty exception}">
        <div  class="divBorder">
            <c:forEach var="cardLocal" items="${cards}" >
                <c:set var="card" value="${cardLocal}" scope="request"></c:set>
                <jsp:include page="../utils/card${card.getCardType()}.jsp" />
             </c:forEach>
        </div>
    </c:if>

    <c:if test="${not empty exception}">
        <div class="divBorder">
            <p class="exception">${exception}</p>
        </div>
    </c:if>