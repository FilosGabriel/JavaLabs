package lab3;

import java.util.ArrayList;
import java.util.List;

public class TravelMap {
    private List<Node> nodes=new ArrayList<Node>();
    private List<Edge> edges=new ArrayList<Edge>();
    private int nrOfNodes = 0; //nush cum sa adaug la final fara sa fac asta
    private int nrOfEdges = 0;

//    public TravelMap() {
//        nodes.add()
//        nodes = new Node[100]; //nush cate elemente ar trebui sa aibe
//        edges = new Edge[100];
//    }

    public void addNode(Node node)
    {
        if (nrOfNodes == 0)
        {
            this.nodes.add(node);
            nrOfNodes++;
        }
        else if (nrOfNodes == 1)
        {
            if (node.getName().compareTo(this.nodes.get(0).getName()) <= 0)
            {
                this.nodes.add(1, this.nodes.get(0));
                this.nodes.add(0,  node);
            }
            else
            {
                this.nodes.add(1,node);
            }
            this.nrOfNodes++;

        }
        else //adaugare in vector sortat
        {
            int start = 0;
            int stop = nrOfNodes-1;
            int m;
            while (true)
            {
                m = (stop - start)/2;
                if (stop-start == 1 || stop-start == 0)
                {
                    if (node.getName().compareTo(this.nodes.get(stop).getName()) > 0)
                    {
                        m=stop+1;
                    }
                    else m=start;
                    break;
                }
                else if (node.getName().compareTo(this.nodes.get(m).getName()) > 0)
                    start = m;
                else if (node.getName().compareTo(this.nodes.get(m-1).getName()) < 0)
                    stop = m-1;
                else break;
            }
            for (int i=this.nrOfNodes; i>m; i--)
            {
                this.nodes.add(i,this.nodes.get(i-1));
            }
            this.nodes.add(m,node);
            nrOfNodes++;
        }
    }

    public void addEdge(Edge edge)
    {
        this.edges.add(edge);
//        this.edges[nrOfEdges] = edge;
        nrOfEdges++;
    }

    public void addEdge(Node n1, Node n2, int weight)
    {
        this.edges.add(nrOfEdges, new Edge(n1, n2, weight));
        nrOfEdges++;
    }

    public void addEdge(Node n1, Node n2, int weight, boolean twoWay)
    {
        this.edges.add(nrOfEdges,new Edge(n1, n2, weight, twoWay));
        nrOfEdges++;
    }

    public String getNodes()
    {
        String nodes = new String(this.nodes.get(0).getName());
        for (int i=1; i<this.nrOfNodes-1; i++)
        {
            nodes += ", " + this.nodes.get(i).getName();
        }
        if (nrOfNodes != 1)
            nodes += ", " + this.nodes.get(this.nrOfNodes-1).getName();
        return nodes;
    }

}
