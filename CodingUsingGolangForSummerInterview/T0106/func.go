package main

import (
	"strconv"
	"strings"
)

func compressString(S string) string {
	var t strings.Builder
	for i := 0; i < len(S); i++ {
		j := i
		ch := S[i]
		for j < len(S) && S[j] == ch {
			j++
		}
		cnt := j - i
		i = j - 1
		t.WriteByte(ch)
		t.WriteString(strconv.Itoa(cnt))
	}
	if t.Len() >= len(S) {
		return S
	}
	return t.String()
}
