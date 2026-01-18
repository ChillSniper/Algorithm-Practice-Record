package t0109

func isFlipedString(s1 string, s2 string) bool {
	lena, lenb := len(s1), len(s2)
	if lena != lenb {
		return false
	}
	for i := 0; i < (lena+1)/2; i++ {
		if s1[i] != s2[lenb-1-i] {
			return false
		}
	}
	return true
}
