class Solution {
    public String discountPrices(String s, int discount) {
        String[] arr=s.split(" ");

        for(int i=0;i<arr.length;i++){
            String str=arr[i];
            if(str.length()!=0 && str.charAt(0)=='$'){
                if(str.substring(1).matches("\\d+")){
                    double n=Double.parseDouble(str.substring(1));
                    n= n-(n*discount/100.0);
                    arr[i] = "$"+ String.format("%.2f",n);
                }
            }
        }
        return String.join(" ",arr);
    }
}