package main

func replaceSpaces(S string, length int) string {
	var cnt = 0
	for i := 0; i < length; i++ {
		if S[i] == ' ' {
			cnt++
		}
	}
	newLength := length + cnt*2
	var ch = make([]byte, newLength)

	var idx = 0
	for i := 0; i < length; i++ {
		if S[i] != ' ' {
			ch[idx] = S[i]
			idx++
		} else {
			ch[idx] = '%'
			idx++
			ch[idx] = '2'
			idx++
			ch[idx] = '0'
			idx++
		}
	}
	return string(ch)
}
