const fs = require('fs');
const path = require('path');
const { getAll, convertToCSV } = require('./ObjectToCSV');

const data = fs.readFileSync(path.join(__dirname, 'data.json'), 'utf8');
const object = JSON.parse(data);
const csv = convertToCSV(getAll({...object}));

fs.writeFileSync(path.join(__dirname, 'data.csv'), csv);