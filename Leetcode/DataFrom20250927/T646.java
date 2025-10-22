import java.util.*;

public class T646 {
    public static void main(String[] args) {
        int[][] test = new int[][] {{1, 2}, {3, 4}, {5, 6}};
        T646 t = new T646();
        int ans = t.findLongestChain(test);
        System.out.println(ans);
    }
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (x, y) -> x[0] - y[0]);
        List<Integer> g = new ArrayList<>();
        for (int[] p : pairs) {
            int x = p[0], y = p[1], n = g.size();
            int pos = LowerBound(g, x);
            if(pos >= n) {
                g.add(y);
            } else {
                g.set(pos, Math.min(g.get(pos), y));
            }
        }
        return g.size();
    }
    private int LowerBound(List<Integer> arr, int val) {
        if(arr.isEmpty())
            return 0;
        int n = arr.size(), l = 0, r = n - 1;
        while(l <= r) {
            int mid = (l + r) >> 1;
            if(arr.get(mid) < val) {
                l = mid + 1;
            }
            else {
                r = mid - 1;
            }
        }
        return l;
    }
}
