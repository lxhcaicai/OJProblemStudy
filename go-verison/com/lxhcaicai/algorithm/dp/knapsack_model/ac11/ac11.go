package main

import "fmt"

func main() {
	var n, m int
	fmt.Scan(&n, &m)
	MOD := 1000000007
	f := make([]int, m+1)
	dp := make([]int, m+1)
	dp[0] = 1
	for i := 1; i <= n; i++ {
		var v, w int
		fmt.Scan(&v, &w)
		for j := m; j >= v; j-- {
			if f[j] < f[j-v]+w {
				f[j] = f[j-v] + w
				dp[j] = dp[j-v]
			} else if f[j] == f[j-v]+w {
				dp[j] = (dp[j-v] + dp[j]) % MOD
			}
		}
	}
	ans := 0
	res := 0
	for i := 0; i <= m; i++ {
		if ans < f[i] {
			res = dp[i]
			ans = f[i]
		} else if ans == f[i] {
			res = (res + dp[i]) % MOD
		}
	}
	fmt.Println(res)

}
