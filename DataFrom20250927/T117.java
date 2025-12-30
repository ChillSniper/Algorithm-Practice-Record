import java.util.*;

public class T117 {
    public Node connect(Node root) {
        Deque<Node> record = new ArrayDeque<>();
        if (root == null)
            return root;
        record.add(root);
        while (!record.isEmpty()) {
            int len = record.size();
            for (int i = 0;i < len - 1;i ++) {
                Node t = record.pollFirst();
                t.next = record.getFirst();
                if (t.left != null)
                    record.addLast(t.left);
                if (t.right != null)
                    record.addLast(t.right);
            }
            Node t = record.pollFirst();
            t.next = null;
        }
        return root;
    }
}
