
var path = ''
function selectPath() {
    var selectId = document.getElementById("select-path").value;
    var request = ''
    if (selectId == 'payment') {
        path = '/qr/payment'
        request = 'payment'
    } else if (selectId == 'check') {
        path = '/qr/check'
        request = 'check'
    } else if (selectId == 'refund') {
        path = '/qr/refound'
        request = 'refound'
    }else if(selectId == 'inquiry') {
        path = '/qr/inquiry'
        request = 'inquiry'
    } else if (selectId == 'payment/debit') {
        path = '/qr/payment/debit'
        request = 'paymentdebit'
    }else if(selectId == 'payment/reversal') {
        path = '/qr/payment/reversal'
        request = 'paymentreversal'
}

    putRequest(request)
    $('#path').val(path);
}

function putRequest(req) {
    $.ajax({
        url: "/api/" + req,
        type: 'GET',
        success: function (response) {
            document.getElementById('request').value = response;
        },
        error: function (error) {
            errorFunction(error, parameter);
        }
    });
}

function removeRequest() {
    document.getElementById('request').value = '';
}

function sendRequest() {
    var request = document.getElementById('request').value;
    $.ajax({
        url: path,
        type: 'POST',
        data: request,
        contentType: 'application/json',
        dataType : 'json',
        success: function (response) {
            document.getElementById('response').value = JSON.stringify(response);
        },
        error: function (error) {
            console.log(error)
        }
    });
}