<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

    <table id="Table${card.id}" class="card-table" cardId="${card.id}">
        <tr>
            <th>ID</th>
            <th>TYPE</th>
            <th>NUMBER TRIP</th>
            <th>ACTIVE</th>
        </tr>
        <tr>
            <td>${card.id}</td>
            <td> NUMBER </td>
            <td>${card.numberTrip}</td>
            <td>${card.active}</td>
            <sec:authorize access="hasRole('ROLE_ADMIN')">
                <td><a href="javascript:{}"><img src="../resources/images/delete.png"></a></td>
            </sec:authorize>
        </tr>
    </table>

