# 6. Zigzag Conversion
# Medium
class Solution:
    # beats 5% by execution time
    # beats 8% by memory usage
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
