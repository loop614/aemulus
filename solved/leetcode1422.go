package main

import (
	"fmt"
	"strings"
)

func maxScore(s string) int {
	var scorecount int = 0
	var maxsum int = 0
	var lens int = len(s)

	if lens < 3 {
		if s[0] == '0' {
			scorecount++
		}
		if s[1] == '1' {
			scorecount++
		}
		return scorecount
	}

	scorecount = 0

	for i := 1; i < lens; i++ {
		scorecount = strings.Count(s[0:i], "0")
		scorecount += strings.Count(s[i:lens], "1")
		if scorecount > maxsum {
			maxsum = scorecount
		}
	}

	return maxsum
}

func main() {
	output := maxScore("011101")
	fmt.Println(output)
	fmt.Println(output == 5)

	output = maxScore("00111")
	fmt.Println(output)
	fmt.Println(output == 5)

	output = maxScore("1111")
	fmt.Println(output)
	fmt.Println(output == 3)

	output = maxScore("00")
	fmt.Println(output)
	fmt.Println(output == 1)

	output = maxScore("11")
	fmt.Println(output)
	fmt.Println(output == 1)

	output = maxScore("01001")
	fmt.Println(output)
	fmt.Println(output == 4)
}
