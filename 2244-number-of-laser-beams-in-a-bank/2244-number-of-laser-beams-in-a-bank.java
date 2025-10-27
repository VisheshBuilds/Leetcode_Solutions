class Solution {
    public int numberOfBeams(String[] bank) {
        int ans=0;
        for(int i=0;i<bank.length;i++){
            int one=ones(bank[i]);
            int j=i+1;
            while(j<bank.length && ones(bank[j])==0) j++;
            if(j<bank.length) ans +=one*ones(bank[j]);
        }
        return ans;
    }
    public int ones(String s){
        int count=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1') count++;
        }
        return count;
    }
}