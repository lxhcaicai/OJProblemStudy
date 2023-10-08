package main

import "fmt"

// AcWing 1023. 买书
func main() {
	var n int
	fmt.Scan(&n)
	f := make([]int, n+1)
	a := []int{10, 20, 50, 100}
	f[0] = 1
	for i := range a {
		for j := a[i]; j <= n; j++ {
			f[j] += f[j-a[i]]
		}
	}
	fmt.Print(f[n])
}
