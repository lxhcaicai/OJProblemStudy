package main

import "fmt"

// AcWing 423. 采药
func main() {
	var t, m int
	fmt.Scan(&t, &m)
	f := make([]int, t+1)
	for i := 1; i <= m; i++ {
		var w, v int
		fmt.Scan(&w, &v)
		for j := t; j >= w; j-- {
			f[j] = max(f[j], f[j-w]+v)
		}
	}
	ans := 0
	for i := 1; i <= t; i++ {
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
