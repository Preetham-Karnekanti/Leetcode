//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String args[]) throws IOException {

        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int V = Integer.parseInt(str[0]);
            int E = Integer.parseInt(str[1]);

            ArrayList<ArrayList<Integer>> edges = new ArrayList<>();

            int i = 0;
            while (i++ < E) {
                String S[] = read.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                int w = Integer.parseInt(S[2]);
                ArrayList<Integer> t1 = new ArrayList<>();
                t1.add(u);
                t1.add(v);
                t1.add(w);
                edges.add(t1);
            }

            int S = Integer.parseInt(read.readLine());

            Solution ob = new Solution();

            int[] ptr = ob.bellman_ford(V, edges, S);

            for (i = 0; i < ptr.length; i++) System.out.print(ptr[i] + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

/*
*   edges: vector of vectors which represents the graph
*   S: source vertex to start traversing graph with
*   V: number of vertices
*/
class Solution {
    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        // Write your code here
        int distance[] = new int[V];
        Arrays.fill(distance, (int)1e8);
        distance[S] = 0;
        for(int i = 0;i<V;i++){
          for(ArrayList<Integer> edge: edges){
              int u = edge.get(0);
              int v = edge.get(1);
              int wt = edge.get(2);
              if(distance[u] != (int)1e8 && distance[u] + wt < distance[v]){
                  distance[v] = distance[u] + wt;
              }
          }
        }
        for(ArrayList<Integer> edge: edges){
              int u = edge.get(0);
              int v = edge.get(1);
              int wt = edge.get(2);
              if(distance[u] != (int)1e8 && distance[u] + wt < distance[v]){
                  int temp[] = new int[1];
                  Arrays.fill(temp, -1);
                  return temp;
              }
          }
        
        return distance;
    }
}
