
function ajaxBuyNumberCard() {
    $('.succesful').hide();

    var numberCard = {
        id : null,
        active : true,
        numberTrip : $('#numberTrip').val(),
        cardType: 'NUMBER'
    };

    $.ajax({
        url : '../buy/numberCard',
        data : {numberCard : JSON.stringify(numberCard)},
        type: 'POST',

        success : function(data) {
            data = $.parseJSON(data);
            $('.succesful').html(data.ok).show();
        },
        error : function(xhr, status, errorThrown) {
            alert('Buy card failed with status: ' + status + '. ' + errorThrown);
        }
    });
}