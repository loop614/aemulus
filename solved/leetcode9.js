/*
9. Palindrome Number
Easy
Given an integer x, return true if x is a palindrome, and false otherwise.
*/
function numDigits(x) {
    return Math.max(Math.floor(Math.log10(Math.abs(x))), 0) + 1;
}

function isPalindrome(x) {
    if (x < 0) return false;

    var pivot = 1;
    var numOfDigits = numDigits(x);
    while (pivot <= x) {
        var temp = Math.floor((x / pivot) % 10);
        var temp2 = Math.floor((x / pivot * 10 * numOfDigits) % 10);
        numOfDigits--;
        pivot *= 10;
        if (temp !== temp2) {
            return false;
        }
    }
    return true;
}
var iterations = [{
        input: 121,
        output: true,
    },
    {
        input: -121,
        output: false,
    },
    {
        input: 10,
        output: false,
    },
    {
        input: 2112,
        output: true,
    }];

var res;

for (var i = 0; i < iterations.length; i++) {
    res = isPalindrome(iterations[i].input);
    if (res === iterations[i].output) {
        console.log("SUCCESS: " + iterations[i].input);
        continue;
    }
    console.log("FAILED: " + iterations[i].input);
}
