import java.util.*;

public class T1625 {
    public String findLexSmallestString(String s, int a, int b) {
        // 这个需要分析
        // 偶数位上的一直加就完事了
        // 初始奇数位上的也能加到
        // 那么问题就来了
        // 这还不如打暴力呢
        // 此题的暴力解法是BFS，没想到打暴力真的不会超内存
        Deque<String> record = new ArrayDeque<>();
        Set<String> vis = new HashSet<>();
        record.offer(s);
        vis.add(s);
        String ans = s;
        int n = s.length();
        while (!record.isEmpty()) {
            String t = record.poll();
            char[] s1 = t.toCharArray(), s2 = t.toCharArray();
            for (int i = 1;i < n;i += 2) {
                s1[i] = (char)(((t.charAt(i) - '0') + a) % 10 + '0');
            }
            String L1 = new String(s1);
            for (int i = 0;i < n;i ++) {
                s2[(i + b) % n] = t.charAt(i);
            }
            String L2 = new String(s2);
            if(L1.compareTo(ans) < 0) 
                ans = L1;
            if(L2.compareTo(ans) < 0)
                ans = L2;
            if(vis.add(L1))
                record.offer(L1);
            if(vis.add(L2))
                record.offer(L2);

            System.out.println(L1);
            System.out.println(L2);
        }
        return ans;
    }
}
