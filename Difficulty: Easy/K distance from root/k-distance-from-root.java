/*
class Node
{
    int data;
    Node left, right;
   Node(int item)    {
        data = item;
        left = right = null;
    }
} */

class Tree {
    // Recursive function to print right view of a binary tree.
    ArrayList<Integer> Kdistance(Node root, int k) {
        // Your code here
        ArrayList<Integer> li=new ArrayList<>();
        solve(root,k,li);
        return li;
    }
    void solve(Node root,int k,ArrayList<Integer> li){
        if(root==null){
            return ;
        }
        if(k==0){
            li.add(root.data);
            return ;
        }
        solve(root.left,k-1,li);
        solve(root.right,k-1,li);
    }
}