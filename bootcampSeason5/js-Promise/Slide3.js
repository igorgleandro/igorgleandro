//Redundant Promises

const PresentationDone = new Promise((resolve, reject) => { resolve('Presentation Done! Thank you!!') })
const SlideDone1 = new Promise((resolve, reject) => { resolve('Slide 1 Done') })
const SlideDone2 = new Promise((resolve, reject) => { resolve('Slide 2 Done') })
const SlideDone3 = new Promise((resolve, reject) => { resolve('Slide 3 Done') })

Promise.race([
    PresentationDone,
    SlideDone1,
    SlideDone2,
    SlideDone3
]).then((menssages) => { console.log(menssages) })


