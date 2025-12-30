class Bank {
    long[] record;
    int Length;
    public Bank(long[] balance) {
        int n = balance.length;
        record = new long[n + 1];
        for (int i = 0;i < n;i ++) {
            record[i + 1] = balance[i];
        }
        Length = n;
    }
    
    public boolean transfer(int account1, int account2, long money) {
        if(account1 > Length || account1 < 1 || account2 > Length || account2 < 1 || money > record[account1])
            return false;
        record[account1] -= money;
        record[account2] += money;
        return true;
    }
    
    public boolean deposit(int account, long money) {
        if(account < 1 || account > Length)
            return false;
        record[account] += money;
        return true;
    }
    
    public boolean withdraw(int account, long money) {
        if(account < 1 || account > Length || record[account] < money)
            return false;
        record[account] -= money;
        return true;
    }
}

/**
 * Your Bank object will be instantiated and called as such:
 * Bank obj = new Bank(balance);
 * boolean param_1 = obj.transfer(account1,account2,money);
 * boolean param_2 = obj.deposit(account,money);
 * boolean param_3 = obj.withdraw(account,money);
 */