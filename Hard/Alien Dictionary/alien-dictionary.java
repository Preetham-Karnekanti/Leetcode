//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = Integer.parseInt(sc.next());
		while(t-- > 0)
		{
		    int n = Integer.parseInt(sc.next());
		    int k = Integer.parseInt(sc.next());
		    
		    String[] words = new String[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        words[i] = sc.next();
		    }
		    
		    Solution ob = new Solution();
		  //  System.out.println(T.findOrder(words,k));
		    String order = ob.findOrder(words,n,k);
		    if(order.length() == 0){
		        System.out.println(0);
		        continue;
		    }
		    if(order.length() != k){
		        System.out.println("INCOMPLETE");
		        return;
		    }
		    String temp[] = new String[n];
		    for(int i=0;i<n;i++)
		        temp[i] = words[i];
		    
		    Arrays.sort(temp, new Comparator<String>(){
		    
		      @Override
                public int compare(String a, String b) {
                    int index1 = 0;
                    int index2 = 0;
                    for(int i = 0; i < Math.min(a.length(), b.length()) 
                                        && index1 == index2; i++) {
                        index1 = order.indexOf(a.charAt(i));
                        index2 = order.indexOf(b.charAt(i));
                    }
                
                    if(index1 == index2 && a.length() != b.length()) 
                    {
                        if(a.length() < b.length())
                            return -1;
                        else
                            return 1;
                    }
                
                    if(index1 < index2)
                        return -1;
                    else
                        return 1;
                        
                }
		    });
		    
		    int flag = 1;
		    for(int i=0;i<n;i++)
		    {
		        if(!words[i].equals(temp[i]))
	            {
	                flag = 0;
	                break;
	            }
		    }
		    
		    System.out.println(flag);
		}
	}
	
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    public String findOrder(String[] dict, int N, int K) {
        // Write your code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < K; i++)
            adj.add(new ArrayList<>());
        for (int i = 0; i < dict.length - 1; i++) {
            compareAndAddEdge(dict[i], dict[i + 1], adj);
        }

        List<Integer> topo = topoSort(adj, K);
        String ans = "";
        for (int i : topo) {
            ans += (char) ('a' + i);
        }
        return ans;
    }

    public void compareAndAddEdge(String s1, String s2, ArrayList<ArrayList<Integer>> adj) {
        int len = Math.min(s1.length(), s2.length());
        for (int i = 0; i < len; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                adj.get(s1.charAt(i) - 'a').add(s2.charAt(i) - 'a');
                break;
            }
        }
    }

    public List<Integer> topoSort(ArrayList<ArrayList<Integer>> adj, int K) {
        Queue<Integer> q = new LinkedList<>();
        List<Integer> topo = new ArrayList<>();
        int indegree[] = new int[K];
        for (int i = 0; i < adj.size(); i++) {
            for (int j : adj.get(i))
                indegree[j]++;
        }
        for (int i = 0; i < K; i++)
            if (indegree[i] == 0)
                q.add(i);
        while (!q.isEmpty()) {
            int cur = q.poll();
            topo.add(cur);
            for (int ngh : adj.get(cur)) {
                indegree[ngh]--;
                if (indegree[ngh] == 0)
                    q.add(ngh);
            }
        }
        return topo;
    }
}