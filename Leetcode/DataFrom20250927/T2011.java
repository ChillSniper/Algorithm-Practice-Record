public class T2011 {
    public int finalValueAfterOperations(String[] operations) {
        int val = 0, n = operations.length;
        for (int i = 0;i < n;i ++) {
            if(operations[i].charAt(1) == '+')
                ++ val;
            else 
                -- val;
        }
        return val;
    }
}
