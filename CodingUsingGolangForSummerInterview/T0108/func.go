package t0108

func setZeroes(matrix [][]int)  {
    flow, fcol := 0, 0
	m, n := len(matrix), len(matrix[0])
	for i := 0; i < m; i ++ {
		if matrix[i][0] == 0 {
			flow = 1;
			break;
		}
	}
	for j := 0;j < n;j ++ {
		if matrix[0][j] == 0 {
			fcol = 1;
			break;
		}
	}
	for i := 1; i < m; i ++ {
		for j := 1; j < n; j ++ {
			if (matrix[i][j] == 0) {
				matrix[i][0] = 0;
				matrix[0][j] = 0;
			}
		}
	}
	for i := 1; i < m; i ++ {
		for j := 1; j < n; j ++ {
			if (matrix[i][0] == 0 || matrix[0][j] == 0) {
				matrix[i][j] = 0;
			}
		}
	}
	if (flow == 1) {
		for i := 0; i < m; i ++ {
			matrix[i][0] = 0;
		}
	}
	if (fcol == 1) {
		for j := 0; j < n; j ++ {
			matrix[0][j] = 0;
		}
	}
}