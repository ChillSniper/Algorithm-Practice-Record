package t0104

func canPermutePalindrome(s string) bool {
	r := [300]int{}
	for _, ch := range s {
		r[ch]++
	}
	cnt := 0
	for i := 0; i < 300; i++ {
		if r[i]%2 == 1 {
			cnt++
		}
	}
	return cnt < 2
}
