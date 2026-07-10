class Solution {
    public int maxProduct(String[] words) {
        int ans=0,n=words.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(diff(words[i],words[j])) ans=Math.max(ans,words[i].length()*words[j].length());
            }
        }
        return ans;
    }
    public boolean diff(String a,String b){
        int[] word=new int[26];
        for(int i=0;i<a.length();i++){
            word[a.charAt(i)-'a']++;
        }
        for(int i=0;i<b.length();i++){
            if(word[b.charAt(i)-'a']>0) return false;
        }
        return true;
    }
}