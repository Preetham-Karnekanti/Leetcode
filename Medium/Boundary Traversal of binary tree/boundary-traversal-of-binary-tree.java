//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}

class GFG
{
    static Node buildTree(String str)
    {
        // Corner Case
        if(str.length() == 0 || str.equals('N'))
            return null;
        String[] s = str.split(" ");
        
        Node root = new Node(Integer.parseInt(s[0]));
        Queue <Node> q = new LinkedList<Node>();
        q.add(root);
        
        // Starting from the second element
        int i = 1;
        while(!q.isEmpty() && i < s.length)
        {
              // Get and remove the front of the queue
              Node currNode = q.remove();
        
              // Get the current node's value from the string
              String currVal = s[i];
        
              // If the left child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the left child for the current node
                  currNode.left = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.left);
              }
        
              // For the right child
              i++;
              if(i >= s.length)
                  break;
              currVal = s[i];
        
              // If the right child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the right child for the current node
                  currNode.right = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.right);
              }
              
              i++;
        }
    
        return root;
    }
    
    public static void main(String args[]) throws IOException {
    
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine();
            Node root = buildTree(s);
            
            Solution T = new Solution();
            
            ArrayList <Integer> res = T.boundary(root);
            for (Integer num : res) System.out.print (num + " ");
            System.out.println();
            t--;
        }
    }
}

// } Driver Code Ends


//User function Template for Java

// class Node  
// { 
//     int data; 
//     Node left, right; 
   
//     public Node(int d)  
//     { 
//         data = d; 
//         left = right = null; 
//     } 
// }

class Solution
{
	ArrayList <Integer> boundary(Node node)
	{
	    ArrayList<Integer> al = new ArrayList<>();
	    if(node == null)
	        return al;
	    al.add(node.data);
	    if(node.left == null && node.right == null)
	        return al;
	    leftBoundary(node.left, al);
	    inorder(node,al);
	    rightBoundary(node.right, al);

	    
	    return al;
	}
	
	public void leftBoundary(Node node, ArrayList<Integer> al){
	    while(node!=null){
	        if(!(node.left == null && node.right == null))
	            al.add(node.data);
	        if(node.left!=null)
	            node = node.left;
	        else
	            node = node.right;
	    }
	}
	public void rightBoundary(Node node, ArrayList<Integer> al){
	    ArrayList<Integer> temp = new ArrayList<>();
	    while(node!=null){
	        if(!(node.left == null && node.right == null))
	            temp.add(node.data);
	        if(node.right != null)
	            node = node.right;
	        else
	            node = node.left;
	    }
	    for(int i = temp.size() - 1;i>=0;i--)
	        al.add(temp.get(i));
	}
	
	public void inorder(Node node, ArrayList<Integer> al){
	    if(node == null)
	        return;
	       if(node.left == null && node.right == null)
	        al.add(node.data);
	       inorder(node.left, al);
	       inorder(node.right, al);
	}
}
