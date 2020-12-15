import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class Traversal {
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> list, int nov) {

        boolean [] vis = new boolean[nov];
        for(int i =0; i<nov;i++)
            vis[i] = false;

        int src =0;
        ArrayList<Integer> res = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        vis[src] = true;
        q.add(src);
        while (q.size() !=0){
            src = q.poll();
            res.add(src);
            Iterator<Integer>  it = list.get(src).iterator();
            while (it.hasNext()){
                int n = it.next();
                if(!vis[n]){
                    vis[n] = true;
                    q.add(n);
                }
            }
        }
        return res;
    }

    static ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> g, int N)
    {
        // add your code here
        boolean vis [] = new boolean[N];
        for(int i =0; i<N; i++){
            vis[i] = false;
        }

        ArrayList<Integer> res = new ArrayList<>();

        for(int i=0; i<N; i++){
            if(!vis[i]){
                DFSUtil(i,g,N,vis,res);
            }
        }
        return res;
    }

    private static void DFSUtil(int i, ArrayList<ArrayList<Integer>> g, int n, boolean[] vis, ArrayList<Integer> res) {
        if(vis[i])
            return;
        vis[i] = true;
        res.add(i);
        for(int j=0;j<g.get(i).size();j++){
            if(!vis[g.get(i).get(j)]){
                DFSUtil(g.get(i).get(j),g,n,vis,res);
            }
        }
    }
}
