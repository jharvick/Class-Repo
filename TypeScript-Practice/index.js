var mountains = [];
mountains.push({ name: 'Kilimanjaro', height: 19341 });
mountains.push({ name: 'Everest', height: 29029 });
mountains.push({ name: 'Denali', height: 20310 });
function findNameOfTallestMountain(mountains) {
    var tallestMountain = mountains[0];
    mountains.forEach(function (mountain) {
        if (mountain.height > tallestMountain.height) {
            tallestMountain = mountain;
        }
    });
    return tallestMountain.name;
}
console.log(findNameOfTallestMountain(mountains)); // Everest
