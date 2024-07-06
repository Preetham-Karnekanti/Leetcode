//{ Driver Code Starts
import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node
{
    int data;
    Node left;
    Node right;
    Node(int data)
    {
        this.data = data;
        left=null;
        right=null;
    }
}

class Main
{
    static Node buildTree(String str)
    {
        
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
    
    public static void main (String[] args) throws IOException
    {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int t=Integer.parseInt(br.readLine());
        
        while(t-- > 0)
        {
            String s = br.readLine();
            Node root = buildTree(s);
            
            Solution g = new Solution();
            System.out.println(g.longestConsecutive(root));
        }
	}
}


// } Driver Code Ends


/*Complete the function below
Node is as follows
class TreeNode
{
    int key;
    TreeNode left, right;
    public TreeNode(int key)
    {
        this.key = key;
        left = right = null;
    }
}*/
class Solution
{
	public int longestConsecutive(Node root)
    {
         //add code here.
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 1));
        int max = -1;
        while(!q.isEmpty()){
            Pair cur = q.poll();
            Node curNode = cur.node;
            int len = cur.len;
            max = Math.max(max, len);
            if(curNode.left != null){
                if(curNode.data + 1 == curNode.left.data ){
                    q.add(new Pair(curNode.left, len + 1));
                }else{
                    q.add(new Pair(curNode.left, 1));
                }
            }
            
            if(curNode.right != null){
                if(curNode.data + 1 == curNode.right.data){
                    q.add(new Pair(curNode.right, len + 1));
                }else{
                    q.add(new Pair(curNode.right, 1));
                }
            }
        }
        return max == 1 ? -1 : max;
    }
}

class Pair{
    Node node;
    int len;
    Pair(Node node,int len){
        this.node = node;
        this.len = len;
    }
}
