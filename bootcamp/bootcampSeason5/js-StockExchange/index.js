$(document).ready(function () {

    fetchData(processResults);

    function fetchData(cb) {
        $.ajax({
            url: 'https://open.er-api.com/v6/latest/USD',
            type: 'GET',
            dataType: 'json',
            success: function (results) { cb(null, results) },
            error: function (request, statusText, httpError) { cb(httpError || statusText) }
        });
    }

    function processResults(error, data) {
        if (error) {
            console.log("Error fetching rates", error);
            return;
        }

        var eur = data.rates.EUR;


    $('#getAmount').click(function (event) { 
            event.preventDefault();
            var amount = parseFloat($('#amount').val()); 
            var exchangedAmount = amount * eur;
            var container = $('#rate');
            console.log(amount);
            container.html('<p>' + amount + ' USD = ' + exchangedAmount.toFixed(2) + ' EUR</p>');
        });
        

    }

});
