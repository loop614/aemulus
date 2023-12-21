package main

import (
	"fmt"
	"sort"
)

func maxWidthOfVerticalArea(points [][]int) int {
	var firstMembers []int
	pointsLen := len(points)

	for i := 0; i < pointsLen; i++ {
		firstMembers = append(firstMembers, points[i][0])
	}
	sort.Ints(firstMembers)
	var diff = 0
	var maxDiff = 0
	for i := 0; i < pointsLen-1; i++ {
		diff = firstMembers[i+1] - firstMembers[i]
		if diff > maxDiff {
			maxDiff = diff
		}
	}

	return maxDiff
}

func main() {
	output := maxWidthOfVerticalArea([][]int{{8, 7}, {9, 9}, {7, 4}, {9, 7}})
	fmt.Println(output)
	fmt.Println(output == 1)

	output = maxWidthOfVerticalArea([][]int{{3, 1}, {9, 0}, {1, 0}, {1, 4}, {5, 3}, {8, 8}})
	fmt.Println(output)
	fmt.Println(output == 3)
}
