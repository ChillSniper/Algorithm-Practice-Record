public class T168_2 {
    public String maxSumOfSquares(int num, int sum) {
        // 这个有点像贪心
        if(sum > 9 * num)
            return "";
        // 0 + 9 = 82
        // 2 + 8 = 68
        // 3 + 7 = 49 + 9 = 58
        // 4 + 6 = 24 + 36 = 60
        // 5 + 5 = 50
        // 这个问题实际上是，多余出的extra_sum，是均摊尽可能多的值的收益更大，还是集中在一起更大
        // extra = 8
        // 81 + 7 = 88
        // 32
        // 所以不如集中在一起
        char[] ch = new char[num];
        for (int i = 0;i < num;i ++) {
            if(sum >= 9) {
                ch[i] = '9';
                sum -= 9;
            } else if(sum > 0){
                ch[i] = (char)('0' + sum);
                sum = 0;
            } else {
                ch[i] = '0';
            }
        }
        return new String(ch);
    }
}
