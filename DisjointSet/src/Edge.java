public class Edge implements Comparable<Edge>{
    int source;
    int destination;
    int weight;

    public Edge() {
    }

    public Edge(int source, int destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    public int getSource() {
        return source;
    }

    public void setSource(int source) {
        this.source = source;
    }

    public int getDestination() {
        return destination;
    }

    public void setDestination(int destination) {
        this.destination = destination;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge compareEdge) {
        if(this.weight-compareEdge.weight ==0)
            return 0;
        else
            return  (this.weight-compareEdge.weight)>0 ?1:-1;
    }
}
