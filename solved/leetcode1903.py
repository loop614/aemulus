# 1903. Largest Odd Number in String
# Easy
# You are given a string num, representing a large integer. Return the largest-valued odd integer (as a string) that is a non-empty substring of num, or an empty string "" if no odd integer exists.
# A substring is a contiguous sequence of characters within a string.
class Solution(object):
    def largestOddNumber(self, num):
        """
        :type num: str
        :rtype: str
        """
        pivot = len(num) - 1
        while pivot >= 0:
            if num[pivot] in ["1", "3", "5", "7", "9"]:
                return num[0:pivot+1]

            pivot -= 1

        return ""

    def largestOddNumber2(self, num):
        """
        :type num: str
        :rtype: str
        """
        if num[-1] in ["1", "3", "5", "7", "9"]:
            return num
        elif len(num) > 1:
            return self.largestOddNumber2(num[:-1])
        elif len(num) <= 1:
            return ""
        return self.largestOddNumber2(num)


if __name__ == '__main__':
    print(Solution().largestOddNumber("52"))
    print(Solution().largestOddNumber("4206"))
    print(Solution().largestOddNumber("354274"))
