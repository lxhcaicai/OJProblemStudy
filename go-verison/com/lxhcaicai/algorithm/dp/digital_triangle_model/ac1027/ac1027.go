package main

import "fmt"

func main() {
	var n int
	fmt.Scan(&n)
	a := make([][]int, n+1)
	for i := range a {
		a[i] = make([]int, n+1)
	}
	for {
		var i, j, k int
		fmt.Scan(&i, &j, &k)
		if i == 0 && j == 0 && k == 0 {
			break
		}
		a[i][j] = k
	}
	f := make([][][]int, n*2+1)
	for i := range f {
		f[i] = make([][]int, n+1)
		for j := 0; j <= n; j++ {
			f[i][j] = make([]int, n+1)
		}
	}

	for k := 2; k <= 2*n; k++ {
		for i1 := 1; i1 <= n; i1++ {
			for i2 := 1; i2 <= n; i2++ {
				j1 := k - i1
				j2 := k - i2
				if 1 <= j1 && j1 <= n && 1 <= j2 && j2 <= n {
					w := a[i1][j1]
					if i1 != i2 {
						w += a[i2][j2]
					}
					f[k][i1][i2] = max(f[k-1][i1][i2], f[k-1][i1-1][i2], f[k-1][i1][i2-1], f[k-1][i1-1][i2-1]) + w
				}
			}
		}
	}
	fmt.Println(f[2*n][n][n])
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
