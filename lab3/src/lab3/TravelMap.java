package lab3;

import java.util.*;

/**
 * A class that represents a collection of nodes and the edges between them
 */

public class TravelMap {
    /**
     * The list of nodes that are part of the TravelMap object
     */
    private List<Node> nodes=new ArrayList<Node>(100);
    /**
     * The list of edges between the nodes of the TravelMap object
     */
    private List<Edge> edges=new ArrayList<Edge>(100);
//    private int nrOfNodes = 0;
    private int nrOfEdges = 0;

    /**
     * Adds a node to the TravelMap
     * @param node the node to be added in the TravelMap
     */
    public void addNode(Node node)
    {
        this.nodes.add(node);
    }

    /**
     * Adds an edge to the TravelMap
     * @param edge the edge to be added in the TravelMap
     */
    public void addEdge(Edge edge)
    {
        this.edges.add(edge);
//        this.edges[nrOfEdges] = edge;
      nrOfEdges++;
    }

    /**
     * Creates and adds an edge that is bi-directional to the TravelMap
     * @param n1 The first node of the edge
     * @param n2 The second node of the edge
     * @param weight The weight of the edge
     */
    public void addEdge(Node n1, Node n2, int weight)
    {
        this.edges.add(new Edge(n1, n2, weight));
        nrOfEdges++;
    }

    /**
     * Creates and adds an edge that may be uni-directional or bi-directional to the TravelMap
     * @param n1 The first node of the edge
     * @param n2 The second node of the edge
     * @param weight The weight of the edge
     * @param twoWay false if the edge is uni-directional, true if it's bi-directional
     */
    public void addEdge(Node n1, Node n2, int weight, boolean twoWay)
    {
        this.edges.add(new Edge(n1, n2, weight, twoWay));
        nrOfEdges++;
    }

    /**
     * @return A string of the sorted list of names of the nodes in the TravelMap
     */
    public String getNodes()
    {
        Collections.sort(nodes,new Comparator<Node>() {
            public int compare(Node c1, Node c2) {
                int result=c1.getName().compareTo(c2.getName());
                if (result<0) return -1;
                if (result>0) return 1;
                return 0;
            }});

        String nodes = new String(this.nodes.get(0).getName());
        for (int i=1; i<this.nodes.size()-1; i++)
        {
            nodes += ", " + this.nodes.get(i).getName();
        }
        if (this.nodes.size() != 1)
            nodes += ", " + this.nodes.get(this.nodes.size()-1).getName();
        return nodes;
    }

    /**
     * @return A string of the list of edges in the TravelMap
     */
    public String getEdges()
    {
        String edges = new String("Edge  \t\t\t\t\t\t\t|\t  Cost \n");
        for (Edge edge:this.edges)
        {
            edges += edge.getNode1().getName();
            if (edge.isTwoWay())
                edges += " ↔ ";
            else
                edges += " → ";
            edges += edge.getNode2().getName() + " | " + edge.getWeight() + "\n";
        }
        return edges;
    }

    @Override
    public String toString()
    {
        String map = new String();
        map += this.getNodes() + "\n";
        map += this.getEdges();
        return map;
    }
    /**
     * Prints every node that is visitable and not payable sorted by their opening hour
     */
    public void freeVisitable(){
        Comparator<Visitable> dateComparator = (h1, h2) -> h1.getOpeningHours().compareTo(h2.getOpeningHours());
        nodes.stream().filter(sc->sc instanceof Visitable ).filter(sc->!(sc instanceof Payable) ).sorted().forEach(System.out::println);
    }

    /**
     * Prints the average ticket price for every node in the TravelMap that is payable
     */
    public void averageTicketPayable(){
        nodes.stream().filter(sc->sc instanceof Payable).mapToDouble(sc->((Payable) sc).getEntryFee()).average().stream().forEach(System.out::println);
    }
}
