public class T3461 {
    public boolean hasSameDigits(String s) {
        // 不知为何，心情又一次差劲到了极点
        // 最近到底是怎么了，感觉又丢了什么
        int n = s.length();
        int[] arr = new int[n];
        for (int i = 0;i < n;i ++) {
            arr[i] = (s.charAt(i) - '0');
        }
        int i = 0, j = n - 1;
        while(j - i + 1 > 2) {
            for (int k = i;k < j;k ++) {
                arr[k] = (arr[k] + arr[k + 1]) % 10;
            }
            -- j;
        }
        return arr[0] == arr[1];
    }
}
