//{ Driver Code Starts
import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

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

class GfG {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
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
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    static void printInorder(Node root)
    {
        if(root == null)
            return;
            
        printInorder(root.left);
        System.out.print(root.data+" ");
        
        printInorder(root.right);
    }
    
	public static void main (String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t > 0){
	            String s = br.readLine();
    	    	Node root = buildTree(s);
        	    Level_Order_Traverse g = new Level_Order_Traverse();
                ArrayList<ArrayList<Integer>> result = g.levelOrder(root);
                for(ArrayList<Integer> values : result){
                    for(int value : values){
                        System.out.print(value + " ");
                    }
                    System.out.print("$ ");
                }
    			System.out.println();
                t--;
            
        }
    }
   
}
// } Driver Code Ends


/*class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}*/


class Level_Order_Traverse
{
    static class info{
        Node root;
        int level;
        public info(Node root,int level){
            this.root=root;
            this.level=level;
        }
    }
    static ArrayList<ArrayList<Integer>> levelOrder(Node node) 
    {
        ArrayList<Integer> li=new ArrayList<>();
        ArrayList<ArrayList<Integer>> list=new ArrayList<>();
        Queue<info> q=new LinkedList<>();
        if(node==null){
            return list;
        }
        q.add(new info(node,0));
        while(!q.isEmpty()){
            info curr=q.poll();
            if(list.size()==curr.level){
                li.add(curr.root.data);
                list.add(new ArrayList(li));
                li.clear();
            }
            else{
                list.get(curr.level).add(curr.root.data);
            }
            if(curr.root.left!=null){
                q.add(new info(curr.root.left,curr.level+1));
            }
            if(curr.root.right!=null){
                q.add(new info(curr.root.right,curr.level+1));
            }
        }
        return list;
}}