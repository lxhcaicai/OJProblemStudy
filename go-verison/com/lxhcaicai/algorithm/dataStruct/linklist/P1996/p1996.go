package main

import (
	"container/ring"
	"fmt"
)

// P1996 约瑟夫问题
func main() {
	var n, m int
	fmt.Scanln(&n, &m)

	r := ring.New(n)
	for i := 1; i <= n; i++ {
		r.Value = i
		r = r.Next()
	}

	cnt := 0
	for r.Len() != 1 {
		cnt += 1
		if cnt%m == 0 {
			fmt.Printf("%d ", r.Value)
			r = r.Prev()
			r.Unlink(1)
		}
		r = r.Next()
	}
	fmt.Printf("%d ", r.Value)
}
