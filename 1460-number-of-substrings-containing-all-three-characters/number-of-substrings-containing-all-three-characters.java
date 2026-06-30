class Solution {
    public int numberOfSubstrings(String s) {
        int count=0,i=0,j=0,n=s.length();
        int[] arr=new int[3];
        while(j<n){
            char ch=s.charAt(j);
            if(ch=='a') arr[0]++;
            else if(ch=='b') arr[1]++;
            else arr[2]++;
            while(arr[0]>0 && arr[1]>0 && arr[2]>0){
                count +=n-j;
                ch=s.charAt(i);
                if(ch=='a') arr[0]--;
                else if(ch=='b') arr[1]--;
                else arr[2]--;
                i++;
            }
            j++;
        }
        return count;
    }
}