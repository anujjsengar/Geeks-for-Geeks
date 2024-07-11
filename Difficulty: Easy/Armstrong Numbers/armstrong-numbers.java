//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();

            System.out.println(ob.armstrongNumber(n));
        }
    }
}
// } Driver Code Ends




//User function Template for Java
class Solution {
    static String armstrongNumber(int n){
        int num=n;
        int count_digit=(int)(Math.log10(n)+1);
        int ans=0;
        while(num>0){
            ans=ans+(int)Math.pow(num%10,count_digit);
            num=num/10;
    }
    if(ans==n){
        return "true";
    }
    else{
        return "false";
    }
}
}