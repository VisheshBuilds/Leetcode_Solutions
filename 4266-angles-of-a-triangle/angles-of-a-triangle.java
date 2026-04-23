class Solution {
    public double[] internalAngles(int[] sides) {
        int a=sides[0],b=sides[1],c=sides[2];
        if(a+b<=c || a+c<=b || b+c<=a){
            return new double[]{};
        }
    
        double cosa= (b*b + c*c -a*a)/(2.0*b*c);
        double cosb=(a*a + c*c - b*b)/(2.0*a*c);
        double cosc=(a*a + b*b-c*c)/(2.0*b*a);
        double[] ans=new double[3];
        ans[0] = Math.toDegrees(Math.acos(cosa));
        ans[1] = Math.toDegrees(Math.acos(cosb));
        ans[2] = Math.toDegrees(Math.acos(cosc));
        Arrays.sort(ans);
        return ans;
    }
}