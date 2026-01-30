package main

import "slices"

func pathWithObstacles(obstacleGrid [][]int) [][]int {
	m, n := len(obstacleGrid), len(obstacleGrid[0])
	dp := make([][]int, m)
	for i := 0; i < m; i++ {
		dp[i] = make([]int, n)
	}
	if obstacleGrid[0][0] == 1 || obstacleGrid[m-1][n-1] == 1 {
		return nil
	}
	dp[0][0] = 1
	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			if obstacleGrid[i][j] == 1 {
				continue
			}
			if (i-1 > -1 && dp[i-1][j] == 1) || (j-1 > -1 && dp[i][j-1] == 1) {
				dp[i][j] = 1
			}
		}
	}
	ans := make([][]int, 0)

	cx, cy := m-1, n-1
	for cx >= 0 && cy >= 0 {
		if dp[cx][cy] == 0 {
			break
		}
		ans = append(ans, []int{cx, cy})
		if cx-1 > -1 && dp[cx-1][cy] == 1 {
			cx--
			continue
		}
		if cy-1 > -1 && dp[cx][cy-1] == 1 {
			cy--
			continue
		}
		break
	}
	slices.Reverse(ans)
	if len(ans) > 0 && ans[0][0] == 0 && ans[0][1] == 0 {
		return ans
	}
	return nil
}
