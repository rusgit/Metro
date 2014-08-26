<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

	<form id="formUpdate" action="<c:url value="/update/card"/>" method="POST">
        <div  class="divBorder">
				 <div class="wrap">
					<input class="input" id="idUpd" type="text" placeholder="Enter ID.." name="id" maxlength="15">
				</div>	
				<div class="wrap">
					<p><input class="input" id="numberTripUpdate" type="text" placeholder="Enter number trip.." name="numberTripUpdate" maxlength="15"></p>
				</div>	
					
					<p><input id="submitUpdate" class="button" type="submit" value="SEND"></p>	   					   
		</div>
	</form>
				
<!-- INFORMATION UPDATE -->

    <c:if test="${(not empty card)}">
        <div  class="divBorder">
            <jsp:include page="../utils/card${card.getCardType()}.jsp" />
        </div>
    </c:if>
    <c:if test="${not empty exception}">
        <p class="exception">${exception}</p>
    </c:if>

