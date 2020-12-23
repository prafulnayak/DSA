import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathUnWeighted {
    public static int[] findShortestPath(ArrayList<ArrayList<Integer>> graph,int from){
        int size = graph.size();
        int [] dist = new int[size];
        boolean[] vis = new boolean[size];
        Arrays.fill(dist,0);
        Arrays.fill(vis,false);

        //BFS
        Queue<Integer> queue = new LinkedList<>();
        queue.add(from);
        vis[from] = true;
        while (!queue.isEmpty()){
            int u = queue.poll();
            for(int v: graph.get(u)){
                if(!vis[v]){
                    dist[v] = dist[u]+1; //distance of each vertex from "from"
                    queue.add(v);
                    vis[v] = true;
                }
            }
        }
        return dist;
    }
}
