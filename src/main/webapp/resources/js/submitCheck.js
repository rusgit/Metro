
function registration(eventObject) {
	
	var a =/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,4})+$/;
	if ($("#email").val().search(a)==-1 || $("#username").val().length < 5 ||
			$("#pass").val().length <5 || $("#pass").val() != $("#repeatPass").val()) {
		eventObject.preventDefault();
		alert('Not correct enter data. Check input!!!');
	}
}

function showCards(eventObject) {
	
	var a = /^[0-9]+$/;	
	if ($("#idTo").val().search(a)==-1 || $("#idFrom").val().search(a)==-1) {
		eventObject.preventDefault();
		alert('Not correct enter data. Check input!!!');
	}
}

function update(eventObject) {
	
	var a = /^[0-9]+$/;
	if ($("#idUpd").val().search(a)==-1 || $("#numberTripUpdate").val().search(a)==-1) {
		eventObject.preventDefault();
		alert('Not correct enter data. Check input!!!');
		
	}
}

function buyUnlim(eventObject) {
	
	var a = /^[a-zA-Z]+$/;
	if ($("#name").val().search(a)==-1 || $("#lastName").val().search(a)==-1) {
		eventObject.preventDefault();
		alert('Not correct enter data. Check input!!!');
	}
}

function buyNumber(eventObject) {
    eventObject.preventDefault();
	var a = /^[0-9]+$/;
	if ($("#numberTrip").val().search(a)!=-1) {
        ajaxBuyNumberCard();
	} else {
        alert('Not correct enter data. Check input!!!');
    }
}

function use(eventObject) {
    eventObject.preventDefault();
	var a = /^[0-9]+$/;
	if ($("#id").val().search(a)!=-1) {
        ajaxUseCard()
	} else {
        alert('Not correct enter data. Check input!!!');
    }
}
