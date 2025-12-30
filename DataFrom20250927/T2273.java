import java.util.*;

public class T2273 {
    public static void main(String[] args) {
        String[] words = new String[]{"a", "b", "a"};
        T2273 t = new T2273();
        System.out.println(t.removeAnagrams(words).size());

    }
    public List<String> removeAnagrams(String[] words) {
        int n = words.length;
        List<String> ans = new ArrayList<>();
        ans.add(words[0]);
        for (int i = 1;i < n;i ++) {
            String cur = words[i], bf = words[i - 1];
            boolean flag = compare(cur, bf);
            if(!flag) {
                ans.add(cur);
            }
        }
        return ans;
    }
    private boolean compare(String x, String y) {
        int[] f = new int[26];
        for (int i = 0;i < x.length();i ++) {
            char ch = x.charAt(i);
            f[ch - 'a'] ++;
        }
        for (int i = 0;i < y.length();i ++) {
            char ch = y.charAt(i);
            f[ch - 'a'] --;
        }
        for (int i = 0;i < 26;i ++) {
            if(f[i] != 0)
                return false;
        }
        return true;
    }
}
