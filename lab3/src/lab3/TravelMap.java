package lab3;

import java.util.*;

public class TravelMap {
    private List<Node> nodes=new ArrayList<Node>(100);
    private List<Edge> edges=new ArrayList<Edge>(100);
    private int nrOfNodes = 0; //nush cum sa adaug la final fara sa fac asta
    private int nrOfEdges = 0;

    public void addNode(Node node)
    {
        this.nodes.add(node);
    }



    public void addEdge(Edge edge)
    {
        this.edges.add(edge);
//        this.edges[nrOfEdges] = edge;
        nrOfEdges++;
    }

    public void addEdge(Node n1, Node n2, int weight)
    {
        this.edges.add(new Edge(n1, n2, weight));
        nrOfEdges++;
    }

    public void addEdge(Node n1, Node n2, int weight, boolean twoWay)
    {
        this.edges.add(nrOfEdges,new Edge(n1, n2, weight, twoWay));
        nrOfEdges++;
    }

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
    public void freeVisitable(){
        Comparator<Visitable> dateComparator = (h1, h2) -> h1.getOpeningHours().compareTo(h2.getOpeningHours());
        nodes.stream().filter(sc->sc instanceof Visitable ).filter(sc->!(sc instanceof Payable) ).sorted().forEach(System.out::println);
    }

    public void averageTicketPayable(){
        nodes.stream().filter(sc->sc instanceof Payable).mapToDouble(sc->((Payable) sc).getEntryFee()).average().stream().forEach(System.out::println);
    }

    


}
