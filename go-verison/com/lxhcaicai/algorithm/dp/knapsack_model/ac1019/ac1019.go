package main

import "fmt"

func main() {

	var n, m int
	fmt.Scan(&n, &m)
	dp := make([]int, m+1)
	pre := make([]int, m+1)
	q := make([]int, m+1)
	for i := 1; i <= n; i++ {
		copyArr(pre, dp)
		var s, v, w int
		fmt.Scan(&v, &w, &s)
		for j := 0; j < v; j++ {
			head := 0
			tail := -1
			for k := j; k <= m; k += v {
				if head <= tail && k-s*v > q[head] {
					head++
				}
				for head <= tail && pre[q[tail]]-(q[tail]-j)/v*w <= pre[k]-(k-j)/v*w {
					tail--
				}
				if head <= tail {
					dp[k] = pre[q[head]] + (k-q[head])/v*w
				}
				tail += 1
				q[tail] = k
			}
		}
	}
	fmt.Println(dp[m])

}

func copyArr(a, b []int) {
	for i := range a {
		a[i] = b[i]
	}
}
