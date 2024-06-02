package main

import (
	"fmt"
	"math"
)

const eps = 1e-8

func check(x, n float64) bool {
	return x*x*x >= n
}

func main() {
	var n float64
	fmt.Scan(&n)
	l := -10000.0
	r := 10000.0
	for math.Abs(r-l) > eps {
		mid := (l + r) / 2
		if check(mid, n) {
			r = mid
		} else {
			l = mid
		}
	}
	fmt.Printf("%.6f", r)
}
