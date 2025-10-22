import java.util.*;
public class T224 {
    public static void main(String[] args) {
        String s = "1-(     -2)";
        T224 t = new T224();
        int ans = t.calculate(s);
        System.out.println(ans);
    }
    public int calculate(String s) {
        // 还有，处理字符串之前先把空格全部去掉，省得后面进行特判
        // 这题好歹只有+和-运算，如果是乘除运算，需要进行权重比较；
        // 不过还是需要权重比较，因为有括号运算符
        // +-的运算优先级比()要低，如果栈顶的运算优先级<= 当前的，先算栈顶的
        // 但是还是有个问题，如果说括号里有一堆++--之类的运算
        // 那么这个该怎么运算呢？
        // md，如果碰到一个值，我们设定检查栈顶有没有运算符去运算，
        // 如果有的话，就去计算（取出两个数）；如果没有或者是括号，就先存进去
        // 对应的，如果碰到一个运算符，就先把它存进去
        // ok，解决完毕
        char[] ch = s.toCharArray();
        int n = ch.length, sl = 0, fs = 0;
        for (;sl <= fs && fs < n;) {
            if(ch[fs] != ' ') {
                ch[sl ++] = ch[fs ++];
            } else {
                ++ fs;
            }
        }
        
        s = new String(ch, 0, sl);
        n = s.length();
        Deque<Long> Num = new ArrayDeque<>();
        Deque<Character> op = new ArrayDeque<>();
        for (int i = 0;i < n;i ++) {
            char cur = s.charAt(i);
            if(cur == '+' || cur == '-') {
                op.addLast(cur);
            }
            else if(cur == '(') {
                op.addLast(cur);
                char nxt = s.charAt(i + 1);
                if(nxt == '-') {
                    Num.add(0l);
                }
            }
            else if(cur == ')') {
                if(op.getLast() != '(') {
                    long val = Num.pollLast();
                    Operation(Num, op, val);
                }
                op.pollLast();
                long val = Num.pollLast();
                Operation(Num, op, val);
            }
            else {
                int j = i;
                long val = 0;

                while(j < n && s.charAt(j) >= '0' && s.charAt(j) <= '9') {
                    val = val * 10 + (s.charAt(j) - '0');
                    ++ j;
                }
                i = j - 1;
                Operation(Num, op, val);
            }
        }
        long val = Num.pollLast();
        Operation(Num, op, val);
        return (int)(long)Num.getLast();
    }
    private void Operation(Deque<Long> Num, Deque<Character> op, long val) {
        long pre;
        while(!(op.isEmpty() || op.getLast() == '(')) {
            char tmp = op.pollLast();
            pre = Num.isEmpty() ? 0 : Num.pollLast();
            if(tmp == '+') {
                val = pre + val;
                // Num.addLast(pre + val);
            } else if(tmp == '-') {
                // Num.addLast(pre - val);
                val = pre - val;
            }
        }
        Num.addLast(val);
    }
}
