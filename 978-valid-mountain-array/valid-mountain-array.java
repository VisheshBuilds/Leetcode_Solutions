class Solution {
    public boolean validMountainArray(int[] arr) {
        int n=arr.length;
        if(n<3) return false;
        
        int prev=arr[0],idx=-1,last=-1;;
        for(int i=1;i<n;i++){
            if(prev==arr[i]) return false;
            if(prev > arr[i] && i==1) return false;
            if(prev<arr[i]) prev=arr[i];
            else{
                last=arr[i];
                idx=i;
                break;
            }
        }
        for(int i=idx+1;i<n;i++){
            if(last==arr[i]) return false;
            if(last> arr[i]) last=arr[i];
            else{
                return false;
            }
        }
        return true;
    }
}