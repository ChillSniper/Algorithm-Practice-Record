package main

func waysToStep(n int) int {
	N := int64(1e9) + 7
	f := make([]int64, n+3, 2*n+10)
	f[2] = 1
	for i := 0; i < n; i++ {
		f[i+3] = (f[i] + f[i+1] + f[i+2]) % N
	}
	return int(f[n+2])
}
