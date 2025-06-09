class Solution {
    int lcsOf3(String s1, String s2, String s3) {
        int a=s1.length();
        int b=s2.length();
        int c=s3.length();
        return lcs(s1,s2,s3,a,b,c);
        
    }
    
    int lcs(String x , String y, String z , int n , int m, int o){
        int[][][] dp= new int[n+1][m+1][o+1];
        
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                for(int k=1;k<o+1;k++){
                    if(x.charAt(i-1)==y.charAt(j-1) && x.charAt(i-1)==z.charAt(k-1)){
                        dp[i][j][k]= 1+dp[i-1][j-1][k-1];
                    }else{
                        dp[i][j][k] = Math.max(dp[i-1][j][k] ,Math.max(dp[i][j-1][k] , dp[i][j][k-1]));
                    }
                }
            }
        }
        return dp[n][m][o];
    }
}



// class Solution {
//     int lcsOf3(String s1, String s2, String s3) {
//         return solve(s1,s2,s3,0,0,0);
        
//     }
//     int solve(String s1,String s2,String s3,int i,int j,int k){
//         if(s1.length()==0 && s2.length()==0 && s3.length()==0){
//             return 0;
//         }
//         if(s1.length()==0 || s2.length()==0 || s3.length()==0){
//             return 0;
//         }
//         int count=Integer.MIN_VALUE;
//         if(s1.charAt(i)==s2.charAt(j) && s2.charAt(j)==s3.charAt(k)){
//             count=Math.max(count,1+solve(s1,s2,s3,i+1,j+1,k+1));
//         }
//         else{
//             count=Math.max(count,solve(s1,s2,s3,i+1,j,k));
//             count=Math.max(count,solve(s1,s2,s3,i,j+1,k));
//             count=Math.max(count,solve(s1,s2,s3,i,j,k+1));
//             count=Math.max(count,solve(s1,s2,s3,i+1,j+1,k));
//             count=Math.max(count,solve(s1,s2,s3,i+1,j,k+1));
//             count=Math.max(count,solve(s1,s2,s3,i,j+1,k+1));
//         }
//         return count;
//     }
// }
