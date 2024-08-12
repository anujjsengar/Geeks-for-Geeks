//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class GfG {

    static Node buildTree(String str) {

        if (str.length() == 0 || str.charAt(0) == 'N') {
            return null;
        }

        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue

        Queue<Node> queue = new LinkedList<>();

        queue.add(root);
        // Starting from the second element

        int i = 1;
        while (queue.size() > 0 && i < ip.length) {

            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= ip.length) break;

            currVal = ip[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }

    static void printInorder(Node root) {
        if (root == null) return;

        printInorder(root.left);
        System.out.print(root.data + " ");

        printInorder(root.right);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String s = br.readLine();
            Node root = buildTree(s);
            Solution obj = new Solution();
            int ans = obj.verticalWidth(root);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
    static class info{
        Node root;
        int hd;
        public info(Node root,int hd){
            this.hd=hd;
            this.root=root;
        }
    }
    public int verticalWidth(Node root) {
        if(root==null){
            return 0;
        }
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        Queue<info> q=new LinkedList<>();
        q.add(new info(root,1));
        while(!q.isEmpty()){
            info curr=q.poll();
            min=Math.min(min,curr.hd);
            max=Math.max(max,curr.hd);
            if(curr.root.left!=null){
                q.add(new info(curr.root.left,curr.hd-1));
                
            }
            if(curr.root.right!=null){
                q.add(new info(curr.root.right,curr.hd+1));
               
            }
        }
        //System.out.println(min+" "+max);
        int count=0;
        for(int i=min;i<=max;i++){
            count++;
        }
        return count;
    }
}