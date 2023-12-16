const assert = require('assert');
const { Given, When, Then } = require('@cucumber/cucumber');
const { getAll, convertToCSV } = require('../../ObjectToCSV');

Given('I have an Object', function () {
    this.object = {
        name: 'John',
        age: 30,
        city: 'New York',
        adress: {
            street: '5th Avenue',
            number: 123
        }
    };
});

When('I convert the Object to a CSV string', function () {
    this.csv = convertToCSV(getAll({...this.object}));
});

Then('I should get a CSV string', function () {
    assert.equal(this.csv, "name,age,city,street,number\nJohn,30,New York,5th Avenue,123\n");
});