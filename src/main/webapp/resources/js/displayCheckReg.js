
function correctEmail(IdInp) {
		
	var a =/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,4})+$/;
	var inp = $("#"+IdInp);
	var ok = $('#'+IdInp+'OK');
	var x = $('#'+IdInp+'X');
	var info = $('#'+IdInp+'Info');
	
		if (inp.val() == '') {
			ok.hide();
			x.hide();
			info.hide();
		} else if (inp.val().search(a)!=-1) {
			ok.fadeIn(400);
			x.hide();
			info.hide();
		} else {
			ok.hide();
			x.fadeIn(400);
			info.fadeIn(400);

	    } 	
}	

function correctRepeat(first,second) {
	
	var el1 = $("#"+first);
	var el2 = $("#"+second);

	if (el1.val() == '' || el2.val() =='') {
		$('#repeatPassOK').hide();
		$('#repeatPassX').hide();
		$('#repeatPassInfo').hide();
	} else if (el1.val() == el2.val()) {
		$('#repeatPassOK').fadeIn(400);
		$('#repeatPassX').hide();
		$('#repeatPassInfo').hide();
	} else {
		$('#repeatPassOK').hide();
		$('#repeatPassX').fadeIn(400);
		$('#repeatPassInfo').fadeIn(400);
	}
}

//////////////////////////////////////////////////////////


function correctInp5more(idInp) {
	
	var inp = $("#"+idInp);
	var resOk = $("#"+idInp+"OK");
	var resX = $("#"+idInp+"X");
	var resInfo = $("#"+idInp+"Info");
	
		if (inp.value == '') {
			resOk.hide();
			resX.hide();
			resInfo.hide();
		} else if (inp.val().length < 5) {
			resOk.hide();
			resX.fadeIn(400);
			resInfo.fadeIn(400);
		} else {
			resOk.fadeIn(400);
			resX.hide();
			resInfo.hide();
		}	
}

function hide(idInp) {
	$("#"+idInp+"OK").hide();
	$("#"+idInp+"X").hide();
	$("#"+idInp+"Info").hide();
}

