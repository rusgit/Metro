
function ajaxUseCard() {

    $('#useInfo').hide();
    $('div.open').hide();
    $('div.close').hide();
    $('div.tableResult').hide();
    $('div.exception').hide();

    var inp = $("#id").val();

    $.ajax({

        url : 'use/card',
        data : 'inp=' +inp,
        type : "POST",

        success : function(data) {
            try {
                data = $.parseJSON(data);
            } catch (e) {
                //do nothing
            }
            if (data.access == 'open') {
                $('#useInfo').show();
                $('div.open').show();
            }
            if (data.access == 'close') {
                $('#useInfo').show();
                $('div.close').show();
            }

            if (data.exception != null) {
                $('div.exception').html(data.exception).show();
            }

            if (data.card != null && data.card.cardType == 'NUMBER') $('div.tableResult')
                .html("<table>" +
                    "<tr>" +
                        "<th>ID</th>" +
                        "<th>TYPE</th>" +
                        "<th>NUMBER TRIP</th>" +
                        "<th>ACTIVE</th>" +
                    "</tr>" +
                    "<tr>" +
                        "<td>"+data.card.id+"</td>" +
                        "<td> NUMBER </td>" +
                        "<td>"+data.card.numberTrip+"</td>" +
                        "<td>"+data.card.active+"</td>" +
                    "</tr>" +
                "</table>")
                .show();

             if (data.card != null && data.card.cardType == 'UNLIM') $('div.tableResult')
                 .html("<table>" +
                     "<tr>" +
                         "<th>ID</th>" +
                         "<th>TYPE</th>" +
                         "<th>NAME</th>" +
                         "<th>LAST NAME</th>" +
                         "<th>ACTIVE</th>" +
                     "</tr>" +
                     "<tr>" +
                         "<td>"+data.card.id+"</td>" +
                         "<td> UNLIM </td>" +
                         "<td>"+data.card.name+"</td>" +
                         "<td>"+data.card.lastName+"</td>" +
                         "<td>"+data.card.active+"</td>" +
                     "</tr>" +
                 "</table>")
                 .show();

            if (data.card != null && data.card.cardType == 'TIME') $('div.tableResult')
                .html("<table>" +
                    "<tr>" +
                        "<th>ID</th>" +
                        "<th>TYPE</th>" +
                        "<th>VALIDITY</th>" +
                        "<th>EXPIRATION</th>" +
                        "<th>ACTIVE</th>" +
                    "</tr>" +
                    "<tr>" +
                        "<td>"+data.card.id+"</td>" +
                        "<td> TIME </td>" +
                        "<td>"+data.card.validity+"</td>" +
                        "<td>"+data.card.expirationDate+"</td>" +
                        "<td>"+data.card.active+"</td>" +
                    "</tr>" +
                "</table>")
                .show();

        },
        error : function(xhr, status, errorThrown) {
            alert('Use card failed with status: ' + status + '. ' + errorThrown);
        }
    });
}


