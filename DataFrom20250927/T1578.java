public class T1578 {
    public int minCost(String colors, int[] neededTime) {
        // 这个甚至dp都不是
        int ans = 0, n = neededTime.length;
        for (int i = 0;i < n;i ++) {
            int j = i, MAxVal = 0, sumVal = 0;
            char ch = colors.charAt(i);
            while (j < n && colors.charAt(j) == ch) {
                sumVal += neededTime[j];
                MAxVal = Math.max(MAxVal, neededTime[j]);
                ++ j;
            }
        
            i = j - 1;
            ans += sumVal - MAxVal;    
        }
        return ans;
    }
}
