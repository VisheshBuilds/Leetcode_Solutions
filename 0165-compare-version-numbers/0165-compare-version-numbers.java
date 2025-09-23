class Solution {
    public int compareVersion(String version1, String version2) {
        int i=0,j=0;
        String[] ver1=version1.split("\\.");
        String[] ver2=version2.split("\\.");
        while(i< ver1.length && j<ver2.length){
            int val1=Integer.valueOf(ver1[i]);
            int val2=Integer.valueOf(ver2[j]);
            if(val1 > val2){
                return 1;
            }
            else if(val1 < val2){
                return -1;
            }
            else {
                i++;
                j++;
            }
        }
        while(i<ver1.length){
            int val1=Integer.valueOf(ver1[i]);
            if(val1>0) return 1;
            else i++;
        }
        while(j<ver2.length){
            int val2=Integer.valueOf(ver2[j]);
            if(val2>0) return -1;
            else j++;
        }
        return 0;
    }
}