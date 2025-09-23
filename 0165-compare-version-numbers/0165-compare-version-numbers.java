class Solution {
    public int compareVersion(String version1, String version2) {
        int i=0,j=0;
        String[] ver1=version1.split("\\.");
        String[] ver2=version2.split("\\.");
        while(i< ver1.length || j<ver2.length){
            int val1=(i<ver1.length) ? Integer.valueOf(ver1[i]):0;
            int val2=(j<ver2.length) ? Integer.valueOf(ver2[j]):0;
             
            if(val1 > val2) return 1;
            else if(val1 <val2) return -1;
            else i++; j++;
        }

        return 0;
    }
}