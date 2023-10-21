package main

import "fmt"

func main() {
	var n, m int
	fmt.Scan(&n, &m)
	var k int
	fmt.Scan(&k)
	dp := make([][]int, n+1)
	for i := 0; i <= n; i++ {
		dp[i] = make([]int, m+1)
	}
	for i := 0; i <= n; i++ {
		for j := 0; j <= m; j++ {
			dp[i][j] = 0x3f3f3f3f
		}
	}
	dp[0][0] = 0
	for h := 1; h <= k; h++ {
		var a, b, c int
		fmt.Scan(&a, &b, &c)
		for i := n; i >= 0; i-- {
			for j := m; j >= 0; j-- {
				dp[i][j] = min(dp[i][j], dp[max(0, i-a)][max(0, j-b)]+c)
			}
		}
	}
	fmt.Println(dp[n][m])
}

func min(a, b int) int {
	if a > b {
		return b
	}
	return a
}

func max(a, b int) int {
	if a < b {
		return b
	}
	return a
}
