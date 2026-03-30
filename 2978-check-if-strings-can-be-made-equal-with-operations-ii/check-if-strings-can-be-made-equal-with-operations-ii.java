class Solution {
    public boolean checkStrings(String s1, String s2) {
             //METHOD 1

        // HashMap<Character,Integer> map_even=new HashMap<>();
        // HashMap<Character,Integer> map_odd=new HashMap<>();

        // for(int i=0;i<s1.length();i++){
        //     if(i%2==0) map_even.put(s1.charAt(i),map_even.getOrDefault(s1.charAt(i),0)+1);
        //     else map_odd.put(s1.charAt(i),map_odd.getOrDefault(s1.charAt(i),0)+1);
        // }
        // for(int i=0;i<s2.length();i++){
        //     if(i%2==0){
        //         if(map_even.getOrDefault(s2.charAt(i),0)==0) return false;
        //         map_even.put(s2.charAt(i),map_even.get(s2.charAt(i))-1);
        //     } 
        //     else {
        //         if(map_odd.getOrDefault(s2.charAt(i),0)==0) return false;
        //         map_odd.put(s2.charAt(i),map_odd.get(s2.charAt(i))-1);
        //     }
        // }
        // return true;


           //METHOD 2

        int[] even=new int[26];
        int[] odd=new int[26];
        int n=s1.length();
         for(int i=0;i<n;i++){
            if(i%2==0) even[s1.charAt(i)-'a']++;
            else odd[s1.charAt(i)-'a']++;
         }
         for(int i=0;i<n;i++){
            if(i%2==0){
               if(even[s2.charAt(i)-'a']==0) return false;
               even[s2.charAt(i)-'a']--;
            } 
            else{
                if(odd[s2.charAt(i)-'a']==0) return false;
                odd[s2.charAt(i)-'a']--;
            } 
         }
         return true;
    }
}