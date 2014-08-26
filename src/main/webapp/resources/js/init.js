$(document).ready(function() {
	Main.initDisplayCheck();
	Main.initSubmit();
	Main.initOther();
}); // end ready

Main = {
		
	initDisplayCheck: function(){

// CHECK-DISPLAY USER + ADMIN
		
		$('#id, #idUpd, #numberTripUpdate, #numberTrip, #idFrom, #idTo').on('focus', function(){
			var elemId = $(this).attr('id');
	//Counter
			counter.countCreate(elemId,'10');
	//HideCheck
			checks.hide(elemId);
		}).on('blur', function(){
			var elemId = $(this).attr('id');
	//Check
			checks.checkTarget(elemId,'integer');
	//HideCounter
			counter.countHide(elemId);
		}).on('keyup', function(){
			var elemId = $(this).attr('id');
	//Counter
			counter.countPress(elemId,'10');
		}); 
		
		$('#name, #lastName').on('focus', function(){
			var elemId = $(this).attr('id');
	//Counter
			counter.countCreate(elemId,'15');
	//HideCheck
			checks.hide(elemId);
		}).on('blur', function(){
			var elemId = $(this).attr('id');
	//Check
			checks.checkTarget(elemId,'latin');
	//HideCounter
			counter.countHide(elemId);
		}).on('keyup', function(){
			var elemId = $(this).attr('id');
			counter.countPress(elemId,'15');
		});

// CHECK-DISPLAY REGISTRATION 
		
		$('#username, #pass').on('blur', function(){
			var elemId = $(this).attr('id');
			correctInp5more(elemId);
		}).on('focus', function(){
			var elemId = $(this).attr('id');
			hide(elemId);
		}); 
		
		$('#repeatPass').on('blur', function(){
			correctRepeat('pass','repeatPass');
		}).on('focus', function(){
			var elemId = $(this).attr('id');
			hide(elemId);
		}); 
		
		$('#email').on('blur', function(){
			correctEmail($(this).attr('id'));
		}).on('focus', function(){
			hide($(this).attr('id'));
		}); 
				
	},	// end initCheck
	
	
	initSubmit: function(){
		
//SUBMIT REGISTRATION
		
		$("#formReg").submit(function(eventObject){
			registration(eventObject);
		});

//SUBMIT USER + ADMIN
		
		$('#formUse').submit(function(eventObject){
		    use(eventObject);
		});
		
		$('#formUpdate').submit(function(eventObject){
			update(eventObject);
		});
		
		$('#formBuyNumber').submit(function(eventObject){
           buyNumber(eventObject);
		});
		
		$('#formBuyUnlim').submit(function(eventObject){
			buyUnlim(eventObject);
		});
		
		$('#formShow').submit(function(eventObject){
			showCards(eventObject);
		});

// DELETE ADMIN

        $('.card-table a').on('click', function(){
            ajaxDeleteCard($(this).closest('table').attr('cardId'));
        });

	}, // end initSubmit	
	
	
	initOther: function(){
	
// DRAGGABLE		
		
		$("fieldset").draggable({
			   axis:'y',
			   revert: true
		});
		  		
// RESIZABLE	
		
		$("#user").resizable({
			  axis:'y',
			  minHeight: 40
		  }).draggable({
			   axis:'y',
			   revert: true
		});	
		
// MENU SELECTED

        $("li").filter(":has(a[class=menu])").removeClass("menuSelected")

        if ('use'==$("#menu").attr("menuId")) {
            $("#use").closest('li').addClass('menuSelected')
        }
        if ('buy'==$("#menu").attr("menuId")) {
            $("#buy").closest('li').addClass('menuSelected')
        }
        if ('update'==$("#menu").attr("menuId")) {
            $("#update").closest('li').addClass('menuSelected')
        }
        if ('show'==$("#menu").attr("menuId")) {
            $("#show").closest('li').addClass('menuSelected')
        }

 //BUY CHOICE

        if ('numberCard'==$("#type").attr("selectId")) {
            $("#type").val('NumberCard');
        }
        if ('unlimCard'==$("#type").attr("selectId")) {
            $("#type").val('UnlimCard');
        }
        if ('timeCard'==$("#type").attr("selectId")) {
            $("#type").val('TimeCard');
        }

 //BUY CHOICE VALIDITY

        if ('MONTH'==$("#validity").attr("selectValidity")) {
            $("#validity").val('MONTH');
        }
        if ('QUARTER'==$("#validity").attr("selectValidity")) {
            $("#validity").val('QUARTER');
        }
        if ('YEAR'==$("#validity").attr("selectValidity")) {
            $("#validity").val('YEAR');
        }


	} // end initOther
	
};// end Main



	


