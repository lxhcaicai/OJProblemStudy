package main

import "fmt"

const N = 1e5 + 100

func quick(a []int, l, r int) {
	mid := a[(l+r)>>1]
	i := l
	j := r

	for i < j {
		for a[i] < mid {
			i++
		}
		for a[j] > mid {
			j--
		}
		if i <= j {
			a[i], a[j] = a[j], a[i]
			i++
			j--
		}
	}
	if i < r {
		quick(a, i, r)
	}
	if l < j {
		quick(a, l, j)
	}
}

func main() {
	var n int
	fmt.Scan(&n)
	a := make([]int, n+1)
	for i := 1; i <= n; i++ {
		fmt.Scan(&a[i])
	}
	quick(a, 1, n)
	for i := 1; i <= n; i++ {
		fmt.Printf("%d ", a[i])
	}
}
