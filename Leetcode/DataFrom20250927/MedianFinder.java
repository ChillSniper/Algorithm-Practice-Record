import java.util.*;

class MedianFinder {

    private final PriorityQueue<Integer> minHeap, maxHeap;

    public MedianFinder() {
        // 得用堆做
        // 可以维护一个小根堆，和一个大根堆；
        // 大根堆记录左边那一半，小根堆记录右边那一半
        // 然后随时记录左右两个堆元素的数量
        // 如果左右元素相等，先扔当右边那个里面去
        // 不然得话哪个少扔哪里去
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
    }
    
    public void addNum(int num) {
        
        int l_size = maxHeap.size(), r_size = minHeap.size();
        int leftVal = maxHeap.isEmpty() ? Integer.MIN_VALUE : maxHeap.peek();
        int rightVal = minHeap.isEmpty() ? Integer.MAX_VALUE : minHeap.peek();
        if (num <= leftVal) {
            maxHeap.add(num);
            if (l_size == r_size - 1) {
                ;
            } else {
                int x = maxHeap.poll();
                minHeap.add(x);
            }
        } else if (num >= rightVal) {
            minHeap.add(num);
            if (l_size == r_size) {
                ;
            } else {
                int x = minHeap.poll();
                maxHeap.add(x);
            }
        } else {
            if (l_size == r_size - 1) {
                maxHeap.add(num);
            } else {
                minHeap.add(num);
            }
        }
    }
    
    public double findMedian() {
        int lsize = maxHeap.size(), rsize = minHeap.size();
        if (lsize == rsize) {
            return (maxHeap.peek() + minHeap.peek()) + 0.0 / 2;
        }
        return minHeap.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */