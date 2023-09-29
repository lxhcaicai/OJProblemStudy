package main

import "fmt"

// AcWing 482. 合唱队形
func main() {
	var n int
	fmt.Scan(&n)
	a := make([]int, n+1)
	f := make([]int, n+1)
	g := make([]int, n+1)
	for i := 1; i <= n; i++ {
		fmt.Scan(&a[i])
		f[i] = 1
		g[i] = 1
	}
	for i := 1; i <= n; i++ {
		for j := 1; j < i; j++ {
			if a[i] > a[j] {
				f[i] = max(f[i], f[j]+1)
			}
		}
	}

	for i := n; i >= 1; i-- {
		for j := n; j > i; j-- {
			if a[i] > a[j] {
				g[i] = max(g[i], g[j]+1)
			}
		}
	}

	ans := 0
	for i := 1; i <= n; i++ {
		ans = max(ans, f[i]+g[i]-1)
	}
	fmt.Println(n - ans)
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}
