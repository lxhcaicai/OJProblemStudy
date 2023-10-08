package main

import "fmt"

func main() {
	var n, m int
	fmt.Scan(&n, &m)
	f := make([]int, m+1)
	a := make([]int, n+1)
	f[0] = 1
	for i := 1; i <= n; i++ {
		fmt.Scan(&a[i])
		for j := a[i]; j <= m; j++ {
			f[j] += f[j-a[i]]
		}
	}
	fmt.Println(f[m])
}
