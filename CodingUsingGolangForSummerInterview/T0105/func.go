package main

import (
	"math"
)

func oneEditAway(first string, second string) bool {
	var la = len(first)
	var lb = len(second)
	if math.Abs(float64(la-lb)) > 1 {
		return false
	}
	if la > lb {
		return oneEditAway(second, first)
	}
	cnt, i, j := 0, 0, 0
	for i < la && j < lb {
		x, y := first[i], second[i]
		if x == y {
			i++
			j++
		} else {
			if la == lb {
				cnt++
				i++
				j++
			} else {
				cnt++
				j++
			}
			if cnt > 1 {
				return false
			}
		}
	}
	return cnt < 2
}
