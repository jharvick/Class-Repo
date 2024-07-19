// interface Mountain {
//     name: string;
//     height: number;
// }
var products = [];
products.push({ name: 'Laptop', price: 1000 });
products.push({ name: 'Phone', price: 500 });
products.push({ name: 'Tablet', price: 200 });
function calcAverageProductPrice(products) {
    var totalPrice = 0;
    products.forEach(function (product) {
        totalPrice += product.price;
    });
    return totalPrice / products.length;
}
console.log(calcAverageProductPrice(products));
var inventory = [];
inventory.push({ product: { name: 'motor', price: 10.00 }, quantity: 10 });
inventory.push({ product: { name: 'sensor', price: 12.50 }, quantity: 4 });
inventory.push({ product: { name: 'LED', price: 1.00 }, quantity: 20 });
function calcInventoryValue(inventory) {
    var totalValue = 0;
    inventory.forEach(function (item) {
        totalValue += item.product.price * item.quantity;
    });
    return totalValue;
}
console.log(calcInventoryValue(inventory));
