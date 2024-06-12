onLoad = (executionContext) => {

    const formContext = executionContext.getFormContext();
    const name = formContext.getAttribute("bool_name").getValue();
    const employee = formContext.getAttribute("bool_employee").getValue();
    const travelCost = formContext.getAttribute("bool_travelcosts").getValue();
    const insuranceCost = formContext.getAttribute("bool_insurancecost").getValue();
    const otherCost = formContext.getAttribute("bool_othercosts").getValue();
    const totalCost = formContext.getAttribute("bool_totalcost").getValue();
    const reimbursmeentStatus = formContext.getAttribute("bool_paidunpaid").getValue();
};



setTotalCost = (executionContext) => {

    const formContext = executionContext.getFormContext();
    const travelCost = formContext.getAttribute("bool_travelcosts").getValue();
    const insuranceCost = formContext.getAttribute("bool_insurancecost").getValue();
    const otherCost = formContext.getAttribute("bool_othercosts").getValue();

    if (travelCost != null && insuranceCost != null && otherCost != null){
        const totalCost = travelCost + insuranceCost + otherCost;
        formContext.getAttribute("bool_totalcost").setValue(totalCost);
    }
}

validateTotalCost = (executionContext) => {

    const formContext = executionContext.getFormContext();
    const totalCost = formContext.getAttribute("bool_totalcost").getValue();

    if(totalCost < 1 || totalCost === Null){
  
        var notification = 
                {
                type: 2,
                level: 2, 
                message: "Total Amount should be greater then zero."
                }

                Xrm.App.addGlobalNotification(notification).then(
                    function success(result) {
                        console.log("Notification created with ID: " + result);
                    
                    },
                    function (error) {
                        console.log(error.message);
                
                    }
                );

    }
}

approve = (primaryControl) => {

    const formContext = primaryControl;
    const statusCode = formContext.getAttribute("bool_paidunpaid").getValue();

    if (statusCode === 1){
        formContext.getAttribute("bool_paidunpaid").setValue(746500001);
    }

}
