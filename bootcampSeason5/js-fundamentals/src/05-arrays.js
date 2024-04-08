/**
 * Determine the location of an item in the array
 */
exports.indexOf = function(arr, item) {
    return arr.indexOf(item);
};


/**
 * Sum the items of an array
 */
exports.sum = function(arr) {
    var total = 0;
    for (var i = 0; i < arr.length; i++) {
        total += arr[i];
    }
    return total;
};


/**
 * Remove all instances of an item from an array
 */
exports.remove = function(arr, item) {
    return arr.filter(function(element) {
        return element !== item;
    });
};


/**
 * Remove all instances of an item from an array by mutating original array
 */
exports.removeWithoutCopy = function(arr, item) {
        for (var i = arr.length - 1; i >= 0; i--) {
            if (arr[i] === item) {
                arr.splice(i, 1);
            }
        }
        return arr;
    };
    

/**
 * Add an item to the end of the array
 */
exports.append = function(arr, item) {
    arr.push(item);
    return arr;
 };
 

/**
 * Remove the last item of an array
 */
exports.truncate = function(arr) {
    arr.pop();
    return arr;
 };

/**
 * Add an item to the beginning of an array
 */
exports.prepend = function(arr, item) {
        arr.unshift(item);
        return arr;
    };
    


/**
 * Remove the first item of an array
 */
exports.curtail = function(arr) {
    arr.shift();
    return arr;
};

/**
 * Join two arrays together
 */
exports.concat = function(arr1, arr2) {
};

/**
 * Add an item to an array in the specified position
 */
exports.insert = function(arr, item, index) {
};

/**
 * Count the number of occurrences of an item in an array
 */
exports.count = function(arr, item) {
};

/**
 * Find all items which container multiple occurrences in the array
 */
exports.duplicates = function(arr) {
};

/**
 * Square each number in the array
 */
exports.square = function(arr) {
};

/**
 * Find all occurrences of an item in an array
 */
exports.findAllOccurrences = function(arr, target) {
};
