class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        int col=encodedText.length()/rows,k=0;
        char[][] mat=new char[rows][col];
        for(int i=0;i<rows;i++){
            for(int j=0;j<col;j++){
                mat[i][j]=encodedText.charAt(k);
                k++;
            }
        }

        StringBuilder ans=new StringBuilder();
        for(int start=0;start<col;start++){
            int i=0,j=start;
            while(i<rows && j < col){
                ans.append(mat[i][j]);
                i++; j++;
            }
        }
        return ans.toString().stripTrailing();
    }
}