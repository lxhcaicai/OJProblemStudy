package main

import "fmt"

func main() {
	var n, m int
	fmt.Scan(&n, &m)
	dp := make([]int, m+1)
	for i := 1; i <= n; i++ {
		var v, w, s int
		fmt.Scan(&v, &w, &s)
		if s == -1 {
			for j := m; j >= v; j-- {
				dp[j] = max(dp[j], dp[j-v]+w)
			}
		} else if s == 0 {
			for j := v; j <= m; j++ {
				dp[j] = max(dp[j], dp[j-v]+w)
			}
		} else {
			for k := 1; k <= s; k <<= 1 {
				for j := m; j >= v*k; j-- {
					dp[j] = max(dp[j], dp[j-k*v]+k*w)
				}
				s -= k * v
			}
			if s > 0 {
				for j := m; j >= s*v; j-- {
					dp[j] = max(dp[j], dp[j-s*v]+s*w)
				}
			}
		}
	}
	fmt.Println(dp[m])
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}
