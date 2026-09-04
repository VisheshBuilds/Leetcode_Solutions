class MedianFinder {
    PriorityQueue<Integer> left;
    PriorityQueue<Integer> right;
    public MedianFinder() {
        //max
        left=new PriorityQueue<>(Collections.reverseOrder());
        //min
        right=new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(left.size()==0 || num<left.peek()){
            left.add(num);
        }
        else right.add(num);
        
        if(left.size()>right.size()+1){
            right.add(left.remove());
        }
        if(right.size()>left.size()){
            left.add(right.remove());
        }
    }
    
    public double findMedian() {
        if(left.size()==right.size()){
            return (double)(left.peek()+right.peek())/2;
        }
        return (double)left.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */