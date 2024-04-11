$(document).ready(function () {

    fetchData(processResults);

    function fetchData(cb) {
        $.ajax({
            url: 'https://api.github.com/search/users?q=',
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
            var user = $('#user'); 
            
            fetchData
            var container = $('#search');
            container.html('<p>' + user + ' user</p>');
        });
        

    }

});