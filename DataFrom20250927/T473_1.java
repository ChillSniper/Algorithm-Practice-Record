public class T473_1 {
    public long removeZeros(long n) {
        long x = 0, p = 1;
        while(n > 0) {
            long t = n % 10;
            n /= 10;
            if(t != 0) {
                x += p * t;
                p *= 10;
            }
        }   
        return x;
    }
}
