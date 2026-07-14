class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ans=new ArrayList<>();
        String str="123456789";
        String l=String.valueOf(low);
        String h=String.valueOf(high);
        for(int s=l.length();s<=h.length();s++){
            for(int i=0;i<=9-s;i++){
                int val=Integer.valueOf(str.substring(i,i+s));
                if(val>=low && val<=high) ans.add(val);
            }
        }
        return ans;
    }
}