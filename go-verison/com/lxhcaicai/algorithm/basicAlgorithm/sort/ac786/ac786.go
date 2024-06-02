package main

import "fmt"

const N = 15 + 100

func findK(a []int, l, r, k int) int {
	if l >= r {
		return a[l]
	}
	mid := a[(l+r)>>1]
	i := l - 1
	j := r + 1
	for i < j {
		for {
			i++
			if a[i] >= mid {
				break
			}
		}

		for {
			j--
			if a[j] <= mid {
				break
			}
		}
		if i < j {
			a[i], a[j] = a[j], a[i]
		}
	}
	if j-l+1 >= k {
		return findK(a, l, j, k)
	} else {
		return findK(a, j+1, r, k-(j-l+1))
	}
}

func main() {
	var n, k int
	fmt.Scan(&n, &k)
	a := make([]int, n+10)
	for i := 1; i <= n; i++ {
		fmt.Scan(&a[i])
	}
	t := findK(a, 1, n, k)
	fmt.Println(t)
}
