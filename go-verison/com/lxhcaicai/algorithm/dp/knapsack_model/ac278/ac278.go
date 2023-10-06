package main

import "fmt"

// AcWing 278. 数字组合
func main() {
	var n, m int
	fmt.Scan(&n, &m)
	a := make([]int, n+1)
	f := make([]int, m+1)
	f[0] = 1
	for i := 1; i <= n; i++ {
		fmt.Scan(&a[i])
		for j := m; j >= a[i]; j-- {
			f[j] += f[j-a[i]]
		}
	}
	fmt.Println(f[m])
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}
