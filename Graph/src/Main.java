import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class Main {
    public static void main(String [] args){
        System.out.println("Hello Graph");
        inputParams();
    }

    private static void inputParams() {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- >0){
            ArrayList<ArrayList<Integer>> graphAdjecencyyList = new ArrayList<>();
            int nov = scanner.nextInt();
            int edg = scanner.nextInt();

            for(int i =0;i<nov;i++){
                graphAdjecencyyList.add(i, new ArrayList<Integer>());
            }

            for (int i=0;i<edg;i++){
                int u = scanner.nextInt();
                int v = scanner.nextInt();
                graphAdjecencyyList.get(u).add(v);
            }

            ArrayList<Integer> res = new Traversal().bfs(graphAdjecencyyList, nov);
            System.out.println("BFS:\n");
            for (Integer re : res) {
                System.out.print(re + " ");
            }
            System.out.println();

            new Traversal();
            ArrayList<Integer> resDfs = Traversal.dfs(graphAdjecencyyList, nov);
            System.out.println("DFS:\n");
            for (Integer re : resDfs) {
                System.out.print(re + " ");
            }
            System.out.println();

            System.out.println("Shortest path unweighted");
            int[] dist =ShortestPathUnWeighted.findShortestPath(graphAdjecencyyList,0);
            for(int i =0; i<dist.length;i++){
                System.out.print(""+dist[i]+" ");
            }

        }
    }
}
