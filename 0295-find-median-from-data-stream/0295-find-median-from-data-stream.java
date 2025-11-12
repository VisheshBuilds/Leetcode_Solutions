         //METHOD 1(BRUTE FORCE) 

// class MedianFinder {
//     List<Integer> arr;
//     public MedianFinder() {
//         arr=new ArrayList<>();
//     }
    
//     public void addNum(int num) {
//         arr.add(num);
//     }
    
//     public double findMedian() {
//         Collections.sort(arr);
//         int n=arr.size();
//         if(n%2!=0) return arr.get(n/2);
//         else return (arr.get(n/2)+arr.get(n/2-1))/2.0;
//     }
// }

            //METHOD 2 (OPTIMISE)

class MedianFinder {
    PriorityQueue<Integer> maxheap=new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> minheap=new PriorityQueue<>();
    public MedianFinder() {

    }
    
    public void addNum(int num) {
        if(maxheap.size()==0) maxheap.add(num);
        else {
            if(maxheap.peek()>num){
                maxheap.add(num);
            }
            else minheap.add(num);
        }

        if(maxheap.size()==minheap.size()+2){
            int top=maxheap.remove();
            minheap.add(top);
        }
        if(maxheap.size() +2==minheap.size()){
            int top=minheap.remove();
            maxheap.add(top);
        }
    }
    
    public double findMedian() {
        if(maxheap.size()==minheap.size()){
            return (maxheap.peek()+minheap.peek())/2.0;
        }

        else if(maxheap.size()>minheap.size()){
            return maxheap.peek();
        }
        else return minheap.peek();
    }
}

