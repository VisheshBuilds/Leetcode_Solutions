class Solution {
    public String countOfAtoms(String f) {
        int i=0,n=f.length();
        Stack<HashMap<String,Integer>> st=new Stack<>();
        st.push(new HashMap<>());

        while(i<n){
            if(f.charAt(i)=='('){
                st.push(new HashMap<>());
                i++;
            }
            else if(f.charAt(i)==')'){
                i++;
                StringBuilder num = new StringBuilder();
                while(i<n && Character.isDigit(f.charAt(i))){
                    num.append(f.charAt(i));
                    i++;
                }

                int mul = num.length()==0 ? 1 : Integer.parseInt(num.toString());
                HashMap<String,Integer> map=st.pop();
                HashMap<String,Integer> org=st.pop();

                for(String key:map.keySet()){
                    int val=map.get(key);
                    map.put(key,val*mul);
                    org.put(key,org.getOrDefault(key,0)+map.get(key));
                }
                
                st.push(org);
            }
            else{
                
                StringBuilder atom=new StringBuilder();
                atom.append(f.charAt(i));
                i++;
                while(i<n && Character.isLowerCase(f.charAt(i))){
                    atom.append(f.charAt(i));
                    i++;
                }
                
                StringBuilder cnt = new StringBuilder();
                while(i<n && Character.isDigit(f.charAt(i))){
                    cnt.append(f.charAt(i));
                    i++;
                }

                int count = cnt.length()==0 ? 1 : Integer.parseInt(cnt.toString());
                HashMap<String,Integer> map=st.pop();
                String name=atom.toString();
                map.put(name,map.getOrDefault(name,0)+ count );
                st.push(map);
            }
        }
        while(st.size()>1){
            HashMap<String,Integer> map=st.pop();
            HashMap<String,Integer> org=st.pop();
            for(String key:map.keySet()){
                    org.put(key,org.getOrDefault(key,0)+map.get(key));
            }
            st.push(org);
        }
        TreeMap<String,Integer> ans=new TreeMap<>();
        HashMap<String,Integer> map=st.pop();
        for(String key:map.keySet()){
            int val=map.get(key);
            ans.put(key,val);
        }
        StringBuilder str=new StringBuilder();
        for(String key:ans.keySet()){
            int val=ans.get(key);
            str.append(key);
            if(val > 1) str.append(String.valueOf(val));
        }
        return str.toString();
    }
}