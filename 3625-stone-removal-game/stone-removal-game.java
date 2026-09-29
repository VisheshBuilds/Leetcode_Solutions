class Solution {
    public boolean canAliceWin(int n) {
        int remove=10,dir=1;
        if(n<10) return false;

        while(n>0){
            if(dir==1 && n<remove) return false;
            else if(dir==-1 && n< remove) return true;

            n -=remove;
            remove--;
            dir= -dir;
        }
        if(dir==1) return false;
        return true;
    }
}