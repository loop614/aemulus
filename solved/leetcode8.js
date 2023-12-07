/**
 * @param {string} s
 * @return {number}
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
