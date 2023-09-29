package main

import "fmt"

// AcWing 1017. 怪盗基德的滑翔翼
func main() {
	var t int
	fmt.Scan(&t)
	for ; t > 0; t-- {
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
				if a[i] < a[j] {
					f[i] = max(f[i], f[j]+1)
				}
			}
		}

		for i := n; i >= 1; i-- {
			for j := n; j > i; j-- {
				if a[i] < a[j] {
					g[i] = max(g[i], g[j]+1)
				}
			}
		}
		fmt.Println(max(getMax(f), getMax(g)))
	}
}

func getMax(a []int) int {
	maxn := a[0]
	for i := range a {
		maxn = max(maxn, a[i])
	}
	return maxn
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}
