package main

/*
1637. Widest Vertical Area Between Two Points Containing No Points
Easy

Given n points on a 2D plane where points[i] = [xi, yi], Return the widest vertical area between two points such that no points are inside the area.
A vertical area is an area of fixed-width extending infinitely along the y-axis (i.e., infinite height). The widest vertical area is the one with the maximum width.
Note that points on the edge of a vertical area are not considered included in the area.
*/

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
