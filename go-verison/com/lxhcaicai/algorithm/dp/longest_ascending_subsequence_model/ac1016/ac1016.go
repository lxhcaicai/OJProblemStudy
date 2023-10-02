package main

import "fmt"

func main() {
	var n int
	fmt.Scan(&n)
	a := make([]int, n+1)
	f := make([]int, n+1)
	for i := 1; i <= n; i++ {
		fmt.Scan(&a[i])
		f[i] = a[i]
	}
	for i := 1; i <= n; i++ {
		for j := 1; j < i; j++ {
			if a[i] > a[j] {
				f[i] = max(f[i], f[j]+a[i])
			}
		}
	}
	ans := f[1]
	for i := 1; i <= n; i++ {
		ans = max(ans, f[i])
	}
	fmt.Println(ans)
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}
