package main

// ac1018. 最低通行费
import (
	"fmt"
)

const N = 105

func main() {
	var n int
	fmt.Scan(&n)
	a := make([][]int, n+1)
	for i := range a {
		a[i] = make([]int, n+1)
	}
	for i := 1; i <= n; i++ {
		for j := 1; j <= n; j++ {
			fmt.Scan(&a[i][j])
		}
	}

	f := make([][]int, n+1)
	for i := range f {
		f[i] = make([]int, n+1)
	}
	for i := 1; i <= n; i++ {
		for j := 1; j <= n; j++ {
			f[i][j] = N * N
		}
	}
	f[1][1] = a[1][1]
	for i := 1; i <= n; i++ {
		for j := 1; j <= n; j++ {
			if i > 1 {
				f[i][j] = min(f[i-1][j]+a[i][j], f[i][j])
			}
			if j > 1 {
				f[i][j] = min(f[i][j-1]+a[i][j], f[i][j])
			}
		}
	}
	fmt.Println(f[n][n])
}

func min(a, b int) int {
	if a > b {
		return b
	}
	return a
}
