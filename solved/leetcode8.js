// 8. String to Integer (atoi)
// Medium
// Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer (similar to C/C++'s atoi function).
// The algorithm for myAtoi(string s) is as follows:
//     Read in and ignore any leading whitespace.
//     Check if the next character (if not already at the end of the string) is '-' or '+'. Read this character in if it is either. This determines if the final result is negative or positive respectively. Assume the result is positive if neither is present.
//     Read in next the characters until the next non-digit character or the end of the input is reached. The rest of the string is ignored.
//     Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32). If no digits were read, then the integer is 0. Change the sign as necessary (from step 2).
//     If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then clamp the integer so that it remains in the range. Specifically, integers less than -231 should be clamped to -231, and integers greater than 231 - 1 should be clamped to 231 - 1.
//     Return the integer as the final result.
// Note:
//     Only the space character ' ' is considered a whitespace character.
//     Do not ignore any characters other than the leading whitespace or the rest of the string after the digits.

/**
 * @param {string} s
 * @return {number}
 *
 * beats 45% by execution time
 * beats 77% by memory usage
 */
var myAtoi = function(s) {
    let cleanS = "";
    s = s.trim();
    let pivot = 0;
    let isPositive = true;
    let hadZero = false;
    let hadPlus = false;
    let hadMinus = false;
    let hadNumber = false;

    while(pivot < s.length) {
        let charcode= s.charCodeAt(pivot);
        // 48 is 0
        if (charcode === 48 && !hadNumber) { hadZero = true; pivot++; continue }
        // 45 is minus
        if (charcode === 45) {
            if(hadMinus) break
            if(hadPlus) break
            hadMinus = true;
            if(!hadZero) {
                pivot++; isPositive = false; continue
            }
            break;
        }

        // 43 is plus
        if (charcode === 43) {
            hadPlus = true;
            if (hadZero) break
            if (!hadMinus) {pivot++; continue}
            break;
        }

        if(charcode > 47 && charcode < 58) {
            cleanS += s[pivot];
            pivot++;
            hadNumber = true;
            continue
        }

        break;
    }

    if (cleanS.length < 1) { return 0; }
    if (cleanS.length > 10) {
        if (isPositive) return 2147483647
        return -2147483648;
    }

    if (!isPositive) cleanS = "-" + cleanS
    let numberS = Number(cleanS);

    if (numberS < -2147483648) {
        return -2147483648;
    }

    if (numberS > 2147483647) {
        return 2147483647;
    }

    return numberS;
};

let iterations = {
    "input": ["000+85", " --2", "2147483648", "2147483646", "-000000000000001", "00000-42a1234", "42", "          -42", "004193 with words", "4193 with words 4559", "-91283472332", "-+12", "+001", "with 004193 words 4559 with", "words and 987", "+-12", "21474836460"],
    "output": [0, 0, 2147483647, 2147483646, -1, 0, 42, -42, 4193, 4193, -2147483648, 0, 1, 0, 0, 0, 2147483647],
}

for (let iter = 0; iter < iterations["input"].length; iter++) {
    let res = myAtoi(iterations["input"][iter]);
    if (iterations["output"][iter] === res) {
        console.log(`Success ${iter} : input ${iterations["input"][iter]}, expected ${iterations["output"][iter]}, res ${res}`);
        continue;
    }
    console.log(`Error ${iter} : input ${iterations["input"][iter]}, expected ${iterations["output"][iter]}, res ${res}`);
}
