class Solution:
    def reverse(self, x: int) -> int:
        x_str = str(x)
        if len(x_str) == 1:
            return x

        reversed_x_str = x_str[::-1]
        reversed_x_str = reversed_x_str.strip("0")
        if reversed_x_str[-1] == "-":
            reversed_x_str = "-" + reversed_x_str[:-1]

        if len(reversed_x_str) < 9:
            return int(reversed_x_str)

        res = int(reversed_x_str)
        if res > pow(2, 31) or -1 * res > pow(2, 31):
            return 0

        return res


def main():
    iterations = {
        "input": [123, -123, 120, 0, 1534236469, -1534236469],
        "output": [321, -321, 21, 0, 0, 0]
    }
    for i, iter in enumerate(iterations["input"]):
        res = Solution().reverse(iter)
        if res == iterations["output"][i]:
            print("Success: " + str(iter) + " is " + str(res))
            continue

        print("Error: " + str(iter) + " expected " + str(iterations["output"][i]) + " got " + str(res))


if __name__ == "__main__":
    main()
