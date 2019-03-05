package lab3;

import java.util.List;

public class TravelMap {
    private List<Node> nodes;
    private List<Edge> edges;
    private int nrOfNodes = 0; //nush cum sa adaug la final fara sa fac asta
    private int nrOfEdges = 0;

//    public TravelMap() {
//        nodes.add()
//        nodes = new Node[100]; //nush cate elemente ar trebui sa aibe
//        edges = new Edge[100];
//    }

    public void addNode(Node node)
    {
        this.nodes.add(node);
//        this.nodes[nrOfNodes]? = node;
//        nrOfNodes++;
    }

    public void addEdge(Edge edge)
    {
        this.edges.add(edge);
//        this.edges[nrOfEdges] = edge;
//        nrOfEdges++;
    }

}
