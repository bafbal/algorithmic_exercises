"use strict";

// Write a function that takes an array of numbers and returns the sum of the numbers. The numbers can be negative or non-integer. If the array does not contain any numbers then you should return 0.

console.log(sum([1, 5.2, 4, 0, -1]));
console.log(sum2([1, 5.2, 4, 0, -1]));
console.log(sum3([1, 5.2, 4, 0, -1]));
// Sum Numbers
function sum(numbers) {
  let sum = 0;
  for (let i = 0; i < numbers.length; i++) {
    sum += numbers[i];
  }
  return sum;
}

function sum2(numbers) {
  return numbers.reduce((sum, n) => sum + n, 0);
}

function sum3(numbers) {
  return numbers.reduce(function (sum, n) {
    return sum + n;
  }, 0);
}
