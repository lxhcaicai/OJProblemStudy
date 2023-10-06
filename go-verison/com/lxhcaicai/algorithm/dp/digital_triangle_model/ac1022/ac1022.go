package main

import "fmt"

func main() {
	var n, m, k int
	fmt.Scan(&n, &m, &k)
	f := make([][]int, n+1)
	for i := range f {
		f[i] = make([]int, m+1)
	}

	for i := 1; i <= k; i++ {
		var a, b int
		fmt.Scan(&a, &b)
		for j := n; j >= a; j-- {
			for g := m; g >= b; g-- {
				f[j][g] = max(f[j][g], f[j-a][g-b]+1)
			}
		}
	}

	ans, res := 0, 0
	for i := 1; i <= n; i++ {
		for j := 0; j < m; j++ {
			if f[i][j] > ans || (ans == f[i][j] && res > j) {
				ans = f[i][j]
				res = j
			}
		}
	}

	fmt.Printf("%d %d", ans, (m - res))
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}
