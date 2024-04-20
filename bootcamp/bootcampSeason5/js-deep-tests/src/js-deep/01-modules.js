/**
 * Creates a counter module with an initial value, zero if not provided
 */
exports.createCounter = function (counter) {

    var qualquer = counter ? counter : 0;

    const batata = {
        get: function () { return qualquer },
        increment: function () { qualquer++ },
        reset: function () { qualquer = 0 }
    }

    return batata;

};

/**
 * Creates a person module with name and age
 * An initial name value should be provided and
 * an exception thrown if not
 */
exports.createPerson = function (name) {
    if (!name) {
        throw new Error('Name parameter is required.');
    }

    var age = 0;

    const person = {

        getName: function () { return name; },
        getAge: function () { return age; },
        setName: function (newName) { name = newName; },
        setAge: function (newAge) { age = newAge }
    };

    return person;

};
