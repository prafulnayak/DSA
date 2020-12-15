import java.util.Scanner;

public class MergingCommunities {

    public static void MST(){
        Scanner scanner = new Scanner(System.in);
        int N= scanner.nextInt();
        int Q = scanner.nextInt();

        Subset[] subset = new Subset[N];
        for(int i=0; i<N;i++){
            subset[i] = new Subset();
            subset[i].parent = i+1; //set parent
            subset[i].communitySize = 1;
        }

        for(int i=0;i<Q;i++){
            String qm = scanner.next();
            switch (qm){
                case "Q":
                    int vertex = scanner.nextInt();
                    System.out.println(subset[find(subset,vertex)-1].communitySize);
                    break;
                case "M":
                    int x =scanner.nextInt();
                    int y =scanner.nextInt();
                    union(subset,x,y);
                    break;
            }
        }
        scanner.close();
    }
    public static class Subset{
        int parent;
        int communitySize;
    }

    private static void union(Subset[] subset, int x, int y) {
        int xRoot = find(subset,x);
        int yRoot = find(subset,y);
        if(xRoot != yRoot){
            subset[xRoot-1].parent = yRoot;
            subset[yRoot-1].communitySize = subset[xRoot-1].communitySize+ subset[yRoot-1].communitySize;

        }
    }

    public static int find(Subset[] subset, int v){
        if(subset[v-1].parent == v){
            return v;
        }
        return subset[v-1].parent = find(subset,subset[v-1].parent);
    }


}
