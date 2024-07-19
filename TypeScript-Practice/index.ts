// interface Mountain {
//     name: string;
//     height: number;
// }

// const mountains: Mountain[] = [];

// mountains.push({ name: 'Kilimanjaro', height: 19341 });
// mountains.push({ name: 'Everest', height: 29029 });
// mountains.push({ name: 'Denali', height: 20310 });

// function findNameOfTallestMountain(mountains: Mountain[]): string {
//     let tallestMountain = mountains[0];
//     mountains.forEach(mountain => {
//         if (mountain.height > tallestMountain.height) {
//             tallestMountain = mountain;
//         }
//     });
//     return tallestMountain.name;
// }

// console.log(findNameOfTallestMountain(mountains));

interface Product {
    name: string;
    price: number;
}

const products: Product[] = [];

products.push({ name: 'Laptop', price: 1000 });
products.push({ name: 'Phone', price: 500 });
products.push({ name: 'Tablet', price: 200 });

function calcAverageProductPrice(products: Product[]): number {
    let totalPrice = 0;
    products.forEach(product => {
        totalPrice += product.price;
    });
    return totalPrice / products.length;
}

console.log(calcAverageProductPrice(products));

interface InventoryItem {
    product: Product;
    quantity: number;
}

const inventory: InventoryItem[] = [];

inventory.push({ product: { name: 'motor', price: 10.00 }, quantity: 10 });
inventory.push({ product: { name: 'sensor', price: 12.50 }, quantity: 4 });
inventory.push({ product: { name: 'LED', price: 1.00 }, quantity: 20 });

function calcInventoryValue(inventory: InventoryItem[]): number {
    let totalValue = 0;
    inventory.forEach(item => {
        totalValue += item.product.price * item.quantity;
    });
    return totalValue;
}

console.log(calcInventoryValue(inventory));