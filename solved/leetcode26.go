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
