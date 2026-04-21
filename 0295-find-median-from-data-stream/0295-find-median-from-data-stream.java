class MedianFinder {
    PriorityQueue<Integer> min;
    PriorityQueue<Integer> max;

    public MedianFinder() {
        min = new PriorityQueue<>();
        max = new PriorityQueue<>((a,b) -> Integer.compare(b , a));
    }
    
    public void addNum(int num) {
        max.add(num);
        min.add(max.poll());

        if (max.size() < min.size()) {
            max.add(min.poll());
        }
    }
    
    public double findMedian() {
        if(min.size() == max.size()) {
            return (min.peek() + max.peek()) / 2.0;
        }

        return (double) max.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */