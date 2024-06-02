package main

import "fmt"

const N = 1e5 + 100

var (
	a   [N]int
	b   [N]int
	cnt int
)

func mergeSort(l, r int) {
	if l == r {
		return
	}
	mid := (l + r) >> 1
	mergeSort(l, mid)
	mergeSort(mid+1, r)
	i := l
	j := mid + 1
	for k := l; k <= r; k++ {
		if j > r || (i <= mid && a[i] <= a[j]) {
			b[k] = a[i]
			i++
		} else {
			cnt += mid - i + 1
			b[k] = a[j]
			j++
		}
	}
	for k := l; k <= r; k++ {
		a[k] = b[k]
	}
}

func main() {
	var n int
	fmt.Scan(&n)
	for i := 1; i <= n; i++ {
		fmt.Scan(&a[i])
	}
	cnt = 0
	mergeSort(1, n)
	fmt.Println(cnt)
}
