package main

import (
	"fmt"
	"sort"
)

type Node struct {
	x int
	y int
}

func main() {
	var n int
	fmt.Scan(&n)
	nodes := make([]Node, n+1)
	f := make([]int, n+1)
	for i := 1; i <= n; i++ {
		var x, y int
		fmt.Scan(&x, &y)
		nodes[i] = Node{x: x, y: y}
		f[i] = 1
	}
	tmp := nodes[1:]
	sort.Slice(tmp, func(i, j int) bool {
		return tmp[i].x < tmp[j].x
	})
	for i := 1; i <= n; i++ {
		for j := 1; j < i; j++ {
			if nodes[i].y > nodes[j].y {
				f[i] = max(f[i], f[j]+1)
			}
		}
	}
	maxn := 0
	for i := 1; i <= n; i++ {
		maxn = max(maxn, f[i])
	}
	fmt.Println(maxn)
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}
