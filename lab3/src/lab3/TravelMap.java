package lab3;

public class TravelMap {
    private Node[] nodes;
    private Edge[] edges;
    private int nrOfNodes = 0; //nush cum sa adaug la final fara sa fac asta
    private int nrOfEdges = 0;

    public TravelMap() {
        nodes = new Node[100]; //nush cate elemente ar trebui sa aibe
        edges = new Edge[100];
    }

    public void addNode(Node node)
    {
        this.nodes[nrOfNodes] = node;
        nrOfNodes++;
    }

    public void addEdge(Edge edge)
    {
        this.edges[nrOfEdges] = edge;
        nrOfEdges++;
    }

}
