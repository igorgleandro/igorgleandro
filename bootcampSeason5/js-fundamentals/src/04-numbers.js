/**
 * Convert a binary String to a Number
 */
exports.binaryToDecimal = function(str) {
   
        var decimal = parseInt(str, 2);
        return decimal;  
};

/**
 * Add two Numbers with a precision of 2
 */
exports.add =  function(a, b) {

    var sum = a + b;
    return Math.round(sum * 100) / 100;

};

/**
 * Multiply two Numbers with a precision of 4
 */
exports.multiply = function(a, b) {
    let precision = 4;
    let multiplier = Math.pow(10, precision);
    let result = Math.round(parseFloat(a) * multiplier) * Math.round(parseFloat(b) * multiplier);
    return result / Math.pow(10, precision * 2);
};

