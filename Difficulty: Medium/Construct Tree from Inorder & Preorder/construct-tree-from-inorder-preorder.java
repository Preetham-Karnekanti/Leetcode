//{ Driver Code Starts
import java.util.*;
import java.io.*;
class Node
{
    int data; 
    Node left, right;
    Node(int key)
    {
        data = key;
        left = right = null;
    }
}

class GFG
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            Node root = null;
            int inorder[] = new int[n];
            int preorder[] = new int[n];
            for(int i = 0; i < n; i++)
              inorder[i] = sc.nextInt();
              
            for(int i = 0; i < n; i++)
              preorder[i] = sc.nextInt();
              
            Solution ob = new Solution();
            root = ob.buildTree(inorder, preorder, n);
            postOrdrer(root);
            System.out.println();
        }
    }
    
    public static void postOrdrer(Node root)
    {
        if(root == null)
          return;
          
        postOrdrer(root.left);
        postOrdrer(root.right);
        System.out.print(root.data + " ");
    }
}
// } Driver Code Ends


class Solution
{
    static int preIndex;
    public static Node buildTree(int inorder[], int preorder[], int n)
    {
        // code here 
        preIndex = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        return helper(hm,inorder, preorder, 0 , n -1);
    }
    
    public static Node helper(HashMap<Integer, Integer> hm,int[] inorder, int[] preorder, int start, int end){
        if(start > end)
            return null;
        int value = preorder[preIndex++];
        Node root = new Node(value);
        if(start == end) return root;
        int idx = -1;
        for(int i = start;i<=end;i++){
            if(inorder[i] == value){
                idx = i;
                break;
            }
        }
        root.left = helper(hm,inorder, preorder, start, idx -1);
        root.right = helper(hm,inorder, preorder, idx + 1, end);
        return root;
    }
}
