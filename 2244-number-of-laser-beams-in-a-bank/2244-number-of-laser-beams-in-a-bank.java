class Solution {
    public int numberOfBeams(String[] bank) {
        //Method 1(self)

        // int ans=0;
        // for(int i=0;i<bank.length;i++){
        //     int one=ones(bank[i]);
        //     int j=i+1;
        //     while(j<bank.length && ones(bank[j])==0) j++;
        //     if(j<bank.length) ans +=one*ones(bank[j]);
        // }
        // return ans;

        //Method 2 (clue)
        int ans=0,prevrowcount=0;
        for(int i=0;i<bank.length;i++){
            int currowcount=ones(bank[i]);
            if(currowcount==0) continue;
            ans +=currowcount*prevrowcount;
            prevrowcount=currowcount;
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