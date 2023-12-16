function getAll(...objects) {
    const all = {};
    let rep = {};
    let index = 0;

    function init(n, key) {
        all[key] = [];
        for (let i = 0; i < n; i++) {
            all[key].push('null');
        }
    }

    function traverse(object, parent = '') {
        for (const key in object) {
            rep[key] === undefined ? (rep[key] = 0) : rep[key]++;
            const repKey = key + (rep[key] > 0 ? `_${parent}` : '');
            const value = object[key];
            if (typeof value === 'object') {
                traverse(value, key);
            } else {
                if (all[repKey]) {
                    all[repKey][index] = value;
                } else {
                    init(objects.length, repKey);
                    all[repKey][index] = value;
                }
            }
        }
    }

    for (const object of objects) {
        rep = {};
        traverse(object);
        index++;
    }

    return all;
}

function convertToCSV(data) {
    let csv = '';
    for (const key in data) {
        csv += `${key},`;
    }
    csv = csv.slice(0, -1);
    csv += '\n';
    const max = Math.max(...Object.values(data).map((v) => v.length));
    for (let i = 0; i < max; i++) {
        for (const key in data) {
            csv += `${data[key][i] instanceof Array ? data[key][i] : data[key][i].toString()},`;
        }
        csv = csv.slice(0, -1);
        csv += '\n';
    }
    return csv;
}

module.exports = {
    getAll,
    convertToCSV,
}