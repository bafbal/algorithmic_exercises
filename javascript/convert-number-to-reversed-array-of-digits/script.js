"use strict";

// Given a random non-negative number, you have to return the digits of this number within an array in reverse order.

console.log(digitize(35231));

function digitize(n) {
  let result = [];
  const nAsString = String(n);
  for (let i = nAsString.length - 1; i >= 0; i--) {
    result.push(Number(nAsString.charAt(i)));
  }
  return result;
}
