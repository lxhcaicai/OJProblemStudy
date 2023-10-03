package main

import "fmt"

func main() {
	a := make([]int, 1010)
	n := 0
	for {
		_, err := fmt.Scan(&a[0])
		if err == nil {
			n += 1
			a[n] = a[0]
		} else {
			break
		}
	}
	f := make([]int, n+1)
	for i := 1; i <= n; i++ {
		f[i] = 1
		for j := 1; j < i; j++ {
			if a[i] <= a[j] {
				f[i] = max(f[i], f[j]+1)
			}
		}
	}

	cnt := 1
	g := make([]int, n+1)
	g[cnt] = a[1]
	for i := 2; i <= n; i++ {
		if g[cnt] < a[i] {
			cnt++
			g[cnt] = a[i]
		} else {
			l := 1
			r := cnt
			ans := l
			for l <= r {
				mid := (l + r) >> 1
				if g[mid] >= a[i] {
					ans = mid
					r = mid - 1
				} else {
					l = mid + 1
				}
			}
			g[ans] = a[i]
		}
	}
	fmt.Println(maxArgs(f))
	fmt.Println(cnt)
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}

func maxArgs(a []int) int {
	maxn := 0
	for i := range a {
		maxn = max(a[i], maxn)
	}
	return maxn
}
