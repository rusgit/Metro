<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
			
	<form id="formUse" action="<c:url value="/use/card"/>" method="POST">
        <div  class="divBorder">
			<div class="wrap">
				<input class="input" id="id" type="text" placeholder="Enter ID.." name="id" maxlength="10" >
			</div>	
			<p><input id="submitUse" class="button" type="submit" value="SEND"></p>
		</div>
	</form>
	
<!-- INFORMATION USE -->

    <div id='useInfo' class="divBorder" style="display: none">
        <div class="open" style="display: none">OPEN</div>
        <div class="close" style="display: none">CLOSE</div>
        <div class="tableResult" style="display: none"></div>
    </div>
    <div class="exception divBorder" style="display: none"></div>


