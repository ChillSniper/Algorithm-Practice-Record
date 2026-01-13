package main

func isUnique(astr string) bool {
	record := [26]int{}
	for _, ch := range astr {
		index := ch - 'a'
		record[index]++
		if record[index] > 1 {
			return false
		}
	}
	return true
}
