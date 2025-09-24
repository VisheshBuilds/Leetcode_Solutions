class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator ==0) return "0";
        StringBuilder result=new StringBuilder();
        if ((numerator < 0) ^ (denominator < 0)) result.append("-");

        long absnum=Math.abs((long)numerator);
        long absden=Math.abs((long)denominator);
        result.append(absnum/absden);
        
        long remain=absnum%absden;
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
            result.append(remain/absden);
            remain = remain%absden;
        }
        return result.toString();
    }
}