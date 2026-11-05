class Solution {
public:
    double myPow(double x, int n) {
        if (n == 0)
            return 1;

        if (n == -1)
            return 1.0 / x;

        if (n == 1)
            return x;
        double val = myPow(x, n / 2);
        
        val *= val;
        if (n % 2) {
            val *= n > 0 ? x : (1.0 / x);
        }

        return val;
    }

};