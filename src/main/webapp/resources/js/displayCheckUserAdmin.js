function check(){
	this.checkTarget = function(idInput,target) {
		var a=null;
		var info=null;
		if (target=='latin') {
			a = /^[a-zA-Z]+$/;
			info = 'only latin symbols';
		}
		if (target=='integer') {
			a = /^[0-9]+$/;
			info = 'only integer type';
		}
		
		var inp = $("#"+idInput);
		
		if ( inp.val() != '') {
			
			if (inp.val().search(a)!=-1) {
				$(".wrap").filter(":has(input[id="+idInput+"])").append("<div id='"+idInput+"OK' class='goodCheck' style='display:none'>OK</div>");
				$("#"+idInput+"OK").fadeIn(400);
				
			} else {
				$(".wrap").filter(":has(input[id="+idInput+"])").append("<div id='"+idInput+"X' class='badCheck'>X</div>")
				.filter(":has(input[id="+idInput+"])").append("<div id='"+idInput +"Info' class='checkInfo'>"+info+"</div>");
				$("#"+idInput+"X").fadeIn(400);
				$("#"+idInput+"Info").fadeIn(400);
			}		
		} 
	};
	this.hide = function(idInput) {
		
		$("#"+idInput+"OK").remove();
		$("#"+idInput+"X").remove();
		$("#"+idInput+"Info").remove();
	};
}

var checks = new check();

/////////////////////////////////////////////////////////


function count(){
	this.countCreate = function(idInput,number) {
		
		var inp = $("#"+idInput);
		
		var content = inp.val();
		var length = content.length;
		var left = number - length;
		
		$(".wrap:has(input[id="+idInput+"])").append("<div id='"+idInput+"Count' class='count'></div>");
		$("#"+idInput+"Count").text(left + ' symbols left');
		
	};
	
	this.countPress = function(idInput,number) {
		
		var inp = $("#"+idInput);
		
		var content = inp.val();
		var length = content.length;
		
		if (length>number) {
			inp.val(content.substr(0,number));
		}
		
		var count =  $("#"+idInput+"Count");
		var left = number - length;
		
		if (left<0) {
			left=0;
		}
		
		count.text(left + ' symbols left');
	};
	
	this.countHide = function(idInput) {
		$("#"+idInput+"Count").remove();
	};
}

var counter = new count();
