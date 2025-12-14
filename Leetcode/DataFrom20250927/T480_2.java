public class T480_2 {
    public String reverseWords(String s) {
        int[] ch = new int[26];
        ch['a' - 'a'] = ch['e' - 'a'] = ch['i' - 'a'] = ch['o' - 'a'] = ch['u' - 'a'] = 1;
        int ori = 0, n = s.length(), i = 0;
        while (i < n && s.charAt(i) != ' ') {
            char c = s.charAt(i);
            if (ch[c - 'a'] == 1)
                ++ ori;
            ++ i;
        }
        if (i >= n)
            return s;
        char[] str = s.toCharArray();
        int fs = i + 1, sl = i + 1;
        while (sl <= fs && fs < n) { 
            int cnt = 0;
            while (fs < n && str[fs] != ' ') {
                if (ch[str[fs] - 'a'] == 1)
                    ++ cnt;
                ++ fs;
            }
            if (cnt == ori){
                for (int lf = sl, ri = fs - 1;lf < ri;lf ++, ri --) {
                    char tmp = str[lf];
                    str[lf] = str[ri];
                    str[ri] = tmp;
                }
            }
            if (fs >= n) {
                break;
            }
            sl = fs + 1;
            ++ fs;
        }
        return new String(str);
    }
}
