class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator ==0) return "0";
        StringBuilder result=new StringBuilder();
        if ((numerator < 0) ^ (denominator < 0)) result.append("-");

        long absnumerator=Math.abs((long)numerator);
        long absdenominator=Math.abs((long)denominator);
        result.append(absnumerator/absdenominator);
        
        long remain=absnumerator%absdenominator;
        if(remain==0) return result.toString();
        result.append(".");
        Map<Long,Integer> map=new HashMap<>();

        while(remain!=0){
            if(map.containsKey(remain)){
                result.insert(map.get(remain),"(");
                result.append(")");
                break;
            }
            map.put(remain,result.length());
            remain *=10;
            result.append(remain/absdenominator);
            remain = remain%absdenominator;
        }
        return result.toString();
    }
}