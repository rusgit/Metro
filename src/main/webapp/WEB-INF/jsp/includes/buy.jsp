<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!-- CHOICE -->


    <div  class="divBorder">
        <form action="<c:url value="/buy/choice"/>" method="POST">
                <p><select class="input" id="type" selectId="${choice}" name="type">
                    <option value="NumberCard">Number Card</option>
                    <option value="UnlimCard">Unlimited Card</option>
                    <option value="TimeCard">Time Card</option>
                </select></p>

                <p><input class="button" type="submit" name="submitChoose" value="NEXT"></p>
        </form>
    </div>
											
	
	<c:set var="choice" value="${choice}"/>
	<c:choose>
	
<%-- BUY NUMBER --%>

    <c:when test="${'numberCard' == choice}">
        <form id="formBuyNumber" action="<c:url value="/buy/numberCard"/>" method="POST">
            <div  class="divBorder">
            <div class="wrap">
                <p><input class="input" id="numberTrip" type="text" placeholder="Enter number trip.." name="numberTrip" maxlength="10">
            </div>

                <p><input id="submitNumber" class="button" type="submit" value="BUY"></p>
            </div>
        </form>
    </c:when>
	     
<%-- BUY TIME --%>
    
    <c:when test="${'timeCard' == choice}">
        <form action="<c:url value="/buy/timeCard"/>" method="POST">
            <div  class="divBorder">
                <p><label for="validity">Validity:</label></p>
                <p><select class="input" id="validity" selectValidity="${card.validity}" name="validity">
                    <option>MONTH</option>
                    <option>QUARTER</option>
                    <option>YEAR</option>
                    </select></p>

                <p><input class="button" type="submit" value="BUY"></p>
            </div>
        </form>
    </c:when>
	    
<%-- BUY UNLIM --%>

    <c:when test="${'unlimCard' == choice}">
        <form id="formBuyUnlim" action="<c:url value="/buy/unlimCard"/>" method="POST">
            <div  class="divBorder">
                <div class="wrap">
                    <p><input class="input" id="name" type="text" placeholder="Enter name.." name="name" maxlength="15">
                </div>
                <div class="wrap">
                    <p><input class="input" id="lastName" type="text" placeholder="Enter last name.." name="lastName" maxlength="15">
                </div>
                <p><input id="submitUnlim" class="button" type="submit" value="BUY"></p>

            </div>
        </form>
    </c:when>
    </c:choose>

<!-- INFORMATION BUY -->

    <div class="exception divBorder" style="display: none"></div>
    <div class="succesful divBorder" style="display: none"></div>
    <div class="tableResult divBorder" style="display: none"></div>

    <c:if test="${not empty card  && empty exception}">
        <div  class="divBorder">
            <jsp:include page="../utils/card${card.getCardType()}.jsp" />
        </div>
    </c:if>
    <c:if test="${not empty exception}">
        <p class="exception">${exception}</p>
    </c:if>