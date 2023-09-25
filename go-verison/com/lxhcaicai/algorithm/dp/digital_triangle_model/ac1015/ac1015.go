package main

import (
	"bufio"
	"fmt"
	"os"
)

const N = 105

var (
	a [N][N]int
	f [N][N]int
)

func main() {
	// 读入写出 优化
	in := bufio.NewReader(os.Stdin)
	out := bufio.NewWriter(os.Stdout)
	defer out.Flush()
	var t, n, m int
	fmt.Fscan(in, &t)
	for ; t > 0; t-- {

		fmt.Fscan(in, &n, &m)
		for i := 1; i <= n; i++ {
			for j := 1; j <= m; j++ {
				fmt.Fscan(in, &a[i][j])
			}
		}
		for i := 1; i <= n; i++ {
			for j := 1; j <= m; j++ {
				f[i][j] = 0
			}
		}
		for i := 1; i <= n; i++ {
			for j := 1; j <= m; j++ {
				f[i][j] = max(f[i-1][j], f[i][j-1]) + a[i][j]
			}
		}
		fmt.Fprintln(out, f[n][m])

	}
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}
