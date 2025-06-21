class Solution {
    static int minJumps(int[] arr) {
        int dp[]=new int[arr.length];
        Arrays.fill(dp,0);
        int result=solve(arr,0,dp);
        return result==Integer.MAX_VALUE?-1:result;
    }
    static int solve(int[] arr,int i,int dp[]){
        if(i==arr.length-1){
            return 0;
        }
        if(i>=arr.length-1){
            return Integer.MAX_VALUE;
        }
        if(dp[i]!=0){
            return dp[i];
        }
        int min=Integer.MAX_VALUE;
        for(int j=1;j<=arr[i];j++){
            int result=solve(arr,i+j,dp);
            if(result!=Integer.MAX_VALUE){
                min=Math.min(min,1+result);
            }
        }
        return dp[i]=min;
    }
}