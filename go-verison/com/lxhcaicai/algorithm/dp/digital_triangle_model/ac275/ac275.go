package main

import "fmt"

func main() {
	var n, m int
	fmt.Scan(&n, &m)
	a := make([][]int, n+1)
	for i := range a {
		a[i] = make([]int, m+1)
	}
	for i := 1; i <= n; i++ {
		for j := 1; j <= m; j++ {
			fmt.Scan(&a[i][j])
		}
	}
	// 注意数组 f[n + m][n][n] 不是 f[n + m][n][m]
	f := make([][][]int, n+m+2)
	for i := range f {
		f[i] = make([][]int, n+1)
		for j := range f[i] {
			f[i][j] = make([]int, n+1)
		}
	}

	for k := 2; k <= n+m; k++ {
		for i1 := 1; i1 <= n; i1++ {
			for i2 := 1; i2 <= n; i2++ {
				j1 := k - i1
				j2 := k - i2
				if 1 <= j1 && j1 <= m && 1 <= j2 && j2 <= m {
					w := a[i1][j1]
					if i1 != i2 {
						w += a[i2][j2]
					}
					f[k][i1][i2] = max(f[k-1][i1][i2], f[k-1][i1-1][i2], f[k-1][i1][i2-1], f[k-1][i1-1][i2-1]) + w
				}
			}
		}
	}
	fmt.Println(f[n+m][n][n])
}

func max(args ...int) int {
	ans := 0
	for i := range args {
		if ans < args[i] {
			ans = args[i]
		}
	}
	return ans
}
