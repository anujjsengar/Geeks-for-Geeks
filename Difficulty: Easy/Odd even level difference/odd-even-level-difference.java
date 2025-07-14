/*
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
*/
class Solution {
    static int sumeven=0;
    static int sumodd=0;
    int getLevelDiff(Node root) {
        // code here
        sumeven=0;
        sumodd=0;
        solve(root,0);
        return sumeven-sumodd;
    }
    void solve(Node root,int level){
        if(root==null){
            return ;
        }
        if(level%2==0){
            sumeven+=root.data;
        }
        else{
            sumodd+=root.data;
        }
        solve(root.left,level+1);
        solve(root.right,level+1);
    }
}