public class SpNode {
    SpNode(int _key, int _value) {
        this.key = _key;
        this.value = _value;
        before = null;
        after = null;
    }
    int key;
    int value;
    SpNode before;
    SpNode after;
}
