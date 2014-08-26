function ajaxDeleteCard(id) {

    $.ajax({
        url : '/delete',
        data : 'id=' + id,
        type : 'POST',

        success : function(data) {
            $('#Table'+id).fadeOut(1000);
        },
        error : function(xhr, status, errorThrown) {
            alert('Delete card failed with status: ' + status + '. ' + errorThrown);
        }
    });
}