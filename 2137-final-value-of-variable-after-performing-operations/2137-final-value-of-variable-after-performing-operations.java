class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int ans=0;
        for(String val:operations){
            if(val.equals("++X") || val.equals("X++")) ans++;
            else ans--;
        }
        return ans;
    }
}