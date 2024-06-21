//{ Driver Code Starts
// driver

import java.util.*;


// } Driver Code Ends
/* node for linked list

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

*/

class Solution {
    // Function to add two numbers represented by linked list.
    static Node addTwoLists(Node num1, Node num2) {
        // code here
        // return head of sum list
        Node reverseNum1 = reverse(num1);
        Node reverseNum2 = reverse(num2);
        int carry = 0;
        Node dummy = new Node(-1);
        Node ans = dummy;
        while(reverseNum1 != null && reverseNum2 != null){
            int sum = carry + reverseNum1.data + reverseNum2.data;
            carry = sum/10;
            sum = sum %10;
            ans.next = new Node(sum);
            ans = ans.next;
            reverseNum1 = reverseNum1.next;
            reverseNum2 = reverseNum2.next;
        }
        
        while(reverseNum1!= null){
            int sum = carry + reverseNum1.data;
            carry = sum/10;
            sum = sum %10;
            ans.next = new Node(sum);
            ans = ans.next;
            reverseNum1 = reverseNum1.next;
        }
         while(reverseNum2!= null){
            int sum = carry + reverseNum2.data;
            carry = sum/10;
            sum = sum %10;
            ans.next = new Node(sum);
            ans = ans.next;
            reverseNum2 = reverseNum2.next;
        }
        if(carry != 0){
            ans.next = new Node(carry);
        }
        ans = reverse(dummy.next);
        while(ans != null && ans.data == 0) ans = ans.next;
        if(ans == null)  return new Node(0);
        return ans;
    }
    
    public static Node reverse(Node head){
        Node cur = head, prev = null;
        while(cur!=null){
            Node next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}

//{ Driver Code Starts.

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class GfG {

    static void printList(Node n) {
        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {

            int n = sc.nextInt();
            int val = sc.nextInt();

            Node num1 = new Node(val);
            Node tail = num1;
            for (int i = 0; i < n - 1; i++) {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }

            int m = sc.nextInt();
            val = sc.nextInt();

            Node num2 = new Node(val);
            tail = num2;
            for (int i = 0; i < m - 1; i++) {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }

            Solution g = new Solution();
            Node res = g.addTwoLists(num1, num2);
            printList(res);
        }
    }
}

// } Driver Code Ends