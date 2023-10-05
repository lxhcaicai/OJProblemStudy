package main

import "fmt"

func main() {
	var n int
	for {
		fmt.Scan(&n)
		if n == 0 {
			break
		}
		a := make([]int, n+1)
		for i := 1; i <= n; i++ {
			fmt.Scan(&a[i])
		}
		ans := n
		up := make([]int, n+1)
		down := make([]int, n+1)
		var dfs func(u, su, sd int)
		dfs = func(u, su, sd int) {
			if su+sd >= ans {
				return
			}
			if u > n {
				ans = su + sd
				return
			}

			k := 1
			for k <= su && up[k] >= a[u] {
				k++
			}
			tmp := up[k]
			up[k] = a[u]
			if k <= su {
				dfs(u+1, su, sd)
			} else {
				dfs(u+1, su+1, sd)
			}
			up[k] = tmp

			k = 1
			for k <= sd && down[k] <= a[u] {
				k++
			}
			tmp = down[k]
			down[k] = a[u]
			if k <= sd {
				dfs(u+1, su, sd)
			} else {
				dfs(u+1, su, sd+1)
			}
			down[k] = tmp
		}
		dfs(1, 0, 0)
		fmt.Println(ans)
	}
}
