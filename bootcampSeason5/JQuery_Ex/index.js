
$(document).ready(function () {

    dataConnect();

});

//AJAX

function dataConnect() {


    $.ajax({
        url: 'http://localhost:8080/javabank5/api/customer/',
        async: true,
        success: successCallback,
        error: errorCallback
    });

}

function deleteConnect(id) {
    $.ajax({
        url: 'http://localhost:8080/javabank5/api/customer/' + id,
        async: true,
        success: dataConnect,
        error: errorCallback,
        type: 'DELETE'
    });
}

function addConnect(firstName1, lastName1, email1, phone1) {
    $.ajax({
        url: 'http://localhost:8080/javabank5/api/customer/',
        type: 'POST',
        data: JSON.stringify({
            firstName: firstName1,
            lastName: lastName1,
            email: email1,
            phone: phone1,
        }),
        async: true,
        contentType: 'application/json',
        success: successCallback,
        error: errorCallback
    });
}

function updateConnect(id2,firstName1, lastName1, email1, phone1) {
    $.ajax({
        url: 'http://localhost:8080/javabank5/api/customer/'+ id2,
        type: 'PUT',
        
        data: JSON.stringify({
            firstName: firstName1,
            lastName: lastName1,
            email: email1,
            phone: phone1,
        }),

        async: true,
        contentType: 'application/json',
        success: dataConnect,
        error: errorCallback
    });
}



// Tables

function successCallback(response) {


    var customerData = response;
    var usersTable = $('#ListOfCustomer');

    usersTable.empty();

    customerData.forEach(function (customer) {
        var row = $('<tr></tr>');

        ["firstName", "lastName", "email", "phone"].forEach(function (key) {
            var cell = $('<td></td>');
            cell.text(customer[key]);
            row.append(cell);
        });

        var editCell = $('<td></td>');
        var customerId = customer.id
        var editButton = $("<button data-id=" + customerId + " class=edit-button>Edit</button>");
        editCell.append(editButton);
        row.append(editCell);

        var deleteCell = $('<td></td>');
        var deleteButton = $("<button data-id='" + customerId + "' class='delete-button'>Delete</button>");
        deleteCell.append(deleteButton);
        row.append(deleteCell);

        usersTable.append(row);
        editCustomer(customer);
    });

    deleteCustomer();
    


};

function errorCallback(request, status, error) {
    console.error("Error fetching customer data:", error);
}



// Buttons


function deleteCustomer() {
    $('.delete-button').click(function () {
       
        var customerId = $(this).data('id');
        deleteConnect(customerId)
        
        usersTable.empty();
        dataConnect();

    });
}

function editCustomer(customer) {
    $('.edit-button').click(function () {

        console.log(customer);

        $('#id').val(customer.id);
        var firstName = $('#firstName').val(customer.firstName);
        var lastName = $('#lastName').val(customer.lastName);
        var email = $('#email').val(customer.email);
        var phone = $('#phone').val(customer.phone);
        console.log(id);

        console.log(editConnect);
       //console.log(editConnect(id,firstName, lastName, email, phone));
    });
}

$('.add-button').click(function () {
    var firstName = $('#firstName').val();
    var lastName = $('#lastName').val();
    var email = $('#email').val();
    var phone = $('#phone').val();

    addConnect(firstName, lastName, email, phone);

});

function updateCustomer(customer) {
    $('.update-button').click(function () {

        var id = $('#id').val(customer.id)
        var firstName = $('#firstName').val(customer.firstName);
        var lastName = $('#lastName').val(customer.lastName);
        var email = $('#email').val(customer.email);
        var phone = $('#phone').val(customer.phone);

        console.log(id + firstName + lastName + email + phone);
        updateConnect(id,firstName, lastName, email, phone);
    });
}

$('.reset-button').click(function () {
    console.log("Reset")
});
