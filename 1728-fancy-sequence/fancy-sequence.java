class Fancy {
    ArrayList<Long> list;
    long add=0;
    long mul=1;
    long mod=1000000007;
    public Fancy() {
        list=new ArrayList<>();
    }
    
    public void append(int val) {
        long x=( ((val - add)%mod  + mod )* power(mul,mod-2))% mod ;
        list.add(x);
    }
    
    public void addAll(int inc) {
        add=(add + inc)%mod;
    }
    
    public void multAll(int m) {
        add= (add*m)%mod;
        mul = (mul *m)%mod;
    }
    
    public int getIndex(int idx) {
        if(idx >= list.size()) return -1;
        return (int)(( (list.get(idx)* mul)%mod + add)%mod);
    }
    long power(long a, long b) {
        if (b == 0)
            return 1;

        long half   = power(a, b / 2);
        long result = (half * half) % mod;

        if (b % 2 == 1) {
            result = (result * a) % mod;
        }

        return result;
    }
}

/**
 * Your Fancy object will be instantiated and called as such:
 * Fancy obj = new Fancy();
 * obj.append(val);
 * obj.addAll(inc);
 * obj.multAll(m);
 * int param_4 = obj.getIndex(idx);
 */