package main

import "fmt"

func main() {
	var n, m int
	fmt.Scan(&n, &m)
	dp := make([][]int, n+1)
	for i := range dp {
		dp[i] = make([]int, m+1)
	}
	w := make([][]int, n+1)
	for i := range w {
		w[i] = make([]int, m+1)
	}
	for i := 1; i <= n; i++ {
		for j := 1; j <= m; j++ {
			fmt.Scan(&w[i][j])
		}
	}
	for i := 1; i <= n; i++ {
		for j := 0; j <= m; j++ {
			for k := 0; k <= j; k++ {
				dp[i][j] = max(dp[i][j], dp[i-1][j-k]+w[i][k])
			}
		}
	}

	fmt.Println(dp[n][m])
	way := make([]int, n+1)
	j := m
	for i := n; i > 0; i-- {
		for k := 0; k <= m; k++ {
			if dp[i][j] == dp[i-1][j-k]+w[i][k] {
				way[i] = k
				j -= k
				break
			}
		}
	}

	for i := 1; i <= n; i++ {
		fmt.Printf("%d %d\n", i, way[i])
	}
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}
