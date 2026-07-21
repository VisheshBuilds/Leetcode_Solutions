class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int n=s.length(),ones=0,i=0;
        List<Integer> zeroes=new ArrayList<>();
        while(i<n){
            int count=0;
            while(i<n &&s.charAt(i)=='0'){
                count++;
                i++;
            }
            if(count!=0) zeroes.add(count);
            while(i<n && s.charAt(i)=='1'){
                i++;
                ones++;
            }
        }
        int max=0;
        for( i=0;i<zeroes.size()-1;i++){
            max=Math.max(max,zeroes.get(i)+zeroes.get(i+1));
        }
        return max+ones;
    }
}