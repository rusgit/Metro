<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

    <c:if test="${not empty cards && empty exception}">
        <div  class="divBorder">
            <c:forEach var="cardLocal" items="${cards}">
                <c:set var="card" value="${cardLocal}" scope="request"></c:set>
                <jsp:include page="../utils/card${card.cardType}.jsp" />
            </c:forEach>
        </div>
    </c:if>

    <c:if test="${not empty exception}">
        <div  class="divBorder">
            <p class="exception">${exception}</p>
        </div>
    </c:if>
