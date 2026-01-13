package main

func CheckPermutation(s1 string, s2 string) bool {
	la := len(s1)
	lb := len(s2)
	if la != lb {
		return false
	}
	r := [26]int{}
	for _, ch := range s1 {
		r[ch-'a']++
	}
	for _, ch := range s2 {
		r[ch-'a']--
		if r[ch-'a'] < 0 {
			return false
		}
	}

	for i := 0; i < 26; i++ {
		if r[i] > 0 {
			return false
		}
	}

	return true
}
