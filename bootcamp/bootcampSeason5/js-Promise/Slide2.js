//CallBack and Promises
const userAttetion = true;
const userOnThePhone = false;

// Callback
function watchSummarizerCallBack(callback,errorCallback){
if (userAttetion){
    errorCallback({
        name: 'Please pay attention! ',
        message: ':('
    })
} else if (userOnThePhone){
    errorCallback({
        name: 'User on the phone',
        message: 'Phone < Summarizer!'
    })
} else {
    callback('Thumbs up!')
}
}

watchSummarizerCallBack((message) => { 
    console.log('Success: ' + message)
}, ( error) => {
    console.log(error.name + ' ' + error.message)
})

//Promise

function watchSummarizerPromise(){
    return new Promise((resolve, reject) => {      
    
        if (userAttetion){
            reject({
            name: 'Please pay attention! ',
            message: ':('
        })
    } else if (userOnThePhone){
        reject({
            name: 'User on the phone',
            message: 'Phone < Summarizer!'
        })
    } else {
        resolve('Thumbs up!')
    }
    })
}

//add Then and Catch
watchSummarizerPromise().then((message) => { 
    console.log('Success: ' + message)
}).catch(( error) => {
    console.log(error.name + ' ' + error.message)
})
