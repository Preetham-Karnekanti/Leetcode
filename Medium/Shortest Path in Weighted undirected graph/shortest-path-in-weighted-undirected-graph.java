//{ Driver Code Starts
import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br;
    static PrintWriter ot;
    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        ot = new PrintWriter(System.out);

        int t = Integer.parseInt(br.readLine().trim());

        while(t-- > 0){
            String s[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]), m = Integer.parseInt(s[1]);
            int edges[][] = new int[m][3];
            for(int i = 0; i < m; i++){
                s = br.readLine().trim().split(" ");
                edges[i][0] = Integer.parseInt(s[0]);
                edges[i][1] = Integer.parseInt(s[1]);
                edges[i][2] = Integer.parseInt(s[2]);
            }

            List<Integer> list = new Solution().shortestPath(n, m, edges);
            
            ot.println(list.get(0));
            if(list.get(0) != -1 && !check(list, edges))
                ot.println(-1);
        }
        ot.close();
    }
    static boolean check(List<Integer> list, int edges[][]){
        Set<Integer> hs = new HashSet<>();
        Map<Integer, Map<Integer, Integer>> hm = new HashMap<>();
        for(int i = 1; i < list.size(); i++)
            hs.add(list.get(i));
        for(int x[] : edges){
            if(hs.contains(x[0]) || hs.contains(x[1])){
                if(!hm.containsKey(x[0]))
                    hm.put(x[0], new HashMap<>());
                if(!hm.containsKey(x[1]))
                    hm.put(x[1], new HashMap<>());
                hm.get(x[0]).put(x[1], x[2]);
                hm.get(x[1]).put(x[0], x[2]);
            }
        }
        int sum = 0;
        for(int i = 1; i < list.size() - 1; i++){
            if(!hm.containsKey(list.get(i)) || !hm.get(list.get(i)).containsKey(list.get(i + 1)))
                return false;
            sum += hm.get(list.get(i)).get(list.get(i + 1));
        }
        return sum == list.get(0);
    }
} 

// } Driver Code Ends


class Solution{
    public List<Integer> shortestPath(int n, int m, int edges[][]){
        //  Code Here.
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0;i<=n;i++)
            adj.add(new ArrayList<>());
        for(int e[] : edges){
            int u = e[0];
            int v = e[1];
            int wt = e[2];
            adj.get(u).add(new Pair(v, wt));
            adj.get(v).add(new Pair(u, wt));
        }
        int source = 1, destination = n;
        List<Integer> shortestPath = getShortestPath(source, destination, adj,n);
        
        return shortestPath;
    }
    
    public List<Integer> getShortestPath(int source, int destination, 
                        ArrayList<ArrayList<Pair>> adj, int n){
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->{
            if(a.weight == b.weight)
                return a.node - b.node;
            return a.weight - b.weight;
        });
        List<Integer> shortestPath = new ArrayList<>();
        int[] distance = new int[n+1];
        int[] parent = new int[n+1];
        for(int i = 0;i<=n;i++)
            parent[i] = i;
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[source] = 0;
        pq.add(new Pair(source, 0));
        while(!pq.isEmpty()){
            Pair curNode = pq.poll();
            for(Pair adjNode: adj.get(curNode.node)){
                int node = adjNode.node;
                int weight = adjNode.weight;
                if(distance[node] > weight + curNode.weight){
                    parent[node] = curNode.node;
                    distance[node] = weight + curNode.weight;
                    pq.add(new Pair(node,distance[node]));
                }
            }
        }
        if(distance[destination] == Integer.MAX_VALUE){
            shortestPath.add(-1);
            return shortestPath;
        }
        int node = destination;
        while(parent[node] != node){
            shortestPath.add(node);
            node = parent[node];
        }
        shortestPath.add(source);
        shortestPath.add(distance[destination]);
        Collections.reverse(shortestPath);
        return shortestPath;
    }
}

class Pair{
    int node;
    int weight;
    Pair(int node, int weight){
        this.node = node;
        this.weight = weight;
    }
}