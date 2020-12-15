import java.util.PriorityQueue;
import java.util.Scanner;

public class MinimumSpanningTree {
    public static Long MST(){
        Scanner scanner = new Scanner(System.in);
        int v = scanner.nextInt(); //no of vertex
        int e = scanner.nextInt(); // no of edges
        long res = 0L;
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<Edge>();

        subset[] vertexA = new subset[v];

        for(int i=0; i<v;i++){
            vertexA[i]=new subset();
            vertexA[i].parent =i;
            vertexA[i].rank =0;
        }

        for(int i = 0; i<e; i++){
            Edge edge = new Edge();
            edge.setSource(scanner.nextInt());
            edge.setDestination(scanner.nextInt());
            edge.setWeight(scanner.nextInt());
            priorityQueue.add(edge);
        }

        while (!priorityQueue.isEmpty()){

            Edge ed = priorityQueue.poll();

            long x = find(vertexA,ed.getSource());
            long y = find(vertexA,ed.getDestination());

            if(x != y){ // not forming a cycle
                // union them/ make one parent for both the node
                union(vertexA, ed.getSource(),ed.getDestination());
                res = res + ed.weight;
                System.out.println(res);
            }


        }
        return res;
    }

    private static void union(subset[] subsets, int source, int destination) {

        int sourceRoot = find(subsets,source);
        int destinationRoot = find(subsets,destination);

        if(subsets[sourceRoot].rank < subsets[destinationRoot].rank){
            subsets[sourceRoot].parent = destinationRoot;
        }else if(subsets[sourceRoot].rank > subsets[destinationRoot].rank){
            subsets[destinationRoot].parent = sourceRoot;
        }else {
            subsets[destinationRoot].parent = sourceRoot;
            subsets[sourceRoot].rank++;
        }

    }

    public static class subset{
        int parent;
        int rank;
    }

    private static int find(subset[] subsets, int value) {
        if(value == subsets[value].parent){
            return subsets[value].parent;
        }

        subsets[value].parent = find(subsets,subsets[value].parent);

        return subsets[value].parent;
    }
}
