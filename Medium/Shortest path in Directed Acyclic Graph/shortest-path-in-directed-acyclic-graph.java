//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] edge = new int[m][3];
			for (int i = 0; i < m; i++) {
				edge[i][0] = sc.nextInt();
				edge[i][1] = sc.nextInt();
				edge[i][2] = sc.nextInt();
			}
			Solution obj = new Solution();
			int res[] = obj.shortestPath(n, m,edge);
			for (int i = 0; i < n; i++) {
				System.out.print(res[i] + " ");
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends


//User function Template for Java
class Solution {

	public int[] shortestPath(int N,int M, int[][] edges) {
		//Code here
		int source = 0;
		ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
		for(int i = 0;i<N;i++)
		    adj.add(new ArrayList<>());
		for(int e[] : edges){
		    adj.get(e[0]).add(new Pair(e[1], e[2]));
		}
		boolean vis[] = new boolean[N];
		Stack<Integer> st = new Stack<>();
		for(int i = 0;i<N;i++){
		    if(!vis[i])
		        dfs(adj,vis,i,st);
		}
		while(!st.isEmpty()){
		    if(st.peek() !=0)
		        st.pop();
		    else break;
		}
		int dist[] = new int[N];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[source] = 0;
		while(!st.isEmpty()){
		    int node = st.pop();
		    for(Pair p: adj.get(node)){
		        int v = p.v;
		        int wt = p.wt;
		        dist[v] = Math.min(dist[v], wt + dist[node]);
		    }
		}
		for(int i = 0;i<N;i++){
		    if(dist[i] == Integer.MAX_VALUE)
		        dist[i] = -1;
		}
		return dist;
	}
	
	public void dfs(ArrayList<ArrayList<Pair>> adj, boolean vis[], int start, Stack<Integer> st){
	    vis[start] = true;
	    for(Pair p: adj.get(start)){
	        if(!vis[p.v]){
	            dfs(adj, vis, p.v, st);
	        }
	    }
	    st.push(start);
	}
}

class Pair{
    int v;
    int wt;
    Pair(int v,int wt){
        this.v = v;
        this.wt = wt;
    }
}