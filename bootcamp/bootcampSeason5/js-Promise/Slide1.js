// Promises Code;
// A Promises can be Resolved or Rejected

//Creating a Promise

let p = new Promise(function (fulfilled, reject) {
    let a = 1 + 1;

    if (a == 3) {
        fulfilled('Success');
    } else {
        reject('Failed')
    }
})

//Using Promises

p.then(function(message){
    console.log('This is in the then: ' + message)
}).catch(function(message){
    console.log('This is in the then: ' + message)
})