//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            String inputLine[] = read.readLine().trim().split(" ");
            int n = inputLine.length;
            int arr[] = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            int sum = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.count(arr, sum));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    public int count(int coins[], int sum) {
        int[][] dp=new int[sum+1][coins.length];
        for(int[] d:dp){
            Arrays.fill(d,-1);
        }
        return solve(coins,sum,0,dp);
    }
    public int solve(int coins[],int sum,int i,int dp[][]){
        if(sum==0){
            return 1;
        }
        if(sum<0 || i>=coins.length){
            return 0;
        }
        if(dp[sum][i]!=-1){
            return dp[sum][i];
        }
        int ways=0;
        for(int j=i;j<coins.length;j++){
            ways+=solve(coins,sum-coins[j],j,dp);
        }
        return dp[sum][i]=ways;
    }
}