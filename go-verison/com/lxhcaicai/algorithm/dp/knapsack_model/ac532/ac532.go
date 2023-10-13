package main

import (
	"fmt"
	"sort"
)

// AcWing 532. 货币系统
func main() {
	var t int
	fmt.Scan(&t)
	for ; t > 0; t-- {
		var n int
		fmt.Scan(&n)
		a := make([]int, n+1)
		for i := 1; i <= n; i++ {
			fmt.Scan(&a[i])
		}
		tmp := a[1:]
		sort.Slice(tmp, func(i, j int) bool {
			return tmp[i] < tmp[j]
		})

		m := a[n]
		f := make([]bool, m+1)
		ans := 0
		f[0] = true
		for i := 1; i <= n; i++ {
			if !f[a[i]] {
				ans++
			}
			for j := a[i]; j <= m; j++ {
				if f[j-a[i]] == true {
					f[j] = true
				}
			}
		}
		fmt.Println(ans)
	}
}
