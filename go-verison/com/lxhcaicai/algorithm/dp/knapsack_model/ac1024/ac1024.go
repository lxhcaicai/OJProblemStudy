package main

import "fmt"

// AcWing 1024. 装箱问题
func main() {
	var m, n int
	fmt.Scan(&m, &n)
	f := make([]int, m+1)
	for i := 1; i <= n; i++ {
		var v int
		fmt.Scan(&v)
		for j := m; j >= v; j -= 1 {
			f[j] = max(f[j], f[j-v]+v)
		}
	}
	res := 0
	for i := 0; i <= m; i++ {
		res = max(res, f[i])
	}
	fmt.Println(m - res)
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}
