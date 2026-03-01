class Solution {
    public int minPartitions(String n) {
        int max=0;
        for(int i=0;i<n.length();i++){
            char ch=n.charAt(i);
            int num=ch - '0';
            if(num > max) max=num;
        }
        return max;
    }
}