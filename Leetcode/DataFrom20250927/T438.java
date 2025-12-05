import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class T438 {
    public static void main(String[] args) {
        String s = "abab", p = "ab";
        T438 t = new T438();
        t.findAnagrams(s, p);
    }
    public List<Integer> findAnagrams(String s, String p) {
        int p_len = p.length();
        Map<Character, Integer> record = new HashMap<>();
        for (int i = 0;i < p_len;i ++) {
            char ch = p.charAt(i);
            record.merge(ch, 1, Integer::sum);
        }
        int notInPNum = 0, diffNum = record.keySet().size();
        int s_len = s.length();
        List<Integer> ans = new ArrayList<>();
        if (s_len < p_len) 
            return ans;
        Map<Character, Integer> sC = new HashMap<>();
        
        for (int i = 0;i < s_len;i ++) {
            char ch = s.charAt(i);
            sC.merge(ch, 1, Integer::sum);
            if (record.containsKey(ch)) {
                int rnum = record.get(ch);
                int snum = sC.get(ch);
                if (snum == rnum) {
                    -- diffNum;
                } else if (snum == rnum + 1){
                    ++ diffNum;
                }
            } else {
                ++ notInPNum;
            }
            if (notInPNum == 0 && diffNum == 0 && i == p_len - 1) {
                ans.add(i - p_len + 1);
            }
            if (i - p_len < 0)
                continue;
            char delete_ch = s.charAt(i - p_len);
            sC.merge(delete_ch, -1, Integer::sum);
            if (record.containsKey(delete_ch)) {
                int rnum = record.get(delete_ch);
                int snum = sC.get(delete_ch);
                if (snum == rnum) {
                    -- diffNum;
                } else if(snum == rnum - 1) {
                    ++ diffNum;
                }
            } else {
                -- notInPNum;
            }
            if (notInPNum == 0 && diffNum == 0) {
                ans.add(i - p_len + 1);
            }
        }
        return ans;
    }
}