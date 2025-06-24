// khai bao bien

// dung khi khai bao cac bien global, dung chung cho ca file hoac nhieu method
var demo1 = 10;

// dung khi muon khai bao cac bien local chi hoat dong trong 1 pham vi nhat dinh nhu 1 khoi lenh, 1 function, method
let demo2 = 20;

// khai bao cac hang so
const demo3 = true;

console.log(demo1);
console.log(demo2);
console.log(demo3);

demo1 = 'demo2';

var person = {
    name: "John",
    age: 25,
    address: "hanoi",
    deleted: false
}

console.log(person);
console.log(person.name);

var arr = ['Cam', 'Tao', 'Vai', 'Sau'];
arr.push('Le');
console.log(arr);
console.log(arr[3]);