
$(document).ready(function () {
    dataConnect();
    

});


function dataConnect(){
    $.ajax({
        url: 'http://localhost:8080/javabank5/api/customer/',
        async: true,
        success: successCallback,
        error: errorCallback
    });

}

function viewConnect(){
    $.ajax({
        url: 'http://localhost:8080/javabank5/api/customer/'+ customerData.getId,
        async: true,
        success: successCallbackView,
        error: errorCallback,
    });

}

function editConnect(){
    $.ajax({
        url: 'http://localhost:8080/javabank5/api/customer/'+ customerData.getId,
        async: true,
        success: successCallbackEdit,
        error: errorCallback,
        type: PUT,
        contentType: 'application/json',

    });

}

function deleteConnect(){
    $.ajax({
        url: 'http://localhost:8080/javabank5/api/customer/'+ customerData.getId,
        async: true,
        success: successCallbackDelete,
        error: errorCallback,
        type: DELETE,
    });

}

function successCallback(response) {


    var customerData = response;
    var usersTable = $('#ListOfCustomer');

    customerData.forEach(function (customer) {
        var row = $('<tr></tr>');

        ["firstName", "lastName", "email", "phone"].forEach(function (key) {
            var cell = $('<td></td>');
            cell.text(customer[key]);
            row.append(cell);
        });


        var viewCell = $('<td></td>');
        var viewButton = $('<button class="view-button">View</button>');
        viewButton.on('click', function () {
            window.location.href = customer.id;
        });
        viewCell.append(viewButton);
        row.append(viewCell);

        var editCell = $('<td></td>');
        var editButton = $('<button class="edit-button">Edit</button>');
        editCell.append(editButton);
        row.append(editCell);

        var deleteCell = $('<td></td>');
        var deleteButton = $('<button class="delete-button">Delete</button>');
        deleteCell.append(deleteButton);
        row.append(deleteCell);

        usersTable.append(row);
    });
};

function errorCallback(request, status, error) {
console.error("Error fetching customer data:", error);
}