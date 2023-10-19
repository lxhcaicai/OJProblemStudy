package main

import "fmt"

// AcWing 8. 二维费用的背包问题
func main() {
	var n, V, M int
	fmt.Scan(&n, &V, &M)
	dp := make([][]int, V+1)
	for i := range dp {
		dp[i] = make([]int, M+1)
	}
	for i := 1; i <= n; i++ {
		var v, m, w int
		fmt.Scan(&v, &m, &w)
		for j := V; j >= v; j-- {
			for k := M; k >= m; k-- {
				dp[j][k] = max(dp[j][k], dp[j-v][k-m]+w)
			}
		}
	}
	fmt.Println(dp[V][M])
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}
