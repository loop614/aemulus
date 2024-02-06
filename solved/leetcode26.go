/*
26. Remove Duplicates from Sorted Array
Easy
Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same. Then return the number of unique elements in nums.
Consider the number of unique elements of nums to be k, to get accepted, you need to do the following things:
    Change the array nums such that the first k elements of nums contain the unique elements in the order they were present in nums initially. The remaining elements of nums are not important as well as the size of nums.
    Return k.

Custom Judge:
The judge will test your solution with the following code:
int[] nums = [...]; // Input array
int[] expectedNums = [...]; // The expected answer with correct length
int k = removeDuplicates(nums); // Calls your implementation
assert k == expectedNums.length;
for (int i = 0; i < k; i++) {
    assert nums[i] == expectedNums[i];
}
If all assertions pass, then your solution will be accepted.
*/
package main

import "fmt"

func inArray(haystack []int, needle int) bool {
	for i := 0; i < len(haystack); i++ {
		if haystack[i] == needle {
			return true
		}
	}
	return false
}

func removeDuplicates2(nums []int) int {
	var uniques []int
	for i := 0; i < len(nums); i++ {
		if !inArray(uniques, nums[i]) {
			uniques = append(uniques, nums[i])
		}
	}

	for i := 0; i < len(uniques); i++ {
		nums[i] = uniques[i]
	}

	return len(uniques)
}

/*
* beats 100% by execution time
* beats 78% by memory usage
*/
func removeDuplicates(nums []int) int {
	var pivot int = 1

	for i := 1; i < len(nums); i++ {
		if nums[i-1] < nums[i] {
			nums[pivot] = nums[i]
			pivot++
		}
	}

	return pivot
}

func main() {
	input := []int{1, 1, 2}
	output := removeDuplicates(input)

	fmt.Println(output)
	for i := 0; i < len(input); i++ {
		fmt.Print(input[i])
	}
	fmt.Print("\n")

	input = []int{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}
	output = removeDuplicates(input)
	fmt.Println(output)
	for i := 0; i < len(input); i++ {
		fmt.Print(input[i])
	}
}
