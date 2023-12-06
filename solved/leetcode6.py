"""
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
P A H N
A P L S I I G
Y I R

And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:
string convert(string s, int numRows);

Example 1:
Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"

Example 2:
Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:
P     I    N
A   L S  I G
Y A   H R
P     I

Example 3:
Input: s = "A", numRows = 1
Output: "A"

Constraints:
1 <= s.length <= 1000
s consists of English letters (lower-case and upper-case), ',' and '.'.
1 <= numRows <= 1000
"""


class Solution:
    def convert(self, s: str, numRows: int) -> str:
        matx = [[] for _ in range(numRows)]
        res = ""
        res_count = 0
        len_s = len(s) - 1
        if numRows == 1 or len_s == 0:
            return s

        while res_count <= len_s:
            for i in range(0, numRows):
                if res_count > len_s:
                    break

                matx[i].append(s[res_count])
                res_count += 1

            pivot = 1
            for i in range(1, numRows - 1):
                for j in range(numRows):
                    if res_count > len_s:
                        break

                    if j == numRows - pivot - 1:
                        pivot += 1
                        matx[j].append(s[res_count])
                        res_count += 1
                        continue

                    matx[j].append("-")

        print('\n'.join(['\t'.join([str(cell) for cell in row]) for row in matx]))
        for i in matx:
            for j in i:
                if j != "-":
                    res += j

        return res


def main():
    iterations = {
        "input": [["PAYPALISHIRING", 5], ["PAYPALISHIRING", 3], ["PAYPALISHIRING", 4], ["A", 1], ["ABC", 2]],
        "output": ["PHASIYIRPLIGAN", "PAHNAPLSIIGYIR", "PINALSIGYAHRPI", "A", "ACB"]
    }
    for i, iter in enumerate(iterations["input"]):
        res = Solution().convert(iter[0], iter[1])
        if res == iterations["output"][i]:
            print("Success: " + iter[0] + " is " + res)
            continue

        print("Error: " + iter[0] + " expected " + iterations["output"][i] + " got " + res)


if __name__ == "__main__":
    main()
