//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    System.out.println(new Solution().evaluatePostFix(br.readLine().trim()));
		}
	}
}
// } Driver Code Ends


class Solution
{
    //Function to evaluate a postfix expression.
    public static int evaluatePostFix(String s)
    {
        // Your code here
        Stack<Integer> st = new Stack<>();
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                int num = s.charAt(i) - '0';
                st.push(num);
            }else{
                int one = st.pop();
                int two = st.pop();
                int res = evaluate(one, two, s.charAt(i));
                st.push(res);
            }
        }
        return st.peek();
    }
    
    public static int evaluate(int a, int b, char operator){
        switch(operator){
            case '+': return a + b;
            case '-': return b - a;
            case '*': return a * b;
            case '/': return b / a;
        }
        return 0;
    }
}