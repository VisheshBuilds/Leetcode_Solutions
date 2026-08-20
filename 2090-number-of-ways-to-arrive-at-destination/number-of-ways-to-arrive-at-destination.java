class Solution { 
    public class Pair implements Comparable<Pair> { 
        int node; 
        long time; 
        
        Pair(int node, long time) { 
            this.node = node; 
            this.time = time; 
        } 
        
        public int compareTo(Pair p) { 
            return Long.compare(this.time, p.time); 
        } 
    } 

    public int countPaths(int n, int[][] roads) { 
        int mod = 1000000007; 
        
        List<List<Pair>> adj = new ArrayList<>(); 
        
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
 
        for (int i = 0; i < roads.length; i++) { 
            int a = roads[i][0];
            int b = roads[i][1];
            int c = roads[i][2];
            
            adj.get(a).add(new Pair(b, c)); 
            adj.get(b).add(new Pair(a, c)); 
        } 
 
        // ans[i] = shortest time to reach node i
        long[] ans = new long[n]; 
        Arrays.fill(ans, Long.MAX_VALUE); 
        
        // ways[i] = number of shortest paths to node i
        int[] ways = new int[n];
        
        ans[0] = 0;
        ways[0] = 1;
 
        PriorityQueue<Pair> pq = new PriorityQueue<>(); 
        pq.add(new Pair(0, 0)); 
        
        while (!pq.isEmpty()) { 
            Pair top = pq.remove(); 
            
            int node = top.node;
            long time = top.time; 
            
            if (time > ans[node]) continue; 
 
            for (Pair p : adj.get(node)) { 
                long totaltime = time + p.time; 
                
                // Found a shorter path
                if (totaltime < ans[p.node]) { 
                    ans[p.node] = totaltime; 
                    
                    // All shortest ways to node can now reach p.node
                    ways[p.node] = ways[node];
                    
                    pq.add(new Pair(p.node, totaltime)); 
                } 
                
                // Found another path with the same shortest distance
                else if (totaltime == ans[p.node]) {
                    ways[p.node] = (int)(
                        ((long) ways[p.node] + ways[node]) % mod
                    );
                }
            } 
        } 
        
        return ways[n - 1]; 
    } 
}